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

package net.java.slee.resource.diameter.base.events;

import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

import org.jdiameter.api.Message;
import org.jdiameter.api.RouteException;

/**
 * Event that represents delivery failure of a given message.
 */
public interface DeliveryFailure {

  /**
   * Returns an exception that made delivery of a given message impossible.
   *
   * @return exception
   */
  RouteException getCause();

  /**
   * Returns the request that caused Tx timeout to expire due to no response from a remote peer.
   *
   * @return origin request
   */
  Message getRequest();

  /**
   * Returns the name of the last selected remote peer that a given message has been routed to.
   *
   * @return peer name
   */
  DiameterIdentity getLastPeer();

  /**
   * Returns true if last selected remote peer is present for a given message.
   *
   * @return true if peer name is present
   */
  boolean hasLastPeer();

}
