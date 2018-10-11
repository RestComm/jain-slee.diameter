/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2018, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */

package org.mobicents.slee.resource.diameter.slg;

import java.io.IOException;

import net.java.slee.resource.diameter.base.events.avp.AvpNotAllowedException;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

import net.java.slee.resource.diameter.slg.SLgAVPFactory;
import net.java.slee.resource.diameter.slg.SLgMessageFactory;
import net.java.slee.resource.diameter.slg.SLgServerSessionActivity;
import net.java.slee.resource.diameter.slg.events.ProvideLocationRequest;
import net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer;
import net.java.slee.resource.diameter.slg.events.LocationReportRequest;

import org.jdiameter.api.Answer;
import org.jdiameter.api.EventListener;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.Request;
import org.jdiameter.api.Stack;
import org.jdiameter.api.app.AppSession;

import org.jdiameter.api.slg.ServerSLgSession;
import org.jdiameter.common.api.app.slg.SLgSessionState;
import org.jdiameter.common.impl.app.slg.LocationReportRequestImpl;
import org.jdiameter.common.impl.app.slg.ProvideLocationAnswerImpl;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;

/**
 * Implementation of {@link SLgServerSessionActivity}.
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class SLgServerSessionActivityImpl extends SLgSessionActivityImpl implements SLgServerSessionActivity {

  private static final long serialVersionUID = 7518916596996009148L;

  protected transient ServerSLgSession serverSLgSession;

  public SLgServerSessionActivityImpl(SLgMessageFactory slgMessageFactory, SLgAVPFactory slgAvpFactory, ServerSLgSession session, EventListener<Request, Answer> raEventListener, DiameterIdentity destinationHost, DiameterIdentity destinationRealm, Stack stack) {
    super(slgMessageFactory, slgAvpFactory, session.getSessions().get(0), raEventListener, destinationHost, destinationRealm);
    // FIXME: remove stack?

    setSession(session);
    super.setCurrentWorkingSession(session.getSessions().get(0));
  }

  public void setSession(ServerSLgSession session) {
    this.serverSLgSession = session;
    this.serverSLgSession.addStateChangeNotification(this);
  }

  public void stateChanged(Enum oldState, Enum newState) {
    if (!terminated) {
      if (newState == SLgSessionState.TERMINATED || newState == SLgSessionState.TIMEDOUT) {
        terminated = true;
        endActivity();
      }
    }
  }

  /*
   * (non-Javadoc)
   * @see org.jdiameter.api.app.StateChangeListener#stateChanged(java.lang.Object, java.lang.Enum, java.lang.Enum)
   */
  public void stateChanged(AppSession appSession, Enum oldState, Enum newState) {
    this.stateChanged(oldState, newState);

  }

  @Override
  public void endActivity() {
    if (this.serverSLgSession != null) {
      this.serverSLgSession.release();
    }

    try {
      // endpoint.endActivity(this.getActivityHandle());
      super.baseListener.endActivity(this.getActivityHandle());
    } catch (Exception e) {
      logger.error("Failed to end activity [" + this + "].", e);
    }
  }

  public ProvideLocationAnswer createProvideLocationAnswer() {
    // Make sure we have the correct type of Request
    if (!(lastRequest instanceof ProvideLocationRequest)) {
      logger.warn("Invalid type of answer for this activity.");
      return null;
    }

    try {
      // Create the answer
      ProvideLocationAnswer pla = (ProvideLocationAnswer) this.slgMessageFactory.createSLgMessage(lastRequest.getHeader(), new DiameterAvp[]{}, ProvideLocationAnswer.COMMAND_CODE, slgMessageFactory.getApplicationId());

      // Fill session related AVPs, if present
      fillSessionAVPs(pla);

      return pla;
    } catch (InternalException e) {
      logger.error("Failed to create Provide-Location-Answer.", e);
    }

    return null;
  }

  public void sendProvideLocationAnswer(ProvideLocationAnswer pla) throws IOException {
    DiameterMessageImpl msg = (DiameterMessageImpl) pla;
    ProvideLocationAnswerImpl provideLocationAnswer = new ProvideLocationAnswerImpl((Answer) msg.getGenericData());
    try {
      serverSLgSession.sendProvideLocationAnswer(provideLocationAnswer);
    } catch (org.jdiameter.api.validation.AvpNotAllowedException anae) {
      throw new AvpNotAllowedException(anae.getMessage(), anae.getAvpCode(), anae.getVendorId());
    } catch (Exception e) {
      if (logger.isDebugEnabled()) {
        logger.debug("Failed to send message.", e);
      }
      throw new IOException(e.getMessage());
    }
  }

  public LocationReportRequest createLocationReportRequest() {
    // Make sure we have the correct type of Request
    if (!(lastRequest instanceof LocationReportRequest)) {
      logger.warn("Invalid type of answer for this activity.");
      return null;
    }

    try {
      // Create the request
      LocationReportRequest lrr = (LocationReportRequest) this.slgMessageFactory.createSLgMessage(lastRequest.getHeader(), new DiameterAvp[]{}, LocationReportRequest.COMMAND_CODE, slgMessageFactory.getApplicationId());

      // Fill session related AVPs, if present
      fillSessionAVPs(lrr);

      return lrr;
    } catch (InternalException e) {
      logger.error("Failed to create Location-Report-Answer.", e);
    }

    return null;
  }

  public void sendLocationReportRequest(LocationReportRequest lrr) throws IOException {
    DiameterMessageImpl msg = (DiameterMessageImpl) lrr;
    LocationReportRequestImpl locationReportRequest = new LocationReportRequestImpl((Answer) msg.getGenericData());
    try {
      serverSLgSession.sendLocationReportRequest(locationReportRequest);
    } catch (org.jdiameter.api.validation.AvpNotAllowedException anae) {
      throw new AvpNotAllowedException(anae.getMessage(), anae.getAvpCode(), anae.getVendorId());
    } catch (Exception e) {
      if (logger.isDebugEnabled()) {
        logger.debug("Failed to send message.", e);
      }
      throw new IOException(e.getMessage());
    }
  }

}

