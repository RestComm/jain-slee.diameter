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

package org.mobicents.slee.resource.diameter.gx.tests.factories;

import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.cca.events.avp.CreditControlAVPCodes;
import net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp;
import net.java.slee.resource.diameter.cca.events.avp.UserEquipmentInfoAvp;
import net.java.slee.resource.diameter.gx.events.avp.ChargingRuleInstall;
import net.java.slee.resource.diameter.gx.events.avp.ChargingRuleRemove;
import net.java.slee.resource.diameter.gx.events.avp.TFTPacketFilterInformation;

import org.mobicents.slee.resource.diameter.base.events.avp.DiameterAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.SubscriptionIdAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.UserEquipmentInfoAvpImpl;
import org.mobicents.slee.resource.diameter.gx.events.avp.ChargingRuleInstallImpl;
import org.mobicents.slee.resource.diameter.gx.events.avp.ChargingRuleRemoveImpl;
import org.mobicents.slee.resource.diameter.gx.events.avp.DiameterGxAvpCodes;
import org.mobicents.slee.resource.diameter.gx.events.avp.TFTPacketFilterInformationImpl;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class GxAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

	public static GxAvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new GxAvpAssistant();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected GxAvpAssistant() throws Exception {
		super();

		// CCA RA

		typeValues.put(SubscriptionIdAvp.class, new SubscriptionIdAvpImpl(CreditControlAVPCodes.Subscription_Id, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(SubscriptionIdAvp[].class, new SubscriptionIdAvpImpl[] { new SubscriptionIdAvpImpl(CreditControlAVPCodes.Subscription_Id, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(UserEquipmentInfoAvp.class, new UserEquipmentInfoAvpImpl(CreditControlAVPCodes.User_Equipment_Info, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(UserEquipmentInfoAvp[].class,
				new UserEquipmentInfoAvpImpl[] { new UserEquipmentInfoAvpImpl(CreditControlAVPCodes.User_Equipment_Info, 0L, 0, 1, dummyAvpBytes) });

		// Gx AVP Factory

		typeValues.put(TFTPacketFilterInformation.class, new TFTPacketFilterInformationImpl(DiameterGxAvpCodes.TFT_PACKET_FILTER_INFORMATION, DiameterGxAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(TFTPacketFilterInformation[].class, new TFTPacketFilterInformationImpl[] { new TFTPacketFilterInformationImpl(DiameterGxAvpCodes.TFT_PACKET_FILTER_INFORMATION,
				DiameterGxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(ChargingRuleRemove.class, new ChargingRuleRemoveImpl(DiameterGxAvpCodes.CHARGING_RULE_REMOVE, DiameterGxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(ChargingRuleRemove[].class, new ChargingRuleRemoveImpl[] { new ChargingRuleRemoveImpl(DiameterGxAvpCodes.CHARGING_RULE_REMOVE,
				DiameterGxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(ChargingRuleInstall.class, new ChargingRuleInstallImpl(DiameterGxAvpCodes.CHARGING_RULE_INSTALL, DiameterGxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(ChargingRuleInstall[].class, new ChargingRuleInstallImpl[] { new ChargingRuleInstallImpl(DiameterGxAvpCodes.CHARGING_RULE_INSTALL,
				DiameterGxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.gx.events.avp.ChargingInformation.class, new org.mobicents.slee.resource.diameter.gx.events.avp.ChargingInformationImpl(
				DiameterGxAvpCodes.CHARGING_INFORMATION, DiameterGxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.gx.events.avp.ChargingInformation[].class,
				new org.mobicents.slee.resource.diameter.gx.events.avp.ChargingInformationImpl[] { new org.mobicents.slee.resource.diameter.gx.events.avp.ChargingInformationImpl(
						DiameterGxAvpCodes.CHARGING_INFORMATION, DiameterGxAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(DiameterAvp.class, new DiameterAvpImpl(0, 0, 0, 1, dummyAvpBytes, null));
		typeValues.put(DiameterAvp[].class, new DiameterAvpImpl[] { new DiameterAvpImpl(0, 0, 0, 1, dummyAvpBytes, null) });

	}

}
