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

import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;

import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.ExperimentalResultAvpImpl;

import net.java.slee.resource.diameter.slg.events.LocationReportAnswer;
import net.java.slee.resource.diameter.slg.events.avp.ELPAVPCodes;
import net.java.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvp;
import net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp;

import org.mobicents.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl;

/**
 * Implementation for {@link LocationReportAnswer}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class LocationReportAnswerImpl extends DiameterMessageImpl implements LocationReportAnswer {

  /**
   * @param message
   */
  public LocationReportAnswerImpl(Message message) {
    super(message);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasExperimentalResult()
   */
  public boolean hasExperimentalResult() {
    return hasAvp(DiameterAvpCodes.EXPERIMENTAL_RESULT);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getExperimentalResult()
   */
  public ExperimentalResultAvp getExperimentalResult() {
    return (ExperimentalResultAvp) getAvpAsCustom(DiameterAvpCodes.EXPERIMENTAL_RESULT, ExperimentalResultAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setExperimentalResult(net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp)
   */
  public void setExperimentalResult(ExperimentalResultAvp experimentalResult) {
    addAvp(DiameterAvpCodes.EXPERIMENTAL_RESULT, experimentalResult.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasAuthSessionState()
   */
  public boolean hasAuthSessionState() {
    return hasAvp(DiameterAvpCodes.AUTH_SESSION_STATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getAuthSessionState()
   */
  public AuthSessionStateType getAuthSessionState() {
    return (AuthSessionStateType) getAvpAsEnumerated(DiameterAvpCodes.AUTH_SESSION_STATE, AuthSessionStateType.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setAuthSessionState(net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType)
   */
  public void setAuthSessionState(AuthSessionStateType authSessionState) {
    addAvp(DiameterAvpCodes.AUTH_SESSION_STATE, authSessionState.getValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasGMLCAddress()
   */
  @Override
  public boolean hasGMLCAddress() {
    return hasAvp(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getGMLCAddress()
   */
  @Override
  public Address getGMLCAddress() {
    return getAvpAsAddress(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setGMLCAddress(net.java.slee.resource.diameter.base.events.avp.Address)
   */
  @Override
  public void setGMLCAddress(Address gmlcAddress) {
    addAvp(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID, gmlcAddress);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasLRAFlags()
   */
  @Override
  public boolean hasLRAFlags() {
    return hasAvp(ELPAVPCodes.LRA_FLAGS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getLRAFlags()
   */
  @Override
  public long getLRAFlags() {
    return getAvpAsUnsigned32(ELPAVPCodes.LRA_FLAGS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setLRAFlags(java.lang.Long)
   */
  @Override
  public void setLRAFlags(long plaFlags) {
    addAvp(ELPAVPCodes.LRA_FLAGS, ELPAVPCodes.SLg_VENDOR_ID, plaFlags);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasReportingPLMNList()
   */
  @Override
  public boolean hasReportingPLMNList() {
    return hasAvp(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getReportingPLMNList()
   */
  @Override
  public ReportingPLMNListAvp getReportingPLMNList() {
    return (ReportingPLMNListAvp) getAvpAsCustom(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID, ReportingPLMNListAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setReportingPLMNList(net.java.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvp)
   */
  @Override
  public void setReportingPLMNList(ReportingPLMNListAvp reportingPLMNList) throws IllegalStateException {
    addAvp(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID, reportingPLMNList.byteArrayValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasLCSReferenceNumber()
   */
  @Override
  public boolean hasLCSReferenceNumber() {
    return hasAvp(ELPAVPCodes.LCS_REFERENCE_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getLCSReferenceNumber()
   */
  @Override
  public byte[] getLCSReferenceNumber() {
    return getAvpAsOctetString(ELPAVPCodes.LCS_REFERENCE_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setLCSReferenceNumber(byte[])
   */
  @Override
  public void setLCSReferenceNumber(byte[] lcsReferenceNumber) throws IllegalStateException {
    addAvp(ELPAVPCodes.LCS_REFERENCE_NUMBER, ELPAVPCodes.SLg_VENDOR_ID, lcsReferenceNumber);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getSupportedFeatureses()
   */
  public SupportedFeaturesAvp[] getSupportedFeatureses() {
    return (SupportedFeaturesAvp[]) getAvpsAsCustom(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, SupportedFeaturesAvpImpl.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setSupportedFeatures(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp)
   */
  public void setSupportedFeatures(SupportedFeaturesAvp supportedFeatures) {
    addAvp(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, supportedFeatures.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setSupportedFeatureses(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp[])
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
    return "Location-Report-Answer";
  }

  /* (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getShortName()
   */
  @Override
  public String getShortName() {
    return "LRA";
  }

}
