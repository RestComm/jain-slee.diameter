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

package org.mobicents.slee.resource.diameter.slg;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.base.events.avp.AvpUtilities;
import net.java.slee.resource.diameter.slg.SLgAVPFactory;
import net.java.slee.resource.diameter.slg.events.avp.ELPAVPCodes;
import net.java.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckNonSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSRequestorNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.AdditionalAreaAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaDefinitionAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaAvp;
import net.java.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvp;
import net.java.slee.resource.diameter.slg.events.avp.PLMNIDListAvp;
import net.java.slee.resource.diameter.slg.events.avp.DeferredMTLRDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.slg.events.avp.MotionEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp;

import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckNonSessionAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSQoSAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSRequestorNameAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckSessionAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.AdditionalAreaAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.AreaEventInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.AreaDefinitionAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.AreaAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.PLMNIDListAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.DeferredMTLRDataAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.MotionEventInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl;

/**
 * Diameter SLg Reference Point AVP Factory. Implementation for {@link SLgAVPFactory}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
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

  @Override
  public AdditionalAreaAvp createAdditionalArea() {
    return (AdditionalAreaAvp) AvpUtilities.createAvp(ELPAVPCodes.ADDITIONAL_AREA, ELPAVPCodes.SLg_VENDOR_ID, AdditionalAreaAvpImpl.class);
  }

  @Override
  public LCSEPSClientNameAvp createLCSEPSClientName() {
    return (LCSEPSClientNameAvp) AvpUtilities.createAvp(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID, null, LCSEPSClientNameAvpImpl.class);
  }

  @Override
  public LCSRequestorNameAvp createLCSRequestorName() {
    return (LCSRequestorNameAvp) AvpUtilities.createAvp(ELPAVPCodes.LCS_REQUESTOR_NAME, ELPAVPCodes.SLg_VENDOR_ID, null, LCSRequestorNameAvpImpl.class);
  }

  @Override
  public LCSQoSAvp createLCSQoS() {
    return (LCSQoSAvp) AvpUtilities.createAvp(ELPAVPCodes.LCS_QoS, ELPAVPCodes.SLg_VENDOR_ID, null, LCSQoSAvpImpl.class);
  }

  @Override
  public LCSPrivacyCheckNonSessionAvp createLCSPrivacyCheckNonSession() {
    return (LCSPrivacyCheckNonSessionAvp) AvpUtilities.createAvp(ELPAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION, ELPAVPCodes.SLg_VENDOR_ID, null, LCSPrivacyCheckNonSessionAvpImpl.class);
  }

  @Override
  public LCSPrivacyCheckSessionAvp createLCSPrivacyCheckSession() {
    return (LCSPrivacyCheckSessionAvp) AvpUtilities.createAvp(ELPAVPCodes.LCS_PRIVACY_CHECK_SESSION, ELPAVPCodes.SLg_VENDOR_ID, null, LCSPrivacyCheckSessionAvpImpl.class);
  }

  @Override
  public GERANPositioningInfoAvp createGERANPositioningInfo() {
    return (GERANPositioningInfoAvp) AvpUtilities.createAvp(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, null, GERANPositioningInfoAvpImpl.class);
  }

  @Override
  public UTRANPositioningInfoAvp createUTRANPositioningInfo() {
    return (UTRANPositioningInfoAvp) AvpUtilities.createAvp(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, null, UTRANPositioningInfoAvpImpl.class);
  }

  @Override
  public AreaEventInfoAvp createAreaEventInfo() {
    return (AreaEventInfoAvp) AvpUtilities.createAvp(ELPAVPCodes.AREA_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, null, AreaEventInfoAvpImpl.class);
  }

  @Override
  public AreaDefinitionAvp createAreaDefinition() {
    return (AreaDefinitionAvp) AvpUtilities.createAvp(ELPAVPCodes.AREA_DEFINITION, ELPAVPCodes.SLg_VENDOR_ID, null, AreaDefinitionAvpImpl.class);
  }

  @Override
  public AreaAvp createArea() {
    return (AreaAvp) AvpUtilities.createAvp(ELPAVPCodes.AREA, ELPAVPCodes.SLg_VENDOR_ID, null, AreaAvpImpl.class);
  }

  @Override
  public PeriodicLDRInfoAvp createPeriodicLDRInformation() {
    return (PeriodicLDRInfoAvp) AvpUtilities.createAvp(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID, null, PeriodicLDRInfoAvpImpl.class);
  }

  @Override
  public ReportingPLMNListAvp createReportingPLMNList() {
    return (ReportingPLMNListAvp) AvpUtilities.createAvp(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID, null, ReportingPLMNListAvpImpl.class);
  }

  @Override
  public PLMNIDListAvp createPLMNIDList() {
    return (PLMNIDListAvp) AvpUtilities.createAvp(ELPAVPCodes.PLMN_ID_LIST, ELPAVPCodes.SLg_VENDOR_ID, null, PLMNIDListAvpImpl.class);
  }

  @Override
  public DeferredMTLRDataAvp createDeferredMTLRData() {
    return (DeferredMTLRDataAvp) AvpUtilities.createAvp(ELPAVPCodes.DEFERRED_MT_LR_DATA, ELPAVPCodes.SLg_VENDOR_ID, null, DeferredMTLRDataAvpImpl.class);
  }

  @Override
  public ESMLCCellInfoAvp createESMLCCellInfo() {
    return (ESMLCCellInfoAvp) AvpUtilities.createAvp(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID, null, ESMLCCellInfoAvpImpl.class);
  }

  @Override
  public DelayedLocationReportingDataAvp createDelayedLocationReportingData() {
    return (DelayedLocationReportingDataAvp) AvpUtilities.createAvp(ELPAVPCodes.DELAYED_LOCATION_REPORTING_DATA, ELPAVPCodes.SLg_VENDOR_ID, null, DelayedLocationReportingDataAvpImpl.class);
  }

  @Override
  public ServingNodeAvp createServingNode() {
    return (ServingNodeAvp) AvpUtilities.createAvp(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, null, ServingNodeAvpImpl.class);
  }

  @Override
  public MotionEventInfoAvp createMotionEventInfo() {
    return (MotionEventInfoAvp) AvpUtilities.createAvp(ELPAVPCodes.MOTION_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, null, MotionEventInfoAvpImpl.class);
  }

  @Override
  public SupportedFeaturesAvp createSupportedFeatures() {
    return (SupportedFeaturesAvp) AvpUtilities.createAvp(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, null, SupportedFeaturesAvpImpl.class);
  }

}

