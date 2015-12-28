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

package org.mobicents.slee.resource.diameter.s6a.events.avp;

import net.java.slee.resource.diameter.s6a.events.avp.*;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.WLANoffloadabilityAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class UserCSGInformationAvpImpl extends GroupedAvpImpl implements UserCSGInformationAvp {

    public UserCSGInformationAvpImpl() {
        super();
    }

    public UserCSGInformationAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public boolean hasCSGId() {
        return hasAvp(DiameterS6aAvpCodes.CSG_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getCSGId() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.CSG_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setCSGId(long csgId) {
        addAvp(DiameterS6aAvpCodes.CSG_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID, csgId);
    }

    public boolean hasCSGAccessMode() {
        return hasAvp(DiameterS6aAvpCodes.CSG_ACCESS_MODE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public CSGAccessMode getCSGAccessMode() {
        return (CSGAccessMode) getAvpAsEnumerated(DiameterS6aAvpCodes.CSG_ACCESS_MODE, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                                                  CSGAccessMode.class);
    }

    public void setCSGAccessMode(CSGAccessMode csgAccessMode) {
        addAvp(DiameterS6aAvpCodes.CSG_ACCESS_MODE, DiameterS6aAvpCodes.S6A_VENDOR_ID, csgAccessMode.getValue());
    }

    public boolean hasCSGMembershipIndication() {
        return hasAvp(DiameterS6aAvpCodes.CSG_MEMBERSHIP_INDICATION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public CSGMembershipIndication getCSGMembershipIndication() {
        return (CSGMembershipIndication) getAvpAsEnumerated(DiameterS6aAvpCodes.CSG_MEMBERSHIP_INDICATION,
                                                            DiameterS6aAvpCodes.S6A_VENDOR_ID,
                                                            CSGMembershipIndication.class);
    }

    public void setCSGMembershipIndication(CSGMembershipIndication csgMembershipIndication) {
        addAvp(DiameterS6aAvpCodes.CSG_MEMBERSHIP_INDICATION, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               csgMembershipIndication.getValue());
    }
}