/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.diameter.s13;

import java.io.IOException;

import net.java.slee.resource.diameter.base.events.avp.AvpNotAllowedException;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.s13.S13AVPFactory;
import net.java.slee.resource.diameter.s13.S13ClientSessionActivity;
import net.java.slee.resource.diameter.s13.S13MessageFactory;
import net.java.slee.resource.diameter.s13.events.MEIdentityCheckRequest;
import net.java.slee.resource.diameter.s13.events.MEIdentityCheckAnswer;

import org.jdiameter.api.Answer;
import org.jdiameter.api.EventListener;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.Request;
import org.jdiameter.api.Stack;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.s13.ClientS13Session;
import org.jdiameter.common.api.app.s13.S13SessionState;
import org.jdiameter.common.impl.app.s13.JMEIdentityCheckRequestImpl;
import org.jdiameter.common.impl.app.s13.JMEIdentityCheckAnswerImpl;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;

/**
 * 
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class S13ClientSessionImpl extends S13SessionImpl implements S13ClientSessionActivity {

  private static final long serialVersionUID = 7518916596996009148L;
  protected transient ClientS13Session appSession;

  public S13ClientSessionImpl(S13MessageFactory s13MessageFactory, S13AVPFactory s13AvpFactory, ClientS13Session session, EventListener<Request, Answer> raEventListener, DiameterIdentity destinationHost, DiameterIdentity destinationRealm, Stack stack) {
    super(s13MessageFactory, s13AvpFactory, session.getSessions().get(0), raEventListener, destinationHost, destinationRealm);
    // FIXME: remove stack?

    setSession(session);
    super.setCurrentWorkingSession(session.getSessions().get(0));
  }

  public void setSession(ClientS13Session session) {
    this.appSession = session;
    this.appSession.addStateChangeNotification(this);
  }

  public void stateChanged(Enum oldState, Enum newState) {
    if (!terminated) {
      if (newState == S13SessionState.TERMINATED || newState == S13SessionState.TIMEDOUT) {
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
    if (this.appSession != null) {
      this.appSession.release();
    }

    try {
      // endpoint.endActivity(this.getActivityHandle());
      super.baseListener.endActivity(this.getActivityHandle());
    }
    catch (Exception e) {
      logger.error("Failed to end activity [" + this + "].", e);
    }
  }

  public void sendMEIdentityCheckRequest(MEIdentityCheckRequest ecr) throws IOException {
    DiameterMessageImpl msg = (DiameterMessageImpl) ecr;
    JMEIdentityCheckRequestImpl request = new JMEIdentityCheckRequestImpl((Request) msg.getGenericData());
    try {
      appSession.sendMEIdentityCheckRequest(request);
    }
    catch (org.jdiameter.api.validation.AvpNotAllowedException anae) {
      throw new AvpNotAllowedException(anae.getMessage(), anae.getAvpCode(), anae.getVendorId());
    }
    catch (Exception e) {
      if (logger.isDebugEnabled()) {
        logger.debug("Failed to send message.", e);
      }
      throw new IOException(e.getMessage());
    }
  }
}
