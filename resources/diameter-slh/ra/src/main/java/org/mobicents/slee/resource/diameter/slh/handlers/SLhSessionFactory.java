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

package org.mobicents.slee.resource.diameter.slh.handlers;

import org.apache.log4j.Logger;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.IllegalDiameterStateException;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.OverloadException;
import org.jdiameter.api.RouteException;
import org.jdiameter.api.SessionFactory;
import org.jdiameter.api.app.AppAnswerEvent;
import org.jdiameter.api.app.AppRequestEvent;
import org.jdiameter.api.app.AppSession;

import org.jdiameter.api.slh.ClientSLhSession;
import org.jdiameter.api.slh.ServerSLhSession;
import org.jdiameter.api.slh.events.LCSRoutingInfoRequest;
import org.jdiameter.api.slh.events.LCSRoutingInfoAnswer;
import org.jdiameter.client.impl.app.slh.SLhClientSessionImpl;
import org.jdiameter.common.impl.app.slh.SLhSessionFactoryImpl;

import org.jdiameter.server.impl.app.slh.SLhServerSessionImpl;
import org.mobicents.slee.resource.diameter.base.handlers.DiameterRAInterface;

/**
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class SLhSessionFactory extends SLhSessionFactoryImpl {

  public DiameterRAInterface slhResourceAdaptor;
  private static final Logger logger = Logger.getLogger(SLhSessionFactory.class);

  /**
   * @param sessionFactory
   */
  public SLhSessionFactory(DiameterRAInterface slhResourceAdaptor, long messageTimeout, SessionFactory sessionFactory) {
    super(sessionFactory);
    this.slhResourceAdaptor = slhResourceAdaptor;
  }

  /* (non-Javadoc)
   * @see org.jdiameter.common.api.app.IAppSessionFactory#getNewSession(java.lang.String, java.lang.Class, org.jdiameter.api.ApplicationId, java.lang.Object[])
   */
  @Override
  public AppSession getNewSession(String sessionId, Class<? extends AppSession> appSessionClass, ApplicationId applicationId, Object[] args) {
    AppSession appSession;

    if (appSessionClass == ServerSLhSession.class) {
      SLhServerSessionImpl serverSession;
      serverSession = (SLhServerSessionImpl) super.getNewSession(sessionId, appSessionClass, applicationId, args);
      appSession = serverSession;
    } else if (appSessionClass == ClientSLhSession.class) {
      SLhClientSessionImpl clientSession;
      clientSession = (SLhClientSessionImpl) super.getNewSession(sessionId, appSessionClass, applicationId, args);
      appSession = clientSession;
    } else {
      throw new IllegalArgumentException("Wrong session class: [" + appSessionClass + "]. Supported[" + ServerSLhSession.class + "," + ClientSLhSession.class + "]");
    }

    return appSession;
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.jdiameter.common.impl.app.sh.SLhSessionFactoryImpl#stateChanged(org.jdiameter.api.app.AppSession, java.lang.Enum, java.lang.Enum)
   */
  @Override
  public void stateChanged(AppSession source, Enum oldState, Enum newState) {
    //slhaResourceAdaptor.stateChanged(source, oldState, newState);
    logger.info("Diameter SLh Session Factory :: stateChanged :: source[" + source + "] :: oldState[" + oldState + "], newState[" + newState + "]");
  }

  /* (non-Javadoc)
   * @see org.jdiameter.api.app.StateChangeListener#stateChanged(java.lang.Enum, java.lang.Enum)
   */
  @Override
  public void stateChanged(Enum oldState, Enum newState) {
    logger.info("Diameter SLh Session Factory :: stateChanged :: oldState[" + oldState + "], newState[" + newState + "]");
  }

  /* (non-Javadoc)
   * @see org.jdiameter.common.api.app.slh.IslhMessageFactory#getApplicationId()
   */
  @Override
  public long getApplicationId() {
    // FIXME: Not needed?
    return 16777291;
  }

  @Override
  public void doLCSRoutingInfoRequestEvent(ServerSLhSession serverSLhSession, LCSRoutingInfoRequest request)
      throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    slhResourceAdaptor.fireEvent(serverSLhSession.getSessionId(), request.getMessage());
  }

  @Override
  public void doLCSRoutingInfoAnswerEvent(ClientSLhSession clientSLhSession, LCSRoutingInfoRequest request, LCSRoutingInfoAnswer answer)
      throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    slhResourceAdaptor.fireEvent(clientSLhSession.getSessionId(), answer.getMessage());
  }

  /* (non-Javadoc)
   * @see org.jdiameter.api.slh.ServerSlhSessionListener#doOtherEvent(org.jdiameter.api.app.AppSession, org.jdiameter.api.app.AppRequestEvent, org.jdiameter.api.app.AppAnswerEvent)
   */
  @Override
  public void doOtherEvent(AppSession appSession, AppRequestEvent request, AppAnswerEvent answer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    logger.info("Diameter SLh Session Factory :: doOtherEvent :: appSession[" + appSession + "], Request[" + request + "]");

    slhResourceAdaptor.fireEvent(appSession.getSessionId(), answer != null ? answer.getMessage() : request.getMessage());
  }

}

