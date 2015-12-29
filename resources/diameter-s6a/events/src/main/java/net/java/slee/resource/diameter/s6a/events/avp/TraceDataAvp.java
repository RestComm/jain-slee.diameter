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

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Trace-Data grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.63 Trace-Data AVP
 *
 * The Trace-Data AVP is of type Grouped. This AVP shall contain the information related to trace function.
 * AVP format
 *     Trace-Data ::= <AVP header: 1458 10415>
 *                     {Trace-Reference}
 *                     {Trace-Depth}
 *                     {Trace-NE-Type-List}
 *                     [Trace-Interface-List]
 *                     {Trace-Event-List}
 *                     [OMC-Id]
 *                     {Trace-Collection-Entity}
 *                     [MDT-Configuration]     //R12
 *                     *[AVP]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface TraceDataAvp extends GroupedAvp {
    /*
        7.3.64 Trace-Reference AVP
        The Trace-Reference AVP is of type OctetString. This AVP shall contain the concatenation of MCC, MNC and Trace
        ID, where the Trace ID is a 3 byte Octet String. See 3GPP TS 32.422 [23].
     */
    public boolean hasTraceReference();
    public byte[] getTraceReference();
    public void setTraceReference(byte[] traceReference);

    /*
        7.3.67 Trace-Depth AVP
        The Trace-Depth AVP is of type Enumerated. The possible values are those defined in 3GPP TS 32.422 [23] for Trace
        Depth.
    */
    public boolean hasTraceDepth();
    public byte[] getTraceDepth();
    public void setTraceDepth(byte[] traceDepth);

    /*
        7.3.68 Trace-NE-Type-List AVP
        The Trace-NE-Type-List AVP is of type OctetString. Octets are coded according to 3GPP TS 32.422 [23].
    */
    public boolean hasTraceNETypeList();
    public byte[] getTraceNETypeList();
    public void setTraceNETypeList(byte[] traceNETypeList);

    /*
        7.3.69 Trace-Interface-List AVP
        The Trace-Interface-List AVP is of type OctetString. Octets are coded according to 3GPP TS 32.422 [23].
    */
    public boolean hasTraceInterfaceList();
    public byte[] getTraceInterfaceList();
    public void setTraceInterfaceList(byte[] traceInterfaceList);

    /*
        7.3.70 Trace-Event-List AVP
        The Trace-Event-List AVP is of type OctetString. Octets are coded according to 3GPP TS 32.422 [23].
    */
    public boolean hasTraceEventList();
    public byte[] getTraceEventList();
    public void setTraceEventList(byte[] traceEventList);

    /*
        7.3.71 OMC-Id AVP
        The OMC-Id AVP is of type OctetString. Octets are coded according to 3GPP TS 29.002 [24].
    */
    public boolean hasOMCId();
    public byte[] getOMCId();
    public void setOMCId(byte[] omcId);


    /*
        7.3.98 Trace-Collection-Entity AVP
        The Trace-collection-Entity AVP is of type Address and contains the IPv4 or IPv6 address of the Trace Collection
        Entity, as defined in 3GPP TS 32.422 [23], clause 5.9.
    */
    public boolean hasTraceCollectionEntity();
    public Address getTraceCollectionEntity();
    public void setTraceCollectionEntity(Address traceCollectionEntity);

    /*
        7.3.136 MDT-Configuration
        The MDT-Configuration AVP is of type Grouped. It shall contain MDT related information as specified in 3GPP TS
        32.422 [23].
     */
    public boolean hasMDTConfiguration();
    public MDTConfigurationAvp getMDTConfiguration();
    public void setMDTConfiguration(MDTConfigurationAvp mdtConfiguration);

}