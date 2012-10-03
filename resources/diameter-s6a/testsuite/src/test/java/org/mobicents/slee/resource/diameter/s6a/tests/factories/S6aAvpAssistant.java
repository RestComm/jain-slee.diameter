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

import net.java.slee.resource.diameter.s6a.events.avp.AMBRAvp;
import net.java.slee.resource.diameter.s6a.events.avp.APNConfigurationAvp;
import net.java.slee.resource.diameter.s6a.events.avp.APNConfigurationProfileAvp;
import net.java.slee.resource.diameter.s6a.events.avp.ActiveAPNAvp;
import net.java.slee.resource.diameter.s6a.events.avp.AllocationRetentionPriorityAvp;
import net.java.slee.resource.diameter.s6a.events.avp.AuthenticationInfoAvp;
import net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes;
import net.java.slee.resource.diameter.s6a.events.avp.EPSLocationInformationAvp;
import net.java.slee.resource.diameter.s6a.events.avp.EPSSubscribedQoSProfileAvp;
import net.java.slee.resource.diameter.s6a.events.avp.EPSUserStateAvp;
import net.java.slee.resource.diameter.s6a.events.avp.EUTRANVectorAvp;
import net.java.slee.resource.diameter.s6a.events.avp.MIP6AgentInfoAvp;
import net.java.slee.resource.diameter.s6a.events.avp.MIPHomeAgentHostAvp;
import net.java.slee.resource.diameter.s6a.events.avp.MMELocationInformationAvp;
import net.java.slee.resource.diameter.s6a.events.avp.MMEUserStateAvp;
import net.java.slee.resource.diameter.s6a.events.avp.RequestedEUTRANAuthenticationInfoAvp;
import net.java.slee.resource.diameter.s6a.events.avp.RequestedUTRANGERANAuthenticationInfoAvp;
import net.java.slee.resource.diameter.s6a.events.avp.SGSNLocationInformationAvp;
import net.java.slee.resource.diameter.s6a.events.avp.SGSNUserStateAvp;
import net.java.slee.resource.diameter.s6a.events.avp.SpecificAPNInfoAvp;
import net.java.slee.resource.diameter.s6a.events.avp.SubscriptionDataAvp;
import net.java.slee.resource.diameter.s6a.events.avp.TerminalInformationAvp;

import org.mobicents.slee.resource.diameter.s6a.events.avp.AMBRAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.APNConfigurationAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.APNConfigurationProfileAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.ActiveAPNAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.AllocationRetentionPriorityAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.AuthenticationInfoAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.EPSLocationInformationAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.EPSSubscribedQoSProfileAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.EPSUserStateAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.EUTRANVectorAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.MIP6AgentInfoAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.MIPHomeAgentHostAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.MMELocationInformationAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.MMEUserStateAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.RequestedEUTRANAuthenticationInfoAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.RequestedUTRANGERANAuthenticationInfoAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.SGSNLocationInformationAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.SGSNUserStateAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.SpecificAPNInfoAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.SubscriptionDataAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.TerminalInformationAvpImpl;

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

	}

}
