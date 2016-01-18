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

package org.mobicents.slee.resource.diameter.cxdx.events.avp;


import net.java.slee.resource.diameter.cxdx.events.avp.DiameterCxDxAvpCodes;
import net.java.slee.resource.diameter.cxdx.events.avp.IdentitywithEmergencyRegistration;
import org.jdiameter.api.Avp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 *
 * IdentitywithEmergencyRegistrationImpl.java
 *
 *
 */
public class IdentitywithEmergencyRegistrationImpl extends GroupedAvpImpl implements IdentitywithEmergencyRegistration {

  public IdentitywithEmergencyRegistrationImpl() {
    super();
  }

  /**
   *
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public IdentitywithEmergencyRegistrationImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

    public boolean hasUserName() {
        return hasAvp(Avp.USER_NAME, DiameterCxDxAvpCodes.CXDX_VENDOR_ID);
    }

    public String getUserName() {
        return getAvpAsUTF8String(Avp.USER_NAME, DiameterCxDxAvpCodes.CXDX_VENDOR_ID);
    }

    public void setUserName(String userName) {
        addAvp(Avp.USER_NAME, userName);
    }

    public boolean hasPublicIdentity() {
        return hasAvp(DiameterCxDxAvpCodes.PUBLIC_IDENTITY, DiameterCxDxAvpCodes.CXDX_VENDOR_ID);
    }

    public String getPublicIdentity() {
        return getAvpAsUTF8String(DiameterCxDxAvpCodes.PUBLIC_IDENTITY, DiameterCxDxAvpCodes.CXDX_VENDOR_ID);
    }

    public void setPublicIdentity(String publicIdentity) {
        addAvp(DiameterCxDxAvpCodes.PUBLIC_IDENTITY, DiameterCxDxAvpCodes.CXDX_AUTH_APP_ID, publicIdentity);
    }
}