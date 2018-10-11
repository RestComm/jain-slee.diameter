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

package net.java.slee.resource.diameter.slh.events;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.VendorSpecificApplicationIdAvp;

/**
 * Interface for LCSRoutingInfoRequest type of message. It has following structure:
 *
 * < LCS-Routing-Info-Request> ::=	< Diameter Header: 8388622, REQ, PXY, 16777291 >
 *
 *                                  < Session-Id >
 *                                  [ Vendor-Specific-Application-Id ]
 *                                  { Auth-Session-State }
 *                                  { Origin-Host }
 *                                  { Origin-Realm }
 *                                  [ Destination-Host ]
 *                                  { Destination-Realm }
 *                                  [ User-Name ]
 *                                  [ MSISDN ]
 *                                  [ GMLC-Number ]
 *                                 *[ Supported-Features ]
 *                                 *[ Proxy-Info ]
 *                                 *[ Route-Record ]
 *                                 *[ AVP ]
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface LCSRoutingInfoRequest extends DiameterMessage {

  static final int COMMAND_CODE = 8388622;

  /**
   * Returns true if the Vendor-Specific-Application-Id AVP is present in the message.
   *
   * @return true if the Vendor-Specific-Application-Id AVP is present in the message, false otherwise
   */
  public boolean hasVendorSpecificApplicationId();

  /**
   * Returns the value of the Vendor-Specific-Application-Id AVP, of type Grouped.
   *
   * @return the value of the Vendor-Specific-Application-Id AVP or null if it has not been set on this message
   */
  public VendorSpecificApplicationIdAvp getVendorSpecificApplicationId();

  /**
   * Sets the value of the Vendor-Specific-Application-Id AVP, of type Grouped.
   *
   * @param vendorSpecificApplicationId the new value for the Vendor-Specific-Application-Id AVP
   */
  public void setVendorSpecificApplicationId(VendorSpecificApplicationIdAvp vendorSpecificApplicationId);

  /**
   * Returns true if the Auth-Session-State AVP is present in the message.
   *
   * @return true if the Auth-Session-State AVP is present in the message, false otherwise
   */
  public boolean hasAuthSessionState();

  /**
   * Returns the value of the Auth-Session-State AVP, of type Enumerated.
   *
   * @return the value of the Auth-Session-State AVP, of type Enumerated
   */
  public AuthSessionStateType getAuthSessionState();

  /**
   * Sets the value of the Auth-Session-State AVP, of type Enumerated.
   *
   * @param authSessionState
   */
  public void setAuthSessionState(AuthSessionStateType authSessionState);

  /**
   * Returns true if the User-Name AVP is present in the message.
   *
   * @return
   */
  boolean hasUserName();

  /**
   * Returns the value of the User-Name AVP, of type UTF8String.
   *
   * @return
   */
  String getUserName();

  /**
   * Sets the value of the User-Name AVP, of type UTF8String.
   *
   * @param userName
   * @throws IllegalStateException
   */
  void setUserName(String userName) throws IllegalStateException;

  /**
   * Returns true if the MSISDN AVP is present in the message.
   *
   * @return
   */
  boolean hasMSISDN();

  /**
   * Returns the value of the MSISDN AVP, of type OctetString.
   *
   * @return
   */
  byte[] getMSISDN();

  /**
   * Sets the value of the MSISDN AVP, of type OctetString.
   *
   * @param msisdn
   * @throws IllegalStateException
   */
  void setMSISDN(byte[] msisdn) throws IllegalStateException;

  /**
   * Returns true if the GMLC-Number AVP is present in the message.
   *
   * @return
   */
  boolean hasGMLCNumber();

  /**
   * Returns the value of the GMLC-Number AVP, of type OctetString.
   *
   * @return
   */
  byte[] getGMLCNumber();

  /**
   * Sets the value of the GMLC-Number AVP, of type OctetString.
   *
   * @param gmlcNumber
   * @throws IllegalStateException
   */
  void setGMLCNumber(byte[] gmlcNumber) throws IllegalStateException;

}


