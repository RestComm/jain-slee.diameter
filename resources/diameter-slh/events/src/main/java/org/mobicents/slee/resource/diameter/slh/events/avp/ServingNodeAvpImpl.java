/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.diameter.slh.events.avp;

import net.java.slee.resource.diameter.slh.events.avp.LCSRoutingInfoAVPCodes;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import net.java.slee.resource.diameter.slh.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

/**
 * Implementation for {@link net.java.slee.resource.diameter.slh.events.avp.ServingNodeAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class ServingNodeAvpImpl extends GroupedAvpImpl implements ServingNodeAvp {

  public ServingNodeAvpImpl() {
    super();
  }

  public ServingNodeAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasSGSNNumber() {
    return hasAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SGSN_NUMBER);
  }

  public byte[] getSGSNNumber() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SGSN_NUMBER);
  }

  public void setSGSNNumber(byte[] sgsnNumber) {
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, sgsnNumber);
  }

  public boolean hasSGSNName() {
    return hasAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SGSN_NAME);
  }

  public Address getSGSNName() {
    return getAvpAsAddress(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SGSN_NAME);
  }

  public void setSGSNNumber(Address sgsnName) {
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, sgsnName);
  }

  public boolean hasSGSNRealm() {
    return hasAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SGSN_REALM);
  }

  public DiameterIdentity getSGSNRealm() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SGSN_REALM);
  }

  public void setSGSNRealm(DiameterIdentity sgsnRealm) {
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, sgsnRealm);
  }

  public boolean hasMMEName() {
    return hasAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.MME_NAME);
  }

  public Address getMMEName() {
    return getAvpAsAddress(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.MME_NAME);
  }

  public void setMMENumber(Address mmeName) {
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, mmeName);
  }

  public boolean hasMMERealm() {
    return hasAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.MME_REALM);
  }

  public Address getMMERealm() {
    return getAvpAsAddress(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.MME_REALM);
  }

  public void setMMERealm(Address mmeRealm) {
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, mmeRealm);
  }

  public boolean hasMSCNumber() {
    return hasAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.MSC_NUMBER);
  }

  public byte[] getMSCNumber() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.MSC_NUMBER);
  }

  public void setMSCNumber(byte[] mscNumber) {
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, mscNumber);
  }

  public boolean has3GPPAAAServerName() {
    return hasAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME);
  }

  public DiameterIdentity get3GPPAAAServerName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME);
  }

  public void set3GPPAAAServerName(DiameterIdentity tgppAAAServerName) {
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, tgppAAAServerName);
  }

  public boolean hasGMLCAddress() {
    return hasAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.GMLC_ADDRESS);
  }

  public Address getGMLCAddress() {
    return getAvpAsAddress(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.GMLC_ADDRESS);
  }

  public void setGMLCAddress(Address gmlcAddress) {
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, gmlcAddress);
  }

}

