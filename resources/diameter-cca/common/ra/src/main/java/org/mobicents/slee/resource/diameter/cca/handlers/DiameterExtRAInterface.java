/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
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
 */

package org.mobicents.slee.resource.diameter.cca.handlers;

import org.jdiameter.api.Message;
import org.jdiameter.api.Peer;
import org.jdiameter.api.RouteException;
import org.jdiameter.api.ro.ClientRoSession;
import org.jdiameter.api.ro.events.RoCreditControlRequest;
import org.mobicents.slee.resource.diameter.base.handlers.DiameterRAInterface;

/**
 * This should be implemented by RA.
 */
public interface DiameterExtRAInterface extends DiameterRAInterface {

  /**
   * Makes RA fire tx timeout event.
   *
   * @param sessionId
   * @param message
   * @param peer
   */
  public void fireTxTimeout(String sessionId, Message message, Peer peer);

  /**
   * Makes RA fire timeout event.
   *
   * @param sessionId
   * @param message
   * @param peer
   */
  public void fireTimeout(String sessionId, Message message, Peer peer);

  /**
   * Makes RA fire delivery failure event.
   *
   * @param cause
   * @param sessionId
   * @param message
   * @param peer
   */
  public void fireDeliveryFailure(String sessionId, Message message, Peer peer, RouteException cause);
}
