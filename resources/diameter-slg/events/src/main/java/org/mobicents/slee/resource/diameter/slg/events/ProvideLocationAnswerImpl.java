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

import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp;
import net.java.slee.resource.diameter.slg.events.avp.ELPAVPCodes;
import net.java.slee.resource.diameter.slg.events.avp.AccuracyFulfilmentIndicator;
import net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp;

import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.ExperimentalResultAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl;

import net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer;

/**
 * Implementation for {@link ProvideLocationAnswer}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class ProvideLocationAnswerImpl extends DiameterMessageImpl implements ProvideLocationAnswer {

  /**
   * @param message
   */
  public ProvideLocationAnswerImpl(Message message) {
    super(message);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasExperimentalResult()
   */
  public boolean hasExperimentalResult() {
    return hasAvp(DiameterAvpCodes.EXPERIMENTAL_RESULT);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getExperimentalResult()
   */
  public ExperimentalResultAvp getExperimentalResult() {
    return (ExperimentalResultAvp) getAvpAsCustom(DiameterAvpCodes.EXPERIMENTAL_RESULT, ExperimentalResultAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setExperimentalResult(net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp)
   */
  public void setExperimentalResult(ExperimentalResultAvp experimentalResult) {
    addAvp(DiameterAvpCodes.EXPERIMENTAL_RESULT, experimentalResult.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasAuthSessionState()
   */
  public boolean hasAuthSessionState() {
    return hasAvp(DiameterAvpCodes.AUTH_SESSION_STATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getAuthSessionState()
   */
  public AuthSessionStateType getAuthSessionState() {
    return (AuthSessionStateType) getAvpAsEnumerated(DiameterAvpCodes.AUTH_SESSION_STATE, AuthSessionStateType.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setAuthSessionState(net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType)
   */
  public void setAuthSessionState(AuthSessionStateType authSessionState) {
    addAvp(DiameterAvpCodes.AUTH_SESSION_STATE, authSessionState.getValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasLocationEstimate()
   */
  @Override
  public boolean hasLocationEstimate() {
    return hasAvp(ELPAVPCodes.LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getLocationEstimate()
   */
  @Override
  public byte[] getLocationEstimate() {
    return getAvpAsOctetString(ELPAVPCodes.LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setLocationEstimate(byte[])
   */
  @Override
  public void setLocationEstimate(byte[] locationEstimate) {
    addAvp(ELPAVPCodes.LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID, locationEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasAccuracyFulfilmentIndicator()
   */
  @Override
  public boolean hasAccuracyFulfilmentIndicator() {
    return hasAvp(ELPAVPCodes.ACCURACY_FULFILMENT_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getAccuracyFulfilmentIndicator()
   */
  @Override
  public AccuracyFulfilmentIndicator getAccuracyFulfilmentIndicator() {
    return (AccuracyFulfilmentIndicator) getAvpAsEnumerated(ELPAVPCodes.ACCURACY_FULFILMENT_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID, AccuracyFulfilmentIndicator.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setAccuracyFulfilmentIndicator(net.java.slee.resource.diameter.slg.events.avp.AccuracyFulfilmentIndicator)
   */
  @Override
  public void setAccuracyFulfilmentIndicator(AccuracyFulfilmentIndicator accuracyFulfilmentIndicator) {
    addAvp(ELPAVPCodes.ACCURACY_FULFILMENT_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID, accuracyFulfilmentIndicator.getValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasAgeOfLocationEstimate()
   */
  @Override
  public boolean hasAgeOfLocationEstimate() {
    return hasAvp(ELPAVPCodes.AGE_OF_LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getAgeOfLocationEstimate()
   */
  @Override
  public long getAgeOfLocationEstimate() {
    return getAvpAsUnsigned32(ELPAVPCodes.AGE_OF_LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setAgeOfLocationEstimate(java.lang.Long)
   */
  @Override
  public void setAgeOfLocationEstimate(long ageOfLocationEstimate) {
    addAvp(ELPAVPCodes.AGE_OF_LOCATION_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID, ageOfLocationEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasVelocityEstimate()
   */
  @Override
  public boolean hasVelocityEstimate() {
    return hasAvp(ELPAVPCodes.VELOCITY_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getVelocityEstimate()
   */
  @Override
  public byte[] getVelocityEstimate() {
    return getAvpAsOctetString(ELPAVPCodes.VELOCITY_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setVelocityEstimate(byte[])
   */
  @Override
  public void setVelocityEstimate(byte[] velocityEstimate) {
    addAvp(ELPAVPCodes.VELOCITY_ESTIMATE, ELPAVPCodes.SLg_VENDOR_ID, velocityEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasEUTRANPositioningData()
   */
  @Override
  public boolean hasEUTRANPositioningData() {
    return hasAvp(ELPAVPCodes.EUTRAN_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getEUTRANPositioningData()
   */
  @Override
  public byte[] getEUTRANPositioningData() {
    return getAvpAsOctetString(ELPAVPCodes.EUTRAN_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setEUTRANPositioningData(byte[])
   */
  @Override
  public void setEUTRANPositioningData(byte[] eutranPositioningData) {
    addAvp(ELPAVPCodes.EUTRAN_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID, eutranPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasECGI()
   */
  @Override
  public boolean hasECGI() {
    return hasAvp(ELPAVPCodes.ECGI, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getECGI()
   */
  @Override
  public byte[] getECGI() {
    return getAvpAsOctetString(ELPAVPCodes.ECGI, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setECGI(byte[])
   */
  @Override
  public void setECGI(byte[] ecgi) {
    addAvp(ELPAVPCodes.ECGI, ELPAVPCodes.SLg_VENDOR_ID, ecgi);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasGERANPositioningInfo()
   */
  @Override
  public boolean hasGERANPositioningInfo() {
    return hasAvp(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getGERANPositioningInfo()
   */
  @Override
  public GERANPositioningInfoAvp getGERANPositioningInfo() {
    return (GERANPositioningInfoAvp) getAvpAsCustom(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, GERANPositioningInfoAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setGERANPositioningInfo(net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp)
   */
  @Override
  public void setGERANPositioningInfo(GERANPositioningInfoAvp geranPositioningInfo) {
    addAvp(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, geranPositioningInfo.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasCellGlobalIdentity()
   */
  @Override
  public boolean hasCellGlobalIdentity() {
    return hasAvp(ELPAVPCodes.CELL_GLOBAL_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getCellGlobalIdentity()
   */
  @Override
  public byte[] getCellGlobalIdentity() {
    return getAvpAsOctetString(ELPAVPCodes.CELL_GLOBAL_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setCellGlobalIdentity(byte[])
   */
  @Override
  public void setCellGlobalIdentity(byte[] cellGlobalIdentity) {
    addAvp(ELPAVPCodes.CELL_GLOBAL_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID, cellGlobalIdentity);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasUTRANPositioningInfo()
   */
  @Override
  public boolean hasUTRANPositioningInfo() {
    return hasAvp(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getUTRANPositioningInfo()
   */
  @Override
  public UTRANPositioningInfoAvp getUTRANPositioningInfo() {
    return (UTRANPositioningInfoAvp) getAvpAsCustom(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, UTRANPositioningInfoAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setUTRANPositioningInfo(net.java.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvp)
   */
  @Override
  public void setUTRANPositioningInfo(UTRANPositioningInfoAvp utranPositioningInfo) {
    addAvp(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, utranPositioningInfo.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasServiceAreaIdentity()
   */
  @Override
  public boolean hasServiceAreaIdentity() {
    return hasAvp(ELPAVPCodes.SERVICE_AREA_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getServiceAreaIdentity()
   */
  @Override
  public byte[] getServiceAreaIdentity() {
    return getAvpAsOctetString(ELPAVPCodes.SERVICE_AREA_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setServiceAreaIdentity(byte[])
   */
  @Override
  public void setServiceAreaIdentity(byte[] serviceAreaIdentity) {
    addAvp(ELPAVPCodes.SERVICE_AREA_IDENTITY, ELPAVPCodes.SLg_VENDOR_ID, serviceAreaIdentity);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasServingNode()
   */
  @Override
  public boolean hasServingNode() {
    return hasAvp(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getServingNode()
   */
  @Override
  public ServingNodeAvp getServingNode() {
    return (ServingNodeAvp) getAvpAsCustom(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, ServingNodeAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setServingNode(net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp)
   */
  @Override
  public void setServingNode(ServingNodeAvp servingNode) {
    addAvp(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, servingNode.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasPLAFlags()
   */
  @Override
  public boolean hasPLAFlags() {
    return hasAvp(ELPAVPCodes.PLA_FLAGS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getPLAFlags()
   */
  @Override
  public long getPLAFlags() {
    return getAvpAsUnsigned32(ELPAVPCodes.PLA_FLAGS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setPLAFlags(java.lang.Long)
   */
  @Override
  public void setPLAFlags(long plaFlags) {
    addAvp(ELPAVPCodes.PLA_FLAGS, ELPAVPCodes.SLg_VENDOR_ID, plaFlags);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasESMLCCellInfo()
   */
  @Override
  public boolean hasESMLCCellInfo() {
    return hasAvp(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getESMLCCellInfo()
   */
  @Override
  public ESMLCCellInfoAvp getESMLCCellInfo() {
    return (ESMLCCellInfoAvp) getAvpAsCustom(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID, ESMLCCellInfoAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setESMLCCellInfo(net.java.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvp)
   */
  @Override
  public void setESMLCCellInfo(ESMLCCellInfoAvp esmlcCellInfo) {
    addAvp(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID, esmlcCellInfo.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasCivicAddress()
   */
  @Override
  public boolean hasCivicAddress() {
    return hasAvp(ELPAVPCodes.CIVIC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getCivicAddress()
   */
  @Override
  public byte[] getCivicAddress() {
    return getAvpAsOctetString(ELPAVPCodes.CIVIC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setCivicAddress(byte[])
   */
  @Override
  public void setCivicAddress(byte[] civicAddress) {
    addAvp(ELPAVPCodes.CIVIC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID, civicAddress);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasBarometricPressure()
   */
  @Override
  public boolean hasBarometricPressure() {
    return hasAvp(ELPAVPCodes.BAROMETRIC_PRESSURE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getBarometricPressure()
   */
  @Override
  public long getBarometricPressure() {
    return getAvpAsUnsigned32(ELPAVPCodes.BAROMETRIC_PRESSURE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setBarometricPressure(java.lang.Long)
   */
  @Override
  public void setBarometricPressure(long barometricPressure) {
    addAvp(ELPAVPCodes.BAROMETRIC_PRESSURE, ELPAVPCodes.SLg_VENDOR_ID, barometricPressure);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getSupportedFeatureses()
   */
  public SupportedFeaturesAvp[] getSupportedFeatureses() {
    return (SupportedFeaturesAvp[]) getAvpsAsCustom(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, SupportedFeaturesAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setSupportedFeatures(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp)
   */
  public void setSupportedFeatures(SupportedFeaturesAvp supportedFeatures) {
    addAvp(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, supportedFeatures.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setSupportedFeatureses(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp[])
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
    return "Provide-Location-Answer";
  }

  /* (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getShortName()
   */
  @Override
  public String getShortName() {
    return "PLA";
  }

}
