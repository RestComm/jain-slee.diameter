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

package org.mobicents.slee.resource.diameter.slg;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.base.events.avp.AvpUtilities;
import net.java.slee.resource.diameter.slg.SLgAVPFactory;
import net.java.slee.resource.diameter.slg.events.avp.*;

import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.*;

import static net.java.slee.resource.diameter.slg.events.avp.EPCLocationProtocolAVPCodes.*;

/**
 * Diameter SLg Reference Point AVP Factory. Implementation for {@link SLgAVPFactory}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class SLgAVPFactoryImpl extends DiameterAvpFactoryImpl implements SLgAVPFactory {

  // TODO: Add helper create methods for the composite AVPs
  protected DiameterAvpFactory baseAvpFactory;

  public SLgAVPFactoryImpl(final DiameterAvpFactory baseAvpFactory) {
    this.baseAvpFactory = baseAvpFactory;
  }

  public DiameterAvpFactory getBaseFactory() {
    return this.baseAvpFactory;
  }
/*
  public SLgLocationTypeAvp createSLgLocationTypeAvp() {
    return (SLgLocationTypeAvp) AvpUtilities.createAvp(SLg_LOCATION_TYPE, SLg_VENDOR_ID, null, SLgLocationTypeAvpImpl.class);
  }

  public LCSEPSCLientNameAvp createLCSEPSCLientNameAvp() {
    return (LCSEPSCLientNameAvp) AvpUtilities.createAvp(LCS_EPS_CLIENT_NAME, SLg_VENDOR_ID, null, LCSEPSCLientNameAvpImpl.class);
  }
*/
  public LCSRequestorNameAvp createLCSRequestorNameAvp() {
    return (LCSRequestorNameAvp) AvpUtilities.createAvp(LCS_REQUESTOR_NAME, SLg_VENDOR_ID, null, LCSRequestorNameAvpImpl.class);
  }
/*
  public LCSPriorityAvp createLCSPriorityAvp() {
    return (LCSPriorityAvp) AvpUtilities.createAvp(LCS_PRIORITY, SLg_VENDOR_ID, null, LCSPriorityAvpImpl.class);
  }
*/
  public LCSQoSAvp createLCSQoSAvp() {
    return (LCSQoSAvp) AvpUtilities.createAvp(LCS_QoS, SLg_VENDOR_ID, null, LCSQoSAvpImpl.class);
  }
