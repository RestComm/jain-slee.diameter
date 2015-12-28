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
 * Defines an interface representing the VPLMN-CSG-Subscription-Data grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 *  7.3.155 VPLMN-CSG-Subscription-Data
 *
 * The VPLMN-CSG-Subscription-Data AVP is of type Grouped. This AVP shall contain the CSG-Id, and optionally an
 * associated expiration date.
 * AVP format
 *      VPLMN-CSG-Subscription-Data ::= <AVP header: 1641 10415>
 *                                      { CSG-Id }
 *                                      [ Expiration-Date ]
 *                                      *[AVP]
 *
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface VPLMNCSGSubscriptionDataAvp extends GroupedAvp {

    /*
        7.3.79 CSG-Id
        The CSG-Id AVP is of type Unsigned32. Values are coded according to 3GPP TS 23.003 [3]. Unused bits (least
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
}