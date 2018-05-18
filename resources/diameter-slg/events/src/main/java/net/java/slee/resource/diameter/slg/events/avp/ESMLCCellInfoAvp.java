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
 * 7.4.57		ESMLC-Cell-Info
 * 	The ESMLC-Cell-Info AVP is of type Grouped.
 *
 * 	AVP format:
 * 		ESMLC-Cell-Info ::= <AVP header: 2552 10415>
 * 												 [ ECGI ]
 * 												 [ Cell-Portion-ID ]
 * 												*[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface ESMLCCellInfoAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V14.1.0

		7.4.19	ECGI
		The ECGI AVP is of type OctetString. It indicates the E-UTRAN Cell Global Identifier.
		is coded according to clause 8.21.5, in 3GPP TS 29.274 [8].
  */
  boolean hasECGI();

  byte[] getECGI();

  void setECGI(byte[] ecgi);

  /*
		From 3GPP TS 29.172 V14.1.0

		7.4.58	Cell-Portion-ID
		The Cell-Portion-ID AVP is of type Unsigned32.
		It indicates the current Cell Portion location of the target UE as provided by the E-SMLC.
		It shall contain the value of the "Cell Portion ID" Information Element as defined in 3GPP TS 29.171 [7].
	*/
  boolean hasCellPortionID();

  long getCellPortionID();

  void setCellPortionID(long cellPortionID);

}
