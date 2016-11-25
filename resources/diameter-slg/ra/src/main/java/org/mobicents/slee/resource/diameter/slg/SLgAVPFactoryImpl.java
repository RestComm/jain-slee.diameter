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
*/
  public LCSEPSClientNameAvp createLCSEPSCLientNameAvp() {
    return (LCSEPSClientNameAvp) AvpUtilities.createAvp(LCS_EPS_CLIENT_NAME, SLg_VENDOR_ID, null, LCSEPSClientNameAvpImpl.class);
  }

  public LCSEPSClientNameAvp createLCSEPSCLientNameAvp(String lcsNameString, LCSFormatIndicator lcsFormatIndicator) {
    // Create the empty AVP
    LCSEPSClientNameAvp lcsEpsClientNameAvp = createLCSEPSCLientNameAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.3	LCS-EPS-Client-Name
     *  The LCS-EPS-Client-Name AVP is of type Grouped.
     *  AVP format:
     *            LCS-EPS-Client-Name ::= <AVP header: 2501 10415>
     *                                [ LCS-Name-String ]
     *                                [ LCS-Format-Indicator ]
     */
    // Set the provided AVP values
    lcsEpsClientNameAvp.setLCSNameString(lcsNameString);
    lcsEpsClientNameAvp.setLCSFormatIndicator(lcsFormatIndicator);

    return lcsEpsClientNameAvp;
  }


  public LCSRequestorNameAvp createLCSRequestorNameAvp() {
    return (LCSRequestorNameAvp) AvpUtilities.createAvp(LCS_REQUESTOR_NAME, SLg_VENDOR_ID, null, LCSRequestorNameAvpImpl.class);
  }

  public LCSRequestorNameAvp createLCSRequestorNameAvp(String lcsRequestorIDString, LCSFormatIndicator lcsFormatIndicator) {
    // Create the empty AVP
    LCSRequestorNameAvp lcsRequestorNameAvp = createLCSRequestorNameAvp();
    /*
    * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
    *
    * <pre>
    *  7.4.4	LCS-Requestor-Name
    * 	The LCS-Requestor-Name AVP is of type Grouped.
    *
    * 	AVP format:
    * 	LCS-Requestor-Name ::= <AVP header: 2502 10415>
    * 											[ LCS-Requestor-Id-String ]
    * 											[ LCS-Format-Indicator ]
    *
    */
    // Set the provided AVP values
    lcsRequestorNameAvp.setLCSRequestorIDString(lcsRequestorIDString);
    lcsRequestorNameAvp.setLCSFormatIndicator(lcsFormatIndicator);

    return lcsRequestorNameAvp;
  }
/*

*/
  public LCSQoSAvp createLCSQoSAvp() {
    return (LCSQoSAvp) AvpUtilities.createAvp(LCS_QoS, SLg_VENDOR_ID, null, LCSQoSAvpImpl.class);
  }

  public LCSQoSAvp createLCSQoSAvp(LCSQoSClass lcsQoSClass, long horizontalAccuracy, long verticalAccuracy, VerticalRequested verticalRequested, ResponseTime responseTime) {
    // Create the empty AVP
    LCSQoSAvp lcsQoSAvp = createLCSQoSAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.6		LCS-QoS
     * 	The LCS-QoS AVP is of type Grouped.
     *
     * 	AVP format:
     * 	LCS-QoS ::= <AVP header: 2504 10415>
     * 											[ LCS-QoS-Class ]
     * 											[ Horizontal-Accuracy ]
     * 											[ Vertical-Accuracy ]
     * 											[ Vertical-Requested ]
     * 											[ Response-Time]
     */
    // Set the provided AVP values
    lcsQoSAvp.setLCSQoSClass(lcsQoSClass);
    lcsQoSAvp.setHorizontalAccuracy(horizontalAccuracy);
    lcsQoSAvp.setVerticalAccuracy(verticalAccuracy);
    lcsQoSAvp.setVerticalRequested(verticalRequested);
    lcsQoSAvp.setResponseTime(responseTime);

    return lcsQoSAvp;
  }
