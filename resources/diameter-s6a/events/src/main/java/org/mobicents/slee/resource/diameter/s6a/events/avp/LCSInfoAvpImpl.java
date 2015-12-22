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
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.LCSInfoAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class LCSInfoAvpImpl extends GroupedAvpImpl implements LCSInfoAvp {

    public LCSInfoAvpImpl() {
        super();
    }

    public LCSInfoAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public boolean hasGMLCNumber() {
        return hasAvp(DiameterS6aAvpCodes.GMLC_NUMBER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setGMLCNumber(byte[] gmlcNumber) {
        addAvp(DiameterS6aAvpCodes.GMLC_NUMBER, DiameterS6aAvpCodes.S6A_VENDOR_ID, gmlcNumber);
    }

    public byte[][] getGMLCNumbers() {
        return getAvpsAsOctetString(DiameterS6aAvpCodes.GMLC_NUMBER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setGMLCNumbers(byte[][] gmlcNumbers) {
        for (byte[] aux : gmlcNumbers) {
            setGMLCNumber(aux);
        }
    }

    public boolean hasLCSPrivacyException() {
        return hasAvp(DiameterS6aAvpCodes.LCS_PRIVACYEXCEPTION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setLCSPrivacyException(LCSPrivacyExceptionAvp lcsPrivacyException) {
        addAvp(lcsPrivacyException);
    }

    public LCSPrivacyExceptionAvp[] getLCSPrivacyExceptions() {
        return (LCSPrivacyExceptionAvp[]) getAvpsAsCustom(DiameterS6aAvpCodes.LCS_PRIVACYEXCEPTION,
                DiameterS6aAvpCodes.S6A_VENDOR_ID, LCSPrivacyExceptionAvpImpl.class);
    }

    public void setLCSPrivacyExceptions(LCSPrivacyExceptionAvp[] lcsPrivacyExceptionAvps) {
        for (LCSPrivacyExceptionAvp aux : lcsPrivacyExceptionAvps) {
            setLCSPrivacyException(aux);
        }
    }

    public boolean hasMOLR() {
        return hasAvp(DiameterS6aAvpCodes.MO_LR, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setMOLR(MOLRAvp molrAvp) {
        addAvp(molrAvp);
    }

    public MOLRAvp[] getMOLRs() {
        return (MOLRAvp[]) getAvpsAsCustom(DiameterS6aAvpCodes.MO_LR, DiameterS6aAvpCodes.S6A_VENDOR_ID, MOLRAvpImpl.class);
    }

    public void setMOLRs(MOLRAvp[] molrs) {
        for (MOLRAvp aux : molrs) {
            setMOLR(aux);
        }
    }
}