/*
  public HorizontalAccuracyAvp createHorizontalAccuracyAvp() {
    return (HorizontalAccuracyAvp) AvpUtilities.createAvp(HORIZONTAL_ACCURACY, SLg_VENDOR_ID, null, HorizontalAccuracyAvpImpl.class);
  }

  public VerticalAccuracyAvp createVerticalAccuracyAvp() {
    return (VerticalAccuracyAvp) AvpUtilities.createAvp(VERTICAL_ACCURACY, SLg_VENDOR_ID, null, VerticalAccuracyAvpImpl.class);
  }

  public VerticalRequestedAvp createVerticalRequestedAvp() {
    return (VerticalRequestedAvp) AvpUtilities.createAvp(VERTICAL_REQUESTED, SLg_VENDOR_ID, null, VerticalRequestedAvpImpl.class);
  }

  public VelocityRequestedAvp createVelocityRequestedAvp() {
    return (VelocityRequestedAvp) AvpUtilities.createAvp(VELOCITY_REQUESTED, SLg_VENDOR_ID, null, VelocityRequestedAvpImpl.class);
  }

  public ResponseTimeAvp createResponseTimeAvp() {
    return (ResponseTimeAvp) AvpUtilities.createAvp(RESPONSE_TIME, SLg_VENDOR_ID, null, ResponseTimeAvpImpl.class);
  }

  public SupportedGADShapesAvp createSupportedGADShapesAvp() {
    return (SupportedGADShapesAvp) AvpUtilities.createAvp(SUPPORTED_GAD_SHAPES, SLg_VENDOR_ID, null, SupportedGADShapesAvpImpl.class);
  }

  public LCSCodewordAvp createLCSCodewordAvp() {
    return (LCSCodewordAvp) AvpUtilities.createAvp(LCS_CODEW0RD, SLg_VENDOR_ID, null, LCSCodewordAvpImpl.class);
  }

  public LCSPrivacyCheckAvp createLCSPrivacyCheckAvp() {
    return (LCSPrivacyCheckAvp) AvpUtilities.createAvp(LCS_PRIVACY_CHECK, SLg_VENDOR_ID, null, LCSPrivacyCheckAvpImpl.class);
  }

  public AccuracyFulfilmentIndicatorAvp createAccuracyFulfilmentIndicatorAvp() {
    return (AccuracyFulfilmentIndicatorAvp) AvpUtilities.createAvp(ACCURACY_FULFILMENT_INDICATOR, SLg_VENDOR_ID, null, AccuracyFulfilmentIndicatorAvpImpl.class);
  }

  public AgeOfLocationEstimateAvp createAgeOfLocationEstimate() {
    return (AgeOfLocationEstimateAvp) AvpUtilities.createAvp(AGE_OF_LOCATION_ESTIMATE, SLg_VENDOR_ID, null, AgeOfLocationEstimateAvpImpl.class);
  }

  public VelocityEstimateAvp createVelocity-EstimateAvp() {
    return (VelocityEstimateAvp) AvpUtilities.createAvp(VELOCITY_ESTIMATE, SLg_VENDOR_ID, null, VelocityEstimateAvpImpl.class);
  }

  public EUTRANPositioningDataAvp createEUTRANPositioningDataAvp() {
    return (EUTRANPositioningDataAvp) AvpUtilities.createAvp(EUTRAN_POSITIONING_DATA, SLg_VENDOR_ID, null, EUTRANPositioningDataAvpImpl.class);
  }

  public ECGIAvp createECGIAvp() {
    return (ECGIAvp) AvpUtilities.createAvp(ECGI, SLg_VENDOR_ID, null, ECGIAvpImpl.class);
  }

  public LocationEventAvp createLocationEventAvp() {
    return (LocationEventAvp) AvpUtilities.createAvp(LOCATION_EVENT, SLg_VENDOR_ID, null, LocationEventAvpImpl.class);
  }

  public PseudonymIndicatorAvp createPseudonymIndicatorAvp() {
    return (PseudonymIndicatorAvp) AvpUtilities.createAvp(PSEUDONYM_INDICATOR, SLg_VENDOR_ID, null, PseudonymIndicatorAvpImpl.class);
  }

  public LCSServiceTypeIDAvp createLCSServiceTypeIDAvp() {
    return (LCSServiceTypeIDAvp) AvpUtilities.createAvp(LCS_SERVICE_TYPE_ID, SLg_VENDOR_ID, null, PseudonymIndicatorAvpImpl.class);
  }
*/
  public LCSPrivacyCheckNonSessionAvp createLCSPrivacyCheckNonSessionAvp() {
    return (LCSPrivacyCheckNonSessionAvp) AvpUtilities.createAvp(LCS_PRIVACY_CHECK_NON_SESSION, SLg_VENDOR_ID, null, LCSPrivacyCheckNonSessionAvpImpl.class);
  }

  public LCSPrivacyCheckSessionAvp createLCSPrivacyCheckSessionAvp() {
    return (LCSPrivacyCheckSessionAvp) AvpUtilities.createAvp(LCS_PRIVACY_CHECK_SESSION, SLg_VENDOR_ID, null, LCSPrivacyCheckSessionAvpImpl.class);
  }
/*
  public LCSQoSClassAvp createLCSQoSClassAvp() {
    return (LCSQoSClassAvp) AvpUtilities.createAvp(LCS_QoS_CLASS, SLg_VENDOR_ID, null, LCSQoSClassAvpImpl.class);
  }
*/
  public GERANPositioningInfoAvp createGERANPositioningInfoAvp() {
    return (GERANPositioningInfoAvp) AvpUtilities.createAvp(GERAN_POSITIONING_INFO, SLg_VENDOR_ID, null, GERANPositioningInfoAvpImpl.class);
  }
