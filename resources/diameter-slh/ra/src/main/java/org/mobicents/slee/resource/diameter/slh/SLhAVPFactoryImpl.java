/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
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

package org.mobicents.slee.resource.diameter.slh;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.AvpUtilities;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import org.jdiameter.api.Avp;
import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import net.java.slee.resource.diameter.slh.SLhAVPFactory;
import net.java.slee.resource.diameter.slh.events.avp.*;
import org.mobicents.slee.resource.diameter.slh.events.avp.*;

/**
 * Implementation of {@link SLhAVPFactory}.
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class SLhAVPFactoryImpl extends DiameterAvpFactoryImpl implements SLhAVPFactory {

  protected DiameterAvpFactory baseAvpFactory;

  public SLhAVPFactoryImpl(final DiameterAvpFactory baseAvpFactory) {
    this.baseAvpFactory = baseAvpFactory;
  }

  public DiameterAvpFactory getBaseFactory() {
    return this.baseAvpFactory;
  }

  @Override
  public ServingNodeAvp createServingNodeAvp() {
    return (ServingNodeAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, null, ServingNodeAvpImpl.class);
  }

  public ServingNodeAvp createServingNode(byte[] sgsnNumber, DiameterIdentity sgsnName, DiameterIdentity sgsnRealm, DiameterIdentity mmeName, DiameterIdentity mmeRealm, byte[] mscNumber,
                                          long lcsCapabilitiesSets, DiameterIdentity tgppAAAServerName, Address gmlcAddress){
    // Create the empty AVP
    ServingNodeAvp servingNodeAvp =  createServingNodeAvp();
    /*
     * From the Diameter-based SLh interface for Control Plane LCS (3GPP TS 29.173 V13.0.0) specification:
    *
    * <pre>
    * 6.4.3 Serving-Node
    *
    * The Serving-Node AVP is of type Grouped. This AVP shall contain the information about the network node serving the targeted user.
    *
    * AVP format
     *				Serving-Node ::=	<AVP header: 2401 10415>
     *											    [ SGSN-Number ]
     *													[ SGSN-Name ]
     *													[ SGSN-Realm ]
     *													[ MME-Name ]
     *													[ MME-Realm ]
     *													[ MSC-Number ]
     *													[ 3GPP-AAA-Server-Name ]
     *													[ LCS-Capabilities-Sets ]
     *													[ GMLC-Address ]
     *													*[AVP]
     *
     */
    // Set the provided AVP values
    servingNodeAvp.setSGSNNumber(sgsnNumber);
    servingNodeAvp.setSGSNName(sgsnName);
    servingNodeAvp.setSGSNRealm(sgsnRealm);
    servingNodeAvp.setMMENumber(mmeName);
    servingNodeAvp.setMMERealm(mmeRealm);
    servingNodeAvp.setMSCNumber(mscNumber);
    servingNodeAvp.setLcsCapabilitiesSets(lcsCapabilitiesSets);
    servingNodeAvp.set3GPPAAAServerName(tgppAAAServerName);
    servingNodeAvp.setGMLCAddress(gmlcAddress);

    return servingNodeAvp;
  }

  @Override
  public AdditionalServingNodeAvp createAdditionalServingNodeAvp(){
    return (AdditionalServingNodeAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.ADDITIONAL_SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, null, AdditionalServingNodeAvpImpl.class);
  }

  public AdditionalServingNodeAvp createAdditionalServingNode(byte[] sgsnNumber, DiameterIdentity sgsnName, DiameterIdentity sgsnRealm, DiameterIdentity mmeName, DiameterIdentity mmeRealm, byte[] mscNumber,
                                          long lcsCapabilitiesSets, DiameterIdentity tgppAAAServerName, Address gmlcAddress){
    // Create the empty AVP
    AdditionalServingNodeAvp additionalServingNodeAvp =  createAdditionalServingNodeAvp();
    /*
     * From the Diameter-based SLh interface for Control Plane LCS (3GPP TS 29.173 V13.0.0) specification:
     *
     * 6.4.8	Additional-Serving-Node
     *
     * The Additional-Serving-Node AVP is of type Grouped. This AVP shall contain the information about the network node serving the targeted user.
     *
     * AVP format
     *
     *				Additional-Serving-Node ::=	<AVP header: 2406 10415>
     *													[ SGSN-Number ]
     *													[ SGSN-Name ]
     *													[ SGSN-Realm ]
     *													[ MME-Name ]
     *													[ MME-Realm ]
     *													[ MSC-Number ]
     *													[ 3GPP-AAA-Server-Name ]
     *													[ LCS-Capabilities-Sets ]
     *													[ GMLC-Address ]
     *													*[AVP]
     *
     */
    // Set the provided AVP values
    additionalServingNodeAvp.setAdditionalSGSNNumber(sgsnNumber);
    additionalServingNodeAvp.setAdditionalSGSNName(sgsnName);
    additionalServingNodeAvp.setAdditionalSGSNRealm(sgsnRealm);
    additionalServingNodeAvp.setAdditionalMMEName(mmeName);
    additionalServingNodeAvp.setAdditionalMMERealm(mmeRealm);
    additionalServingNodeAvp.setAdditionalMSCNumber(mscNumber);
    additionalServingNodeAvp.setAdditionalLcsCapabilitiesSets(lcsCapabilitiesSets);
    additionalServingNodeAvp.setAdditional3GPPAAAServerName(tgppAAAServerName);
    additionalServingNodeAvp.setAdditionalGMLCAddress(gmlcAddress);

    return additionalServingNodeAvp;
  }

  @Override
  public SupportedFeaturesAvp createSupportedFeaturesAvp() {
    return (SupportedFeaturesAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.SUPPORTED_FEATURES, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, null, SupportedFeaturesAvpImpl.class);
  }

  public SupportedFeaturesAvp createSupportedFeaturesAvp(long vendorId, long featureListId, long featureList) {
    // Create the empty AVP
    SupportedFeaturesAvp supportedFeaturesAvp = createSupportedFeaturesAvp();


    /*
     * From the Diameter-based SLh interface for Control Plane LCS (3GPP TS 29.229 V14.0.0) specification:
     *
     * 6.3.29	Supported-Features AVP
     *
     * The Supported-Features AVP is of type Grouped. If this AVP is present it may inform the destination host about the features that the origin host supports for the application.
     * The Feature-List AVP contains a list of supported features of the origin host. The Vendor-Id AVP and the Feature-List-ID AVP shall together identify which feature list
     * is carried in the Supported-Features AVP for the Application-ID present in the command header.
     * Where a Supported-Features AVP is used to identify features that have been defined by 3GPP, the Vendor-Id AVP shall contain the vendor ID of 3GPP.
     * Vendors may define proprietary features, but it is strongly recommended that the possibility is used only as the last resort.
     * Where the Supported-Features AVP is used to identify features that have been defined by a vendor other than 3GPP, it shall contain the vendor ID of the specific vendor in question.
     * If there are multiple feature lists defined by the same vendor and the same application, the Feature-List-ID AVP shall differentiate those lists from one another.
     * The destination host shall use the value of the Feature-List-ID AVP to identify the feature list.
     * AVP format
     *            Supported-Features ::= 	< AVP header: 628 10415 >
     *                                    { Vendor-Id }
     *                                    { Feature-List-ID }
     *                                    { Feature-List }
     *                                    *[AVP]
     *
     */
    // Set the provided AVP values
    supportedFeaturesAvp.setVendorId(vendorId);
    supportedFeaturesAvp.setFeatureListId(featureListId);
    supportedFeaturesAvp.setFeatureList(featureList);

    return supportedFeaturesAvp;
  }

