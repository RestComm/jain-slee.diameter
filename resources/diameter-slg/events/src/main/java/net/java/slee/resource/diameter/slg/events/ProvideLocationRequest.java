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
import net.java.slee.resource.diameter.slg.events.avp.AreaEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.MotionEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvp;
import net.java.slee.resource.diameter.slg.events.avp.SLgLocationType;
import net.java.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSClientType;
import net.java.slee.resource.diameter.slg.events.avp.LCSRequestorNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSAvp;
import net.java.slee.resource.diameter.slg.events.avp.VelocityRequested;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckNonSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp;

/**
 * Interface for ProvideLocationRequest type of message. It has following structure:
 *
 * < Provide-Location-Request> ::=	< Diameter Header: 8388620, REQ, PXY, 16777255 >
 *
 *                                  < Session-Id >
 *                                  [ Vendor-Specific-Application-Id ]
 *                                  { Auth-Session-State }
 *                                  { Origin-Host }
 *                                  { Origin-Realm }
 *                                  { Destination-Host }
 *                                  { Destination-Realm }
 *                                  { SLg-Location-Type }
 *                                  [ User-Name ]
 *                                  [ MSISDN]
 *                                  [ IMEI ]
 *                                  { LCS-EPS-Client-Name }
 *                                  { LCS-Client-Type }
 *                                  [ LCS-Requestor-Name ]
 *                                  [ LCS-Priority ]
 *                                  [ LCS-QoS ]
 *                                  [ Velocity-Requested ]
 *                                  [ LCS-Supported-GAD-Shapes ]
 *                                  [ LCS-Service-Type-ID ]
 *                                  [ LCS-Codeword ]
 *                                  [ LCS-Privacy-Check-Non-Session ]
 *                                  [ LCS-Privacy-Check-Session ]
 *                                  [ Service-Selection ]
 *                                  [ Deferred-Location-Type ]
 *                                  [ PLR-Flags ]
 *                                  *[ Supported-Features ]
 *                                  *[ AVP ]
 *                                  *[ Proxy-Info ]
 *                                  *[ Route-Record ]
 *                                  Note: plus all extra AVPs defined in Table 6.2.2-1: Provide Subscriber Location Request, i.e.
 * 	                                [ LCS-Reference-Number ]
 * 	                                [ Area-Event-Info ]
 * 	                                [ GMLC-Address ]
 * 	                                [ Periodic-LDR-Information ]
 * 	                                [ Reporting-PLMN-List ]
 * 	                                [ Motion-Event-Info ]
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * */
public interface ProvideLocationRequest extends DiameterMessage {

  static final int COMMAND_CODE = 8388620;

  /**
   * Returns true if the Vendor-Specific-Application-Id AVP is present in the message.
   *
   * @return true if the Vendor-Specific-Application-Id AVP is present in the message, false otherwise
   */
  boolean hasVendorSpecificApplicationId();

  /**
   * Returns the value of the Vendor-Specific-Application-Id AVP, of type Grouped.
   *
   * @return the value of the Vendor-Specific-Application-Id AVP or null if it has not been set on this message
   */
  VendorSpecificApplicationIdAvp getVendorSpecificApplicationId();

  /**
   * Sets the value of the Vendor-Specific-Application-Id AVP, of type Grouped.
   *
   * @param vendorSpecificApplicationId the new value for the Vendor-Specific-Application-Id AVP
   */
  void setVendorSpecificApplicationId(VendorSpecificApplicationIdAvp vendorSpecificApplicationId);

  /**
   * Returns true if the Auth-Session-State AVP is present in the message.
   *
   * @return true if the Auth-Session-State AVP is present in the message, false otherwise
   */
  boolean hasAuthSessionState();

  /**
   * Returns the value of the Auth-Session-State AVP, of type Enumerated.
   *
   * @return the value of the Auth-Session-State AVP, of type Enumerated
   */
  AuthSessionStateType getAuthSessionState();

  /**
   * Sets the value of the Auth-Session-State AVP, of type Enumerated.
   *
   * @param authSessionState
   */
  void setAuthSessionState(AuthSessionStateType authSessionState);

  /**
   * Returns true if the SLg-Location-Type AVP is present in the message.
   *
   * @return
   */
  boolean hasSLgLocationType();

  /**
   * Returns the value of the SLg-Location-Type AVP, of type Enumerated.
   *
   * @return
   */
  SLgLocationType getSLgLocationType();