/*
  public GERANPositioningDataAvp createGERANPositioningDataAvp() {
    return (GERANPositioningDataAvp) AvpUtilities.createAvp(GERAN_POSITIONING_DATA, SLg_VENDOR_ID, null, GERANPositioningDataAvpImpl.class);
  }

  public GERANGANSSPositioningDataAvp createGERANGANSSPositioningDataAvp() {
    return (GERANGANSSPositioningDataAvp) AvpUtilities.createAvp(GERAN_GANSS_POSITIONING_DATA, SLg_VENDOR_ID, null, GERANGANSSPositioningDataAvpImpl.class);
  }
*/
  public UTRANPositioningInfoAvp createUTRANPositioningInfoAvp() {
    return (UTRANPositioningInfoAvp) AvpUtilities.createAvp(UTRAN_POSITIONING_INFO, SLg_VENDOR_ID, null, UTRANPositioningInfoAvpImpl.class);
  }
/*
  public UTRANPositioningDataAvp createUTRANPositioningDataAvp() {
    return (UTRANPositioningDataAvp) AvpUtilities.createAvp(UTRAN_POSITIONING_DATA, SLg_VENDOR_ID, null, UTRANPositioningDataAvpImpl.class);
  }

  public UTRANGANSSPositioningDataAvp createUTRANGANSSPositioningDataAvp() {
    return (UTRANGANSSPositioningDataAvp) AvpUtilities.createAvp(UTRAN_GANSS_POSITIONING_DATA, SLg_VENDOR_ID, null, UTRANGANSSPositioningDataAvpImpl.class);
  }

  public LRRFlagsAvp createLRRFlagsAvp() {
    return (LRRFlagsAvp) AvpUtilities.createAvp(LRR_FLAGS, SLg_VENDOR_ID, null, LRRFlagsAvpImpl.class);
  }

  public LCSReferenceNumberAvp createLCSReferenceNumberAvp() {
    return (LCSReferenceNumberAvp) AvpUtilities.createAvp(LCS_REFERENCE_NUMBER, SLg_VENDOR_ID, null, LCSReferenceNumberAvpImpl.class);
  }

  public OccurrenceInfoAvp createOccurrenceInfoAvp() {
    return (OccurrenceInfoAvp) AvpUtilities.createAvp(OCCURRENCE_INFO, SLg_VENDOR_ID, null, OccurrenceInfoAvpImpl.class);
  }

  public IntervalTimeAvp createIntervalTimeAvp() {
    return (IntervalTimeAvp) AvpUtilities.createAvp(INTERVAL_TIME, SLg_VENDOR_ID, null, IntervalTimeAvpImpl.class);
  }

  public PeriodicLDRInformationAvp createPeriodicLDRInformationAvp() {
    return (PeriodicLDRInformationAvp) AvpUtilities.createAvp(PERIODIC_LDR_INFORMATION, SLg_VENDOR_ID, null, PeriodicLDRInformationAvpImpl.class);
  }

  public ReportingAmountAvp createReportingAmountAvp() {
    return (ReportingAmountAvp) AvpUtilities.createAvp(REPORTING_AMOUNT, SLg_VENDOR_ID, null, ReportingAmountAvpImpl.class);
  }

  public ReportingIntervalAvp createReportingIntervalAvp() {
    return (ReportingIntervalAvp) AvpUtilities.createAvp(REPORTING_INTERVAL, SLg_VENDOR_ID, null, ReportingIntervalAvpImpl.class);
  }
*/
  public ReportingPLMNListAvp createReportingPLMNListAvp() {
    return (ReportingPLMNListAvp) AvpUtilities.createAvp(REPORTING_PLMN_LIST, SLg_VENDOR_ID, null, ReportingPLMNListAvpImpl.class);
  }

  public PLMNIDListAvp createPLMNIDListAvp() {
    return (PLMNIDListAvp) AvpUtilities.createAvp(PLMN_ID_LIST, SLg_VENDOR_ID, null, PLMNIDListAvpImpl.class);
  }
