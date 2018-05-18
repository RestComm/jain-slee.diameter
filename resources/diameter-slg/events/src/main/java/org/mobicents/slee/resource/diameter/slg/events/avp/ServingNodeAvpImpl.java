/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2018, Telestax Inc and individual contributors
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

import net.java.slee.resource.diameter.slg.events.avp.ELPAVPCodes;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

/**
 * Implementation for {@link ServingNodeAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
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
    return hasAvp(ELPAVPCodes.SGSN_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public byte[] getSGSNNumber() {
    return getAvpAsOctetString(ELPAVPCodes.SGSN_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setSGSNNumber(byte[] sgsnNumber) {
    addAvp(ELPAVPCodes.SGSN_NUMBER, ELPAVPCodes.SLg_VENDOR_ID, sgsnNumber);
  }

  public boolean hasSGSNName() {
    return hasAvp(ELPAVPCodes.SGSN_NAME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity getSGSNName() {
    return getAvpAsDiameterIdentity(ELPAVPCodes.SGSN_NAME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setSGSNName(DiameterIdentity sgsnName) {
    addAvp(ELPAVPCodes.SGSN_NAME, ELPAVPCodes.SLg_VENDOR_ID, sgsnName);
  }

  public boolean hasSGSNRealm() {
    return hasAvp(ELPAVPCodes.SGSN_REALM, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity getSGSNRealm() {
    return getAvpAsDiameterIdentity(ELPAVPCodes.SGSN_REALM, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setSGSNRealm(DiameterIdentity sgsnRealm) {
    addAvp(ELPAVPCodes.SGSN_REALM, ELPAVPCodes.SLg_VENDOR_ID, sgsnRealm);
  }

  public boolean hasMMEName() {
    return hasAvp(ELPAVPCodes.MME_NAME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity getMMEName() {
    return getAvpAsDiameterIdentity(ELPAVPCodes.MME_NAME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setMMEName(DiameterIdentity mmeName) {
    addAvp(ELPAVPCodes.MME_NAME, ELPAVPCodes.SLg_VENDOR_ID, mmeName);
  }

  public boolean hasMMERealm() {
    return hasAvp(ELPAVPCodes.MME_REALM, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity getMMERealm() {
    return getAvpAsDiameterIdentity(ELPAVPCodes.MME_REALM, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setMMERealm(DiameterIdentity mmeRealm) {
    addAvp(ELPAVPCodes.MME_REALM, ELPAVPCodes.SLg_VENDOR_ID, mmeRealm);
  }

  public boolean hasMSCNumber() {
    return hasAvp(ELPAVPCodes.MSC_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public byte[] getMSCNumber() {
    return getAvpAsOctetString(ELPAVPCodes.MSC_NUMBER, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setMSCNumber(byte[] mscNumber) {
    addAvp(ELPAVPCodes.MSC_NUMBER, ELPAVPCodes.SLg_VENDOR_ID, mscNumber);
  }

  public boolean has3GPPAAAServerName() {
    return hasAvp(ELPAVPCodes.TGPP_AAA_SERVER_NAME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public DiameterIdentity get3GPPAAAServerName() {
    return getAvpAsDiameterIdentity(ELPAVPCodes.TGPP_AAA_SERVER_NAME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void set3GPPAAAServerName(DiameterIdentity tgppAAAServerName) {
    addAvp(ELPAVPCodes.TGPP_AAA_SERVER_NAME, ELPAVPCodes.SLg_VENDOR_ID, tgppAAAServerName);
  }

  public boolean hasLcsCapabilitiesSets() {
    return hasAvp(ELPAVPCodes.LCS_CAPABILITIES_SETS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getLcsCapabilitiesSets() {
    return getAvpAsUnsigned32(ELPAVPCodes.LCS_CAPABILITIES_SETS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setLcsCapabilitiesSets(long lcsCapabilitiesSets) {
    addAvp(ELPAVPCodes.LCS_CAPABILITIES_SETS, ELPAVPCodes.SLg_VENDOR_ID, lcsCapabilitiesSets);
  }

  public boolean hasGMLCAddress() {
    return hasAvp(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public Address getGMLCAddress() {
    return getAvpAsAddress(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setGMLCAddress(Address gmlcAddress) {
    addAvp(ELPAVPCodes.GMLC_ADDRESS, ELPAVPCodes.SLg_VENDOR_ID, gmlcAddress);
  }

}

