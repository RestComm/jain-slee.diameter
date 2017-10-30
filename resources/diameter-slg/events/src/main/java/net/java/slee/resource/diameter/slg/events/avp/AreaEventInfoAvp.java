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

package net.java.slee.resource.diameter.slg.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Area-Event-Info AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
 *
 * <pre>
 * 7.4.38	Area-Event-Info
 * 	The Area-Event-Info AVP is of type Grouped.
 *
 * 	AVP format:
 * 		Area-Event-Info ::= <AVP header: 2533 10415>
 * 											{ Area-Definition }
 * 											[ Occurrence-Info ]
 * 											[ Interval-Time ]
 * 											*[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface AreaEventInfoAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V13.0.0

		7.4.39	Area-Definition
		The Area-Definition AVP is of type Grouped.
		AVP format:
		Area-Definition ::= <AVP header: 2534 10415>
										1*10{ Area }
										*[ AVP ]
  */
  public boolean hasAreaDefinition();
  public AreaDefinitionAvp getAreaDefinition();
  public void setAreaDefinition(AreaDefinitionAvp areaDefinition);

  /*
		From 3GPP TS 29.172 V13.0.0

		7.4.43	Occurrence-Info
      The Occurrence-Info AVP is of type Enumerated. The following values are defined:
      ONE_TIME_EVENT (0)
    MULTIPLE_TIME_EVENT (1)

	*/
  public boolean hasOccurrenceInfo();
  public OccurrenceInfo getOccurrenceInfo();
  public void setOccurrenceInfo(OccurrenceInfo occurrenceInfo);

  /*
		From 3GPP TS 29.172 V13.0.0

		7.4.44	Interval-Time
      The Interval-Time AVP is of type Unsigned32 and it contains minimum time interval between area reports, in seconds.
	*/
  public boolean hasIntervalTime();
  public long getIntervalTime();
  public void setIntervalTime(long intervalTime);

}
