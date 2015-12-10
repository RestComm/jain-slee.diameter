/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.diameter.s6a;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.base.events.avp.AvpUtilities;
import net.java.slee.resource.diameter.s6a.S6aAVPFactory;
import net.java.slee.resource.diameter.s6a.events.avp.*;

import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.*;

import static net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes.*;

/**
 * Diameter S6a Reference Point AVP Factory. Implementation for {@link S6aAVPFactory}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class S6aAVPFactoryImpl extends DiameterAvpFactoryImpl implements S6aAVPFactory {

    // TODO: Add helper create methods for the composite AVPs
    protected DiameterAvpFactory baseAvpFactory;

    public S6aAVPFactoryImpl(final DiameterAvpFactory baseAvpFactory) {
        this.baseAvpFactory = baseAvpFactory;
    }

    public DiameterAvpFactory getBaseFactory() {
        return this.baseAvpFactory;
    }

    public ActiveAPNAvp createActiveAPN() {
        return (ActiveAPNAvp) AvpUtilities.createAvp(ACTIVE_APN, S6A_VENDOR_ID, null, ActiveAPNAvpImpl.class);
    }

    public AllocationRetentionPriorityAvp createAllocationRetentionPriority() {
        return (AllocationRetentionPriorityAvp) AvpUtilities.createAvp(ALLOCATION_RETENTION_POLICY, S6A_VENDOR_ID, null, AllocationRetentionPriorityAvpImpl.class);
    }

    public AMBRAvp createAMBR() {
        return (AMBRAvp) AvpUtilities.createAvp(AMBR, S6A_VENDOR_ID, null, AMBRAvpImpl.class);
    }

    public APNConfigurationAvp createAPNConfiguration() {
        return (APNConfigurationAvp) AvpUtilities.createAvp(APN_CONFIGURATION, S6A_VENDOR_ID, null, APNConfigurationAvpImpl.class);
    }

    public APNConfigurationProfileAvp createAPNConfigurationProfile() {
        return (APNConfigurationProfileAvp) AvpUtilities.createAvp(APN_CONFIGURATION_PROFILE, S6A_VENDOR_ID, null, APNConfigurationProfileAvpImpl.class);
    }

    public AreaScopeAvp createAreaScopeAvp() {
        return (AreaScopeAvp) AvpUtilities.createAvp(AREA_SCOPE, S6A_VENDOR_ID, null, AreaScopeAvpImpl.class);
    }

    public AuthenticationInfoAvp createAuthenticationInfo() {
        return (AuthenticationInfoAvp) AvpUtilities.createAvp(AUTHENTICATION_INFO, S6A_VENDOR_ID, null, AuthenticationInfoAvpImpl.class);
    }

    public CallBarringInfoAvp createCallBarringInforList() {
        return (CallBarringInfoAvp) AvpUtilities.createAvp(CALL_BARRING_INFO, S6A_VENDOR_ID, null, CallBarringInfoAvpImpl.class);
    }

    public CSGSubscriptionDataAvp createCSGSubscriptionData() {
        return (CSGSubscriptionDataAvp) AvpUtilities.createAvp(CSG_SUBSCRIPTION_DATA, S6A_VENDOR_ID, null, CSGSubscriptionDataAvpImpl.class);
    }

    public EPSLocationInformationAvp createEPSLocationInformation() {
        return (EPSLocationInformationAvp) AvpUtilities.createAvp(EPS_LOCATION_INFORMATION, S6A_VENDOR_ID, null, EPSLocationInformationAvpImpl.class);
    }

    public EPSSubscribedQoSProfileAvp createEPSSubscribedQoSProfile() {
        return (EPSSubscribedQoSProfileAvp) AvpUtilities.createAvp(EPS_SUBSCRIBED_QOS_PROFILE, S6A_VENDOR_ID, null, EPSSubscribedQoSProfileAvpImpl.class);
    }

    public EPSUserStateAvp createEPSUserState() {
        return (EPSUserStateAvp) AvpUtilities.createAvp(EPS_USER_STATE, S6A_VENDOR_ID, null, EPSUserStateAvpImpl.class);
    }

    public EquivalentPLMNListAvp createEquivalentPLMNList() {
        return (EquivalentPLMNListAvp) AvpUtilities.createAvp(EQUIVALENT_PLMN_LIST, S6A_VENDOR_ID, null, EquivalentPLMNListAvpImpl.class);
    }

    public EUTRANVectorAvp createEUTRANVector() {
        return (EUTRANVectorAvp) AvpUtilities.createAvp(EUTRAN_VECTOR, S6A_VENDOR_ID, null, EUTRANVectorAvpImpl.class);
    }

    public ExternalClientAvp createExternalClient() {
        return (ExternalClientAvp) AvpUtilities.createAvp(EXTERNAL_CLIENT, S6A_VENDOR_ID, null, ExternalClientAvpImpl.class);
    }

    public GERANVectorAvp createGERANVector() {
        return (GERANVectorAvp) AvpUtilities.createAvp(GERAN_VECTOR, S6A_VENDOR_ID, null, GERANVectorAvpImpl.class);
    }

    public GPRSSubscriptionDataAvp createGPRSSubscriptionData() {
        return (GPRSSubscriptionDataAvp) AvpUtilities.createAvp(GPRS_SUBSCRIPTION_DATA, S6A_VENDOR_ID, null, GPRSSubscriptionDataAvpImpl.class);
    }

    public LCSInfoAvp createLCSInfo() {
        return (LCSInfoAvp) AvpUtilities.createAvp(LCS_INFO, S6A_VENDOR_ID, null, LCSInfoAvpImpl.class);
    }

    public LCSPrivacyExceptionAvp createLCSPrivacyException() {
        return (LCSPrivacyExceptionAvp) AvpUtilities.createAvp(LCS_PRIVACYEXCEPTION, S6A_VENDOR_ID, null, LCSPrivacyExceptionAvpImpl.class);
    }

    public LocalTimeZoneAvp createLocalTimeZone() {
        return (LocalTimeZoneAvp) AvpUtilities.createAvp(LOCAL_TIME_ZONE, S6A_VENDOR_ID, null, LocalTimeZoneAvpImpl.class);
    }

    public MDTConfigurationAvp createMDTConfigurationAvp() {
        return (MDTConfigurationAvp) AvpUtilities.createAvp(MDT_CONFIGURATION, S6A_VENDOR_ID, null, MDTConfigurationAvpImpl.class);
    }

    public MIP6AgentInfoAvp createMIP6AgentInfo() {
        return (MIP6AgentInfoAvp) AvpUtilities.createAvp(MIP6_AGENT_INFO, null, MIP6AgentInfoAvpImpl.class);
    }

    public MIPHomeAgentHostAvp createMIPHomeAgentHost() {
        return (MIPHomeAgentHostAvp) AvpUtilities.createAvp(MIP_HOME_AGENT_HOST, null, MIPHomeAgentHostAvpImpl.class);
    }

    public MMELocationInformationAvp createMMELocationInformation() {
        return (MMELocationInformationAvp) AvpUtilities.createAvp(MME_LOCATION_INFORMATION, S6A_VENDOR_ID, null, MMELocationInformationAvpImpl.class);
    }

    public MMEUserStateAvp createMMEUserState() {
        return (MMEUserStateAvp) AvpUtilities.createAvp(MME_USER_STATE, S6A_VENDOR_ID, null, MMEUserStateAvpImpl.class);
    }

    public MOLRAvp createMOLR() {
        return (MOLRAvp) AvpUtilities.createAvp(MO_LR, S6A_VENDOR_ID, null, MOLRAvpImpl.class);
    }

    public PDPContextAvp createPDPContext() {
        return (PDPContextAvp) AvpUtilities.createAvp(PDP_CONTEXT, S6A_VENDOR_ID, null, PDPContextAvpImpl.class);
    }

    public ProSeAllowedPLMNAvp createProSeAllowedPLMN() {
        return (ProSeAllowedPLMNAvp) AvpUtilities.createAvp(PROSE_ALLOWED_PLMN, S6A_VENDOR_ID, null, ProSeAllowedPLMNAvpImpl.class);
    }

    public ProSESubscriptionDataAvp createProSeSubscriptionData() {
        return (ProSESubscriptionDataAvp) AvpUtilities.createAvp(PROSE_SUBSCRIPTION_DATA, S6A_VENDOR_ID, null, ProSeSubscriptionDataAvpImpl.class);
    }

    public RequestedEUTRANAuthenticationInfoAvp createRequestedEUTRANAuthenticationInfo() {
        return (RequestedEUTRANAuthenticationInfoAvp) AvpUtilities.createAvp(REQUESTED_EUTRAN_AUTHENTICATION_INFO, S6A_VENDOR_ID, null, RequestedEUTRANAuthenticationInfoAvpImpl.class);
    }

    public RequestedUTRANGERANAuthenticationInfoAvp createRequestedUTRANGERANAuthenticationInfo() {
        return (RequestedUTRANGERANAuthenticationInfoAvp) AvpUtilities.createAvp(REQUESTED_UTRAN_GERAN_AUTHENTICATION_INFO, S6A_VENDOR_ID, null, RequestedUTRANGERANAuthenticationInfoAvpImpl.class);
    }

    public ServiceTypeAvp createServiceType() {
        return (ServiceTypeAvp) AvpUtilities.createAvp(SERVICE_TYPE, S6A_VENDOR_ID, null, ServiceTypeAvpImpl.class);
    }

    public SGSNLocationInformationAvp createSGSNLocationInformation() {
        return (SGSNLocationInformationAvp) AvpUtilities.createAvp(SGSN_LOCATION_INFORMATION, S6A_VENDOR_ID, null, SGSNLocationInformationAvpImpl.class);
    }

    public SGSNUserStateAvp createSGSNUserState() {
        return (SGSNUserStateAvp) AvpUtilities.createAvp(SGSN_USER_STATE, S6A_VENDOR_ID, null, SGSNUserStateAvpImpl.class);
    }

    public SpecificAPNInfoAvp createSpecificAPNInfo() {
        return (SpecificAPNInfoAvp) AvpUtilities.createAvp(SPECIFIC_APN_INFO, S6A_VENDOR_ID, null, SpecificAPNInfoAvpImpl.class);
    }

    public SubscriptionDataAvp createSubscriptionData() {
        return (SubscriptionDataAvp) AvpUtilities.createAvp(SUBSCRIPTION_DATA, S6A_VENDOR_ID, null, SubscriptionDataAvpImpl.class);
    }

    public SupportedFeaturesAvp createSupportedFeatures() {
        return (SupportedFeaturesAvp) AvpUtilities.createAvp(SUPPORTED_FEATURES, S6A_VENDOR_ID, null, SupportedFeaturesAvpImpl.class);
    }

    public TeleserviceListAvp createTeleserviceList(){
        return (TeleserviceListAvp) AvpUtilities.createAvp(TELESERVICE_LIST, S6A_VENDOR_ID, null, TeleserviceListAvpImpl.class);
    }

    public TerminalInformationAvp createTerminalInformation() {
        return (TerminalInformationAvp) AvpUtilities.createAvp(TERMINAL_INFORMATION, S6A_VENDOR_ID, null, TerminalInformationAvpImpl.class);
    }

    public TraceDataAvp createTraceData() {
        return (TraceDataAvp) AvpUtilities.createAvp(TRACE_DATA, S6A_VENDOR_ID, null, TraceDataAvpImpl.class);
    }

    public UserCSGInformationAvp createUserCSGInformation() {
        return (UserCSGInformationAvp) AvpUtilities.createAvp(USER_CSG_INFORMATION, S6A_VENDOR_ID, null, UserCSGInformationAvpImpl.class);
    }

    public UTRANVectorAvp createUTRANVector() {
        return (UTRANVectorAvp) AvpUtilities.createAvp(UTRAN_VECTOR, S6A_VENDOR_ID, null, UTRANVectorAvpImpl.class);
    }

    public VPLMNCSGSubscriptionDataAvp createVPLMNCSGSubscriptionData() {
        return (VPLMNCSGSubscriptionDataAvp) AvpUtilities.createAvp(VPLMN_CSG_SUBSCRIPTION_DATA, S6A_VENDOR_ID, null, VPLMNCSGSubscriptionDataAvpImpl.class);
    }

    public WLANoffloadabilityAvp createWLANoffloadability() {
        return (WLANoffloadabilityAvp) AvpUtilities.createAvp(WLAN_OFFLOADABILITY, S6A_VENDOR_ID, null, WLANoffloadabilityAvpImpl.class);
    }
}