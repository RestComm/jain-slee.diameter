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

package org.mobicents.slee.resource.diameter.slg.handlers;

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

import org.jdiameter.api.slg.ClientSLgSession;
import org.jdiameter.api.slg.ServerSLgSession;
import org.jdiameter.api.slg.events.ProvideLocationRequest;
import org.jdiameter.api.slg.events.ProvideLocationAnswer;
import org.jdiameter.api.slg.events.LocationReportRequest;
import org.jdiameter.api.slg.events.LocationReportAnswer;
import org.jdiameter.common.impl.app.slg.SLgSessionFactoryImpl;
import org.jdiameter.client.impl.app.slg.SLgClientSessionImpl;
import org.jdiameter.server.impl.app.slg.SLgServerSessionImpl;

import org.mobicents.slee.resource.diameter.base.handlers.DiameterRAInterface;

/**
 * @author Fernando Mendioroz (fernando.mendioroz@gmail.com)
 */
public class SLgSessionFactory extends SLgSessionFactoryImpl {

  public DiameterRAInterface slgResourceAdaptor;
  private static final Logger logger = Logger.getLogger(SLgSessionFactory.class);

  public SLgSessionFactory(DiameterRAInterface slgResourceAdaptor, long messageTimeout, SessionFactory sessionFactory) {
    super(sessionFactory);
    this.slgResourceAdaptor = slgResourceAdaptor;
  }

  /* (non-Javadoc)
   * @see org.jdiameter.common.api.app.IAppSessionFactory#getNewSession(java.lang.String, java.lang.Class, org.jdiameter.api.ApplicationId, java.lang.Object[])
   */

  @Override
  public AppSession getNewSession(String sessionId, Class<? extends AppSession> appSessionClass, ApplicationId applicationId, Object[] args) {
    AppSession appSession = null;

    if (appSessionClass == ServerSLgSession.class) {
      SLgServerSessionImpl serverSession = null;
      serverSession = (SLgServerSessionImpl) super.getNewSession(sessionId, appSessionClass, applicationId, args);
      appSession = serverSession;
    } else if (appSessionClass == ClientSLgSession.class) {
      SLgClientSessionImpl clientSession = null;
      clientSession = (SLgClientSessionImpl) super.getNewSession(sessionId, appSessionClass, applicationId, args);
      appSession = clientSession;
    } else {
      throw new IllegalArgumentException("Wrong session class: [" + appSessionClass + "]. Supported[" + ServerSLgSession.class + "," + ClientSLgSession.class + "]");
    }

    return appSession;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.jdiameter.common.impl.app.slg.SLgSessionFactoryImpl#stateChanged(org.jdiameter.api.app.AppSession, java.lang.Enum, java.lang.Enum)
   */
  @Override
  public void stateChanged(AppSession source, Enum oldState, Enum newState) {
    // slgResourceAdaptor.state(source, oldState, newState);
    logger.info("Diameter SLg Session Factory :: stateChanged :: source[" + source + "] :: oldState[" + oldState + "], newState[" + newState + "]");
  }

  /* (non-Javadoc)
   * @see org.jdiameter.api.app.StateChangeListener#stateChanged(java.lang.Enum, java.lang.Enum)
   */
  @Override
  public void stateChanged(Enum oldState, Enum newState) {
    if (logger.isDebugEnabled())
      logger.debug("Diameter SLg Session Factory :: stateChanged :: oldState[" + oldState + "], newState[" + newState + "]");
  }

  /* (non-Javadoc)
   * @see org.jdiameter.common.api.app.slg.ISLgMessageFactory#getApplicationId()
   */
  @Override
  public long getApplicationId() {
    // FIXME: Not needed?
    return 16777255;
  }

  private void doFireEvent(AppSession appSession, Message message) {
    this.slgResourceAdaptor.fireEvent(appSession.getSessions().get(0).getSessionId(), message);
  }

  @Override
  public void doProvideLocationRequestEvent(ServerSLgSession serverSLgSession, ProvideLocationRequest provideLocationRequest) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    if (logger.isDebugEnabled())
      logger.debug("Diameter SLg Session Factory :: doProvideLocationRequest :: appSession[" + serverSLgSession + "], Request[" + provideLocationRequest + "]");
    doFireEvent(serverSLgSession, provideLocationRequest.getMessage());
  }

  @Override
  public void doProvideLocationAnswerEvent(ClientSLgSession clientSLgSession, ProvideLocationRequest provideLocationRequest, ProvideLocationAnswer provideLocationAnswer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    if (logger.isDebugEnabled())
      logger.debug("Diameter SLg Session Factory :: doProvideLocationAnswer :: appSession[" + clientSLgSession + "], Request[" + provideLocationRequest + "], Answer[" + provideLocationAnswer + "]");
    doFireEvent(clientSLgSession, provideLocationAnswer.getMessage());
  }

  @Override
  public void doLocationReportRequestEvent(ClientSLgSession clientSLgSession, LocationReportRequest locationReportRequest) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    if (logger.isDebugEnabled())
      logger.debug("Diameter SLg Session Factory :: doLocationReportRequest :: appSession[" + clientSLgSession + "], Request[" + locationReportRequest + "]");
    doFireEvent(clientSLgSession, locationReportRequest.getMessage());
  }

  @Override
  public void doLocationReportAnswerEvent(ServerSLgSession serverSLgSession, LocationReportRequest locationReportRequest, LocationReportAnswer locationReportAnswer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    if (logger.isDebugEnabled())
      logger.debug("Diameter SLg Session Factory :: doLocationReportAnswer :: appSession[" + serverSLgSession + "], Request[" + locationReportRequest + "], Answer[" + locationReportAnswer + "]");
    doFireEvent(serverSLgSession, locationReportAnswer.getMessage());
  }

  /* (non-Javadoc)
   * @see org.jdiameter.api.slg.ServerSLgSessionListener#doOtherEvent(org.jdiameter.api.app.AppSession, org.jdiameter.api.app.AppRequestEvent, org.jdiameter.api.app.AppAnswerEvent)
   */
  @Override
  public void doOtherEvent(AppSession appSession, AppRequestEvent request, AppAnswerEvent answer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
    if (logger.isDebugEnabled())
      logger.debug("Diameter SLg Session Factory :: doOtherEvent :: appSession[" + appSession + "], Request[" + request + "]");
    doFireEvent(appSession, answer != null ? answer.getMessage() : request.getMessage());
  }

}