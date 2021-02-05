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

package net.java.slee.resource.diameter.slg;

import net.java.slee.resource.diameter.Validator;
import net.java.slee.resource.diameter.base.CreateActivityException;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

/**
 * Provider to create SLg sessions and obtain Messages/AVP Factories.
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface SLgProvider {

  /**
   * Create a new server session to send and receive Diameter messages.
   * All messages sent on an activity created by this method must contain valid
   * routing AVPs (one or both of Destination-Realm and Destination-Host as
   * defined by RFC6733).
   *
   * @return a instance of a SLgServerSession to send SLg messages
   */
  SLgServerSessionActivity createSLgServerSessionActivity() throws CreateActivityException;

  /**
   * Create a new server session to send and receive Diameter messages.
   * Messages sent on an activity created by this method will automatically
   * have the Destination-Host and Destination-Realm AVPs set to the provided
   * values.
   *
   * @param destinationHost  a destination host to automatically put in all messages, may be null if not needed
   * @param destinationRealm a destination realm to automatically put in all messages
   * @return a instance of a SLgServerSession to send SLg messages
   * @throws CreateActivityException
   */
  SLgServerSessionActivity createSLgServerSessionActivity(DiameterIdentity destinationHost, DiameterIdentity destinationRealm) throws CreateActivityException;

  /**
   * Create a new client session to send and receive Diameter messages.
   * All messages sent on an activity created by this method must contain valid
   * routing AVPs (one or both of Destination-Realm and Destination-Host as
   * defined by RFC6733).
   *
   * @return a instance of a SLgClientSession to send SLg messages
   */
  SLgClientSessionActivity createSLgClientSessionActivity() throws CreateActivityException;

  /**
   * Create a new client session to send and receive Diameter messages.
   * Messages sent on an activity created by this method will automatically
   * have the Destination-Host and Destination-Realm AVPs set to the provided
   * values.
   *
   * @param destinationHost  a destination host to automatically put in all messages, may be null if not needed
   * @param destinationRealm a destination realm to automatically put in all messages
   * @return a instance of a SLgClientSession to send SLg messages
   * @throws CreateActivityException
   */
  SLgClientSessionActivity createSLgClientSessionActivity(DiameterIdentity destinationHost, DiameterIdentity destinationRealm) throws CreateActivityException;
  SLgClientSessionActivity createSLgClientSessionActivity(DiameterIdentity destinationHost, DiameterIdentity destinationRealm, String sessionId) throws CreateActivityException;

  /**
   * Return a message factory to be used to create SLg messages.
   *
   * @return a SLgMessageFactory implementation
   */
  SLgMessageFactory getSLgMessageFactory();

  /**
   * Return a AVP factory to be used to create SLg AVPs
   *
   * @return a SLgAVPFactory implementation
   */
  SLgAVPFactory getSLgAVPFactory();

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
