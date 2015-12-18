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

import net.java.slee.resource.diameter.s6a.events.avp.AMBRAvp;
import net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes;
import net.java.slee.resource.diameter.s6a.events.avp.MOLRAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.MOLRAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class MOLRAvpImpl extends GroupedAvpImpl implements MOLRAvp {

    public MOLRAvpImpl() {
        super();
    }

    public MOLRAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public boolean hasSSCode() {
        return hasAvp(DiameterS6aAvpCodes.SS_CODE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getSSCode() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.SS_CODE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setSSCode(byte[] ssCode) {
        addAvp(DiameterS6aAvpCodes.SS_CODE, DiameterS6aAvpCodes.S6A_VENDOR_ID, ssCode);
    }

    public boolean hasSSStatus() {
        return hasAvp(DiameterS6aAvpCodes.SS_STATUS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getSSStatus() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.SS_STATUS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setSSStatus(byte[] ssStatus) {
        addAvp(DiameterS6aAvpCodes.SS_STATUS, DiameterS6aAvpCodes.S6A_VENDOR_ID, ssStatus);
    }
}