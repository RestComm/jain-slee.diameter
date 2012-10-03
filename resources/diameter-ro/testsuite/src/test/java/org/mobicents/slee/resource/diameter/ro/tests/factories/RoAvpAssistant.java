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

package org.mobicents.slee.resource.diameter.ro.tests.factories;

import net.java.slee.resource.diameter.cca.events.avp.CostInformationAvp;
import net.java.slee.resource.diameter.cca.events.avp.CreditControlAVPCodes;
import net.java.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvp;
import net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp;
import net.java.slee.resource.diameter.cca.events.avp.UserEquipmentInfoAvp;
import net.java.slee.resource.diameter.ro.events.avp.AdditionalContentInformation;
import net.java.slee.resource.diameter.ro.events.avp.AddressDomain;
import net.java.slee.resource.diameter.ro.events.avp.ApplicationServerInformation;
import net.java.slee.resource.diameter.ro.events.avp.EventType;
import net.java.slee.resource.diameter.ro.events.avp.ImsInformation;
import net.java.slee.resource.diameter.ro.events.avp.InterOperatorIdentifier;
import net.java.slee.resource.diameter.ro.events.avp.LcsClientId;
import net.java.slee.resource.diameter.ro.events.avp.LcsClientName;
import net.java.slee.resource.diameter.ro.events.avp.LcsInformation;
import net.java.slee.resource.diameter.ro.events.avp.LcsRequestorId;
import net.java.slee.resource.diameter.ro.events.avp.LocationType;
import net.java.slee.resource.diameter.ro.events.avp.MbmsInformation;
import net.java.slee.resource.diameter.ro.events.avp.MessageBody;
import net.java.slee.resource.diameter.ro.events.avp.MessageClass;
import net.java.slee.resource.diameter.ro.events.avp.MmContentType;
import net.java.slee.resource.diameter.ro.events.avp.MmsInformation;
import net.java.slee.resource.diameter.ro.events.avp.OriginatorAddress;
import net.java.slee.resource.diameter.ro.events.avp.PocInformation;
import net.java.slee.resource.diameter.ro.events.avp.PsFurnishChargingInformation;
import net.java.slee.resource.diameter.ro.events.avp.PsInformation;
import net.java.slee.resource.diameter.ro.events.avp.RecipientAddress;
import net.java.slee.resource.diameter.ro.events.avp.SdpMediaComponent;
import net.java.slee.resource.diameter.ro.events.avp.ServerCapabilities;
import net.java.slee.resource.diameter.ro.events.avp.ServiceInformation;
import net.java.slee.resource.diameter.ro.events.avp.TalkBurstExchange;
import net.java.slee.resource.diameter.ro.events.avp.TimeStamps;
import net.java.slee.resource.diameter.ro.events.avp.TrunkGroupId;
import net.java.slee.resource.diameter.ro.events.avp.WlanInformation;
import net.java.slee.resource.diameter.ro.events.avp.WlanRadioContainer;

