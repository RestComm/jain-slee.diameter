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

package org.mobicents.slee.resource.diameter.slh;

import java.io.IOException;

import net.java.slee.resource.diameter.base.events.avp.AvpNotAllowedException;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slh.SLhAVPFactory;
import net.java.slee.resource.diameter.slh.SLhClientSessionActivity;
import net.java.slee.resource.diameter.slh.SLhMessageFactory;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;

import org.jdiameter.api.*;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.slh.ClientSLhSession;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.jdiameter.common.impl.app.slh.LCSRoutingInfoRequestImpl;

/**
 * Implementation of {@link SLhClientSessionActivity}.
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class SLhClientSessionActivityImpl extends SLhSessionActivityImpl implements SLhClientSessionActivity {

  private static final long serialVersionUID = 6391181777305378777L;

  protected transient ClientSLhSession clientSLhSession;

  /**
   * @param slhMessageFactory
   * @param slhAvpFactory
   * @param session
   * @param destinationHost
   * @param destinationRealm
   * @param stack
   */
  public SLhClientSessionActivityImpl(SLhMessageFactory slhMessageFactory, SLhAVPFactory slhAvpFactory, ClientSLhSession session, EventListener<Request, Answer> raEventListener, DiameterIdentity destinationHost,
                                      DiameterIdentity destinationRealm, Stack stack) {
    super(slhMessageFactory, slhAvpFactory, null, (EventListener<Request, Answer>) session, destinationHost, destinationRealm);
    // FIXME: remove stack?

    setSession(session);
    super.setCurrentWorkingSession(session.getSessions().get(0));
  }

  public void setSession(ClientSLhSession clientSLhSession) {
    this.clientSLhSession = clientSLhSession;
    this.clientSLhSession.addStateChangeNotification(this);
  }

  /*
   * (non-Javadoc)
   * @see org.jdiameter.api.app.StateChangeListener#stateChanged(java.lang.Enum, java.lang.Enum)
   */
  public void stateChanged(Enum oldState, Enum newState) {
    if (!terminated) {
      if (newState == org.jdiameter.common.api.app.slh.SLhSessionState.TERMINATED || newState == org.jdiameter.common.api.app.slh.SLhSessionState.TIMEDOUT) {
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
    this.clientSLhSession.release();
    super.endActivity();
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.SLhClientSessionActivity#screateEventLCSRoutingInfoRequest()
   */
  public LCSRoutingInfoRequest createLCSRoutingInfoRequest() {

      LCSRoutingInfoRequest rir = super.getSLhMessageFactory().createLCSRoutingInfoRequest(super.getSessionId());

      // If there's a Destination-Host, add the AVP
      if (destinationHost != null) {
        rir.setDestinationHost(destinationHost);
      }

      if (destinationRealm != null) {
        rir.setDestinationRealm(destinationRealm);
      }

      return rir;

  }


  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.SLhClientSessionActivity#sendEventLCSRoutingInfoRequest(net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest)
   */
  public void sendLCSRoutingInfoRequest(LCSRoutingInfoRequest rir) throws IOException {

    DiameterMessageImpl msg = (DiameterMessageImpl) rir;
    try {
      clientSLhSession.sendLCSRoutingInfoRequest(new LCSRoutingInfoRequestImpl((Request) msg.getGenericData()));
    } catch (org.jdiameter.api.validation.AvpNotAllowedException e) {
      throw new AvpNotAllowedException("Message validation failed.", e, e.getAvpCode(), e.getVendorId());
    } catch (Exception e) {
      throw new IOException("Failed to send message, due to: " + e);
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (isTerminateAfterProcessing() ? 1231 : 1237);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    SLhClientSessionActivityImpl other = (SLhClientSessionActivityImpl) obj;
    if (terminateAfterProcessing != other.isTerminateAfterProcessing()) {
      return false;
    }

    return true;
  }

}
