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

package net.java.slee.resource.diameter.slg.events;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.VendorSpecificApplicationIdAvp;
import net.java.slee.resource.diameter.slg.events.avp.AccuracyFulfilmentIndicator;
import net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.PseudonymIndicator;
import net.java.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSClass;
import net.java.slee.resource.diameter.slg.events.avp.LocationEvent;
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.slg.events.avp.DeferredMTLRDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp;

/**
 * Interface for LocationReportRequest type of message. It has following structure:
 *
 * < Location-Report-Request> ::=	< Diameter Header: 8388621, REQ, PXY, 16777255 >
 *
 *                                  < Session-Id >
 *                                  [ Vendor-Specific-Application-Id ]
 *                                  { Auth-Session-State }
 *                                  { Origin-Host }
 *                                  { Origin-Realm }
 *                                  { Destination-Host }
 *                                  { Destination-Realm }
 *																	{ Location-Event }
 *                                  [ LCS-EPS-Client-Name ]
 *                                  [ User-Name ]
 *                                  [ MSISDN ]
 *                                  [ IMEI ]
 *                                  [ Location-Estimate ]
 *                                  [ Accuracy-Fulfilment-Indicator ]
 *                                  [ Age-Of-Location-Estimate ]
 *                                  [ Velocity-Estimate ]
 *                                  [ EUTRAN-Positioning-Data ]
 *                                  [ ECGI ]
 *                                  [ GERAN-Positioning-Info ]
 *                                  [ Cell-Global-Identity ]
 *                                  [ UTRAN-Positioning-Info ]
 *                                  [ Service-Area-Identity ]
 *                                  [ LCS-Service-Type-ID ]
 *                                  [ Pseudonym-Indicator ]
 *                                  [ LCS-QoS-Class ]
 *                                  [ Serving-Node ]
 *                                  [ LRR-Flags ]
 *                                  [ LCS-Reference-Number ]
 *                                  [ Deferred-MT-LR-Data ]
 *                                  [ GMLC-Address ]
 *                                  [ Reporting-Amount ]
 *                                  [ Periodic-LDR-Information ]
 *                                  [ ESMLC-Cell-Info ]
 *                                  [ 1xRTT-RCID ]
 *                                  [ Delayed-Location-Reporting-Data ]
 *                                  [ Civic-Address ]
 *                                  [ Barometric-Pressure ]
 *                                  *[ Supported-Features ]
 *                                  *[ AVP ]
 *                                  *[ Proxy-Info ]
 *                                  *[ Route-Record ]
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * */
public interface LocationReportRequest extends DiameterMessage {

  static final int COMMAND_CODE = 8388621;

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
   * Returns true if the Location-Event AVP is present in the message.
   *
   * @return
   */
  boolean hasLocationEvent();

  /**
   * Returns the value of the Location-Event AVP, of type Enumerated.
   *
   * @return
   */
  LocationEvent getLocationEvent();

  /**
   * Sets the value of the Location-Event AVP, of type Enumerated.
   *
   * @param locationEvent
   * @throws IllegalStateException
   */
  void setLocationEvent(LocationEvent locationEvent) throws IllegalStateException;

  /**
   * Returns true if the LCS-EPS-Client-Name AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSEPSClientName();

  /**
   * Returns the value of the LCS-EPS-Client-Name AVP, of type Grouped.
   *
   * @return
   */
  LCSEPSClientNameAvp getLCSEPSClientName();

  /**
   * Sets the value of the LCS-EPS-Client-Name AVP, of type Grouped.
   *
   * @param lcsEpsClientName
   * @throws IllegalStateException
   */
  void setLCSEPSClientName(LCSEPSClientNameAvp lcsEpsClientName) throws IllegalStateException;

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
   * Returns true if the IMEI AVP is present in the message.
   *
   * @return
   */
  boolean hasIMEI();

  /**
   * Returns the value of the IMEI AVP, of type UTF8String.
   *
   * @return
   */
  String getIMEI();

  /**
   * Sets the value of the IMEI AVP, of type UTF8String.
   *
   * @param imei
   * @throws IllegalStateException
   */
  void setIMEI(String imei) throws IllegalStateException;

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
   * Returns the value of the EUTRAN-Positioning-Data AVP, of type OctetString.
   *
   * @return
   */
  byte[] getEUTRANPositioningData();

  /**
   * Sets the value of the EUTRAN-Positioning-Data AVP, of type OctetString.
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
   * Returns true if the LCS-Service-Type-ID AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSServiceTypeID();

  /**
   * Returns the value of the LCS-Service-Type-ID AVP, of type Unsigned32 .
   *
   * @return
   */
  long getLCSServiceTypeID();

  /**
   * Sets the value of the LCS-Service-Type-ID AVP, of type Unsigned32 .
   *
   * @param lcsServiceTypeID
   * @throws IllegalStateException
   */
  void setLCSServiceTypeID(long lcsServiceTypeID) throws IllegalStateException;

  /**
   * Returns true if the Pseudonym-Indicator AVP is present in the message.
   *
   * @return
   */
  boolean hasPseudonymIndicator();

  /**
   * Returns the value of the Pseudonym-Indicator AVP, of type Enumerated.
   *
   * @return
   */
  PseudonymIndicator getPseudonymIndicator();

