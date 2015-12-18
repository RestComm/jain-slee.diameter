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

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes;
import net.java.slee.resource.diameter.s6a.events.avp.MDTConfigurationAvp;
import net.java.slee.resource.diameter.s6a.events.avp.TeleserviceListAvp;
import net.java.slee.resource.diameter.s6a.events.avp.TraceDataAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.TraceDataAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class TraceDataAvpImpl extends GroupedAvpImpl implements TraceDataAvp {

    public TraceDataAvpImpl() {
        super();
    }

    public TraceDataAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public boolean hasTraceReference() {
        return hasAvp(DiameterS6aAvpCodes.TRACE_REFERENCE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getTraceReference() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.TRACE_REFERENCE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setTraceReference(byte[] traceReference) {
        addAvp(DiameterS6aAvpCodes.TRACE_REFERENCE, DiameterS6aAvpCodes.S6A_VENDOR_ID, traceReference);
    }

    public boolean hasTraceDepth() {
        return hasAvp(DiameterS6aAvpCodes.TRACE_DEPTH, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getTraceDepth() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.TRACE_DEPTH, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setTraceDepth(byte[] traceDepth) {
        addAvp(DiameterS6aAvpCodes.TRACE_DEPTH, DiameterS6aAvpCodes.S6A_VENDOR_ID, traceDepth);
    }

    public boolean hasTraceNETypeList() {
        return hasAvp(DiameterS6aAvpCodes.TRACE_NE_TYPE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getTraceNETypeList() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.TRACE_NE_TYPE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setTraceNETypeList(byte[] traceNETypeList) {
        addAvp(DiameterS6aAvpCodes.TRACE_NE_TYPE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, traceNETypeList);
    }

    public boolean hasTraceInterfaceList() {
        return hasAvp(DiameterS6aAvpCodes.TRACE_INTERFACE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getTraceInterfaceList() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.TRACE_INTERFACE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setTraceInterfaceList(byte[] traceInterfaceList) {
        addAvp(DiameterS6aAvpCodes.TRACE_INTERFACE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, traceInterfaceList);
    }

    public boolean hasTraceEventList() {
        return hasAvp(DiameterS6aAvpCodes.TRACE_EVENT_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getTraceEventList() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.TRACE_EVENT_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setTraceEventList(byte[] traceEventList) {
        addAvp(DiameterS6aAvpCodes.TRACE_EVENT_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, traceEventList);
    }

    public boolean hasOMCId() {
        return hasAvp(DiameterS6aAvpCodes.OMC_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getOMCId() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.OMC_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setOMCId(byte[] omcId) {
        addAvp(DiameterS6aAvpCodes.OMC_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID, omcId);
    }

    public boolean hasTraceCollectionEntity(){
        return hasAvp(DiameterS6aAvpCodes.TRACE_COLLECTION_ENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public Address getTraceCollectionEntity(){
        return getAvpAsAddress(DiameterS6aAvpCodes.TRACE_COLLECTION_ENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setTraceCollectionEntity(Address traceCollectionEntity){
        addAvp(DiameterS6aAvpCodes.TRACE_COLLECTION_ENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, traceCollectionEntity);
    }

    public boolean hasMDTConfiguration() {
        return hasAvp(DiameterS6aAvpCodes.MDT_CONFIGURATION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public MDTConfigurationAvp getMDTConfiguration() {
        return (MDTConfigurationAvp) getAvpAsCustom(DiameterS6aAvpCodes.MDT_CONFIGURATION,
                                                    DiameterS6aAvpCodes.S6A_VENDOR_ID, MDTConfigurationAvpImpl.class);
    }

    public void setMDTConfiguration(MDTConfigurationAvp mdtConfiguration) {
        addAvp(mdtConfiguration);
    }
}