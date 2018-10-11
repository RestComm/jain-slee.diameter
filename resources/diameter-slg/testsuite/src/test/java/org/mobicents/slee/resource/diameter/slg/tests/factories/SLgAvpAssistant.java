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

package org.mobicents.slee.resource.diameter.slg.tests.factories;

import net.java.slee.resource.diameter.slg.events.avp.ELPAVPCodes;
import net.java.slee.resource.diameter.slg.events.avp.AdditionalAreaAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaDefinitionAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.DeferredMTLRDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.MotionEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckNonSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSRequestorNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.PLMNIDListAvp;
import net.java.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvp;
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvp;

import org.mobicents.slee.resource.diameter.slg.events.avp.AdditionalAreaAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.AreaAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.AreaDefinitionAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.AreaEventInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.DeferredMTLRDataAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.MotionEventInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckNonSessionAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckSessionAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSQoSAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.LCSRequestorNameAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.PLMNIDListAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.ServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvpImpl;

/**
 * Aux Class for assisting in testing AVP setters/getters
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonça </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class SLgAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

  public static SLgAvpAssistant INSTANCE;

  static {
    try {
      INSTANCE = new SLgAvpAssistant();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected SLgAvpAssistant() throws Exception {
    super();

    // SLg AVP Factory
    typeValues.put(AdditionalAreaAvp.class, new AdditionalAreaAvpImpl(ELPAVPCodes.ADDITIONAL_AREA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(AdditionalAreaAvp[].class, new AdditionalAreaAvpImpl[]{
        new AdditionalAreaAvpImpl(ELPAVPCodes.ADDITIONAL_AREA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new AdditionalAreaAvpImpl(ELPAVPCodes.ADDITIONAL_AREA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(AreaAvp.class, new AreaAvpImpl(ELPAVPCodes.AREA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(AreaAvp[].class, new AreaAvpImpl[]{
        new AreaAvpImpl(ELPAVPCodes.AREA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new AreaAvpImpl(ELPAVPCodes.AREA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(AreaDefinitionAvp.class, new AreaDefinitionAvpImpl(ELPAVPCodes.AREA_DEFINITION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(AreaDefinitionAvp[].class, new AreaDefinitionAvpImpl[]{
        new AreaDefinitionAvpImpl(ELPAVPCodes.AREA_DEFINITION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new AreaDefinitionAvpImpl(ELPAVPCodes.AREA_DEFINITION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(AreaEventInfoAvp.class, new AreaEventInfoAvpImpl(ELPAVPCodes.AREA_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(AreaEventInfoAvp[].class, new AreaEventInfoAvpImpl[]{
        new AreaEventInfoAvpImpl(ELPAVPCodes.AREA_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new AreaEventInfoAvpImpl(ELPAVPCodes.AREA_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(DeferredMTLRDataAvp.class, new DeferredMTLRDataAvpImpl(ELPAVPCodes.DEFERRED_MT_LR_DATA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(DeferredMTLRDataAvp[].class, new DeferredMTLRDataAvpImpl[]{
        new DeferredMTLRDataAvpImpl(ELPAVPCodes.DEFERRED_MT_LR_DATA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new DeferredMTLRDataAvpImpl(ELPAVPCodes.DEFERRED_MT_LR_DATA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(DelayedLocationReportingDataAvp.class, new DelayedLocationReportingDataAvpImpl(ELPAVPCodes.DELAYED_LOCATION_REPORTING_DATA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(DelayedLocationReportingDataAvp[].class, new DelayedLocationReportingDataAvpImpl[]{
        new DelayedLocationReportingDataAvpImpl(ELPAVPCodes.DELAYED_LOCATION_REPORTING_DATA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new DelayedLocationReportingDataAvpImpl(ELPAVPCodes.DELAYED_LOCATION_REPORTING_DATA, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(ESMLCCellInfoAvp.class, new ESMLCCellInfoAvpImpl(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(ESMLCCellInfoAvp[].class, new ESMLCCellInfoAvpImpl[]{
        new ESMLCCellInfoAvpImpl(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new ESMLCCellInfoAvpImpl(ELPAVPCodes.ESMLC_CELL_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(GERANPositioningInfoAvp.class, new GERANPositioningInfoAvpImpl(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(GERANPositioningInfoAvp[].class, new GERANPositioningInfoAvpImpl[]{
        new GERANPositioningInfoAvpImpl(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new GERANPositioningInfoAvpImpl(ELPAVPCodes.GERAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(LCSEPSClientNameAvp.class, new LCSEPSClientNameAvpImpl(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(LCSEPSClientNameAvp[].class, new LCSEPSClientNameAvpImpl[]{
        new LCSEPSClientNameAvpImpl(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new LCSEPSClientNameAvpImpl(ELPAVPCodes.LCS_EPS_CLIENT_NAME, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(LCSPrivacyCheckNonSessionAvp.class, new LCSPrivacyCheckNonSessionAvpImpl(ELPAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(LCSPrivacyCheckNonSessionAvp[].class, new LCSPrivacyCheckNonSessionAvpImpl[]{
        new LCSPrivacyCheckNonSessionAvpImpl(ELPAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new LCSPrivacyCheckNonSessionAvpImpl(ELPAVPCodes.LCS_PRIVACY_CHECK_NON_SESSION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(LCSPrivacyCheckSessionAvp.class, new LCSPrivacyCheckSessionAvpImpl(ELPAVPCodes.LCS_PRIVACY_CHECK_SESSION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(LCSPrivacyCheckSessionAvp[].class, new LCSPrivacyCheckSessionAvpImpl[]{
        new LCSPrivacyCheckSessionAvpImpl(ELPAVPCodes.LCS_PRIVACY_CHECK_SESSION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new LCSPrivacyCheckSessionAvpImpl(ELPAVPCodes.LCS_PRIVACY_CHECK_SESSION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(LCSQoSAvp.class, new LCSQoSAvpImpl(ELPAVPCodes.LCS_QoS, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(LCSQoSAvp[].class, new LCSQoSAvpImpl[]{
        new LCSQoSAvpImpl(ELPAVPCodes.LCS_QoS, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new LCSQoSAvpImpl(ELPAVPCodes.LCS_QoS, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(LCSRequestorNameAvp.class, new LCSRequestorNameAvpImpl(ELPAVPCodes.LCS_REQUESTOR_NAME, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(LCSRequestorNameAvp[].class, new LCSRequestorNameAvpImpl[]{
        new LCSRequestorNameAvpImpl(ELPAVPCodes.LCS_REQUESTOR_NAME, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new LCSRequestorNameAvpImpl(ELPAVPCodes.LCS_REQUESTOR_NAME, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(MotionEventInfoAvp.class, new MotionEventInfoAvpImpl(ELPAVPCodes.MOTION_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(MotionEventInfoAvp[].class, new MotionEventInfoAvpImpl[]{
        new MotionEventInfoAvpImpl(ELPAVPCodes.MOTION_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new MotionEventInfoAvpImpl(ELPAVPCodes.MOTION_EVENT_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(PeriodicLDRInfoAvp.class, new PeriodicLDRInfoAvpImpl(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(PeriodicLDRInfoAvp[].class, new PeriodicLDRInfoAvpImpl[]{
        new PeriodicLDRInfoAvpImpl(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new PeriodicLDRInfoAvpImpl(ELPAVPCodes.PERIODIC_LDR_INFORMATION, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(PLMNIDListAvp.class, new PLMNIDListAvpImpl(ELPAVPCodes.PLMN_ID_LIST, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(PLMNIDListAvp[].class, new PLMNIDListAvpImpl[]{
        new PLMNIDListAvpImpl(ELPAVPCodes.PLMN_ID_LIST, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new PLMNIDListAvpImpl(ELPAVPCodes.PLMN_ID_LIST, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(ReportingPLMNListAvp.class, new ReportingPLMNListAvpImpl(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(ReportingPLMNListAvp[].class, new ReportingPLMNListAvpImpl[]{
        new ReportingPLMNListAvpImpl(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new ReportingPLMNListAvpImpl(ELPAVPCodes.REPORTING_PLMN_LIST, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(ServingNodeAvp.class, new ServingNodeAvpImpl(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(ServingNodeAvp[].class, new ServingNodeAvpImpl[]{
        new ServingNodeAvpImpl(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new ServingNodeAvpImpl(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(UTRANPositioningInfoAvp.class, new UTRANPositioningInfoAvpImpl(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(UTRANPositioningInfoAvp[].class, new UTRANPositioningInfoAvpImpl[]{
        new UTRANPositioningInfoAvpImpl(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes),
        new UTRANPositioningInfoAvpImpl(ELPAVPCodes.UTRAN_POSITIONING_INFO, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp.class, new org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl(
        ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp[].class, new org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl[]{
        new org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, 0, 1,
            dummyAvpBytes),
        new org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl(ELPAVPCodes.SUPPORTED_FEATURES, ELPAVPCodes.SLg_VENDOR_ID, 0, 1,
            dummyAvpBytes)});

  }

}