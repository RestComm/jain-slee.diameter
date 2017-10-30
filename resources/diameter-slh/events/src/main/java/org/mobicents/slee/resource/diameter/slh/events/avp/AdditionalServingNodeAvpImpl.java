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

package org.mobicents.slee.resource.diameter.slh.events.avp;

import net.java.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvp;
import net.java.slee.resource.diameter.slh.events.avp.LCSRoutingInfoAVPCodes;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

/**
 * Implementation for {@link net.java.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class AdditionalServingNodeAvpImpl extends GroupedAvpImpl implements AdditionalServingNodeAvp {

  public AdditionalServingNodeAvpImpl() {
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
  public AdditionalServingNodeAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasAdditionalSGSNNumber() {
    return hasAvp(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public byte[] getAdditionalSGSNNumber() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public void setAdditionalSGSNNumber(byte[] additionalSgsnNumber) {
    addAvp(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalSgsnNumber);
  }

  public boolean hasAdditionalSGSNName() {
    return hasAvp(LCSRoutingInfoAVPCodes.SGSN_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public DiameterIdentity getAdditionalSGSNName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.SGSN_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public void setAdditionalSGSNName(DiameterIdentity additionalSGSNName) {
    addAvp(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalSGSNName);
  }

  public boolean hasAdditionalSGSNRealm() {
    return hasAvp(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public DiameterIdentity getAdditionalSGSNRealm() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public void setAdditionalSGSNRealm(DiameterIdentity additionalSgsnRealm) {
    addAvp(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalSgsnRealm);
  }

  public boolean hasAdditionalMMEName() {
    return hasAvp(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public DiameterIdentity getAdditionalMMEName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public void setAdditionalMMEName(DiameterIdentity additionalMmeName) {
    addAvp(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalMmeName);
  }

  public boolean hasAdditionalMMERealm() {
    return hasAvp(LCSRoutingInfoAVPCodes.MME_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public DiameterIdentity getAdditionalMMERealm() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.MME_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public void setAdditionalMMERealm(DiameterIdentity additionalMmeRealm) {
    addAvp(LCSRoutingInfoAVPCodes.MME_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalMmeRealm);
  }

  public boolean hasAdditionalMSCNumber() {
    return hasAvp(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public byte[] getAdditionalMSCNumber() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public void setAdditionalMSCNumber(byte[] additionalMscNumber) {
    addAvp(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalMscNumber);
  }

  public boolean hasAdditionalLcsCapabilitiesSets() {
    return hasAvp(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public long getAdditionalLcsCapabilitiesSets() {
    return getAvpAsUnsigned32(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public void setAdditionalLcsCapabilitiesSets(long lcsCapabilitiesSets) {
    addAvp(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, lcsCapabilitiesSets);
  }

  public boolean hasAdditional3GPPAAAServerName() {
    return hasAvp(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public DiameterIdentity getAdditional3GPPAAAServerName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public void setAdditional3GPPAAAServerName(DiameterIdentity additional3gppAAAServerName) {
    addAvp(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additional3gppAAAServerName);
  }

  public boolean hasAdditionalGMLCAddress() {
    return hasAvp(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public Address getAdditionalGMLCAddress() {
    return getAvpAsAddress(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  public void setAdditionalGMLCAddress(Address additionalGmlcAddress) {
    addAvp(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalGmlcAddress);
  }

}

