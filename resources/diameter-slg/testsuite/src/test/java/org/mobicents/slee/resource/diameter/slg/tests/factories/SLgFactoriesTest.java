/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2018, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */

package org.mobicents.slee.resource.diameter.slg.tests.factories;

import static org.junit.Assert.*;

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.AddressType;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slg.SLgAVPFactory;
import net.java.slee.resource.diameter.slg.SLgMessageFactory;

import net.java.slee.resource.diameter.slg.events.ProvideLocationRequest;
import net.java.slee.resource.diameter.slg.events.ProvideLocationAnswer;
import net.java.slee.resource.diameter.slg.events.LocationReportRequest;
import net.java.slee.resource.diameter.slg.events.LocationReportAnswer;
import net.java.slee.resource.diameter.slg.events.avp.AdditionalAreaAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaDefinitionAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.DeferredMTLRDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.ELPAVPCodes;
import net.java.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSFormatIndicator;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheck;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckNonSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSClass;
import net.java.slee.resource.diameter.slg.events.avp.LCSRequestorNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.MotionEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.OccurrenceInfo;
import net.java.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.PeriodicLocationSupportIndicator;
import net.java.slee.resource.diameter.slg.events.avp.PLMNIDListAvp;
import net.java.slee.resource.diameter.slg.events.avp.PrioritizedListIndicator;
import net.java.slee.resource.diameter.slg.events.avp.PseudonymIndicator;
import net.java.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvp;
import net.java.slee.resource.diameter.slg.events.avp.ResponseTime;
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.slg.events.avp.SLgLocationType;
import net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp;
import net.java.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.VelocityRequested;
import net.java.slee.resource.diameter.slg.events.avp.VerticalRequested;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.Stack;
import org.jdiameter.api.slg.ClientSLgSession;
import org.jdiameter.api.slg.ServerSLgSession;
import org.jdiameter.common.impl.app.slg.SLgSessionFactoryImpl;
import org.junit.Test;
import org.mobicents.diameter.dictionary.AvpDictionary;
import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.tests.factories.BaseFactoriesTest;
import org.mobicents.slee.resource.diameter.base.tests.factories.BaseFactoriesTest.MyConfiguration;
import org.mobicents.slee.resource.diameter.slg.SLgAVPFactoryImpl;
import org.mobicents.slee.resource.diameter.slg.SLgClientSessionActivityImpl;
import org.mobicents.slee.resource.diameter.slg.SLgMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.slg.SLgServerSessionActivityImpl;
import org.mobicents.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvpImpl;

