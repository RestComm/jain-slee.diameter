/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
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

import net.java.slee.resource.diameter.Validator;
import net.java.slee.resource.diameter.base.CreateActivityException;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;

/**
 * The SBB interface for the Diameter SLh Resource Adaptor.
 *
 * This API can be used in either an asynchronous or synchronous manner.
 *
 * To send messages asynchronously, create a SLhClientSessionActivity using one of the createSLhClientSessionActivity() methods.
 *
 * To send messages synchronously, use the following methods:
 * <ul>eventLCSRoutingInfoRequest(LCSRoutingInfoRequest)</ul>
 * <ul>initialLCSRoutingInfoRequest(LCSRoutingInfoRequest)</ul>
 * <ul>updateLCSRoutingInfoRequest(LCSRoutingInfoRequest)</ul>
 * <ul>terminationLCSRoutingInfoRequest(LCSRoutingInfoRequest)</ul>
 *
 * The Routing-Info-Request messages must be created using the SLhMessageFactory returned from getSLhMessageFactory().
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface SLhProvider {

  /**
   * Return a message factory to be used to create concrete implementations of LCS Routing-Info messages.
   *
   * @return
   */
  public SLhMessageFactory getSLhMessageFactory();

  /**
   * Return a avp factory to be used to create concrete implementations of SLh AVPs.
   *
   * @return
   */
  public SLhAVPFactory getSLhAvpFactory();

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
   * @param destinationHost a destination host to automatically put in all messages
   * @param destinationRealm a destination realm to automatically put in all messages
   * @return a DiameterActivity
   * @throws CreateActivityException if the RA could not create the activity for any reason
   */
  public SLhClientSessionActivity createSLhClientSessionActivity(DiameterIdentity destinationHost, DiameterIdentity destinationRealm) throws CreateActivityException;

  /**
   * Send a LCS Routing-Info-Request message to the appropriate peers, and block until the response is received then return it.
   *
   * @param rir the LCSRoutingInfoRequest to send
   * @return the answer received
   * @throws IOException if an error occurred sending the request to the peer
   */
  public LCSRoutingInfoAnswer sendLCSRoutingInfoRequest(LCSRoutingInfoRequest rir) throws IOException;

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
