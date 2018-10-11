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
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import net.java.slee.resource.diameter.slg.events.avp.DelayedLocationReportingDataAvp;

/**
 * Implementation for {@link DelayedLocationReportingDataAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class DelayedLocationReportingDataAvpImpl extends GroupedAvpImpl implements DelayedLocationReportingDataAvp {

  public DelayedLocationReportingDataAvpImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public DelayedLocationReportingDataAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasTerminationCause() {
    return hasAvp(ELPAVPCodes.TERMINATION_CAUSE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getTerminationCause() {
    return getAvpAsInteger32(ELPAVPCodes.TERMINATION_CAUSE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setTerminationCause(long terminationCause) {
    addAvp(ELPAVPCodes.TERMINATION_CAUSE, ELPAVPCodes.SLg_VENDOR_ID, terminationCause);
  }

  public boolean hasServingNode() {
    return hasAvp(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public ServingNodeAvp getServingNode() {
    return (ServingNodeAvp) getAvpAsCustom(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, ServingNodeAvpImpl.class);
  }

  public void setServingNode(ServingNodeAvp servingNode) {
    addAvp(ELPAVPCodes.SERVING_NODE, ELPAVPCodes.SLg_VENDOR_ID, servingNode.byteArrayValue());
  }

}