/*
  public PLRFlagsAvp createPLRFlagsAvp() {
    return (PLRFlagsAvp) AvpUtilities.createAvp(PLR_FLAGS, SLg_VENDOR_ID, null, PLRFlagsAvpImpl.class);
  }

  public PLAFlagsAvp createPLAFlagsAvp() {
    return (PLAFlagsAvp) AvpUtilities.createAvp(PLA_FLAGS, SLg_VENDOR_ID, null, PLAFlagsAvpImpl.class);
  }
*/
  public DeferredMTLRDataAvp createDeferredMTLRDataAvp() {
    return (DeferredMTLRDataAvp) AvpUtilities.createAvp(DEFERRED_MT_LR_DATA, SLg_VENDOR_ID, null, DeferredMTLRDataAvpImpl.class);
  }
/*
  public TerminationCauseAvp createTerminationCauseAvp() {
    return (TerminationCauseAvp) AvpUtilities.createAvp(TERMINATION_CAUSE, SLg_VENDOR_ID, null, TerminationCauseAvpImpl.class);
  }

  public PeriodicLocationSupportIndicatorAvp createPeriodicLocationSupportIndicatorAvp() {
    return (PeriodicLocationSupportIndicatorAvp) AvpUtilities.createAvp(PERIODIC_LOCATION_SUPPORT_INDICATOR, SLg_VENDOR_ID, null, PeriodicLocationSupportIndicatorAvpImpl.class);
  }

  public PrioritizedListIndicatorAvp createPrioritizedListIndicatorAvp() {
    return (PrioritizedListIndicatorAvp) AvpUtilities.createAvp(PRIORITIZED_LIST_INDICATOR, SLg_VENDOR_ID, null, PrioritizedListIndicatorAvpImpl.class);
  }
*/
  public ESMLCCellInfoAvp createESMLCCellInfoAvp() {
    return (ESMLCCellInfoAvp) AvpUtilities.createAvp(ESMLC_CELL_INFO, SLg_VENDOR_ID, null, ESMLCCellInfoAvpImpl.class);
  }
