/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
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
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.diameter.slh;

import java.io.IOException;

import net.java.slee.resource.diameter.base.events.avp.AvpNotAllowedException;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

import net.java.slee.resource.diameter.slh.SLhMessageFactory;
import net.java.slee.resource.diameter.slh.SLhServerSessionActivity;
import net.java.slee.resource.diameter.slh.SLhSessionState;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;

import org.jdiameter.api.Answer;
import org.jdiameter.api.EventListener;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.Request;
import org.jdiameter.api.Stack;
import org.jdiameter.api.app.AppSession;

//import org.jdiameter.api.slh.ServerSLhSession;
//import org.jdiameter.common.api.app.slh.ServerSLhSessionState;
//import org.jdiameter.common.impl.app.slh.LCSRoutingInfoAnswerImpl;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;

/**
 * Implementation of {@link SLhServerSessionActivity}.
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class SLhServerSessionActivityImpl {}

//public class SLhServerSessionActivityImpl extends SLhSessionActivityImpl implements SLhServerSessionActivity {
//
//  private static final long serialVersionUID = 7518916596996009148L;
//
//  protected transient ServerSLhSession appSession;
//
//  public SLhServerSessionImpl(SLhMessageFactory slhMessageFactory, SLhAVPFactory slhAvpFactory, ServerSLhSession session, EventListener<Request, Answer> raEventListener, DiameterIdentity destinationHost, DiameterIdentity destinationRealm, Stack stack) {
//    super(slhMessageFactory, slhAvpFactory, session.getSessions().get(0), raEventListener, destinationHost, destinationRealm);
//    // FIXME: remove stack?
//
//    setSession(session);
//    super.setCurrentWorkingSession(session.getSessions().get(0));
//  }
//
//  public void setSession(ServerSLhSession session) {
//    this.appSession = session;
//    this.appSession.addStateChangeNotification(this);
//  }
//
//  public void stateChanged(Enum oldState, Enum newState) {
//    if (!terminated) {
//      if (newState == SLhSessionState.TERMINATED || newState == SLhSessionState.TIMEDOUT) {
//        terminated = true;
//        endActivity();
//      }
//    }
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see org.jdiameter.api.app.StateChangeListener#stateChanged(java.lang.Object, java.lang.Enum, java.lang.Enum)
//   */
//  public void stateChanged(AppSession appSession, Enum oldState, Enum newState) {
//    this.stateChanged(oldState, newState);
//
//  }
//
//  @Override
//  public void endActivity() {
//    if (this.appSession != null) {
//      this.appSession.release();
//    }
//
//    try {
//      // endpoint.endActivity(this.getActivityHandle());
//      super.baseListener.endActivity(this.getActivityHandle());
//    }
//    catch (Exception e) {
//      logger.error("Failed to end activity [" + this + "].", e);
//    }
//  }
//
//  public LCSRoutingInfoAnswer createLCSRoutingInfoAnswer() {
//    // Make sure we have the correct type of Request
//    if (!(lastRequest instanceof LCSRoutingInfoRequest)) {
//      logger.warn("Invalid type of answer for this activity.");
//      return null;
//    }
//
//    try {
//      // Create the answer
//      LCSRoutingInfoAnswer ria = (LCSRoutingInfoAnswer) this.slhMessageFactory.createSLhMessage(lastRequest.getHeader(), new DiameterAvp[]{}, LCSRoutingInfoAnswer.COMMAND_CODE, slhMessageFactory.getApplicationId());
//
//      // Fill session related AVPs, if present
//      fillSessionAVPs(ria);
//
//      return ria;
//    }
//    catch (InternalException e) {
//      logger.error("Failed to create LCS Routing-Info-Answer.", e);
//    }
//
//    return null;
//  }
//
//  public void sendLCSRoutingInfoAnswer(LCSRoutingInfoAnswer ria) throws IOException {
//    DiameterMessageImpl msg = (DiameterMessageImpl) ria;
//    LCSRoutingInfoAnswerImpl answer = new LCSRoutingInfoAnswerImpl((Answer) msg.getGenericData());
//    try {
//      appSession.sendLCSRoutingInfoAnswer(answer);
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException anae) {
//      throw new AvpNotAllowedException(anae.getMessage(), anae.getAvpCode(), anae.getVendorId());
//    }
//    catch (Exception e) {
//      if (logger.isDebugEnabled()) {
//        logger.debug("Failed to send message.", e);
//      }
//      throw new IOException(e.getMessage());
//    }
//  }
//
//}
