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
import net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp;

/**
 * Implementation for {@link GERANPositioningInfoAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class GERANPositioningInfoAvpImpl extends GroupedAvpImpl implements GERANPositioningInfoAvp {

  public GERANPositioningInfoAvpImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public GERANPositioningInfoAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasGERANPositioningData() {
    return hasAvp(ELPAVPCodes.GERAN_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public byte[] getGERANPositioningData() {
    return getAvpAsOctetString(ELPAVPCodes.GERAN_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setGERANPositioningData(byte[] geranPositioningData) {
    addAvp(ELPAVPCodes.GERAN_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID, geranPositioningData);
  }

  public boolean hasGERANGANSSPositioningData() {
    return hasAvp(ELPAVPCodes.GERAN_GANSS_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public byte[] getGERANGANSSPositioningData() {
    return getAvpAsOctetString(ELPAVPCodes.GERAN_GANSS_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setGERANGANSSPositioningData(byte[] geranGANSSPositioningData) {
    addAvp(ELPAVPCodes.GERAN_GANSS_POSITIONING_DATA, ELPAVPCodes.SLg_VENDOR_ID, geranGANSSPositioningData);
  }

}

