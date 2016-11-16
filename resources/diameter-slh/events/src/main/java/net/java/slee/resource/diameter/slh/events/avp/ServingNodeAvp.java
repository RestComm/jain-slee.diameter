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

package net.java.slee.resource.diameter.slh.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

/**
 * Defines an interface representing the Serving-Node grouped AVP type.
 * From the Diameter-based SLh interface for Control Plane LCS (3GPP TS 29.173 V13.0.0) specification:
 *
 * <pre>
 * 6.4.3 Serving-Node
 *
 * The Serving-Node AVP is of type Grouped. This AVP shall contain the information about the network node serving the
 * targeted user.
 *
 * AVP format
 *
 *				Serving-Node ::=	<AVP header: 2401 10415>
 *													[ SGSN-Number ]
 *													[ SGSN-Name ]
 *													[ SGSN-Realm ]
 *													[ MME-Name ]
 *													[ MME-Realm ]
 *													[ MSC-Number ]
 *													[ 3GPP-AAA-Server-Name ]
 *													[ LCS-Capabilities-Sets ]
 *													[ GMLC-Address ]
 *													*[AVP]
 *
 * The GMLC-Address AVP included in the Serving-Node grouped AVP shall contain, if present,
 * the IPv4 or IPv6 address of the GMLC associated with the serving node
 * (i.e., either the home GMLC or the visited GMLC, depending on the location of the serving node).
 * </pre>
 *
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */

public interface ServingNodeAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.272 (v12.9.0)

		7.3.102 SGSN-Number

		The SGSN-Number AVP is of type OctetString and it shall contain the ISDN number of the SGSN. For further details on the definition of this AVP,
		see 3GPP TS 23.003[3]. This AVP contains an SGSN-Number in international number format as described in ITU-T Rec E.164 [41] and shall be encoded
		as a TBCD-string. See 3GPP TS 29.002 [24] for encoding of TBCD-strings.
		This AVP shall not include leading indicators for the nature of address and the numbering plan;
		it shall contain only the TBCD-encoded digits of the address.
  */
  public boolean hasSGSNNumber();
  public byte[] getSGSNNumber();
  public void setSGSNNumber(byte[] sgsnNumber);

  /*
    From 3GPP TS 29.173 (v13.0.0)

    6.4.13	SGSN-Name

    The SGSN-Name AVP is of type DiameterIdentity and it shall contain the Diameter identity of the serving SGSN.
    For further details on the encoding of this AVP, see IETF RFC 3588 [5].
  */
  public boolean hasSGSNName();
  public Address getSGSNName();
  public void setSGSNNumber(Address sgsnName);


  /*
    From 3GPP TS 29.173 (v13.0.0)

    6.4.14	SGSN-Realm

    The SGSN-Realm AVP is of type DiameterIdentity and it shall contain the Diameter Realm Identity of the serving SGSN.
    For further details on the encoding of this AVP, see IETF RFC 3588 [5].
  */
  public boolean hasSGSNRealm();
  public DiameterIdentity getSGSNRealm();
  public void setSGSNRealm(DiameterIdentity sgsnRealm);

  /*
    From 3GPP TS 29.173 (v13.0.0)

    6.4.4	MME-Name

    The MME-Name AVP is of type DiameterIdentity and it shall contain the Diameter identity of the serving MME.
    For further details on the encoding of this AVP, see IETF RFC 3588 [5].
  */
  public boolean hasMMEName();
  public Address getMMEName();
  public void setMMENumber(Address mmeName);

  /*
    From 3GPP TS 29.173 (v13.0.0)

    6.4.12	MME-Realm

    The MME-Realm AVP is of type DiameterIdentity and it shall contain the Diameter Realm Identity of the serving MME.
    For further details on the encoding of this AVP, see IETF RFC 3588 [5].
  */
  public boolean hasMMERealm();
  public Address getMMERealm();
  public void setMMERealm(Address mmeRealm);

  /*
    From 3GPP TS 29.173 (v13.0.0)

    6.4.5	MSC-Number

    The MSC-Number AVP is of type OctetString and it shall contain the ISDN number of the serving MSC or MSC server
    in international number format as described in ITU-T Rec E.164 [15] and shall be encoded as a TBCD-string.
    See 3GPP TS 29.002 [3] for encoding of TBCD-strings.
  */
  public boolean hasMSCNumber();
  public byte[] getMSCNumber();
  public void setMSCNumber(byte[] mscNumber);

  /*
    From 3GPP TS 29.173 (v13.0.0)

    6.4.6	LCS-Capabilities-Sets

    The LCS-Capabilities-Sets AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits shall be as defined
    in 3GPP 29.002 [3].
  */
  public boolean hasLcsCapabilitiesSets();
  public long getLcsCapabilitiesSets();
  public void setLcsCapabilitiesSets(long lcsCapabilitiesSets);

  /*
    From 3GPP TS 29.273 (v14.0.0)

    8.2.3.24	3GPP-AAA-Server-Name

    The 3GPP-AAA-Server-Name AVP is of type DiameterIdentity, and defines the Diameter address of the 3GPP AAA Server node.
  */
  public boolean has3GPPAAAServerName();
  public DiameterIdentity get3GPPAAAServerName();
  public void set3GPPAAAServerName(DiameterIdentity tgppAAAServerName);

  /*
    From 3GPP TS 29.173 (v13.0.0)

    6.4.7	GMLC-Address

    The GMLC-Address AVP is of type Address and shall contain the IPv4 or IPv6 address of H-GMLC or the V-GMLC associated with the serving node.
  */
  public boolean hasGMLCAddress();
  public Address getGMLCAddress();
  public void setGMLCAddress(Address gmlcAddress);

}

