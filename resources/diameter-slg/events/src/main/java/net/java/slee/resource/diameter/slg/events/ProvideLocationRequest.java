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

import java.util.Date;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.VendorSpecificApplicationIdAvp;
import net.java.slee.resource.diameter.slg.events.avp.*;


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
 *                                  {Destination-Host }
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
 *                                  [LCS-Supported-GAD-Shapes ]
 *                                  [ LCS-Service-Type-ID ]
 *                                  [ LCS-Codeword ]
 *                                  [ LCS-Privacy-Check-Non-Session ]
 *                                  [ LCS-Privacy-Check-Session ]
 *                                  [Service-Selection ]
 *                                  [ Deferred-Location-Type ]
 *                                  [ PLR-Flags ]
 *                                  *[ Supported-Features ]
 *                                  *[ AVP ]
 *                                  *[ Proxy-Info ]
 *                                  *[ Route-Record ]
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 * */
public interface ProvideLocationRequest extends DiameterMessage {

  static final int COMMAND_CODE = 8388620;

//  /**
//   * Returns true if the Vendor-Specific-Application-Id AVP is present in the message.
//   *
//   * @return true if the Vendor-Specific-Application-Id AVP is present in the message, false otherwise
//   */
//  public boolean hasVendorSpecificApplicationId();
//
//  /**
//   * Returns the value of the Vendor-Specific-Application-Id AVP, of type Grouped.
//   *
//   * @return the value of the Vendor-Specific-Application-Id AVP or null if it has not been set on this message
//   */
//  public VendorSpecificApplicationIdAvp getVendorSpecificApplicationId();
//
//  /**
//   * Sets the value of the Vendor-Specific-Application-Id AVP, of type Grouped.
//   *
//   * @param vendorSpecificApplicationId the new value for the Vendor-Specific-Application-Id AVP
//   */
//  public void setVendorSpecificApplicationId(VendorSpecificApplicationIdAvp vendorSpecificApplicationId);

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
  void setLCSEPSClientNameAvp(LCSEPSClientNameAvp lcsEpsClientName) throws IllegalStateException;

  /**
   * Returns true if the LCS-Name-String AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSNameString();

  /**
   * Returns the value of the LCS-Name-String AVP, of type UTF8String.
   *
   * @return
   */
  String getLCSNameString();

  /**
   * Sets the value of the LCS-Name-String AVP, of type UTF8String.
   *
   * @param lcsNameString
   * @throws IllegalStateException
   */
  void setLCSNameString(String lcsNameString) throws IllegalStateException;

  /**
   * Returns true if the LCS-Format-Indicator AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSFormatIndicator();

  /**
   * Returns the value of the LCS-Format-Indicator AVP, of type Enumerated.
   *
   * @return
   */
  LCSFormatIndicator getLCSFormatIndicator();

  /**
   * Sets the value of the LCS-Format-Indicator AVP, of type Enumerated.
   *
   * @param lcsFormatIndicator
   * @throws IllegalStateException
   */
  void setLCSFormatIndicator(LCSFormatIndicator lcsFormatIndicator) throws IllegalStateException;

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
   * Sets the value of the LCS-Requestor-Name AVP, of type Grouped.
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
   * Returns true if the Horizontal-Accuracy AVP is present in the message.
   *
   * @return
   */
  boolean hasHorizontalAccuracy();

  /**
   * Returns the value of the Horizontal-Accuracy AVP, of type Unsigned32.
   *
   * @return
   */
  long getHorizontalAccuracy();

  /**
   * Sets the value of the Horizontal-Accuracy AVP, of type Unsigned32.
   *
   * @param horizontalAccuracy
   * @throws IllegalStateException
   */
  void setHorizontalAccuracy(long horizontalAccuracy) throws IllegalStateException;

  /**
   * Returns true if the Vertical-Accuracy AVP is present in the message.
   *
   * @return
   */
  boolean hasVerticalAccuracy();

  /**
   * Returns the value of the Vertical-Accuracy AVP, of type Unsigned32.
   *
   * @return
   */
  long getVerticalAccuracy();

  /**
   * Sets the value of the Vertical-Accuracy AVP, of type Unsigned32.
   *
   * @param verticalAccuracy
   * @throws IllegalStateException
   */
  void setVerticalAccuracy(long verticalAccuracy) throws IllegalStateException;

  /**
   * Returns true if the Response-Time AVP is present in the message.
   *
   * @return
   */
  boolean hasResponseTime();

  /**
   * Returns the value of the Response-Time AVP, of type Enumerated.
   *
   * @return
   */
  ResponseTime getResponseTime();

  /**
   * Sets the value of the Response-Time AVP, of type Enumerated.
   *
   * @param responseTime
   * @throws IllegalStateException
   */
  void setResponseTime(ResponseTime responseTime) throws IllegalStateException;

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

}