/**
 * Test class for JAIN SLEE Diameter SLg RA Message and AVP Factories
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonça </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class SLgFactoriesTest {

  private static SLgMessageFactory slgMessageFactory;
  private static SLgAVPFactory slgAvpFactory;
  private static SLgServerSessionActivityImpl sLgServerSessionActivity;
  private static SLgClientSessionActivityImpl sLgClientSessionActivity;

  private static Stack stack;

  static {
    stack = new org.jdiameter.client.impl.StackImpl();
    try {
      stack.init(new MyConfiguration());
    }
    catch (Exception e) {
      throw new RuntimeException("Failed to initialize the stack.");
    }

    slgAvpFactory = new SLgAVPFactoryImpl(new DiameterAvpFactoryImpl());

    try {
      slgMessageFactory = new SLgMessageFactoryImpl(stack);

      SLgSessionFactoryImpl sf = new SLgSessionFactoryImpl(stack.getSessionFactory());
      ApplicationId slgAppId = ApplicationId.createByAuthAppId(ELPAVPCodes.SLg_VENDOR_ID, ELPAVPCodes.SLg_AUTH_APP_ID);
      org.jdiameter.server.impl.app.slg.SLgServerSessionImpl stackServerSession = (org.jdiameter.server.impl.app.slg.SLgServerSessionImpl) sf.getNewSession("123",
          ServerSLgSession.class, slgAppId, new Object[0]);
      org.jdiameter.client.impl.app.slg.SLgClientSessionImpl stackClientSession = (org.jdiameter.client.impl.app.slg.SLgClientSessionImpl) sf.getNewSession("321",
          ClientSLgSession.class, slgAppId, new Object[0]);
      sLgServerSessionActivity = new SLgServerSessionActivityImpl(slgMessageFactory, slgAvpFactory, stackServerSession, stackServerSession, null, null, stack);
      sLgClientSessionActivity = new SLgClientSessionActivityImpl(slgMessageFactory, slgAvpFactory, stackClientSession, stackClientSession, null, null, stack);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    try {
      AvpDictionary.INSTANCE.parseDictionary(SLgFactoriesTest.class.getClassLoader().getResourceAsStream("dictionary.xml"));
    }
    catch (Exception e) {
      throw new RuntimeException("Failed to parse dictionary file.");
    }
  }

  // *********************************************//
  // *** Provide-Location-Request (PLR) Tests ***//
  // ********************************************//

  @Test
  public void isRequestPLR() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    assertTrue("Request Flag in LCS Provide-Location-Request is not set.", plr.getHeader().isRequest());
  }

  @Test
  public void isProxiablePLR() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    assertTrue("The 'P' bit is not set by default in LCS Provide-Location-Request it should.", plr.getHeader().isProxiable());
  }

  @Test
  public void testGroupedChildAVPsPLR() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    LCSEPSClientNameAvp lcsEpsClientNameAvp = slgAvpFactory.createLCSEPSClientName();
    LCSRequestorNameAvp lcsRequestorNameAvp = slgAvpFactory.createLCSRequestorName();
    LCSQoSAvp lcsQoSAvp = slgAvpFactory.createLCSQoS();
    LCSPrivacyCheckNonSessionAvp lcsPrivacyCheckNonSessionAvp =slgAvpFactory.createLCSPrivacyCheckNonSession();
    LCSPrivacyCheckSessionAvp lcsPrivacyCheckSessionAvp = slgAvpFactory.createLCSPrivacyCheckSession();
    AreaEventInfoAvp areaEventInfoAvp = slgAvpFactory.createAreaEventInfo();
    AreaDefinitionAvp areaDefinitionAvp = slgAvpFactory.createAreaDefinition();
    AreaAvp areaAvp = slgAvpFactory.createArea();
    AdditionalAreaAvp additionalAreaAvp = slgAvpFactory.createAdditionalArea();
    PeriodicLDRInfoAvp periodicLDRInfoAvp = slgAvpFactory.createPeriodicLDRInformation();
    ReportingPLMNListAvp reportingPLMNListAvp = slgAvpFactory.createReportingPLMNList();
    PLMNIDListAvp plmnIdListAvp = slgAvpFactory.createPLMNIDList();
    MotionEventInfoAvp motionEventInfoAvp = slgAvpFactory.createMotionEventInfo();

    /** LCS-EPS-Client-Name **/
    // LCS-Name-String
    String lcsNameString = "Restcomm Geolocation API";
    lcsEpsClientNameAvp.setLCSNameString(lcsNameString);
    // LCS-Format-Indicator
    LCSFormatIndicator lcsFormatIndicator = null;
    int lcsFormatInd = LCSFormatIndicator._MSISDN;
    lcsFormatIndicator = lcsFormatIndicator.fromInt(lcsFormatInd);
    lcsEpsClientNameAvp.setLCSFormatIndicator(lcsFormatIndicator);
    // Add LCS-EPS-Client-Name Grouped AVP to Provide-Location-Request
    plr.setLCSEPSClientName(lcsEpsClientNameAvp);

    /** LCS-Requestor-Name **/
    // LCS-Requestor-Id-String
    String lcsRequestorIdString = "restcomm_geolocation_23";
    lcsRequestorNameAvp.setLCSRequestorIDString(lcsRequestorIdString);
    // LCS-Format-Indicator
    int reqLcsFormatInd = LCSFormatIndicator._LOGICAL_NAME;
    lcsFormatIndicator = lcsFormatIndicator.fromInt(reqLcsFormatInd);
    lcsRequestorNameAvp.setLCSFormatIndicator(lcsFormatIndicator);
    // Add LCS-Requestor-Name Grouped AVP to Provide-Location-Request
    plr.setLCSRequestorName(lcsRequestorNameAvp);

    /** LCS-QoS **/
    // LCS-QoS-Class
    LCSQoSClass lcsQoSClass = null;
    int lcsQoSClassValue = LCSQoSClass._BEST_EFFORT;
    lcsQoSClass = lcsQoSClass.fromInt(lcsQoSClassValue);
    lcsQoSAvp.setLCSQoSClass(lcsQoSClass);
    // Horizontal-Accuracy
    long horizontalAccuracy = 120L;
    lcsQoSAvp.setHorizontalAccuracy(horizontalAccuracy);
    // Vertical-Accuracy
    long verticalAccuracy = 3237L;
    lcsQoSAvp.setVerticalAccuracy(verticalAccuracy);
    // Vertical-Requested
    VerticalRequested verticalRequested = null;
    int verticalRequestedValue = VerticalRequested._VERTICAL_COORDINATE_IS_REQUESTED;
    verticalRequested = verticalRequested.fromInt(verticalRequestedValue);
    lcsQoSAvp.setVerticalRequested(verticalRequested);
    // Response-Time
    ResponseTime responseTime = null;
    int responseTimeValue = ResponseTime._DELAY_TOLERANT;
    responseTime = responseTime.fromInt(responseTimeValue);
    lcsQoSAvp.setResponseTime(responseTime);
    // Add LCS-QoS Grouped AVP to Provide-Location-Request
    plr.setLCSQoS(lcsQoSAvp);

    /** LCS-Privacy-Check-Non-Session **/
    // LCS-Privacy-Check
    LCSPrivacyCheck lcsPrivacyCheck = null;
    int lcsPrivacyCheckNonSValue = LCSPrivacyCheck._ALLOWED_WITH_NOTIFICATION;
    lcsPrivacyCheck = lcsPrivacyCheck.fromInt(lcsPrivacyCheckNonSValue);
    lcsPrivacyCheckNonSessionAvp.setLCSPrivacyCheck(lcsPrivacyCheck);
    // Add LCS-Privacy-Check-Non-Session Grouped AVP to Provide-Location-Request
    plr.setLCSPrivacyCheckNonSession(lcsPrivacyCheckNonSessionAvp);

    /** LCS-Privacy-Check-Session **/
    // LCS-Privacy-Check
    int lcsPrivacyCheckValue = LCSPrivacyCheck._RESTRICTED_IF_NO_RESPONSE;
    lcsPrivacyCheck = lcsPrivacyCheck.fromInt(lcsPrivacyCheckValue);
    lcsPrivacyCheckSessionAvp.setLCSPrivacyCheck(lcsPrivacyCheck);
    // Add LCS-Privacy-Check-Session Grouped AVP to Provide-Location-Request
    plr.setLCSPrivacyCheckSession(lcsPrivacyCheckSessionAvp);

    /** Area-Event-Info **/
    // Area
    long areaType = 2L;
    String areaIdStr = "Area51";
    byte[] areaIdentification = areaIdStr.getBytes();
    areaAvp.setAreaType(areaType);
    areaAvp.setAreaIdentification(areaIdentification);
    // AdditionalArea
    long addAreaType = 3L;
    String addAreaIdStr = "Area52";
    byte[] addAreaIdentification = addAreaIdStr.getBytes();
    additionalAreaAvp.setAreaType(addAreaType);
    additionalAreaAvp.setAreaIdentification(addAreaIdentification);
    // Area-Definition
    areaDefinitionAvp.setArea(areaAvp);
    areaDefinitionAvp.setAdditionalArea(additionalAreaAvp);
    // Area-Event-Info
    int occInfo = OccurrenceInfo._ONE_TIME_EVENT;
    OccurrenceInfo occurrenceInfo = OccurrenceInfo.fromInt(occInfo);
    long intervalTime = 180L;
    long samplingInterval = 30L;
    long maximumInterval = 1800L;
    long reportingDuration = 36000L;
    long reportingLocationRequirements = 5L;
    areaEventInfoAvp.setAreaDefinition(areaDefinitionAvp);
    areaEventInfoAvp.setOccurrenceInfo(occurrenceInfo);
    areaEventInfoAvp.setIntervalTime(intervalTime);
    areaEventInfoAvp.setMaximumInterval(maximumInterval);
    areaEventInfoAvp.setSamplingInterval(samplingInterval);
    areaEventInfoAvp.setReportDuration(reportingDuration);
    areaEventInfoAvp.setReportingLocationRequirements(reportingLocationRequirements);
    // Add Area-Event-Info Grouped AVP to Provide-Location-Request
    plr.setAreaEventInfo(areaEventInfoAvp);

    /** Periodic-LDR-Info **/
    // Reporting-Amount
    long reportingAmount = 1L;
    periodicLDRInfoAvp.setReportingAmount(reportingAmount);
    // Reporting-Interval
    long reportingInterval = 8639999L;
    periodicLDRInfoAvp.setReportingInterval(reportingInterval);
    // Add Periodic-LDR-Info Grouped AVP to Provide-Location-Request
    plr.setPeriodicLDRInformation(periodicLDRInfoAvp);

    /** Reporting-PLMN-List **/
    // PLMN-ID-List
    String visitedPLMNIdListString = "222";
    byte[] visitedPLMNIdList = visitedPLMNIdListString.getBytes();
    plmnIdListAvp.setVisitedPLMNId(visitedPLMNIdList);
    // Periodic-Location-Support-Indicator
    PeriodicLocationSupportIndicator periodicLocationSupportIndicator = PeriodicLocationSupportIndicator.SUPPORTED;
    plmnIdListAvp.setPeriodicLocationSupportIndicator(periodicLocationSupportIndicator);
    reportingPLMNListAvp.setPLMNIDList(plmnIdListAvp);
    // Prioritized-List-Indicator
    PrioritizedListIndicator prioritizedListIndicator = PrioritizedListIndicator.PRIORITIZED;
    reportingPLMNListAvp.setPrioritizedListIndicator(prioritizedListIndicator);
    // Add Reporting-PLMN-List Grouped AVP to Provide-Location-Request
    plr.setReportingPLMNList(reportingPLMNListAvp);

    /** Motion-Event-Info **/
    // Linear-Distance
    long linearDistance = 300L;
    OccurrenceInfo occurrenceInfoME = OccurrenceInfo.MULTIPLE_TIME_EVENT;
    long intervalTimeME = 800L;
    long maximumIntervalME = 1900L;
    long samplingIntervalME = 60L;
    long reportingDurationME = 36000L;
    long reportingLocationRequirementsME = 25L;
    motionEventInfoAvp.setLinearDistance(linearDistance);
    motionEventInfoAvp.setOccurrenceInfo(occurrenceInfoME);
    motionEventInfoAvp.setIntervalTime(intervalTimeME);
    motionEventInfoAvp.setMaximumInterval(maximumIntervalME);
    motionEventInfoAvp.setSamplingInterval(samplingIntervalME);
    motionEventInfoAvp.setReportDuration(reportingDurationME);
    motionEventInfoAvp.setReportingLocationRequirements(reportingLocationRequirementsME);
    // Add Motion-Event-Info Grouped AVP to Provide-Location-Request
    plr.setMotionEventInfo(motionEventInfoAvp);

  }

  @Test
  public void testGettersAndSettersPLR() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();

    int nFailures = SLgAvpAssistant.INSTANCE.testMethods(plr, ProvideLocationRequest.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }

  @Test
  public void testMessageFactoryApplicationIdChangePLR() throws Exception {
    long vendor = 10415L;
    ApplicationId originalAppId = ((SLgMessageFactoryImpl) slgMessageFactory).getApplicationId();

    boolean isAuth = originalAppId.getAuthAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;
    boolean isAcct = originalAppId.getAcctAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;

    boolean isVendor = originalAppId.getVendorId() != 0L;

    assertTrue("Invalid Application-Id (" + originalAppId + "). Should only, and at least, contain either Auth or Acct value.", (isAuth && !isAcct) || (!isAuth && isAcct));

    System.out.println("Default VENDOR-ID for SLg is " + originalAppId.getVendorId());
    // let's create a message and see how it comes...
    ProvideLocationRequest originalPLR = slgMessageFactory.createProvideLocationRequest();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, originalPLR);

    // now we switch..
    originalPLR = null;
    isVendor = !isVendor;
    ((SLgMessageFactoryImpl) slgMessageFactory).setApplicationId(isVendor ? vendor : 0L, isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());

    // create a new message and see how it comes...
    ProvideLocationRequest changedAIR = slgMessageFactory.createProvideLocationRequest();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, changedAIR);

    // revert back to default
    ((SLgMessageFactoryImpl) slgMessageFactory).setApplicationId(originalAppId.getVendorId(), isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());
  }

  // *********************************************//
  // ***  Provide-Location-Answer (PLA) Tests ***//
  // *******************************************//

  @Test
  public void isAnswerPLA() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    sLgServerSessionActivity.fetchSessionData(plr);
    ProvideLocationAnswer pla = sLgServerSessionActivity.createProvideLocationAnswer();

    assertFalse("Request Flag in Provide-Location-Answer is set.", pla.getHeader().isRequest());
  }

  @Test
  public void testGettersAndSettersPLA() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    sLgServerSessionActivity.fetchSessionData(plr);
    ProvideLocationAnswer pla = sLgServerSessionActivity.createProvideLocationAnswer();

    int nFailures = SLgAvpAssistant.INSTANCE.testMethods(pla, ProvideLocationAnswer.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }

  @Test
  public void testGroupedChildAVPsPLA() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    sLgServerSessionActivity.fetchSessionData(plr);
    ProvideLocationAnswer pla = sLgServerSessionActivity.createProvideLocationAnswer();
    GERANPositioningInfoAvp geranPositioningInfoAvp = slgAvpFactory.createGERANPositioningInfo();
    UTRANPositioningInfoAvp utranPositioningInfoAvp = slgAvpFactory.createUTRANPositioningInfo();
    ESMLCCellInfoAvp esmlcCellInfoAvp = slgAvpFactory.createESMLCCellInfo();
    ServingNodeAvp servingNodeAvp = slgAvpFactory.createServingNode();

    /** GERAN-Positioning-Info **/
    // GERAN-Positioning-Data
    String geranPosData = "42545339343342534333";
    byte[] geranPositioningData = geranPosData.getBytes();
    geranPositioningInfoAvp.setGERANPositioningData(geranPositioningData);
    // GERAN-GANSS-Positioning-Data
    String geranGanssPosData = "4254533733524E4331473433";
    byte[] geranGanssPositioningData = geranGanssPosData.getBytes();
    geranPositioningInfoAvp.setGERANGANSSPositioningData(geranGanssPositioningData);
    // Add GERAN-Positioning-Info AVP to Provide-Location-Answer
    pla.setGERANPositioningInfo(geranPositioningInfoAvp);

    /** UTRAN-Positioning-Info **/
    // UTRAN-Positioning-Data
    String utranPosData = "42545339343342534333";
    byte[] utranPositioningData = utranPosData.getBytes();
    utranPositioningInfoAvp.setUTRANPositioningData(utranPositioningData);
    // UTRAN-GANSS-Positioning-Data
    String utranGanssPosData = "4254533733524E4331473433";
    byte[] utranGanssPositioningData = utranGanssPosData.getBytes();
    utranPositioningInfoAvp.setUTRANGANSSPositioningData(utranGanssPositioningData);
    // UTRAN-Additional-Positioning-Data
    String utranAddPosData = "42545339343342534333";
    byte[] utranAdditionalPositioningData = utranAddPosData.getBytes();
    utranPositioningInfoAvp.setUTRANAdditionalPositioningData(utranAdditionalPositioningData);
    // Add UTRAN-Positioning-Info AVP to Provide-Location-Answer
    pla.setUTRANPositioningInfo(utranPositioningInfoAvp);

    /** ESMLC-Cell-Info **/
    // ECGI
    String ecgiStr = "654E4239343337";
    byte[] ecgi = ecgiStr.getBytes();
    esmlcCellInfoAvp.setECGI(ecgi);
    // Cell-Portion-ID
    long cellPortionId = 34923L;
    esmlcCellInfoAvp.setCellPortionID(cellPortionId);
    // Add ESMLC-Cell-Info Grouped AVP to Provide-Location-Answer
    pla.setESMLCCellInfo(esmlcCellInfoAvp);

    /** Serving-Node **/
    // SGSN-Number
    String sgsnNumberStr = "59899004501";
    byte[] sgsnNumber = sgsnNumberStr.getBytes();
    servingNodeAvp.setSGSNNumber(sgsnNumber);
    // SGSN-Name
    DiameterIdentity sgsnName = new DiameterIdentity("SGSN01");
    servingNodeAvp.setSGSNName(sgsnName);
    // SGSN-Realm
    DiameterIdentity sgsnRealm = new DiameterIdentity("sgsn.restcomm.com");
    servingNodeAvp.setSGSNRealm(sgsnRealm);
    // MME-Realm
    DiameterIdentity mmeRealm = new DiameterIdentity("mme.restcomm.com");
    servingNodeAvp.setMMERealm(mmeRealm);
    // MME-Name
    DiameterIdentity mmeName = new DiameterIdentity("MME710");
    servingNodeAvp.setMMEName(mmeName);
    // MSC-Number
    String mscNumberStr = "59899001207";
    byte[] mscNumber = mscNumberStr.getBytes();
    servingNodeAvp.setMSCNumber(mscNumber);
    // LCS-Capabilities-Set
    long lcsCapabilitiesSets = 99900123L;
    servingNodeAvp.setLcsCapabilitiesSets(lcsCapabilitiesSets);
    // 3GPP-AAA-Server-Name
    DiameterIdentity tgppAAAServerName = new DiameterIdentity("aaa.restcomm.com");
    servingNodeAvp.set3GPPAAAServerName(tgppAAAServerName);
    // GMLC-Address
    AddressType gmlcAddressType = AddressType.ADDRESS_IP;
    String gmlcAddressStr = "10.0.0.10";
    byte[] addGmlcAddressBytes = gmlcAddressStr.getBytes();
    Address gmlcAddress = new Address(gmlcAddressType, addGmlcAddressBytes);
    servingNodeAvp.setGMLCAddress(gmlcAddress);
    // Add Serving-Node Grouped AVP to Provide-Location-Answer
    pla.setServingNode(servingNodeAvp);

  }

  @Test
  public void hasDestinationHostPLA() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    sLgServerSessionActivity.fetchSessionData(plr);
    ProvideLocationAnswer pla = sLgServerSessionActivity.createProvideLocationAnswer();

    assertNull("The Destination-Host and Destination-Realm AVPs MUST NOT be present in the answer message. [RFC6733/6.2]", pla.getDestinationHost());
  }

  @Test
  public void hasDestinationRealmPLA() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    sLgServerSessionActivity.fetchSessionData(plr);
    ProvideLocationAnswer pla = sLgServerSessionActivity.createProvideLocationAnswer();

    assertNull("The Destination-Host and Destination-Realm AVPs MUST NOT be present in the answer message. [RFC6733/6.2]", pla.getDestinationRealm());
  }

  @Test
  public void isProxiableCopiedPLA() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    sLgServerSessionActivity.fetchSessionData(plr);
    ProvideLocationAnswer pla = sLgServerSessionActivity.createProvideLocationAnswer();
    assertEquals("The 'P' bit is not copied from request in LCS Provide-Location-Answer, it should. [RFC6733/6.2]", plr.getHeader().isProxiable(), pla.getHeader().isProxiable());

    // Reverse 'P' bit ...
    ((DiameterMessageImpl) plr).getGenericData().setProxiable(!plr.getHeader().isProxiable());
    assertTrue("The 'P' bit was not modified in LCS Provide-Location-Request, it should.", plr.getHeader().isProxiable() != pla.getHeader().isProxiable());
    sLgServerSessionActivity.fetchSessionData(plr);

    pla = sLgServerSessionActivity.createProvideLocationAnswer();
    assertEquals("The 'P' bit is not copied from request in LCS Provide-Location-Answer, it should. [RFC6733/6.2]", plr.getHeader().isProxiable(), pla.getHeader().isProxiable());
  }

  @Test
  public void hasTFlagSetPLA() throws Exception {
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    ((DiameterMessageImpl) plr).getGenericData().setReTransmitted(true);

    assertTrue("The 'T' flag should be set in LCS Provide-Location-Request", plr.getHeader().isPotentiallyRetransmitted());

    sLgServerSessionActivity.fetchSessionData(plr);
    ProvideLocationAnswer pla = sLgServerSessionActivity.createProvideLocationAnswer();
    assertFalse("The 'T' flag should not be set in LCS Provide-Location-Answer", pla.getHeader().isPotentiallyRetransmitted());
  }

  @Test
  public void testServerSessionApplicationIdChangePLA() throws Exception {
    long vendor = 10415L;
    ApplicationId originalAppId = ((SLgMessageFactoryImpl) slgMessageFactory).getApplicationId();

    boolean isAuth = originalAppId.getAuthAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;
    boolean isAcct = originalAppId.getAcctAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;

    boolean isVendor = originalAppId.getVendorId() != 0L;

    assertTrue("Invalid Application-Id (" + originalAppId + "). Should only, and at least, contain either Auth or Acct value.", (isAuth && !isAcct) || (!isAuth && isAcct));

    System.out.println("Default VENDOR-ID for SLg is " + originalAppId.getVendorId());
    // let's create a message and see how it comes...
    ProvideLocationRequest plr = slgMessageFactory.createProvideLocationRequest();
    sLgServerSessionActivity.fetchSessionData(plr);
    ProvideLocationAnswer originalPLA = sLgServerSessionActivity.createProvideLocationAnswer();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, originalPLA);

    // now we switch..
    originalPLA = null;
    isVendor = !isVendor;
    ((SLgMessageFactoryImpl) slgMessageFactory).setApplicationId(isVendor ? vendor : 0L, isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());

    // create a new message and see how it comes...
    ProvideLocationAnswer changedPLA = sLgServerSessionActivity.createProvideLocationAnswer();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, changedPLA);

    // revert back to default
    ((SLgMessageFactoryImpl) slgMessageFactory).setApplicationId(originalAppId.getVendorId(), isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());
  }

  // *********************************************//
  // *** Location-Report-Request (LRR) Tests *** //
  // *******************************************//

  @Test
  public void isRequestLRR() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    assertTrue("Request Flag in LCS Location-Report-Request is not set.", lrr.getHeader().isRequest());
  }

  @Test
  public void isProxiableLRR() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    assertTrue("The 'P' bit is not set by default in LCS Location-Report-Request it should.", lrr.getHeader().isProxiable());
  }

  @Test
  public void testGroupedChildAVPsLRR() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    DeferredMTLRDataAvp deferredMTLRDataAvp = slgAvpFactory.createDeferredMTLRData();
    DelayedLocationReportingDataAvp delayedLocationReportingDataAvp = slgAvpFactory.createDelayedLocationReportingData();
    LCSEPSClientNameAvp lcsEpsClientNameAvp = slgAvpFactory.createLCSEPSClientName();
    GERANPositioningInfoAvp geranPositioningInfoAvp = slgAvpFactory.createGERANPositioningInfo();
    UTRANPositioningInfoAvp utranPositioningInfoAvp = slgAvpFactory.createUTRANPositioningInfo();
    ServingNodeAvp servingNodeAvp = slgAvpFactory.createServingNode();
    PeriodicLDRInfoAvp periodicLDRInfoAvp = slgAvpFactory.createPeriodicLDRInformation();
    ESMLCCellInfoAvp esmlcCellInfoAvp = slgAvpFactory.createESMLCCellInfo();

    /** LCS-EPS-Client-Name **/
    // LCS-Name-String
    String lcsNameString = "Restcomm Geolocation API";
    lcsEpsClientNameAvp.setLCSNameString(lcsNameString);
    // LCS-Format-Indicator
    LCSFormatIndicator lcsFormatIndicator = null;
    int lcsFormatInd = LCSFormatIndicator._MSISDN;
    lcsFormatIndicator = lcsFormatIndicator.fromInt(lcsFormatInd);
    lcsEpsClientNameAvp.setLCSFormatIndicator(lcsFormatIndicator);
    // Add LCS-EPS-Client-Name Grouped AVP to Location-Report-Request
    lrr.setLCSEPSClientName(lcsEpsClientNameAvp);

    /** GERAN-Positioning-Info **/
    // GERAN-Positioning-Data
    String geranPosData = "42545339343342534333";
    byte[] geranPositioningData = geranPosData.getBytes();
    geranPositioningInfoAvp.setGERANPositioningData(geranPositioningData);
    // GERAN-GANSS-Positioning-Data
    String geranGanssPosData = "4254533733524E4331473433";
    byte[] geranGanssPositioningData = geranGanssPosData.getBytes();
    geranPositioningInfoAvp.setGERANGANSSPositioningData(geranGanssPositioningData);
    // Add GERAN-Positioning-Info AVP to Location-Report-Request
    lrr.setGERANPositioningInfo(geranPositioningInfoAvp);

    /** UTRAN-Positioning-Info **/
    // UTRAN-Positioning-Data
    String utranPosData = "42545339343342534333";
    byte[] utranPositioningData = utranPosData.getBytes();
    utranPositioningInfoAvp.setUTRANPositioningData(utranPositioningData);
    // UTRAN-GANSS-Positioning-Data
    String utranGanssPosData = "4254533733524E4331473433";
    byte[] utranGanssPositioningData = utranGanssPosData.getBytes();
    utranPositioningInfoAvp.setUTRANGANSSPositioningData(utranGanssPositioningData);
    // UTRAN-Additional-Positioning-Data
    String utranAddPosData = "42545339343342534333";
    byte[] utranAdditionalPositioningData = utranAddPosData.getBytes();
    utranPositioningInfoAvp.setUTRANAdditionalPositioningData(utranAdditionalPositioningData);
    // Add UTRAN-Positioning-Info AVP to Location-Report-Request
    lrr.setUTRANPositioningInfo(utranPositioningInfoAvp);

    /** Periodic-LDR-Info **/
    // Reporting-Amount
    long reportingAmount = 1L;
    periodicLDRInfoAvp.setReportingAmount(reportingAmount);
    // Reporting-Interval
    long reportingInterval = 8639999L;
    periodicLDRInfoAvp.setReportingInterval(reportingInterval);
    // Add Periodic-LDR-Info Grouped AVP to Location-Report-Request
    lrr.setPeriodicLDRInformation(periodicLDRInfoAvp);

    /** ESMLC-Cell-Info **/
    // ECGI
    String ecgiStr = "654E4239343337";
    byte[] ecgi = ecgiStr.getBytes();
    esmlcCellInfoAvp.setECGI(ecgi);
    // Cell-Portion-ID
    long cellPortionId = 34923L;
    esmlcCellInfoAvp.setCellPortionID(cellPortionId);
    // Add ESMLC-Cell-Info Grouped AVP to Location-Report-Request
    lrr.setESMLCCellInfo(esmlcCellInfoAvp);

    /** Serving-Node **/
    // SGSN-Number
    String sgsnNumberStr = "59899004501";
    byte[] sgsnNumber = sgsnNumberStr.getBytes();
    servingNodeAvp.setSGSNNumber(sgsnNumber);
    // SGSN-Name
    DiameterIdentity sgsnName = new DiameterIdentity("SGSN01");
    servingNodeAvp.setSGSNName(sgsnName);
    // SGSN-Realm
    DiameterIdentity sgsnRealm = new DiameterIdentity("sgsn.restcomm.com");
    servingNodeAvp.setSGSNRealm(sgsnRealm);
    // MME-Realm
    DiameterIdentity mmeRealm = new DiameterIdentity("mme.restcomm.com");
    servingNodeAvp.setMMERealm(mmeRealm);
    // MME-Name
    DiameterIdentity mmeName = new DiameterIdentity("MME710");
    servingNodeAvp.setMMEName(mmeName);
    // MSC-Number
    String mscNumberStr = "59899001207";
    byte[] mscNumber = mscNumberStr.getBytes();
    servingNodeAvp.setMSCNumber(mscNumber);
    // LCS-Capabilities-Set
    long lcsCapabilitiesSets = 99900123L;
    servingNodeAvp.setLcsCapabilitiesSets(lcsCapabilitiesSets);
    // 3GPP-AAA-Server-Name
    DiameterIdentity tgppAAAServerName = new DiameterIdentity("aaa.restcomm.com");
    servingNodeAvp.set3GPPAAAServerName(tgppAAAServerName);
    // GMLC-Address
    AddressType gmlcAddressType = AddressType.ADDRESS_IP;
    String gmlcAddressStr = "10.0.0.10";
    byte[] addGmlcAddressBytes = gmlcAddressStr.getBytes();
    Address gmlcAddress = new Address(gmlcAddressType, addGmlcAddressBytes);
    servingNodeAvp.setGMLCAddress(gmlcAddress);
    // Add Serving-Node Grouped AVP to Location-Report-Request
    lrr.setServingNode(servingNodeAvp);

    /** Deferred-MT-LR-Data **/
    // Deferred-Location-Type
    long deferredLocationType = 5L;
    deferredMTLRDataAvp.setDeferredLocationType(deferredLocationType);
    // Termination-Cause
    long terminationCause = 9L;
    deferredMTLRDataAvp.setTerminationCause(terminationCause);
    // Serving-Node
    deferredMTLRDataAvp.setServingNode(servingNodeAvp);
    // Add Deferred-MT-LR-Data Grouped AVP to Location-Report-Request
    lrr.setDeferredMTLRData(deferredMTLRDataAvp);

    /** Delayed-Location-Reporting-Data **/
    // Termination-Cause
    long terminationCauseDLRD = 9L;
    delayedLocationReportingDataAvp.setTerminationCause(terminationCauseDLRD);
    // Serving-Node
    delayedLocationReportingDataAvp.setServingNode(servingNodeAvp);
    // Add Delayed-Location-Reporting-Data Grouped AVP to Location-Report-Request
    lrr.setDelayedLocationReportingData(delayedLocationReportingDataAvp);

  }

  @Test
  public void testGettersAndSettersLRR() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();

    int nFailures = SLgAvpAssistant.INSTANCE.testMethods(lrr, LocationReportRequest.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }

  @Test
  public void testMessageFactoryApplicationIdChangeLRR() throws Exception {
    long vendor = 10415L;
    ApplicationId originalAppId = ((SLgMessageFactoryImpl) slgMessageFactory).getApplicationId();

    boolean isAuth = originalAppId.getAuthAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;
    boolean isAcct = originalAppId.getAcctAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;

    boolean isVendor = originalAppId.getVendorId() != 0L;

    assertTrue("Invalid Application-Id (" + originalAppId + "). Should only, and at least, contain either Auth or Acct value.", (isAuth && !isAcct) || (!isAuth && isAcct));

    System.out.println("Default VENDOR-ID for SLg is " + originalAppId.getVendorId());
    // let's create a message and see how it comes...
    LocationReportRequest originalLRR = slgMessageFactory.createLocationReportRequest();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, originalLRR);

    // now we switch..
    originalLRR = null;
    isVendor = !isVendor;
    ((SLgMessageFactoryImpl) slgMessageFactory).setApplicationId(isVendor ? vendor : 0L, isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());

    // create a new message and see how it comes...
    LocationReportRequest changedLRR = slgMessageFactory.createLocationReportRequest();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, changedLRR);

    // revert back to default
    ((SLgMessageFactoryImpl) slgMessageFactory).setApplicationId(originalAppId.getVendorId(), isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());
  }

  // *********************************************//
  // ***  Location-Report-Answer (LRA) Tests *** //
  // *******************************************//

  @Test
  public void isAnswerLRA() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    sLgClientSessionActivity.fetchSessionData(lrr);
    LocationReportAnswer lra = sLgClientSessionActivity.createLocationReportAnswer();

    assertFalse("Request Flag in LCS Location-Report-Answer is set.", lra.getHeader().isRequest());
  }

  @Test
  public void testGroupedChildAVPsLRA() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    sLgClientSessionActivity.fetchSessionData(lrr);
    LocationReportAnswer lra = sLgClientSessionActivity.createLocationReportAnswer();
    ReportingPLMNListAvp reportingPLMNListAvp = slgAvpFactory.createReportingPLMNList();
    PLMNIDListAvp plmnIdListAvp = slgAvpFactory.createPLMNIDList();

    /** Reporting-PLMN-List **/
    // PLMN-ID-List
    String visitedPLMNIdListString = "222";
    byte[] visitedPLMNIdList = visitedPLMNIdListString.getBytes();
    plmnIdListAvp.setVisitedPLMNId(visitedPLMNIdList);
    // Periodic-Location-Support-Indicator
    PeriodicLocationSupportIndicator periodicLocationSupportIndicator = PeriodicLocationSupportIndicator.SUPPORTED;
    plmnIdListAvp.setPeriodicLocationSupportIndicator(periodicLocationSupportIndicator);
    reportingPLMNListAvp.setPLMNIDList(plmnIdListAvp);
    // Prioritized-List-Indicator
    PrioritizedListIndicator prioritizedListIndicator = PrioritizedListIndicator.PRIORITIZED;
    reportingPLMNListAvp.setPrioritizedListIndicator(prioritizedListIndicator);
    // Add Reporting-PLMN-List Grouped AVP to Location-Report-Answer
    lra.setReportingPLMNList(reportingPLMNListAvp);

  }

  @Test
  public void testGettersAndSettersLRA() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    sLgClientSessionActivity.fetchSessionData(lrr);
    LocationReportAnswer lra = sLgClientSessionActivity.createLocationReportAnswer();

    int nFailures = SLgAvpAssistant.INSTANCE.testMethods(lra, LocationReportAnswer.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }

  @Test
  public void hasDestinationHostLRA() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    sLgClientSessionActivity.fetchSessionData(lrr);
    LocationReportAnswer lra = sLgClientSessionActivity.createLocationReportAnswer();

    assertNull("The Destination-Host and Destination-Realm AVPs MUST NOT be present in the answer message. [RFC6733/6.2]", lra.getDestinationHost());
  }

  @Test
  public void hasDestinationRealmLRA() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    sLgClientSessionActivity.fetchSessionData(lrr);
    LocationReportAnswer lra = sLgClientSessionActivity.createLocationReportAnswer();

    assertNull("The Destination-Host and Destination-Realm AVPs MUST NOT be present in the answer message. [RFC6733/6.2]", lra.getDestinationRealm());
  }

  @Test
  public void isProxiableCopiedLRA() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    sLgClientSessionActivity.fetchSessionData(lrr);
    LocationReportAnswer lra = sLgClientSessionActivity.createLocationReportAnswer();
    assertEquals("The 'P' bit is not copied from request in LCS Location-Report-Answer, it should. [RFC6733/6.2]", lrr.getHeader().isProxiable(), lra.getHeader().isProxiable());

    // Reverse 'P' bit ...
    ((DiameterMessageImpl) lrr).getGenericData().setProxiable(!lrr.getHeader().isProxiable());
    assertTrue("The 'P' bit was not modified in LCS Location-Report-Request, it should.", lrr.getHeader().isProxiable() != lra.getHeader().isProxiable());
    sLgClientSessionActivity.fetchSessionData(lrr);

    lra = sLgClientSessionActivity.createLocationReportAnswer();
    assertEquals("The 'P' bit is not copied from request in Location-Report-Answer, it should. [RFC6733/6.2]", lrr.getHeader().isProxiable(), lra.getHeader().isProxiable());
  }

  @Test
  public void hasTFlagSetLRA() throws Exception {
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    ((DiameterMessageImpl) lrr).getGenericData().setReTransmitted(true);

    assertTrue("The 'T' flag should be set in LCS Location-Report-Request", lrr.getHeader().isPotentiallyRetransmitted());

    sLgClientSessionActivity.fetchSessionData(lrr);
    LocationReportAnswer lra = sLgClientSessionActivity.createLocationReportAnswer();
    assertFalse("The 'T' flag should not be set in LCS Location-Report-Answer", lra.getHeader().isPotentiallyRetransmitted());
  }

  @Test
  public void testClientSessionApplicationIdChangeLRA() throws Exception {
    long vendor = 10415L;
    ApplicationId originalAppId = ((SLgMessageFactoryImpl) slgMessageFactory).getApplicationId();

    boolean isAuth = originalAppId.getAuthAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;
    boolean isAcct = originalAppId.getAcctAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;

    boolean isVendor = originalAppId.getVendorId() != 0L;

    assertTrue("Invalid Application-Id (" + originalAppId + "). Should only, and at least, contain either Auth or Acct value.", (isAuth && !isAcct) || (!isAuth && isAcct));

    System.out.println("Default VENDOR-ID for SLg is " + originalAppId.getVendorId());
    // let's create a message and see how it comes...
    LocationReportRequest lrr = slgMessageFactory.createLocationReportRequest();
    sLgClientSessionActivity.fetchSessionData(lrr);
    LocationReportAnswer originalLRA = sLgClientSessionActivity.createLocationReportAnswer();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, originalLRA);

    // now we switch..
    originalLRA = null;
    isVendor = !isVendor;
    ((SLgMessageFactoryImpl) slgMessageFactory).setApplicationId(isVendor ? vendor : 0L, isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());

    // create a new message and see how it comes...
    LocationReportAnswer changedLRA = sLgClientSessionActivity.createLocationReportAnswer();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, changedLRA);

    // revert back to default
    ((SLgMessageFactoryImpl) slgMessageFactory).setApplicationId(originalAppId.getVendorId(), isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());
  }

  @Test
  public void testGettersAndSettersSupportedFeatures() throws Exception {
    SupportedFeaturesAvp avp = slgAvpFactory.createSupportedFeatures();

    int nFailures = SLgAvpAssistant.INSTANCE.testMethods(avp, SupportedFeaturesAvpImpl.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }

}