import org.mobicents.slee.resource.diameter.cca.events.avp.CostInformationAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.SubscriptionIdAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.UserEquipmentInfoAvpImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.AdditionalContentInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.AddressDomainImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.ApplicationServerInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.DiameterRoAvpCodes;
import org.mobicents.slee.resource.diameter.ro.events.avp.EventTypeImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.ImsInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.InterOperatorIdentifierImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.LcsClientIdImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.LcsClientNameImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.LcsInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.LcsRequestorIdImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.LocationTypeImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.MbmsInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.MessageBodyImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.MessageClassImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.MmContentTypeImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.MmsInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.OriginatorAddressImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.PocInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.PsFurnishChargingInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.PsInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.RecipientAddressImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.SdpMediaComponentImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.ServerCapabilitiesImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.ServiceInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.TalkBurstExchangeImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.TimeStampsImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.TrunkGroupIdImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.WlanInformationImpl;
import org.mobicents.slee.resource.diameter.ro.events.avp.WlanRadioContainerImpl;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class RoAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

	public static RoAvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new RoAvpAssistant();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected RoAvpAssistant() throws Exception {
		super();

		// CCA RA

		typeValues.put(CostInformationAvp.class, new CostInformationAvpImpl(CreditControlAVPCodes.Cost_Information, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(CostInformationAvp[].class, new CostInformationAvpImpl[] { new CostInformationAvpImpl(CreditControlAVPCodes.Cost_Information, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(MultipleServicesCreditControlAvp.class,
				new MultipleServicesCreditControlAvpImpl(CreditControlAVPCodes.Multiple_Services_Credit_Control, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(MultipleServicesCreditControlAvp[].class, new MultipleServicesCreditControlAvpImpl[] { new MultipleServicesCreditControlAvpImpl(
				CreditControlAVPCodes.Multiple_Services_Credit_Control, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(SubscriptionIdAvp.class, new SubscriptionIdAvpImpl(CreditControlAVPCodes.Subscription_Id, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(SubscriptionIdAvp[].class, new SubscriptionIdAvpImpl[] { new SubscriptionIdAvpImpl(CreditControlAVPCodes.Subscription_Id, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(UserEquipmentInfoAvp.class, new UserEquipmentInfoAvpImpl(CreditControlAVPCodes.User_Equipment_Info, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(UserEquipmentInfoAvp[].class,
				new UserEquipmentInfoAvpImpl[] { new UserEquipmentInfoAvpImpl(CreditControlAVPCodes.User_Equipment_Info, 0L, 0, 1, dummyAvpBytes) });

		// Ro AVP Factory

		typeValues.put(ApplicationServerInformation.class, new ApplicationServerInformationImpl(DiameterRoAvpCodes.APPLICATION_SERVER_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID,
				0, 1, dummyAvpBytes));
		typeValues.put(ApplicationServerInformation[].class, new ApplicationServerInformationImpl[] { new ApplicationServerInformationImpl(
				DiameterRoAvpCodes.APPLICATION_SERVER_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(EventType.class, new EventTypeImpl(DiameterRoAvpCodes.EVENT_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(EventType[].class, new EventTypeImpl[] { new EventTypeImpl(DiameterRoAvpCodes.EVENT_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(InterOperatorIdentifier.class, new InterOperatorIdentifierImpl(DiameterRoAvpCodes.INTER_OPERATOR_IDENTIFIER, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(InterOperatorIdentifier[].class, new InterOperatorIdentifierImpl[] { new InterOperatorIdentifierImpl(DiameterRoAvpCodes.INTER_OPERATOR_IDENTIFIER,
				DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(MessageBody.class, new MessageBodyImpl(DiameterRoAvpCodes.MESSAGE_BODY, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(MessageBody[].class, new MessageBodyImpl[] { new MessageBodyImpl(DiameterRoAvpCodes.MESSAGE_BODY, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(SdpMediaComponent.class, new SdpMediaComponentImpl(DiameterRoAvpCodes.SDP_MEDIA_COMPONENT, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(SdpMediaComponent[].class, new SdpMediaComponentImpl[] { new SdpMediaComponentImpl(DiameterRoAvpCodes.SDP_MEDIA_COMPONENT, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0,
				1, dummyAvpBytes) });

		typeValues.put(TimeStamps.class, new TimeStampsImpl(DiameterRoAvpCodes.TIME_STAMPS, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(TimeStamps[].class, new TimeStampsImpl[] { new TimeStampsImpl(DiameterRoAvpCodes.TIME_STAMPS, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(TrunkGroupId.class, new TrunkGroupIdImpl(DiameterRoAvpCodes.TRUNK_GROUP_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues
				.put(TrunkGroupId[].class, new TrunkGroupIdImpl[] { new TrunkGroupIdImpl(DiameterRoAvpCodes.TRUNK_GROUP_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(LcsClientName.class, new LcsClientNameImpl(DiameterRoAvpCodes.LCS_CLIENT_NAME, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(LcsClientName[].class, new LcsClientNameImpl[] { new LcsClientNameImpl(DiameterRoAvpCodes.LCS_CLIENT_NAME, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(LcsRequestorId.class, new LcsRequestorIdImpl(DiameterRoAvpCodes.LCS_REQUESTOR_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(LcsRequestorId[].class, new LcsRequestorIdImpl[] { new LcsRequestorIdImpl(DiameterRoAvpCodes.LCS_REQUESTOR_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(LcsClientId.class, new LcsClientIdImpl(DiameterRoAvpCodes.LCS_CLIENT_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(LcsClientId[].class, new LcsClientIdImpl[] { new LcsClientIdImpl(DiameterRoAvpCodes.LCS_CLIENT_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(LocationType.class, new LocationTypeImpl(DiameterRoAvpCodes.LOCATION_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(LocationType[].class, new LocationTypeImpl[] { new LocationTypeImpl(DiameterRoAvpCodes.LOCATION_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(AdditionalContentInformation.class, new AdditionalContentInformationImpl(DiameterRoAvpCodes.ADDITIONAL_CONTENT_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID,
				0, 1, dummyAvpBytes));
		typeValues.put(AdditionalContentInformation[].class, new AdditionalContentInformationImpl[] { new AdditionalContentInformationImpl(
				DiameterRoAvpCodes.ADDITIONAL_CONTENT_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(MessageClass.class, new MessageClassImpl(DiameterRoAvpCodes.MESSAGE_CLASS, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(MessageClass[].class, new MessageClassImpl[] { new MessageClassImpl(DiameterRoAvpCodes.MESSAGE_CLASS, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(MmContentType.class, new MmContentTypeImpl(DiameterRoAvpCodes.MM_CONTENT_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(MmContentType[].class, new MmContentTypeImpl[] { new MmContentTypeImpl(DiameterRoAvpCodes.MM_CONTENT_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(OriginatorAddress.class, new OriginatorAddressImpl(DiameterRoAvpCodes.ORIGINATOR_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(OriginatorAddress[].class, new OriginatorAddressImpl[] { new OriginatorAddressImpl(DiameterRoAvpCodes.ORIGINATOR_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0,
				1, dummyAvpBytes) });

		typeValues.put(RecipientAddress.class, new RecipientAddressImpl(DiameterRoAvpCodes.ORIGINATOR_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(RecipientAddress[].class, new RecipientAddressImpl[] { new RecipientAddressImpl(DiameterRoAvpCodes.ORIGINATOR_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(AddressDomain.class, new AddressDomainImpl(DiameterRoAvpCodes.ADDRESS_DOMAIN, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(AddressDomain[].class,
				new AddressDomainImpl[] { new AddressDomainImpl(DiameterRoAvpCodes.ADDRESS_DOMAIN, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(TalkBurstExchange.class, new TalkBurstExchangeImpl(DiameterRoAvpCodes.TALK_BURST_EXCHANGE, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(TalkBurstExchange[].class, new TalkBurstExchangeImpl[] { new TalkBurstExchangeImpl(DiameterRoAvpCodes.TALK_BURST_EXCHANGE, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0,
				1, dummyAvpBytes) });

		typeValues.put(PsFurnishChargingInformation.class, new PsFurnishChargingInformationImpl(DiameterRoAvpCodes.PS_FURNISH_CHARGING_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID,
				0, 1, dummyAvpBytes));
		typeValues.put(PsFurnishChargingInformation[].class, new PsFurnishChargingInformationImpl[] { new PsFurnishChargingInformationImpl(
				DiameterRoAvpCodes.PS_FURNISH_CHARGING_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(ImsInformation.class, new ImsInformationImpl(DiameterRoAvpCodes.IMS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(ImsInformation[].class, new ImsInformationImpl[] { new ImsInformationImpl(DiameterRoAvpCodes.IMS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(LcsInformation.class, new LcsInformationImpl(DiameterRoAvpCodes.LCS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(LcsInformation[].class, new LcsInformationImpl[] { new LcsInformationImpl(DiameterRoAvpCodes.LCS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(MbmsInformation.class, new MbmsInformationImpl(DiameterRoAvpCodes.MBMS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(MbmsInformation[].class, new MbmsInformationImpl[] { new MbmsInformationImpl(DiameterRoAvpCodes.MBMS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(MmsInformation.class, new MmsInformationImpl(DiameterRoAvpCodes.MMS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(MmsInformation[].class, new MmsInformationImpl[] { new MmsInformationImpl(DiameterRoAvpCodes.MMS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(PocInformation.class, new PocInformationImpl(DiameterRoAvpCodes.POC_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(PocInformation[].class, new PocInformationImpl[] { new PocInformationImpl(DiameterRoAvpCodes.POC_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(PsInformation.class, new PsInformationImpl(DiameterRoAvpCodes.PS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(PsInformation[].class,
				new PsInformationImpl[] { new PsInformationImpl(DiameterRoAvpCodes.PS_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(WlanInformation.class, new WlanInformationImpl(DiameterRoAvpCodes.WLAN_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(WlanInformation[].class, new WlanInformationImpl[] { new WlanInformationImpl(DiameterRoAvpCodes.WLAN_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(WlanRadioContainer.class, new WlanRadioContainerImpl(DiameterRoAvpCodes.WLAN_RADIO_CONTAINER, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(WlanRadioContainer[].class, new WlanRadioContainerImpl[] { new WlanRadioContainerImpl(DiameterRoAvpCodes.WLAN_RADIO_CONTAINER,
				DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(ServerCapabilities.class, new ServerCapabilitiesImpl(DiameterRoAvpCodes.SERVER_CAPABILITIES, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(ServerCapabilities[].class, new ServerCapabilitiesImpl[] { new ServerCapabilitiesImpl(DiameterRoAvpCodes.SERVER_CAPABILITIES, DiameterRoAvpCodes.TGPP_VENDOR_ID,
				0, 1, dummyAvpBytes) });

		typeValues.put(ServiceInformation.class, new ServiceInformationImpl(DiameterRoAvpCodes.SERVICE_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(ServiceInformation[].class, new ServiceInformationImpl[] { new ServiceInformationImpl(DiameterRoAvpCodes.SERVICE_INFORMATION, DiameterRoAvpCodes.TGPP_VENDOR_ID,
				0, 1, dummyAvpBytes) });

	}

}
