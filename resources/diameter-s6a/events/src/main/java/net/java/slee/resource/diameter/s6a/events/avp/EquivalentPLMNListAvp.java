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
 * Defines an interface representing the Equivalent-PLMN-List grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.3.151 Equivalent-PLMN-List
 *
 * The Equivalent-PLMN-List AVP is of type Grouped. This AVP shall contain the equivalent PLMN IDs of the
 * registered PLMN (i.e. the visited PLMN) of the MME or the SGSN.
 *
 * AVP format
 *     Equivalent-PLMN-List ::= <AVP header: 1637 10415>
 *                              *{ Visited-PLMN-Id }
 *                              *[AVP]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface EquivalentPLMNListAvp extends GroupedAvp {

    /*
        The Visited-PLMN-Id AVP is of type OctetString. This AVP shall contain the concatenation of MCC and MNC. See
        3GPP TS 23.003 [3]. The content of this AVP shall be encoded as an octet string according to table 7.3.9-1.
     */
    public boolean hasVisitedPLMNId();
    public byte[] getVisitedPLMNId();
    public void setVisitedPLMNId(byte[] visitedPLMNId);

}