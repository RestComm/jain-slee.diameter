/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
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
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.java.slee.resource.diameter.slh.events;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.base.events.avp.FailedAvp;
import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;
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
 *                              *[ Supported-Features ]
 *                              [ User-Name ]
 *                              [ MSISDN ]
 *                              [ LMSI ]
 *                              [ Serving-Node ]
 *                              *[ Additional-Serving-Node ]
 *                              [ GMLC-Address ]
 *                              [ PPR-Address ]
 *                              [ RIA-Flags ]
 *                              *[ AVP ]
 *                              *[ Failed-AVP ]
 *                              *[ Proxy-Info ]
 *                              *[ Route-Record ]
 *
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface LCSRoutingInfoAnswer extends DiameterMessage {

  /**
   * Returns true if the Result-Code AVP is present in the message.
   */
  boolean hasResultCode();

  /**
   * Returns the value of the Result-Code AVP, of type Unsigned32. Use
   * {@link #hasResultCode()} to check the existence of this AVP.
   *
   * @return the value of the Result-Code AVP
   * @throws IllegalStateException
   *             if the Result-Code AVP has not been set on this message
   */
  long getResultCode();

  /**
   * Sets the value of the Result-Code AVP, of type Unsigned32.
   *
   * @throws IllegalStateException
   *             if setResultCode has already been called
   */
  void setResultCode(long resultCode);

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
  byte[] getServingNode();

  /**
   * Sets the value of the Serving-Node AVP, of type Grouped.
   *
   * @param servingNode
   * @throws IllegalStateException
   */
  void setServingNode(ServingNodeAvp servingNode) throws IllegalStateException;

  /**
   * Returns true if the SGSN-Number AVP is present in the message.
   *
   * @return
   */
  boolean hasSGSNNumber();

  /**
   * Returns the value of the SGSN-Number AVP, of type OctetString.
   *
   * @return
   */
  DiameterIdentity getSGSNNumber();

  /**
   * Sets the value of the SGSN-Number AVP, of type OctetString.
   *
   * @param sgsnNumber
   * @throws IllegalStateException
   */
  void setSGSNNumber(DiameterIdentity sgsnNumber) throws IllegalStateException;

  /**
   * Returns true if the SGSN-Name AVP is present in the message.
   *
   * @return
   */
  boolean hasSGSNName();

  /**
   * Returns the value of the SGSN-Name AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity getSGSNName();

  /**
   * Sets the value of the SGSN-Name AVP, of type DiameterIdentity.
   *
   * @param sgsnName
   * @throws IllegalStateException
   */
  void setSGSNName(DiameterIdentity sgsnName) throws IllegalStateException;

  /**
   * Returns the value of the SGSN-Realm AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity getSGSNRealm();

  /**
   * Sets the value of the SGSN-Realm AVP, of type DiameterIdentity.
   *
   * @param sgsnRealm
   * @throws IllegalStateException
   */
  void setSGSNRealm(DiameterIdentity sgsnRealm) throws IllegalStateException;

  /**
   * Returns true if the SGSN-Realm AVP is present in the message.
   *
   * @return
   */
  boolean hasSGSNRealm();

  /**
   * Returns true if the MME-Name AVP is present in the message.
   *
   * @return
   */
  boolean hasMMEName();

  /**
   * Returns the value of the MME-Name AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity getMMEName();

  /**
   * Sets the value of the MME-Name AVP, of type DiameterIdentity.
   *
   * @param mmeName
   * @throws IllegalStateException
   */
  void setMMEName(DiameterIdentity mmeName) throws IllegalStateException;

  /**
   * Returns true if the MME-Realm AVP is present in the message.
   *
   * @return
   */
  boolean hasMMERealm();

  /**
   * Returns the value of the MME-Realm AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity getMMERealm();

  /**
   * Sets the value of the MME-Realm AVP, of type DiameterIdentity.
   *
   * @param mmeRealm
   * @throws IllegalStateException
   */
  void setMMERealm(DiameterIdentity mmeRealm) throws IllegalStateException;

  /**
   * Returns true if the MSC-Number AVP is present in the message.
   *
   * @return
   */
  boolean hasMSCNumber();

  /**
   * Returns the value of the MSC-Number AVP, of type OctetString.
   *
   * @return
   */
  byte[] getMSCNumber();

  /**
   * Sets the value of the MSC-Number AVP, of type OctetString.
   *
   * @param mscNumber
   * @throws IllegalStateException
   */
  void setMSCNumber(byte[] mscNumber) throws IllegalStateException;

  /**
   * Returns true if the 3GPP-AAA-Server-Name AVP is present in the message.
   *
   * @return
   */
  boolean has3GPPAAAServerName();

  /**
   * Returns the value of the 3GPP-AAA-Server-Name AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity get3GPPAAAServerName();

  /**
   * Sets the value of the 3GPP-AAA-Server-Name AVP, of type DiameterIdentity.
   *
   * @param tgppAAAServerName
   * @throws IllegalStateException
   */
  void set3GPPAAAServerName(DiameterIdentity tgppAAAServerName) throws IllegalStateException;

  /**
   * Returns true if the LCS-Capabilities-Sets AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSCapabilitiesSets();

  /**
   * Returns the value of the LCS-Capabilities-Sets AVP, of type Unsigned32.
   *
   * @return
   */
  long getLCSCapabilitiesSets();

  /**
   * Sets the value of the LCS-Capabilities-Sets AVP, of type Unsigned32.
   *
   * @param lcsCapabilitiesSets
   * @throws IllegalStateException
   */
  void setLCSCapabilitiesSets(long lcsCapabilitiesSets) throws IllegalStateException;

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
  byte[] getAdditionalServingNode();

  /**
   * Sets the value of the Serving-Node AVP, of type Grouped.
   *
   * @param additionalServingNode
   * @throws IllegalStateException
   */
  void setAdditionalServingNode(AdditionalServingNodeAvp additionalServingNode) throws IllegalStateException;

  /**
   * Returns true if the (Additional) SGSN-Number AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditionalSGSNNumber();

  /**
   * Returns the value of the (Additional) SGSN-Number AVP, of type OctetString.
   *
   * @return
   */
  byte[] getAdditionalSGSNNumber();

  /**
   * Sets the value of the (Additional) SGSN-Number AVP, of type OctetString.
   *
   * @param sgsnNumber
   * @throws IllegalStateException
   */
  void setAdditionalSGSNNumber(byte[] sgsnNumber) throws IllegalStateException;

  /**
   * Returns true if the (Additional) SGSN-Name AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditionalSGSNName();

  /**
   * Returns the value of the (Additional) SGSN-Name AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity getAdditionalSGSNName();

  /**
   * Sets the value of the (Additional) SGSN-Name AVP, of type DiameterIdentity.
   *
   * @param sgsnName
   * @throws IllegalStateException
   */
  void setAdditionalSGSNName(DiameterIdentity sgsnName) throws IllegalStateException;

  /**
   * Returns true if the (Additional) SGSN-Realm AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditionalSGSNRealm();

  /**
   * Returns the value of the (Additional) SGSN-Realm AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity getAdditionalSGSNRealm();

  /**
   * Sets the value of the (Additional) SGSN-Realm AVP, of type DiameterIdentity.
   *
   * @param sgsnRealm
   * @throws IllegalStateException
   */
  void setAdditionalSGSNRealm(DiameterIdentity sgsnRealm) throws IllegalStateException;

  /**
   * Returns true if the (Additional) MME-Name AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditionalMMEName();

  /**
   * Returns the value of the (Additional) MME-Name AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity getAdditionalMMEName();

  /**
   * Sets the value of the (Additional) MME-Name AVP, of type DiameterIdentity.
   *
   * @param mmeName
   * @throws IllegalStateException
   */
  void setAdditionalMMEName(DiameterIdentity mmeName) throws IllegalStateException;

  /**
   * Returns true if the (Additional) MME-Realm AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditionalMMERealm();

  /**
   * Returns the value of the (Additional) MME-Realm AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity getAdditionalMMERealm();

  /**
   * Sets the value of the (Additional) MME-Realm AVP, of type DiameterIdentity.
   *
   * @param mmeRealm
   * @throws IllegalStateException
   */
  void setAdditionalMMERealm(DiameterIdentity mmeRealm) throws IllegalStateException;

  /**
   * Returns true if the (Additional) MSC-Number AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditionalMSCNumber();

  /**
   * Returns the value of the (Additional) MSC-Number AVP, of type OctetString.
   *
   * @return
   */
  byte[] getAdditionalMSCNumber();

  /**
   * Sets the value of the (Additional) MSC-Number AVP, of type OctetString.
   *
   * @param mscNumber
   * @throws IllegalStateException
   */
  void setAdditionalMSCNumber(byte[] mscNumber) throws IllegalStateException;

  /**
   * Returns true if the (Additional) 3GPP-AAA-Server-Name AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditional3GPPAAAServerName();

  /**
   * Returns the value of the (Additional) 3GPP-AAA-Server-Name AVP, of type DiameterIdentity.
   *
   * @return
   */
  DiameterIdentity getAdditional3GPPAAAServerName();

  /**
   * Sets the value of the (Additional) 3GPP-AAA-Server-Name AVP, of type DiameterIdentity.
   *
   * @param tgppAAAServerName
   * @throws IllegalStateException
   */
  void setAdditional3GPPAAAServerName(DiameterIdentity tgppAAAServerName) throws IllegalStateException;

  /**
   * Returns true if the (Additional) LCS-Capabilities-Sets AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditionalLCSCapabilitiesSets();

  /**
   * Returns the value of the (Additional) LCS-Capabilities-Sets AVP, of type Unsigned32.
   *
   * @return
   */
  long getAdditionalLCSCapabilitiesSets();

  /**
   * Sets the value of the (Additional) LCS-Capabilities-Sets AVP, of type Unsigned32.
   *
   * @param lcsCapabilitiesSets
   * @throws IllegalStateException
   */
  void setAdditionalLCSCapabilitiesSets(long lcsCapabilitiesSets) throws IllegalStateException;

  /**
   * Returns true if the (Additional) GMLC-Address AVP is present in the message.
   *
   * @return
   */
  boolean hasAdditionalGMLCAddress();

  /**
   * Returns the value of the (Additional) GMLC-Address AVP, of type Address.
   *
   * @return
   */
  Address getAdditionalGMLCAddress();

  /**
   * Sets the value of the (Additional) GMLC-Address AVP, of type Address.
   *
   * @param gmlcAddress
   * @throws IllegalStateException
   */
  void setAdditionalGMLCAddress(Address gmlcAddress) throws IllegalStateException;

  /**
   * Returns true if the (Additional) GMLC-Address AVP is present in the message.
   *
   * @return
   */
  boolean hasPPRAddress();

  /**
   * Returns the value of the (Additional) PPR-Address AVP, of type Address.
   *
   * @return
   */
  Address getPPRAddress();

  /**
   * Sets the value of the (Additional) PPR-Address AVP, of type Address.
   *
   * @param pprAddress
   * @throws IllegalStateException
   */
  void setPPRAddress(Address pprAddress) throws IllegalStateException;

}

