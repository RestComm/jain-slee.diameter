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

import net.java.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvp;
import net.java.slee.resource.diameter.slh.events.avp.LCSRoutingInfoAVPCodes;
import net.java.slee.resource.diameter.slh.events.avp.ServingNodeAvp;
import org.mobicents.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slh.events.avp.ServingNodeAvpImpl;

/**
 * Aux Class for assisting in testing AVP setters/getters
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonça </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class SLhAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

  public static SLhAvpAssistant INSTANCE;

  static {
    try {
      INSTANCE = new SLhAvpAssistant();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected SLhAvpAssistant() throws Exception {
    super();

    // SLh AVP Factory
    typeValues.put(ServingNodeAvp.class, new ServingNodeAvpImpl(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(ServingNodeAvp[].class, new ServingNodeAvpImpl[]{
        new ServingNodeAvpImpl(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, 0, 1, dummyAvpBytes),
        new ServingNodeAvpImpl(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(AdditionalServingNodeAvp.class, new AdditionalServingNodeAvpImpl(LCSRoutingInfoAVPCodes.ADDITIONAL_SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(AdditionalServingNodeAvp[].class, new AdditionalServingNodeAvpImpl[]{
        new AdditionalServingNodeAvpImpl(LCSRoutingInfoAVPCodes.ADDITIONAL_SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, 0, 1, dummyAvpBytes),
        new AdditionalServingNodeAvpImpl(LCSRoutingInfoAVPCodes.ADDITIONAL_SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, 0, 1, dummyAvpBytes)});

    typeValues.put(net.java.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvp.class, new org.mobicents.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvpImpl(
        LCSRoutingInfoAVPCodes.SUPPORTED_FEATURES, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, 0, 1, dummyAvpBytes));
    typeValues.put(net.java.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvp[].class, new org.mobicents.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvpImpl[]{
        new org.mobicents.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvpImpl(LCSRoutingInfoAVPCodes.SUPPORTED_FEATURES, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, 0, 1,
            dummyAvpBytes),
        new org.mobicents.slee.resource.diameter.slh.events.avp.SupportedFeaturesAvpImpl(LCSRoutingInfoAVPCodes.SUPPORTED_FEATURES, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, 0, 1,
            dummyAvpBytes)});

  }

}

