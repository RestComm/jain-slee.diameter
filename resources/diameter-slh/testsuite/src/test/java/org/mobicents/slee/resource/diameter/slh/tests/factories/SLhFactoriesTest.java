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

package org.mobicents.slee.resource.diameter.slh.tests.factories;

import static org.junit.Assert.*;

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.AddressType;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slh.SLhAVPFactory;
import net.java.slee.resource.diameter.slh.SLhMessageFactory;

import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;
import net.java.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvp;
import net.java.slee.resource.diameter.slh.events.avp.LCSRoutingInfoAVPCodes;
import net.java.slee.resource.diameter.slh.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvp;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.Stack;
import org.jdiameter.api.slh.ClientSLhSession;
import org.jdiameter.api.slh.ServerSLhSession;
import org.jdiameter.common.impl.app.slh.SLhSessionFactoryImpl;
import org.junit.Test;
import org.mobicents.diameter.dictionary.AvpDictionary;
import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.tests.factories.BaseFactoriesTest;
import org.mobicents.slee.resource.diameter.base.tests.factories.BaseFactoriesTest.MyConfiguration;
import org.mobicents.slee.resource.diameter.slh.SLhAVPFactoryImpl;
import org.mobicents.slee.resource.diameter.slh.SLhClientSessionActivityImpl;
import org.mobicents.slee.resource.diameter.slh.SLhMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.slh.SLhServerSessionActivityImpl;
import org.mobicents.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slh.events.avp.ServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvpImpl;