/*

*/
  public LCSPrivacyCheckNonSessionAvp createLCSPrivacyCheckNonSessionAvp() {
    return (LCSPrivacyCheckNonSessionAvp) AvpUtilities.createAvp(LCS_PRIVACY_CHECK_NON_SESSION, SLg_VENDOR_ID, null, LCSPrivacyCheckNonSessionAvpImpl.class);
  }

  public LCSPrivacyCheckNonSessionAvp createLCSPrivacyCheckNonSessionAvp(LCSPrivacyCheck lcsPrivacyCheck) {
    // Create the empty AVP
    LCSPrivacyCheckNonSessionAvp lcsPrivacyCheckNonSessionAvp = createLCSPrivacyCheckNonSessionAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.23		LCS-Privacy-Check-Non-Session
     * 	The LCS-Privacy-Check-Non-Session AVP is of type Grouped.
     *
     * 	AVP format:
     * 							LLCS-Privacy-Check-Non-Session ::= <AVP header: 2521 10415>
     * 																					      { LCS-Privacy-Check }
     */
    // Set the provided AVP values
    lcsPrivacyCheckNonSessionAvp.setLCSPrivacyCheck(lcsPrivacyCheck);

    return lcsPrivacyCheckNonSessionAvp;
  }

  public LCSPrivacyCheckSessionAvp createLCSPrivacyCheckSessionAvp() {
    return (LCSPrivacyCheckSessionAvp) AvpUtilities.createAvp(LCS_PRIVACY_CHECK_SESSION, SLg_VENDOR_ID, null, LCSPrivacyCheckSessionAvpImpl.class);
  }

  public LCSPrivacyCheckSessionAvp createLCSPrivacyCheckSessionAvp(LCSPrivacyCheck lcsPrivacyCheck) {
    // Create the empty AVP
    LCSPrivacyCheckSessionAvp lcsPrivacyCheckSessionAvp = createLCSPrivacyCheckSessionAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.23		LCS-Privacy-Check-Session
     * 	The LCS-Privacy-Check-Session AVP is of type Grouped.
     *
     * 	AVP format:
     * 							LCS-Privacy-Check-Session ::= <AVP header: 2522 10415>
     * 																					{ LCS-Privacy-Check }
     */
    // Set the provided AVP values
    lcsPrivacyCheckSessionAvp.setLCSPrivacyCheck(lcsPrivacyCheck);

    return lcsPrivacyCheckSessionAvp;

  }

  public GERANPositioningInfoAvp createGERANPositioningInfoAvp() {
    return (GERANPositioningInfoAvp) AvpUtilities.createAvp(GERAN_POSITIONING_INFO, SLg_VENDOR_ID, null, GERANPositioningInfoAvpImpl.class);
  }

  public GERANPositioningInfoAvp createGERANPositioningInfoAvp(byte[] geranPositioningData, byte[] geranGanssPositioningData) {
    // Create the empty AVP
    GERANPositioningInfoAvp geranPositioningInfoAvp = createGERANPositioningInfoAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.29	GERAN-Positioning-Info
     * 	The GERAN-Positioning-Info AVP is of type Grouped.
     *
     * 	AVP format:
     * 	GERAN-Positioning-Info ::= <AVP header: 2524 10415>
     * 													[ GERAN-Positioning-Data ]
     * 													[ GERAN-GANSS-Positioning-Data ]
     * 													*[ AVP ]
     */
    // Set the provided AVP values
    geranPositioningInfoAvp.setGERANPositioningData(geranPositioningData);
    geranPositioningInfoAvp.setGERANGANSSPositioningData(geranGanssPositioningData);

    return geranPositioningInfoAvp;
  }

  public UTRANPositioningInfoAvp createUTRANPositioningInfoAvp() {
    return (UTRANPositioningInfoAvp) AvpUtilities.createAvp(UTRAN_POSITIONING_INFO, SLg_VENDOR_ID, null, UTRANPositioningInfoAvpImpl.class);
  }

  public UTRANPositioningInfoAvp createUTRANPositioningInfoAvp(byte[] utranPositioningData, byte[] utranGanssPositioningData, byte[] utranAdditionalPositioningData) {
    // Create the empty AVP
    UTRANPositioningInfoAvp utranPositioningInfoAvp = createUTRANPositioningInfoAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.29	UTRAN-Positioning-Info
     * 	The UTRAN-Positioning-Info AVP is of type Grouped.
     *
     * 	AVP format:
     * 		UTRAN-Positioning-Info ::= <AVP header: 2527 10415>
     * 														[ UTRAN-Positioning-Data ]
     * 														[ UTRAN-GANSS-Positioning-Data ]
     *														[ UTRAN-Additional-Positioning-Data ]
     * 														*[ AVP ]
     */
    // Set the provided AVP values
    utranPositioningInfoAvp.setUTRANPositioningData(utranPositioningData);
    utranPositioningInfoAvp.setUTRANGANSSPositioningData(utranGanssPositioningData);
    utranPositioningInfoAvp.setUTRANAdditionalPositioningData(utranAdditionalPositioningData);

    return utranPositioningInfoAvp;
  }

  public AreaEventInfoAvp createAreaEventInfoAvp() {
    return (AreaEventInfoAvp) AvpUtilities.createAvp(AREA_EVENT_INFO, SLg_VENDOR_ID, null, AreaDefinitionAvpImpl.class);
  }

  public AreaEventInfoAvp createAreaEventInfoAvp(AreaDefinitionAvp areaDefinitionAvp, OccurrenceInfo occurrenceInfo, long intervalTime) {
    // Create the empty AVP
    AreaEventInfoAvp areaEventInfoAvp = createAreaEventInfoAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.38	Area-Event-Info
     * 	The Area-Event-Info AVP is of type Grouped.
     *
     * 	AVP format:
     * 		Area-Event-Info ::= <AVP header: 2533 10415>
     * 											{ Area-Definition }
     * 											[ Occurrence-Info ]
     * 											[ Interval-Time ]
     * 											*[ AVP ]
     */
    // Set the provided AVP values
    areaEventInfoAvp.setAreaDefinition(areaDefinitionAvp);
    areaEventInfoAvp.setOccurrenceInfo(occurrenceInfo);
    areaEventInfoAvp.setIntervalTime(intervalTime);

    return areaEventInfoAvp;
  }

  public AreaDefinitionAvp createAreaDefinitionAvp() {
    return (AreaDefinitionAvp) AvpUtilities.createAvp(AREA_DEFINITION, SLg_VENDOR_ID, null, AreaDefinitionAvpImpl.class);
  }

  public AreaDefinitionAvp createAreaDefinitionAvp(AreaAvp area) {
    // Create the empty AVP
    AreaDefinitionAvp areaDefinitionAvp = createAreaDefinitionAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.39	Area
     * The Area-Definition AVP is of type Grouped.
     * AVP format:
     * 						Area-Definition ::= <AVP header: 2534 10415>
     * 						1*10{ Area }
     * 						[ AVP ]
     */
    // Set the provided AVP values
    areaDefinitionAvp.setArea(area);

    return areaDefinitionAvp;
  }

  public AreaAvp createAreaAvp() {
    return (AreaAvp) AvpUtilities.createAvp(AREA, SLg_VENDOR_ID, null, AreaAvpImpl.class);
  }

  public AreaAvp createAreaAvp(long areaType, byte[] areaIdentification) {
    // Create the empty AVP
    AreaAvp areaAvp = createAreaAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.40	Area
     * The Area AVP is of type Grouped.
     * 	AVP format:
     * 						Area ::= <AVP header: 2535 10415>
     * 										{ Area-Type }
     * 										{ Area-Identification }
     *										*[ AVP ]
     */
    areaAvp.setAreaType(areaType);
    areaAvp.setAreaIdentification(areaIdentification);

    return areaAvp;
  }

  public PeriodicLDRInfoAvp createPeriodicLDRInformationAvp() {
    return (PeriodicLDRInfoAvp) AvpUtilities.createAvp(PERIODIC_LDR_INFORMATION, SLg_VENDOR_ID, null, PeriodicLDRInfoAvpImpl.class);
  }

  public PeriodicLDRInfoAvp createPeriodicLDRInformationAvp(long reportingAmount, long reportingInterval) {
    // Create the empty AVP
    PeriodicLDRInfoAvp periodicLDRInfoAvp = createPeriodicLDRInformationAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.45	Periodic-LDR-Info
     * The Periodic-LDR-Info AVP is of type Grouped.
     * AVP format:
     * 						Periodic-LDR-Info ::= <AVP header: 2540 10415>
     * 																{ Reporting-Amount }
     * 																{ Reporting-Interval }
     * 																*[ AVP ]
     */
    // Set the provided AVP values
    periodicLDRInfoAvp.setReportingAmount(reportingAmount);
    periodicLDRInfoAvp.setReportingInterval(reportingInterval);

    return periodicLDRInfoAvp;
  }

  public ReportingPLMNListAvp createReportingPLMNListAvp() {
    return (ReportingPLMNListAvp) AvpUtilities.createAvp(REPORTING_PLMN_LIST, SLg_VENDOR_ID, null, ReportingPLMNListAvpImpl.class);
  }

  public ReportingPLMNListAvp createReportingPLMNListAvp(PLMNIDListAvp plmnidListAvp, PrioritizedListIndicator prioritizedListIndicator) {
    // Create the empty AVP
    ReportingPLMNListAvp reportingPLMNListAvp = createReportingPLMNListAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.48	Reporting-PLMN-List
     * The Reporting-PLMN-List AVP is of type Grouped.
     * AVP format:
     * 		Reporting-PLMN-List ::= <AVP header: 2543 10415>
     * 													1*20{ PLMN-ID-List }
     * 													[ Prioritized-List-Indicator ]
     * 													*[ AVP ]
     */
    // Set the provided AVP values
    reportingPLMNListAvp.setPLMNIDList(plmnidListAvp);
    reportingPLMNListAvp.setPrioritizedListIndicator(prioritizedListIndicator);

    return reportingPLMNListAvp;
  }

  public PLMNIDListAvp createPLMNIDListAvp() {
    return (PLMNIDListAvp) AvpUtilities.createAvp(PLMN_ID_LIST, SLg_VENDOR_ID, null, PLMNIDListAvpImpl.class);
  }

  public PLMNIDListAvp createPLMNIDListAvp(byte[] visitedPLMNId, PeriodicLocationSupportIndicator periodicLocationSupportIndicator) {
    // Create the empty AVP
    PLMNIDListAvp plmnidListAvp = createPLMNIDListAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.49	PLMN-ID-List
     * The PLMN-ID-List AVP is of type Grouped.
     * AVP format:
     * 						PLMN-ID-List ::= <AVP header: 2544 10415>
     * 														{ Visited-PLMN-Id }
     * 														[ Periodic-Location-Support-Indicator ]
     * 														*[ AVP ]
     */
    // Set the provided AVP values
    plmnidListAvp.setVisitedPLMNId(visitedPLMNId);
    plmnidListAvp.setPeriodicLocationSupportIndicator(periodicLocationSupportIndicator);

    return  plmnidListAvp;
  }

  public DeferredMTLRDataAvp createDeferredMTLRDataAvp() {
    return (DeferredMTLRDataAvp) AvpUtilities.createAvp(DEFERRED_MT_LR_DATA, SLg_VENDOR_ID, null, DeferredMTLRDataAvpImpl.class);
  }

  public DeferredMTLRDataAvp createDeferredMTLRDataAvp(long deferredLocationType, long terminationCause, ServingNodeAvp servingNodeAvp) {
    // Create the empty AVP
    DeferredMTLRDataAvp deferredMTLRDataAvp = createDeferredMTLRDataAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.54	Deferred-MT-LR-Data
     * The Deferred-MT-LR-Data AVP is of type Grouped.
     * AVP format:
     * 						Deferred-MT-LR-Data ::= <AVP header: 2547 10415>
     * 																	{ Deferred-Location-Type }
     * 																	[ Termination-Cause ]
     * 																	[ Serving-Node ]
     * 																	*[ AVP ]
     */
    // Set the provided AVP values
    deferredMTLRDataAvp.setDeferredLocationType(deferredLocationType);
    deferredMTLRDataAvp.setTerminationCause(terminationCause);
    deferredMTLRDataAvp.setServingNode(servingNodeAvp);

    return deferredMTLRDataAvp;
  }

  public ESMLCCellInfoAvp createESMLCCellInfoAvp() {
    return (ESMLCCellInfoAvp) AvpUtilities.createAvp(ESMLC_CELL_INFO, SLg_VENDOR_ID, null, ESMLCCellInfoAvpImpl.class);
  }

  public ESMLCCellInfoAvp createESMLCCellInfoAvp(byte[] ecgi, long cellPortionId) {
    // Create the empty AVP
    ESMLCCellInfoAvp esmlcCellInfoAvp = createESMLCCellInfoAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
     *
     * <pre>
     * 7.4.57		ESMLC-Cell-Info
     * 	The ESMLC-Cell-Info AVP is of type Grouped.
     *
     * 	AVP format:
     * 		ESMLC-Cell-Info ::= <AVP header: 2552 10415>
     * 														[ ECGI ]
     * 														[ Cell-Portion-ID ]
     * 														*[ AVP ]
     */
    // Set the provided AVP values
    esmlcCellInfoAvp.setECGI(ecgi);
    esmlcCellInfoAvp.setCellPortionID(cellPortionId);

    return esmlcCellInfoAvp;
  }

  public DelayedLocationReportingDataAvp createDelayedLocationReportingDataAvp() {
    return (DelayedLocationReportingDataAvp) AvpUtilities.createAvp(DELAYED_LOCATION_REPORTING_DATA, SLg_VENDOR_ID, null, DelayedLocationReportingDataAvpImpl.class);
  }

  public DelayedLocationReportingDataAvp createDelayedLocationReportingDataAvp(int terminationCause, ServingNodeAvp servingNodeAvp) {
    // Create the empty AVP
    DelayedLocationReportingDataAvp delayedLocationReportingDataAvp = createDelayedLocationReportingDataAvp();
    /**
     * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.1.0) specification.
     *
     * <pre>
     * 7.4.60	Delayed-Location-Reporting-Data
     * The Delayed-Location-Reporting-Data AVP is of type Grouped.
     * AVP format:
     * 						Delayed-Location-Reporting-Data ::= <AVP header: 2555 10415>
     * 																						[ Termination-Cause ]
     * 																						[ Serving-Node ]
     * 																						*[ AVP ]
     */
    // Set the provided AVP values
    delayedLocationReportingDataAvp.setTerminationCause(terminationCause);
    delayedLocationReportingDataAvp.setServingNode(servingNodeAvp);

    return delayedLocationReportingDataAvp;
  }

