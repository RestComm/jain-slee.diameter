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

package org.mobicents.slee.resource.diameter.slg.events;

import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.slg.events.ProvideLocationRequest;
import org.jdiameter.api.Message;

import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import net.java.slee.resource.diameter.slg.events.avp.*;

/**
 * Implementation for {@link ProvideLocationRequest}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class ProvideLocationRequestImpl extends DiameterMessageImpl implements ProvideLocationRequest {

  /**
   * @param message
   */
  public ProvideLocationRequestImpl(Message message) {
    super(message);
  }

  /* (non-Javadoc)
     * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasAuthSessionState()
     */
  public boolean hasAuthSessionState() {
    return hasAvp(DiameterAvpCodes.AUTH_SESSION_STATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getAuthSessionState()
   */
  public AuthSessionStateType getAuthSessionState() {
    return (AuthSessionStateType) getAvpAsEnumerated(DiameterAvpCodes.AUTH_SESSION_STATE, AuthSessionStateType.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setAuthSessionState(net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType)
   */
  public void setAuthSessionState(AuthSessionStateType authSessionState) {
    addAvp(DiameterAvpCodes.AUTH_SESSION_STATE, authSessionState.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasSLgLocationType()
   */
  @Override
  public boolean hasSLgLocationType() {
    return hasAvp(EPCLocationProtocolAVPCodes.SLg_LOCATION_TYPE);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getSLgLocationType()
   */
  @Override
  public SLgLocationType getSLgLocationType() {
    return (SLgLocationType) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.SLg_LOCATION_TYPE, SLgLocationType.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setSLgLocationType()
   */
  @Override
  public void setSLgLocationType(SLgLocationType slgLocationType) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.SLg_LOCATION_TYPE, slgLocationType.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasUserName()
   */
  @Override
  public boolean hasUserName() {
    return hasAvp(EPCLocationProtocolAVPCodes.USER_NAME);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getUserName()
   */
  @Override
  public String getUserName() {
    return getAvpAsUTF8String(EPCLocationProtocolAVPCodes.USER_NAME);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setUserName()
   */
  @Override
  public void setUserName(String imsi) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.USER_NAME, imsi);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasMSISDN()
   */
  @Override
  public boolean hasMSISDN() {
    return hasAvp(EPCLocationProtocolAVPCodes.MSISDN);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getMSISDN()
   */
  @Override
  public byte[] getMSISDN() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.MSISDN);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setMSISDN()
   */
  @Override
  public void setMSISDN(byte[] msisdn) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.MSISDN, msisdn);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasIMEI()
   */
  @Override
  public boolean hasIMEI() {
    return hasAvp(EPCLocationProtocolAVPCodes.IMEI);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getUserName()
   */
  @Override
  public String getIMEI() {
    return getAvpAsUTF8String(EPCLocationProtocolAVPCodes.IMEI);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setUserName()
   */
  @Override
  public void setIMEI(String imei) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.IMEI, imei);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSEPSClientName()
   */
  @Override
  public boolean hasLCSEPSClientName() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_EPS_CLIENT_NAME);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSEPSClientName()
   */
  @Override
  public LCSEPSClientNameAvp getLCSEPSClientName() {
    return (LCSEPSClientNameAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.LCS_EPS_CLIENT_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, LCSEPSClientNameAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSEPSClientName()
   */
  @Override
  public void setLCSEPSClientNameAvp(LCSEPSClientNameAvp lcsEPSClientName) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_EPS_CLIENT_NAME, lcsEPSClientName);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSNameString()
   */
  @Override
  public boolean hasLCSNameString() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_NAME_STRING);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSNameString()
   */
  @Override
  public String getLCSNameString() {
    return getAvpAsUTF8String(EPCLocationProtocolAVPCodes.LCS_NAME_STRING, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSNameString()
   */
  @Override
  public void setLCSNameString(String lcsNameString) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_NAME_STRING, lcsNameString);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSFormatIndicator()
   */
  @Override
  public boolean hasLCSFormatIndicator() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_FORMAT_INDICATOR);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSFormatIndicator()
   */
  @Override
  public LCSFormatIndicator getLCSFormatIndicator() {
    return (LCSFormatIndicator) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.LCS_FORMAT_INDICATOR, LCSFormatIndicator.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLocationEvent()
   */
  @Override
  public void setLCSFormatIndicator(LCSFormatIndicator lcsFormatIndicator) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_FORMAT_INDICATOR, lcsFormatIndicator.getValue());
  }


  /*
    * (non-Javadoc)
    * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSClientType()
   */
  @Override
  public boolean hasLCSClientType() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_CLIENT_TYPE);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSClientType()
   */
  @Override
  public LCSClientType getLCSClientType() {
    return (LCSClientType) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.LCS_CLIENT_TYPE, LCSClientType.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSClientType()
   */
  @Override
  public void setLCSClientType(LCSClientType lcsClientType) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_CLIENT_TYPE, lcsClientType.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSRequestorName()
   */
  @Override
  public boolean hasLCSRequestorName() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_REQUESTOR_NAME);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSRequestorName()
   */
  @Override
  public LCSRequestorNameAvp getLCSRequestorName() {
    return (LCSRequestorNameAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.LCS_REQUESTOR_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, LCSRequestorNameAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSRequestorName()
   */
  @Override
  public void setLCSRequestorName(LCSRequestorNameAvp lcsRequestorName) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_REQUESTOR_NAME, lcsRequestorName);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#LCSPriority()
   */
  @Override
  public boolean hasLCSPriority() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_PRIORITY);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSPriority()
   */
  @Override
  public long getLCSPriority() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LCS_PRIORITY);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSPriority()
   */
  @Override
  public void setLCSPriority(long lcsPriority) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_PRIORITY, lcsPriority);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSQoS()
   */
  @Override
  public boolean hasLCSQoS() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_QoS);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSQoS()
   */
  @Override
  public LCSQoSAvp getLCSQoS() {
    return (LCSQoSAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, LCSQoSAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSQoS()
   */
  @Override
  public void setLCSQoS(LCSQoSAvp lcsQoS) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_QoS, lcsQoS);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSQoSClass()
   */
  @Override
  public boolean hasLCSQoSClass() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_QoS_CLASS);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSQoSClass()
   */
  @Override
  public LCSQoSClass getLCSQoSClass() {
    return (LCSQoSClass) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.LCS_QoS_CLASS, LCSQoSClass.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSQoSClass()
   */
  @Override
  public void setLCSQoSClass(LCSQoSClass lcsQoSClass) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_QoS_CLASS, lcsQoSClass);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasHorizontalAccuracy()
   */
  @Override
  public boolean hasHorizontalAccuracy() {
    return hasAvp(EPCLocationProtocolAVPCodes.HORIZONTAL_ACCURACY);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getHorizontalAccuracy()
   */
  @Override
  public long getHorizontalAccuracy() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.HORIZONTAL_ACCURACY, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setHorizontalAccuracy()
   */
  @Override
  public void setHorizontalAccuracy(long horizontalAccuracy) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.HORIZONTAL_ACCURACY, horizontalAccuracy);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasVerticalAccuracy()
   */
  @Override
  public boolean hasVerticalAccuracy() {
    return hasAvp(EPCLocationProtocolAVPCodes.VERTICAL_ACCURACY);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getVerticalAccuracy()
   */
  @Override
  public long getVerticalAccuracy() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.VERTICAL_ACCURACY, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setVerticalAccuracy()
   */
  @Override
  public void setVerticalAccuracy(long verticalAccuracy) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.VERTICAL_ACCURACY, verticalAccuracy);
  }

  /*
    * (non-Javadoc)
    * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasResponseTime()
   */
  @Override
  public boolean hasResponseTime() {
    return hasAvp(EPCLocationProtocolAVPCodes.RESPONSE_TIME);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getResponseTime()
   */
  @Override
  public ResponseTime getResponseTime() {
    return (ResponseTime) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.RESPONSE_TIME, ResponseTime.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setResponseTime()
   */
  @Override
  public void setResponseTime(ResponseTime responseTime) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.RESPONSE_TIME, responseTime.getValue());
  }

  /*
    * (non-Javadoc)
    * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasVelocityRequested()
   */
  @Override
  public boolean hasVelocityRequested() {
    return hasAvp(EPCLocationProtocolAVPCodes.VELOCITY_REQUESTED);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getVelocityRequested()
   */
  @Override
  public VelocityRequested getVelocityRequested() {
    return (VelocityRequested) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.VELOCITY_REQUESTED, VelocityRequested.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setVelocityRequested()
   */
  @Override
  public void setVelocityRequested(VelocityRequested velocityRequested) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.VELOCITY_REQUESTED, velocityRequested.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSSupportedGADShapes()
   */
  @Override
  public boolean hasLCSSupportedGADShapes() {
    return hasAvp(EPCLocationProtocolAVPCodes.SUPPORTED_GAD_SHAPES);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSSupportedGADShapes()
   */
  @Override
  public long getLCSSupportedGADShapes() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.SUPPORTED_GAD_SHAPES);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSQoS()
   */
  @Override
  public void setLCSSupportedGADShapes(long lcsSupportedGADShapes) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.SUPPORTED_GAD_SHAPES, lcsSupportedGADShapes);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSServiceTypeID()
   */
  @Override
  public boolean hasLCSServiceTypeID() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_SERVICE_TYPE_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSServiceTypeID()
   */
  @Override
  public long getLCSServiceTypeID() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LCS_SERVICE_TYPE_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSQoS()
   */
  @Override
  public void setLCSServiceTypeID(long lcsSupportedGADShapes) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_SERVICE_TYPE_ID, lcsSupportedGADShapes);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSCodeword()
   */
  @Override
  public boolean hasLCSCodeword() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_CODEW0RD);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSCodeword()
   */
  @Override
  public String getLCSCodeword() {
    return getAvpAsUTF8String(EPCLocationProtocolAVPCodes.LCS_CODEW0RD);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSCodeword()
   */
  @Override
  public void setLCSCodeword(String lcsCodeword) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_CODEW0RD, lcsCodeword);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSPrivacyCheckNonSession()
   */
  @Override
  public boolean hasLCSPrivacyCheckNonSession() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSPrivacyCheckNonSession()
   */
  @Override
  public LCSPrivacyCheckNonSessionAvp getLCSPrivacyCheckNonSession() {
    return (LCSPrivacyCheckNonSessionAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, LCSPrivacyCheckNonSessionAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSPrivacyCheckNonSession()
   */
  @Override
  public void setLCSPrivacyCheckNonSession(LCSPrivacyCheckNonSessionAvp lcsPrivacyCheckNonSession) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION, lcsPrivacyCheckNonSession);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSPrivacyCheckNonSession()
   */
  @Override
  public boolean hasLCSPrivacyCheckSession() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_PRIVACY_CHECK_SESSION);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSPrivacyCheckSessionAvp()
   */
  @Override
  public LCSPrivacyCheckSessionAvp getLCSPrivacyCheckSession() {
    return (LCSPrivacyCheckSessionAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.LCS_PRIVACY_CHECK_SESSION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, LCSPrivacyCheckSessionAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSPrivacyCheckNonSession()
   */
  @Override
  public void setLCSPrivacyCheckSession(LCSPrivacyCheckSessionAvp lcsPrivacyCheckSession) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_PRIVACY_CHECK_SESSION, lcsPrivacyCheckSession);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasServiceSelection()
   */
  @Override
  public boolean hasServiceSelection() {
    return hasAvp(EPCLocationProtocolAVPCodes.SERVICE_SELECTION);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getServiceSelection()
   */
  @Override
  public String getServiceSelection() {
    return getAvpAsUTF8String(EPCLocationProtocolAVPCodes.SERVICE_SELECTION);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setServiceSelection()
   */
  @Override
  public void setServiceSelection(String serviceSelection) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.SERVICE_SELECTION, serviceSelection);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasDeferredLocationType()
   */
  @Override
  public boolean hasDeferredLocationType() {
    return hasAvp(EPCLocationProtocolAVPCodes.DEFERRED_LOCATION_TYPE);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getDeferredLocationType()
   */
  @Override
  public long getDeferredLocationType() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.DEFERRED_LOCATION_TYPE);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setDeferredLocationType()
   */
  @Override
  public void setDeferredLocationType(long lcsDeferredLocationType) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.DEFERRED_LOCATION_TYPE, lcsDeferredLocationType);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasPLRFlags()
   */
  @Override
  public boolean hasPLRFlags() {
    return hasAvp(EPCLocationProtocolAVPCodes.PLR_FLAGS);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getPLRFlags()
   */
  @Override
  public long getPLRFlags() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.PLR_FLAGS);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setPLRFlags()
   */
  @Override
  public void setPLRFlags(long plrFlags) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.PLR_FLAGS, plrFlags);
  }

  @Override
  public String getLongName() {
    return "Provide-Location-Request";
  }

  @Override
  public String getShortName() {
    return "PLR";
  }

}
