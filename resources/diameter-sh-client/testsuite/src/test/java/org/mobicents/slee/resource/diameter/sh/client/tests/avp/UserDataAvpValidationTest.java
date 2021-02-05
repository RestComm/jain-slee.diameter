/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat, Inc. and/or its affiliates, and individual
 * contributors as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a full listing
 * of individual contributors.
 * 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU General Public License, v. 2.0.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License,
 * v. 2.0 along with this distribution; if not, write to the Free 
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */
package org.mobicents.slee.resource.diameter.sh.client.tests.avp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.sh.DiameterShAvpFactoryImpl;

/**
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class UserDataAvpValidationTest {

	private DiameterShAvpFactoryImpl shAvpFactory = null;

	@Before
	public void setUp() {
		//FIXME: add more init for other tests later.
		this.shAvpFactory = new DiameterShAvpFactoryImpl(new DiameterAvpFactoryImpl());
	}

	@After
	public void tearDown() {
		this.shAvpFactory = null;
	}

	@Test
	public void testUserDataAvpValidation() {
		byte[] userData = null;

		// we must fail, since it's null
		assertFalse("Test result passed for null reference, it should have failed.", shAvpFactory.validateUserData(userData));

		// now it's just empty, should fail
		userData = new byte[256];

		assertFalse("Test result passed for empty data, it should have failed.", shAvpFactory.validateUserData(userData));

		userData = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<Sh-Data xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
					"<IWillFail></IWillFail>" +
				"</Sh-Data>").getBytes();

		assertFalse("Test result passed for data not following schema, it should have failed.", shAvpFactory.validateUserData(userData));

		userData=("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<Sh-Data\n" +
				"\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
				"\t<PublicIdentifiers>\n" +
				"\t\t<IMSPublicIdentity>sip:john.doe@hp.com</IMSPublicIdentity>\n" +
				"\t\t<MSISDN>59899077937</MSISDN>\n" +
				"\t\t<Extension>\n" +
				"\t\t\t<IdentityType>2</IdentityType>\n" +
				"\t\t\t<WildcardedPSI>http://www.jainsleediameter.com</WildcardedPSI>\n" +
				"\t\t\t<Extension>\n" +
				"\t\t\t\t<WildcardedIMPU>http://www.jain-slee.diameter.com</WildcardedIMPU>\n" +
				"\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t<ExtendedMSISDN>\n" +
				"\t\t\t\t\t\t<MSISDN>59899077938</MSISDN>\n" +
				"\t\t\t\t\t\t<MSISDNType>1</MSISDNType>\n" +
				"\t\t\t\t\t</ExtendedMSISDN>\n" +
				"\t\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t\t<EnhancedIMSPublicIdentifiers>\n" +
				"\t\t\t\t\t\t\t<IMSPublicIdentity>sip:john.doe2@hw.com</IMSPublicIdentity>\n" +
				"\t\t\t\t\t\t\t<IdentityType>0</IdentityType>\n" +
				"\t\t\t\t\t\t\t<Extension></Extension>\n" +
				"\t\t\t\t\t\t</EnhancedIMSPublicIdentifiers>\n" +
				"\t\t\t\t\t</Extension>\n" +
				"\t\t\t\t</Extension>\n" +
				"\t\t\t</Extension>\n" +
				"\t\t</Extension>\n" +
				"\t</PublicIdentifiers>\n" +
				"\t<Sh-IMS-Data>\n" +
				"\t\t<SCSCFName>sip:scsf@02.com</SCSCFName>\n" +
				"\t\t<IFCs>\n" +
				"\t\t\t<InitialFilterCriteria>\n" +
				"\t\t\t\t<Priority>0</Priority>\n" +
				"\t\t\t\t<TriggerPoint>\n" +
				"\t\t\t\t\t<ConditionTypeCNF>false</ConditionTypeCNF>\n" +
				"\t\t\t\t\t<SPT>\n" +
				"\t\t\t\t\t\t<ConditionNegated>false</ConditionNegated>\n" +
				"\t\t\t\t\t\t<Group>0</Group>\n" +
				"\t\t\t\t\t\t<SessionCase>1</SessionCase>\n" +
				"\t\t\t\t\t</SPT>\n" +
				"\t\t\t\t</TriggerPoint>\n" +
				"\t\t\t\t<ApplicationServer>\n" +
				"\t\t\t\t\t<ServerName>sip:scsf243@02.com</ServerName>\n" +
				"\t\t\t\t\t<DefaultHandling>0</DefaultHandling>\n" +
				"\t\t\t\t\t<ServiceInfo>service</ServiceInfo>\n" +
				"\t\t\t\t\t<Extension></Extension>\n" +
				"\t\t\t\t</ApplicationServer>\n" +
				"\t\t\t\t<ProfilePartIndicator>0</ProfilePartIndicator>\n" +
				"\t\t\t\t<Extension></Extension>\n" +
				"\t\t\t</InitialFilterCriteria>\n" +
				"\t\t</IFCs>\n" +
				"\t\t<IMSUserState>1</IMSUserState>\n" +
				"\t\t<ChargingInformation>\n" +
				"\t\t\t<PrimaryEventChargingFunctionName>aaa://ocs:8028</PrimaryEventChargingFunctionName>\n" +
				"\t\t\t<SecondaryEventChargingFunctionName>aaa://ocs:8031</SecondaryEventChargingFunctionName>\n" +
				"\t\t\t<PrimaryChargingCollectionFunctionName>aaa://ocf:9421</PrimaryChargingCollectionFunctionName>\n" +
				"\t\t\t<SecondaryChargingCollectionFunctionName>aaa://ocf:9425</SecondaryChargingCollectionFunctionName>\n" +
				"\t\t\t<Extension>\n" +
				"\t\t\t\t<PSIActivation>1</PSIActivation>\n" +
				"\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t<DSAI>\n" +
				"\t\t\t\t\t\t<DSAI-Tag>dsai</DSAI-Tag>\n" +
				"\t\t\t\t\t\t<DSAI-Value>0</DSAI-Value>\n" +
				"\t\t\t\t\t</DSAI>\n" +
				"\t\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t\t<ServiceLevelTraceInfo>0</ServiceLevelTraceInfo>\n" +
				"\t\t\t\t\t\t<IPv4Address>10.0.0.2</IPv4Address>\n" +
				"\t\t\t\t\t\t<IPv6Prefix>2001:db8:3c4d</IPv6Prefix>\n" +
				"\t\t\t\t\t\t<IPv6InterfaceIdentifier>02BBCCFFFEDD1122</IPv6InterfaceIdentifier>\n" +
				"\t\t\t\t\t\t<ServicePriorityLevel>1</ServicePriorityLevel>\n" +
				"\t\t\t\t\t\t<UEReachabilityForIP>\n" +
				"\t\t\t\t\t\t\t<UEIPReachabilityMME>0</UEIPReachabilityMME>\n" +
				"\t\t\t\t\t\t\t<Extension></Extension>\n" +
				"\t\t\t\t\t\t</UEReachabilityForIP>\n" +
				"\t\t\t\t\t\t<SMSRegistrationInfo>\n" +
				"\t\t\t\t\t\t\t<IP-SM-GW-Number>5989901019</IP-SM-GW-Number>\n" +
				"\t\t\t\t\t\t\t<Extension></Extension>\n" +
				"\t\t\t\t\t\t</SMSRegistrationInfo>\n" +
				"\t\t\t\t\t\t<Extension></Extension>\n" +
				"\t\t\t\t\t</Extension>\n" +
				"\t\t\t\t</Extension>\n" +
				"\t\t\t</Extension>\n" +
				"\t\t</ChargingInformation>\n" +
				"\t</Sh-IMS-Data>\n" +
				"\t<CSLocationInformation>\n" +
				"\t\t<LocationNumber>hJdlMCRFmQk=</LocationNumber>\n" +
				"\t\t<CellGlobalId>NzIBAAFOSg==</CellGlobalId>\n" +
				"\t\t<GeographicalInformation>EBu2ELlt9wA=</GeographicalInformation>\n" +
				"\t\t<GeodeticInformation>AxCiJcdOOq8ZAQ==</GeodeticInformation>\n" +
				"\t\t<VLRNumber>\n" +
				"\t\t\t<Address>NTk4OTc4OTM1==</Address>\n" +
				"\t\t</VLRNumber>\n" +
				"\t\t<MSCNumber>\n" +
				"\t\t\t<Address>NTk4OTc4OTM0==</Address>\n" +
				"\t\t</MSCNumber>\n" +
				"\t\t<CurrentLocationRetrieved>0</CurrentLocationRetrieved>\n" +
				"\t\t<AgeOfLocationInformation>0</AgeOfLocationInformation>\n" +
				"\t\t<Extension>\n" +
				"\t\t\t<UserCSGInformation>\n" +
				"\t\t\t\t<CSGId>ODE5MQ==</CSGId>\n" +
				"\t\t\t</UserCSGInformation>\n" +
				"\t\t\t<Extension>\n" +
				"\t\t\t\t<E-UTRANCellGlobalId>BfKRAk4nFQ==</E-UTRANCellGlobalId>\n" +
				"\t\t\t\t<TrackingAreaId>BfKRAwY=</TrackingAreaId>\n" +
				"\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t<LocalTimeZone>" +
				"\t\t\t\t\t\t<TimeZone>-3</TimeZone>\n" +
				"\t\t\t\t\t\t<DaylightSavingTime>0</DaylightSavingTime>\n" +
				"\t\t\t\t\t</LocalTimeZone>\n" +
				"\t\t\t\t</Extension>\n" +
				"\t\t\t</Extension>\n" +
				"\t\t</Extension>\n" +
				"\t</CSLocationInformation>\n" +
				"\t<PSLocationInformation>\n" +
				"\t\t<CellGlobalId>NzIBAAFOSg==</CellGlobalId>\n" +
				"\t\t<RoutingAreaId>R/gQOTUy</RoutingAreaId>\n" +
				"\t\t<GeographicalInformation>EKEgAU402RI=</GeographicalInformation>\n" +
				"\t\t<GeodeticInformation>AxCiJcdOOq8ZAP==</GeodeticInformation>\n" +
				"\t\t<SGSNNumber>\n" +
				"\t\t\t<Address>NTk4OTc4OTM2==</Address>\n" +
				"\t\t</SGSNNumber>\n" +
				"\t\t<CurrentLocationRetrieved>1</CurrentLocationRetrieved>\n" +
				"\t\t<AgeOfLocationInformation>5</AgeOfLocationInformation>\n" +
				"\t\t<Extension>\n" +
				"\t\t\t<UserCSGInformation>\n" +
				"\t\t\t\t<CSGId>ODE5MQ==</CSGId>\n" +
				"\t\t\t</UserCSGInformation>\n" +
				"\t\t\t<Extension>\n" +
				"\t\t\t\t<VisitedPLMNID>BfKRA=</VisitedPLMNID>\n" +
				"\t\t\t\t<LocalTimeZone>" +
				"\t\t\t\t\t<TimeZone>-3</TimeZone>\n" +
				"\t\t\t\t\t<DaylightSavingTime>0</DaylightSavingTime>\n" +
				"\t\t\t\t</LocalTimeZone>\n" +
				"\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t<RATtype>1004</RATtype>\n" +
				"\t\t\t\t</Extension>\n" +
				"\t\t\t</Extension>\n" +
				"\t\t</Extension>\n" +
				"\t</PSLocationInformation>\n" +
				"\t<Extension>\n" +
				"\t\t<Extension>\n" +
				"\t\t\t<Extension>\n" +
				"\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t<EPSUserState>4</EPSUserState>\n" +
				"\t\t\t\t\t<EPSLocationInformation>\n" +
				"\t\t\t\t\t\t<E-UTRANCellGlobalId>BfKRAk4nFQ==</E-UTRANCellGlobalId>\n" +
				"\t\t\t\t\t\t<TrackingAreaId>BfKRAwY=</TrackingAreaId>\n" +
				"\t\t\t\t\t\t<GeographicalInformation>EKEgAU402RI=</GeographicalInformation>\n" +
				"\t\t\t\t\t\t<GeodeticInformation>AxCiJcdOOq8ZAP==</GeodeticInformation>\n" +
				"\t\t\t\t\t\t<MMEName>MMEC18.MMEGI8001.MME.EPC.MNC019.MCC502.3GPPNETWORK.ORG</MMEName>\n" +
				"\t\t\t\t\t\t<CurrentLocationRetrieved>0</CurrentLocationRetrieved>\n" +
				"\t\t\t\t\t\t<AgeOfLocationInformation>0</AgeOfLocationInformation>\n" +
				"\t\t\t\t\t\t<UserCSGInformation>\n" +
				"\t\t\t\t\t\t\t<CSGId>ODE5MQ==</CSGId>\n" +
				"\t\t\t\t\t\t</UserCSGInformation>\n" +
				"\t\t\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t\t\t<VisitedPLMNID>951800</VisitedPLMNID>\n" +
				"\t\t\t\t\t\t\t<LocalTimeZone>" +
				"\t\t\t\t\t\t\t\t<TimeZone>-3</TimeZone>\n" +
				"\t\t\t\t\t\t\t\t<DaylightSavingTime>0</DaylightSavingTime>\n" +
				"\t\t\t\t\t\t\t</LocalTimeZone>\n" +
				"\t\t\t\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t\t\t\t<RATtype>1004</RATtype>\n" +
				"\t\t\t\t\t\t\t</Extension>\n" +
				"\t\t\t\t\t\t</Extension>\n" +
				"\t\t\t\t\t</EPSLocationInformation>\n" +
				"\t\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t\t\t<Extension>\n" +
				"\t\t\t\t\t\t\t\t<Sh-5GSLocationInformation>\n" +
				"\t\t\t\t\t\t\t\t\t<NRCellGlobalId>95180077395570</NRCellGlobalId>\n" +
				"\t\t\t\t\t\t\t\t\t<E-UTRANCellGlobalId>BfKRAk4nFQ==</E-UTRANCellGlobalId>\n" +
				"\t\t\t\t\t\t\t\t\t<TrackingAreaId>BfKRAwY=</TrackingAreaId>\n" +
				"\t\t\t\t\t\t\t\t\t<GeographicalInformation>EKEgAU402RI=</GeographicalInformation>\n" +
				"\t\t\t\t\t\t\t\t\t<AMFAddress>amf1.cluster1.net2.amf.5gc.mnc012.mcc345.3gppnetwork.org</AMFAddress>\n" +
				"\t\t\t\t\t\t\t\t\t<SMSFAddress>set12. smfset.5gc.mnc012.mcc345.3gppnetwork.org</SMSFAddress>\n" +
				"\t\t\t\t\t\t\t\t\t<CurrentLocationRetrieved>0</CurrentLocationRetrieved>\n" +
				"\t\t\t\t\t\t\t\t\t<AgeOfLocationInformation>0</AgeOfLocationInformation>\n" +
				"\t\t\t\t\t\t\t\t\t<VisitedPLMNID>951810</VisitedPLMNID>\n" +
				"\t\t\t\t\t\t\t\t\t<LocalTimeZone>" +
				"\t\t\t\t\t\t\t\t\t\t<TimeZone>-3</TimeZone>\n" +
				"\t\t\t\t\t\t\t\t\t\t<DaylightSavingTime>0</DaylightSavingTime>\n" +
				"\t\t\t\t\t\t\t\t\t</LocalTimeZone>\n" +
				"\t\t\t\t\t\t\t\t\t<RATtype>1006</RATtype>\n" +
				"\t\t\t\t\t\t\t\t</Sh-5GSLocationInformation>\n" +
				"\t\t\t\t\t\t\t</Extension>\n" +
				"\t\t\t\t\t\t</Extension>\n" +
				"\t\t\t\t\t</Extension>\n" +
				"\t\t\t\t</Extension>\n" +
				"\t\t\t</Extension>\n" +
				"\t\t</Extension>\n" +
				"\t</Extension>\n" +
				"</Sh-Data>").getBytes();

		assertTrue("Test result failed for valid data, it should have passed.", shAvpFactory.validateUserData(userData));
	}
}
