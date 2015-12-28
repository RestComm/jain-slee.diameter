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

import net.java.slee.resource.diameter.base.events.avp.DiameterResultCode;
import net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes;
import net.java.slee.resource.diameter.s6a.events.avp.GERANVectorAvp;
import net.java.slee.resource.diameter.s6a.events.avp.UTRANVectorAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

import java.awt.*;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.GERANVectorAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class GERANVectorAvpImpl extends GroupedAvpImpl implements GERANVectorAvp {

    public GERANVectorAvpImpl() {
        super();
    }

    public GERANVectorAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public long getItemNumber() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.ITEM_NUMBER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setItemNumber(long itemNumber) {
        addAvp(DiameterS6aAvpCodes.ITEM_NUMBER, DiameterS6aAvpCodes.S6A_VENDOR_ID, itemNumber);
    }

    public boolean hasItemNumber() {
        return hasAvp(DiameterS6aAvpCodes.ITEM_NUMBER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public boolean hasRAND() {
        return hasAvp(DiameterS6aAvpCodes.RAND, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getRAND() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.RAND, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setRAND(byte[] rand) {
        addAvp(DiameterS6aAvpCodes.RAND, DiameterS6aAvpCodes.S6A_VENDOR_ID, rand);
    }

    public boolean hasSRES() {
        return hasAvp(DiameterS6aAvpCodes.SRES, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getSRES() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.SRES, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setSRES(byte[] sres) {
        addAvp(DiameterS6aAvpCodes.SRES, DiameterS6aAvpCodes.S6A_VENDOR_ID, sres);
    }

    public boolean hasKc() {
        return hasAvp(DiameterS6aAvpCodes.KC, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getKc() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.KC, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setKc(byte[] kc) {
        addAvp(DiameterS6aAvpCodes.KC, DiameterS6aAvpCodes.S6A_VENDOR_ID, kc);
    }
}