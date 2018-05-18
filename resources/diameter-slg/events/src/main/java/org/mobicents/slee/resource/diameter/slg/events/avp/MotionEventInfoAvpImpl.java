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
import net.java.slee.resource.diameter.slg.events.avp.MotionEventInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.OccurrenceInfo;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link MotionEventInfoAvp}
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class MotionEventInfoAvpImpl extends GroupedAvpImpl implements MotionEventInfoAvp {

  public MotionEventInfoAvpImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public MotionEventInfoAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasLinearDistance() {
    return hasAvp(ELPAVPCodes.LINEAR_DISTANCE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getLinearDistance() {
    return getAvpAsUnsigned32(ELPAVPCodes.LINEAR_DISTANCE, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setLinearDistance(long linearDistance) {
    addAvp(ELPAVPCodes.LINEAR_DISTANCE, ELPAVPCodes.SLg_VENDOR_ID, linearDistance);
  }

  public boolean hasOccurrenceInfo() {
    return hasAvp(ELPAVPCodes.OCCURRENCE_INFO, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public OccurrenceInfo getOccurrenceInfo() {
    return (OccurrenceInfo) getAvpAsEnumerated(ELPAVPCodes.OCCURRENCE_INFO, ELPAVPCodes.SLg_VENDOR_ID, OccurrenceInfo.class);
  }

  public void setOccurrenceInfo(OccurrenceInfo occurrenceInfo) {
    addAvp(ELPAVPCodes.OCCURRENCE_INFO, ELPAVPCodes.SLg_VENDOR_ID, occurrenceInfo.getValue());
  }

  public boolean hasIntervalTime() {
    return hasAvp(ELPAVPCodes.INTERVAL_TIME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getIntervalTime() {
    return getAvpAsUnsigned32(ELPAVPCodes.INTERVAL_TIME, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setIntervalTime(long intervalTime) {
    addAvp(ELPAVPCodes.INTERVAL_TIME, ELPAVPCodes.SLg_VENDOR_ID, intervalTime);
  }

  public boolean hasMaximumInterval() {
    return hasAvp(ELPAVPCodes.MAXIMUM_INTERVAL, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getMaximumInterval() {
    return getAvpAsUnsigned32(ELPAVPCodes.MAXIMUM_INTERVAL, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setMaximumInterval(long maximumInterval) {
    addAvp(ELPAVPCodes.MAXIMUM_INTERVAL, ELPAVPCodes.SLg_VENDOR_ID, maximumInterval);
  }

  public boolean hasSamplingInterval() {
    return hasAvp(ELPAVPCodes.SAMPLING_INTERVAL, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getSamplingInterval() {
    return getAvpAsUnsigned32(ELPAVPCodes.SAMPLING_INTERVAL, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setSamplingInterval(long samplingInterval) {
    addAvp(ELPAVPCodes.SAMPLING_INTERVAL, ELPAVPCodes.SLg_VENDOR_ID, samplingInterval);
  }

  public boolean hasReportDuration() {
    return hasAvp(ELPAVPCodes.REPORTING_DURATION, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getReportDuration() {
    return getAvpAsUnsigned32(ELPAVPCodes.REPORTING_DURATION, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setReportDuration(long reportDuration) {
    addAvp(ELPAVPCodes.REPORTING_DURATION, ELPAVPCodes.SLg_VENDOR_ID, reportDuration);
  }

  public boolean hasReportingLocationRequirements() {
    return hasAvp(ELPAVPCodes.REPORTING_LOCATION_REQUIREMENTS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public long getReportingLocationRequirements() {
    return getAvpAsUnsigned32(ELPAVPCodes.REPORTING_LOCATION_REQUIREMENTS, ELPAVPCodes.SLg_VENDOR_ID);
  }

  public void setReportingLocationRequirements(long reportingLocationRequirements) {
    addAvp(ELPAVPCodes.REPORTING_LOCATION_REQUIREMENTS, ELPAVPCodes.SLg_VENDOR_ID, reportingLocationRequirements);
  }

}
