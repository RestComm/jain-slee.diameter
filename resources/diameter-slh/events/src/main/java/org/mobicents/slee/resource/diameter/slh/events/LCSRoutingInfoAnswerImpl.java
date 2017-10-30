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

package org.mobicents.slee.resource.diameter.slh.events;

import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer;

import net.java.slee.resource.diameter.slh.events.avp.*;

/**
 * Implementation for {@link LCSRoutingInfoAnswer}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class LCSRoutingInfoAnswerImpl extends DiameterMessageImpl implements LCSRoutingInfoAnswer {

  /**
   * @param message
   */
  public LCSRoutingInfoAnswerImpl(Message message) {
    super(message);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasUserName()
   */
  @Override
  public boolean hasUserName() {
    return hasAvp(LCSRoutingInfoAVPCodes.USER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getUserName()
   */
  @Override
  public String getUserName() {
    return getAvpAsUTF8String(LCSRoutingInfoAVPCodes.USER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setUserName(java.lang.String)
   */
  @Override
  public void setUserName(String imsi) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.USER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, imsi);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasMSISDN()
   */
  @Override
  public boolean hasMSISDN() {
    return hasAvp(LCSRoutingInfoAVPCodes.MSISDN, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getMSISDN()
   */
  @Override
  public byte[] getMSISDN() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.MSISDN, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setMSISDN(byte[])
   */
  @Override
  public void setMSISDN(byte[] msisdn) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.MSISDN, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, msisdn);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasLMSI()
   */
  @Override
  public boolean hasLMSI() {
    return hasAvp(LCSRoutingInfoAVPCodes.LMSI, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getLMSI()
   */
  @Override
  public byte[] getLMSI() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.LMSI, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setLMSI(byte[])
   */
  @Override
  public void setLMSI(byte[] lmsi) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.LMSI, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, lmsi);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasServingNode()
   */
  @Override
  public boolean hasServingNode() {
    return hasAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getServingNode()
   */
  @Override
  public byte[] getServingNode() {
    return getAvpAsGrouped(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getServingNode()
   */
  @Override
  public void setServingNode(ServingNodeAvp servingNode){
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, servingNode);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasSGSNNumber(DiameterIdentity)
   */
  @Override
  public boolean hasSGSNNumber() {
    return hasAvp(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getSGSNNumber()
   */
  @Override
  public DiameterIdentity getSGSNNumber() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setSGSNNumber(DiameterIdentity)
   */
  @Override
  public void setSGSNNumber(DiameterIdentity sgsnNumber) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, sgsnNumber);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasSGSNName()
   */
  @Override
  public boolean hasSGSNName() {
    return hasAvp(LCSRoutingInfoAVPCodes.SGSN_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getSGSNName()
   */
  @Override
  public DiameterIdentity getSGSNName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.SGSN_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setSGSNName(DiameterIdentity)
   */
  @Override
  public void setSGSNName(DiameterIdentity sgsnName) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.SGSN_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, sgsnName);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasSGSNRealm()
   */
  @Override
  public boolean hasSGSNRealm() {
    return hasAvp(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getSGSNRealm()
   */
  @Override
  public DiameterIdentity getSGSNRealm() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setSGSNName(DiameterIdentity)
   */
  @Override
  public void setSGSNRealm(DiameterIdentity sgsnRealm) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, sgsnRealm);
  }


  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasMMEName()
   */
  @Override
  public boolean hasMMEName() {
    return hasAvp(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getMMEName()
   */
  @Override
  public DiameterIdentity getMMEName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setMMEName(DiameterIdentity)
   */
  @Override
  public void setMMEName(DiameterIdentity mmeName) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, mmeName);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasMMERealm()
   */
  @Override
  public boolean hasMMERealm() {
    return hasAvp(LCSRoutingInfoAVPCodes.MME_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getMMERealm()
   */
  @Override
  public DiameterIdentity getMMERealm() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.MME_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setMMEName(DiameterIdentity)
   */
  @Override
  public void setMMERealm(DiameterIdentity mmeRealm) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.MME_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, mmeRealm);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasMSCNumber()
   */
  @Override
  public boolean hasMSCNumber() {
    return hasAvp(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getMSCNumber()
   */
  @Override
  public byte[] getMSCNumber() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setMSCNumber(OctetString)
   */
  @Override
  public void setMSCNumber(byte[] mscNumber) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, mscNumber);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasMMERealm()
   */
  @Override
  public boolean has3GPPAAAServerName() {
    return hasAvp(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#get3GPPAAAServerName()
   */
  @Override
  public DiameterIdentity get3GPPAAAServerName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#set3GPPAAAServerName(DiameterIdentity)
   */
  @Override
  public void set3GPPAAAServerName(DiameterIdentity tgppAAAServerName) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, tgppAAAServerName);
  }

  /*
     * (non-Javadoc)
     * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasMMERealm()
     */
  @Override
  public boolean hasLCSCapabilitiesSets() {
    return hasAvp(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getLCSCapabilitiesSets()
   */
  @Override
  public long getLCSCapabilitiesSets() {
    return getAvpAsUnsigned32(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setLCSCapabilitiesSets(DiameterIdentity)
   */
  @Override
  public void setLCSCapabilitiesSets(long lcsCapabilitiesSets) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, lcsCapabilitiesSets);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasGMLCAddress()
   */
  @Override
  public boolean hasGMLCAddress() {
    return hasAvp(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getGMLCAddress()
   */
  @Override
  public Address getGMLCAddress() {
    return getAvpAsAddress(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setGMLCAddress(Address)
   */
  @Override
  public void setGMLCAddress(Address gmlcAddress) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, gmlcAddress);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasAdditionalServingNode()
   */
  @Override
  public boolean hasAdditionalServingNode() {
    return hasAvp(LCSRoutingInfoAVPCodes.ADDITIONAL_SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalServingNode()
   */
  @Override
  public byte[] getAdditionalServingNode() {
    return getAvpAsGrouped(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalServingNode()
   */
  @Override
  public void setAdditionalServingNode(AdditionalServingNodeAvp additionalServingNode){
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalServingNode);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasAdditionalSGSNNumber(DiameterIdentity)
   */
  @Override
  public boolean hasAdditionalSGSNNumber() {
    return hasAvp(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalSGSNNumber()
   */
  @Override
  public byte[] getAdditionalSGSNNumber() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setAdditionalSGSNNumber(DiameterIdentity)
   */
  @Override
  public void setAdditionalSGSNNumber(byte[] additionalSgsnNumber) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.SGSN_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalSgsnNumber);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasAdditionalSGSNName()
   */
  @Override
  public boolean hasAdditionalSGSNName() {
    return hasAvp(LCSRoutingInfoAVPCodes.SGSN_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalSGSNName()
   */
  @Override
  public DiameterIdentity getAdditionalSGSNName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.SGSN_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setAdditionalSGSNName(DiameterIdentity)
   */
  @Override
  public void setAdditionalSGSNName(DiameterIdentity additionalSgsnName) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.SGSN_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalSgsnName);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasAdditionalSGSNRealm()
   */
  @Override
  public boolean hasAdditionalSGSNRealm() {
    return hasAvp(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalSGSNRealm()
   */
  @Override
  public DiameterIdentity getAdditionalSGSNRealm() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setAdditionalSGSNName(DiameterIdentity)
   */
  @Override
  public void setAdditionalSGSNRealm(DiameterIdentity additionalSgsnRealm) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.SGSN_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalSgsnRealm);
  }


  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasAdditionalMMEName()
   */
  @Override
  public boolean hasAdditionalMMEName() {
    return hasAvp(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalMMEName()
   */
  @Override
  public DiameterIdentity getAdditionalMMEName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setMMEName(DiameterIdentity)
   */
  @Override
  public void setAdditionalMMEName(DiameterIdentity additionalMmeName) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.MME_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalMmeName);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasAdditionalMMERealm()
   */
  @Override
  public boolean hasAdditionalMMERealm() {
    return hasAvp(LCSRoutingInfoAVPCodes.MME_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalMMERealm()
   */
  @Override
  public DiameterIdentity getAdditionalMMERealm() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.MME_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setAdditionalMMEName(DiameterIdentity)
   */
  @Override
  public void setAdditionalMMERealm(DiameterIdentity additionalMmeRealm) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.MME_REALM, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalMmeRealm);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasAdditionalMSCNumber()
   */
  @Override
  public boolean hasAdditionalMSCNumber() {
    return hasAvp(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalMSCNumber()
   */
  @Override
  public byte[] getAdditionalMSCNumber() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setAdditionalMSCNumber(OctetString)
   */
  @Override
  public void setAdditionalMSCNumber(byte[] additionalMscNumber) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.MSC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalMscNumber);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasMMERealm()
   */
  @Override
  public boolean hasAdditional3GPPAAAServerName() {
    return hasAvp(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditional3GPPAAAServerName()
   */
  @Override
  public DiameterIdentity getAdditional3GPPAAAServerName() {
    return getAvpAsDiameterIdentity(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setAdditional3GPPAAAServerName(DiameterIdentity)
   */
  @Override
  public void setAdditional3GPPAAAServerName(DiameterIdentity additionalTgppAAAServerName) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.TGPP_AAA_SERVER_NAME, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalTgppAAAServerName);
  }

  /*
     * (non-Javadoc)
     * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasAdditionalLCSCapabilitiesSets()
     */
  @Override
  public boolean hasAdditionalLCSCapabilitiesSets() {
    return hasAvp(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalLCSCapabilitiesSets()
   */
  @Override
  public long getAdditionalLCSCapabilitiesSets() {
    return getAvpAsUnsigned32(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setAdditionalLCSCapabilitiesSets(DiameterIdentity)
   */
  @Override
  public void setAdditionalLCSCapabilitiesSets(long additionalLcsCapabilitiesSets) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.LCS_CAPABILITIES_SETS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalLcsCapabilitiesSets);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasAdditionalGMLCAddress()
   */
  @Override
  public boolean hasAdditionalGMLCAddress() {
    return hasAvp(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getAdditionalGMLCAddress()
   */
  @Override
  public Address getAdditionalGMLCAddress() {
    return getAvpAsAddress(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setAdditionalGMLCAddress(Address)
   */
  @Override
  public void setAdditionalGMLCAddress(Address additionalGmlcAddress) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalGmlcAddress);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasPPRAddress()
   */
  @Override
  public boolean hasPPRAddress() {
    return hasAvp(LCSRoutingInfoAVPCodes.PPR_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getPPRAddress()
   */
  @Override
  public Address getPPRAddress() {
    return getAvpAsAddress(LCSRoutingInfoAVPCodes.PPR_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setPPRAddress(Address)
   */
  @Override
  public void setPPRAddress(Address additionalGmlcAddress) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.PPR_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalGmlcAddress);
  }

  @Override
  public String getLongName() {
    return "Routing-Info-Answer";
  }

  @Override
  public String getShortName() {
    return "RIA";
  }

}

