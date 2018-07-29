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

package org.mobicents.slee.resource.diameter.slg.events;

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import net.java.slee.resource.diameter.slg.events.ProvideLocationRequest;
import net.java.slee.resource.diameter.slg.events.avp.AreaEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.ELPAVPCodes;
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

import org.jdiameter.api.Message;

import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.AreaEventInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSRequestorNameAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSQoSAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckNonSessionAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckSessionAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.MotionEventInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl;

/**
 * Implementation for {@link ProvideLocationRequest}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
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
    return hasAvp(ELPAVPCodes.SLg_LOCATION_TYPE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getSLgLocationType()
   */
  @Override
  public SLgLocationType getSLgLocationType() {
    return (SLgLocationType) getAvpAsEnumerated(ELPAVPCodes.SLg_LOCATION_TYPE, ELPAVPCodes.SLg_VENDOR_ID, SLgLocationType.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setSLgLocationType(net.java.slee.resource.diameter.slg.events.avp.SLgLocationType)
   */
  @Override
  public void setSLgLocationType(SLgLocationType slgLocationType) throws IllegalStateException {
    addAvp(ELPAVPCodes.SLg_LOCATION_TYPE, ELPAVPCodes.SLg_VENDOR_ID, slgLocationType.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasUserName()
   */
  @Override
  public boolean hasUserName() {
    return hasAvp(ELPAVPCodes.USER_NAME, 0);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getUserName()
   */
  @Override
  public String getUserName() {
    return getAvpAsUTF8String(ELPAVPCodes.USER_NAME, 0);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setUserName(java.lang.String)
   */
  @Override
  public void setUserName(String imsi) throws IllegalStateException {
    addAvp(ELPAVPCodes.USER_NAME, 0, imsi);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasMSISDN()
   */
  @Override
  public boolean hasMSISDN() {
    return hasAvp(ELPAVPCodes.MSISDN, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getMSISDN()
   */
  @Override
  public byte[] getMSISDN() {
    return getAvpAsOctetString(ELPAVPCodes.MSISDN, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setMSISDN(byte[])
   */
  @Override
  public void setMSISDN(byte[] msisdn) throws IllegalStateException {
    addAvp(ELPAVPCodes.MSISDN, ELPAVPCodes.SLg_VENDOR_ID, msisdn);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasIMEI()
   */
  @Override
  public boolean hasIMEI() {
    return hasAvp(ELPAVPCodes.IMEI, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getUserName()
   */
  @Override
  public String getIMEI() {
    return getAvpAsUTF8String(ELPAVPCodes.IMEI, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setUserName(java.lang.String)
   */
  @Override
  public void setIMEI(String imei) throws IllegalStateException {
    addAvp(ELPAVPCodes.IMEI, ELPAVPCodes.SLg_VENDOR_ID, imei);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSEPSClientName()
   */
  @Override
  public boolean hasLCSEPSClientName() {
    return hasAvp(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSEPSClientName()
   */
  @Override
  public LCSEPSClientNameAvp getLCSEPSClientName() {
    return (LCSEPSClientNameAvp) getAvpAsCustom(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID, LCSEPSClientNameAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSEPSClientName(net.java.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvp)
   */
  @Override
  public void setLCSEPSClientName(LCSEPSClientNameAvp lcsEPSClientName) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID, lcsEPSClientName.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSClientType()
   */
  @Override
  public boolean hasLCSClientType() {
    return hasAvp(ELPAVPCodes.LCS_CLIENT_TYPE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSClientType()
   */
  @Override
  public LCSClientType getLCSClientType() {
    return (LCSClientType) getAvpAsEnumerated(ELPAVPCodes.LCS_CLIENT_TYPE, ELPAVPCodes.SLg_VENDOR_ID, LCSClientType.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSClientType(net.java.slee.resource.diameter.slg.events.avp.LCSClientType)
   */
  @Override
  public void setLCSClientType(LCSClientType lcsClientType) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_CLIENT_TYPE, ELPAVPCodes.SLg_VENDOR_ID, lcsClientType.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSRequestorName()
   */
  @Override
  public boolean hasLCSRequestorName() {
    return hasAvp(ELPAVPCodes.LCS_REQUESTOR_NAME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSRequestorName()
   */
  @Override
  public LCSRequestorNameAvp getLCSRequestorName() {
    return (LCSRequestorNameAvp) getAvpAsCustom(ELPAVPCodes.LCS_REQUESTOR_NAME, ELPAVPCodes.SLg_VENDOR_ID, LCSRequestorNameAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSRequestorName(net.java.slee.resource.diameter.slg.events.avp.LCSRequestorNameAvp)
   */
  @Override
  public void setLCSRequestorName(LCSRequestorNameAvp lcsRequestorName) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_REQUESTOR_NAME, ELPAVPCodes.SLg_VENDOR_ID, lcsRequestorName.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#LCSPriority()
   */
  @Override
  public boolean hasLCSPriority() {
    return hasAvp(ELPAVPCodes.LCS_PRIORITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSPriority()
   */
  @Override
  public long getLCSPriority() {
    return getAvpAsUnsigned32(ELPAVPCodes.LCS_PRIORITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSPriority(java.lang.Long)
   */
  @Override
  public void setLCSPriority(long lcsPriority) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_PRIORITY, ELPAVPCodes.SLg_VENDOR_ID, lcsPriority);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSQoS()
   */
  @Override
  public boolean hasLCSQoS() {
    return hasAvp(ELPAVPCodes.LCS_QoS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSQoS()
   */
  @Override
  public LCSQoSAvp getLCSQoS() {
    return (LCSQoSAvp) getAvpAsCustom(ELPAVPCodes.LCS_QoS, ELPAVPCodes.SLg_VENDOR_ID, LCSQoSAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSQoS(net.java.slee.resource.diameter.slg.events.avp.LCSQoSAvp)
   */
  @Override
  public void setLCSQoS(LCSQoSAvp lcsQoS) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_QoS, ELPAVPCodes.SLg_VENDOR_ID, lcsQoS.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasVelocityRequested()
   */
  @Override
  public boolean hasVelocityRequested() {
    return hasAvp(ELPAVPCodes.VELOCITY_REQUESTED, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getVelocityRequested()
   */
  @Override
  public VelocityRequested getVelocityRequested() {
    return (VelocityRequested) getAvpAsEnumerated(ELPAVPCodes.VELOCITY_REQUESTED, ELPAVPCodes.SLg_VENDOR_ID, VelocityRequested.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setVelocityRequested(net.java.slee.resource.diameter.slg.events.avp.VelocityRequested)
   */
  @Override
  public void setVelocityRequested(VelocityRequested velocityRequested) throws IllegalStateException {
    addAvp(ELPAVPCodes.VELOCITY_REQUESTED, ELPAVPCodes.SLg_VENDOR_ID, velocityRequested.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSSupportedGADShapes()
   */
  @Override
  public boolean hasLCSSupportedGADShapes() {
    return hasAvp(ELPAVPCodes.SUPPORTED_GAD_SHAPES, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSSupportedGADShapes()
   */
  @Override
  public long getLCSSupportedGADShapes() {
    return getAvpAsUnsigned32(ELPAVPCodes.SUPPORTED_GAD_SHAPES, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSSupportedGADShapes(java.lang.Long)
   */
  @Override
  public void setLCSSupportedGADShapes(long lcsSupportedGADShapes) throws IllegalStateException {
    addAvp(ELPAVPCodes.SUPPORTED_GAD_SHAPES, ELPAVPCodes.SLg_VENDOR_ID, lcsSupportedGADShapes);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSServiceTypeID()
   */
  @Override
  public boolean hasLCSServiceTypeID() {
    return hasAvp(ELPAVPCodes.LCS_SERVICE_TYPE_ID, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSServiceTypeID()
   */
  @Override
  public long getLCSServiceTypeID() {
    return getAvpAsUnsigned32(ELPAVPCodes.LCS_SERVICE_TYPE_ID, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSServiceTypeID(java.lang.Long)
   */
  @Override
  public void setLCSServiceTypeID(long lcsSupportedGADShapes) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_SERVICE_TYPE_ID, ELPAVPCodes.SLg_VENDOR_ID, lcsSupportedGADShapes);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSCodeword()
   */
  @Override
  public boolean hasLCSCodeword() {
    return hasAvp(ELPAVPCodes.LCS_CODEWORD, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSCodeword()
   */
  @Override
  public String getLCSCodeword() {
    return getAvpAsUTF8String(ELPAVPCodes.LCS_CODEWORD, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSCodeword(java.lang.String)
   */
  @Override
  public void setLCSCodeword(String lcsCodeword) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_CODEWORD, ELPAVPCodes.SLg_VENDOR_ID, lcsCodeword);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSPrivacyCheckNonSession()
   */
  @Override
  public boolean hasLCSPrivacyCheckNonSession() {
    return hasAvp(ELPAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSPrivacyCheckNonSession()
   */
  @Override
  public LCSPrivacyCheckNonSessionAvp getLCSPrivacyCheckNonSession() {
    return (LCSPrivacyCheckNonSessionAvp) getAvpAsCustom(ELPAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION, ELPAVPCodes.SLg_VENDOR_ID, LCSPrivacyCheckNonSessionAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSPrivacyCheckNonSession(net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckNonSessionAvp)
   */
  @Override
  public void setLCSPrivacyCheckNonSession(LCSPrivacyCheckNonSessionAvp lcsPrivacyCheckNonSession) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION, ELPAVPCodes.SLg_VENDOR_ID, lcsPrivacyCheckNonSession.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSPrivacyCheckSession()
   */
  @Override
  public boolean hasLCSPrivacyCheckSession() {
    return hasAvp(ELPAVPCodes.LCS_PRIVACY_CHECK_SESSION, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSPrivacyCheckSessionAvp()
   */
  @Override
  public LCSPrivacyCheckSessionAvp getLCSPrivacyCheckSession() {
    return (LCSPrivacyCheckSessionAvp) getAvpAsCustom(ELPAVPCodes.LCS_PRIVACY_CHECK_SESSION, ELPAVPCodes.SLg_VENDOR_ID, LCSPrivacyCheckSessionAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSPrivacyCheckSession(net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckSessionAvp)
   */
  @Override
  public void setLCSPrivacyCheckSession(LCSPrivacyCheckSessionAvp lcsPrivacyCheckSession) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_PRIVACY_CHECK_SESSION, ELPAVPCodes.SLg_VENDOR_ID, lcsPrivacyCheckSession.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasServiceSelection()
   */
  @Override
  public boolean hasServiceSelection() {
    return hasAvp(ELPAVPCodes.SERVICE_SELECTION, 0);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getServiceSelection()
   */
  @Override
  public String getServiceSelection() {
    return getAvpAsUTF8String(ELPAVPCodes.SERVICE_SELECTION, 0);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setServiceSelection(java.lang.String)
   */
  @Override
  public void setServiceSelection(String serviceSelection) throws IllegalStateException {
    addAvp(ELPAVPCodes.SERVICE_SELECTION, 0, serviceSelection);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasDeferredLocationType()
   */
  @Override
  public boolean hasDeferredLocationType() {
    return hasAvp(ELPAVPCodes.DEFERRED_LOCATION_TYPE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getDeferredLocationType()
   */
  @Override
  public long getDeferredLocationType() {
    return getAvpAsUnsigned32(ELPAVPCodes.DEFERRED_LOCATION_TYPE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setDeferredLocationType(java.lang.Long)
   */
  @Override
  public void setDeferredLocationType(long lcsDeferredLocationType) throws IllegalStateException {
    addAvp(ELPAVPCodes.DEFERRED_LOCATION_TYPE, ELPAVPCodes.SLg_VENDOR_ID, lcsDeferredLocationType);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasPLRFlags()
   */
  @Override
  public boolean hasPLRFlags() {
    return hasAvp(ELPAVPCodes.PLR_FLAGS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getPLRFlags()
   */
  @Override
  public long getPLRFlags() {
    return getAvpAsUnsigned32(ELPAVPCodes.PLR_FLAGS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setPLRFlags(java.lang.Long)
   */
  @Override
  public void setPLRFlags(long plrFlags) throws IllegalStateException {
    addAvp(ELPAVPCodes.PLR_FLAGS, ELPAVPCodes.SLg_VENDOR_ID, plrFlags);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSReferenceNumber()
   */
  @Override
  public boolean hasLCSReferenceNumber() {
    return hasAvp(ELPAVPCodes.LCS_REFERENCE_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSReferenceNumber()
   */
  @Override
  public byte[] getLCSReferenceNumber() {
    return getAvpAsOctetString(ELPAVPCodes.LCS_REFERENCE_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSReferenceNumber(byte[])
   */
  @Override
  public void setLCSReferenceNumber(byte[] lcsReferenceNumber) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_REFERENCE_NUMBER, ELPAVPCodes.SLg_VENDOR_ID, lcsReferenceNumber);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasAreaEventInfo()
   */
  @Override
  public boolean hasAreaEventInfo() {
    return hasAvp(ELPAVPCodes.AREA_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getAreaEventInfo()
   */
  @Override
  public AreaEventInfoAvp getAreaEventInfo() {
    return (AreaEventInfoAvp) getAvpAsCustom(ELPAVPCodes.AREA_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, AreaEventInfoAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setAreaEventInfo(net.java.slee.resource.diameter.slg.events.avp.AreaEventInfoAvp)
   */
  @Override
  public void setAreaEventInfo(AreaEventInfoAvp areaEventInfo) throws IllegalStateException {
    addAvp(ELPAVPCodes.AREA_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, areaEventInfo.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasGMLCAddress()
   */
  @Override
  public boolean hasGMLCAddress() {
    return hasAvp(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getGMLCAddress()
   */
  @Override
  public Address getGMLCAddress() {
    return getAvpAsAddress(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setGMLCAddress(net.java.slee.resource.diameter.base.events.avp.Address)
   */
  @Override
  public void setGMLCAddress(Address gmlcAddress) {
    addAvp(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID, gmlcAddress);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasPeriodicLDRInformation()
   */
  @Override
  public boolean hasPeriodicLDRInformation() {
    return hasAvp(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getPeriodicLDRInformation()
   */
  @Override
  public PeriodicLDRInfoAvp getPeriodicLDRInformation() {
    return (PeriodicLDRInfoAvp) getAvpAsCustom(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID, PeriodicLDRInfoAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setPeriodicLDRInformation(net.java.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvp)
   */
  @Override
  public void setPeriodicLDRInformation(PeriodicLDRInfoAvp periodicLDRInfoAvp) throws IllegalStateException {
    addAvp(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID, periodicLDRInfoAvp.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasReportingPLMNList()
   */
  @Override
  public boolean hasReportingPLMNList() {
    return hasAvp(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getReportingPLMNList()
   */
  @Override
  public ReportingPLMNListAvp getReportingPLMNList() {
    return (ReportingPLMNListAvp) getAvpAsCustom(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID, ReportingPLMNListAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setReportingPLMNList(net.java.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvp)
   */
  @Override
  public void setReportingPLMNList(ReportingPLMNListAvp reportingPLMNList) throws IllegalStateException {
    addAvp(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID, reportingPLMNList.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasMotionEventInfo()
   */
  @Override
  public boolean hasMotionEventInfo() {
    return hasAvp(ELPAVPCodes.MOTION_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getMotionEventInfo()
   */
  @Override
  public MotionEventInfoAvp getMotionEventInfo() {
    return (MotionEventInfoAvp) getAvpAsCustom(ELPAVPCodes.MOTION_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, MotionEventInfoAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setMotionEventInfo(net.java.slee.resource.diameter.slg.events.avp.MotionEventInfoAvp)
   */
  @Override
  public void setMotionEventInfo(MotionEventInfoAvp motionEventInfoAvp) throws IllegalStateException {
    addAvp(ELPAVPCodes.MOTION_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, motionEventInfoAvp.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getSupportedFeatureses()
   */
  public SupportedFeaturesAvp[] getSupportedFeatureses() {
    return (SupportedFeaturesAvp[]) getAvpsAsCustom(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, SupportedFeaturesAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setSupportedFeatures(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp)
   */
  public void setSupportedFeatures(SupportedFeaturesAvp supportedFeatures) {
    addAvp(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, supportedFeatures.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setSupportedFeatureses(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp[])
   */
  public void setSupportedFeatureses(SupportedFeaturesAvp[] supportedFeatureses) {
    for (SupportedFeaturesAvp supportedFeatures : supportedFeatureses) {
      setSupportedFeatures(supportedFeatures);
    }
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
