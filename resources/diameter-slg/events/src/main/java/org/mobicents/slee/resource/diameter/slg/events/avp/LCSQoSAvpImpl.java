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

package org.mobicents.slee.resource.diameter.slg.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;
import net.java.slee.resource.diameter.slg.events.avp.EPCLocationProtocolAVPCodes;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import net.java.slee.resource.diameter.slg.events.avp.LCSQoSAvp;

/**
 * Implementation for {@link net.java.slee.resource.diameter.slg.events.avp.LCSQoSAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class LCSQoSAvpImpl extends GroupedAvpImpl implements LCSQoSAvp {

  public LCSQoSAvpImpl() {
    super();
  }

  public LCSQoSAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasLCSQoSClass() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.LCS_QoS_CLASS);
  }

  public int getLCSQoSClass() {
    return getAvpAsInteger32(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.LCS_QoS_CLASS);
  }

  public void setLCSQoSClass(int lcsQoSClass) {
    addAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, lcsQoSClass);
  }

  public boolean hasHorizontalAccuracy() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.HORIZONTAL_ACCURACY);
  }

  public long getHorizontalAccuracy() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.HORIZONTAL_ACCURACY);
  }

  public void setHorizontalAccuracy(long horizontalAccuracy) {
    addAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, horizontalAccuracy);
  }

  public boolean hasVerticalAccuracy() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.VERTICAL_ACCURACY);
  }

  public long getVerticalAccuracy() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.VERTICAL_ACCURACY);
  }

  public void setVerticalAccuracy(long verticalAccuracy) {
    addAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, verticalAccuracy);
  }

  public boolean hasVerticalRequested() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.VERTICAL_REQUESTED);
  }

  public int getVerticalRequested() {
    return getAvpAsInteger32(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.VERTICAL_REQUESTED);
  }

  public void setVerticalRequested(int verticalRequested) {
    addAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, verticalRequested);
  }

  public boolean hasResponseTime() {
    return hasAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.RESPONSE_TIME);
  }

  public int getResponseTime() {
    return getAvpAsInteger32(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.RESPONSE_TIME);
  }

  public void setResponseTime(int responseTime) {
    addAvp(EPCLocationProtocolAVPCodes.LCS_QoS, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, responseTime);
  }

}

