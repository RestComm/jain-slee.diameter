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

package org.mobicents.slee.resource.diameter.slh;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.base.events.avp.AvpUtilities;
import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;

import net.java.slee.resource.diameter.slh.SLhAVPFactory;
import net.java.slee.resource.diameter.slh.events.avp.LCSRoutingInfoAVPCodes;
import net.java.slee.resource.diameter.slh.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvp;
import net.java.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvp;
import org.mobicents.slee.resource.diameter.slh.events.avp.ServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvpImpl;

/**
 * Implementation of {@link SLhAVPFactory}.
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class SLhAVPFactoryImpl extends DiameterAvpFactoryImpl implements SLhAVPFactory {

  protected DiameterAvpFactory baseAvpFactory;

  public SLhAVPFactoryImpl(final DiameterAvpFactory baseAvpFactory) {
    this.baseAvpFactory = baseAvpFactory;
  }

  public DiameterAvpFactory getBaseFactory() {
    return this.baseAvpFactory;
  }

  public ServingNodeAvp createServingNode() {
    /*
     * From the Diameter-based SLh interface for Control Plane LCS (3GPP TS 29.173 V14.0.0) specification:
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
     *												 *[ AVP ]
     *
     */
    return (ServingNodeAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, null, ServingNodeAvpImpl.class);
  }

  public AdditionalServingNodeAvp createAdditionalServingNode() {
    /*
     * From the Diameter-based SLh interface for Control Plane LCS (3GPP TS 29.173 V14.0.0) specification:
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
    return (AdditionalServingNodeAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.ADDITIONAL_SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, null, AdditionalServingNodeAvpImpl.class);
  }

  @Override
  public SupportedFeaturesAvp createSupportedFeatures() {
    return (SupportedFeaturesAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.SUPPORTED_FEATURES, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, null, SupportedFeaturesAvpImpl.class);
  }

  public SupportedFeaturesAvp createSupportedFeatures(long vendorId, long featureListId, long featureList) {
    // Create the empty AVP
    SupportedFeaturesAvp supportedFeaturesAvp = createSupportedFeatures();

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

}