/**
 * Test class for JAIN SLEE Diameter SLh RA Message and AVP Factories
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonça </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class SLhFactoriesTest {

  private static SLhMessageFactory slhMessageFactory;
  private static SLhAVPFactory slhAvpFactory;
  private static SLhServerSessionActivityImpl sLhServerSessionActivity;
  private static SLhClientSessionActivityImpl sLhClientSessionActivity;

  private static Stack stack;

  static {
    stack = new org.jdiameter.client.impl.StackImpl();
    try {
      stack.init(new MyConfiguration());
    } catch (Exception e) {
      throw new RuntimeException("Failed to initialize the stack.");
    }

    slhAvpFactory = new SLhAVPFactoryImpl(new DiameterAvpFactoryImpl());

    try {
      slhMessageFactory = new SLhMessageFactoryImpl(stack);

      SLhSessionFactoryImpl sf = new SLhSessionFactoryImpl(stack.getSessionFactory());
      ApplicationId slhAppId = ApplicationId.createByAuthAppId(LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, LCSRoutingInfoAVPCodes.SLh_AUTH_APP_ID);
      org.jdiameter.server.impl.app.slh.SLhServerSessionImpl stackServerSession = (org.jdiameter.server.impl.app.slh.SLhServerSessionImpl) sf.getNewSession("123",
          ServerSLhSession.class, slhAppId, new Object[0]);
      org.jdiameter.client.impl.app.slh.SLhClientSessionImpl stackClientSession = (org.jdiameter.client.impl.app.slh.SLhClientSessionImpl) sf.getNewSession("321",
          ClientSLhSession.class, slhAppId, new Object[0]);
      sLhServerSessionActivity = new SLhServerSessionActivityImpl(slhMessageFactory, slhAvpFactory, stackServerSession, stackServerSession, null, null, stack);
      sLhClientSessionActivity = new SLhClientSessionActivityImpl(slhMessageFactory, slhAvpFactory, stackClientSession, stackClientSession, null, null, stack);
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      AvpDictionary.INSTANCE.parseDictionary(SLhFactoriesTest.class.getClassLoader().getResourceAsStream("dictionary.xml"));
    } catch (Exception e) {
      throw new RuntimeException("Failed to parse dictionary file.");
    }
  }

  @Test
  public void isRequestRIR() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    assertTrue("Request Flag in LCS Routing-Info-Request is not set.", rir.getHeader().isRequest());
  }

  @Test
  public void isProxiableRIR() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    assertTrue("The 'P' bit is not set by default in LCS Routing-Info-Request it should.", rir.getHeader().isProxiable());
  }

  @Test
  public void testGettersAndSettersRIR() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();

    int nFailures = SLhAvpAssistant.INSTANCE.testMethods(rir, LCSRoutingInfoRequest.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }

  @Test
  public void testGroupedChildAVPsRIA() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    sLhServerSessionActivity.fetchSessionData(rir);
    LCSRoutingInfoAnswer ria = sLhServerSessionActivity.createLCSRoutingInfoAnswer();

    // Serving-Node Grouped AVP
    ServingNodeAvp servingNodeAvp = slhAvpFactory.createServingNode();
    //SGSN Number
    String sgsnNumberStr = "59899004501";
    byte[] sgsnNumber = sgsnNumberStr.getBytes();
    servingNodeAvp.setSGSNNumber(sgsnNumber);
    //SGSN Name
    DiameterIdentity sgsnName = new DiameterIdentity("SGSN01");
    servingNodeAvp.setSGSNName(sgsnName);
    //SGSN Realm
    DiameterIdentity sgsnRealm = new DiameterIdentity("sgsn.restcomm.com");
    servingNodeAvp.setSGSNRealm(sgsnRealm);
    //MME Realm
    DiameterIdentity mmeRealm = new DiameterIdentity("mme.restcomm.com");
    servingNodeAvp.setMMERealm(mmeRealm);
    //MME Name
    DiameterIdentity mmeName = new DiameterIdentity("MME710");
    servingNodeAvp.setMMEName(mmeName);
    //MSC Number
    String mscNumberStr = "59899001207";
    byte[] mscNumber = mscNumberStr.getBytes();
    servingNodeAvp.setMSCNumber(mscNumber);
    // 3GPP AAA Server Name
    DiameterIdentity tgppAAAServerName = new DiameterIdentity("aaa.restcomm.com");
    servingNodeAvp.set3GPPAAAServerName(tgppAAAServerName);
    // GMLC Address
    AddressType gmlcAddressType = AddressType.ADDRESS_IP;
    String gmlcAddressStr = "10.0.0.7";
    byte[] gAddressBytes = gmlcAddressStr.getBytes();
    Address gmlcAddress = new Address(gmlcAddressType, gAddressBytes);
    servingNodeAvp.setGMLCAddress(gmlcAddress);

    // Additional-Serving-Node Grouped AVP
    AdditionalServingNodeAvp additionalServingNodeAvp = slhAvpFactory.createAdditionalServingNode();
    // Additional SGSN Number
    String addSgsnNumberStr = "59899004502";
    byte[] addSgsnNumber = addSgsnNumberStr.getBytes();
    additionalServingNodeAvp.setSGSNNumber(addSgsnNumber);
    // Additional SGSN Name
    DiameterIdentity addSgsnName = new DiameterIdentity("SGSN02");
    additionalServingNodeAvp.setSGSNName(addSgsnName);
    // Additional SGSN Realm
    DiameterIdentity addSgsnRealm = new DiameterIdentity("sgsn.restcomm.com");
    additionalServingNodeAvp.setSGSNRealm(addSgsnRealm);
    // Additional MME Realm
    DiameterIdentity addMmeRealm = new DiameterIdentity("mme.restcomm.com");
    additionalServingNodeAvp.setMMERealm(addMmeRealm);
    // Additional MME Name
    DiameterIdentity addMmeName = new DiameterIdentity("MME710");
    additionalServingNodeAvp.setMMEName(addMmeName);
    // Additional MSC Number
    String addMscNumberStr = "59899001207";
    byte[] addMscNumber = addMscNumberStr.getBytes();
    additionalServingNodeAvp.setMSCNumber(addMscNumber);
    // Additional 3GPP AAA Server Name
    DiameterIdentity add3gppAAAServerName = new DiameterIdentity("aaa.restcomm.com");
    additionalServingNodeAvp.set3GPPAAAServerName(add3gppAAAServerName);
    // Additional GMLC Address
    AddressType addGmlcAddressType = AddressType.ADDRESS_IP;
    String addGmlcAddressStr = "10.0.0.10";
    byte[] addGmlcAddressBytes = addGmlcAddressStr.getBytes();
    Address addGmlcAddress = new Address(addGmlcAddressType, addGmlcAddressBytes);
    additionalServingNodeAvp.setGMLCAddress(addGmlcAddress);

    ria.setServingNode(servingNodeAvp);
    ria.setAdditionalServingNode(additionalServingNodeAvp);
  }

  @Test
  public void isAnswerRIA() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    sLhServerSessionActivity.fetchSessionData(rir);
    LCSRoutingInfoAnswer ria = sLhServerSessionActivity.createLCSRoutingInfoAnswer();

    assertFalse("Request Flag in Routing-Information-Answer is set.", ria.getHeader().isRequest());
  }

  @Test
  public void testGettersAndSettersRIA() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    sLhServerSessionActivity.fetchSessionData(rir);
    LCSRoutingInfoAnswer ria = sLhServerSessionActivity.createLCSRoutingInfoAnswer();

    int nFailures = SLhAvpAssistant.INSTANCE.testMethods(ria, LCSRoutingInfoAnswer.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }

  @Test
  public void hasDestinationHostRIA() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    sLhServerSessionActivity.fetchSessionData(rir);
    LCSRoutingInfoAnswer ria = sLhServerSessionActivity.createLCSRoutingInfoAnswer();

    assertNull("The Destination-Host and Destination-Realm AVPs MUST NOT be present in the answer message. [RFC6733/6.2]", ria.getDestinationHost());
  }

  @Test
  public void hasDestinationRealmRIA() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    sLhServerSessionActivity.fetchSessionData(rir);
    LCSRoutingInfoAnswer ria = sLhServerSessionActivity.createLCSRoutingInfoAnswer();

    assertNull("The Destination-Host and Destination-Realm AVPs MUST NOT be present in the answer message. [RFC6733/6.2]", ria.getDestinationRealm());
  }

  @Test
  public void isProxiableCopiedRIA() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    sLhServerSessionActivity.fetchSessionData(rir);
    LCSRoutingInfoAnswer ria = sLhServerSessionActivity.createLCSRoutingInfoAnswer();
    assertEquals("The 'P' bit is not copied from request in Routing-Information-Answer, it should. [RFC6733/6.2]", rir.getHeader().isProxiable(), ria.getHeader().isProxiable());

    // Reverse 'P' bit ...
    ((DiameterMessageImpl) rir).getGenericData().setProxiable(!rir.getHeader().isProxiable());
    assertTrue("The 'P' bit was not modified in Routing-Information-Request, it should.", rir.getHeader().isProxiable() != ria.getHeader().isProxiable());
    sLhServerSessionActivity.fetchSessionData(rir);

    ria = sLhServerSessionActivity.createLCSRoutingInfoAnswer();
    assertEquals("The 'P' bit is not copied from request in Routing-Information-Answer, it should. [RFC6733/6.2]", rir.getHeader().isProxiable(), ria.getHeader()
        .isProxiable());
  }

  @Test
  public void hasTFlagSetRIA() throws Exception {
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    ((DiameterMessageImpl) rir).getGenericData().setReTransmitted(true);

    assertTrue("The 'T' flag should be set in Routing-Information-Request", rir.getHeader().isPotentiallyRetransmitted());

    sLhServerSessionActivity.fetchSessionData(rir);
    LCSRoutingInfoAnswer ria = sLhServerSessionActivity.createLCSRoutingInfoAnswer();
    assertFalse("The 'T' flag should not be set in Routing-Information-Answer", ria.getHeader().isPotentiallyRetransmitted());
  }

  @Test
  public void testMessageFactoryApplicationIdChangeRIR() throws Exception {
    long vendor = 10415L;
    ApplicationId originalAppId = ((SLhMessageFactoryImpl) slhMessageFactory).getApplicationId();

    boolean isAuth = originalAppId.getAuthAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;
    boolean isAcct = originalAppId.getAcctAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;

    boolean isVendor = originalAppId.getVendorId() != 0L;

    assertTrue("Invalid Application-Id (" + originalAppId + "). Should only, and at least, contain either Auth or Acct value.", (isAuth && !isAcct) || (!isAuth && isAcct));

    System.out.println("Default VENDOR-ID for SLh is " + originalAppId.getVendorId());
    // let's create a message and see how it comes...
    LCSRoutingInfoRequest originalRIR = slhMessageFactory.createLCSRoutingInfoRequest();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, originalRIR);

    // now we switch..
    originalRIR = null;
    isVendor = !isVendor;
    ((SLhMessageFactoryImpl) slhMessageFactory).setApplicationId(isVendor ? vendor : 0L, isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());

    // create a new message and see how it comes...
    LCSRoutingInfoRequest changedAIR = slhMessageFactory.createLCSRoutingInfoRequest();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, changedAIR);

    // revert back to default
    ((SLhMessageFactoryImpl) slhMessageFactory).setApplicationId(originalAppId.getVendorId(), isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());
  }

  @Test
  public void testServerSessionApplicationIdChangeRIR() throws Exception {
    long vendor = 10415L;
    ApplicationId originalAppId = ((SLhMessageFactoryImpl) slhMessageFactory).getApplicationId();

    boolean isAuth = originalAppId.getAuthAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;
    boolean isAcct = originalAppId.getAcctAppId() != org.jdiameter.api.ApplicationId.UNDEFINED_VALUE;

    boolean isVendor = originalAppId.getVendorId() != 0L;

    assertTrue("Invalid Application-Id (" + originalAppId + "). Should only, and at least, contain either Auth or Acct value.", (isAuth && !isAcct) || (!isAuth && isAcct));

    System.out.println("Default VENDOR-ID for SLh is " + originalAppId.getVendorId());
    // let's create a message and see how it comes...
    LCSRoutingInfoRequest rir = slhMessageFactory.createLCSRoutingInfoRequest();
    sLhServerSessionActivity.fetchSessionData(rir);
    LCSRoutingInfoAnswer originalRIA = sLhServerSessionActivity.createLCSRoutingInfoAnswer();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, originalRIA);

    // now we switch..
    originalRIA = null;
    isVendor = !isVendor;
    ((SLhMessageFactoryImpl) slhMessageFactory).setApplicationId(isVendor ? vendor : 0L, isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());

    // create a new message and see how it comes...
    LCSRoutingInfoAnswer changedRIA = sLhServerSessionActivity.createLCSRoutingInfoAnswer();
    BaseFactoriesTest.checkCorrectApplicationIdAVPs(isVendor, isAuth, isAcct, changedRIA);

    // revert back to default
    ((SLhMessageFactoryImpl) slhMessageFactory).setApplicationId(originalAppId.getVendorId(), isAuth ? originalAppId.getAuthAppId() : originalAppId.getAcctAppId());
  }

  @Test
  public void testGettersAndSettersServingNode() throws Exception {
    ServingNodeAvp servingNodeAvp = slhAvpFactory.createServingNode();

    int nFailures = SLhAvpAssistant.INSTANCE.testMethods(servingNodeAvp, ServingNodeAvpImpl.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }

  @Test
  public void testGettersAndSettersAdditionalServingNode() throws Exception {
    AdditionalServingNodeAvp additionalServingNodeAvp = slhAvpFactory.createAdditionalServingNode();

    int nFailures = SLhAvpAssistant.INSTANCE.testMethods(additionalServingNodeAvp, AdditionalServingNodeAvpImpl.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }


  @Test
  public void testGettersAndSettersSupportedFeatures() throws Exception {
    SupportedFeaturesAvp supportedFeaturesAvp = slhAvpFactory.createSupportedFeatures();

    int nFailures = SLhAvpAssistant.INSTANCE.testMethods(supportedFeaturesAvp, SupportedFeaturesAvpImpl.class);

    assertEquals("Some methods have failed. See logs for more details.", 0, nFailures);
  }

}
