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

package net.java.slee.resource.diameter.slg.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Reporting-PLMN-List AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
 *
 * <pre>
 * 7.4.48	Reporting-PLMN-List
 * The Reporting-PLMN-List AVP is of type Grouped.
 * AVP format:
 * 		Reporting-PLMN-List ::= <AVP header: 2543 10415>
 * 													1*20{ PLMN-ID-List }
 * 													[ Prioritized-List-Indicator ]
 * 													*[ AVP ]
 * If not included, the default value of Prioritized-List-Indicator shall be considered as "NOT_PRIORITIZED" (0).
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface ReportingPLMNListAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V13.0.0

		7.4.49	PLMN-ID-List
		The PLMN-ID-List AVP is of type Grouped.
		AVP format:
							PLMN-ID-List ::= <AVP header: 2544 10415>
															{ Visited-PLMN-Id }
															[ Periodic-Location-Support-Indicator ]
															*[ AVP ]
															If not included, the default value of Periodic-Location-Support-Indicator shall be considered as "NOT_SUPPORTED" (0).
  */
  public boolean hasPLMNIDList();
  public PLMNIDListAvp getPLMNIDList();
  public void setPLMNIDList(PLMNIDListAvp plmnidList);

  /*
		7.4.51	Prioritized-List-Indicator
		The Prioritized-List-Indicator AVP is of type Enumerated and it indicates if the PLMN-ID-List is provided in prioritized order or not.
		The following values are defined:
			NOT_PRIORITIZED  (0)
			PRIORITIZED (1)
	*/
  public boolean hasPrioritizedListIndicator();
  public PrioritizedListIndicator getPrioritizedListIndicator();
  public void setPrioritizedListIndicator(PrioritizedListIndicator prioritizedListIndicator);

}
