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

package org.mobicents.slee.resource.diameter.cxdx.tests.factories;

import net.java.slee.resource.diameter.cxdx.events.avp.AssociatedIdentities;
import net.java.slee.resource.diameter.cxdx.events.avp.AssociatedRegisteredIdentities;
import net.java.slee.resource.diameter.cxdx.events.avp.CableLabsSIPDigestAuthenticate;
import net.java.slee.resource.diameter.cxdx.events.avp.ChargingInformation;
import net.java.slee.resource.diameter.cxdx.events.avp.DeregistrationReason;
import net.java.slee.resource.diameter.cxdx.events.avp.DiameterCxDxAvpCodes;
import net.java.slee.resource.diameter.cxdx.events.avp.EtsiSIPAuthenticate;
import net.java.slee.resource.diameter.cxdx.events.avp.EtsiSIPAuthenticationInfo;
import net.java.slee.resource.diameter.cxdx.events.avp.EtsiSIPAuthorization;
import net.java.slee.resource.diameter.cxdx.events.avp.IdentitywithEmergencyRegistration;
import net.java.slee.resource.diameter.cxdx.events.avp.RestorationInfo;
import net.java.slee.resource.diameter.cxdx.events.avp.SCSCFRestorationInfo;
import net.java.slee.resource.diameter.cxdx.events.avp.SIPAuthDataItem;
import net.java.slee.resource.diameter.cxdx.events.avp.SIPDigestAuthenticate;
import net.java.slee.resource.diameter.cxdx.events.avp.SubscriptionInfo;
import net.java.slee.resource.diameter.cxdx.events.avp.SupportedFeaturesAvp;

