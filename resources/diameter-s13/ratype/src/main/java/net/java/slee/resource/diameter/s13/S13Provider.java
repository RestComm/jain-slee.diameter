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

package net.java.slee.resource.diameter.s13;

import net.java.slee.resource.diameter.Validator;
import net.java.slee.resource.diameter.base.CreateActivityException;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

/**
 * Provider to create S13 sessions and obtain Messages/AVP Factories.
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface S13Provider {

  /**
   * Create a new server session to send and receive Diameter messages.
   * All messages sent on an activity created by this method must contain valid
   * routing AVPs (one or both of Destination-Realm and Destination-Host as
   * defined by RFC3588).
   * 
   * @return a instance of a S13ServerSession to send S13 messages
   */
  S13ServerSessionActivity createS13ServerSessionActivity()throws CreateActivityException;

  /**
   * Create a new server session to send and receive Diameter messages.
   * Messages sent on an activity created by this method will automatically
   * have the Destination-Host and Destination-Realm AVPs set to the provided
   * values.
   * 
   * @param destinationHost a destination host to automatically put in all messages, may be null if not needed
   * @param destinationRealm a destination realm to automatically put in all messages
   * @return a instance of a S13ServerSession to send S13 messages
   * @throws CreateActivityException 
   */
  S13ServerSessionActivity createS13ServerSessionActivity(DiameterIdentity destinationHost, DiameterIdentity destinationRealm) throws CreateActivityException;

  /**
   * Create a new client session to send and receive Diameter messages.
   * All messages sent on an activity created by this method must contain valid
   * routing AVPs (one or both of Destination-Realm and Destination-Host as
   * defined by RFC3588).
   * 
   * @return a instance of a S13ClientSession to send S13 messages
   */
  S13ClientSessionActivity createS13ClientSessionActivity()throws CreateActivityException;

  /**
   * Create a new client session to send and receive Diameter messages.
   * Messages sent on an activity created by this method will automatically
   * have the Destination-Host and Destination-Realm AVPs set to the provided
   * values.
   * 
   * @param destinationHost a destination host to automatically put in all messages, may be null if not needed
   * @param destinationRealm a destination realm to automatically put in all messages
   * @return a instance of a S13ClientSession to send S13 messages
   * @throws CreateActivityException 
   */
  S13ClientSessionActivity createS13ClientSessionActivity(DiameterIdentity destinationHost, DiameterIdentity destinationRealm) throws CreateActivityException;

  /**
   * Return a message factory to be used to create S13 messages
   * 
   * @return a S13MessageFactory implementation
   */
  S13MessageFactory getS13MessageFactory();

  /**
   * Return a AVP factory to be used to create S13 AVPs
   * 
   * @return a S13AVPFactory implementation
   */
  S13AVPFactory getS13AVPFactory();

  /**
   * Return the number of peers this Diameter resource adaptor is connected to.
   * 
   * @return connected peer count
   */
  int getPeerCount();

  /**
   * Returns array containing identities of connected peers.
   * 
   * @return
   */
  DiameterIdentity[] getConnectedPeers();

  Validator getValidator();

}
