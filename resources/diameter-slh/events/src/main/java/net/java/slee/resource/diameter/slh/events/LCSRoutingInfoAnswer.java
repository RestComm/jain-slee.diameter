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
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp;
import net.java.slee.resource.diameter.base.events.avp.FailedAvp;

import net.java.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvp;
import net.java.slee.resource.diameter.slh.events.avp.ServingNodeAvp;

/**
 * Interface defining LCSRoutingInfoAnswer message. It has following structure:
 *
 * < LCS-Routing-Info-Answer> ::=	< Diameter Header: 8388622, PXY, 16777291 >
 *
 *                              < Session-Id >
 *                              [ Vendor-Specific-Application-Id ]
 *                              [ Result-Code ]
 *                              [ Experimental-Result ]
 *                              { Auth-Session-State }
 *                              { Origin-Host }
 *                              { Origin-Realm }
 *                             *[ Supported-Features ]
 *                              [ User-Name ]
 *                              [ MSISDN ]
 *                              [ LMSI ]
 *                              [ Serving-Node ]
 *                             *[ Additional-Serving-Node ]
 *                              [ GMLC-Address ]
 *                              [ PPR-Address ]
 *                              [ RIA-Flags ]
 *                             *[ AVP ]
 *                             *[ Failed-AVP ]
 *                             *[ Proxy-Info ]
 *                             *[ Route-Record ]
 *
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface LCSRoutingInfoAnswer extends DiameterMessage {

  static final int COMMAND_CODE = 8388622;

  /**
   * Returns true if the Result-Code AVP is present in the message.
   */
  boolean hasResultCode();

  /**
   * Returns the value of the Result-Code AVP, of type Unsigned32. Use
   * {@link #hasResultCode()} to check the existence of this AVP.
   *
   * @return the value of the Result-Code AVP
   * @throws IllegalStateException if the Result-Code AVP has not been set on this message
   */
  long getResultCode();

  /**
   * Sets the value of the Result-Code AVP, of type Unsigned32.
   *
   * @throws IllegalStateException if setResultCode has already been called
   */
  void setResultCode(long resultCode);

  /**
   * @return true if the Experimental-Result AVP is present in the message, false otherwise
   */
  public boolean hasExperimentalResult();

  /**
   * @return the value of the Experimental-Result AVP, of type Grouped.
   */
  public ExperimentalResultAvp getExperimentalResult();

  /**
   * Sets the value of the Experimental-Result AVP, of type Grouped.
   *
   * @param experimentalResult
   */
  public void setExperimentalResult(ExperimentalResultAvp experimentalResult);

  /**
   * @return true if the Experimental-Result AVP is present in the message, false otherwise
   */
  public boolean hasAuthSessionState();

  /**
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
   * Returns the set of Failed-AVP AVPs.
   *
   * @return
   */
  FailedAvp[] getFailedAvps();

  /**
   * Sets a single Failed-AVP AVP in the message, of type Grouped.
   *
   * @param failedAvp
   * @throws IllegalStateException
   */
  void setFailedAvp(FailedAvp failedAvp) throws IllegalStateException;

  /**
   * Sets the set of Failed-AVP AVPs, with all the values in the given array.
   *
   * @param failedAvps
   * @throws IllegalStateException
   */
  void setFailedAvps(FailedAvp[] failedAvps) throws IllegalStateException;

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
   * Returns true if the LMSI AVP is present in the message.
   *
   * @return
   */
  boolean hasLMSI();

  /**
   * Returns the value of the LMSI AVP, of type OctetString.
   *
   * @return
   */
  byte[] getLMSI();

  /**
   * Sets the value of the LMSI AVP, of type OctetString.
   *
   * @param lmsi
   * @throws IllegalStateException
   */
  void setLMSI(byte[] lmsi) throws IllegalStateException;

  /**
   * Returns true if the Serving-Node AVP is present in the message.
   *
   * @return
   */
  boolean hasServingNode();

  /**
   * Returns the value of the Serving-Node AVP, of type Grouped.
   *
   * @return
   */
  ServingNodeAvp getServingNode();

  /**
   * Sets the value of the Serving-Node AVP, of type Grouped.
   *
   * @param servingNode
   * @throws IllegalStateException
   */
  void setServingNode(ServingNodeAvp servingNode) throws IllegalStateException;

  /**
   * Returns true if the Additional-Serving-Node AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditionalServingNode();

  /**
   * Returns the value of the Additional-Serving-Node AVP, of type Grouped.
   *
   * @return
   */
  AdditionalServingNodeAvp getAdditionalServingNode();

  /**
   * Sets the value of the Additional-Serving-Node AVP, of type Grouped.
   *
   * @param additionalServingNode
   * @throws IllegalStateException
   */
  void setAdditionalServingNode(AdditionalServingNodeAvp additionalServingNode) throws IllegalStateException;

  /**
   * Returns true if the GMLC-Address AVP is present in the message.
   *
   * @return
   */
  boolean hasGMLCAddress();

  /**
   * Returns the value of the GMLC-Address AVP, of type Address.
   *
   * @return
   */
  Address getGMLCAddress();

  /**
   * Sets the value of the GMLC-Address AVP, of type Address.
   *
   * @param gmlcNumber
   * @throws IllegalStateException
   */
  void setGMLCAddress(Address gmlcNumber) throws IllegalStateException;

  /**
   * Returns true if the PPR-Address AVP is present in the message.
   *
   * @return
   */
  boolean hasPPRAddress();

  /**
   * Returns the value of the PPR-Address AVP, of type Address.
   *
   * @return
   */
  Address getPPRAddress();

  /**
   * Sets the value of the PPR-Address AVP, of type Address.
   *
   * @param pprAddress
   * @throws IllegalStateException
   */
  void setPPRAddress(Address pprAddress) throws IllegalStateException;

  /**
   * Returns true if the RIA-Flags AVP is present in the message.
   *
   * @return
   */
  boolean hasRIAFlags();

  /**
   * Returns the value of the RIA-Flags AVP, of type Unsigned32.
   *
   * @return
   */
  long getRIAFlags();

  /**
   * Sets the value of the RIA-Flags AVP, of type Address.
   *
   * @param riaFlags
   * @throws IllegalStateException
   */
  void setRIAFlags(long riaFlags) throws IllegalStateException;

}

