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

package net.java.slee.resource.diameter.slh;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.slh.events.avp.*;

/**
 * Used by applications to create Diameter SLh request messages.
 * SLh answer messages can be created using the SLhServerSessionActivity.createLCSRoutingInfoAnswer() method.
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface SLhAVPFactory extends DiameterAvpFactory {

  public ServingNodeAvp createServingNodeAvp();

  public AdditionalServingNodeAvp createAdditionalServingNodeAvp();

  public SupportedFeaturesAvp createSupportedFeaturesAvp();

  /*
  public LMSIAvp createLMSIAvp();

  public MMENameAvp createMMENameAvp();

  public MSCNumberAvp createMSCNumberAvp();

  public LCSCapabilitiesSetsAvp createLCSCapabilitiesSetsAvp();

  public GMLCAddressAvp createGMLCAddressAvp();

  public PPRAddressAvp createPPRAddressAvp();

  public MMERealmAvp createMMERealmAvp();

  public SGSNNameAvp createSGSNNameAvp();

  public SGSNRealmAvp createSGSNRealmAvp();

  public RIAFlagsAvp createRIAFlagsAvp();

  public MSISDNAvp createMSISDNAvp();

  public SGSNNumberAvp createSGSNNumberAvp();

  public FeatureListIDAvp createFeatureListIDAvp();

  public GMLCNumberAvp createGMLCNumberAvp():

  public TGPPAAAServerNameAvp createTGPPAAAServerNameAvp();
*/
}

