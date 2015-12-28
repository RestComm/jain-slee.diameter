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

package org.mobicents.slee.resource.diameter.s6a.events.avp;

import net.java.slee.resource.diameter.s6a.events.avp.*;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.MDTConfigurationAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class MDTConfigurationAvpImpl extends GroupedAvpImpl implements MDTConfigurationAvp {

    public MDTConfigurationAvpImpl() {
        super();
    }

    public MDTConfigurationAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }


    public boolean hasJobType() {
        return hasAvp(DiameterS6aAvpCodes.JOB_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public JobType getJobType() {
        return (JobType) getAvpAsEnumerated(DiameterS6aAvpCodes.JOB_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, JobType.class);
    }

    public void setJobType(JobType jobType) {
        addAvp(DiameterS6aAvpCodes.JOB_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, jobType.getValue());
    }

    public boolean hasAreaScope() {
        return hasAvp(DiameterS6aAvpCodes.AREA_SCOPE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public AreaScopeAvp getAreaScope() {
        return (AreaScopeAvp) getAvpAsCustom(DiameterS6aAvpCodes.AREA_SCOPE, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                                             AreaScopeAvpImpl.class);
    }

    public void setAreaScope(AreaScopeAvp areaScopeAvp) {
        addAvp(areaScopeAvp);
    }

    public boolean hasListOfMeasurements() {
        return hasAvp(DiameterS6aAvpCodes.LIST_OF_MEASUREMENTS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getListOfMeasurements() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.LIST_OF_MEASUREMENTS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setListOfMeasurements(long listOfMeasurements) {
        addAvp(DiameterS6aAvpCodes.LIST_OF_MEASUREMENTS, DiameterS6aAvpCodes.S6A_VENDOR_ID, listOfMeasurements);
    }

    public boolean hasReportingTrigger() {
        return hasAvp(DiameterS6aAvpCodes.REPORTING_TRIGGER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getReportingTrigger() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.REPORTING_TRIGGER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setReportingTrigger(long reportingTrigger) {
        addAvp(DiameterS6aAvpCodes.REPORTING_TRIGGER, DiameterS6aAvpCodes.S6A_VENDOR_ID, reportingTrigger);
    }

    public boolean hasReportInterval() {
        return hasAvp(DiameterS6aAvpCodes.REPORT_INTERVAL, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public ReportInterval getReportInterval() {
        return (ReportInterval) getAvpAsEnumerated(DiameterS6aAvpCodes.REPORT_INTERVAL, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                                                   ReportInterval.class);
    }

    public void setReportInterval(ReportInterval reportInterval) {
        addAvp(DiameterS6aAvpCodes.REPORT_INTERVAL, DiameterS6aAvpCodes.S6A_VENDOR_ID, reportInterval.getValue());
    }

    public boolean hasReportAmount() {
        return hasAvp(DiameterS6aAvpCodes.REPORT_AMOUNT, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public ReportAmount getReportAmount() {
        return (ReportAmount) getAvpAsEnumerated(DiameterS6aAvpCodes.REPORT_AMOUNT, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                                                 ReportAmount.class);
    }

    public void setReportAmount(ReportAmount reportAmount) {
        addAvp(DiameterS6aAvpCodes.REPORT_AMOUNT, DiameterS6aAvpCodes.S6A_VENDOR_ID, reportAmount.getValue());
    }

    public boolean hasEventThresholdRSRP() {
        return hasAvp(DiameterS6aAvpCodes.EVENT_THRESHOLD_RSRP, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getEventThresholdRSRP() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.EVENT_THRESHOLD_RSRP, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setEventThresholdRSRP(long eventThresholdRSRP) {
        addAvp(DiameterS6aAvpCodes.EVENT_THRESHOLD_RSRP, DiameterS6aAvpCodes.S6A_VENDOR_ID, eventThresholdRSRP);
    }

    public boolean hasEventThresholdRSRQ() {
        return hasAvp(DiameterS6aAvpCodes.EVENT_THRESHOLD_RSRQ, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getEventThresholdRSRQ() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.EVENT_THRESHOLD_RSRQ, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setEventThresholdRSRQ(long eventThresholdRSRQ) {
        addAvp(DiameterS6aAvpCodes.EVENT_THRESHOLD_RSRQ, DiameterS6aAvpCodes.S6A_VENDOR_ID, eventThresholdRSRQ);
    }

    public boolean hasLoggingInterval() {
        return hasAvp(DiameterS6aAvpCodes.LOGGING_INTERVAL, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public LoggingInterval getLoggingInterval() {
        return (LoggingInterval) getAvpAsEnumerated(DiameterS6aAvpCodes.LOGGING_INTERVAL,
                                                    DiameterS6aAvpCodes.S6A_VENDOR_ID, LoggingInterval.class);
    }

    public void setLoggingInterval(LoggingInterval loggingInterval) {
        addAvp(DiameterS6aAvpCodes.LOGGING_INTERVAL, DiameterS6aAvpCodes.S6A_VENDOR_ID, loggingInterval.getValue());
    }

    public boolean hasLoggingDuration() {
        return hasAvp(DiameterS6aAvpCodes.LOGGING_DURATION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public LoggingDuration getLoggingDuration() {
        return (LoggingDuration) getAvpAsEnumerated(DiameterS6aAvpCodes.LOGGING_DURATION,
                                                    DiameterS6aAvpCodes.S6A_VENDOR_ID, LoggingDuration.class);
    }

    public void setLoggingDuration(LoggingDuration loggingDuration) {
        addAvp(DiameterS6aAvpCodes.LOGGING_DURATION, DiameterS6aAvpCodes.S6A_VENDOR_ID, loggingDuration.getValue());
    }

    public boolean hasMeasurementPeriodLTE() {
        return hasAvp(DiameterS6aAvpCodes.MEASUREMENT_PERIOD_LTE,DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public MeasurementPeriodLTE getMeasurementPeriodLTE() {
        return (MeasurementPeriodLTE) getAvpAsEnumerated(DiameterS6aAvpCodes.MEASUREMENT_PERIOD_LTE,
                                                         DiameterS6aAvpCodes.S6A_VENDOR_ID, MeasurementPeriodLTE.class);
    }

    public void setMeasurementPeriodLTE(MeasurementPeriodLTE measurementPeriodLTE) {
        addAvp(DiameterS6aAvpCodes.MEASUREMENT_PERIOD_LTE, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               measurementPeriodLTE.getValue());
    }

    public boolean hasMeasurementPeriodUMTS() {
        return hasAvp(DiameterS6aAvpCodes.MEASUREMENT_PERIOD_UMTS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public MeasurementPeriodUMTS getMeasurementPeriodUMTS() {
        return (MeasurementPeriodUMTS) getAvpAsEnumerated(DiameterS6aAvpCodes.MEASUREMENT_PERIOD_UMTS,
                                                          DiameterS6aAvpCodes.S6A_VENDOR_ID, MeasurementPeriodUMTS.class);
    }

    public void setMeasurementPeriodUMTS(MeasurementPeriodUMTS measurementPeriodUMTS) {
        addAvp(DiameterS6aAvpCodes.MEASUREMENT_PERIOD_UMTS, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               measurementPeriodUMTS.getValue());
    }

    public boolean hasCollectionPeriodRRMLTE() {
        return hasAvp(DiameterS6aAvpCodes.COLLECTION_PERIOD_RRM_LTE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public CollectionPeriodRRMLTE getCollectionPeriodRRMLTE() {
        return (CollectionPeriodRRMLTE) getAvpAsEnumerated(DiameterS6aAvpCodes.COLLECTION_PERIOD_RRM_LTE,
                                                       DiameterS6aAvpCodes.S6A_VENDOR_ID, CollectionPeriodRRMLTE.class);
    }

    public void setCollectionPeriodRRMLTE(CollectionPeriodRRMLTE collectionPeriodRRMLTE) {
        addAvp(DiameterS6aAvpCodes.COLLECTION_PERIOD_RRM_LTE, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               collectionPeriodRRMLTE.getValue());
    }

    public boolean hasCollectionPeriodRRMUMTS() {
        return hasAvp(DiameterS6aAvpCodes.COLLECTION_PERIOD_RRM_UMTS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public CollectionPeriodRRMUMTS getCollectionPeriodRRMUMTS() {
        return (CollectionPeriodRRMUMTS) getAvpAsEnumerated(DiameterS6aAvpCodes.COLLECTION_PERIOD_RRM_UMTS,
                                                            DiameterS6aAvpCodes.S6A_VENDOR_ID,
                                                            CollectionPeriodRRMUMTS.class);
    }

    public void setCollectionPeriodRRMUMTS(CollectionPeriodRRMUMTS collectionPeriodRRMUMTS) {
        addAvp(DiameterS6aAvpCodes.COLLECTION_PERIOD_RRM_UMTS, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               collectionPeriodRRMUMTS.getValue());
    }

    public boolean hasPositioningMethod() {
        return hasAvp(DiameterS6aAvpCodes.POSITIONING_METHOD, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getPositioningMethod() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.POSITIONING_METHOD, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setPositioningMethod(byte[] positioningMethod) {
        addAvp(DiameterS6aAvpCodes.POSITIONING_METHOD, DiameterS6aAvpCodes.S6A_VENDOR_ID, positioningMethod);
    }

    public boolean hasMeasurementQuantity() {
        return hasAvp(DiameterS6aAvpCodes.MEASUREMENT_QUANTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getMeasurementQuantity() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.MEASUREMENT_QUANTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setMeasurementQuantity(byte[] measurementQuantity) {
        addAvp(DiameterS6aAvpCodes.MEASUREMENT_QUANTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, measurementQuantity);
    }

    public boolean hasEventThresholdEvent1F() {
        return hasAvp(DiameterS6aAvpCodes.EVENT_THRESHOLD_EVENT_1F, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public int getEventThresholdEvent1F() {
        return getAvpAsInteger32(DiameterS6aAvpCodes.EVENT_THRESHOLD_EVENT_1F, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setEventThresholdEvent1F(int eventThresholdEvent1F) {
        addAvp(DiameterS6aAvpCodes.EVENT_THRESHOLD_EVENT_1F, DiameterS6aAvpCodes.S6A_VENDOR_ID, eventThresholdEvent1F);
    }

    public boolean hasEventThresholdEvent1I() {
        return hasAvp(DiameterS6aAvpCodes.EVENT_THRESHOLD_EVENT_1I, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public int getEventThresholdEvent1I() {
        return getAvpAsInteger32(DiameterS6aAvpCodes.EVENT_THRESHOLD_EVENT_1I, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setEventThresholdEvent1I(int eventThresholdEvent1I) {
        addAvp(DiameterS6aAvpCodes.EVENT_THRESHOLD_EVENT_1I, DiameterS6aAvpCodes.S6A_VENDOR_ID, eventThresholdEvent1I);
    }

    public boolean hasMDTAllowedPLMNId() {
        return hasAvp(DiameterS6aAvpCodes.MDT_ALLOWED_PLMN_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setMDTAllowedPLMNId(byte[] mdtAllowedPLMNId) {
        addAvp(DiameterS6aAvpCodes.MDT_ALLOWED_PLMN_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID, mdtAllowedPLMNId);
    }

    public byte[][] getMDTAllowedPLMNIds(){
        return getAvpsAsOctetString(DiameterS6aAvpCodes.MDT_ALLOWED_PLMN_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setMDTAllowedPLMNIds(byte[][] mdtAllowedPLMNIds){
        for (byte[] aux : mdtAllowedPLMNIds){
            setMDTAllowedPLMNId(aux);
        }
    }
}