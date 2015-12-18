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

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes;
import net.java.slee.resource.diameter.s6a.events.avp.TraceDataAvp;
import net.java.slee.resource.diameter.s6a.events.avp.UTRANVectorAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

import java.awt.*;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.UTRANVectorAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class UTRANVectorAvpImpl extends GroupedAvpImpl implements UTRANVectorAvp {

    public UTRANVectorAvpImpl() {
        super();
    }

    public UTRANVectorAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
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

    public boolean hasXRES() {
        return hasAvp(DiameterS6aAvpCodes.XRES, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getXRES() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.XRES, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setXRES(byte[] xres) {
        addAvp(DiameterS6aAvpCodes.XRES, DiameterS6aAvpCodes.S6A_VENDOR_ID, xres);
    }

    public boolean hasAUTN() {
        return hasAvp(DiameterS6aAvpCodes.AUTN, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getAUTN() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.AUTN, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setAUTN(byte[] autn) {
        addAvp(DiameterS6aAvpCodes.AUTN, DiameterS6aAvpCodes.S6A_VENDOR_ID, autn);
    }

    public boolean hasConfidentialityKey() {
        return hasAvp(DiameterS6aAvpCodes.CONFIDENTIALITY_KEY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getConfidentialityKey() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.CONFIDENTIALITY_KEY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setConfidentialityKey(byte[] confidentialityKey) {
        addAvp(DiameterS6aAvpCodes.CONFIDENTIALITY_KEY, DiameterS6aAvpCodes.S6A_VENDOR_ID, confidentialityKey);
    }

    public boolean hasIntegrityKey() {
        return hasAvp(DiameterS6aAvpCodes.INTEGRITY_KEY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getIntegrityKey() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.INTEGRITY_KEY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setIntegrityKey(byte[] integrityKey) {
        addAvp(DiameterS6aAvpCodes.INTEGRITY_KEY, DiameterS6aAvpCodes.S6A_VENDOR_ID, integrityKey);
    }
}