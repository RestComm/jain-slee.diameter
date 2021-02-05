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

import net.java.slee.resource.diameter.base.events.DiameterHeader;
import net.java.slee.resource.diameter.base.events.avp.AvpNotAllowedException;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

import net.java.slee.resource.diameter.slg.SLgAVPFactory;
import net.java.slee.resource.diameter.slg.SLgMessageFactory;
import net.java.slee.resource.diameter.slg.SLgClientSessionActivity;
import net.java.slee.resource.diameter.slg.events.LocationReportRequest;
import net.java.slee.resource.diameter.slg.events.ProvideLocationRequest;
import net.java.slee.resource.diameter.slg.events.LocationReportAnswer;

import org.jdiameter.api.Answer;
import org.jdiameter.api.EventListener;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.Request;
import org.jdiameter.api.Stack;
import org.jdiameter.api.app.AppSession;


import org.jdiameter.api.slg.ClientSLgSession;
import org.jdiameter.common.api.app.slg.SLgSessionState;
import org.jdiameter.common.impl.app.slg.LocationReportAnswerImpl;
import org.jdiameter.common.impl.app.slg.ProvideLocationRequestImpl;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;

/**
 * Implementation of {@link SLgClientSessionActivity}.
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class SLgClientSessionActivityImpl extends org.mobicents.slee.resource.diameter.slg.SLgSessionActivityImpl implements SLgClientSessionActivity {

  private static final long serialVersionUID = 7518916596996009148L;
  protected transient ClientSLgSession clientSLgSession;

  public SLgClientSessionActivityImpl(SLgMessageFactory slgMessageFactory, SLgAVPFactory slgAvpFactory, ClientSLgSession session, EventListener<Request, Answer> raEventListener, DiameterIdentity destinationHost, DiameterIdentity destinationRealm, Stack stack) {
    super(slgMessageFactory, slgAvpFactory, session.getSessions().get(0), raEventListener, destinationHost, destinationRealm);
    // FIXME: remove stack?
    setSession(session);
    super.setCurrentWorkingSession(session.getSessions().get(0));
  }

  public void setSession(ClientSLgSession session) {
    this.clientSLgSession = session;
    this.clientSLgSession.addStateChangeNotification(this);
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
    if (this.clientSLgSession != null) {
      this.clientSLgSession.release();
    }

    try {
      // endpoint.endActivity(this.getActivityHandle());
      super.baseListener.endActivity(this.getActivityHandle());
    } catch (Exception e) {
      logger.error("Failed to end activity [" + this +
              "], baseListener [" + super.baseListener + "], activityHandle [" + this.getActivityHandle() + "].", e);
    }
  }

  public ProvideLocationRequest createProvideLocationRequest() {

    ProvideLocationRequest plr = super.getSLgMessageFactory().createProvideLocationRequest(super.getSessionId());

      // If there's a Destination-Host, add the AVP
      if (destinationHost != null) {
        plr.setDestinationHost(destinationHost);
      }

      if (destinationRealm != null) {
        plr.setDestinationRealm(destinationRealm);
      }

      return plr;

  }

  public ProvideLocationRequest createProvideLocationRequest(String sessionId) throws IllegalArgumentException {
    ProvideLocationRequest ecr = createProvideLocationRequest();
    ecr.setSessionId(sessionId);
    return ecr;
  }


  public void sendProvideLocationRequest(ProvideLocationRequest plr) throws IOException {
    DiameterMessageImpl msg = (DiameterMessageImpl) plr;
    ProvideLocationRequestImpl provideLocationRequest = new ProvideLocationRequestImpl((Request) msg.getGenericData());
    try {
      clientSLgSession.sendProvideLocationRequest(provideLocationRequest);
    } catch (org.jdiameter.api.validation.AvpNotAllowedException anae) {
      throw new AvpNotAllowedException(anae.getMessage(), anae.getAvpCode(), anae.getVendorId());
    } catch (Exception e) {
      if (logger.isDebugEnabled()) {
        logger.debug("Failed to send message.", e);
      }
      throw new IOException(e.getMessage());
    }
  }


  public LocationReportAnswer createLocationReportAnswer() {
    // Make sure we have the correct type of Request
    if (!(lastRequest instanceof LocationReportRequest)) {
      logger.warn("Invalid type of answer for this activity.");
      return null;
    }

    try {
      //Create the answer
      LocationReportAnswer lra = (LocationReportAnswer) this.slgMessageFactory.createSLgMessage(lastRequest.getHeader(), new DiameterAvp[]{}, LocationReportAnswer.COMMAND_CODE, slgMessageFactory.getApplicationId());

      // Fill session related AVPs, if present
      fillSessionAVPs(lra);

      return lra;
    } catch (InternalException e) {
      logger.error("Failed to create Provide-Location-Answer.", e);
    }

    return null;
  }

  public LocationReportAnswer createLocationReportAnswer(DiameterHeader header) {
    try {
      //Create the answer
      LocationReportAnswer lra = (LocationReportAnswer) this.slgMessageFactory.createSLgMessage(header,
          new DiameterAvp[]{}, LocationReportAnswer.COMMAND_CODE, slgMessageFactory.getApplicationId());

      // Fill session related AVPs, if present
      fillSessionAVPs(lra);

      return lra;
    } catch (InternalException e) {
      logger.error("Failed to create Provide-Location-Answer.", e);
    }

    return null;
  }

  public void sendLocationReportAnswer(LocationReportAnswer lra) throws IOException {
    DiameterMessageImpl msg = (DiameterMessageImpl) lra;
    LocationReportAnswerImpl request = new LocationReportAnswerImpl((Answer) msg.getGenericData());
    try {
      clientSLgSession.sendLocationReportAnswer(request);
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

