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

import net.java.slee.resource.diameter.base.DiameterException;
import net.java.slee.resource.diameter.base.events.ReAuthAnswer;
import net.java.slee.resource.diameter.base.events.avp.AvpNotAllowedException;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slh.events.avp.*;
import net.java.slee.resource.diameter.slh.SLhAvpFactory;
import net.java.slee.resource.diameter.slh.SLhClientSessionActivity;
import net.java.slee.resource.diameter.slh.SLhMessageFactory;
import net.java.slee.resource.diameter.slh.SLhSessionState;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;

import org.jdiameter.api.Answer;
import org.jdiameter.api.EventListener;
import org.jdiameter.api.Request;
import org.jdiameter.api.Stack;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.app.StateChangeListener;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
// import org.jdiameter.api.slh.ClientSLhSession;
// import org.jdiameter.common.api.app.slh.ClientSLhSessionState;
// import org.jdiameter.common.impl.app.slh.LCSRoutingInfoRequestImpl;

/**
 * Implementation of {@link SLhClientSessionActivity}.
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class SLhClientSessionActivityImpl {
}


//public class SLhClientSessionActivityImpl extends SLhSessionActivityImpl implements SLhClientSessionActivity, StateChangeListener<AppSession> {
//
//  private static final long serialVersionUID = 6391181777305378777L;
//
//  protected transient ClientSLhSession session;
//
//  /**
//   *
//   * @param slhMessageFactory
//   * @param slhAvpFactory
//   * @param session
//   * @param destinationHost
//   * @param destinationRealm
//   * // @param endpoint
//   * @param stack
//   */
//  public SLhClientSessionActivityImpl(SLhMessageFactory slhMessageFactory, SLhAvpFactory slhAvpFactory, ClientSLhSession session, DiameterIdentity destinationHost,
//                                      DiameterIdentity destinationRealm, Stack stack) {
//    super(slhMessageFactory, slhAvpFactory, null, (EventListener<Request, Answer>) session, destinationRealm, destinationRealm);
//
//    setSession(session);
//    super.setCurrentWorkingSession(session.getSessions().get(0));
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slh.SLhClientSessionActivity#createSLhCreditControlRequest(net.java.slee.resource.diameter.slh.events.avp.CcRequestType)
//   */
//  public LCSRoutingInfoRequest createLCSRoutingInfoRequest(CcRequestType type) {
//    // Create the request
//    LCSRoutingInfoRequest request = super.getSLhMessageFactory().createLCSRoutingInfoRequest(super.getSessionId()/*,type*/);
//    request.setCcRequestType(type);
//
//    // If there's a Destination-Host, add the AVP
//    if (destinationHost != null) {
//      request.setDestinationHost(destinationHost);
//    }
//
//    if (destinationRealm != null) {
//      request.setDestinationRealm(destinationRealm);
//    }
//
//    return request;
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slh.SLhClientSessionActivity#sendEventLCSRoutingInfoRequest(net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest)
//   */
//  public void sendEventLCSRoutingInfoRequest(LCSRoutingInfoRequest rir) throws IOException {
//    // fetchCurrentState(rir);
//
//    DiameterMessageImpl msg = (DiameterMessageImpl) rir;
//    validateState(rir);
//    try {
//      session.sendLCSRoutingInfoRequest(new LCSRoutingInfoRequestImpl((Request) msg.getGenericData()));
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException e) {
//      throw new AvpNotAllowedException("Message validation failed.", e, e.getAvpCode(), e.getVendorId());
//    }
//    catch (Exception e) {
//      if(logger.isDebugEnabled()) {
//        logger.debug("Failed to send message.", e);
//      }
//      throw new IOException("Failed to send message, due to: " + e);
//    }
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slh.SLhClientSessionActivity#sendInitialSLhCreditControlRequest(net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest)
//   */
//  public void sendInitialLCSRoutingInfoRequest(LCSRoutingInfoRequest rir) throws IOException {
//    // FIXME: should this affect FSM ?
//
//    validateState(rir);
//
//    DiameterMessageImpl msg = (DiameterMessageImpl) rir;
//
//    try {
//      session.sendLCSRoutingInfoRequest(new LCSRoutingInfoRequestImpl((Request) msg.getGenericData()));
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException e) {
//      throw new AvpNotAllowedException("Message validation failed.", e, e.getAvpCode(), e.getVendorId());
//    }
//    catch (Exception e) {
//      throw new IOException("Failed to send message, due to: " + e);
//    }
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slh.SLhClientSessionActivity#sendUpdateLCSRoutingInfoRequest(net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest)
//   */
//  public void sendUpdateLCSRoutingInfoRequest(LCSRoutingInfoRequest rir) throws IOException {
//    validateState(rir);
//
//    DiameterMessageImpl msg = (DiameterMessageImpl) rir;
//
//    try {
//      session.sendLCSRoutingInfoRequest(new LCSRoutingInfoRequestImpl((Request) msg.getGenericData()));
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException e) {
//      throw new AvpNotAllowedException("Message validation failed.", e, e.getAvpCode(), e.getVendorId());
//    }
//    catch (Exception e) {
//      throw new IOException("Failed to send message, due to: " + e);
//    }
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slh.SLhClientSessionActivity#sendTerminationLCSRoutingInfoRequest(net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest)
//   */
//  public void sendTerminationLCSRoutingInfoRequest(LCSRoutingInfoRequest rir) throws IOException {
//    // This should not be used to terminate sub-sessions!
//
//    validateState(rir);
//
//    DiameterMessageImpl msg = (DiameterMessageImpl) rir;
//
//    try {
//      session.sendLCSRoutingInfoRequest(new LCSRoutingInfoRequestImpl((Request) msg.getGenericData()));
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException e) {
//      throw new AvpNotAllowedException("Message validation failed.", e, e.getAvpCode(), e.getVendorId());
//    }
//    catch (Exception e) {
//      throw new IOException("Failed to send message, due to: " + e);
//    }
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slh.SLhClientSessionActivity#sendReAuthAnswer(net.java.slee.resource.diameter.base.events.ReAuthAnswer)
//   */
//  public void sendReAuthAnswer(ReAuthAnswer rar) throws IOException {
//    DiameterMessageImpl msg = (DiameterMessageImpl) rar;
//
//    try {
//      session.sendReAuthAnswer(new ReAuthAnswerImpl((Answer) msg.getGenericData()));
//    }
//    catch (org.jdiameter.api.validation.AvpNotAllowedException e) {
//      throw new AvpNotAllowedException("Message validation failed.", e, e.getAvpCode(), e.getVendorId());
//    }
//    catch (Exception e) {
//      throw new IOException("Failed to send message, due to: " + e);
//    }
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see org.jdiameter.api.app.StateChangeListener#stateChanged(java.lang.Object, java.lang.Enum, java.lang.Enum)
//   */
//  public void stateChanged(AppSession arg0, Enum oldState, Enum newState) {
//    this.stateChanged(oldState, newState);
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see org.jdiameter.api.app.StateChangeListener#stateChanged(java.lang.Enum, java.lang.Enum)
//   */
//  public void stateChanged(Enum oldState, Enum newState) {
//    ClientSLhSessionState s = (ClientSLhSessionState) newState;
//
//    // IDLE(0), PENDING_EVENT(1), PENDING_INITIAL(2), PENDING_UPDATE(3),
//    // PENDING_TERMINATION(4), PENDING_BUFFERED(5), OPEN(6);
//    switch (s) {
//      case PENDING_EVENT:
//        //this.state = CreditControlSessionState.PENDING_EVENT;
//        break;
//    /*case PENDING_BUFFERED:
//      //this.state = CreditControlSessionState.PENDING_BUFFERED;
//      break;
//    case PENDING_TERMINATION:
//      //this.state = CreditControlSessionState.PENDING_TERMINATION;
//      break;
//    case PENDING_UPDATE:
//      //this.state = CreditControlSessionState.PENDING_UPDATE;
//      break;
//    case OPEN:
//      // FIXME: this should not happen?
//      //this.state = CreditControlSessionState.OPEN;
//      break;
//    case PENDING_INITIAL:
//      //this.state = CreditControlSessionState.PENDING_INITIAL;
//      break;
//    case IDLE:
//      //this.state = CreditControlSessionState.IDLE;*/
//      this.setTerminateAfterProcessing(true);
//      super.baseListener.startActivityRemoveTimer(getActivityHandle());
//      break;
//
//      default:
//        logger.error("Unexpected state in LCS Routing-Info Client FSM: " + s);
//    }
//  }
//
//  private void validateState(LCSRoutingInfoRequest rir) {
//    //this is used for methods that send specific messages. should be done in jdiam, but there is not hook for it now.
//    if(rir.getCcRequestType() == null) {
//      throw new DiameterException("No request type is present!!");
//    }
//    int t = rir.getCcRequestType().getValue();
//
//    SLhSessionState currentState = this.getState();
//    if(t == CcRequestType._INITIAL_REQUEST) {
//      if(currentState!=SLhSessionState.IDLE) {
//        //FIXME: change all exception to DiameterException
//        throw new DiameterException("Failed to validate, intial event, wrong state: "+currentState);
//      }
//    }
//    else if(t == CcRequestType._UPDATE_REQUEST) {
//      if(currentState!=SLhSessionState.OPEN) {
//        //FIXME: change all exception to DiameterException
//        throw new DiameterException("Failed to validate, intial event, wrong state: "+currentState);
//      }
//    }
//    else if(t == CcRequestType._TERMINATION_REQUEST) {
//      if(currentState!=SLhSessionState.OPEN) {
//        //FIXME: change all exception to DiameterException
//        throw new DiameterException("Failed to validate, intial event, wrong state: "+currentState);
//      }
//    }
//    else if(t == CcRequestType._EVENT_REQUEST) {
//      if(currentState!=SLhSessionState.IDLE) {
//        //FIXME: change all exception to DiameterException
//        throw new DiameterException("Failed to validate, intial event, wrong state: "+currentState);
//      }
//    }
//  }
//
//  public void setSession(ClientSLhSession session2) {
//    this.session = session2;
//    this.session.addStateChangeNotification(this);
//  }
//
//  public SLhSessionState getState() {
//    ClientSLhSessionState s = this.session.getState(ClientSLhSessionState.class);
//
//    // IDLE(0), PENDING_EVENT(1), PENDING_INITIAL(2), PENDING_UPDATE(3),
//    // PENDING_TERMINATION(4), PENDING_BUFFERED(5), OPEN(6);
//    switch (s) {
//      case PENDING_EVENT:
//        return SLhSessionState.PENDING_EVENT;
//      case PENDING_BUFFERED:
//        return SLhSessionState.PENDING_BUFFERED;
//      case PENDING_TERMINATION:
//        return SLhSessionState.PENDING_TERMINATION;
//      case PENDING_UPDATE:
//        return SLhSessionState.PENDING_UPDATE;
//      case OPEN:
//        return SLhSessionState.OPEN;
//      case PENDING_INITIAL:
//        return SLhSessionState.PENDING_INITIAL;
//      case IDLE:
//        return SLhSessionState.IDLE;
//      default:
//        logger.error("Unexpected state in LCS Routin-Info Client FSM: " + s);
//        return null;
//    }
//  }
//
//  @Override
//  public int hashCode() {
//    final int prime = 31;
//    int result = super.hashCode();
//    result = prime * result + (isTerminateAfterProcessing() ? 1231 : 1237);
//    return result;
//  }
//
//  @Override
//  public boolean equals(Object obj) {
//    if (this == obj) {
//      return true;
//    }
//    if (!super.equals(obj)) {
//      return false;
//    }
//    if (getClass() != obj.getClass()) {
//      return false;
//    }
//    SLhClientSessionActivityImpl other = (SLhClientSessionActivityImpl) obj;
//    if (terminateAfterProcessing != other.isTerminateAfterProcessing()) {
//      return false;
//    }
//
//    return true;
//  }
//
//  @Override
//  public void endActivity() {
//    this.session.release();
//    super.endActivity();
//  }
//
//}



