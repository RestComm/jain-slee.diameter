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

package org.mobicents.slee.resource.diameter.cca.tests.factories;

import net.java.slee.resource.diameter.cca.events.avp.CcMoneyAvp;
import net.java.slee.resource.diameter.cca.events.avp.CostInformationAvp;
import net.java.slee.resource.diameter.cca.events.avp.CreditControlAVPCodes;
import net.java.slee.resource.diameter.cca.events.avp.FinalUnitIndicationAvp;
import net.java.slee.resource.diameter.cca.events.avp.GSUPoolReferenceAvp;
import net.java.slee.resource.diameter.cca.events.avp.GrantedServiceUnitAvp;
import net.java.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvp;
import net.java.slee.resource.diameter.cca.events.avp.RedirectServerAvp;
import net.java.slee.resource.diameter.cca.events.avp.RequestedServiceUnitAvp;
import net.java.slee.resource.diameter.cca.events.avp.ServiceParameterInfoAvp;
import net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp;
import net.java.slee.resource.diameter.cca.events.avp.UnitValueAvp;
import net.java.slee.resource.diameter.cca.events.avp.UsedServiceUnitAvp;
import net.java.slee.resource.diameter.cca.events.avp.UserEquipmentInfoAvp;

import org.mobicents.slee.resource.diameter.cca.events.avp.CcMoneyAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.CostInformationAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.FinalUnitIndicationAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.GSUPoolReferenceAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.GrantedServiceUnitAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.RedirectServerAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.RequestedServiceUnitAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.ServiceParameterInfoAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.SubscriptionIdAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.UnitValueAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.UsedServiceUnitAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.UserEquipmentInfoAvpImpl;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class CCAAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

	public static CCAAvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new CCAAvpAssistant();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected CCAAvpAssistant() throws Exception {
		super();

		// CCA RA

		typeValues.put(CostInformationAvp.class, new CostInformationAvpImpl(CreditControlAVPCodes.Cost_Information, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(CostInformationAvp[].class, new CostInformationAvpImpl[] { new CostInformationAvpImpl(CreditControlAVPCodes.Cost_Information, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(FinalUnitIndicationAvp.class, new FinalUnitIndicationAvpImpl(CreditControlAVPCodes.Final_Unit_Indication, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(FinalUnitIndicationAvp[].class, new FinalUnitIndicationAvpImpl[] { new FinalUnitIndicationAvpImpl(CreditControlAVPCodes.Final_Unit_Indication, 0L, 0, 1,
				dummyAvpBytes) });

		typeValues.put(GrantedServiceUnitAvp.class, new GrantedServiceUnitAvpImpl(CreditControlAVPCodes.Granted_Service_Unit, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(GrantedServiceUnitAvp[].class, new GrantedServiceUnitAvpImpl[] { new GrantedServiceUnitAvpImpl(CreditControlAVPCodes.Granted_Service_Unit, 0L, 0, 1,
				dummyAvpBytes) });

		typeValues.put(MultipleServicesCreditControlAvp.class,
				new MultipleServicesCreditControlAvpImpl(CreditControlAVPCodes.Multiple_Services_Credit_Control, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(MultipleServicesCreditControlAvp[].class, new MultipleServicesCreditControlAvpImpl[] { new MultipleServicesCreditControlAvpImpl(
				CreditControlAVPCodes.Multiple_Services_Credit_Control, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(RequestedServiceUnitAvp.class, new RequestedServiceUnitAvpImpl(CreditControlAVPCodes.Requested_Service_Unit, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(RequestedServiceUnitAvp[].class, new RequestedServiceUnitAvpImpl[] { new RequestedServiceUnitAvpImpl(CreditControlAVPCodes.Requested_Service_Unit, 0L, 0, 1,
				dummyAvpBytes) });

		typeValues.put(ServiceParameterInfoAvp.class, new ServiceParameterInfoAvpImpl(CreditControlAVPCodes.Service_Parameter_Info, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(ServiceParameterInfoAvp[].class, new ServiceParameterInfoAvpImpl[] { new ServiceParameterInfoAvpImpl(CreditControlAVPCodes.Service_Parameter_Info, 0L, 0, 1,
				dummyAvpBytes) });

		typeValues.put(SubscriptionIdAvp.class, new SubscriptionIdAvpImpl(CreditControlAVPCodes.Subscription_Id, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(SubscriptionIdAvp[].class, new SubscriptionIdAvpImpl[] { new SubscriptionIdAvpImpl(CreditControlAVPCodes.Subscription_Id, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(UserEquipmentInfoAvp.class, new UserEquipmentInfoAvpImpl(CreditControlAVPCodes.User_Equipment_Info, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(UserEquipmentInfoAvp[].class,
				new UserEquipmentInfoAvpImpl[] { new UserEquipmentInfoAvpImpl(CreditControlAVPCodes.User_Equipment_Info, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(UsedServiceUnitAvp.class, new UsedServiceUnitAvpImpl(CreditControlAVPCodes.Used_Service_Unit, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(UsedServiceUnitAvp[].class, new UsedServiceUnitAvpImpl[] { new UsedServiceUnitAvpImpl(CreditControlAVPCodes.Used_Service_Unit, 0L, 0, 1, dummyAvpBytes) });

		// CCA AVP Factory

		typeValues.put(CcMoneyAvp.class, new CcMoneyAvpImpl(CreditControlAVPCodes.CC_Money, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(CcMoneyAvp[].class, new CcMoneyAvpImpl[] { new CcMoneyAvpImpl(CreditControlAVPCodes.CC_Money, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(GSUPoolReferenceAvp.class, new GSUPoolReferenceAvpImpl(CreditControlAVPCodes.G_S_U_Pool_Reference, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(GSUPoolReferenceAvp[].class, new GSUPoolReferenceAvpImpl[] { new GSUPoolReferenceAvpImpl(CreditControlAVPCodes.G_S_U_Pool_Reference, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(RedirectServerAvp.class, new RedirectServerAvpImpl(CreditControlAVPCodes.Redirect_Server, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(RedirectServerAvp[].class, new RedirectServerAvpImpl[] { new RedirectServerAvpImpl(CreditControlAVPCodes.Redirect_Server, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(UnitValueAvp.class, new UnitValueAvpImpl(CreditControlAVPCodes.Unit_Value, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(UnitValueAvp[].class, new UnitValueAvpImpl[] { new UnitValueAvpImpl(CreditControlAVPCodes.Unit_Value, 0L, 0, 1, dummyAvpBytes) });

	}

}
