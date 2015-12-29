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

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Area-Scope grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 32.299 V12.8.0) specification:
 *
 * <pre>
 * 7.2.240A User-CSG-Information AVP
 *
 * The User-CSG-Information AVP (AVP code 2319) is of type Grouped and holds the user "Closed Subscriber Group"
 * information associated to CSG cell access: it comprises CSG ID within the PLMN, access mode and indication on CSG
 * membership for the user when hybrid access applies, as defined in TS 29.060 [225] for GPRS case, and in TS 29.274
 * [226] for EPC case.
 *
 * It has the following ABNF grammar:
 *          User-CSG-Information :: = < AVP Header: 2319>
 *                                      { CSG-Id }
 *                                      { CSG-Access-Mode }
 *                                      [ CSG-Membership-Indication ]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface UserCSGInformationAvp extends GroupedAvp {

    /*
        7.3.79 CSG-Id
        The CSG-Id AVP is of type Unsigned32. Values are coded according to 3GPP TS 23.003 [3]. Unused bits (least
        significant) shall be padded with zeros.
     */
    public boolean hasCSGId();
    public long getCSGId();
    public void setCSGId(long csgId);

    /*
        7.2.46A CSG-Access-Mode AVP
        The CSG-Access-Mode AVP (AVP code 2317) is of type Enumerated and holds the mode in which the CSG cell User is
        accessing to, operates
     */
    public boolean hasCSGAccessMode();
    public CSGAccessMode getCSGAccessMode();
    public void setCSGAccessMode(CSGAccessMode csgAccessMode);

    /*
        7.2.46B CSG-Membership-Indication AVP
        The CSG-Membership-Indication AVP (AVP code 2318) is of type Enumerated, and indicates the UE is a member of
        the accessing CSG cell, if the access mode is Hybrid, as described in TS 29.060 [225], and in TS 29.274 [226]
     */
    public boolean hasCSGMembershipIndication();
    public CSGMembershipIndication getCSGMembershipIndication();
    public void setCSGMembershipIndication(CSGMembershipIndication csgMembershipIndication);
}