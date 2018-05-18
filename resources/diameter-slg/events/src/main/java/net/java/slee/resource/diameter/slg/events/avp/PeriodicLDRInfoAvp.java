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
 * Defines an interface representing the ESMLC-Cell-Info AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V14.1.0) specification.
 * <p>
 * <pre>
 * 7.4.45	Periodic-LDR-Info
 * The Periodic-LDR-Info AVP is of type Grouped.
 * AVP format:
 * 						Periodic-LDR-Info ::= <AVP header: 2540 10415>
 *                                 { Reporting-Amount }
 *                                 { Reporting-Interval }
 * 																*[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface PeriodicLDRInfoAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V14.1.0

		7.4.46	Reporting-Amount
		The Reporting-Amount AVP is of type Unsigned32 and it contains reporting frequency.
		Its minimum value shall be 1 and maximum value shall be 8639999.
  */
  boolean hasReportingAmount();

  long getReportingAmount();

  void setReportingAmount(long reportingAmount);

  /*
		From 3GPP TS 29.172 V14.1.0

		7.4.47	Reporting-Interval
		The Interval-Time AVP is of type Unsigned32 and it contains reporting interval in seconds.
		Its minimum value shall be 1 and maximum value shall be 8639999.
	*/
  boolean hasReportingInterval();

  long getReportingInterval();

  void setReportingInterval(long reportingInterval);

}
