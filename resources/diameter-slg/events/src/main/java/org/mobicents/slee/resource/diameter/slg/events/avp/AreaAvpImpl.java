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

import net.java.slee.resource.diameter.base.events.avp.Enumerated;
import net.java.slee.resource.diameter.slg.events.avp.EPCLocationProtocolAVPCodes;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import net.java.slee.resource.diameter.slg.events.avp.AreaAvp;

/**
 * Implementation for {@link net.java.slee.resource.diameter.slg.events.avp.AreaAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class AreaAvpImpl extends GroupedAvpImpl implements AreaAvp {

  public AreaAvpImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public AreaAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasAreaType() {
    return hasAvp(EPCLocationProtocolAVPCodes.AREA_TYPE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public long getAreaType() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.AREA_TYPE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setAreaType(long areaType) {
    addAvp(EPCLocationProtocolAVPCodes.AREA_TYPE, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, areaType);
  }

  public boolean hasAreaIdentification() {
    return hasAvp(EPCLocationProtocolAVPCodes.AREA_IDENTIFICATION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public byte[] getAreaIdentification() {
    return getAvpAsOctetString(EPCLocationProtocolAVPCodes.AREA_IDENTIFICATION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setAreaIdentification(byte[] areaIdentification) {
    addAvp(EPCLocationProtocolAVPCodes.AREA_IDENTIFICATION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, areaIdentification);
  }

}

