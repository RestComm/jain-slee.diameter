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

package net.java.slee.resource.diameter.slg.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Reporting-PLMN-List AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V14.1.0) specification.
 * <p>
 * <pre>
 * 7.4.48	Reporting-PLMN-List
 * The Reporting-PLMN-List AVP is of type Grouped.
 * AVP format:
 * 		Reporting-PLMN-List ::= <AVP header: 2543 10415>
 * 													  1*20{ PLMN-ID-List }
 * 													  [ Prioritized-List-Indicator ]
 * 													 *[ AVP ]
 * If not included, the default value of Prioritized-List-Indicator shall be considered as "NOT_PRIORITIZED" (0).
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface ReportingPLMNListAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V14.1.0

		7.4.49	PLMN-ID-List
		The PLMN-ID-List AVP is of type Grouped.
		AVP format:
							PLMN-ID-List ::= <AVP header: 2544 10415>
															{ Visited-PLMN-Id }
															[ Periodic-Location-Support-Indicator ]
															*[ AVP ]
															If not included, the default value of Periodic-Location-Support-Indicator shall be considered as "NOT_SUPPORTED" (0).
  */
  boolean hasPLMNIDList();

  PLMNIDListAvp getPLMNIDList();

  void setPLMNIDList(PLMNIDListAvp plmnidList);

  /*
		7.4.51	Prioritized-List-Indicator
		The Prioritized-List-Indicator AVP is of type Enumerated and it indicates if the PLMN-ID-List is provided in prioritized order or not.
		The following values are defined:
			NOT_PRIORITIZED  (0)
			PRIORITIZED (1)
	*/
  boolean hasPrioritizedListIndicator();

  PrioritizedListIndicator getPrioritizedListIndicator();

  void setPrioritizedListIndicator(PrioritizedListIndicator prioritizedListIndicator);

}
