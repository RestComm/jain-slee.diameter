/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.java.slee.resource.diameter.s6a.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Area-Scope grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.138 Area-Scope
 *
 * The Area-Scope AVP is of type Grouped. See 3GPP TS 32.422 [23].
 * The AVP format shall conform to:
 *
 *      Area-Scope ::= <AVP header: 1623 10415>
 *                      *[ Cell-Global-Identity ]
 *                      *[ E-UTRAN-Cell-Global-Identity ]
 *                      *[ Routing-Area-Identity ]
 *                      *[ Location-Area-Identity ]
 *                      *[ Tracking-Area-Identity ]
 *                      *[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface AreaScopeAvp extends GroupedAvp {
    /*
        7.3.119 Cell-Global-Identity
        The Cell-Global-Identity AVP is of type OctetString and shall contain the Cell Global Identification of the user which
        identifies the cell the user equipment is registered, as specified in 3GPP TS 23.003 [3]. Octets are coded as described in
        3GPP TS 29.002 [24].
     */
    public boolean hasCellGlobalIdentity();
    public void setCellGlobalIdentity(byte[] cellGlobalIdentity);
    public byte[][] getCellGlobalIdentities();
    public void setCellGlobalIdentities(byte[][] cellGlobalIdentities);

    /*
        7.3.117 E-UTRAN-Cell-Global-Identity
        The E-UTRAN-Cell-Global-Identity AVP is of type OctetString and shall contain the E-UTRAN Cell Global
        Identification of the user which identifies the cell the user equipment is registered, as specified in 3GPP TS 23.003 [3].
        Octets are coded as described in 3GPP TS 29.002 [24].
     */
    public boolean hasEUTRANCellGlobalIdentity();
    public void setEUTRANCellGlobalIdentity(byte[] eutranCellGlobalIdentity);
    public byte[][] getEUTRANCellGlobalIdentities();
    public void setEUTRANCellGlobalIdentities(byte[][] eutranCellGlobalIdentities);

    /*
        7.3.120 Routing-Area-Identity
        The Routing-Area-Identity AVP is of type OctetString and shall contain the Routing Area Identity of the user which
        identifies the routing area where the user is located, as specified in 3GPP TS 23.003 [3]. Octets are coded as described
        in 3GPP TS 29.002 [24].
     */
    public boolean hasRoutingAreaIdentity();
    public void setRoutingAreaIdentity(byte[] routingAreaIdentity);
    public byte[][] getRoutingAreaIdentities();
    public void setRoutingAreaIdentities(byte[][] routingAreaIdentities);

    /*
        7.3.121 Location-Area-Identity
        The Location-Area-Identity AVP is of type OctetString and shall contain the Location Area Identification of the user
        which identifies the Location area where the user is located, as specified in 3GPP TS 23.003 [3]. Octets are coded as
        described in 3GPP TS 29.002 [24].
     */
    public boolean hasLocationAreaIdentity();
    public void setLocationAreaIdentity(byte[] locationAreaIdentity);
    public byte[][] getLocationAreaIdentities();
    public void setLocationAreaIdentities(byte[][] locationAreaIdentities);

    /*
        7.3.118 Tracking-Area-Identity
        The Tracking-Area-Identity AVP is of type OctetString and shall contain the Tracking Area Identity of the user which
        identifies the tracking area where the user is located, as specified in 3GPP TS 23.003 [3]. Octets are coded as described
        in 3GPP TS 29.002 [24].
     */
    public boolean hasTrackingAreaIdentity();
    public void setTrackingAreaIdentity(byte[] trackingAreaIdentity);
    public byte[][] getTrackingAreaIdentities();
    public void setTrackingAreaIdentities(byte[][] trackingAreaIdentities);
}