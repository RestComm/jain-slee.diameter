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

import java.util.Date;

/**
 * Defines an interface representing the WLAN-offloadavility grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.3.181 WLAN-offloadability
 *
 * The WLAN-offloadability AVP is of type Grouped. This AVP contains WLAN offloadability for E-UTRAN or
 * UTRAN.
 *
 * AVP format:
 *      WLAN-offloadability ::= <AVP header: 1667>
 *                              [ WLAN-offloadability-EUTRAN ]
 *                              [ WLAN-offloadability-UTRAN ]
 *                             *[ AVP ]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface WLANoffloadabilityAvp extends GroupedAvp {

    /*
        7.3.182 WLAN-offloadability-EUTRAN
        The WLAN-offloadability-EUTRAN AVP is of type Unsigned32 and it shall contain a bitmask. The meaning of the
        bits is defined in table 7.3.182/1:
     */
    public boolean hasWLANoffloadabilityEUTRAN();
    public byte[] getWLANoffloadabilityEUTRAN();
    public void setWLANoffloadabilityEUTRAN(byte[] wlaNoffloadabilityEUTRAN);

    /*
        7.3.183 WLAN-offloadability-UTRAN
        The WLAN-offloadability-UTRAN AVP is of type Unsigned32 and it shall contain a bitmask. The meaning of the bits
        is defined in table 7.3.183/1:
     */
    public boolean hasWLANoffloadabilityUTRAN();
    public byte[] getWLANoffloadabilityUTRAN();
    public void setWLANoffloadabilityUTRAN(byte[] wlaNoffloadabilityUTRAN);
}