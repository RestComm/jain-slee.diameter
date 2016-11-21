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

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slg.events.LocationReportRequest;
import org.jdiameter.api.Message;

import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import net.java.slee.resource.diameter.slg.events.avp.*;

/**
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
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
    return hasAvp(EPCLocationProtocolAVPCodes.LOCATION_EVENT, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLocationEvent()
   */
  @Override
  public LocationEvent getLocationEvent() {
    return (LocationEvent) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.LOCATION_EVENT, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, LocationEvent.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLocationEvent()
   */
  @Override
  public void setLocationEvent(LocationEvent locationEvent) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LOCATION_EVENT, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, locationEvent.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLCSEPSClientName()
   */
  @Override
  public boolean hasLCSEPSClientName() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_EPS_CLIENT_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLCSEPSClientName()
   */
  @Override
  public LCSEPSClientNameAvp getLCSEPSClientName() {
    return (LCSEPSClientNameAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.LCS_EPS_CLIENT_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, LCSEPSClientNameAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLCSEPSClientName()
   */
  @Override
  public void setLCSEPSClientNameAvp(LCSEPSClientNameAvp lcsEPSClientName) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_EPS_CLIENT_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lcsEPSClientName);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLCSNameString()
   */
  @Override
  public boolean hasLCSNameString() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_NAME_STRING, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLCSNameString()
   */
  @Override
  public String getLCSNameString() {
    return getAvpAsUTF8String(EPCLocationProtocolAVPCodes.LCS_NAME_STRING, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLCSNameString()
   */
  @Override
  public void setLCSNameString(String lcsNameString) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_NAME_STRING, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lcsNameString);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLCSFormatIndicator()
   */
  @Override
  public boolean hasLCSFormatIndicator() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_FORMAT_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLCSFormatIndicator()
   */
  @Override
  public LCSFormatIndicator getLCSFormatIndicator() {
    return (LCSFormatIndicator) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.LCS_FORMAT_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, LCSFormatIndicator.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLocationEvent()
   */
  @Override
  public void setLCSFormatIndicator(LCSFormatIndicator lcsFormatIndicator) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_FORMAT_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lcsFormatIndicator.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasUserName()
   */
  @Override
  public boolean hasUserName() {
    return hasAvp(EPCLocationProtocolAVPCodes.USER_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getUserName()
   */
  @Override
  public String getUserName() {
    return getAvpAsUTF8String(EPCLocationProtocolAVPCodes.USER_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setUserName()
   */
  @Override
  public void setUserName(String imsi) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.USER_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, imsi);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasMSISDN()
   */
  @Override
  public boolean hasMSISDN() {
    return hasAvp(EPCLocationProtocolAVPCodes.MSISDN, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getMSISDN()
   */
  @Override
  public byte[] getMSISDN() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.MSISDN, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setMSISDN()
   */
  @Override
  public void setMSISDN(byte[] msisdn) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.MSISDN, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, msisdn);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasIMEI()
   */
  @Override
  public boolean hasIMEI() {
    return hasAvp(EPCLocationProtocolAVPCodes.IMEI, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getUserName()
   */
  @Override
  public String getIMEI() {
    return getAvpAsUTF8String(EPCLocationProtocolAVPCodes.IMEI, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setUserName()
   */
  @Override
  public void setIMEI(String imei) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.IMEI, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, imei);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLocationEstimate()
   */
  public boolean hasLocationEstimate() {
    return hasAvp(EPCLocationProtocolAVPCodes.LOCATION_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLocationEstimate()
   */
  public byte[] getLocationEstimate() {
    return  getAvpAsOctetString(EPCLocationProtocolAVPCodes.LOCATION_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLocationEstimate
   */
  public void setLocationEstimate(byte[] locationEstimate) {
    addAvp(EPCLocationProtocolAVPCodes.LOCATION_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, locationEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasAccuracyFulfilmentIndicator()
   */
  public boolean hasAccuracyFulfilmentIndicator() {
    return hasAvp(EPCLocationProtocolAVPCodes.ACCURACY_FULFILMENT_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getAccuracyFulfilmentIndicator()
   */
  public AccuracyFulfilmentIndicator getAccuracyFulfilmentIndicator() {
    return (AccuracyFulfilmentIndicator) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.ACCURACY_FULFILMENT_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, AccuracyFulfilmentIndicator.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setAccuracyFulfilmentIndicator()
   */
  public void setAccuracyFulfilmentIndicator(AccuracyFulfilmentIndicator accuracyFulfilmentIndicator) {
    addAvp(EPCLocationProtocolAVPCodes.ACCURACY_FULFILMENT_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, accuracyFulfilmentIndicator);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasAgeOfLocationEstimate()
   */
  public boolean hasAgeOfLocationEstimate() {
    return hasAvp(EPCLocationProtocolAVPCodes.AGE_OF_LOCATION_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getAgeOfLocationEstimate()
   */
  public long getAgeOfLocationEstimate() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.AGE_OF_LOCATION_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setAgeOfLocationEstimate()
   */
  public void setAgeOfLocationEstimate(long ageOfLocationEstimate) {
    addAvp(EPCLocationProtocolAVPCodes.AGE_OF_LOCATION_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, ageOfLocationEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasVelocityEstimate()
   */
  public boolean hasVelocityEstimate() {
    return hasAvp(EPCLocationProtocolAVPCodes.VELOCITY_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getVelocityEstimate()
   */
  public byte[] getVelocityEstimate() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.VELOCITY_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setVelocityEstimate()
   */
  public void setVelocityEstimate(byte[] velocityEstimate) {
    addAvp(EPCLocationProtocolAVPCodes.VELOCITY_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, velocityEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasEUTRANPositioningData()
   */
  public boolean hasEUTRANPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.EUTRAN_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getEUTRANPositioningData()
   */
  public byte[] getEUTRANPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.EUTRAN_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setEUTRANPositioningData()
   */
  public void setEUTRANPositioningData(byte[] eutranPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.EUTRAN_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, eutranPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasECGI()
   */
  public boolean hasECGI() {
    return hasAvp(EPCLocationProtocolAVPCodes.ECGI, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getECGI()
   */
  public byte[] getECGI() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.ECGI, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setECGI()
   */
  public void setECGI(byte[] ecgi) {
    addAvp(EPCLocationProtocolAVPCodes.ECGI, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, ecgi);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasGERANPositioningInfo()
   */
  public boolean hasGERANPositioningInfo() {
    return hasAvp(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getGERANPositioningInfo()
   */
  public GERANPositioningInfoAvp getGERANPositioningInfo() {
    return (GERANPositioningInfoAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, GERANPositioningInfoAvp.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setGERANPositioningInfo()
   */
  public void setGERANPositioningInfo(GERANPositioningInfoAvp geranPositioningInfo) {
    addAvp(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, geranPositioningInfo);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasGERANPositioningData()
   */
  public boolean hasGERANPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getGERANPositioningData()
   */
  public byte[] getGERANPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setGERANPositioningData()
   */
  public void setGERANPositioningData(byte[] geranPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, geranPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasGERANGANSSPositioningData()
   */
  public boolean hasGERANGANSSPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.GERAN_GANSS_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getGERANGANSSPositioningData()
   */
  public byte[] getGERANGANSSPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.GERAN_GANSS_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setGERANGANSSPositioningData()
   */
  public void setGERANGANSSPositioningData(byte[] geranGanssPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.GERAN_GANSS_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, geranGanssPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasCellGlobalIdentity()
   */
  public boolean hasCellGlobalIdentity() {
    return hasAvp(EPCLocationProtocolAVPCodes.CELL_GLOBAL_IDENTITY, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getCellGlobalIdentity()
   */
  public byte[] getCellGlobalIdentity() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.CELL_GLOBAL_IDENTITY, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setCellGlobalIdentity()
   */
  public void setCellGlobalIdentity(byte[] cellGlobalIdentity) {
    addAvp(EPCLocationProtocolAVPCodes.CELL_GLOBAL_IDENTITY, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, cellGlobalIdentity);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasUTRANPositioningInfo()
   */
  public boolean hasUTRANPositioningInfo() {
    return hasAvp(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getUTRANPositioningInfo()
   */
  public UTRANPositioningInfoAvp getUTRANPositioningInfo() {
    return (UTRANPositioningInfoAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, UTRANPositioningInfoAvp.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setUTRANPositioningInfo()
   */
  public void setUTRANPositioningInfo(UTRANPositioningInfoAvp utranPositioningInfo) {
    addAvp(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, utranPositioningInfo);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasUTRANPositioningData()
   */
  public boolean hasUTRANPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getUTRANPositioningData()
   */
  public byte[] getUTRANPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setUTRANPositioningData()
   */
  public void setUTRANPositioningData(byte[] utranPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, utranPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasUTRANGANSSPositioningData()
   */
  public boolean hasUTRANGANSSPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.UTRAN_GANSS_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getUTRANGANSSPositioningData()
   */
  public byte[] getUTRANGANSSPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.UTRAN_GANSS_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setUTRANGANSSPositioningData()
   */
  public void setUTRANGANSSPositioningData(byte[] utranGANSSPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.UTRAN_GANSS_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, utranGANSSPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasUTRANAdditionalPositioningData()
   */
  public boolean hasUTRANAdditionalPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.UTRAN_ADDITIONAL_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getUTRANAdditionalPositioningData()
   */
  public byte[] getUTRANAdditionalPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.UTRAN_ADDITIONAL_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setUTRANPositioningData()
   */
  public void setUTRANAdditionalPositioningData(byte[] utranAdditionalPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.UTRAN_ADDITIONAL_POSITIONING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, utranAdditionalPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasServiceAreaIdentity()
   */
  public boolean hasServiceAreaIdentity() {
    return hasAvp(EPCLocationProtocolAVPCodes.SERVICE_AREA_IDENTITY, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getServiceAreaIdentity()
   */
  public byte[] getServiceAreaIdentity() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.SERVICE_AREA_IDENTITY, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setServiceAreaIdentity()
   */
  public void setServiceAreaIdentity(byte[] serviceAreaIdentity) {
    addAvp(EPCLocationProtocolAVPCodes.SERVICE_AREA_IDENTITY, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, serviceAreaIdentity);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSServiceTypeID()
   */
  @Override
  public boolean hasLCSServiceTypeID() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_SERVICE_TYPE_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSServiceTypeID()
   */
  @Override
  public long getLCSServiceTypeID() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LCS_SERVICE_TYPE_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSQoS()
   */
  @Override
  public void setLCSServiceTypeID(long lcsSupportedGADShapes) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_SERVICE_TYPE_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lcsSupportedGADShapes);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasPseudonymIndicator()
   */
  @Override
  public boolean hasPseudonymIndicator() {
    return hasAvp(EPCLocationProtocolAVPCodes.PSEUDONYM_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getPseudonymIndicator()
   */
  @Override
  public PseudonymIndicator getPseudonymIndicator() {
    return (PseudonymIndicator) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.PSEUDONYM_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, PseudonymIndicator.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setPseudonymIndicator()
   */
  @Override
  public void setPseudonymIndicator(PseudonymIndicator pseudonymIndicator) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.PSEUDONYM_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, pseudonymIndicator);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#hasLCSQoSClass()
   */
  @Override
  public boolean hasLCSQoSClass() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_QoS_CLASS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#getLCSQoSClass()
   */
  @Override
  public LCSQoSClass getLCSQoSClass() {
    return (LCSQoSClass) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.LCS_QoS_CLASS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, LCSQoSClass.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationRequest#setLCSQoSClass()
   */
  @Override
  public void setLCSQoSClass(LCSQoSClass lcsQoSClass) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_QoS_CLASS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lcsQoSClass);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasServingNode()
   */
  public boolean hasServingNode() {
    return hasAvp(EPCLocationProtocolAVPCodes.SERVING_NODE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getServingNode()
   */
  public ServingNodeAvp getServingNode() {
    return (ServingNodeAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.SERVING_NODE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, ServingNodeAvp.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setServingNode()
   */
  public void setServingNode(ServingNodeAvp servingNode) {
    addAvp(EPCLocationProtocolAVPCodes.SERVING_NODE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, servingNode);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasSGSNNumber()
   */
  public boolean hasSGSNNumber() {
    return hasAvp(EPCLocationProtocolAVPCodes.SGSN_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getSGSNNumber()
   */
  public byte[] getSGSNNumber() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.SGSN_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setSGSNNumber()
   */
  public void setSGSNNumber(byte[] sgsnNumber) {
    addAvp(EPCLocationProtocolAVPCodes.SGSN_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, sgsnNumber);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasSGSNName()
   */
  public boolean hasSGSNName() {
    return hasAvp(EPCLocationProtocolAVPCodes.SGSN_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getSGSNName()
   */
  public DiameterIdentity getSGSNName() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.SGSN_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setSGSNName()
   */
  public void setSGSNName(DiameterIdentity sgsnName) {
    addAvp(EPCLocationProtocolAVPCodes.SGSN_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, sgsnName);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasSGSNRealm()
   */
  public boolean hasSGSNRealm() {
    return hasAvp(EPCLocationProtocolAVPCodes.SGSN_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getSGSNRealm()
   */
  public DiameterIdentity getSGSNRealm() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.SGSN_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setSGSNRealm()
   */
  public void setSGSNRealm(DiameterIdentity sgsnRealm) {
    addAvp(EPCLocationProtocolAVPCodes.SGSN_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, sgsnRealm);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasMMEName()
   */
  public boolean hasMMEName() {
    return hasAvp(EPCLocationProtocolAVPCodes.MME_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getMMEName()
   */
  public DiameterIdentity getMMEName() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.MME_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setMMEName()
   */
  public void setMMEName(DiameterIdentity mmeName) {
    addAvp(EPCLocationProtocolAVPCodes.MME_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, mmeName);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasMMERealm()
   */
  public boolean hasMMERealm() {
    return hasAvp(EPCLocationProtocolAVPCodes.MME_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getMMERealm()
   */
  public DiameterIdentity getMMERealm() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.MME_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setMMERealm()
   */
  public void setMMERealm(DiameterIdentity mmeRealm) {
    addAvp(EPCLocationProtocolAVPCodes.MME_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, mmeRealm);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasMSCNumber()
   */
  public boolean hasMSCNumber() {
    return hasAvp(EPCLocationProtocolAVPCodes.MSC_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getMSCNumber()
   */
  public byte[] getMSCNumber() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.MSC_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setMSCNumber()
   */
  public void setMSCNumber(byte[] mscNumber) {
    addAvp(EPCLocationProtocolAVPCodes.MSC_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, mscNumber);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#has3GPPAAAServerName()
   */
  public boolean has3GPPAAAServerName() {
    return hasAvp(EPCLocationProtocolAVPCodes.TGPP_AAA_SERVER_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#get3GPPAAAServerName()
   */
  public DiameterIdentity get3GPPAAAServerName() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.TGPP_AAA_SERVER_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#set3GPPAAAServerName()
   */
  public void set3GPPAAAServerName(DiameterIdentity tgppAAAServerName) {
    addAvp(EPCLocationProtocolAVPCodes.TGPP_AAA_SERVER_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, tgppAAAServerName);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLCSCapabilitiesSets()
   */
  public boolean hasLCSCapabilitiesSets() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_CAPABILITIES_SETS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLCSCapabilitiesSets()
   */
  public long getLCSCapabilitiesSets() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LCS_CAPABILITIES_SETS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLCSCapabilitiesSets()
   */
  public void setLCSCapabilitiesSets(long lcsCapabilitiesSets) {
    addAvp(EPCLocationProtocolAVPCodes.LCS_CAPABILITIES_SETS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lcsCapabilitiesSets);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasGMLCAddress()
   */
  public boolean hasGMLCAddress() {
    return hasAvp(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getGMLCAddress()
   */
  public Address getGMLCAddress() {
    return getAvpAsAddress(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setGMLCAddress()
   */
  public void setGMLCAddress(Address gmlcAddress) {
    addAvp(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, gmlcAddress);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLRRFlags()
   */
  @Override
  public boolean hasLRRFlags() {
    return hasAvp(EPCLocationProtocolAVPCodes.LRR_FLAGS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLRRFlags()
   */
  @Override
  public long getLRRFlags() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LRR_FLAGS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setLRRFlags()
   */
  @Override
  public void setLRRFlags(long lrrFlags) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LRR_FLAGS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lrrFlags);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasLCSReferenceNumber()
   */
  @Override
  public boolean hasLCSReferenceNumber() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_REFERENCE_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getLCSReferenceNumber()
   */
  @Override
  public byte[] getLCSReferenceNumber() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.LCS_REFERENCE_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#set()
   */
  @Override
  public void setLCSReferenceNumber(byte[] lcsReferenceNumber) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.LCS_REFERENCE_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lcsReferenceNumber);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasDeferredMTLRData()
   */
  @Override
  public boolean hasDeferredMTLRData() {
    return hasAvp(EPCLocationProtocolAVPCodes.DEFERRED_MT_LR_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getDeferredMTLRData()
   */
  @Override
  public DeferredMTLRDataAvp getDeferredMTLRData() {
    return (DeferredMTLRDataAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.DEFERRED_MT_LR_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, DeferredMTLRDataAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setDeferredMTLRData()
   */
  @Override
  public void setDeferredMTLRData(DeferredMTLRDataAvp deferredMTLRDataAvp) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.DEFERRED_MT_LR_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, deferredMTLRDataAvp);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasDeferredLocationType()
   */
  @Override
  public boolean hasDeferredLocationType() {
    return hasAvp(EPCLocationProtocolAVPCodes.DEFERRED_LOCATION_TYPE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getDeferredLocationType()
   */
  @Override
  public long getDeferredLocationType() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.DEFERRED_LOCATION_TYPE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setDeferredLocationType()
   */
  @Override
  public void setDeferredLocationType(long deferredLocationType) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.DEFERRED_LOCATION_TYPE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, deferredLocationType);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasTerminationCause()
   */
  @Override
  public boolean hasTerminationCause() {
    return hasAvp(EPCLocationProtocolAVPCodes.TERMINATION_CAUSE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getTerminationCause()
   */
  @Override
  public long getTerminationCause() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.TERMINATION_CAUSE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setTerminationCause()
   */
  @Override
  public void setTerminationCause(long terminationCause) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.TERMINATION_CAUSE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, terminationCause);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasReportingAmount()
   */
  @Override
  public boolean hasReportingAmount() {
    return hasAvp(EPCLocationProtocolAVPCodes.REPORTING_AMOUNT, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getReportingAmount()
   */
  @Override
  public long getReportingAmount() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.REPORTING_AMOUNT, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setReportingAmount()
   */
  @Override
  public void setReportingAmount(long reportingAmount) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.REPORTING_AMOUNT, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, reportingAmount);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasPeriodicLDRInformation()
   */
  @Override
  public boolean hasPeriodicLDRInformation() {
    return hasAvp(EPCLocationProtocolAVPCodes.PERIODIC_LDR_INFORMATION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getPeriodicLDRInfo()
   */
  @Override
  public PeriodicLDRInfoAvp getPeriodicLDRInformation() {
    return (PeriodicLDRInfoAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.PERIODIC_LDR_INFORMATION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, PeriodicLDRInfoAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setPeriodicLDRInfo()
   */
  @Override
  public void setPeriodicLDRInformation(PeriodicLDRInfoAvp periodicLDRInfoAvp) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.PERIODIC_LDR_INFORMATION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, periodicLDRInfoAvp);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasReportingInterval()
   */
  @Override
  public boolean hasReportingInterval() {
    return hasAvp(EPCLocationProtocolAVPCodes.REPORTING_INTERVAL, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getReportingInterval()
   */
  @Override
  public long getReportingInterval() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.REPORTING_INTERVAL, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setReportingInterval()
   */
  @Override
  public void setReportingInterval(long reportingInterval) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.REPORTING_INTERVAL, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, reportingInterval);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasESMLCCellInfo()
   */
  public boolean hasESMLCCellInfo() {
    return hasAvp(EPCLocationProtocolAVPCodes.ESMLC_CELL_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getESMLCCellInfo()
   */
  public ESMLCCellInfoAvp getESMLCCellInfo() {
    return (ESMLCCellInfoAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.ESMLC_CELL_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, ESMLCCellInfoAvp.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setESMLCCellInfo()
   */
  public void setESMLCCellInfo(ESMLCCellInfoAvp esmlcCellInfo) {
    addAvp(EPCLocationProtocolAVPCodes.ESMLC_CELL_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, esmlcCellInfo);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasCellPortionID()
   */
  public boolean hasCellPortionID() {
    return hasAvp(EPCLocationProtocolAVPCodes.CELL_PORTION_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getCellPortionID()
   */
  public long getCellPortionID() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.CELL_PORTION_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setCellPortionID()
   */
  public void setCellPortionID(long cellPortionID) {
    addAvp(EPCLocationProtocolAVPCodes.CELL_PORTION_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, cellPortionID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#has1xRTTRCID()
   */
  @Override
  public boolean has1xRTTRCID() {
    return hasAvp(EPCLocationProtocolAVPCodes.ONExRTT_RCID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#get1xRTTRCID()
   */
  @Override
  public byte[] get1xRTTRCID() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.ONExRTT_RCID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#set1xRTTRCID()
   */
  @Override
  public void set1xRTTRCID(byte[] onexRTTRCID) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.ONExRTT_RCID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, onexRTTRCID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasDelayedLocationReportingData()
   */
  @Override
  public boolean hasDelayedLocationReportingData() {
    return hasAvp(EPCLocationProtocolAVPCodes.DELAYED_LOCATION_REPORTING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getDelayedLocationReportingData()
   */
  @Override
  public DelayedLocationReportingDataAvp getDelayedLocationReportingData() {
    return (DelayedLocationReportingDataAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.DELAYED_LOCATION_REPORTING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, DelayedLocationReportingDataAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setDelayedLocationReportingData()
   */
  @Override
  public void setDelayedLocationReportingData(DelayedLocationReportingDataAvp delayedLocationReportingData) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.DELAYED_LOCATION_REPORTING_DATA, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, delayedLocationReportingData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasCivicAddress()
   */
  public boolean hasCivicAddress() {
    return hasAvp(EPCLocationProtocolAVPCodes.CIVIC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getCivicAddress()
   */
  public byte[] getCivicAddress() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.CIVIC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setCivicAddress()
   */
  public void setCivicAddress(byte[] civicAddress) {
    addAvp(EPCLocationProtocolAVPCodes.CIVIC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, civicAddress);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#hasBarometricPressure()
   */
  public boolean hasBarometricPressure() {
    return hasAvp(EPCLocationProtocolAVPCodes.BAROMETRIC_PRESSURE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#getBarometricPressure()
   */
  public long getBarometricPressure() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.BAROMETRIC_PRESSURE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportRequest#setBarometricPressure()
   */
  public void setBarometricPressure(long barometricPressure) {
    addAvp(EPCLocationProtocolAVPCodes.BAROMETRIC_PRESSURE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, barometricPressure);
  }

  /*
   * (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getLongName()
   */
  public String getLongName() {
    return "Location-Report-Request";
  }

  /* (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getShortName()
   */
  public String getShortName() {
    return "LRR";
  }

}

