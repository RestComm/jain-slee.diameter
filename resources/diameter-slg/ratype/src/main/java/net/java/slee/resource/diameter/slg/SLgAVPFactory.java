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

package net.java.slee.resource.diameter.slg;

import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckNonSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSRequestorNameAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSPrivacyCheckSessionAvp;
import net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.AdditionalAreaAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaDefinitionAvp;
import net.java.slee.resource.diameter.slg.events.avp.AreaAvp;
import net.java.slee.resource.diameter.slg.events.avp.PeriodicLDRInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.ReportingPLMNListAvp;
import net.java.slee.resource.diameter.slg.events.avp.PLMNIDListAvp;
import net.java.slee.resource.diameter.slg.events.avp.DeferredMTLRDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvp;
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.slg.events.avp.MotionEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp;

/**
 * Factory to support the creation of Grouped AVP instances for SLg.
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface SLgAVPFactory extends DiameterAvpFactory {

  // SLg Grouped AVPs in alphabetical order

  AdditionalAreaAvp createAdditionalArea();

  AreaAvp createArea();

  AreaDefinitionAvp createAreaDefinition();

  AreaEventInfoAvp createAreaEventInfo();

  DeferredMTLRDataAvp createDeferredMTLRData();

  DelayedLocationReportingDataAvp createDelayedLocationReportingData();

  ESMLCCellInfoAvp createESMLCCellInfo();

  GERANPositioningInfoAvp createGERANPositioningInfo();

  LCSEPSClientNameAvp createLCSEPSClientName();

  LCSRequestorNameAvp createLCSRequestorName();

  LCSQoSAvp createLCSQoS();

  LCSPrivacyCheckNonSessionAvp createLCSPrivacyCheckNonSession();

  LCSPrivacyCheckSessionAvp createLCSPrivacyCheckSession();

  MotionEventInfoAvp createMotionEventInfo();

  PeriodicLDRInfoAvp createPeriodicLDRInformation();

  PLMNIDListAvp createPLMNIDList();

  ReportingPLMNListAvp createReportingPLMNList();

  ServingNodeAvp createServingNode();

  SupportedFeaturesAvp createSupportedFeatures();

  UTRANPositioningInfoAvp createUTRANPositioningInfo();

}