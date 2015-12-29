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
 * Defines an interface representing the CSG-Subscription-Data grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 *  7.3.78 CSG-Subscription-Data
 *  The CSG-Subscription-Data AVP is of type Grouped. This AVP shall contain the CSG-Id and optionally an associated
 *  expiration date.
 *  AVP format
 *     CSG-Subscription-Data ::= <AVP header: 1436 10415>
 *     { CSG-Id }
 *     [ Expiration-Date ]
 *     *[ Service-Selection ]
 *     [ Visited-PLMN-Id ]
 *     *[AVP]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface CSGSubscriptionDataAvp extends GroupedAvp {
    /*
        7.3.79 CSG-Id
        The CSG-Id-Data AVP is of type Unsigned32. Values are coded according to 3GPP TS 23.003 [3]. Unused bits (least
        significant) shall be padded with zeros.
    */
    public boolean hasCSGId();
    public long getCSGId();
    public void setCSGId(long csgId);

    /*
        7.3.80 Expiration-Date
        The Expiration-Date AVP is of type Time (see IETF RFC 3588 [4]) and contains the point in time when subscription to
        the CSG-Id expires.
    */
    public boolean hasExpirationDate();
    public Date getExpirationDate();
    public void setExpirationDate(Date expirationDate);

    /*
        7.3.36 Service-Selection
        The Service-Selection AVP is of type of UTF8String. This AVP shall contain either the APN Network Identifier (i.e. an
        APN without the Operator Identifier) per 3GPP TS 23.003 [3], clauses 9.1 & 9.1.1, or this AVP shall contain the wild
        card value per 3GPP TS 23.003 [3], clause 9.1.2, and 3GPP TS 23.008 [30], clause 2.13.6).
    */
    public boolean hasServiceSelection();
    public void setServiceSelection(String serviceSelection);
    public String[] getServiceSelections();
    public void setServiceSelections(String[] serviceSelection);

    /*
        7.3.9 Visited-PLMN-Id
        The Visited-PLMN-Id AVP is of type OctetString. This AVP shall contain the concatenation of MCC and MNC. See
        3GPP TS 23.003 [3]. The content of this AVP shall be encoded as an octet string according to table 7.3.9-1.
     */
    public boolean hasVisitedPLMNId();
    public byte[] getVisitedPLMNId();
    public void setVisitedPLMNId(byte[] visitedPLMNId);
}