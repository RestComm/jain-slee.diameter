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
 * Defines an interface representing the PDP-Context grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.74 PDP-Context
 *
 * The PDP-Context AVP is of type Grouped. For a particular GPRS user having multiple PDP Context configurations,
 * the Service-Selection AVP values may be the same for different PDP-Context AVPs.
 * AVP format
 *      PDP-Context ::= <AVP header: 1469 10415>
 *                      { Context-Identifier }
 *                      { PDP-Type }
 *                      [ PDP-Address ]
 *                      { QoS-Subscribed }
 *                      [ VPLMN-Dynamic-Address-Allowed ]
 *                      { Service-Selection }
 *                      [3GPP-Charging-Characteristics]
 *                      [ Ext-PDP-Type ]
 *                      [ Ext-PDP-Address ]
 *                      [ AMBR ]                                    //R12
 *                      [ APN-OI-Replacement ]                      //R12
 *                      [ SIPTO-Permission ]                        //R12
 *                      [ LIPA-Permission ]                         //R12
 *                      [ Restoration-Priority ]                    //R12
 *                      [ SIPTO-Local-Network-Permission ]          //R12
 *                      *[AVP]
 *
 *  NOTE: The Ext-PDP-Address AVP may be present only if the PDP-Address AVP is present. If the Ext-PDP-Address AVP is
 *  present, then it shall not contain the same address type (IPv4 or IPv6) as the PDP-Address AVP.
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface PDPContextAvp extends GroupedAvp {
    /*
        7.3.27 Context-Identifier
        The Context-Identifier AVP is of type Unsigned32.
     */
    public boolean hasContextIdentifier();
    public long getContextIdentifier();
    public void setContextIdentifier(long contextIdentifier);

    /*
        7.3.75 PDP-Type
        The PDP-Type AVP is of type OctetString. Octets are coded according to 3GPP TS 29.002 [24] and 3GPP TS 29.060[39].
     */
    public boolean hasPDPType();
    public byte[] getPDPType();
    public void setPDPType(byte[] pdpType);

    /*
        PDP-Address
     */
    public boolean hasPDPAddress();
    public Address getPDPAddress();
    public void setPDPAddress(Address pdpAddress);

    /*
        7.3.75A Ext-PDP-Type
        The Ext-PDP-Type AVP is of type OctetString. Octets are coded according to 3GPP TS 29.002 [24] and 3GPP TS
        29.060 [39] and shall contain the value of IPv4v6
     */
    public boolean hasExtPDPType();
    public byte[] getExtPDPType();
    public void setExtPDPType(byte[] extPDPType);

    /*
        7.3.77 QoS-Subscribed
        The QoS-Subscribed AVP is of type OctetString. Octets are coded according to 3GPP TS 29.002 [24] (octets of QoSSubscribed,
        Ext-QoS-Subscribed, Ext2-QoS-Subscribed, Ext3-QoS-Subscribed and Ext4-QoS-Subscribed values are
        concatenated).
     */
    public boolean hasQoSSubscribed();
    public byte[] getQoSSubscribed();
    public void setQoSSubscribed(byte[] qoSSubscribed);

    /*
        7.3.38 VPLMN-Dynamic-Address-Allowed
        The VPLMN Dynamic Address Allowed AVP is of type Enumerated. It shall indicate whether for this APN, the UE is
        allowed to use the PDN GW in the domain of the HPLMN only, or additionally, the PDN GW in the domain of the
        VPLMN.. If this AVP is not present, this means that the UE is not allowed to use PDN GWs in the domain of the
        VPLMN. The following values are defined:
            NOTALLOWED (0)
            ALLOWED (1)
     */
    public boolean hasVPLMNDynamicAddressAllowed();
    public VPLMNDynamicAddressAllowed getVPLMNDynamicAddressAllowed();
    public void setVPLMNDynamicAddressAllowed(VPLMNDynamicAddressAllowed vplmnDynamicAddressAllowed);

    /*
        7.3.36 Service-Selection
        The Service-Selection AVP is of type of UTF8String. This AVP shall contain either the APN Network Identifier (i.e. an
        APN without the Operator Identifier) per 3GPP TS 23.003 [3], clauses 9.1 & 9.1.1, or this AVP shall contain the wild
        card value per 3GPP TS 23.003 [3], clause 9.1.2, and 3GPP TS 23.008 [30], clause 2.13.6).
        The contents of the Service-Selection AVP shall be formatted as a character string composed of one or more labels
        separated by dots ("."), or as the wild card APN, i.e., consisting of only one ASCII label, "*".
     */
    public boolean hasServiceSelection();
    public String getServiceSelection();
    public void setServiceSelection(String serviceSelection);

    /*
        7.3.129 Ext-PDP-Address AVP
        The Ext-PDP-Address AVP is of type Address and indicates an additional address of the data protocol, and it may be
        included when the PDP supports dual-stack (IPv4v6).
     */
    public boolean hasExtPDPAddress();
    public Address getExtPDPAddress();
    public void setExtPDPAddress(Address extPDPAddress);

    /*
        7.3.135 SIPTO-Permission
        The SIPTO-Permission AVP is of type Enumerated. It shall indicate whether the traffic associated with this particular
        APN is allowed or not for SIPTO above RAN.
        The following values are defined:
            SIPTO_above_RAN _ALLOWED (0)
            SIPTO_above_RAN _NOTALLOWED (1)
     */

    public boolean hasSIPTOPermission();
    public SIPTOPermission getSIPTOPermission();
    public void setSIPTOPermission(SIPTOPermission siptoPermission);

    public boolean hasLIPAPermission();
    public LIPAPermission getLIPAPermission();
    public void setLIPAPermission(LIPAPermission lipaPermission);

    public boolean hasRestorationPriority();
    public long getRestorationPriority();
    public void setRestorationPriority(long restorationPriority);

    public boolean hasSIPTOLocalNetworkPermission();
    public long getSIPTOLocalNetworkPermission();
    public void setSIPTOLocalNetworkPermission(long siptoLocalNetworkPermission);

    public boolean hasAMBR();
    public AMBRAvp getAMBR();
    public void setAMBR(AMBRAvp ambr);

    public boolean hasAPNOIReplacement();
    public String getAPNOIReplacement();
    public void setAPNOIReplacement(String apnoiReplacement);
}