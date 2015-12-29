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
 * Defines an interface representing the Call-Barring-Infor-List grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 *   7.3.101 Call-Barring-Infor-List
 *   The Call-Barring-Infor-List AVP is of type Grouped. This AVP shall contain the service codes for the short message
 *   related call barring services for a subscriber:
 *   AVP format
 *   Call-Barring-Infor-List ::= <AVP header: 1488 10415>
 *                               * { SS-Code }
 *                               * { SS-Status }
 *                               * [ AVP ]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface CallBarringInfoAvp extends GroupedAvp {
    /*
      7.3.87 SS-Code
      The SS-Code AVP is of type OctetString. Octets are coded according to 3GPP TS 29.002 [24].
     */
    public boolean hasSSCode();
    public byte[] getSSCode();
    public void setSSCode(byte[] ssCode);

    /*
      7.3.88 SS-Status
      The SS-Status AVP is of type OctetString. Octets are coded according to 3GPP TS 29.002 [24]. For details, see 3GPP
      TS 23.011 [29].
    */
    public boolean hasSSStatus();
    public byte[] getSSStatus();
    public void setSSStatus(byte[] ssStatus);
}