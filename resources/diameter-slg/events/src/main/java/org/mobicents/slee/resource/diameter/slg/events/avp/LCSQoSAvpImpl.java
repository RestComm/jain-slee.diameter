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
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSAvp;
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSClass;
import net.java.slee.resource.diameter.slg.events.avp.VerticalRequested;
import net.java.slee.resource.diameter.slg.events.avp.ResponseTime;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link LCSQoSAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class LCSQoSAvpImpl extends GroupedAvpImpl implements LCSQoSAvp {

  public LCSQoSAvpImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public LCSQoSAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasLCSQoSClass() {
    return hasAvp(ELPAVPCodes.LCS_QoS_CLASS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public LCSQoSClass getLCSQoSClass() {
    return (LCSQoSClass) getAvpAsEnumerated(ELPAVPCodes.LCS_QoS_CLASS, ELPAVPCodes.SLg_VENDOR_ID, LCSQoSClass.class);
  }

  public void setLCSQoSClass(LCSQoSClass lcsQoSClass) {
    addAvp(ELPAVPCodes.LCS_QoS_CLASS, ELPAVPCodes.SLg_VENDOR_ID, lcsQoSClass.getValue());
  }

  public boolean hasHorizontalAccuracy() {
    return hasAvp(ELPAVPCodes.HORIZONTAL_ACCURACY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getHorizontalAccuracy() {
    return getAvpAsUnsigned32(ELPAVPCodes.HORIZONTAL_ACCURACY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setHorizontalAccuracy(long horizontalAccuracy) {
    addAvp(ELPAVPCodes.HORIZONTAL_ACCURACY, ELPAVPCodes.SLg_VENDOR_ID, horizontalAccuracy);
  }

  public boolean hasVerticalAccuracy() {
    return hasAvp(ELPAVPCodes.VERTICAL_ACCURACY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getVerticalAccuracy() {
    return getAvpAsUnsigned32(ELPAVPCodes.VERTICAL_ACCURACY, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setVerticalAccuracy(long verticalAccuracy) {
    addAvp(ELPAVPCodes.VERTICAL_ACCURACY, ELPAVPCodes.SLg_VENDOR_ID, verticalAccuracy);
  }

  public boolean hasVerticalRequested() {
    return hasAvp(ELPAVPCodes.VERTICAL_REQUESTED, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public VerticalRequested getVerticalRequested() {
    return (VerticalRequested) getAvpAsEnumerated(ELPAVPCodes.VERTICAL_REQUESTED, ELPAVPCodes.SLg_VENDOR_ID, VerticalRequested.class);
  }

  public void setVerticalRequested(VerticalRequested verticalRequested) {
    addAvp(ELPAVPCodes.VERTICAL_REQUESTED, ELPAVPCodes.SLg_VENDOR_ID, verticalRequested.getValue());
  }

  public boolean hasResponseTime() {
    return hasAvp(ELPAVPCodes.RESPONSE_TIME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public ResponseTime getResponseTime() {
    return (ResponseTime) getAvpAsEnumerated(ELPAVPCodes.RESPONSE_TIME, ELPAVPCodes.SLg_VENDOR_ID, ResponseTime.class);
  }

  public void setResponseTime(ResponseTime responseTime) {
    addAvp(ELPAVPCodes.RESPONSE_TIME, ELPAVPCodes.SLg_VENDOR_ID, responseTime.getValue());
  }

}

