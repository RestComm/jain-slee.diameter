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
import net.java.slee.resource.diameter.slg.events.avp.AreaDefinitionAvp;
import net.java.slee.resource.diameter.slg.events.avp.EPCLocationProtocolAVPCodes;
import net.java.slee.resource.diameter.slg.events.avp.OccurrenceInfo;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import net.java.slee.resource.diameter.slg.events.avp.AreaEventInfoAvp;

/**
 * Implementation for {@link net.java.slee.resource.diameter.slg.events.avp.AreaEventInfoAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class AreaEventInfoAvpImpl extends GroupedAvpImpl implements AreaEventInfoAvp {

  public AreaEventInfoAvpImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public AreaEventInfoAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasAreaDefinition() {
    return hasAvp(EPCLocationProtocolAVPCodes.AREA_DEFINITION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public AreaDefinitionAvp getAreaDefinition() {
    return (AreaDefinitionAvp) getAvpAsCustom(EPCLocationProtocolAVPCodes.AREA_DEFINITION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, AreaDefinitionAvpImpl.class);
  }

  public void setAreaDefinition(AreaDefinitionAvp areaDefinition){
    addAvp(EPCLocationProtocolAVPCodes.AREA_DEFINITION, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, areaDefinition.byteArrayValue());
  }

  public boolean hasOccurrenceInfo() {
    return hasAvp(EPCLocationProtocolAVPCodes.OCCURRENCE_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public OccurrenceInfo getOccurrenceInfo() {
    return (OccurrenceInfo) getAvpAsEnumerated(EPCLocationProtocolAVPCodes.OCCURRENCE_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, OccurrenceInfo.class);
  }

  public void setOccurrenceInfo(OccurrenceInfo occurrenceInfo) {
    addAvp(EPCLocationProtocolAVPCodes.OCCURRENCE_INFO, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, occurrenceInfo.getValue());
  }

  public boolean hasIntervalTime() {
    return hasAvp(EPCLocationProtocolAVPCodes.INTERVAL_TIME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public long getIntervalTime() {
    return getAvpAsUnsigned32(EPCLocationProtocolAVPCodes.INTERVAL_TIME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID);
  }

  public void setIntervalTime(long intervalTime) {
    addAvp(EPCLocationProtocolAVPCodes.INTERVAL_TIME, EPCLocationProtocolAVPCodes.SLg_VENDOR_ID, intervalTime);
  }

}
