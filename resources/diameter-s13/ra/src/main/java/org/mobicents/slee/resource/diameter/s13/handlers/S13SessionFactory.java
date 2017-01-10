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

package org.mobicents.slee.resource.diameter.s13.handlers;

import org.apache.log4j.Logger;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.IllegalDiameterStateException;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.Message;
import org.jdiameter.api.OverloadException;
import org.jdiameter.api.RouteException;
import org.jdiameter.api.SessionFactory;
import org.jdiameter.api.app.AppAnswerEvent;
import org.jdiameter.api.app.AppRequestEvent;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.s13.ClientS13Session;
import org.jdiameter.api.s13.ServerS13Session;
import org.jdiameter.api.s13.events.JMEIdentityCheckRequest;
import org.jdiameter.api.s13.events.JMEIdentityCheckAnswer;
import org.jdiameter.client.impl.app.s13.S13ClientSessionImpl;
import org.jdiameter.common.impl.app.s13.S13SessionFactoryImpl;
import org.jdiameter.server.impl.app.s13.S13ServerSessionImpl;
import org.mobicents.slee.resource.diameter.base.handlers.DiameterRAInterface;

/**
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class S13SessionFactory extends S13SessionFactoryImpl {

  private DiameterRAInterface s13ResourceAdaptor;
  private static final Logger logger = Logger.getLogger(S13SessionFactory.class);

  public S13SessionFactory(DiameterRAInterface s13ResourceAdaptor, long messageTimeout, SessionFactory sessionFactory) {
    super(sessionFactory);
    this.s13ResourceAdaptor = s13ResourceAdaptor;
  }

  /* (non-Javadoc)
   * @see org.jdiameter.common.api.app.IAppSessionFactory#getNewSession(java.lang.String, java.lang.Class, org.jdiameter.api.ApplicationId, java.lang.Object[])
   */
  @Override
  public AppSession getNewSession(String sessionId, Class<? extends AppSession> appSessionClass, ApplicationId applicationId, Object[] args) {
    AppSession appSession = null;

    if(appSessionClass == ServerS13Session.class) {
      S13ServerSessionImpl serverSession = null;
      serverSession = (S13ServerSessionImpl) super.getNewSession(sessionId, appSessionClass, applicationId, args);
      appSession = serverSession;
    }
    else if(appSessionClass == ClientS13Session.class){
      S13ClientSessionImpl clientSession = null;
      clientSession = (S13ClientSessionImpl) super.getNewSession(sessionId, appSessionClass, applicationId, args);
      appSession = clientSession;
    }
    else {
      throw new IllegalArgumentException("Wrong session class: [" + appSessionClass + "]. Supported[" + ServerS13Session.class + "," + ClientS13Session.class + "]");
    }

    return appSession;
  }

  /* (non-Javadoc)
   * @see org.jdiameter.api.s13.Servers13SessionListener#doOtherEvent(org.jdiameter.api.app.AppSession, org.jdiameter.api.app.AppRequestEvent, org.jdiameter.api.app.AppAnswerEvent)
   */
  @Override
  public void doOtherEvent(AppSession appSession, AppRequestEvent request, AppAnswerEvent answer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    logger.info("Diameter S13 Session Factory :: doOtherEvent :: appSession[" + appSession + "], Request[" + request + "]");

    doFireEvent(appSession, answer != null ? answer.getMessage() : request.getMessage());
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.jdiameter.common.impl.app.sh.ShSessionFactoryImpl#stateChanged(org
   * .jdiameter.api.app.AppSession, java.lang.Enum, java.lang.Enum)
   */
  @Override
  public void stateChanged(AppSession source, Enum oldState, Enum newState) {
    //s13ResourceAdaptor.stateChanged(source, oldState, newState);
    logger.info("Diameter S13 Session Factory :: stateChanged :: source[" + source + "] :: oldState[" + oldState + "], newState[" + newState + "]");
  }

  /* (non-Javadoc)
   * @see org.jdiameter.api.app.StateChangeListener#stateChanged(java.lang.Enum, java.lang.Enum)
   */
  @Override
  public void stateChanged(Enum oldState, Enum newState) {
    logger.info("Diameter S13 Session Factory :: stateChanged :: oldState[" + oldState + "], newState[" + newState + "]");
  }

  /* (non-Javadoc)
   * @see org.jdiameter.common.api.app.s13.Is13MessageFactory#getApplicationId()
   */
  @Override
  public long getApplicationId() {
    // FIXME: Not needed?
    return 16777252;
  }

  private void doFireEvent(AppSession appSession, Message message) {
    this.s13ResourceAdaptor.fireEvent(appSession.getSessions().get(0).getSessionId(), message);
  }

  @Override
  public void doMEIdentityCheckRequestEvent(ServerS13Session appSession, JMEIdentityCheckRequest request) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    logger.info("Diameter S13 Session Factory :: doMEIdentityCheckRequest :: appSession[" + appSession + "], Request[" + request + "]");
    doFireEvent(appSession, request.getMessage());
  }

  @Override
  public void doMEIdentityCheckAnswerEvent(ClientS13Session appSession, JMEIdentityCheckRequest request, JMEIdentityCheckAnswer answer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    logger.info("Diameter S13 Session Factory :: doMEIdentityCheckAnswerEvent :: appSession[" + appSession + "], Request[" + request + "], Answer[" + answer + "]");
    doFireEvent(appSession, answer.getMessage());
  }
}