/*
  public LCSPriorityAvp createLCSPriorityAvp() {
    return (LCSPriorityAvp) AvpUtilities.createAvp(LCS_PRIORITY, SLg_VENDOR_ID, null, LCSPriorityAvpImpl.class);
  }

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

  public ResponseTime createResponseTimeAvp() {
    return (ResponseTime) AvpUtilities.createAvp(RESPONSE_TIME, SLg_VENDOR_ID, null, ResponseTime.class);
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

  public LCSQoSClassAvp createLCSQoSClassAvp() {
    return (LCSQoSClassAvp) AvpUtilities.createAvp(LCS_QoS_CLASS, SLg_VENDOR_ID, null, LCSQoSClassAvpImpl.class);
  }

  public GERANPositioningDataAvp createGERANPositioningDataAvp() {
    return (GERANPositioningDataAvp) AvpUtilities.createAvp(GERAN_POSITIONING_DATA, SLg_VENDOR_ID, null, GERANPositioningDataAvpImpl.class);
  }

  public GERANGANSSPositioningDataAvp createGERANGANSSPositioningDataAvp() {
    return (GERANGANSSPositioningDataAvp) AvpUtilities.createAvp(GERAN_GANSS_POSITIONING_DATA, SLg_VENDOR_ID, null, GERANGANSSPositioningDataAvpImpl.class);
  }

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

  public DeferredLocationTypeAvp createDeferredLocationTypeAvp() {
    return (DeferredLocationTypeAvp) AvpUtilities.createAvp(DEFERRED_LOCATION_TYPE, SLg_VENDOR_ID, null, DeferredLocationTypeAvpImpl.class);
  }

  public OccurrenceInfoAvp createOccurrenceInfoAvp() {
    return (OccurrenceInfoAvp) AvpUtilities.createAvp(OCCURRENCE_INFO, SLg_VENDOR_ID, null, OccurrenceInfoAvpImpl.class);
  }

  public IntervalTimeAvp createIntervalTimeAvp() {
    return (IntervalTimeAvp) AvpUtilities.createAvp(INTERVAL_TIME, SLg_VENDOR_ID, null, IntervalTimeAvpImpl.class);
  }

  public ReportingAmountAvp createReportingAmountAvp() {
    return (ReportingAmountAvp) AvpUtilities.createAvp(REPORTING_AMOUNT, SLg_VENDOR_ID, null, ReportingAmountAvpImpl.class);
  }

  public ReportingIntervalAvp createReportingIntervalAvp() {
    return (ReportingIntervalAvp) AvpUtilities.createAvp(REPORTING_INTERVAL, SLg_VENDOR_ID, null, ReportingIntervalAvpImpl.class);
  }

  public PLRFlagsAvp createPLRFlagsAvp() {
    return (PLRFlagsAvp) AvpUtilities.createAvp(PLR_FLAGS, SLg_VENDOR_ID, null, PLRFlagsAvpImpl.class);
  }

  public PLAFlagsAvp createPLAFlagsAvp() {
    return (PLAFlagsAvp) AvpUtilities.createAvp(PLA_FLAGS, SLg_VENDOR_ID, null, PLAFlagsAvpImpl.class);
  }

  public TerminationCauseAvp createTerminationCauseAvp() {
    return (TerminationCauseAvp) AvpUtilities.createAvp(TERMINATION_CAUSE, SLg_VENDOR_ID, null, TerminationCauseAvpImpl.class);
  }

  public PeriodicLocationSupportIndicatorAvp createPeriodicLocationSupportIndicatorAvp() {
    return (PeriodicLocationSupportIndicatorAvp) AvpUtilities.createAvp(PERIODIC_LOCATION_SUPPORT_INDICATOR, SLg_VENDOR_ID, null, PeriodicLocationSupportIndicatorAvpImpl.class);
  }

  public PrioritizedListIndicatorAvp createPrioritizedListIndicatorAvp() {
    return (PrioritizedListIndicatorAvp) AvpUtilities.createAvp(PRIORITIZED_LIST_INDICATOR, SLg_VENDOR_ID, null, PrioritizedListIndicatorAvpImpl.class);
  }

  public CellPortionIDAvp createCellPortionIDAvp() {
    return (CellPortionIDAvp) AvpUtilities.createAvp(CELL_PORTION_ID, SLg_VENDOR_ID, null, CellPortionIDAvpImpl.class);
  }

  public OnexRTTRCIDAvp createOnexRTTRCIDAvp() {
    return (OnexRTTRCIDAvp) AvpUtilities.createAvp(ONExRTT_RCID, SLg_VENDOR_ID, null, OnexRTTRCIDAvpImpl.class);
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

