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

package net.java.slee.resource.diameter.cca.events;

import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import org.jdiameter.api.Message;

/**
 *
 * Request Timeout as specified in RFC 4006:
 *
 */
public interface RequestTimeout {

  /**
   * Returns the request that caused timeout to expire due to no response from a remote peer.
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
