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
  public void fireDeliveryFailure(RouteException cause, String session, Message msg, Peer peer);
}
