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

import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;

/**
 * An SLhClientSessionActivity represents a session for SLh interface clients (GMLCs)
 * <p>
 * All requests for the session must be sent via the same SLhClientSessionActivity.
 * </p>
 * All responses related to the session will be received as events fired on the same SLhClientSessionActivity.
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface SLhClientSessionActivity extends SLhSessionActivity {

  /**
   * Create LCS Routing-Info-Request.
   */
  LCSRoutingInfoRequest createLCSRoutingInfoRequest();

  /**
   * Send an LCS Routing-Info-Request.
   *
   * @param rir (the LCS Routing-Info-Request to send)
   * @throws IOException (if an error occurred sending the request to the peer)
   */
  void sendLCSRoutingInfoRequest(LCSRoutingInfoRequest rir) throws IOException;

}

