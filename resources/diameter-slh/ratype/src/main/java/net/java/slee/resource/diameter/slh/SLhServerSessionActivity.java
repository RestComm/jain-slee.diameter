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

package net.java.slee.resource.diameter.slh;

import java.io.IOException;

import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer;

/**
 * An SLhServerSessionActivity represents a session between GMLC and HSS.
 * <p>
 * A single SLhServerSessionActivity will be created for the Diameter session.
 * All requests received for the session will be fired as events on the same SLhServerSessionActivity.
 * </p>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface SLhServerSessionActivity extends SLhSessionActivity {

  /**
   * Create a SLh-specific Routing-Info-Answer message pre-populated with the
   * appropriate AVPs for this session.
   *
   * @return a new LCSRoutingInfoAnswer
   */
  LCSRoutingInfoAnswer createLCSRoutingInfoAnswer();

  /**
   * Sends a Routing-Info-Answer message to the peer.
   *
   * @param ria the LCSRoutingInfoAnswer to send
   * @throws IOException if an error occurred sending the request to the peer
   */
  void sendLCSRoutingInfoAnswer(LCSRoutingInfoAnswer ria) throws IOException;


}
