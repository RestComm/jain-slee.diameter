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

package net.java.slee.resource.diameter.slg.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Motion-Event-Info AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V14.1.0) specification.
 * <p>
 * <pre>
 * 7.4.4	Motion-Event-Info
 * 	The Motion-Event-Info AVP is of type Grouped.
 * 	 AVP format:
 * 	 Motion-Event-Info ::= <AVP header: 2559 10415>
 *                          { Linear-Distance }
 * 	                        [ Occurrence-Info ]
 * 	                        [ Interval-Time ]
 * 	                        [ Maximum-Interval ]
 * 	                        [ Sampling-Interval ]
 * 	                        [ Reporting-Duration ]
 * 	                        [ Reporting-Location-Requirements ]
 * 	                       *[ AVP ]
 *
 * 	 If not included, the default value of Occurrence-Info shall be considered as "ONE_TIME_EVENT" (0).
 * 	 Interval-Time and Maximum-Interval AVPs are only applicable when the Occurrence-Info is set to "MULTIPLE_TIME_EVENT" (1).
 * 	 If not included, the default value of Interval-Time shall be considered as one and the default values of Maximum-Interval,
 * 	 Sampling-Interval and Reporting-Duration shall each be considered as the maximum value.
 * 	 The Motion-Event-Info AVP is only applicable to a deferred EPC-MT-LR.
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface MotionEventInfoAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 (v14.1.0)

		7.4.65	Linear-Distance
      The Linear-Distance AVP is of type Unsigned32 and it contains the minimum linear (straight line) distance for motion event reports, in meters.
      The minimum value shall be 1 and maximum value shall be 10,000. The Linear-Distance AVP is only applicable to a deferred EPC-MT-LR.
  */
  boolean hasLinearDistance();

  long getLinearDistance();

  void setLinearDistance(long linearDistance);

  /*
    From 3GPP TS 29.172 (v14.1.0)

		7.4.43	Occurrence-Info
      The Occurrence-Info AVP is of type Enumerated. The following values are defined:
      ONE_TIME_EVENT (0)
      MULTIPLE_TIME_EVENT (1)
  */
  boolean hasOccurrenceInfo();

  OccurrenceInfo getOccurrenceInfo();

  void setOccurrenceInfo(OccurrenceInfo occurrenceInfo);

  /*
    From 3GPP TS 29.172 (v14.1.0)

		7.4.44	Interval-Time
      The Interval-Time AVP is of type Unsigned32 and it contains the minimum time interval between area reports or motion reports, in seconds.
      The minimum value shall be 1 second and the maximum value 32767 seconds.
  */
  boolean hasIntervalTime();

  long getIntervalTime();

  void setIntervalTime(long motionEventIntervalTime);

  /*
    From 3GPP TS 29.172 (v14.1.0)

		7.4.66	Maximum-Interval
      The Maximum-Interval AVP is of type Unsigned32 and it contains the maximum time interval between consecutive event reports, in seconds.
      The minimum value shall be 1 second and the maximum value 86400 seconds.
      The Maximum-Interval AVP is only applicable to a deferred EPC-MT-LR.
  */
  boolean hasMaximumInterval();

  long getMaximumInterval();

  void setMaximumInterval(long motionEventMaximumInterval);

  /*
    From 3GPP TS 29.172 (v14.1.0)

		7.4.67	Sampling-Interval
      The Sampling-Interval AVP is of type Unsigned32 and it contains the maximum time interval between consecutive evaluations by a UE of an area event or motion event, in seconds.
      The minimum value shall be 1 second and the maximum value 3600 seconds.
      The Sampling-Interval AVP is only applicable to a deferred EPC-MT-LR.
  */
  boolean hasSamplingInterval();

  long getSamplingInterval();

  void setSamplingInterval(long motionEventSamplingInterval);

  /*
		From 3GPP TS 29.172 V14.1.0

		7.4.68	Reporting-Duration
     The Reporting-Duration AVP is of type Unsigned32 and it contains the maximum duration of event reporting, in seconds.
     Its minimum value shall be 1 and maximum value shall be 8640000.
     The Reporting-Duration AVP is only applicable to a deferred EPC-MT-LR.
	*/
  boolean hasReportDuration();

  long getReportDuration();

  void setReportDuration(long motionEventReportDuration);

  /*
		From 3GPP TS 29.172 V14.1.0

		7.4.69	Reporting-Location-Requirements
     The Reporting-Location-Requirements AVP is of type Unsigned32 and it shall contain a bit string indicating requirements
     on location provision for a deferred EPC-MT-LR. When a bit is set to one, the corresponding requirement is present.
     When a bit is set to zero or when the AVP is omitted, the corresponding requirement is not present.
     For support of backward compatibility, a receiver shall ignore any bits that are set to one but are not supported
     The meaning of the bits shall be as defined in table 7.4.69/1:

     Table 7.4.69/1: Reporting-Location-Requirements
      Bit	    Requirement	        Description
        0	    Location-Estimate	  A location estimate is required for each area event, motion event report or expiration of the
                                  maximum time interval between event reports.
      1-31    None	              Spare
	*/
  boolean hasReportingLocationRequirements();

  long getReportingLocationRequirements();

  void setReportingLocationRequirements(long motionEventReportingLocationRequirements);

}
