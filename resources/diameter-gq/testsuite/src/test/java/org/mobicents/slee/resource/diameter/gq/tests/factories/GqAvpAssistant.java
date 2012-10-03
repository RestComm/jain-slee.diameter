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

package org.mobicents.slee.resource.diameter.gq.tests.factories;

import net.java.slee.resource.diameter.gq.events.avp.BindingInformation;
import net.java.slee.resource.diameter.gq.events.avp.BindingInputList;
import net.java.slee.resource.diameter.gq.events.avp.BindingOutputList;
import net.java.slee.resource.diameter.gq.events.avp.FlowGrouping;
import net.java.slee.resource.diameter.gq.events.avp.Flows;
import net.java.slee.resource.diameter.gq.events.avp.GloballyUniqueAddress;
import net.java.slee.resource.diameter.gq.events.avp.MediaComponentDescription;
import net.java.slee.resource.diameter.gq.events.avp.MediaSubComponent;
import net.java.slee.resource.diameter.gq.events.avp.V4TransportAddress;
import net.java.slee.resource.diameter.gq.events.avp.V6TransportAddress;

import org.mobicents.slee.resource.diameter.gq.events.avp.BindingInformationImpl;
import org.mobicents.slee.resource.diameter.gq.events.avp.BindingInputListImpl;
import org.mobicents.slee.resource.diameter.gq.events.avp.BindingOutputListImpl;
import org.mobicents.slee.resource.diameter.gq.events.avp.DiameterGqAvpCodes;
import org.mobicents.slee.resource.diameter.gq.events.avp.FlowGroupingImpl;
import org.mobicents.slee.resource.diameter.gq.events.avp.FlowsImpl;
import org.mobicents.slee.resource.diameter.gq.events.avp.GloballyUniqueAddressImpl;
import org.mobicents.slee.resource.diameter.gq.events.avp.MediaComponentDescriptionImpl;
import org.mobicents.slee.resource.diameter.gq.events.avp.MediaSubComponentImpl;
import org.mobicents.slee.resource.diameter.gq.events.avp.V4TransportAddressImpl;
import org.mobicents.slee.resource.diameter.gq.events.avp.V6TransportAddressImpl;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class GqAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

	public static GqAvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new GqAvpAssistant();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected GqAvpAssistant() throws Exception {
		super();

		// Gq AVP Factory

		typeValues.put(BindingInformation.class, new BindingInformationImpl(DiameterGqAvpCodes.ETSI_BINDING_INFORMATION, DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(BindingInformation[].class, new BindingInformationImpl[] { new BindingInformationImpl(DiameterGqAvpCodes.ETSI_BINDING_INFORMATION,
				DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(BindingInputList.class, new BindingInputListImpl(DiameterGqAvpCodes.ETSI_BINDING_INPUT_LIST, DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(BindingInputList[].class, new BindingInputListImpl[] { new BindingInputListImpl(DiameterGqAvpCodes.ETSI_BINDING_INPUT_LIST, DiameterGqAvpCodes.ETSI_VENDOR_ID,
				0, 1, dummyAvpBytes) });

		typeValues.put(BindingOutputList.class, new BindingOutputListImpl(DiameterGqAvpCodes.ETSI_BINDING_OUTPUT_LIST, DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(BindingOutputList[].class, new BindingOutputListImpl[] { new BindingOutputListImpl(DiameterGqAvpCodes.ETSI_BINDING_OUTPUT_LIST,
				DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(FlowGrouping.class, new FlowGroupingImpl(DiameterGqAvpCodes.TGPP_FLOW_GROUPING, DiameterGqAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(FlowGrouping[].class, new FlowGroupingImpl[] { new FlowGroupingImpl(DiameterGqAvpCodes.TGPP_FLOW_GROUPING, DiameterGqAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(Flows.class, new FlowsImpl(DiameterGqAvpCodes.TGPP_FLOWS, DiameterGqAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(Flows[].class, new FlowsImpl[] { new FlowsImpl(DiameterGqAvpCodes.TGPP_FLOWS, DiameterGqAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(GloballyUniqueAddress.class, new GloballyUniqueAddressImpl(DiameterGqAvpCodes.ETSI_GLOBALLY_UNIQUE_ADDRESS, DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(GloballyUniqueAddress[].class, new GloballyUniqueAddressImpl[] { new GloballyUniqueAddressImpl(DiameterGqAvpCodes.ETSI_GLOBALLY_UNIQUE_ADDRESS,
				DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(MediaComponentDescription.class, new MediaComponentDescriptionImpl(DiameterGqAvpCodes.TGPP_MEDIA_COMPONENT_DESCRIPTION, DiameterGqAvpCodes.TGPP_VENDOR_ID, 0, 1,
				dummyAvpBytes));
		typeValues.put(MediaComponentDescription[].class, new MediaComponentDescriptionImpl[] { new MediaComponentDescriptionImpl(DiameterGqAvpCodes.TGPP_MEDIA_COMPONENT_DESCRIPTION,
				DiameterGqAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(MediaSubComponent.class, new MediaSubComponentImpl(DiameterGqAvpCodes.TGPP_MEDIA_SUB_COMPONENT, DiameterGqAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(MediaSubComponent[].class, new MediaSubComponentImpl[] { new MediaSubComponentImpl(DiameterGqAvpCodes.TGPP_MEDIA_SUB_COMPONENT,
				DiameterGqAvpCodes.TGPP_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(V4TransportAddress.class, new V4TransportAddressImpl(DiameterGqAvpCodes.ETSI_V4_TRANSPORT_ADDRESS, DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(V4TransportAddress[].class, new V4TransportAddressImpl[] { new V4TransportAddressImpl(DiameterGqAvpCodes.ETSI_V4_TRANSPORT_ADDRESS,
				DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes) });

		typeValues.put(V6TransportAddress.class, new V6TransportAddressImpl(DiameterGqAvpCodes.ETSI_V6_TRANSPORT_ADDRESS, DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(V6TransportAddress[].class, new V6TransportAddressImpl[] { new V6TransportAddressImpl(DiameterGqAvpCodes.ETSI_V6_TRANSPORT_ADDRESS,
				DiameterGqAvpCodes.ETSI_VENDOR_ID, 0, 1, dummyAvpBytes) });

	}

}
