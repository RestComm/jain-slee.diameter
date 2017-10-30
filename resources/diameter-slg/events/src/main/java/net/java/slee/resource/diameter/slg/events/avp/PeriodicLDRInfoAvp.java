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
 * Defines an interface representing the ESMLC-Cell-Info AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
 *
 * <pre>
 * 7.4.45	Periodic-LDR-Info
 * The Periodic-LDR-Info AVP is of type Grouped.
 * AVP format:
 * 						Periodic-LDR-Info ::= <AVP header: 2540 10415>
 * 																{ Reporting-Amount }
 * 																{ Reporting-Interval }
 * 																*[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface PeriodicLDRInfoAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V13.0.0

		7.4.46	Reporting-Amount
		The Reporting-Amount AVP is of type Unsigned32 and it contains reporting frequency.
		Its minimum value shall be 1 and maximum value shall be 8639999.
  */
  public boolean hasReportingAmount();
  public long getReportingAmount();
  public void setReportingAmount(long reportingAmount);

  /*
		From 3GPP TS 29.172 V13.0.0

		7.4.47	Reporting-Interval
		The Interval-Time AVP is of type Unsigned32 and it contains reporting interval in seconds.
		Its minimum value shall be 1 and maximum value shall be 8639999.
	*/
  public boolean hasReportingInterval();
  public long getReportingInterval();
  public void setReportingInterval(long reportingInterval);

}
