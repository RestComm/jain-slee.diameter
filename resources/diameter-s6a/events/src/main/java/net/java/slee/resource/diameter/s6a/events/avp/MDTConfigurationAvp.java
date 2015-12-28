/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.java.slee.resource.diameter.s6a.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the MDT-Configuration grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.3.136 MDT-Configuration
 *
 * The MDT-Configuration AVP is of type Grouped. It shall contain MDT related information as specified in 3GPP TS
 * 32.422 [23].
 *
 * The AVP format shall conform to:
 *
 *      MDT-Configuration ::= <AVP header: 1622 10415>
 *                              { Job-Type }
 *                              [ Area-Scope ]
 *                              [ List-Of-Measurements ]
 *                              [ Reporting-Trigger ]
 *                              [ Report-Interval ]
 *                              [ Report-Amount ]
 *                              [ Event-Threshold-RSRP ]
 *                              [ Event-Threshold-RSRQ ]
 *                              [ Logging-Interval ]
 *                              [ Logging-Duration ]
 *                              [ Measurement-Period-LTE ]
 *                              [ Measurement-Period-UMTS ]
 *                              [ Collection-Period-RMM-LTE ]
 *                              [ Collection-Period-RRM-UMTS ]
 *                              [ Positioning-Method ]
 *                              [ Measurement-Quantity]
 *                              [ Event-Threshold-Event-1F ]
 *                              [ Event-Threshold-Event-1I ]
 *                              *[ MDT-Allowed-PLMN-Id ]
