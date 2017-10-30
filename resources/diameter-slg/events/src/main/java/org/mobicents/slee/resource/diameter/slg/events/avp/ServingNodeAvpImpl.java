/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
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
 */

package org.mobicents.slee.resource.diameter.slg.events.avp;

import net.java.slee.resource.diameter.slg.events.avp.EPCLocationProtocolAVPCodes;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

/**
 * Implementation for {@link net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class ServingNodeAvpImpl extends GroupedAvpImpl implements ServingNodeAvp {

  public ServingNodeAvpImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public ServingNodeAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasSGSNNumber() {
    return hasAvp(EPCLocationProtocolAVPCodes.SGSN_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public byte[] getSGSNNumber() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.SGSN_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setSGSNNumber(byte[] sgsnNumber) {
    addAvp(EPCLocationProtocolAVPCodes.SGSN_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, sgsnNumber);
  }

  public boolean hasSGSNName() {
    return hasAvp(EPCLocationProtocolAVPCodes.SGSN_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity getSGSNName() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.SGSN_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setSGSNName(DiameterIdentity sgsnName) {
    addAvp(EPCLocationProtocolAVPCodes.SGSN_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, sgsnName);
  }

  public boolean hasSGSNRealm() {
    return hasAvp(EPCLocationProtocolAVPCodes.SGSN_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity getSGSNRealm() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.SGSN_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setSGSNRealm(DiameterIdentity sgsnRealm) {
    addAvp(EPCLocationProtocolAVPCodes.SGSN_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, sgsnRealm);
  }

  public boolean hasMMEName() {
    return hasAvp(EPCLocationProtocolAVPCodes.MME_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity getMMEName() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.MME_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setMMENumber(DiameterIdentity mmeName) {
    addAvp(EPCLocationProtocolAVPCodes.MME_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, mmeName);
  }

  public boolean hasMMERealm() {
    return hasAvp(EPCLocationProtocolAVPCodes.MME_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity getMMERealm() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.MME_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setMMERealm(DiameterIdentity mmeRealm) {
    addAvp(EPCLocationProtocolAVPCodes.MME_REALM, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, mmeRealm);
  }

  public boolean hasMSCNumber() {
    return hasAvp(EPCLocationProtocolAVPCodes.MSC_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public byte[] getMSCNumber() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.MSC_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setMSCNumber(byte[] mscNumber) {
    addAvp(EPCLocationProtocolAVPCodes.MSC_NUMBER, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, mscNumber);
  }

  public boolean has3GPPAAAServerName() {
    return hasAvp(EPCLocationProtocolAVPCodes.TGPP_AAA_SERVER_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity get3GPPAAAServerName() {
    return getAvpAsDiameterIdentity(EPCLocationProtocolAVPCodes.TGPP_AAA_SERVER_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void set3GPPAAAServerName(DiameterIdentity tgppAAAServerName) {
    addAvp(EPCLocationProtocolAVPCodes.TGPP_AAA_SERVER_NAME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, tgppAAAServerName);
  }

  public boolean hasLcsCapabilitiesSets() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_CAPABILITIES_SETS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public long getLcsCapabilitiesSets() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LCS_CAPABILITIES_SETS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setLcsCapabilitiesSets(long lcsCapabilitiesSets) {
    addAvp(EPCLocationProtocolAVPCodes.LCS_CAPABILITIES_SETS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lcsCapabilitiesSets);
  }

  public boolean hasGMLCAddress() {
    return hasAvp(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public Address getGMLCAddress() {
    return getAvpAsAddress(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setGMLCAddress(Address gmlcAddress) {
    addAvp(EPCLocationProtocolAVPCodes.GMLC_ADDRESS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, gmlcAddress);
  }

}

