/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
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

package net.java.slee.resource.diameter.slg;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.slg.events.avp.*;

/**
 * Factory to support the creation of Grouped AVP instances for SLg.
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface SLgAVPFactory extends DiameterAvpFactory {
/*
  public SLgLocationTypeAvp createSLgLocationTypeAvp();
*/
  public LCSEPSClientNameAvp createLCSEPSCLientNameAvp();

  public LCSRequestorNameAvp createLCSRequestorNameAvp();
/*
  public LCSPriorityAvp createLCSPriorityAvp();
*/
  public LCSQoSAvp createLCSQoSAvp();
/*
  public HorizontalAccuracyAvp createHorizontalAccuracyAvp();

  public VerticalAccuracyAvp createVerticalAccuracyAvp();

  public VerticalRequestedAvp createVerticalRequestedAvp();

  public VelocityRequestedAvp createVelocityRequestedAvp();

  public ResponseTime createResponseTimeAvp();

  public SupportedGADShapesAvp createSupportedGADShapesAvp();

  public LCSCodewordAvp createLCSCodewordAvp();

  public LCSPrivacyCheckAvp createLCSPrivacyCheckAvp();

  public AccuracyFulfilmentIndicatorAvp createAccuracyFulfilmentIndicatorAvp();

  public AgeOfLocationEstimateAvp createAgeOfLocationEstimate();

  public VelocityEstimateAvp createVelocity-EstimateAvp();

  public EUTRANPositioningDataAvp createEUTRANPositioningDataAvp();

  public ECGIAvp createECGIAvp();

  public LocationEventAvp createLocationEventAvp();

  public PseudonymIndicatorAvp createPseudonymIndicatorAvp();

  public LCSServiceTypeIDAvp createLCSServiceTypeIDAvp();
*/
  public LCSPrivacyCheckNonSessionAvp createLCSPrivacyCheckNonSessionAvp();

  public LCSPrivacyCheckSessionAvp createLCSPrivacyCheckSessionAvp();
/*
  public LCSQoSClassAvp createLCSQoSClassAvp();
*/
  public GERANPositioningInfoAvp createGERANPositioningInfoAvp();
/*
  public GERANPositioningDataAvp createGERANPositioningDataAvp();

  public GERANGANSSPositioningDataAvp createGERANGANSSPositioningDataAvp();
*/
  public UTRANPositioningInfoAvp createUTRANPositioningInfoAvp();
/*
  public UTRANPositioningDataAvp createUTRANPositioningDataAvp();

  public UTRANGANSSPositioningDataAvp createUTRANGANSSPositioningDataAvp();

  public LRRFlagsAvp createLRRFlagsAvp();

  public LCSReferenceNumberAvp createLCSReferenceNumberAvp();

  public DeferredLocationTypeAvp createDeferredLocationTypeAvp();
*/
  public AreaEventInfoAvp createAreaEventInfoAvp();

  public AreaDefinitionAvp createAreaDefinitionAvp();

  public AreaAvp createAreaAvp();
/*
  public AreaTypeAvp createAreaTypeAvp();

  public OccurrenceInfoAvp createOccurrenceInfoAvp();

  public IntervalTimeAvp createIntervalTimeAvp();
*/
  public PeriodicLDRInfoAvp createPeriodicLDRInformationAvp();
/*
  public ReportingAmountAvp createReportingAmountAvp();

  public ReportingIntervalAvp createReportingIntervalAvp();
*/
  public ReportingPLMNListAvp createReportingPLMNListAvp();

  public PLMNIDListAvp createPLMNIDListAvp();
/*
  public PLRFlagsAvp createPLRFlagsAvp();

  public PLAFlagsAvp createPLAFlagsAvp();
*/
  public DeferredMTLRDataAvp createDeferredMTLRDataAvp();
/*
  public TerminationCauseAvp createTerminationCauseAvp();

  public PeriodicLocationSupportIndicatorAvp createPeriodicLocationSupportIndicatorAvp();

  public PrioritizedListIndicatorAvp createPrioritizedListIndicatorAvp();
*/
  public ESMLCCellInfoAvp createESMLCCellInfoAvp();
/*
  public CellPortionIDAvp createCellPortionIDAvp();

  public OnexRTTRCIDAvp createOnexRTTRCIDAvp();
*/
  public DelayedLocationReportingDataAvp createDelayedLocationReportingDataAvp();
/*
  public CivicAddressAvp createCivicAddressAvp();BarometricPressureAvp

  public UTRANAdditionalPositioningDataAvp createUTRANAdditionalPositioningDataAvp();

  public LCSFormatIndicatorAvp createLCSFormatIndicatorAvp();

  public LCSNameStringAvp createLCSNameStringAvp();

  public LCSClientTypeAvp createLCSClientTypeAvp();

  public LCSRequestorIdStringAvp createLCSRequestorIdStringAvp();

  public LocationEstimateAvp createLocationEstimateAvp();

  public IMEIAvp createIMEIAvp();

  public MSISDNAvp createMSISDNAvp();

  public ServiceSelectionAvp createServiceSelectionAvp();

  public UserNameAvp createUserNameAvp();
*/
  public SupportedFeaturesAvp createSupportedFeaturesAvp();
/*
  public FeatureListIDAvp createFeatureListIDAvp();

  public FeatureListAvp createFeatureListAvp();

  public CellGlobalIdentityAvp createCellGlobalIdentityAvp();

  public ServiceAreaIdentityAvp createServiceAreaIdentityAvp();

  public GMLCAddressAvp createGMLCAddressAvp();

  public VisitedPLMNIdAvp createVisitedPLMNIdAvp();
*/
}