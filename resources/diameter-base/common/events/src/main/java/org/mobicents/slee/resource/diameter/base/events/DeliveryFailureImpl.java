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

package org.mobicents.slee.resource.diameter.base.events;

import net.java.slee.resource.diameter.base.events.DeliveryFailure;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

import org.jdiameter.api.Message;
import org.jdiameter.api.RouteException;

/**
 * Delivery failure implementation.
 */
public class DeliveryFailureImpl implements DeliveryFailure {

  protected RouteException cause = null;
  protected Message request = null;
  protected DiameterIdentity peer = null;

  /**
   * Constructor.
   * @param request
   * @param peer
   */
  public DeliveryFailureImpl(RouteException cause, Message request, DiameterIdentity peer) {
    this.cause = cause;
    this.request = request;
    this.peer = peer;
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.base.events.DeliveryFailure#getCause()
   */
  public RouteException getCause() {
    return cause;
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.base.events.DeliveryFailure#getRequest()
   */
  public Message getRequest() {
    return request;
  }

  /*
   * (non-Javadoc)
   * @see nnet.java.slee.resource.diameter.base.events.DeliveryFailure#getLastPeer()
   */
  public DiameterIdentity getLastPeer() {
    return peer;
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.base.events.DeliveryFailure#hasLastPeer()
   */
  public boolean hasLastPeer() {
    return peer != null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\r\n");
    sb.append("+--------------------------- Delivery failure ---------------------------------+\r\n");
    sb.append("| Last selected peer:  ").append(peer).append("\r\n");
    sb.append("| Failure for message: ").append(request).append("\r\n");
    sb.append("|   Application-Id..........").append(request.getApplicationId()).append("\r\n");
    sb.append("|   Hop-By-Hop Identifier...").append(request.getHopByHopIdentifier()).append("\r\n");
    sb.append("|   End-To-End Identifier...").append(request.getEndToEndIdentifier()).append("\r\n");
    sb.append("|   Session-Id..............").append(request.getSessionId()).append("\r\n");
    sb.append("| Root cause: ").append(cause).append("\r\n");
    sb.append("+-----------------------------------------------------------------------------+\r\n");
    return sb.toString();
  }
}