  /**
   * Sets the value of the Pseudonym-Indicator AVP, of type Enumerated.
   *
   * @param pseudonymIndicator
   * @throws IllegalStateException
   */
  void setPseudonymIndicator(PseudonymIndicator pseudonymIndicator) throws IllegalStateException;

  /**
   * Returns true if the LCS-QoS-Class AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSQoSClass();

  /**
   * Returns the value of the LCS-QoS-Class AVP, of type Enumerated.
   *
   * @return
   */
  LCSQoSClass getLCSQoSClass();

  /**
   * Sets the value of the LCS-QoS-Class AVP, of type Enumerated.
   *
   * @param lcsQoSClass
   * @throws IllegalStateException
   */
  void setLCSQoSClass(LCSQoSClass lcsQoSClass) throws IllegalStateException;

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
   * Returns true if the LRR-Flags AVP is present in the message.
   *
   * @return
   */
  boolean hasLRRFlags();

  /**
   * Returns the value of the LRR-Flags AVP, of type Unsigned32.
   *
   * @return
   */
  long getLRRFlags();

  /**
   * Sets the value of the LRR-Flags AVP, of type Unsigned32.
   *
   * @param lrrFlags
   * @throws IllegalStateException
   */
  void setLRRFlags(long lrrFlags) throws IllegalStateException;

  /**
   * Returns true if the LCS-Reference-Number AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSReferenceNumber();

  /**
   * Returns the value of the LCS-Reference-Number AVP, of type OctetString.
   *
   * @return
   */
  byte[] getLCSReferenceNumber();

  /**
   * Sets the value of the LCS-Reference-Number AVP, of type OctetString.
   *
   * @param lcsReferenceNumber
   * @throws IllegalStateException
   */
  void setLCSReferenceNumber(byte[] lcsReferenceNumber) throws IllegalStateException;

  /**
   * Returns true if the Deferred-MT-LR-Data AVP is present in the message.
   *
   * @return
   */
  boolean hasDeferredMTLRData();

  /**
   * Returns the value of the Deferred-MT-LR-Data AVP, of type .
   *
   * @return
   */
  DeferredMTLRDataAvp getDeferredMTLRData();

  /**
   * Sets the value of the Deferred-MT-LR-Data AVP, of type .
   *
   * @param deferredMTLRData
   * @throws IllegalStateException
   */
  void setDeferredMTLRData(DeferredMTLRDataAvp deferredMTLRData) throws IllegalStateException;

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
   * Returns true if the Reporting-Amount AVP is present in the message.
   *
   * @return
   */
  boolean hasReportingAmount();

  /**
   * Returns the value of the Reporting-Amount AVP, of type Unsigned32 .
   *
   * @return
   */
  long getReportingAmount();

  /**
   * Sets the value of the Reporting-Amount AVP, of type Unsigned32 .
   *
   * @param reportingAmount
   * @throws IllegalStateException
   */
  void setReportingAmount(long reportingAmount) throws IllegalStateException;

  /**
   * Returns true if the Periodic-LDR-Information AVP is present in the message.
   *
   * @return
   */
  boolean hasPeriodicLDRInformation();

  /**
   * Returns the value of the Periodic-LDR-Information AVP, of type Grouped.
   *
   * @return
   */
  PeriodicLDRInfoAvp getPeriodicLDRInformation();

  /**
   * Sets the value of the Periodic-LDR-Information AVP, of type Grouped.
   *
   * @param putParam
   * @throws IllegalStateException
   */
  void setPeriodicLDRInformation(PeriodicLDRInfoAvp putParam) throws IllegalStateException;

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
   * Returns true if the 1xRTT-RCID AVP is present in the message.
   *
   * @return
   */
  boolean has1xRTTRCID();

  /**
   * Returns the value of the 1xRTT-RCID AVP, of type OctetString.
   *
   * @return
   */
  byte[] get1xRTTRCID();

  /**
   * Sets the value of the 1xRTT-RCID AVP, of type OctetString.
   *
   * @param onexRTTRCID
   * @throws IllegalStateException
   */
  void set1xRTTRCID(byte[] onexRTTRCID) throws IllegalStateException;

  /**
   * Returns true if the Delayed-Location-Reporting-Data AVP is present in the message.
   *
   * @return
   */
  boolean hasDelayedLocationReportingData();

  /**
   * Returns the value of the Delayed-Location-Reporting-Data AVP, of type Grouped.
   *
   * @return
   */
  DelayedLocationReportingDataAvp getDelayedLocationReportingData();

  /**
   * Sets the value of the Delayed-Location-Reporting-Data AVP, of type Grouped.
   *
   * @param delayedLocationReportingData
   * @throws IllegalStateException
   */
  void setDelayedLocationReportingData(DelayedLocationReportingDataAvp delayedLocationReportingData) throws IllegalStateException;

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

  /**
   * Returns the value of the Supported-Features AVP, of type Grouped.
   *
   * @return
   */
  public SupportedFeaturesAvp[] getSupportedFeatureses();

  /**
   * Set a single instance value of the Supported-Features AVP, of type Grouped.
   *
   * @param supportedFeatures
   */
  public void setSupportedFeatures(SupportedFeaturesAvp supportedFeatures);

  /**
   * Set multiple instance value of the Supported-Features AVP, of type Grouped.
   *
   * @param supportedFeatureses
   */
  public void setSupportedFeatureses(SupportedFeaturesAvp[] supportedFeatureses);

}