/*
  @Override
  public LMSIAvp createLMSIAvp() {
    return (LMSIAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.LMSI, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, LMSIAvpImpl.class);
  }

  @Override
  public MMENameAvp createMMENameAvp() {
    return (MMENameAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, MMENameAvpImpl.class);
  }

  @Override
  public MSCNumberAvp createMSCNumberAvp() {
    return (MSCNumberAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, MSCNumberAvpImpl.class);
  }

  @Override
  public LCSCapabilitiesSetsAvp createLCSCapabilitiesSetsAvp() {
    return (LCSCapabilitiesSetsAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, LCSCapabilitiesSetsAvpImpl.class);
  }

  @Override
  public GMLCAddressAvp createGMLCAddressAvp() {
    return (GMLCAddressAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, GMLCAddressAvpImpl.class);
  }

  @Override
  public PPRAddressAvp createPPRAddressAvp() {
    return (PPRAddress) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.PPR_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, PPRAddressAvpImpl.class);
  }

  @Override
  public MMERealmAvp createMMERealmAvp() {
    return (PPRAddressAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, PPRAddressAvpImpl.class);
  }

  @Override
  public SGSNNameAvp createSGSNNameAvp() {
    return (SGSNNameAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.SGSN_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, SGSNNameAvpImpl.class);
  }

  @Override
  public SGSNRealmAvp createSGSNRealmAvp() {
    return (SGSNRealmAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, SGSNRealmAvpImpl.class);
  }

  @Override
  public RIAFlagsAvp createRIAFlagsAvp() {
    return (RIAFlagsAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.RIA_FLAGS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, RIAFlagsAvpImpl.class);
  }

  @Override
  public MSISDNAvp createMSISDNAvp() {
    return (MSISDNAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.MSISDN, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, MSISDNAvpImpl.class);
  }

  @Override
  public SGSNNumberAvp createSGSNNumberAvp() {
    return (SGSNNumberAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, SGSNNumberAvpImpl.class);
  }

  @Override
  public FeatureListIDAvp createFeatureListIDAvp(){
    return (FeatureListIDAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.FEATURE_LIST_ID, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, FeatureListIDAvpImpl.class);
  }

  @Override
  public GMLCNumberAvp createGMLCNumberAvp(){
    return (GMLCNumberAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.GMLC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, GMLCNumberAvpImpl.class);
  }

  @Override
  public TGPPAAAServerNameAvp createTGPPAAAServerNameAvp(){
    return (TGPPAAAServerNameAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, TGPPAAAServerNameAvpImpl.class);
  }
*/
}

