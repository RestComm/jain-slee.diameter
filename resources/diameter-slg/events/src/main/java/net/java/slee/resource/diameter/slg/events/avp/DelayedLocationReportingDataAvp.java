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
 * Defines an interface representing the Delayed-Location-Reporting-Data AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.1.0) specification.
 *
 * <pre>
 * 7.4.60	Delayed-Location-Reporting-Data
 * The Delayed-Location-Reporting-Data AVP is of type Grouped.
 * AVP format:
 * 						Delayed-Location-Reporting-Data ::= <AVP header: 2555 10415>
 * 																						[ Termination-Cause ]
 * 																						[ Serving-Node ]
 * 																						*[ AVP ]
 * Serving-Node may be included only when the Termination-Cause is present indicating MT_LR_RESTART.
 * The Serving-Node refers to the node where the UE has moved to and shall be included, if available.
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface DelayedLocationReportingDataAvp extends GroupedAvp {

  /*
		From 3GPP TS 29.172 V13.0.0

		7.4.55	Termination-Cause
		The Termination-Cause AVP is of type Unsigned32. The following values are defined:
			"Normal"																			0
			"Error Undefined"															1
			"Internal Timeout"														2
			"Congestion"																	3
			"MT_LR_Restart"																4
			"Privacy Violation"														5
			"Shape of Location Estimate Not Supported"		6
			"Subscriber Termination"											7
			"UE Termination"															8
			"Network Termination"													9
		"MT_LR_Restart" cause code shall be used to trigger the GMLC to restart the location procedure,
		either because the sending node knows that the terminal has moved under coverage of another SGSN or MME,
		or because the subscriber has been deregistered due to a Cancel Location received from HSS.
		Any unrecognized value of Termination-Cause shall be treated the same as value 1 ("Error Undefined").
	*/
  public boolean hasTerminationCause();
  public int getTerminationCause();
  public void setTerminationCause(int terminationCause);

  /*
    From 3GPP TS 29.172 V13.0.0

    7.4.28	Serving-Node
    The Serving-Node AVP is of type Grouped. This AVP shall contain the information about the network node serving the targeted user.

  */
  public boolean hasServingNode();

}