/*
  public CellPortionIDAvp createCellPortionIDAvp() {
    return (CellPortionIDAvp) AvpUtilities.createAvp(CELL_PORTION_ID, SLg_VENDOR_ID, null, CellPortionIDAvpImpl.class);
  }

  public OnexRTTRCIDAvp createOnexRTTRCIDAvp() {
    return (OnexRTTRCIDAvp) AvpUtilities.createAvp(ONExRTT_RCID, SLg_VENDOR_ID, null, OnexRTTRCIDAvpImpl.class);
  }

  public DelayedLocationReportingDataAvp createDelayedLocationReportingDataAvp() {
    return (DelayedLocationReportingDataAvp) AvpUtilities.createAvp(DELAYED_LOCATION_REPORTING_DATA, SLg_VENDOR_ID, null, DelayedLocationReportingDataAvpImpl.class);
  }

  public CivicAddressAvp createCivicAddressAvp() {
    return (CivicAddressAvp) AvpUtilities.createAvp(CIVIC_ADDRESS, SLg_VENDOR_ID, null, CivicAddressAvpImpl.class);
  }

  public BarometricPressureAvp createBarometricPressureAvp() {
    return (BarometricPressureAvp) AvpUtilities.createAvp(BAROMETRIC_PRESSURE, SLg_VENDOR_ID, null, BarometricPressureAvpImpl.class);
  }

  public UTRANAdditionalPositioningDataAvp createUTRANAdditionalPositioningDataAvp() {
    return (UTRANAdditionalPositioningDataAvp) AvpUtilities.createAvp(UTRAN_ADDITIONAL_POSITIONING_DATA, SLg_VENDOR_ID, null, UTRANAdditionalPositioningDataAvpImpl.class);
  }

  public LCSFormatIndicatorAvp createLCSFormatIndicatorAvp() {
    return (LCSFormatIndicatorAvp) AvpUtilities.createAvp(LCS_FORMAT_INDICATOR, SLg_VENDOR_ID, null, LCSFormatIndicatorAvpImpl.class);
  }

  public LCSNameStringAvp createLCSNameStringAvp() {
    return (LCSNameStringAvp) AvpUtilities.createAvp(LCS_NAME_STRING, SLg_VENDOR_ID, null, LCSNameStringAvpImpl.class);
  }

  public LCSClientTypeAvp createLCSClientTypeAvp() {
    return (LCSClientTypeAvp) AvpUtilities.createAvp(LCS_CLIENT_TYPE, SLg_VENDOR_ID, null, LCSClientTypeAvpImpl.class);
  }

  public LCSRequestorIdStringAvp createLCSRequestorIdStringAvp() {
    return (LCSRequestorIdStringAvp) AvpUtilities.createAvp(LCS_REQUESTOR_ID_STRING, SLg_VENDOR_ID, null, LCSRequestorIdStringAvpImpl.class);
  }

  public LocationEstimateAvp createLocationEstimateAvp() {
    return (LocationEstimateAvp) AvpUtilities.createAvp(LOCATION_ESTIMATE, SLg_VENDOR_ID, null, LocationEstimateAvpImpl.class);
  }

  public IMEIAvp createIMEIAvp() {
    return (IMEIAvp) AvpUtilities.createAvp(IMEI, SLg_VENDOR_ID, null, IMEIAvpImpl.class);
  }

  public MSISDNAvp createMSISDNAvp() {
    return (MSISDNAvp) AvpUtilities.createAvp(MSISDN, SLg_VENDOR_ID, null, MSISDNAvpImpl.class);
  }

  public ServiceSelectionAvp createServiceSelectionAvp() {
    return (ServiceSelectionAvp) AvpUtilities.createAvp(SERVICE_SELECTION, SLg_VENDOR_ID, null, ServiceSelectionAvpImpl.class);
  }

  public UserNameAvp createUserNameAvp() {
    return (UserNameAvp) AvpUtilities.createAvp(USER_NAME, SLg_VENDOR_ID, null, UserNameAvpImpl.class);
  }

  public SupportedFeaturesAvp createSupportedFeaturesAvp() {
    return (SupportedFeaturesAvp) AvpUtilities.createAvp(SUPPORTED_FEATURES, SLg_VENDOR_ID, null, SupportedFeaturesAvpImpl.class);
  }

  public FeatureListIDAvp createFeatureListIDAvp() {
    return (FeatureListIDAvp) AvpUtilities.createAvp(FEATURE_LIST_ID, SLg_VENDOR_ID, null, FeatureListIDAvpImpl.class);
  }

  public FeatureListAvp createFeatureListAvp() {
    return (FeatureListAvp) AvpUtilities.createAvp(FEATURE_LIST, SLg_VENDOR_ID, null, FeatureListAvpImpl.class);
  }

  public CellGlobalIdentityAvp createCellGlobalIdentityAvp() {
    return (CellGlobalIdentityAvp) AvpUtilities.createAvp(CELL_GLOBAL_IDENTITY, SLg_VENDOR_ID, null, CellGlobalIdentityAvpImpl.class);
  }

  public ServiceAreaIdentityAvp createServiceAreaIdentityAvp() {
    return (ServiceAreaIdentityAvp) AvpUtilities.createAvp(SERVICE_AREA_IDENTITY, SLg_VENDOR_ID, null, ServiceAreaIdentityAvpImpl.class);
  }

  public GMLCAddressAvp createGMLCAddressAvp() {
    return (GMLCAddressAvp) AvpUtilities.createAvp(GMLC_ADDRESS, SLg_VENDOR_ID, null, GMLCAddressAvpImpl.class);
  }

  public VisitedPLMNIdAvp createVisitedPLMNIdAvp() {
    return (VisitedPLMNIdAvp) AvpUtilities.createAvp(VISITED_PLMN_ID, SLg_VENDOR_ID, null, VisitedPLMNIdAvpImpl.class);
  }
*/
}

