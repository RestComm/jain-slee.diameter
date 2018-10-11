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
 * Defines an interface representing the Area AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V14.1.0) specification.
 * <p>
 * <pre>
 * 7.4.40	Area
 * The Area AVP is of type Grouped.
 * 	AVP format:
 * 						Area ::= <AVP header: 2535 10415>
 *                     { Area-Type }
 *                     { Area-Identification }
 * 										*[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface AreaAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V14.1.0

    7.4.41	Area-Type
    The Area-Type AVP is of type Unsigned32. The following values are defined:
			"Country Code"			      0
			"PLMN ID"						      1
			"Location Area ID"	      2
			"Routing Area ID"		      3
			"Cell Global ID"		      4
			"UTRAN Cell ID"			      5
			"Tracking Area ID"				6
      "E-UTRAN Cell Global ID"	7
  */
  boolean hasAreaType();

  long getAreaType();

  void setAreaType(long areaType);

  /*
		From 3GPP TS 29.172 V14.1.0

		7.4.42	Area-Identification
		The Area-Identification AVP is of type OctetString and shall contain the identification of the area applicable for the change
		of area event based deferred location reporting. For Area-Type 0 to 5, octets are coded as described in 3GPP TS 29.002 [24].
		For Area-Type 6, octets are coded as defined for the Tracking Area Identity area identification in 3GPP TS 24.080 [24].
		For Area-Type 7, octets are coded as defined for the ECGI area identification in 3GPP TS 24.080 [24].
		For a deferred EPC-MT-LR for the area event, only Area-Type 6 and 7 are applicable.
	*/
  boolean hasAreaIdentification();

  byte[] getAreaIdentification();

  void setAreaIdentification(byte[] areaIdentification);

}
