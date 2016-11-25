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
 * Defines an interface representing the LCS-Requestor-Name AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
 *
 * <pre>
 * 7.4.4	LCS-Requestor-Name
 * 	The LCS-Requestor-Name AVP is of type Grouped.
 *
 * 	AVP format:
 * 	LCS-Requestor-Name ::= <AVP header: 2502 10415>
 * 											[ LCS-Requestor-Id-String ]
 * 											[ LCS-Format-Indicator ]
 *
 *	The details of the LCS-Requestor-Id-String AVP and the LCS-Format-Indicator AVP are described in 3GPP TS 32.299 [10].
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface LCSRequestorNameAvp extends GroupedAvp {

  /*
    From 3GPP TS 32.299 (v14.1.0)

		7.2.92	LCS-Requestor-ID-String AVP
		The LCS-Requestor-ID-String AVP (AVP code 1240) is of type UTF8String and contains the identification of the Requestor and can be e.g. MSISDN or logical name.

  */
  public boolean hasLCSRequestorIDString();
  public String getLCSRequestorIDString();
  public void setLCSRequestorIDString(String lcsRequestorIDString);

  /*
		7.2.88	LCS-Format-Indicator AVP

		The LCS-Format-Indicator AVP (AVP code 1237) is of type Enumerated and contains the format of the LCS Client name. It can be one of the following values:

		0	LOGICAL_NAME
		1	EMAIL_ADDRESS
		2	MSISDN
		3	URL
		4	SIP_URL
	*/
  public boolean hasLCSFormatIndicator();
  public LCSFormatIndicator getLCSFormatIndicator();
  public void setLCSFormatIndicator(LCSFormatIndicator lcsFormatIndicator);

}

