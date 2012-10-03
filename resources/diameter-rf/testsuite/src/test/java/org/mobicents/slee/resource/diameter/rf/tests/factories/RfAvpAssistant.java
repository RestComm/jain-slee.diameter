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

package org.mobicents.slee.resource.diameter.rf.tests.factories;

import org.mobicents.slee.resource.diameter.rf.events.avp.DiameterRfAvpCodes;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class RfAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

	public static RfAvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new RfAvpAssistant();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected RfAvpAssistant() throws Exception {
		super();

		// Rf AVP Factory

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.ApplicationServerInformation.class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.ApplicationServerInformationImpl(DiameterRfAvpCodes.APPLICATION_SERVER_INFORMATION,
						DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues
				.put(
						net.java.slee.resource.diameter.rf.events.avp.ApplicationServerInformation[].class,
						new org.mobicents.slee.resource.diameter.rf.events.avp.ApplicationServerInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.ApplicationServerInformationImpl(
								DiameterRfAvpCodes.APPLICATION_SERVER_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.EventType.class, new org.mobicents.slee.resource.diameter.rf.events.avp.EventTypeImpl(
				DiameterRfAvpCodes.EVENT_TYPE, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.EventType[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.EventTypeImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.EventTypeImpl(
						DiameterRfAvpCodes.EVENT_TYPE, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.InterOperatorIdentifier.class, new org.mobicents.slee.resource.diameter.rf.events.avp.InterOperatorIdentifierImpl(
				DiameterRfAvpCodes.INTER_OPERATOR_IDENTIFIER, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.InterOperatorIdentifier[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.InterOperatorIdentifierImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.InterOperatorIdentifierImpl(
						DiameterRfAvpCodes.INTER_OPERATOR_IDENTIFIER, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MessageBody.class, new org.mobicents.slee.resource.diameter.rf.events.avp.MessageBodyImpl(
				DiameterRfAvpCodes.MESSAGE_BODY, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MessageBody[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.MessageBodyImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.MessageBodyImpl(
						DiameterRfAvpCodes.MESSAGE_BODY, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.SdpMediaComponent.class, new org.mobicents.slee.resource.diameter.rf.events.avp.SdpMediaComponentImpl(
				DiameterRfAvpCodes.SDP_MEDIA_COMPONENT, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.SdpMediaComponent[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.SdpMediaComponentImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.SdpMediaComponentImpl(
						DiameterRfAvpCodes.SDP_MEDIA_COMPONENT, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.TimeStamps.class, new org.mobicents.slee.resource.diameter.rf.events.avp.TimeStampsImpl(
				DiameterRfAvpCodes.TIME_STAMPS, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.TimeStamps[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.TimeStampsImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.TimeStampsImpl(
						DiameterRfAvpCodes.TIME_STAMPS, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.TrunkGroupId.class, new org.mobicents.slee.resource.diameter.rf.events.avp.TrunkGroupIdImpl(
				DiameterRfAvpCodes.TRUNK_GROUP_ID, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.TrunkGroupId[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.TrunkGroupIdImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.TrunkGroupIdImpl(
						DiameterRfAvpCodes.TRUNK_GROUP_ID, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LcsClientName.class, new org.mobicents.slee.resource.diameter.rf.events.avp.LcsClientNameImpl(
				DiameterRfAvpCodes.LCS_CLIENT_NAME, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LcsClientName[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.LcsClientNameImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.LcsClientNameImpl(
						DiameterRfAvpCodes.LCS_CLIENT_NAME, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LcsRequestorId.class, new org.mobicents.slee.resource.diameter.rf.events.avp.LcsRequestorIdImpl(
				DiameterRfAvpCodes.LCS_REQUESTOR_ID, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LcsRequestorId[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.LcsRequestorIdImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.LcsRequestorIdImpl(
						DiameterRfAvpCodes.LCS_REQUESTOR_ID, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LcsClientId.class, new org.mobicents.slee.resource.diameter.rf.events.avp.LcsClientIdImpl(
				DiameterRfAvpCodes.LCS_CLIENT_ID, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LcsClientId[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.LcsClientIdImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.LcsClientIdImpl(
						DiameterRfAvpCodes.LCS_CLIENT_ID, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LocationType.class, new org.mobicents.slee.resource.diameter.rf.events.avp.LocationTypeImpl(
				DiameterRfAvpCodes.LOCATION_TYPE, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LocationType[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.LocationTypeImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.LocationTypeImpl(
						DiameterRfAvpCodes.LOCATION_TYPE, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.AdditionalContentInformation.class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.AdditionalContentInformationImpl(DiameterRfAvpCodes.ADDITIONAL_CONTENT_INFORMATION,
						DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues
				.put(
						net.java.slee.resource.diameter.rf.events.avp.AdditionalContentInformation[].class,
						new org.mobicents.slee.resource.diameter.rf.events.avp.AdditionalContentInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.AdditionalContentInformationImpl(
								DiameterRfAvpCodes.ADDITIONAL_CONTENT_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MessageClass.class, new org.mobicents.slee.resource.diameter.rf.events.avp.MessageClassImpl(
				DiameterRfAvpCodes.MESSAGE_CLASS, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MessageClass[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.MessageClassImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.MessageClassImpl(
						DiameterRfAvpCodes.MESSAGE_CLASS, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MmContentType.class, new org.mobicents.slee.resource.diameter.rf.events.avp.MmContentTypeImpl(
				DiameterRfAvpCodes.MM_CONTENT_TYPE, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MmContentType[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.MmContentTypeImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.MmContentTypeImpl(
						DiameterRfAvpCodes.MM_CONTENT_TYPE, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.OriginatorAddress.class, new org.mobicents.slee.resource.diameter.rf.events.avp.OriginatorAddressImpl(
				DiameterRfAvpCodes.ORIGINATOR_ADDRESS, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.OriginatorAddress[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.OriginatorAddressImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.OriginatorAddressImpl(
						DiameterRfAvpCodes.ORIGINATOR_ADDRESS, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.RecipientAddress.class, new org.mobicents.slee.resource.diameter.rf.events.avp.RecipientAddressImpl(
				DiameterRfAvpCodes.ORIGINATOR_ADDRESS, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.RecipientAddress[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.RecipientAddressImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.RecipientAddressImpl(
						DiameterRfAvpCodes.ORIGINATOR_ADDRESS, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.AddressDomain.class, new org.mobicents.slee.resource.diameter.rf.events.avp.AddressDomainImpl(
				DiameterRfAvpCodes.ADDRESS_DOMAIN, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.AddressDomain[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.AddressDomainImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.AddressDomainImpl(
						DiameterRfAvpCodes.ADDRESS_DOMAIN, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.TalkBurstExchange.class, new org.mobicents.slee.resource.diameter.rf.events.avp.TalkBurstExchangeImpl(
				DiameterRfAvpCodes.TALK_BURST_EXCHANGE, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.TalkBurstExchange[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.TalkBurstExchangeImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.TalkBurstExchangeImpl(
						DiameterRfAvpCodes.TALK_BURST_EXCHANGE, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.PsFurnishChargingInformation.class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.PsFurnishChargingInformationImpl(DiameterRfAvpCodes.PS_FURNISH_CHARGING_INFORMATION,
						DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues
				.put(
						net.java.slee.resource.diameter.rf.events.avp.PsFurnishChargingInformation[].class,
						new org.mobicents.slee.resource.diameter.rf.events.avp.PsFurnishChargingInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.PsFurnishChargingInformationImpl(
								DiameterRfAvpCodes.PS_FURNISH_CHARGING_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.ImsInformation.class, new org.mobicents.slee.resource.diameter.rf.events.avp.ImsInformationImpl(
				DiameterRfAvpCodes.IMS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.ImsInformation[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.ImsInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.ImsInformationImpl(
						DiameterRfAvpCodes.IMS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LcsInformation.class, new org.mobicents.slee.resource.diameter.rf.events.avp.LcsInformationImpl(
				DiameterRfAvpCodes.LCS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.LcsInformation[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.LcsInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.LcsInformationImpl(
						DiameterRfAvpCodes.LCS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MbmsInformation.class, new org.mobicents.slee.resource.diameter.rf.events.avp.MbmsInformationImpl(
				DiameterRfAvpCodes.MBMS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MbmsInformation[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.MbmsInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.MbmsInformationImpl(
						DiameterRfAvpCodes.MBMS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MmsInformation.class, new org.mobicents.slee.resource.diameter.rf.events.avp.MmsInformationImpl(
				DiameterRfAvpCodes.MMS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.MmsInformation[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.MmsInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.MmsInformationImpl(
						DiameterRfAvpCodes.MMS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.PocInformation.class, new org.mobicents.slee.resource.diameter.rf.events.avp.PocInformationImpl(
				DiameterRfAvpCodes.POC_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.PocInformation[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.PocInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.PocInformationImpl(
						DiameterRfAvpCodes.POC_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.PsInformation.class, new org.mobicents.slee.resource.diameter.rf.events.avp.PsInformationImpl(
				DiameterRfAvpCodes.PS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.PsInformation[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.PsInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.PsInformationImpl(
						DiameterRfAvpCodes.PS_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.WlanInformation.class, new org.mobicents.slee.resource.diameter.rf.events.avp.WlanInformationImpl(
				DiameterRfAvpCodes.WLAN_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.WlanInformation[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.WlanInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.WlanInformationImpl(
						DiameterRfAvpCodes.WLAN_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.WlanRadioContainer.class, new org.mobicents.slee.resource.diameter.rf.events.avp.WlanRadioContainerImpl(
				DiameterRfAvpCodes.WLAN_RADIO_CONTAINER, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.WlanRadioContainer[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.WlanRadioContainerImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.WlanRadioContainerImpl(
						DiameterRfAvpCodes.WLAN_RADIO_CONTAINER, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities.class, new org.mobicents.slee.resource.diameter.rf.events.avp.ServerCapabilitiesImpl(
				DiameterRfAvpCodes.SERVER_CAPABILITIES, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.ServerCapabilitiesImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.ServerCapabilitiesImpl(
						DiameterRfAvpCodes.SERVER_CAPABILITIES, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.ServiceInformation.class, new org.mobicents.slee.resource.diameter.rf.events.avp.ServiceInformationImpl(
				DiameterRfAvpCodes.SERVICE_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(net.java.slee.resource.diameter.rf.events.avp.ServiceInformation[].class,
				new org.mobicents.slee.resource.diameter.rf.events.avp.ServiceInformationImpl[] { new org.mobicents.slee.resource.diameter.rf.events.avp.ServiceInformationImpl(
						DiameterRfAvpCodes.SERVICE_INFORMATION, DiameterRfAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

	}

}