  /**
   * Sets the value of the SLg-Location-Type AVP, of type Enumerated.
   *
   * @param slgLocationType
   * @throws IllegalStateException
   */
  void setSLgLocationType(SLgLocationType slgLocationType) throws IllegalStateException;

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
   * Returns true if the LCS-Client-Type AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSClientType();

  /**
   * Returns the value of the LCS-Client-Type AVP, of type Enumerated.
   *
   * @return
   */
  LCSClientType getLCSClientType();

  /**
   * Sets the value of the LCS-Client-Type AVP, of type Enumerated.
   *
   * @param lcsClientType
   * @throws IllegalStateException
   */
  void setLCSClientType(LCSClientType lcsClientType) throws IllegalStateException;

  /**
   * Returns true if the LCS-Requestor-Name AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSRequestorName();

  /**
   * Returns the value of the LCS-Requestor-Name AVP, of type Grouped.
   *
   * @return
   */
  LCSRequestorNameAvp getLCSRequestorName();

  /**
   * Sets the value of the LCS-Requestor-Id-String AVP, of type Grouped.
   *
   * @param lcsRequestorName
   * @throws IllegalStateException
   */
  void setLCSRequestorName(LCSRequestorNameAvp lcsRequestorName) throws IllegalStateException;

  /**
   * Returns true if the LCS-Priority AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSPriority();

  /**
   * Returns the value of the LCS-Priority AVP, of type Unsigned32.
   *
   * @return
   */
  long getLCSPriority();

  /**
   * Sets the value of the LCS-Priority AVP, of type Unsigned32.
   *
   * @param lcsRequestorName
   * @throws IllegalStateException
   */
  void setLCSPriority(long lcsRequestorName) throws IllegalStateException;

  /**
   * Returns true if the LCS-QoS AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSQoS();

  /**
   * Returns the value of the LCS-QoS AVP, of type Grouped.
   *
   * @return
   */
  LCSQoSAvp getLCSQoS();

  /**
   * Sets the value of the LCS-QoS AVP, of type Grouped.
   *
   * @param lcsQoS
   * @throws IllegalStateException
   */
  void setLCSQoS(LCSQoSAvp lcsQoS) throws IllegalStateException;

  /**
   * Returns true if the Velocity-Requested AVP is present in the message.
   *
   * @return
   */
  boolean hasVelocityRequested();

  /**
   * Returns the value of the Velocity-Requested AVP, of type Enumerated.
   *
   * @return
   */
  VelocityRequested getVelocityRequested();

  /**
   * Sets the value of the Velocity-Requested AVP, of type Enumerated.
   *
   * @param lcsVelocityRequested
   * @throws IllegalStateException
   */
  void setVelocityRequested(VelocityRequested lcsVelocityRequested) throws IllegalStateException;

  /**
   * Returns true if the LCS-Supported-GAD-Shapes AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSSupportedGADShapes();

  /**
   * Returns the value of the LCS-Supported-GAD-Shapes AVP, of type Unsigned32 .
   *
   * @return
   */
  long getLCSSupportedGADShapes();

  /**
   * Sets the value of the LCS-Supported-GAD-Shapes AVP, of type Unsigned32 .
   *
   * @param lcsSupportedGADShapes
   * @throws IllegalStateException
   */
  void setLCSSupportedGADShapes(long lcsSupportedGADShapes) throws IllegalStateException;

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
   * Returns true if the LCS-Codeword AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSCodeword();

  /**
   * Returns the value of the LCS-Codeword AVP, of type UTF8String .
   *
   * @return
   */
  String getLCSCodeword();

  /**
   * Sets the value of the LCS-Codeword AVP, of type UTF8String .
   *
   * @param lcsCodeword
   * @throws IllegalStateException
   */
  void setLCSCodeword(String lcsCodeword) throws IllegalStateException;

  /**
   * Returns true if the LCS-Privacy-Check-Non-Session AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSPrivacyCheckNonSession();

  /**
   * Returns the value of the LCS-Privacy-Check-Non-Session AVP, of type Grouped .
   *
   * @return
   */
  LCSPrivacyCheckNonSessionAvp getLCSPrivacyCheckNonSession();

