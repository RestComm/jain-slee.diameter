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

package net.java.slee.resource.diameter.slg.events;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.base.events.avp.FailedAvp;
import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;
import net.java.slee.resource.diameter.slg.events.avp.*;

/**
 * Interface for ProvideLocationAnswer type of message. It has following structure:
 *
 * < Provide-Location-Request> ::=	< Diameter Header: 8388620, REQ, PXY, 16777255 >
 *
 *                                  < Session-Id >
 *                                  [ Vendor-Specific-Application-Id ]
 *                                  [ Result-Code ]
 *                                  [ Experimental-Result ]
 *                                  { Auth-Session-State }
 *                                  { Origin-Host }
 *                                  { Origin-Realm }
 *                                  [ Location-Estimate ]
 *                                  [ Accuracy-Fulfilment-Indicator ]
 *                                  [ Age-Of-Location-Estimate]
 *                                  [ Velocity-Estimate ]
 *                                  [ EUTRAN-Positioning-Data]
 *                                  [ ECGI ]
 *                                  [ GERAN-Positioning-Info ]
 *                                  [ Cell-Global-Identity ]
 *                                  [ UTRAN-Positioning-Info ]
 *                                  [ Service-Area-Identity ]
 *                                  [ Serving-Node ]
 *                                  [ PLA-Flags ]
 *                                  [ ESMLC-Cell-Info ]
 *                                  [ Civic-Address ]
 *                                  [ Barometric-Pressure ]
 *                                  *[ Supported-Features ]
 *                                  *[ AVP ]
 *                                  *[ Failed-AVP ]
 *                                  *[ Proxy-Info ]
 *                                  *[ Route-Record ]
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface ProvideLocationAnswer extends DiameterMessage {

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
   * Returns true if the Location-Estimate AVP is present in the message.
   *
   * @return
   */
  boolean hasLocationEstimate();

  /**
   * Returns the value of the Location-Estimate AVP, of type OctetString.
   *
   * @return
   */
  byte[] getLocationEstimate();

  /**
   * Sets the value of the Location-Estimate AVP, of type OctetString.
   *
   * @param locationEstimate
   * @throws IllegalStateException
   */
  void setLocationEstimate(byte[] locationEstimate) throws IllegalStateException;

  /**
   * Returns true if the Accuracy-Fulfilment-Indicator AVP is present in the message.
   *
   * @return
   */
  boolean hasAccuracyFulfilmentIndicator();

  /**
   * Returns the value of the Accuracy-Fulfilment-Indicator AVP, of type Enumerated.
   *
   * @return
   */
  AccuracyFulfilmentIndicator getAccuracyFulfilmentIndicator();

  /**
   * Sets the value of the Accuracy-Fulfilment-Indicator AVP, of type Enumerated.
   *
   * @param accuracyFulfilmentIndicator
   * @throws IllegalStateException
   */
  void setAccuracyFulfilmentIndicator(AccuracyFulfilmentIndicator accuracyFulfilmentIndicator) throws IllegalStateException;

  /**
   * Returns true if the Age-Of-Location-Estimate AVP is present in the message.
   *
   * @return
   */
  boolean hasAgeOfLocationEstimate();

  /**
   * Returns the value of the Age-Of-Location-Estimate AVP, of type Unsigned32.
   *
   * @return
   */
  long getAgeOfLocationEstimate();

  /**
   * Sets the value of the Age-Of-Location-Estimate AVP, of type Unsigned32.
   *
   * @param accuracyFulfilmentIndicator
   * @throws IllegalStateException
   */
  void setAgeOfLocationEstimate(long accuracyFulfilmentIndicator) throws IllegalStateException;

  /**
   * Returns true if the Velocity-Estimate AVP is present in the message.
   *
   * @return
   */
  boolean hasVelocityEstimate();

  /**
   * Returns the value of the Velocity-Estimate AVP, of type OctetString.
   *
   * @return
   */
  byte[] getVelocityEstimate();

  /**
   * Sets the value of the Velocity-Estimate AVP, of type OctetString.
   *
   * @param velocityEstimate
   * @throws IllegalStateException
   */
  void setVelocityEstimate(byte[] velocityEstimate) throws IllegalStateException;

  /**
   * Returns true if the EUTRAN-Positioning-Data AVP is present in the message.
   *
   * @return
   */
  boolean hasEUTRANPositioningData();

  /**
   * Returns the value of the Velocity-Estimate AVP, of type OctetString.
   *
   * @return
   */
  byte[] getEUTRANPositioningData();

  /**
   * Sets the value of the Velocity-Estimate AVP, of type OctetString.
   *
   * @param eUTRANPositioningData
   * @throws IllegalStateException
   */
  void setEUTRANPositioningData(byte[] eUTRANPositioningData) throws IllegalStateException;

  /**
   * Returns true if the ECGI AVP is present in the message.
   *
   * @return
   */
  boolean hasECGI();

  /**
   * Returns the value of the ECGI AVP, of type OctetString.
   *
   * @return
   */
  byte[] getECGI();

  /**
   * Sets the value of the ECGI AVP, of type OctetString.
   *
   * @param ecgi
   * @throws IllegalStateException
   */
  void setECGI(byte[] ecgi) throws IllegalStateException;

  /**
   * Returns true if the GERAN-Positioning-Info AVP is present in the message.
   *
   * @return
   */
  boolean hasGERANPositioningInfo();

  /**
   * Returns the value of the GERAN-Positioning-Info AVP, of type Grouped.
   *
   * @return
   */
  GERANPositioningInfoAvp getGERANPositioningInfo();

  /**
   * Sets the value of the GERAN-Positioning-Info AVP, of type Grouped.
   *
   * @param geranPositioningInfo
   * @throws IllegalStateException
   */
  void setGERANPositioningInfo(GERANPositioningInfoAvp geranPositioningInfo) throws IllegalStateException;

  /**
   * Returns true if the GERAN-Positioning-Data AVP is present in the message.
   *
   * @return
   */
  boolean hasGERANPositioningData();

  /**
   * Returns the value of the GERAN-Positioning-Data AVP, of type OctetString.
   *
   * @return
   */
  byte[] getGERANPositioningData();

  /**
   * Sets the value of the GERAN-Positioning-Data AVP, of type OctetString.
   *
   * @param geranPositioningData
   * @throws IllegalStateException
   */
  void setGERANPositioningData(byte[] geranPositioningData) throws IllegalStateException;

  /**
   * Returns true if the GERAN-GANSS-Positioning-Data AVP is present in the message.
   *
   * @return
   */
  boolean hasGERANGANSSPositioningData();

  /**
   * Returns the value of the GERAN-GANSS-Positioning-Data AVP, of type OctetString.
   *
   * @return
   */
  byte[] getGERANGANSSPositioningData();

  /**
   * Sets the value of the GERAN-GANSS-Positioning-Data AVP, of type OctetString.
   *
   * @param geranGanssPositioningData
   * @throws IllegalStateException
   */
  void setGERANGANSSPositioningData(byte[] geranGanssPositioningData) throws IllegalStateException;

  /**
   * Returns true if the Cell-Global-Identity AVP is present in the message.
   *
   * @return
   */
  boolean hasCellGlobalIdentity();

  /**
   * Returns the value of the Cell-Global-Identity AVP, of type OctetString.
   *
   * @return
   */
  byte[] getCellGlobalIdentity();

  /**
   * Sets the value of the Cell-Global-Identity AVP, of type OctetString.
   *
   * @param cellGlobalIdentity
   * @throws IllegalStateException
   */
  void setCellGlobalIdentity(byte[] cellGlobalIdentity) throws IllegalStateException;

  /**
   * Returns true if the UTRAN-Positioning-Info AVP is present in the message.
   *
   * @return
   */
  boolean hasUTRANPositioningInfo();

  /**
   * Returns the value of the UTRAN-Positioning-Info AVP, of type Grouped.
   *
   * @return
   */
  UTRANPositioningInfoAvp getUTRANPositioningInfo();

  /**
   * Sets the value of the UTRAN-Positioning-Info AVP, of type Grouped.
   *
   * @param utranPositioningInfo
   * @throws IllegalStateException
   */
  void setUTRANPositioningInfo(UTRANPositioningInfoAvp utranPositioningInfo) throws IllegalStateException;

  /**
   * Returns true if the UTRAN-Positioning-Data AVP is present in the message.
   *
   * @return
   */
  boolean hasUTRANPositioningData();

  /**
   * Returns the value of the UTRAN-Positioning-Data AVP, of type OctetString.
   *
   * @return
   */
  byte[] getUTRANPositioningData();

  /**
   * Sets the value of the UTRAN-Positioning-Data AVP, of type OctetString.
   *
   * @param utranPositioningData
   * @throws IllegalStateException
   */
  void setUTRANPositioningData(byte[] utranPositioningData) throws IllegalStateException;

  /**
   * Returns true if the UTRAN-GANSS-Positioning-Data AVP is present in the message.
   *
   * @return
   */
  boolean hasUTRANGANSSPositioningData();

  /**
   * Returns the value of the UTRAN-GANSS-Positioning-Data AVP, of type OctetString.
   *
   * @return
   */
  byte[] getUTRANGANSSPositioningData();

  /**
   * Sets the value of the UTRAN-GANSS-Positioning-Data AVP, of type OctetString.
   *
   * @param utranGanssPositioningData
   * @throws IllegalStateException
   */
  void setUTRANGANSSPositioningData(byte[] utranGanssPositioningData) throws IllegalStateException;

  /**
   * Returns true if the UTRAN-Additional-Positioning-Data AVP is present in the message.
   *
   * @return
   */
  boolean hasUTRANAdditionalPositioningData();

  /**
   * Returns the value of the UTRAN-Additional-Positioning-Data AVP, of type OctetString.
   *
   * @return
   */
  byte[] getUTRANAdditionalPositioningData();

  /**
   * Sets the value of the UTRAN-Additional-Positioning-Data AVP, of type OctetString.
   *
   * @param utranAdditionalPositioningData
   * @throws IllegalStateException
   */
  void setUTRANAdditionalPositioningData(byte[] utranAdditionalPositioningData) throws IllegalStateException;

  /**
   * Returns true if the Service-Area-Identity AVP is present in the message.
   *
   * @return
   */
  boolean hasServiceAreaIdentity();

  /**
   * Returns the value of the Service-Area-Identity AVP, of type OctetString.
   *
   * @return
   */
  byte[] getServiceAreaIdentity();

  /**
   * Sets the value of the Service-Area-Identity AVP, of type OctetString.
   *
   * @param serviceAreaIdentity
   * @throws IllegalStateException
   */
  void setServiceAreaIdentity(byte[] serviceAreaIdentity) throws IllegalStateException;

  /**
   * Returns true if the Serving-Node AVP is present in the message.
   *
   * @return
   */
  boolean hasServingNode();

  /**
   * Returns the value of the Serving-Node AVP, of type OctetString.
   *
   * @return
   */
  ServingNodeAvp getServingNode();

  /**
   * Sets the value of the Serving-Node AVP, of type OctetString.
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
  byte[] getSGSNNumber();

  /**
   * Sets the value of the SGSN-Number AVP, of type OctetString.
   *
   * @param sgsnNumber
   * @throws IllegalStateException
   */
  void setSGSNNumber(byte[] sgsnNumber) throws IllegalStateException;

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
   * Returns true if the SGSN-Realm AVP is present in the message.
   *
   * @return
   */
  boolean hasSGSNRealm();

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
   * Returns the value of the 3GPP-AAA-Server-Name, of type DiameterIdentity.
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
   * Returns the value of the LCS-Capabilities-Sets, of type Unsigned32.
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
   * Returns the value of the GMLC-Address, of type Address.
   *
   * @return
   */
  Address getGMLCAddress();

  /**
   * Sets the value of the GMLC-Address AVP, of type Address.
   *
   * @param gmlcAddress
   * @throws IllegalStateException
   */
  void setGMLCAddress(Address gmlcAddress) throws IllegalStateException;

  /**
   * Returns true if the PLA-Flags AVP is present in the message.
   *
   * @return
   */
  boolean hasPLAFlags();

  /**
   * Returns the value of the PLA-Flags, of type Unsigned32.
   *
   * @return
   */
  long getPLAFlags();

  /**
   * Sets the value of the PLA-Flags AVP, of type Unsigned32.
   *
   * @param plaFlags
   * @throws IllegalStateException
   */
  void setPLAFlags(long plaFlags) throws IllegalStateException;

  /**
   * Returns true if the ESMLC-Cell-Info AVP is present in the message.
   *
   * @return
   */
  boolean hasESMLCCellInfo();

  /**
   * Returns the value of the ESMLC-Cell-Info, of type Grouped.
   *
   * @return
   */
  ESMLCCellInfoAvp getESMLCCellInfo();

  /**
   * Sets the value of the ESMLC-Cell-Info AVP, of type Grouped.
   *
   * @param eSMLCCellInfo
   * @throws IllegalStateException
   */
  void setESMLCCellInfo(ESMLCCellInfoAvp eSMLCCellInfo) throws IllegalStateException;

  /**
   * Returns true if the Cell-Portion-ID AVP is present in the message.
   *
   * @return
   */
  boolean hasCellPortionID();

  /**
   * Returns the value of the Cell-Portion-ID, of type Unsigned32.
   *
   * @return
   */
  long getCellPortionID();

  /**
   * Sets the value of the Cell-Portion-ID AVP, of type Unsigned32.
   *
   * @param cellPortionID
   * @throws IllegalStateException
   */
  void setCellPortionID(long cellPortionID) throws IllegalStateException;

  /**
   * Returns true if the Civic-Address AVP is present in the message.
   *
   * @return
   */
  boolean hasCivicAddress();

  /**
   * Returns the value of the Civic-Address AVP, of type OctetString.
   *
   * @return
   */
  byte[] getCivicAddress();

  /**
   * Sets the value of the Civic-Address AVP, of type OctetString.
   *
   * @param civicAddress
   * @throws IllegalStateException
   */
  void setCivicAddress(byte[] civicAddress) throws IllegalStateException;

  /**
   * Returns true if the Barometric-Pressure AVP is present in the message.
   *
   * @return
   */
  boolean hasBarometricPressure();

  /**
   * Returns the value of the Barometric-Pressure, of type Unsigned32.
   *
   * @return
   */
  long getBarometricPressure();

  /**
   * Sets the value of the Barometric-Pressure AVP, of type Unsigned32.
   *
   * @param barometricPressure
   * @throws IllegalStateException
   */
  void setBarometricPressure(long barometricPressure) throws IllegalStateException;

}