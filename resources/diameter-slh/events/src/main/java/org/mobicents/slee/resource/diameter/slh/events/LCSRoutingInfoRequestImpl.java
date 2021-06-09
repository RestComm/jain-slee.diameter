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

import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;
import org.jdiameter.api.Message;

import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import net.java.slee.resource.diameter.slh.events.avp.LCSRoutingInfoAVPCodes;

/**
 * Implementation for {@link LCSRoutingInfoRequest}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class LCSRoutingInfoRequestImpl extends DiameterMessageImpl implements LCSRoutingInfoRequest {

  /**
   * @param message
   */
  public LCSRoutingInfoRequestImpl(Message message) {
    super(message);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSInfoRequest#hasAuthSessionState()
   */
  public boolean hasAuthSessionState() {
    return hasAvp(DiameterAvpCodes.AUTH_SESSION_STATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSInfoRequest#getAuthSessionState()
   */
  public AuthSessionStateType getAuthSessionState() {
    return (AuthSessionStateType) getAvpAsEnumerated(DiameterAvpCodes.AUTH_SESSION_STATE, AuthSessionStateType.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSInfoRequest#setAuthSessionState(net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType)
   */
  public void setAuthSessionState(AuthSessionStateType authSessionState) {
    addAvp(DiameterAvpCodes.AUTH_SESSION_STATE, authSessionState.getValue());
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest#hasUserName()
   */
  @Override
  public boolean hasUserName() {
    return hasAvp(LCSRoutingInfoAVPCodes.USER_NAME);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest#getUserName()
   */
  @Override
  public String getUserName() {
    return getAvpAsUTF8String(LCSRoutingInfoAVPCodes.USER_NAME);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest#setUserName(java.lang.String)
   */
  @Override
  public void setUserName(String imsi) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.USER_NAME, imsi);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest#hasMSISDN()
   */
  @Override
  public boolean hasMSISDN() {
    return hasAvp(LCSRoutingInfoAVPCodes.MSISDN, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest#getMSISDN()
   */
  @Override
  public byte[] getMSISDN() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.MSISDN, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest#setMSISDN(byte[])
   */
  @Override
  public void setMSISDN(byte[] msisdn) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.MSISDN, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, msisdn);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest#hasGMLCNumber()
   */
  @Override
  public boolean hasGMLCNumber() {
    return hasAvp(LCSRoutingInfoAVPCodes.GMLC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest#getGMLCNumber()
   */
  @Override
  public byte[] getGMLCNumber() {
    return getAvpAsOctetString(LCSRoutingInfoAVPCodes.GMLC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest#setGMLCNumber(byte[])
   */
  @Override
  public void setGMLCNumber(byte[] gmlcNumber) throws IllegalStateException {
    addAvp(LCSRoutingInfoAVPCodes.GMLC_NUMBER, LCSRoutingInfoAVPCodes.SLh_VENDOR_ID, gmlcNumber);
  }

  @Override
  public String getLongName() {
    return "Routing-Info-Request";
  }

  @Override
  public String getShortName() {
    return "RIR";
  }

}

