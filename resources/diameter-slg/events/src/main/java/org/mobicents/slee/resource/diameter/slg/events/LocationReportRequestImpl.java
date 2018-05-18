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
import net.java.slee.resource.diameter.slg.events.avp.ELPAVPCodes;
import net.java.slee.resource.diameter.slg.events.LocationReportRequest;
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

import org.jdiameter.api.Message;

import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import org.mobicents.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.DeferredMTLRDataAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl;

/**
 *  * Implementation for {@link LocationReportRequest}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class LocationReportRequestImpl extends DiameterMessageImpl implements LocationReportRequest {

  /**
   * @param message
   */
  public LocationReportRequestImpl(Message message) {
    super(message);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasAuthSessionState()
   */
  public boolean hasAuthSessionState() {
    return hasAvp(DiameterAvpCodes.AUTH_SESSION_STATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getAuthSessionState()
   */
  public AuthSessionStateType getAuthSessionState() {
    return (AuthSessionStateType) getAvpAsEnumerated(DiameterAvpCodes.AUTH_SESSION_STATE, AuthSessionStateType.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setAuthSessionState(net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType)
   */
  public void setAuthSessionState(AuthSessionStateType authSessionState) {
    addAvp(DiameterAvpCodes.AUTH_SESSION_STATE, authSessionState.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLocationEvent()
   */
  @Override
  public boolean hasLocationEvent() {
    return hasAvp(ELPAVPCodes.LOCATION_EVENT, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLocationEvent()
   */
  @Override
  public LocationEvent getLocationEvent() {
    return (LocationEvent) getAvpAsEnumerated(ELPAVPCodes.LOCATION_EVENT, ELPAVPCodes.SLg_VENDOR_ID, LocationEvent.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLocationEvent(net.java.slee.resource.diameter.slg.events.avp.LocationEvent)
   */
  @Override
  public void setLocationEvent(LocationEvent locationEvent) throws IllegalStateException {
    addAvp(ELPAVPCodes.LOCATION_EVENT, ELPAVPCodes.SLg_VENDOR_ID, locationEvent.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLCSEPSClientName()
   */
  @Override
  public boolean hasLCSEPSClientName() {
    return hasAvp(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLCSEPSClientName()
   */
  @Override
  public LCSEPSClientNameAvp getLCSEPSClientName() {
    return (LCSEPSClientNameAvp) getAvpAsCustom(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID, LCSEPSClientNameAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLCSEPSClientName(net.java.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvp)
   */
  @Override
  public void setLCSEPSClientName(LCSEPSClientNameAvp lcsEPSClientName) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID, lcsEPSClientName.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasUserName()
   */
  @Override
  public boolean hasUserName() {
    return hasAvp(ELPAVPCodes.USER_NAME, 0);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getUserName()
   */
  @Override
  public String getUserName() {
    return getAvpAsUTF8String(ELPAVPCodes.USER_NAME, 0);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setUserName(java.lang.String)
   */
  @Override
  public void setUserName(String imsi) throws IllegalStateException {
    addAvp(ELPAVPCodes.USER_NAME, 0, imsi);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasMSISDN()
   */
  @Override
  public boolean hasMSISDN() {
    return hasAvp(ELPAVPCodes.MSISDN, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getMSISDN()
   */
  @Override
  public byte[] getMSISDN() {
    return getAvpAsOctetString(ELPAVPCodes.MSISDN, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setMSISDN(byte[])
   */
  @Override
  public void setMSISDN(byte[] msisdn) throws IllegalStateException {
    addAvp(ELPAVPCodes.MSISDN, ELPAVPCodes.SLg_VENDOR_ID, msisdn);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasIMEI()
   */
  @Override
  public boolean hasIMEI() {
    return hasAvp(ELPAVPCodes.IMEI, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getIMEI()
   */
  @Override
  public String getIMEI() {
    return getAvpAsUTF8String(ELPAVPCodes.IMEI, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setUserName(java.lang.String)
   */
  @Override
  public void setIMEI(String imei) throws IllegalStateException {
    addAvp(ELPAVPCodes.IMEI, ELPAVPCodes.SLg_VENDOR_ID, imei);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLocationEstimate()
   */
  @Override
  public boolean hasLocationEstimate() {
    return hasAvp(ELPAVPCodes.LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLocationEstimate()
   */
  @Override
  public byte[] getLocationEstimate() {
    return getAvpAsOctetString(ELPAVPCodes.LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLocationEstimate(byte[])
   */
  @Override
  public void setLocationEstimate(byte[] locationEstimate) {
    addAvp(ELPAVPCodes.LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID, locationEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasAccuracyFulfilmentIndicator()
   */
  @Override
  public boolean hasAccuracyFulfilmentIndicator() {
    return hasAvp(ELPAVPCodes.ACCURACY_FULFILMENT_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getAccuracyFulfilmentIndicator()
   */
  @Override
  public AccuracyFulfilmentIndicator getAccuracyFulfilmentIndicator() {
    return (AccuracyFulfilmentIndicator) getAvpAsEnumerated(ELPAVPCodes.ACCURACY_FULFILMENT_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID, AccuracyFulfilmentIndicator.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setAccuracyFulfilmentIndicator(net.java.slee.resource.diameter.slg.events.avp.AccuracyFulfilmentIndicator)
   */
  @Override
  public void setAccuracyFulfilmentIndicator(AccuracyFulfilmentIndicator accuracyFulfilmentIndicator) {
    addAvp(ELPAVPCodes.ACCURACY_FULFILMENT_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID, accuracyFulfilmentIndicator.getValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasAgeOfLocationEstimate()
   */
  @Override
  public boolean hasAgeOfLocationEstimate() {
    return hasAvp(ELPAVPCodes.AGE_OF_LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getAgeOfLocationEstimate()
   */
  @Override
  public long getAgeOfLocationEstimate() {
    return getAvpAsUnsigned32(ELPAVPCodes.AGE_OF_LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setAgeOfLocationEstimate(java.lang.Long)
   */
  @Override
  public void setAgeOfLocationEstimate(long ageOfLocationEstimate) {
    addAvp(ELPAVPCodes.AGE_OF_LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID, ageOfLocationEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasVelocityEstimate()
   */
  @Override
  public boolean hasVelocityEstimate() {
    return hasAvp(ELPAVPCodes.VELOCITY_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getVelocityEstimate()
   */
  @Override
  public byte[] getVelocityEstimate() {
    return getAvpAsOctetString(ELPAVPCodes.VELOCITY_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setVelocityEstimate(byte[])
   */
  @Override
  public void setVelocityEstimate(byte[] velocityEstimate) {
    addAvp(ELPAVPCodes.VELOCITY_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID, velocityEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasEUTRANPositioningData()
   */
  @Override
  public boolean hasEUTRANPositioningData() {
    return hasAvp(ELPAVPCodes.EUTRAN_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getEUTRANPositioningData()
   */
  @Override
  public byte[] getEUTRANPositioningData() {
    return getAvpAsOctetString(ELPAVPCodes.EUTRAN_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setEUTRANPositioningData(byte[])
   */
  @Override
  public void setEUTRANPositioningData(byte[] eutranPositioningData) {
    addAvp(ELPAVPCodes.EUTRAN_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID, eutranPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasECGI()
   */
  @Override
  public boolean hasECGI() {
    return hasAvp(ELPAVPCodes.ECGI, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getECGI()
   */
  @Override
  public byte[] getECGI() {
    return getAvpAsOctetString(ELPAVPCodes.ECGI, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setECGI(byte[])
   */
  @Override
  public void setECGI(byte[] ecgi) {
    addAvp(ELPAVPCodes.ECGI, ELPAVPCodes.SLg_VENDOR_ID, ecgi);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasGERANPositioningInfo()
   */
  @Override
  public boolean hasGERANPositioningInfo() {
    return hasAvp(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getGERANPositioningInfo()
   */
  @Override
  public GERANPositioningInfoAvp getGERANPositioningInfo() {
    return (GERANPositioningInfoAvp) getAvpAsCustom(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, GERANPositioningInfoAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setGERANPositioningInfo(net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp)
   */
  @Override
  public void setGERANPositioningInfo(GERANPositioningInfoAvp geranPositioningInfo) {
    addAvp(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, geranPositioningInfo.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasCellGlobalIdentity()
   */
  @Override
  public boolean hasCellGlobalIdentity() {
    return hasAvp(ELPAVPCodes.CELL_GLOBAL_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getCellGlobalIdentity()
   */
  @Override
  public byte[] getCellGlobalIdentity() {
    return getAvpAsOctetString(ELPAVPCodes.CELL_GLOBAL_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setCellGlobalIdentity(byte[])
   */
  @Override
  public void setCellGlobalIdentity(byte[] cellGlobalIdentity) {
    addAvp(ELPAVPCodes.CELL_GLOBAL_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID, cellGlobalIdentity);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasUTRANPositioningInfo()
   */
  @Override
  public boolean hasUTRANPositioningInfo() {
    return hasAvp(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getUTRANPositioningInfo()
   */
  @Override
  public UTRANPositioningInfoAvp getUTRANPositioningInfo() {
    return (UTRANPositioningInfoAvp) getAvpAsCustom(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, UTRANPositioningInfoAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setUTRANPositioningInfo(net.java.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvp)
   */
  @Override
  public void setUTRANPositioningInfo(UTRANPositioningInfoAvp utranPositioningInfo) {
    addAvp(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, utranPositioningInfo.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasServiceAreaIdentity()
   */
  @Override
  public boolean hasServiceAreaIdentity() {
    return hasAvp(ELPAVPCodes.SERVICE_AREA_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getServiceAreaIdentity()
   */
  @Override
  public byte[] getServiceAreaIdentity() {
    return getAvpAsOctetString(ELPAVPCodes.SERVICE_AREA_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setServiceAreaIdentity(byte[])
   */
  @Override
  public void setServiceAreaIdentity(byte[] serviceAreaIdentity) {
    addAvp(ELPAVPCodes.SERVICE_AREA_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID, serviceAreaIdentity);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLCSServiceTypeID()
   */
  @Override
  public boolean hasLCSServiceTypeID() {
    return hasAvp(ELPAVPCodes.LCS_SERVICE_TYPE_ID, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLCSServiceTypeID()
   */
  @Override
  public long getLCSServiceTypeID() {
    return getAvpAsUnsigned32(ELPAVPCodes.LCS_SERVICE_TYPE_ID, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLCSServiceTypeID(java.lang.Long)
   */
  @Override
  public void setLCSServiceTypeID(long lcsSupportedGADShapes) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_SERVICE_TYPE_ID, ELPAVPCodes.SLg_VENDOR_ID, lcsSupportedGADShapes);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasPseudonymIndicator()
   */
  @Override
  public boolean hasPseudonymIndicator() {
    return hasAvp(ELPAVPCodes.PSEUDONYM_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getPseudonymIndicator()
   */
  @Override
  public PseudonymIndicator getPseudonymIndicator() {
    return (PseudonymIndicator) getAvpAsEnumerated(ELPAVPCodes.PSEUDONYM_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID, PseudonymIndicator.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setPseudonymIndicator(net.java.slee.resource.diameter.slg.events.avp.PseudonymIndicator)
   */
  @Override
  public void setPseudonymIndicator(PseudonymIndicator pseudonymIndicator) throws IllegalStateException {
    addAvp(ELPAVPCodes.PSEUDONYM_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID, pseudonymIndicator.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLCSQoSClass()
   */
  @Override
  public boolean hasLCSQoSClass() {
    return hasAvp(ELPAVPCodes.LCS_QoS_CLASS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLCSQoSClass()
   */
  @Override
  public LCSQoSClass getLCSQoSClass() {
    return (LCSQoSClass) getAvpAsEnumerated(ELPAVPCodes.LCS_QoS_CLASS, ELPAVPCodes.SLg_VENDOR_ID, LCSQoSClass.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLCSQoSClass(net.java.slee.resource.diameter.slg.events.avp.LCSQoSClass)
   */
  @Override
  public void setLCSQoSClass(LCSQoSClass lcsQoSClass) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_QoS_CLASS, ELPAVPCodes.SLg_VENDOR_ID, lcsQoSClass.getValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasServingNode()
   */
  @Override
  public boolean hasServingNode() {
    return hasAvp(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getServingNode()
   */
  @Override
  public ServingNodeAvp getServingNode() {
    return (ServingNodeAvp) getAvpAsCustom(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, ServingNodeAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setServingNode(net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp)
   */
  @Override
  public void setServingNode(ServingNodeAvp servingNode) {
    addAvp(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, servingNode.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLRRFlags()
   */
  @Override
  public boolean hasLRRFlags() {
    return hasAvp(ELPAVPCodes.LRR_FLAGS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLRRFlags()
   */
  @Override
  public long getLRRFlags() {
    return getAvpAsUnsigned32(ELPAVPCodes.LRR_FLAGS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLRRFlags(java.lang.Long)
   */
  @Override
  public void setLRRFlags(long lrrFlags) throws IllegalStateException {
    addAvp(ELPAVPCodes.LRR_FLAGS, ELPAVPCodes.SLg_VENDOR_ID, lrrFlags);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLCSReferenceNumber()
   */
  @Override
  public boolean hasLCSReferenceNumber() {
    return hasAvp(ELPAVPCodes.LCS_REFERENCE_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLCSReferenceNumber()
   */
  @Override
  public byte[] getLCSReferenceNumber() {
    return getAvpAsOctetString(ELPAVPCodes.LCS_REFERENCE_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLCSReferenceNumber(byte[])
   */
  @Override
  public void setLCSReferenceNumber(byte[] lcsReferenceNumber) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_REFERENCE_NUMBER, ELPAVPCodes.SLg_VENDOR_ID, lcsReferenceNumber);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasDeferredMTLRData()
   */
  @Override
  public boolean hasDeferredMTLRData() {
    return hasAvp(ELPAVPCodes.DEFERRED_MT_LR_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getDeferredMTLRData()
   */
  @Override
  public DeferredMTLRDataAvp getDeferredMTLRData() {
    return (DeferredMTLRDataAvp) getAvpAsCustom(ELPAVPCodes.DEFERRED_MT_LR_DATA, ELPAVPCodes.SLg_VENDOR_ID, DeferredMTLRDataAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setDeferredMTLRData(net.java.slee.resource.diameter.slg.events.avp.DeferredMTLRDataAvp)
   */
  @Override
  public void setDeferredMTLRData(DeferredMTLRDataAvp deferredMTLRDataAvp) throws IllegalStateException {
    addAvp(ELPAVPCodes.DEFERRED_MT_LR_DATA, ELPAVPCodes.SLg_VENDOR_ID, deferredMTLRDataAvp.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasGMLCAddress()
   */
  @Override
  public boolean hasGMLCAddress() {
    return hasAvp(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getGMLCAddress()
   */
  @Override
  public Address getGMLCAddress() {
    return getAvpAsAddress(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setGMLCAddress(net.java.slee.resource.diameter.base.events.avp.Address)
   */
  @Override
  public void setGMLCAddress(Address gmlcAddress) {
    addAvp(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID, gmlcAddress);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasReportingAmount()
   */
  @Override
  public boolean hasReportingAmount() {
    return hasAvp(ELPAVPCodes.REPORTING_AMOUNT, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getReportingAmount()
   */
  @Override
  public long getReportingAmount() {
    return getAvpAsUnsigned32(ELPAVPCodes.REPORTING_AMOUNT, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setReportingAmount(java.lang.Long)
   */
  @Override
  public void setReportingAmount(long reportingAmount) throws IllegalStateException {
    addAvp(ELPAVPCodes.REPORTING_AMOUNT, ELPAVPCodes.SLg_VENDOR_ID, reportingAmount);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasPeriodicLDRInformation()
   */
  @Override
  public boolean hasPeriodicLDRInformation() {
    return hasAvp(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getPeriodicLDRInformation()
   */
  @Override
  public PeriodicLDRInfoAvp getPeriodicLDRInformation() {
    return (PeriodicLDRInfoAvp) getAvpAsCustom(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID, PeriodicLDRInfoAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setPeriodicLDRInformation(net.java.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvp)
   */
  @Override
  public void setPeriodicLDRInformation(PeriodicLDRInfoAvp periodicLDRInfoAvp) throws IllegalStateException {
    addAvp(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID, periodicLDRInfoAvp.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasESMLCCellInfo()
   */
  @Override
  public boolean hasESMLCCellInfo() {
    return hasAvp(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getESMLCCellInfo()
   */
  @Override
  public ESMLCCellInfoAvp getESMLCCellInfo() {
    return (ESMLCCellInfoAvp) getAvpAsCustom(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID, ESMLCCellInfoAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setESMLCCellInfo(net.java.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvp)
   */
  @Override
  public void setESMLCCellInfo(ESMLCCellInfoAvp esmlcCellInfo) {
    addAvp(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID, esmlcCellInfo.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#has1xRTTRCID()
   */
  @Override
  public boolean has1xRTTRCID() {
    return hasAvp(ELPAVPCodes.ONExRTT_RCID, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#get1xRTTRCID()
   */
  @Override
  public byte[] get1xRTTRCID() {
    return getAvpAsOctetString(ELPAVPCodes.ONExRTT_RCID, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#set1xRTTRCID(byte[])
   */
  @Override
  public void set1xRTTRCID(byte[] onexRTTRCID) throws IllegalStateException {
    addAvp(ELPAVPCodes.ONExRTT_RCID, ELPAVPCodes.SLg_VENDOR_ID, onexRTTRCID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasDelayedLocationReportingData()
   */
  @Override
  public boolean hasDelayedLocationReportingData() {
    return hasAvp(ELPAVPCodes.DELAYED_LOCATION_REPORTING_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getDelayedLocationReportingData()
   */
  @Override
  public DelayedLocationReportingDataAvp getDelayedLocationReportingData() {
    return (DelayedLocationReportingDataAvp) getAvpAsCustom(ELPAVPCodes.DELAYED_LOCATION_REPORTING_DATA, ELPAVPCodes.SLg_VENDOR_ID, DelayedLocationReportingDataAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setDelayedLocationReportingData(net.java.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvp)
   */
  @Override
  public void setDelayedLocationReportingData(DelayedLocationReportingDataAvp delayedLocationReportingData) throws IllegalStateException {
    addAvp(ELPAVPCodes.DELAYED_LOCATION_REPORTING_DATA, ELPAVPCodes.SLg_VENDOR_ID, delayedLocationReportingData.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasCivicAddress()
   */
  @Override
  public boolean hasCivicAddress() {
    return hasAvp(ELPAVPCodes.CIVIC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getCivicAddress()
   */
  @Override
  public byte[] getCivicAddress() {
    return getAvpAsOctetString(ELPAVPCodes.CIVIC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setCivicAddress(byte[])
   */
  @Override
  public void setCivicAddress(byte[] civicAddress) {
    addAvp(ELPAVPCodes.CIVIC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID, civicAddress);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasBarometricPressure()
   */
  @Override
  public boolean hasBarometricPressure() {
    return hasAvp(ELPAVPCodes.BAROMETRIC_PRESSURE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getBarometricPressure()
   */
  @Override
  public long getBarometricPressure() {
    return getAvpAsUnsigned32(ELPAVPCodes.BAROMETRIC_PRESSURE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setBarometricPressure(java.lang.Long)
   */
  @Override
  public void setBarometricPressure(long barometricPressure) {
    addAvp(ELPAVPCodes.BAROMETRIC_PRESSURE, ELPAVPCodes.SLg_VENDOR_ID, barometricPressure);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getSupportedFeatureses()
   */
  public SupportedFeaturesAvp[] getSupportedFeatureses() {
    return (SupportedFeaturesAvp[]) getAvpsAsCustom(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, SupportedFeaturesAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setSupportedFeatures(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp)
   */
  public void setSupportedFeatures(SupportedFeaturesAvp supportedFeatures) {
    addAvp(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, supportedFeatures.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setSupportedFeatureses(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp[])
   */
  public void setSupportedFeatureses(SupportedFeaturesAvp[] supportedFeatureses) {
    for (SupportedFeaturesAvp supportedFeatures : supportedFeatureses) {
      setSupportedFeatures(supportedFeatures);
    }
  }

  /*
   * (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getLongName()
   */
  @Override
  public String getLongName() {
    return "Location-Report-Request";
  }

  /* (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getShortName()
   */
  @Override
  public String getShortName() {
    return "LRR";
  }

}

