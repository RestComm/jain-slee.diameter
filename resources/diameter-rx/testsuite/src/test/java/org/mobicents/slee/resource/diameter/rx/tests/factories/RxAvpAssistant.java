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

package org.mobicents.slee.resource.diameter.rx.tests.factories;

import net.java.slee.resource.diameter.cca.events.avp.CreditControlAVPCodes;
import net.java.slee.resource.diameter.cca.events.avp.GrantedServiceUnitAvp;
import net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp;
import net.java.slee.resource.diameter.cca.events.avp.UsedServiceUnitAvp;
import net.java.slee.resource.diameter.rx.events.avp.AcceptableServiceInfoAvp;
import net.java.slee.resource.diameter.rx.events.avp.AccessNetworkChargingIdentifierAvp;
import net.java.slee.resource.diameter.rx.events.avp.FlowsAvp;
import net.java.slee.resource.diameter.rx.events.avp.MediaComponentDescriptionAvp;
import net.java.slee.resource.diameter.rx.events.avp.MediaSubComponentAvp;
import net.java.slee.resource.diameter.rx.events.avp.SponsoredConnectivityDataAvp;

import org.mobicents.slee.resource.diameter.cca.events.avp.GrantedServiceUnitAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.SubscriptionIdAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.UsedServiceUnitAvpImpl;
import org.mobicents.slee.resource.diameter.rx.events.avp.AcceptableServiceInfoAvpImpl;
import org.mobicents.slee.resource.diameter.rx.events.avp.AccessNetworkChargingIdentifierAvpImpl;
import org.mobicents.slee.resource.diameter.rx.events.avp.DiameterRxAvpCodes;
import org.mobicents.slee.resource.diameter.rx.events.avp.FlowsAvpImpl;
import org.mobicents.slee.resource.diameter.rx.events.avp.MediaComponentDescriptionAvpImpl;
import org.mobicents.slee.resource.diameter.rx.events.avp.MediaSubComponentAvpImpl;
import org.mobicents.slee.resource.diameter.rx.events.avp.SponsoredConnectivityDataAvpImpl;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class RxAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

	public static RxAvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new RxAvpAssistant();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected RxAvpAssistant() throws Exception {
		super();

		typeValues.put(GrantedServiceUnitAvp.class, new GrantedServiceUnitAvpImpl(CreditControlAVPCodes.Granted_Service_Unit, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(GrantedServiceUnitAvp[].class, new GrantedServiceUnitAvpImpl[] { new GrantedServiceUnitAvpImpl(CreditControlAVPCodes.Granted_Service_Unit, 0L, 0, 1,
				dummyAvpBytes) });

		typeValues.put(UsedServiceUnitAvp.class, new UsedServiceUnitAvpImpl(CreditControlAVPCodes.Used_Service_Unit, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(UsedServiceUnitAvp[].class, new UsedServiceUnitAvpImpl[] { new UsedServiceUnitAvpImpl(CreditControlAVPCodes.Used_Service_Unit, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(SubscriptionIdAvp.class, new SubscriptionIdAvpImpl(CreditControlAVPCodes.Subscription_Id, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(SubscriptionIdAvp[].class, new SubscriptionIdAvpImpl[] { new SubscriptionIdAvpImpl(CreditControlAVPCodes.Subscription_Id, 0L, 0, 1, dummyAvpBytes) });

		// Rx AVP Factory : avps are doubled from Gq... but with AVP suffix... damn

		typeValues.put(AcceptableServiceInfoAvp.class, new AcceptableServiceInfoAvpImpl(DiameterRxAvpCodes.ACCEPTABLE_SERVICE_INFO, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(AcceptableServiceInfoAvp[].class, new AcceptableServiceInfoAvpImpl[] {
				new AcceptableServiceInfoAvpImpl(DiameterRxAvpCodes.ACCEPTABLE_SERVICE_INFO, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes),
				new AcceptableServiceInfoAvpImpl(DiameterRxAvpCodes.ACCEPTABLE_SERVICE_INFO, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(AccessNetworkChargingIdentifierAvp.class, new AccessNetworkChargingIdentifierAvpImpl(DiameterRxAvpCodes.ACCESS_NETWORK_CHARGING_IDENTIFIER,
				DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(AccessNetworkChargingIdentifierAvp[].class, new AccessNetworkChargingIdentifierAvpImpl[] {
				new AccessNetworkChargingIdentifierAvpImpl(DiameterRxAvpCodes.ACCESS_NETWORK_CHARGING_IDENTIFIER, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes),
				new AccessNetworkChargingIdentifierAvpImpl(DiameterRxAvpCodes.ACCESS_NETWORK_CHARGING_IDENTIFIER, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(FlowsAvp.class, new FlowsAvpImpl(DiameterRxAvpCodes.FLOWS, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(FlowsAvp[].class, new FlowsAvpImpl[] { new FlowsAvpImpl(DiameterRxAvpCodes.FLOWS, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes),
				new FlowsAvpImpl(DiameterRxAvpCodes.FLOWS, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(MediaComponentDescriptionAvp.class, new MediaComponentDescriptionAvpImpl(DiameterRxAvpCodes.MEDIA_COMPONENT_DESCRIPTION, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0,
				1, dummyAvpBytes));
		typeValues.put(MediaComponentDescriptionAvp[].class, new MediaComponentDescriptionAvpImpl[] {
				new MediaComponentDescriptionAvpImpl(DiameterRxAvpCodes.MEDIA_COMPONENT_DESCRIPTION, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes),
				new MediaComponentDescriptionAvpImpl(DiameterRxAvpCodes.MEDIA_COMPONENT_DESCRIPTION, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(MediaSubComponentAvp.class, new MediaSubComponentAvpImpl(DiameterRxAvpCodes.MEDIA_SUBCOMPONENT, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(MediaSubComponentAvp[].class, new MediaSubComponentAvpImpl[] {
				new MediaSubComponentAvpImpl(DiameterRxAvpCodes.MEDIA_SUBCOMPONENT, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes),
				new MediaSubComponentAvpImpl(DiameterRxAvpCodes.MEDIA_SUBCOMPONENT, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(SponsoredConnectivityDataAvp.class, new SponsoredConnectivityDataAvpImpl(DiameterRxAvpCodes.SPONSORED_CONNECTIVITY_DATA, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0,
				1, dummyAvpBytes));
		typeValues.put(SponsoredConnectivityDataAvp[].class, new SponsoredConnectivityDataAvpImpl[] {
				new SponsoredConnectivityDataAvpImpl(DiameterRxAvpCodes.SPONSORED_CONNECTIVITY_DATA, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes),
				new SponsoredConnectivityDataAvpImpl(DiameterRxAvpCodes.SPONSORED_CONNECTIVITY_DATA, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rx.events.avp.SupportedFeaturesAvp.class, new org.mobicents.slee.resource.diameter.rx.events.avp.SupportedFeaturesAvpImpl(
				DiameterRxAvpCodes.SUPPORTED_FEATURES, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rx.events.avp.SupportedFeaturesAvp[].class, new org.mobicents.slee.resource.diameter.rx.events.avp.SupportedFeaturesAvpImpl[] {
				new org.mobicents.slee.resource.diameter.rx.events.avp.SupportedFeaturesAvpImpl(DiameterRxAvpCodes.SUPPORTED_FEATURES, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1,
						dummyAvpBytes),
				new org.mobicents.slee.resource.diameter.rx.events.avp.SupportedFeaturesAvpImpl(DiameterRxAvpCodes.SUPPORTED_FEATURES, DiameterRxAvpCodes.TGPP_VENDOR_ID, 0, 1,
						dummyAvpBytes) });

	}

}
