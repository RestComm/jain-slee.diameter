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

import net.java.slee.resource.diameter.Validator;
import net.java.slee.resource.diameter.base.CreateActivityException;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

/**
 * The SBB interface for the Diameter SLh Resource Adaptor.
 * <p>
 * This API can be used in either an asynchronous or synchronous manner.
 * <p>
 * To send messages asynchronously, create a SLhClientSessionActivity using one of the createSLhClientSessionActivity() methods.
 * <p>
 * To send messages synchronously, use the following methods:
 * <ul>eventLCSRoutingInfoRequest(LCSRoutingInfoRequest)</ul>
 * <p>
 * The Routing-Info-Request messages must be created using the SLhMessageFactory returned from getSLhMessageFactory().
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface SLhProvider {

  /**
   * Return a message factory to be used to create concrete implementations of LCS Routing-Info messages.
   *
   * @return
   */
  SLhMessageFactory getSLhMessageFactory();

  /**
   * Return a avp factory to be used to create concrete implementations of SLh AVPs.
   *
   * @return
   */
  SLhAVPFactory getSLhAvpFactory();

  /**
   * Create a new activity to send and receive Diameter messages.
   *
   * @return a DiameterActivity
   * @throws CreateActivityException if the RA could not create the activity for any reason
   */
  public SLhClientSessionActivity createSLhClientSessionActivity() throws CreateActivityException;

  /**
   * Create a new activity to send and receive Diameter messages.
   *
   * @param destinationHost  a destination host to automatically put in all messages
   * @param destinationRealm a destination realm to automatically put in all messages
   * @return a DiameterActivity
   * @throws CreateActivityException if the RA could not create the activity for any reason
   */
  public SLhClientSessionActivity createSLhClientSessionActivity(DiameterIdentity destinationHost, DiameterIdentity destinationRealm) throws CreateActivityException;

  /**
   * Create a new server session to send and receive Diameter messages.
   * All messages sent on an activity created by this method must contain valid
   * routing AVPs (one or both of Destination-Realm and Destination-Host as
   * defined by IETF RFC 6733).
   *
   * @return a instance of a SLhServerSession to send SLh messages
   */
  SLhServerSessionActivity createSLhServerSessionActivity() throws CreateActivityException;

  /**
   * Create a new server session to send and receive Diameter messages.
   * Messages sent on an activity created by this method will automatically
   * have the Destination-Host and Destination-Realm AVPs set to the provided
   * values.
   *
   * @param destinationHost  a destination host to automatically put in all messages, may be null if not needed
   * @param destinationRealm a destination realm to automatically put in all messages
   * @return a instance of a SLhServerSession to send SLh messages
   * @throws CreateActivityException
   */
  SLhServerSessionActivity createSLhServerSessionActivity(DiameterIdentity destinationHost, DiameterIdentity destinationRealm) throws CreateActivityException;

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