*                               *[ AVP ]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface MDTConfigurationAvp extends GroupedAvp {
    /*
        7.3.137 Job-Type
        The Job-Type AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Job-Type.
     */
    public boolean hasJobType();
    public JobType getJobType();
    public void setJobType(JobType jobType);

    /*
        7.3.138 Area-Scope
        The Area-Scope AVP is of type Grouped. See 3GPP TS 32.422 [23].
     */
    public boolean hasAreaScope();
    public AreaScopeAvp getAreaScope();
    public void setAreaScope(AreaScopeAvp areaScopeAvp);

    /*
        7.3.139 List-Of-Measurements
        The List-Of-Measurements AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits is
        defined in 3GPP TS 32.422 [23]. The most significant bit is bit 8 of the first octet.
     */
    public boolean hasListOfMeasurements();
    public long getListOfMeasurements();
    public void setListOfMeasurements(long listOfMeasurements);

    /*
        7.3.140 Reporting-Trigger
        The Reporting-Trigger AVP is of type Unsigned32 and it shall contain a bit mask. The meaning of the bits is defined in
        3GPP TS 32.422 [23]. The most significant bit is bit 8 of the first octet.
     */
    public boolean hasReportingTrigger();
    public long getReportingTrigger();
    public void setReportingTrigger(long reportingTrigger);

    /*
        7.3.141 Report-Interval
        The Report-Interval AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for
        Report Interval
     */
    public boolean hasReportInterval();
    public ReportInterval getReportInterval();
    public void setReportInterval(ReportInterval reportInterval);

    /*
        7.3.142 Report-Amount
        The Report-Amount AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for
        Report Amount
     */
    public boolean hasReportAmount();
    public ReportAmount getReportAmount();
    public void setReportAmount(ReportAmount reportAmount);

    /*
        7.3.143 Event-Threshold-RSRP
        The Event-Threshold-RSRP AVP is of type Unsigned32. See 3GPP TS 32.422 for allowed values
     */
    public boolean hasEventThresholdRSRP();
    public long getEventThresholdRSRP();
    public void setEventThresholdRSRP(long eventThresholdRSRP);

    /*
        7.3.144 Event-Threshold-RSRQ
        The Event-Threshold-RSRQ AVP is of type Unsigned32. See 3GPP TS 32.422 for allowed values
     */
    public boolean hasEventThresholdRSRQ();
    public long getEventThresholdRSRQ();
    public void setEventThresholdRSRQ(long eventThresholdRSRQ);

    /*
        7.3.145 Logging-Interval
        The Logging-Interval AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for
        Logging Interval
     */
    public boolean hasLoggingInterval();
    public LoggingInterval getLoggingInterval();
    public void setLoggingInterval(LoggingInterval loggingInterval);

    /*
        7.3.146 Logging-Duration
        The Logging-Duration AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for
        Logging Duration
     */
    public boolean hasLoggingDuration();
    public LoggingDuration getLoggingDuration();
    public void setLoggingDuration(LoggingDuration loggingDuration);

    /*
        7.3.166 Measurement-Period-LTE
        The Measurement-Period-LTE AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422
        [23] for Measurement period LTE.
     */
    public boolean hasMeasurementPeriodLTE();
    public MeasurementPeriodLTE getMeasurementPeriodLTE();
    public void setMeasurementPeriodLTE(MeasurementPeriodLTE measurementPeriodLTE);

    /*
        7.3.167 Measurement-Period-UMTS
        The Measurement-Period-UMTS AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422
        [23] for Measurement period UMTS
     */
    public boolean hasMeasurementPeriodUMTS();
    public MeasurementPeriodUMTS getMeasurementPeriodUMTS();
    public void setMeasurementPeriodUMTS(MeasurementPeriodUMTS measurementPeriodUMTS);

    /*
        7.3.168 Collection-Period-RRM-LTE
        The Collection-Period-RRM-LTE AVP is of type Enumerated. The possible values are those defined in 3GPP TS
        32.422 [23] for Collection period for RRM measurements LTE.
     */
    public boolean hasCollectionPeriodRRMLTE();
    public CollectionPeriodRRMLTE getCollectionPeriodRRMLTE();
    public void setCollectionPeriodRRMLTE(CollectionPeriodRRMLTE collectionPeriodRRMLTE);

    /*
        7.3.169 Collection-Period-RRM-UMTS
        The Collection-Period-RRM-UMTS AVP is of type Enumerated. The possible values are those defined in 3GPP TS
        32.422 [23] for Collection period for RRM measurements UMTS.
     */
    public boolean hasCollectionPeriodRRMUMTS();
    public CollectionPeriodRRMUMTS getCollectionPeriodRRMUMTS();
    public void setCollectionPeriodRRMUMTS(CollectionPeriodRRMUMTS collectionPeriodRRMUMTS);

    /*
        7.3.170 Positioning-Method
        The Positioning-Method AVP is of type OctetString. It contains one octet carrying a bit map of 8 bits. The possible
        values are those defined in 3GPP TS 32.422 [23] for Positioning Method.
     */
    public boolean hasPositioningMethod();
    public byte[] getPositioningMethod();
    public void setPositioningMethod(byte[] positioningMethod);

    /*
        7.3.171 Measurement-Quantity
        The Measurement-Quantity AVP is of type OctetString. It contains one octet carrying a bit map of 8 bits. The possible
        values are those defined in 3GPP TS 32.422 [23] for Measurement quantity.
     */
    public boolean hasMeasurementQuantity();
    public byte[] getMeasurementQuantity();
    public void setMeasurementQuantity(byte[] measurementQuantity);

    /*
        7.3.172 Event-Threshold-Event-1F
        The Event-Threshold-Event-1F AVP is of type Integer32. See 3GPP TS 32.422 [23] for allowed values.
     */
    public boolean hasEventThresholdEvent1F();
    public int getEventThresholdEvent1F();
    public void setEventThresholdEvent1F(int eventThresholdEvent1F);

    /*
        7.3.173 Event-Threshold-Event-1I
        The Event-Threshold-Event-1I AVP is of type Integer32. See 3GPP TS 32.422 [23] for allowed values
     */
    public boolean hasEventThresholdEvent1I();
    public int getEventThresholdEvent1I();
    public void setEventThresholdEvent1I(int eventThresholdEvent1I);

    /*
        7.3.185 MDT-Allowed-PLMN-Id
        The MDT-Allowed-PLMN-Id AVP is of type OctetString. This AVP shall contain the concatenation of MCC and
        MNC. See 3GPP TS 23.003 [3]. The content of this AVP shall be encoded as an octet string according to table
        7.3.185/1.
     */
    public boolean hasMDTAllowedPLMNId();
    public void setMDTAllowedPLMNId(byte[] mdtAllowedPLMNId);
    public byte[][] getMDTAllowedPLMNIds();
    public void setMDTAllowedPLMNIds(byte[][] mdtAllowedPLMNIds);
}