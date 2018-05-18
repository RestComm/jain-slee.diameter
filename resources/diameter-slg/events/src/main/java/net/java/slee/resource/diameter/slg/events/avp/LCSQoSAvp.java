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
 * Defines an interface representing the LCS-QoS AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V14.1.0) specification.
 * <p>
 * <pre>
 * 7.4.6		LCS-QoS
 * 	The LCS-QoS AVP is of type Grouped.
 *
 * 	AVP format:
 * 	LCS-QoS ::= <AVP header: 2504 10415>
 * 											[ LCS-QoS-Class ]
 * 											[ Horizontal-Accuracy ]
 * 											[ Vertical-Accuracy ]
 * 											[ Vertical-Requested ]
 * 											[ Response-Time]
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface LCSQoSAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V14.1.0

		7.4.27	LCS-QoS-Class
			The LCS-QoS-Class AVP is of the type Enumerated. The following values are defined.
				ASSURED (0)
			  BEST EFFORT (1)
  */
  boolean hasLCSQoSClass();

  LCSQoSClass getLCSQoSClass();

  void setLCSQoSClass(LCSQoSClass lcsQoSClass);

  /*
		From 3GPP TS 29.172 V14.1.0

		7.4.7	Horizontal-Accuracy
		The Horizontal-Accuracy AVP is of type Unsigned32.
		Bits 6-0 corresponds to Uncertainty Code defined in 3GPP TS 23.032 [3].
		The horizontal location error should be less than the error indicated by the uncertainty code with 67% confidence.
		Bits 7 to 31 shall be ignored.

	*/
  boolean hasHorizontalAccuracy();

  long getHorizontalAccuracy();

  void setHorizontalAccuracy(long horizontalAccuracy);

  /*
    From 3GPP TS 29.172 V14.1.0

    7.4.8	Vertical-Accuracy
    The Vertical-Accuracy AVP is of type Unsigned32.
    Bits 6-0 corresponds to Uncertainty Code defined in 3GPP TS 23.032 [3].
    The vertical location error should be less than the error indicated by the uncertainty code with 67% confidence.
    Bits 7 to 31 shall be ignored.
  */
  boolean hasVerticalAccuracy();

  long getVerticalAccuracy();

  void setVerticalAccuracy(long verticalAccuracy);

  /*
    From 3GPP TS 29.172 V14.1.0

    7.4.9	Vertical-Requested
      The Vertical-Requested AVP is of type Enumerated. The following values are defined:
        VERTICAL_COORDINATE_IS_NOT REQUESTED (0)
        VERTICAL_COORDINATE_IS_REQUESTED (1)
      Default value if AVP is not present is: VERTICAL_COORDINATE_IS_NOT_REQUESTED (0).
  */
  boolean hasVerticalRequested();

  VerticalRequested getVerticalRequested();

  void setVerticalRequested(VerticalRequested verticalRequested);

  /*
    From 3GPP TS 29.172 V14.1.0

    7.4.11	Response-Time
      The Response-Time AVP is of type Enumerated. The following values are defined:
        LOW_DELAY (0)
        DELAY_TOLERANT (1)
  */
  boolean hasResponseTime();

  ResponseTime getResponseTime();

  void setResponseTime(ResponseTime responseTime);

}

