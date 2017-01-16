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

package org.mobicents.slee.resource.diameter.cca.events;

import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.cca.events.RequestTxTimeout;

import org.jdiameter.api.Avp;
import org.jdiameter.api.Message;

/**
 * Tx timer implementation.
 */
public class RequestTxTimeoutImpl implements RequestTxTimeout {
  
  protected Message request = null;
  protected DiameterIdentity peer = null;
  
  /**
   * Constructor.
   * @param request
   * @param peer
   */
  public RequestTxTimeoutImpl(Message request, DiameterIdentity peer) {
    this.request = request;
    this.peer = peer;
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.cca.events.RequestTxTimeout#getRequest()
   */
  public Message getRequest() {
    return request;
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.cca.events.RequestTxTimeout#getLastPeer()
   */
  public DiameterIdentity getLastPeer() {
    return peer;
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.cca.events.RequestTxTimeout#hasLastPeer()
   */
  public boolean hasLastPeer() {
    return peer != null;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\r\n");
    sb.append("+--------------------------- Request timeout ---------------------------------+\r\n");
    sb.append("| Last selected peer:  ").append(peer).append("\r\n");
    sb.append("| Timeout for message: ").append(request).append("\r\n");
    sb.append("|   Application-Id..........").append(request.getApplicationId()).append("\r\n");
    sb.append("|   Hop-By-Hop Identifier...").append(request.getHopByHopIdentifier()).append("\r\n");
    sb.append("|   End-To-End Identifier...").append(request.getEndToEndIdentifier()).append("\r\n");
    sb.append("|   Session-Id..............").append(request.getSessionId()).append("\r\n");
    sb.append("+-----------------------------------------------------------------------------+\r\n");
    return sb.toString();
  }
}
