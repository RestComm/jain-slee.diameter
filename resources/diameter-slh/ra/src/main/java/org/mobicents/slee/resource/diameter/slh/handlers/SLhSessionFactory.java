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

package org.mobicents.slee.resource.diameter.slh.handlers;

import org.jdiameter.api.InternalException;
import org.jdiameter.api.SessionFactory;
import org.jdiameter.api.app.AppAnswerEvent;
import org.jdiameter.api.app.AppRequestEvent;
import org.jdiameter.api.app.AppSession;
/*
import org.jdiameter.api.slh.ClientSLhSession;
import org.jdiameter.api.slh.ServerSLhSession;
import org.jdiameter.api.slh.events.LCSRoutingInfoRequest;
import org.jdiameter.api.slh.events.LCSRoutingInfoAnswer;
import org.jdiameter.common.impl.app.slh.SLhSessionFactoryImpl;
 */
import org.mobicents.slee.resource.diameter.base.handlers.DiameterRAInterface;
/**
 *
 * @author Fernando Mendioroz (fernando.mendioroz@telestax.com)
 *
 */
public class SLhSessionFactory {/*extends SLhSessionFactoryImpl {

  public DiameterRAInterface ra;

  /**
   * @param sessionFactory
   */
  /*/public SLhSessionFactory(DiameterRAInterface ra, SessionFactory sessionFactory/*, int defaultDirectDebitingFailureHandling, int defaultCreditControlFailureHandling, long defaultValidityTime, long defaultTxTimerValue*///) {
    /*/super(sessionFactory);

    //super.defaultDirectDebitingFailureHandling = defaultDirectDebitingFailureHandling;
    //super.defaultCreditControlFailureHandling = defaultCreditControlFailureHandling;
    //super.defaultValidityTime = defaultValidityTime;
    //super.defaultTxTimerValue = defaultTxTimerValue;

    this.ra = ra;
  }

  @Override
  public void doLCSRoutingInfoAnswer(ClientSLhSession session, LCSRoutingInfoRequest request, LCSRoutingInfoAnswer answer) throws InternalException {
    ra.fireEvent(session.getSessionId(), answer.getMessage());
  }

  @Override
  public void doLCSRoutingInfoRequest(ServerSLhSession session, LCSRoutingInfoRequest request) throws InternalException {
    ra.fireEvent(session.getSessionId(), request.getMessage());
  }

  @Override
  public void doOtherEvent(AppSession session, AppRequestEvent request, AppAnswerEvent answer) throws InternalException {
    ra.fireEvent(session.getSessionId(), answer != null ? answer.getMessage() : request.getMessage());
  }


*/
}