  /**
   * Sets the value of the LCS-Privacy-Check-Non-Session AVP, of type Grouped .
   *
   * @param lcsPrivacyCheckNonSession
   * @throws IllegalStateException
   */
  void setLCSPrivacyCheckNonSession(LCSPrivacyCheckNonSessionAvp lcsPrivacyCheckNonSession) throws IllegalStateException;

  /**
   * Returns true if the LCS-Privacy-Check-Session AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSPrivacyCheckSession();

  /**
   * Returns the value of the LCS-Privacy-Check-Session AVP, of type Grouped .
   *
   * @return
   */
  LCSPrivacyCheckSessionAvp getLCSPrivacyCheckSession();

  /**
   * Sets the value of the LCS-Privacy-Check-Session AVP, of type Grouped .
   *
   * @param lcsPrivacyCheckSession
   * @throws IllegalStateException
   */
  void setLCSPrivacyCheckSession(LCSPrivacyCheckSessionAvp lcsPrivacyCheckSession) throws IllegalStateException;

  /**
   * Returns true if the Service-Selection AVP is present in the message.
   *
   * @return
   */
  boolean hasServiceSelection();

  /**
   * Returns the value of the Service-Selection AVP, of type UTF8String.
   *
   * @return
   */
  String getServiceSelection();

  /**
   * Sets the value of the Service-Selection AVP, of type UTF8String.
   *
   * @param serviceSelection
   * @throws IllegalStateException
   */
  void setServiceSelection(String serviceSelection) throws IllegalStateException;

  /**
   * Returns true if the Deferred-Location-Type AVP is present in the message.
   *
   * @return
   */
  boolean hasDeferredLocationType();

  /**
   * Returns the value of the Deferred-Location-Type AVP, of type Unsigned32.
   *
   * @return
   */
  long getDeferredLocationType();

  /**
   * Sets the value of the Deferred-Location-Type AVP, of type Unsigned32.
   *
   * @param deferredLocationType
   * @throws IllegalStateException
   */
  void setDeferredLocationType(long deferredLocationType) throws IllegalStateException;

  /**
   * Returns true if the PLR-Flags AVP is present in the message.
   *
   * @return
   */
  boolean hasPLRFlags();

  /**
   * Returns the value of the PLR-Flags AVP, of type Unsigned32.
   *
   * @return
   */
  long getPLRFlags();

  /**
   * Sets the value of the PLR-Flags AVP, of type Unsigned32.
   *
   * @param plrFlags
   * @throws IllegalStateException
   */
  void setPLRFlags(long plrFlags) throws IllegalStateException;

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
   * Returns true if the Area-Event-Info AVP is present in the message.
   *
   * @return
   */
  boolean hasAreaEventInfo();

  /**
   * Returns the value of the Area-Event-Info AVP, of type Grouped.
   *
   * @return
   */
  AreaEventInfoAvp getAreaEventInfo();

  /**
   * Sets the value of the Area-Event-Info AVP, of type Grouped.
   *
   * @param areaEventInfo
   * @throws IllegalStateException
   */
  void setAreaEventInfo(AreaEventInfoAvp areaEventInfo) throws IllegalStateException;

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
   * @param periodicLDRInfo
   * @throws IllegalStateException
   */
  void setPeriodicLDRInformation(PeriodicLDRInfoAvp periodicLDRInfo) throws IllegalStateException;

  /**
   * Returns true if the Reporting-PLMN-List AVP is present in the message.
   *
   * @return
   */
  boolean hasReportingPLMNList();

  /**
   * Returns the value of the Reporting-PLMN-List AVP, of type Grouped.
   *
   * @return
   */
  ReportingPLMNListAvp getReportingPLMNList();

  /**
   * Sets the value of the Reporting-PLMN-List AVP, of type Grouped.
   *
   * @param reportingPLMNList
   * @throws IllegalStateException
   */
  void setReportingPLMNList(ReportingPLMNListAvp reportingPLMNList) throws IllegalStateException;

  /**
   * Returns true if the Motion-Event-Info AVP is present in the message.
   *
   * @return
   */
  boolean hasMotionEventInfo();

  /**
   * Returns the value of the Motion-Event-Info AVP, of type Grouped.
   *
   * @return
   */
  MotionEventInfoAvp getMotionEventInfo();

  /**
   * Sets the value of the Motion-Event-Info AVP, of type Grouped.
   *
   * @param motionEventInfo
   * @throws IllegalStateException
   */
  void setMotionEventInfo(MotionEventInfoAvp motionEventInfo) throws IllegalStateException;

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
