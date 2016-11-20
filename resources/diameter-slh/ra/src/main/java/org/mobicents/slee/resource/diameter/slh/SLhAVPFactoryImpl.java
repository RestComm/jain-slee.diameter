/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
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
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.diameter.slh;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.base.events.avp.AvpUtilities;
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
*/
  @Override
  public ServingNodeAvp createServingNodeAvp() {
    return (ServingNodeAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, ServingNodeAvpImpl.class);
  }
/*
  @Override
  public PPRAddressAvp createPPRAddressAvp() {
    return (PPRAddressAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes., LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, PPRAddressAvpImpl.class);
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
*/

  @Override
  public SupportedFeaturesAvp createSupportedFeaturesAvp() {
    return (SupportedFeaturesAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.SUPPORTED_FEATURES, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, SupportedFeaturesAvpImpl.class);
  }

  @Override
  public AdditionalServingNodeAvp createAdditionalServingNodeAvp(){
    return (AdditionalServingNodeAvp) AvpUtilities.createAvp(LCSRoutingInfoAVPCodes.ADDITIONAL_SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, AdditionalServingNodeAvpImpl.class);
  }
/*
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

