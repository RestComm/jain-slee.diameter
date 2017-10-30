package org.mobicents.slee.resource.diameter.slg.events;

import net.java.slee.resource.diameter.base.events.avp.*;

import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.ExperimentalResultAvpImpl;

import static net.java.slee.resource.diameter.slg.events.avp.EPCLocationProtocolAVPCodes.SLg_VENDOR_ID;
import static net.java.slee.resource.diameter.slg.events.avp.EPCLocationProtocolAVPCodes.SUPPORTED_FEATURES;
import net.java.slee.resource.diameter.slg.events.LocationReportAnswer;
import net.java.slee.resource.diameter.slg.events.avp.*;

/**
 * Implementation for {@link LocationReportAnswer}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */

public class LocationReportAnswerImpl extends DiameterMessageImpl implements LocationReportAnswer {

  /**
   * @param message
   */
  public LocationReportAnswerImpl(Message message) {
    super(message);
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
//

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasGMLCAddress()
   */
  public boolean hasGMLCAddress() {
    return hasAvp(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getGMLCAddress()
   */
  public Address getGMLCAddress() {
    return getAvpAsAddress(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setGMLCAddress()
   */
  public void setGMLCAddress(Address gmlcAddress) {
    addAvp(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, gmlcAddress);
  }

  /* (non-Javadoc)
    * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasLRAFlags()
    */
  public boolean hasLRAFlags() {
    return hasAvp(EPCLocationProtocolAVPCodes.LRA_FLAGS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getLRAFlags()
   */
  public long getLRAFlags() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LRA_FLAGS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setLRAFlags()
   */
  public void setLRAFlags(long plaFlags) {
    addAvp(EPCLocationProtocolAVPCodes.LRA_FLAGS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, plaFlags);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasReportingPLMNList()
   */
  @Override
  public boolean hasReportingPLMNList() {
    return hasAvp(EPCLocationProtocolAVPCodes.REPORTING_PLMN_LIST, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getReportingPLMNList()
   */
  @Override
  public ReportingPLMNListAvp getReportingPLMNList() {
    return (ReportingPLMNListAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.REPORTING_PLMN_LIST, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, ReportingPLMNListAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setReportingPLMNList()
   */
  @Override
  public void setReportingPLMNList(ReportingPLMNListAvp reportingPLMNList) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.REPORTING_PLMN_LIST, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, reportingPLMNList);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasPLMNIDList()
   */
  @Override
  public boolean hasPLMNIDList() {
    return hasAvp(EPCLocationProtocolAVPCodes.PLMN_ID_LIST, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getPLMNIDList()
   */
  @Override
  public PLMNIDListAvp getPLMNIDList() {
    return (PLMNIDListAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.PLMN_ID_LIST, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, PLMNIDListAvp.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setPLMNIDList()
   */
  @Override
  public void setPLMNIDList(PLMNIDListAvp plmnIDList) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.PLMN_ID_LIST, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, plmnIDList);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasPrioritizedListIndicator()
   */
  @Override
  public boolean hasPrioritizedListIndicator() {
    return hasAvp(EPCLocationProtocolAVPCodes.PRIORITIZED_LIST_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getPrioritizedListIndicator()
   */
  @Override
  public PrioritizedListIndicator getPrioritizedListIndicator() {
    return (PrioritizedListIndicator) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.PRIORITIZED_LIST_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, PrioritizedListIndicator.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setPrioritizedListIndicator()
   */
  @Override
  public void setPrioritizedListIndicator(PrioritizedListIndicator prioritizedListIndicator) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.PRIORITIZED_LIST_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, prioritizedListIndicator);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasVisitedPLMNId()
   */
  @Override
  public boolean hasVisitedPLMNId() {
    return hasAvp(EPCLocationProtocolAVPCodes.VISITED_PLMN_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getVisitedPLMNId()
   */
  @Override
  public byte[] getVisitedPLMNId() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.VISITED_PLMN_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setVisitedPLMNId()
   */
  @Override
  public void setVisitedPLMNId(byte[] visitedPLMNId) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.VISITED_PLMN_ID, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, visitedPLMNId);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#hasPeriodicLocationSupportIndicator()
   */
  @Override
  public boolean hasPeriodicLocationSupportIndicator() {
    return hasAvp(EPCLocationProtocolAVPCodes.PERIODIC_LOCATION_SUPPORT_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#getPeriodicLocationSupportIndicator()
   */
  @Override
  public PeriodicLocationSupportIndicator getPeriodicLocationSupportIndicator() {
    return (PeriodicLocationSupportIndicator) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.PERIODIC_LOCATION_SUPPORT_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, PeriodicLocationSupportIndicator.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slg.events.LocationReportAnswer#setPeriodicLocationSupportIndicator()
   */
  @Override
  public void setPeriodicLocationSupportIndicator(PeriodicLocationSupportIndicator periodicLocationSupportIndicator) throws IllegalStateException {
    addAvp(EPCLocationProtocolAVPCodes.PERIODIC_LOCATION_SUPPORT_INDICATOR, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, periodicLocationSupportIndicator);
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
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getLongName()
   */
  public String getLongName() {
    return "Location-Report-Answer";
  }

  /* (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getShortName()
   */
  public String getShortName() {
    return "LRA";
  }

}
