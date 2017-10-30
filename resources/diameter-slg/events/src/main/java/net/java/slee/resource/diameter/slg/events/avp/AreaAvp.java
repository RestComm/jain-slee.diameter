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
 * Defines an interface representing the Area AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
 *
 * <pre>
 * 7.4.40	Area
 * The Area AVP is of type Grouped.
 * 	AVP format:
 * 						Area ::= <AVP header: 2535 10415>
 * 										{ Area-Type }
 * 										{ Area-Identification }
 *										*[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface AreaAvp extends GroupedAvp {

  /*
    7.4.41	Area-Type
    The Area-Type AVP is of type Unsigned32. The following values are defined:
			"Country Code"			0
			"PLMN ID"						1
			"Location Area ID"	2
			"Routing Area ID"		3
			"Cell Global ID"		4
			"UTRAN Cell ID"			5
  */
  public boolean hasAreaType();
  public long getAreaType();
  public void setAreaType(long areaType);

  /*
		From 3GPP TS 29.172 V13.0.0

		7.4.42	Area-Identification
		The Area-Identification AVP is of type OctetString and shall contain the identification
		of the area applicable for the change of area event based deferred location reporting.
		Octets are coded as described in 3GPP TS 29.002 [24].
	*/
  public boolean hasAreaIdentification();
  public byte[] getAreaIdentification();
  public void setAreaIdentification(byte[] areaIdentification);

}
