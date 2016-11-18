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
 * Defines an interface representing the GERAN-Positioning-Info AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
 *
 * <pre>
 * 7.4.29	GERAN-Positioning-Info
 * 	The GERAN-Positioning-Info AVP is of type Grouped.
 *
 * 	AVP format:
 * 	GERAN-Positioning-Info ::= <AVP header: 2524 10415>
 * 													[ GERAN-Positioning-Data ]
 * 													[ GERAN-GANSS-Positioning-Data ]
 * 													*[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface GERANPositioningInfoAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V13.0.0

		7.4.30	GERAN-Positioning-Data
		The GERAN-Positioning-Data AVP is of type OctetString.
		It shall contain the encoded content of the "Positioning Data" Information Element as defined in 3GPP TS 49.031 [20].
  */
  public boolean hasGERANPositioningData();
  public byte[] getGERANPositioningData();
  public void setGERANPositioningData(byte[] geranPositioningData);

  /*
		From 3GPP TS 29.172 V13.0.0

		7.4.31	GERAN-GANSS-Positioning-Data
		The GERAN-GANSS-Positioning-Data AVP is of type OctetString.
		It shall contain the encoded content of the "GANSS Positioning Data" Information Element as defined in 3GPP TS 49.031 [20].

	*/
  public boolean hasGERANGANSSPositioningData();
  public byte[] getGERANGANSSPositioningData();
  public void setGERANGANSSPositioningData(byte[] geranGANSSPositioningData);

}
