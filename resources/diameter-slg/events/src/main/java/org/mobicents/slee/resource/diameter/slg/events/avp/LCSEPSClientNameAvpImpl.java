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
import net.java.slee.resource.diameter.slg.events.avp.LCSFormatIndicator;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import net.java.slee.resource.diameter.slg.events.avp.LCSEPSClientNameAvp;

/**
 * Implementation for {@link LCSEPSClientNameAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class LCSEPSClientNameAvpImpl extends GroupedAvpImpl implements LCSEPSClientNameAvp {

  public LCSEPSClientNameAvpImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public LCSEPSClientNameAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasLCSNameString() {
    return hasAvp(ELPAVPCodes.LCS_NAME_STRING, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public String getLCSNameString() {
    return getAvpAsUTF8String(ELPAVPCodes.LCS_NAME_STRING, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setLCSNameString(String lcsNameString) {
    addAvp(ELPAVPCodes.LCS_NAME_STRING, ELPAVPCodes.SLg_VENDOR_ID, lcsNameString);
  }

  public boolean hasLCSFormatIndicator() {
    return hasAvp(ELPAVPCodes.LCS_FORMAT_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public LCSFormatIndicator getLCSFormatIndicator() {
    return (LCSFormatIndicator) getAvpAsEnumerated(ELPAVPCodes.LCS_FORMAT_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID, LCSFormatIndicator.class);
  }

  public void setLCSFormatIndicator(LCSFormatIndicator lcsFormatIndicator) {
    addAvp(ELPAVPCodes.LCS_FORMAT_INDICATOR, ELPAVPCodes.SLg_VENDOR_ID, lcsFormatIndicator.getValue());
  }

}
