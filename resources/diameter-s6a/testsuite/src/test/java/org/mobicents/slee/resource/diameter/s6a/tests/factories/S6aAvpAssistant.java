/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008-2011, Red Hat, Inc. and individual contributors
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

package org.mobicents.slee.resource.diameter.s6a.tests.factories;

import net.java.slee.resource.diameter.s6a.events.avp.*;

import org.mobicents.slee.resource.diameter.s6a.events.avp.*;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class S6aAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

	public static S6aAvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new S6aAvpAssistant();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected S6aAvpAssistant() throws Exception {
		super();

		// S6a AVP Factory

		typeValues.put(ActiveAPNAvp.class, new ActiveAPNAvpImpl(DiameterS6aAvpCodes.ACTIVE_APN, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(ActiveAPNAvp[].class, new ActiveAPNAvpImpl[] { new ActiveAPNAvpImpl(DiameterS6aAvpCodes.ACTIVE_APN, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new ActiveAPNAvpImpl(DiameterS6aAvpCodes.ACTIVE_APN, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(AllocationRetentionPriorityAvp.class, new AllocationRetentionPriorityAvpImpl(DiameterS6aAvpCodes.ALLOCATION_RETENTION_POLICY, DiameterS6aAvpCodes.S6A_VENDOR_ID,
				0, 1, dummyAvpBytes));
		typeValues.put(AllocationRetentionPriorityAvp[].class, new AllocationRetentionPriorityAvpImpl[] {
				new AllocationRetentionPriorityAvpImpl(DiameterS6aAvpCodes.ALLOCATION_RETENTION_POLICY, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new AllocationRetentionPriorityAvpImpl(DiameterS6aAvpCodes.ALLOCATION_RETENTION_POLICY, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(AMBRAvp.class, new AMBRAvpImpl(DiameterS6aAvpCodes.AMBR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(AMBRAvp[].class, new AMBRAvpImpl[] { new AMBRAvpImpl(DiameterS6aAvpCodes.AMBR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new AMBRAvpImpl(DiameterS6aAvpCodes.AMBR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(APNConfigurationAvp.class, new APNConfigurationAvpImpl(DiameterS6aAvpCodes.APN_CONFIGURATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(APNConfigurationAvp[].class, new APNConfigurationAvpImpl[] {
				new APNConfigurationAvpImpl(DiameterS6aAvpCodes.APN_CONFIGURATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new APNConfigurationAvpImpl(DiameterS6aAvpCodes.APN_CONFIGURATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(APNConfigurationProfileAvp.class, new APNConfigurationProfileAvpImpl(DiameterS6aAvpCodes.APN_CONFIGURATION_PROFILE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(APNConfigurationProfileAvp[].class, new APNConfigurationProfileAvpImpl[] {
				new APNConfigurationProfileAvpImpl(DiameterS6aAvpCodes.APN_CONFIGURATION_PROFILE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new APNConfigurationProfileAvpImpl(DiameterS6aAvpCodes.APN_CONFIGURATION_PROFILE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(AuthenticationInfoAvp.class, new AuthenticationInfoAvpImpl(DiameterS6aAvpCodes.AUTHENTICATION_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(AuthenticationInfoAvp[].class, new AuthenticationInfoAvpImpl[] {
				new AuthenticationInfoAvpImpl(DiameterS6aAvpCodes.AUTHENTICATION_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new AuthenticationInfoAvpImpl(DiameterS6aAvpCodes.AUTHENTICATION_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(EPSLocationInformationAvp.class, new EPSLocationInformationAvpImpl(DiameterS6aAvpCodes.EPS_LOCATION_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(EPSLocationInformationAvp[].class, new EPSLocationInformationAvpImpl[] {
				new EPSLocationInformationAvpImpl(DiameterS6aAvpCodes.EPS_LOCATION_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new EPSLocationInformationAvpImpl(DiameterS6aAvpCodes.EPS_LOCATION_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(EPSSubscribedQoSProfileAvp.class, new EPSSubscribedQoSProfileAvpImpl(DiameterS6aAvpCodes.EPS_SUBSCRIBED_QOS_PROFILE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(EPSSubscribedQoSProfileAvp[].class, new EPSSubscribedQoSProfileAvpImpl[] {
				new EPSSubscribedQoSProfileAvpImpl(DiameterS6aAvpCodes.EPS_SUBSCRIBED_QOS_PROFILE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new EPSSubscribedQoSProfileAvpImpl(DiameterS6aAvpCodes.EPS_SUBSCRIBED_QOS_PROFILE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(EPSUserStateAvp.class, new EPSUserStateAvpImpl(DiameterS6aAvpCodes.EPS_USER_STATE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(EPSUserStateAvp[].class, new EPSUserStateAvpImpl[] {
				new EPSUserStateAvpImpl(DiameterS6aAvpCodes.EPS_USER_STATE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new EPSUserStateAvpImpl(DiameterS6aAvpCodes.EPS_USER_STATE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(EUTRANVectorAvp.class, new EUTRANVectorAvpImpl(DiameterS6aAvpCodes.E_UTRAN_VECTOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(EUTRANVectorAvp[].class, new EUTRANVectorAvpImpl[] {
				new EUTRANVectorAvpImpl(DiameterS6aAvpCodes.E_UTRAN_VECTOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new EUTRANVectorAvpImpl(DiameterS6aAvpCodes.E_UTRAN_VECTOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(SubscriptionDataAvp.class, new SubscriptionDataAvpImpl(DiameterS6aAvpCodes.SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(SubscriptionDataAvp[].class, new SubscriptionDataAvpImpl[] {
				new SubscriptionDataAvpImpl(DiameterS6aAvpCodes.SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new SubscriptionDataAvpImpl(DiameterS6aAvpCodes.SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(RequestedEUTRANAuthenticationInfoAvp.class, new RequestedEUTRANAuthenticationInfoAvpImpl(DiameterS6aAvpCodes.REQUESTED_EUTRAN_AUTHENTICATION_INFO,
				DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(RequestedEUTRANAuthenticationInfoAvp[].class, new RequestedEUTRANAuthenticationInfoAvpImpl[] {
				new RequestedEUTRANAuthenticationInfoAvpImpl(DiameterS6aAvpCodes.REQUESTED_EUTRAN_AUTHENTICATION_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new RequestedEUTRANAuthenticationInfoAvpImpl(DiameterS6aAvpCodes.REQUESTED_EUTRAN_AUTHENTICATION_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(RequestedUTRANGERANAuthenticationInfoAvp.class, new RequestedUTRANGERANAuthenticationInfoAvpImpl(DiameterS6aAvpCodes.REQUESTED_UTRAN_GERAN_AUTHENTICATION_INFO,
				DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(RequestedUTRANGERANAuthenticationInfoAvp[].class, new RequestedUTRANGERANAuthenticationInfoAvpImpl[] {
				new RequestedUTRANGERANAuthenticationInfoAvpImpl(DiameterS6aAvpCodes.REQUESTED_UTRAN_GERAN_AUTHENTICATION_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new RequestedUTRANGERANAuthenticationInfoAvpImpl(DiameterS6aAvpCodes.REQUESTED_UTRAN_GERAN_AUTHENTICATION_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(MIP6AgentInfoAvp.class, new MIP6AgentInfoAvpImpl(DiameterS6aAvpCodes.MIP6_AGENT_INFO, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(MIP6AgentInfoAvp[].class, new MIP6AgentInfoAvpImpl[] { new MIP6AgentInfoAvpImpl(DiameterS6aAvpCodes.MIP6_AGENT_INFO, 0L, 0, 1, dummyAvpBytes),
				new MIP6AgentInfoAvpImpl(DiameterS6aAvpCodes.MIP6_AGENT_INFO, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(MIPHomeAgentHostAvp.class, new MIPHomeAgentHostAvpImpl(DiameterS6aAvpCodes.MIP_HOME_AGENT_HOST, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(MIPHomeAgentHostAvp[].class, new MIPHomeAgentHostAvpImpl[] { new MIPHomeAgentHostAvpImpl(DiameterS6aAvpCodes.MIP_HOME_AGENT_HOST, 0L, 0, 1, dummyAvpBytes),
				new MIPHomeAgentHostAvpImpl(DiameterS6aAvpCodes.MIP_HOME_AGENT_HOST, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(MMELocationInformationAvp.class, new MMELocationInformationAvpImpl(DiameterS6aAvpCodes.MME_LOCATION_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(MMELocationInformationAvp[].class, new MMELocationInformationAvpImpl[] {
				new MMELocationInformationAvpImpl(DiameterS6aAvpCodes.MME_LOCATION_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new MMELocationInformationAvpImpl(DiameterS6aAvpCodes.MME_LOCATION_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(MMEUserStateAvp.class, new MMEUserStateAvpImpl(DiameterS6aAvpCodes.MME_USER_STATE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(MMEUserStateAvp[].class, new MMEUserStateAvpImpl[] {
				new MMEUserStateAvpImpl(DiameterS6aAvpCodes.MME_USER_STATE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new MMEUserStateAvpImpl(DiameterS6aAvpCodes.MME_USER_STATE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(SGSNLocationInformationAvp.class, new SGSNLocationInformationAvpImpl(DiameterS6aAvpCodes.SGSN_LOCATION_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(SGSNLocationInformationAvp[].class, new SGSNLocationInformationAvpImpl[] {
				new SGSNLocationInformationAvpImpl(DiameterS6aAvpCodes.SGSN_LOCATION_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new SGSNLocationInformationAvpImpl(DiameterS6aAvpCodes.SGSN_LOCATION_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(SGSNUserStateAvp.class, new SGSNUserStateAvpImpl(DiameterS6aAvpCodes.SGSN_USER_STATE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(SGSNUserStateAvp[].class, new SGSNUserStateAvpImpl[] {
				new SGSNUserStateAvpImpl(DiameterS6aAvpCodes.SGSN_USER_STATE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new SGSNUserStateAvpImpl(DiameterS6aAvpCodes.SGSN_USER_STATE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(SpecificAPNInfoAvp.class, new SpecificAPNInfoAvpImpl(DiameterS6aAvpCodes.SPECIFIC_APN_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(SpecificAPNInfoAvp[].class, new SpecificAPNInfoAvpImpl[] {
				new SpecificAPNInfoAvpImpl(DiameterS6aAvpCodes.SPECIFIC_APN_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new SpecificAPNInfoAvpImpl(DiameterS6aAvpCodes.SPECIFIC_APN_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.s6a.events.avp.SupportedFeaturesAvp.class, new org.mobicents.slee.resource.diameter.s6a.events.avp.SupportedFeaturesAvpImpl(
				DiameterS6aAvpCodes.SUPPORTED_FEATURES, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.s6a.events.avp.SupportedFeaturesAvp[].class, new org.mobicents.slee.resource.diameter.s6a.events.avp.SupportedFeaturesAvpImpl[] {
				new org.mobicents.slee.resource.diameter.s6a.events.avp.SupportedFeaturesAvpImpl(DiameterS6aAvpCodes.SUPPORTED_FEATURES, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1,
						dummyAvpBytes),
				new org.mobicents.slee.resource.diameter.s6a.events.avp.SupportedFeaturesAvpImpl(DiameterS6aAvpCodes.SUPPORTED_FEATURES, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1,
						dummyAvpBytes) });

		typeValues.put(TerminalInformationAvp.class, new TerminalInformationAvpImpl(DiameterS6aAvpCodes.TERMINAL_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(TerminalInformationAvp[].class, new TerminalInformationAvpImpl[] {
				new TerminalInformationAvpImpl(DiameterS6aAvpCodes.TERMINAL_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
				new TerminalInformationAvpImpl(DiameterS6aAvpCodes.TERMINAL_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(UTRANVectorAvp.class, new UTRANVectorAvpImpl(DiameterS6aAvpCodes.UTRAN_VECTOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(UTRANVectorAvp[].class, new UTRANVectorAvpImpl[] {
                new UTRANVectorAvpImpl(DiameterS6aAvpCodes.UTRAN_VECTOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new UTRANVectorAvpImpl(DiameterS6aAvpCodes.UTRAN_VECTOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(GERANVectorAvp.class, new GERANVectorAvpImpl(DiameterS6aAvpCodes.GERAN_VECTOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(GERANVectorAvp[].class, new GERANVectorAvpImpl[] {
                new GERANVectorAvpImpl(DiameterS6aAvpCodes.GERAN_VECTOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new GERANVectorAvpImpl(DiameterS6aAvpCodes.GERAN_VECTOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(LCSInfoAvp.class, new LCSInfoAvpImpl(DiameterS6aAvpCodes.LCS_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(LCSInfoAvp[].class, new LCSInfoAvpImpl[] { new LCSInfoAvpImpl(DiameterS6aAvpCodes.LCS_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new LCSInfoAvpImpl(DiameterS6aAvpCodes.LCS_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(LCSPrivacyExceptionAvp.class, new LCSPrivacyExceptionAvpImpl(DiameterS6aAvpCodes.LCS_PRIVACYEXCEPTION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(LCSPrivacyExceptionAvp[].class, new LCSPrivacyExceptionAvpImpl[] { new LCSPrivacyExceptionAvpImpl(DiameterS6aAvpCodes.LCS_PRIVACYEXCEPTION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new LCSPrivacyExceptionAvpImpl(DiameterS6aAvpCodes.LCS_PRIVACYEXCEPTION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(ServiceTypeAvp.class, new ServiceTypeAvpImpl(DiameterS6aAvpCodes.SERVICE_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(ServiceTypeAvp[].class, new ServiceTypeAvpImpl[] { new ServiceTypeAvpImpl(DiameterS6aAvpCodes.SERVICE_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new ServiceTypeAvpImpl(DiameterS6aAvpCodes.SERVICE_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });


        typeValues.put(TeleserviceListAvp.class, new TeleserviceListAvpImpl(DiameterS6aAvpCodes.TELESERVICE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(TeleserviceListAvp[].class, new TeleserviceListAvpImpl[] { new TeleserviceListAvpImpl(DiameterS6aAvpCodes.TELESERVICE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new TeleserviceListAvpImpl(DiameterS6aAvpCodes.TELESERVICE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(CallBarringInfoAvp.class, new CallBarringInfoAvpImpl(DiameterS6aAvpCodes.CALL_BARRING_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(CallBarringInfoAvp[].class, new CallBarringInfoAvpImpl[] { new CallBarringInfoAvpImpl(DiameterS6aAvpCodes.CALL_BARRING_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new CallBarringInfoAvpImpl(DiameterS6aAvpCodes.CALL_BARRING_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(TraceDataAvp.class, new TraceDataAvpImpl(DiameterS6aAvpCodes.TRACE_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(TraceDataAvp[].class, new TraceDataAvpImpl[] { new TraceDataAvpImpl(DiameterS6aAvpCodes.TRACE_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new TraceDataAvpImpl(DiameterS6aAvpCodes.TRACE_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(GPRSSubscriptionDataAvp.class, new GPRSSubscriptionDataAvpImpl(DiameterS6aAvpCodes.GPRS_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(GPRSSubscriptionDataAvp[].class, new GPRSSubscriptionDataAvpImpl[] { new GPRSSubscriptionDataAvpImpl(DiameterS6aAvpCodes.GPRS_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new GPRSSubscriptionDataAvpImpl(DiameterS6aAvpCodes.GPRS_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(CSGSubscriptionDataAvp.class, new CSGSubscriptionDataAvpImpl(DiameterS6aAvpCodes.CSG_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(CSGSubscriptionDataAvp[].class, new CSGSubscriptionDataAvpImpl[]{new CSGSubscriptionDataAvpImpl(DiameterS6aAvpCodes.CSG_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new CSGSubscriptionDataAvpImpl(DiameterS6aAvpCodes.CSG_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(ExternalClientAvp.class, new ExternalClientAvpImpl(DiameterS6aAvpCodes.EXTERNAL_CLIENT, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(ExternalClientAvp[].class, new ExternalClientAvpImpl[]{new ExternalClientAvpImpl(DiameterS6aAvpCodes.EXTERNAL_CLIENT, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new ExternalClientAvpImpl(DiameterS6aAvpCodes.EXTERNAL_CLIENT, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(MOLRAvp.class, new MOLRAvpImpl(DiameterS6aAvpCodes.MO_LR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(MOLRAvp[].class, new MOLRAvpImpl[]{new MOLRAvpImpl(DiameterS6aAvpCodes.MO_LR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new MOLRAvpImpl(DiameterS6aAvpCodes.MO_LR, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(PDPContextAvp.class, new PDPContextAvpImpl(DiameterS6aAvpCodes.PDP_CONTEXT, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(PDPContextAvp[].class, new PDPContextAvpImpl[]{new PDPContextAvpImpl(DiameterS6aAvpCodes.PDP_CONTEXT, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new PDPContextAvpImpl(DiameterS6aAvpCodes.PDP_CONTEXT, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});
        
        typeValues.put(LocalTimeZoneAvp.class, new LocalTimeZoneAvpImpl(DiameterS6aAvpCodes.LOCAL_TIME_ZONE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(LocalTimeZoneAvp[].class, new LocalTimeZoneAvpImpl[]{new LocalTimeZoneAvpImpl(DiameterS6aAvpCodes.LOCAL_TIME_ZONE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new LocalTimeZoneAvpImpl(DiameterS6aAvpCodes.LOCAL_TIME_ZONE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(EquivalentPLMNListAvp.class, new EquivalentPLMNListAvpImpl(DiameterS6aAvpCodes.EQUIVALENT_PLMN_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(EquivalentPLMNListAvp[].class, new EquivalentPLMNListAvpImpl[]{new EquivalentPLMNListAvpImpl(DiameterS6aAvpCodes.EQUIVALENT_PLMN_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new EquivalentPLMNListAvpImpl(DiameterS6aAvpCodes.EQUIVALENT_PLMN_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(AreaScopeAvp.class, new AreaScopeAvpImpl(DiameterS6aAvpCodes.AREA_SCOPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(AreaScopeAvp[].class, new AreaScopeAvpImpl[]{new AreaScopeAvpImpl(DiameterS6aAvpCodes.AREA_SCOPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new AreaScopeAvpImpl(DiameterS6aAvpCodes.AREA_SCOPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(MDTConfigurationAvp.class, new MDTConfigurationAvpImpl(DiameterS6aAvpCodes.MDT_CONFIGURATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(MDTConfigurationAvp[].class, new MDTConfigurationAvpImpl[]{new MDTConfigurationAvpImpl(DiameterS6aAvpCodes.MDT_CONFIGURATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new MDTConfigurationAvpImpl(DiameterS6aAvpCodes.MDT_CONFIGURATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(VPLMNCSGSubscriptionDataAvp.class, new VPLMNCSGSubscriptionDataAvpImpl(DiameterS6aAvpCodes.VPLMN_CSG_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(VPLMNCSGSubscriptionDataAvp[].class, new VPLMNCSGSubscriptionDataAvpImpl[]{new VPLMNCSGSubscriptionDataAvpImpl(DiameterS6aAvpCodes.VPLMN_CSG_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new VPLMNCSGSubscriptionDataAvpImpl(DiameterS6aAvpCodes.VPLMN_CSG_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(WLANoffloadabilityAvp.class, new WLANoffloadabilityAvpImpl(DiameterS6aAvpCodes.WLAN_OFFLOADABILITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(WLANoffloadabilityAvp[].class, new WLANoffloadabilityAvpImpl[]{new WLANoffloadabilityAvpImpl(DiameterS6aAvpCodes.WLAN_OFFLOADABILITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new WLANoffloadabilityAvpImpl(DiameterS6aAvpCodes.WLAN_OFFLOADABILITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(UserCSGInformationAvp.class, new UserCSGInformationAvpImpl(DiameterS6aAvpCodes.USER_CSG_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(UserCSGInformationAvp[].class, new UserCSGInformationAvpImpl[]{new UserCSGInformationAvpImpl(DiameterS6aAvpCodes.USER_CSG_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new UserCSGInformationAvpImpl(DiameterS6aAvpCodes.USER_CSG_INFORMATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(ProSESubscriptionDataAvp.class, new ProSeSubscriptionDataAvpImpl(DiameterS6aAvpCodes.PROSE_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(ProSESubscriptionDataAvp[].class, new ProSeSubscriptionDataAvpImpl[]{new ProSeSubscriptionDataAvpImpl(DiameterS6aAvpCodes.PROSE_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new ProSeSubscriptionDataAvpImpl(DiameterS6aAvpCodes.PROSE_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});

        typeValues.put(ProSeAllowedPLMNAvp.class, new ProSeAllowedPLMNAvpImpl(DiameterS6aAvpCodes.PROSE_ALLOWED_PLMN, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(ProSeAllowedPLMNAvp[].class, new ProSeAllowedPLMNAvpImpl[]{new ProSeAllowedPLMNAvpImpl(DiameterS6aAvpCodes.PROSE_ALLOWED_PLMN, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes),
                new ProSeAllowedPLMNAvpImpl(DiameterS6aAvpCodes.PROSE_ALLOWED_PLMN, DiameterS6aAvpCodes.S6A_VENDOR_ID, 0, 1, dummyAvpBytes)});
    }
}