import org.mobicents.slee.resource.diameter.cxdx.events.avp.AssociatedIdentitiesImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.AssociatedRegisteredIdentitiesImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.CableLabsSIPDigestAuthenticateImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.ChargingInformationImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.DeregistrationReasonImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.EtsiSIPAuthenticateImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.EtsiSIPAuthenticationInfoImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.EtsiSIPAuthorizationImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.IdentitywithEmergencyRegistrationImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.RestorationInfoImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.SCSCFRestorationInfoImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.SIPAuthDataItemImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.SIPDigestAuthenticateImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.SubscriptionInfoImpl;
import org.mobicents.slee.resource.diameter.cxdx.events.avp.SupportedFeaturesAvpImpl;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class CxDxAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

	public static CxDxAvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new CxDxAvpAssistant();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected CxDxAvpAssistant() throws Exception {
		super();

		// Cx/Dx AVP Factory

		typeValues.put(SIPAuthDataItem.class, new SIPAuthDataItemImpl(DiameterCxDxAvpCodes.SIP_AUTH_DATA_ITEM, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(SIPAuthDataItem[].class, new SIPAuthDataItemImpl[] { new SIPAuthDataItemImpl(DiameterCxDxAvpCodes.SIP_AUTH_DATA_ITEM, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(ChargingInformation.class, new ChargingInformationImpl(DiameterCxDxAvpCodes.CHARGING_INFORMATION, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(ChargingInformation[].class, new ChargingInformationImpl[] { new ChargingInformationImpl(DiameterCxDxAvpCodes.CHARGING_INFORMATION,
				DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(AssociatedIdentities.class, new AssociatedIdentitiesImpl(DiameterCxDxAvpCodes.ASSOCIATED_IDENTITIES, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(AssociatedIdentities[].class, new AssociatedIdentitiesImpl[] { new AssociatedIdentitiesImpl(DiameterCxDxAvpCodes.ASSOCIATED_IDENTITIES,
				DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(AssociatedRegisteredIdentities.class, new AssociatedRegisteredIdentitiesImpl(DiameterCxDxAvpCodes.ASSOCIATED_REGISTERED_IDENTITIES,
				DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(AssociatedRegisteredIdentities[].class, new AssociatedRegisteredIdentitiesImpl[] { new AssociatedRegisteredIdentitiesImpl(
				DiameterCxDxAvpCodes.ASSOCIATED_REGISTERED_IDENTITIES, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(DeregistrationReason.class, new DeregistrationReasonImpl(DiameterCxDxAvpCodes.DEREGISTRATION_REASON, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(DeregistrationReason[].class, new DeregistrationReasonImpl[] { new DeregistrationReasonImpl(DiameterCxDxAvpCodes.DEREGISTRATION_REASON,
				DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(SCSCFRestorationInfo.class, new SCSCFRestorationInfoImpl(DiameterCxDxAvpCodes.SCSCF_RESTORATION_INFO, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(SCSCFRestorationInfo[].class, new SCSCFRestorationInfoImpl[] { new SCSCFRestorationInfoImpl(DiameterCxDxAvpCodes.SCSCF_RESTORATION_INFO,
				DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(SubscriptionInfo.class, new SubscriptionInfoImpl(DiameterCxDxAvpCodes.SUBSCRIPTION_INFO, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(SubscriptionInfo[].class, new SubscriptionInfoImpl[] { new SubscriptionInfoImpl(DiameterCxDxAvpCodes.SUBSCRIPTION_INFO, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0,
				1, dummyAvpBytes) });

		typeValues.put(SIPDigestAuthenticate.class, new SIPDigestAuthenticateImpl(DiameterCxDxAvpCodes.SIP_DIGEST_AUTHENTICATE, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(SIPDigestAuthenticate[].class, new SIPDigestAuthenticateImpl[] { new SIPDigestAuthenticateImpl(DiameterCxDxAvpCodes.SIP_DIGEST_AUTHENTICATE,
				DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(CableLabsSIPDigestAuthenticate.class, new CableLabsSIPDigestAuthenticateImpl(DiameterCxDxAvpCodes.CABLELABS_SIP_DIGEST_AUTHENTICATE,
				DiameterCxDxAvpCodes.CABLELABS_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(CableLabsSIPDigestAuthenticate[].class, new CableLabsSIPDigestAuthenticateImpl[] { new CableLabsSIPDigestAuthenticateImpl(
				DiameterCxDxAvpCodes.CABLELABS_SIP_DIGEST_AUTHENTICATE, DiameterCxDxAvpCodes.CABLELABS_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(RestorationInfo.class, new RestorationInfoImpl(DiameterCxDxAvpCodes.RESTORATION_INFO, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(RestorationInfo[].class, new RestorationInfoImpl[] { new RestorationInfoImpl(DiameterCxDxAvpCodes.RESTORATION_INFO, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.cxdx.events.avp.ServerCapabilities.class, new org.mobicents.slee.resource.diameter.cxdx.events.avp.ServerCapabilitiesImpl(
				DiameterCxDxAvpCodes.SERVER_CAPABILITIES, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.cxdx.events.avp.ServerCapabilities[].class,
				new org.mobicents.slee.resource.diameter.cxdx.events.avp.ServerCapabilitiesImpl[] { new org.mobicents.slee.resource.diameter.cxdx.events.avp.ServerCapabilitiesImpl(
						DiameterCxDxAvpCodes.SERVER_CAPABILITIES, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(EtsiSIPAuthorization.class, new EtsiSIPAuthorizationImpl(DiameterCxDxAvpCodes.ETSI_SIP_AUTHORIZATION, DiameterCxDxAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(EtsiSIPAuthorization[].class, new EtsiSIPAuthorizationImpl[] { new EtsiSIPAuthorizationImpl(DiameterCxDxAvpCodes.ETSI_SIP_AUTHORIZATION,
				DiameterCxDxAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(EtsiSIPAuthenticate.class, new EtsiSIPAuthenticateImpl(DiameterCxDxAvpCodes.ETSI_SIP_AUTHENTICATE, DiameterCxDxAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(EtsiSIPAuthenticate[].class, new EtsiSIPAuthenticateImpl[] { new EtsiSIPAuthenticateImpl(DiameterCxDxAvpCodes.ETSI_SIP_AUTHENTICATE,
				DiameterCxDxAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(EtsiSIPAuthenticationInfo.class, new EtsiSIPAuthenticationInfoImpl(DiameterCxDxAvpCodes.ETSI_SIP_AUTHENTICATION_INFO, DiameterCxDxAvpCodes.ETSI_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(EtsiSIPAuthenticationInfo[].class, new EtsiSIPAuthenticationInfoImpl[] { new EtsiSIPAuthenticationInfoImpl(DiameterCxDxAvpCodes.ETSI_SIP_AUTHENTICATION_INFO,
				DiameterCxDxAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(SupportedFeaturesAvp.class, new SupportedFeaturesAvpImpl(DiameterCxDxAvpCodes.SUPPORTED_FEATURES, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(SupportedFeaturesAvp[].class, new SupportedFeaturesAvpImpl[] {
				new SupportedFeaturesAvpImpl(DiameterCxDxAvpCodes.SUPPORTED_FEATURES, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes),
				new SupportedFeaturesAvpImpl(DiameterCxDxAvpCodes.SUPPORTED_FEATURES, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes) });

        typeValues.put(IdentitywithEmergencyRegistration.class, new IdentitywithEmergencyRegistrationImpl(DiameterCxDxAvpCodes.IDENTITY_WITH_EMERGENCY_REGISTRATION, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1, dummyAvpBytes));
        typeValues.put(IdentitywithEmergencyRegistration[].class, new IdentitywithEmergencyRegistrationImpl[] { new IdentitywithEmergencyRegistrationImpl(DiameterCxDxAvpCodes.IDENTITY_WITH_EMERGENCY_REGISTRATION, DiameterCxDxAvpCodes.CXDX_VENDOR_ID, 0, 1,
                dummyAvpBytes) });
	}
}
