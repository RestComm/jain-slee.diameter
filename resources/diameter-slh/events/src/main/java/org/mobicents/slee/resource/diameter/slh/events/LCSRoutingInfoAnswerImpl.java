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

package org.mobicents.slee.resource.diameter.slh.events;

import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer;

import net.java.slee.resource.diameter.slh.events.avp.LCSRoutingInfoAVPCodes;
import net.java.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvp;
import net.java.slee.resource.diameter.slh.events.avp.ServingNodeAvp;

import org.mobicents.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvpImpl;
import org.mobicents.slee.resource.diameter.slh.events.avp.ServingNodeAvpImpl;;

/**
 * Implementation for {@link LCSRoutingInfoAnswer}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
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
  public ServingNodeAvp getServingNode() {
    return (ServingNodeAvp) getAvpAsCustom(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, ServingNodeAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setServingNode(net.java.slee.resource.diameter.slh.events.avp.ServingNodeAvp)
   */
  @Override
  public void setServingNode(ServingNodeAvp servingNode) {
    addAvp(LCSRoutingInfoAVPCodes.SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, servingNode.byteArrayValue());
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
  public AdditionalServingNodeAvp getAdditionalServingNode() {
    return (AdditionalServingNodeAvp) getAvpAsCustom(LCSRoutingInfoAVPCodes.ADDITIONAL_SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, AdditionalServingNodeAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setAdditionalServingNode(net.java.slee.resource.diameter.slh.events.avp.AdditionalServingNodeAvp)
   */
  @Override
  public void setAdditionalServingNode(AdditionalServingNodeAvp additionalServingNode) {
    addAvp(LCSRoutingInfoAVPCodes.ADDITIONAL_SERVING_NODE, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, additionalServingNode.byteArrayValue());
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
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setGMLCAddress(net.java.slee.resource.diameter.base.events.avp.Address)
   */
  @Override
  public void setGMLCAddress(Address gmlcAddress) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.GMLC_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, gmlcAddress);
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
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setPPRAddress(net.java.slee.resource.diameter.base.events.avp.Address)
   */
  @Override
  public void setPPRAddress(Address pprAddress) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.PPR_ADDRESS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, pprAddress);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#hasRIAFlags()
   */
  @Override
  public boolean hasRIAFlags() {
    return hasAvp(LCSRoutingInfoAVPCodes.RIA_FLAGS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#getRIAFlags()
   */
  @Override
  public long getRIAFlags() {
    return getAvpAsInteger32(LCSRoutingInfoAVPCodes.RIA_FLAGS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer#setRIAFlags(java.lang.Long)
   */
  @Override
  public void setRIAFlags(long riaFlags) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.RIA_FLAGS, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, riaFlags);
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


