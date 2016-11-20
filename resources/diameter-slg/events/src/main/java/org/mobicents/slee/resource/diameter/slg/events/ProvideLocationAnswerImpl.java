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

import net.java.slee.resource.diameter.base.events.avp.*;

import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.ExperimentalResultAvpImpl;

import static net.java.slee.resource.diameter.slg.events.avp.EPCLocationProtocolAVPCodes.SLg_VENDOR_ID;
import static net.java.slee.resource.diameter.slg.events.avp.EPCLocationProtocolAVPCodes.SUPPORTED_FEATURES;
import net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer;
import net.java.slee.resource.diameter.slg.events.avp.*;

/**
 * Implementation for {@link ProvideLocationAnswer}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class ProvideLocationAnswerImpl extends DiameterMessageImpl implements ProvideLocationAnswer {

  /**
   * @param message
   */
  public ProvideLocationAnswerImpl(Message message) {
    super(message);
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

//  /* (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setSupportedFeatures(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp)
//   */
//  public void setSupportedFeatures(SupportedFeaturesAvp supportedFeatures) {
//    addAvp(SUPPORTED_FEATURES, SLg_VENDOR_ID, supportedFeatures.byteArrayValue());
//  }
//
//  /* (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setSupportedFeatureses(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp[])
//   */
//  public void setSupportedFeatureses(SupportedFeaturesAvp[] supportedFeatureses) {
//    for (SupportedFeaturesAvp supportedFeatures : supportedFeatureses) {
//      setSupportedFeatures(supportedFeatures);
//    }
//  }
//
//  /* (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getSupportedFeatureses()
//   */
//  public SupportedFeaturesAvp[] getSupportedFeatureses() {
//    return (SupportedFeaturesAvp[]) getAvpsAsCustom(SUPPORTED_FEATURES, SLg_VENDOR_ID, SupportedFeaturesAvpImpl.class);

//  /* (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#has()
//   */
//  public boolean hasResultCode() {
//    return hasAvp(EPCLocationProtocolAVPCodes.RESULT_CODE);
//  }
//
//  /* (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#get()
//   */
//  public long getResultCode() {
//    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.RESULT_CODE);
//  }
//
//  /* (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setAuthSessionState(net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType)
//   */
//  public void setResultCode(long resultCode ) {
//    addAvp(EPCLocationProtocolAVPCodes.RESULT_CODE, resultCode);
//  }

//  /* (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasExperimentalResult()
//   */
//  public boolean hasExperimentalResult() {
//    return hasAvp(DiameterAvpCodes.EXPERIMENTAL_RESULT);
//  }
//
//  /* (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getExperimentalResult()
//   */
//  public ExperimentalResultAvp getExperimentalResult() {
//    return (ExperimentalResultAvp) getAvpAsCustom(DiameterAvpCodes.EXPERIMENTAL_RESULT, ExperimentalResultAvpImpl.class);
//  }
//
//  /* (non-Javadoc)
//   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setExperimentalResult(net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp)
//   */
//  public void setExperimentalResult(ExperimentalResultAvp experimentalResult) {
//    addAvp(DiameterAvpCodes.EXPERIMENTAL_RESULT, experimentalResult.byteArrayValue());
//  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasLocationEstimate()
   */
  public boolean hasLocationEstimate() {
    return hasAvp(EPCLocationProtocolAVPCodes.LOCATION_ESTIMATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getLocationEstimate()
   */
  public byte[] getLocationEstimate() {
    return  getAvpAsOctetString(EPCLocationProtocolAVPCodes.LOCATION_ESTIMATE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setLocationEstimate
   */
  public void setLocationEstimate(byte[] locationEstimate) {
    addAvp(EPCLocationProtocolAVPCodes.LOCATION_ESTIMATE, locationEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasAccuracyFulfilmentIndicator()
   */
  public boolean hasAccuracyFulfilmentIndicator() {
    return hasAvp(EPCLocationProtocolAVPCodes.ACCURACY_FULFILMENT_INDICATOR);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getAccuracyFulfilmentIndicator()
   */
  public AccuracyFulfilmentIndicator getAccuracyFulfilmentIndicator() {
    return (AccuracyFulfilmentIndicator) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.ACCURACY_FULFILMENT_INDICATOR, AccuracyFulfilmentIndicator.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setAccuracyFulfilmentIndicator()
   */
  public void setAccuracyFulfilmentIndicator(AccuracyFulfilmentIndicator accuracyFulfilmentIndicator) {
    addAvp(EPCLocationProtocolAVPCodes.ACCURACY_FULFILMENT_INDICATOR, accuracyFulfilmentIndicator);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasAgeOfLocationEstimate()
   */
  public boolean hasAgeOfLocationEstimate() {
    return hasAvp(EPCLocationProtocolAVPCodes.AGE_OF_LOCATION_ESTIMATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getAgeOfLocationEstimate()
   */
  public long getAgeOfLocationEstimate() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.AGE_OF_LOCATION_ESTIMATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setAgeOfLocationEstimate()
   */
  public void setAgeOfLocationEstimate(long ageOfLocationEstimate) {
    addAvp(EPCLocationProtocolAVPCodes.AGE_OF_LOCATION_ESTIMATE, ageOfLocationEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasVelocityEstimate()
   */
  public boolean hasVelocityEstimate() {
    return hasAvp(EPCLocationProtocolAVPCodes.VELOCITY_ESTIMATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getVelocityEstimate()
   */
  public byte[] getVelocityEstimate() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.VELOCITY_ESTIMATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setVelocityEstimate()
   */
  public void setVelocityEstimate(byte[] velocityEstimate) {
    addAvp(EPCLocationProtocolAVPCodes.VELOCITY_ESTIMATE, velocityEstimate);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasEUTRANPositioningData()
   */
  public boolean hasEUTRANPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.EUTRAN_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getEUTRANPositioningData()
   */
  public byte[] getEUTRANPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.EUTRAN_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setEUTRANPositioningData()
   */
  public void setEUTRANPositioningData(byte[] eutranPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.EUTRAN_POSITIONING_DATA, eutranPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasECGI()
   */
  public boolean hasECGI() {
    return hasAvp(EPCLocationProtocolAVPCodes.ECGI
    );
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getECGI()
   */
  public byte[] getECGI() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.ECGI);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setECGI()
   */
  public void setECGI(byte[] ecgi) {
    addAvp(EPCLocationProtocolAVPCodes.ECGI, ecgi);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasGERANPositioningInfo()
   */
  public boolean hasGERANPositioningInfo() {
    return hasAvp(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_INFO);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getGERANPositioningInfo()
   */
  public GERANPositioningInfoAvp getGERANPositioningInfo() {
    return (GERANPositioningInfoAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, GERANPositioningInfoAvp.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setGERANPositioningInfo()
   */
  public void setGERANPositioningInfo(GERANPositioningInfoAvp geranPositioningInfo) {
    addAvp(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_INFO, geranPositioningInfo);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasGERANPositioningData()
   */
  public boolean hasGERANPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getGERANPositioningData()
   */
  public byte[] getGERANPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setGERANPositioningData()
   */
  public void setGERANPositioningData(byte[] geranPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.GERAN_POSITIONING_DATA, geranPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasGERANGANSSPositioningData()
   */
  public boolean hasGERANGANSSPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.GERAN_GANSS_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getGERANGANSSPositioningData()
   */
  public byte[] getGERANGANSSPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.GERAN_GANSS_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setGERANGANSSPositioningData()
   */
  public void setGERANGANSSPositioningData(byte[] geranganssPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.GERAN_GANSS_POSITIONING_DATA, geranganssPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasCellGlobalIdentity()
   */
  public boolean hasCellGlobalIdentity() {
    return hasAvp(EPCLocationProtocolAVPCodes.CELL_GLOBAL_IDENTITY);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getCellGlobalIdentity()
   */
  public byte[] getCellGlobalIdentity() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.CELL_GLOBAL_IDENTITY);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setCellGlobalIdentity()
   */
  public void setCellGlobalIdentity(byte[] cellGlobalIdentity) {
    addAvp(EPCLocationProtocolAVPCodes.CELL_GLOBAL_IDENTITY, cellGlobalIdentity);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasUTRANPositioningInfo()
   */
  public boolean hasUTRANPositioningInfo() {
    return hasAvp(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_INFO);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getUTRANPositioningInfo()
   */
  public UTRANPositioningInfoAvp getUTRANPositioningInfo() {
    return (UTRANPositioningInfoAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, UTRANPositioningInfoAvp.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setUTRANPositioningInfo()
   */
  public void setUTRANPositioningInfo(UTRANPositioningInfoAvp utranPositioningInfo) {
    addAvp(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_INFO, utranPositioningInfo);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasUTRANPositioningData()
   */
  public boolean hasUTRANPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getUTRANPositioningData()
   */
  public byte[] getUTRANPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setUTRANPositioningData()
   */
  public void setUTRANPositioningData(byte[] utranPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.UTRAN_POSITIONING_DATA, utranPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasUTRANGANSSPositioningData()
   */
  public boolean hasUTRANGANSSPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.UTRAN_GANSS_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getUTRANGANSSPositioningData()
   */
  public byte[] getUTRANGANSSPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.UTRAN_GANSS_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setUTRANGANSSPositioningData()
   */
  public void setUTRANGANSSPositioningData(byte[] utranGANSSPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.UTRAN_GANSS_POSITIONING_DATA, utranGANSSPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasUTRANAdditionalPositioningData()
   */
  public boolean hasUTRANAdditionalPositioningData() {
    return hasAvp(EPCLocationProtocolAVPCodes.UTRAN_ADDITIONAL_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getUTRANAdditionalPositioningData()
   */
  public byte[] getUTRANAdditionalPositioningData() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.UTRAN_ADDITIONAL_POSITIONING_DATA);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setUTRANPositioningData()
   */
  public void setUTRANAdditionalPositioningData(byte[] utranAdditionalPositioningData) {
    addAvp(EPCLocationProtocolAVPCodes.UTRAN_ADDITIONAL_POSITIONING_DATA, utranAdditionalPositioningData);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasServiceAreaIdentity()
   */
  public boolean hasServiceAreaIdentity() {
    return hasAvp(EPCLocationProtocolAVPCodes.SERVICE_AREA_IDENTITY);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getServiceAreaIdentity()
   */
  public byte[] getServiceAreaIdentity() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.SERVICE_AREA_IDENTITY);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setServiceAreaIdentity()
   */
  public void setServiceAreaIdentity(byte[] serviceAreaIdentity) {
    addAvp(EPCLocationProtocolAVPCodes.SERVICE_AREA_IDENTITY, serviceAreaIdentity);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasServingNode()
   */
  public boolean hasServingNode() {
    return hasAvp(EPCLocationProtocolAVPCodes.SERVING_NODE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getServingNode()
   */
  public ServingNodeAvp getServingNode() {
    return (ServingNodeAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.SERVING_NODE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, ServingNodeAvp.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setServingNode()
   */
  public void setServingNode(ServingNodeAvp servingNode) {
    addAvp(EPCLocationProtocolAVPCodes.SERVING_NODE, servingNode);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasSGSNNumber()
   */
  public boolean hasSGSNNumber() {
    return hasAvp(EPCLocationProtocolAVPCodes.SGSN_NUMBER);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getSGSNNumber()
   */
  public byte[] getSGSNNumber() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.SGSN_NUMBER);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setSGSNNumber()
   */
  public void setSGSNNumber(byte[] sgsnNumber) {
    addAvp(EPCLocationProtocolAVPCodes.SGSN_NUMBER, sgsnNumber);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasSGSNName()
   */
  public boolean hasSGSNName() {
    return hasAvp(EPCLocationProtocolAVPCodes.SGSN_NAME);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getSGSNName()
   */
  public DiameterIdentity getSGSNName() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.SGSN_NAME);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setSGSNName()
   */
  public void setSGSNName(DiameterIdentity sgsnName) {
    addAvp(EPCLocationProtocolAVPCodes.SGSN_NAME, sgsnName);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasSGSNRealm()
   */
  public boolean hasSGSNRealm() {
    return hasAvp(EPCLocationProtocolAVPCodes.SGSN_REALM);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getSGSNRealm()
   */
  public DiameterIdentity getSGSNRealm() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.SGSN_REALM);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setSGSNRealm()
   */
  public void setSGSNRealm(DiameterIdentity sgsnRealm) {
    addAvp(EPCLocationProtocolAVPCodes.SGSN_REALM, sgsnRealm);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasMMEName()
   */
  public boolean hasMMEName() {
    return hasAvp(EPCLocationProtocolAVPCodes.MME_NAME);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getMMEName()
   */
  public DiameterIdentity getMMEName() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.MME_NAME);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setMMEName()
   */
  public void setMMEName(DiameterIdentity mmeName) {
    addAvp(EPCLocationProtocolAVPCodes.MME_NAME, mmeName);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasMMERealm()
   */
  public boolean hasMMERealm() {
    return hasAvp(EPCLocationProtocolAVPCodes.MME_REALM);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getMMERealm()
   */
  public DiameterIdentity getMMERealm() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.MME_REALM);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setMMERealm()
   */
  public void setMMERealm(DiameterIdentity mmeRealm) {
    addAvp(EPCLocationProtocolAVPCodes.MME_REALM, mmeRealm);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasMSCNumber()
   */
  public boolean hasMSCNumber() {
    return hasAvp(EPCLocationProtocolAVPCodes.MSC_NUMBER);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getMSCNumber()
   */
  public byte[] getMSCNumber() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.MSC_NUMBER);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setMSCNumber()
   */
  public void setMSCNumber(byte[] mscNumber) {
    addAvp(EPCLocationProtocolAVPCodes.MSC_NUMBER, mscNumber);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#has3GPPAAAServerName()
   */
  public boolean has3GPPAAAServerName() {
    return hasAvp(EPCLocationProtocolAVPCodes.TGPP_AAA_SERVER_NAME);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#get3GPPAAAServerName()
   */
  public DiameterIdentity get3GPPAAAServerName() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.TGPP_AAA_SERVER_NAME);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#set3GPPAAAServerName()
   */
  public void set3GPPAAAServerName(DiameterIdentity tgppAAAServerName) {
    addAvp(EPCLocationProtocolAVPCodes.TGPP_AAA_SERVER_NAME, tgppAAAServerName);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasLCSCapabilitiesSets()
   */
  public boolean hasLCSCapabilitiesSets() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_CAPABILITIES_SETS);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getLCSCapabilitiesSets()
   */
  public long getLCSCapabilitiesSets() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LCS_CAPABILITIES_SETS);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setLCSCapabilitiesSets()
   */
  public void setLCSCapabilitiesSets(long lcsCapabilitiesSets) {
    addAvp(EPCLocationProtocolAVPCodes.LCS_CAPABILITIES_SETS, lcsCapabilitiesSets);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasGMLCAddress()
   */
  public boolean hasGMLCAddress() {
    return hasAvp(EPCLocationProtocolAVPCodes.GMLC_ADDRESS);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getGMLCAddress()
   */
  public Address getGMLCAddress() {
    return getAvpAsAddress(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setGMLCAddress()
   */
  public void setGMLCAddress(Address gmlcAddress) {
    addAvp(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, gmlcAddress);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasPLAFlags()
   */
  public boolean hasPLAFlags() {
    return hasAvp(EPCLocationProtocolAVPCodes.PLA_FLAGS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getPLAFlags()
   */
  public long getPLAFlags() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.PLA_FLAGS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setPLAFlags()
   */
  public void setPLAFlags(long plaFlags) {
    addAvp(EPCLocationProtocolAVPCodes.PLA_FLAGS, plaFlags);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasESMLCCellInfo()
   */
  public boolean hasESMLCCellInfo() {
    return hasAvp(EPCLocationProtocolAVPCodes.ESMLC_CELL_INFO);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getESMLCCellInfo()
   */
  public ESMLCCellInfoAvp getESMLCCellInfo() {
    return (ESMLCCellInfoAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.ESMLC_CELL_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, ESMLCCellInfoAvp.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setESMLCCellInfo()
   */
  public void setESMLCCellInfo(ESMLCCellInfoAvp esmlcCellInfo) {
    addAvp(EPCLocationProtocolAVPCodes.ESMLC_CELL_INFO, esmlcCellInfo);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasCellPortionID()
   */
  public boolean hasCellPortionID() {
    return hasAvp(EPCLocationProtocolAVPCodes.CELL_PORTION_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getCellPortionID()
   */
  public long getCellPortionID() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.CELL_PORTION_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setCellPortionID()
   */
  public void setCellPortionID(long cellPortionID) {
    addAvp(EPCLocationProtocolAVPCodes.CELL_PORTION_ID, cellPortionID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasCivicAddress()
   */
  public boolean hasCivicAddress() {
    return hasAvp(EPCLocationProtocolAVPCodes.CIVIC_ADDRESS);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getCivicAddress()
   */
  public byte[] getCivicAddress() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.CIVIC_ADDRESS);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setCivicAddress()
   */
  public void setCivicAddress(byte[] civicAddress) {
    addAvp(EPCLocationProtocolAVPCodes.CIVIC_ADDRESS, civicAddress);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#hasBarometricPressure()
   */
  public boolean hasBarometricPressure() {
    return hasAvp(EPCLocationProtocolAVPCodes.BAROMETRIC_PRESSURE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#getBarometricPressure()
   */
  public long getBarometricPressure() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.BAROMETRIC_PRESSURE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer#setBarometricPressure()
   */
  public void setBarometricPressure(long barometricPressure) {
    addAvp(EPCLocationProtocolAVPCodes.BAROMETRIC_PRESSURE, barometricPressure);
  }

  /*
   * (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getLongName()
   */
  public String getLongName() {
    return "Provide-Location-Answer";
  }

  /* (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getShortName()
   */
  public String getShortName() {
    return "PLA";
  }
}
