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
 * Defines an interface representing the APN-Configuration grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.3.35 APN-Configuration
 * 
 * The APN-Configuration AVP is of type Grouped. It shall contain the information related to the
 * user's subscribed APN configurations. The Context-Identifier in the APN-Configuration AVP shall
 * identify that APN configuration, and it shall not have a value of zero. Furthermore, the 
 * Context-Identifier in the APN-Configuration AVP shall uniquely identify the EPS APN
 * configuration per subscription. For a particular EPS user having multiple APN configurations, 
 * the Service-Selection AVP values shall be unique across APN-Configuration AVPs.
 * 
 * The AVP format shall conform to:
 * APN-Configuration ::= < AVP header: 1430 10415 >
 *                       { Context-Identifier }
 *                   * 2 [ Served-Party-IP-Address ]
 *                       { PDN-Type }
 *                       { Service-Selection}
 *                       [ EPS-Subscribed-QoS Profile ]
 *                       [ VPLMN-Dynamic-Address-Allowed ]
 *                       [ MIP6-Agent-Info ]
 *                       [ Visited-Network-Identifier ]
 *                       [ PDN-GW-Allocation-Type ]
 *                       [ 3GPP-Charging-Characteristics ]
 *                       [ AMBR ]
 *                      *[ Specific-APN-Info ]
 *                       [ APN-OI-Replacement ]
 *                       [ SIPTO-Permission ]      //R12
 *                       [ LIPA-Permission ]       //R12
 *                       [ Restoration-Priority ]  //R12
 *                       [ SIPTO-Local-Network-Permission ] //R12
 *                       [ WLAN-offloadability ]   //R12
 *                      *[ AVP ]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface APNConfigurationAvp extends GroupedAvp {

    public boolean hasContextIdentifier();

    public long getContextIdentifier();

    public void setContextIdentifier(long contextIdentifier);

    public boolean hasPDNType();

    public void setPDNType(PDNType pt);

    public PDNType getPDNType();

    public boolean hasServiceSelection();

    public String getServiceSelection();

    public void setServiceSelection(String serviceSelection);

    public boolean hasEPSSubscribedQoSProfile();

    public EPSSubscribedQoSProfileAvp getEPSSubscribedQoSProfile();

    public void setEPSSubscribedQoSProfile(EPSSubscribedQoSProfileAvp qp);

    public boolean hasVPLMNDynamicAddressAllowed();

    public VPLMNDynamicAddressAllowed getVPLMNDynamicAddressAllowed();

    public void setVPLMNDynamicAddressAllowed(VPLMNDynamicAddressAllowed daa);

    public boolean hasPDNGWAllocationType();

    public PDNGWAllocationType getPDNGWAllocationType();

    public void setPDNGWAllocationType(PDNGWAllocationType at);

    public boolean hasAMBR();

    public AMBRAvp getAMBR();

    public void setAMBR(AMBRAvp ambr);

    /**
     * Returns true if the MIP6-Agent-Info AVP is present in the message.
     *
     * @return true if the MIP6-Agent-Info AVP is present in the message, false otherwise
     */
    public boolean hasMIP6AgentInfo();

    /**
     * Returns the value of the MIP6-Agent-Info AVP, of type Grouped.
     *
     * @return the value of the MIP6-Agent-Info AVP or null if it has not been set on this message
     */
    public MIP6AgentInfoAvp getMIP6AgentInfo();

    /**
     * Sets the value of the MIP6-Agent-Info AVP, of type Grouped.
     *
     * @param mip the new value for the MIP6-Agent-Info AVP
     */
    public void setMIP6AgentInfo(MIP6AgentInfoAvp mip);

    /**
     * Returns true if the SIP-TO-Permission AVP is present in the message.
     *
     * @return true if the SIP-TO-Permission AVP is present in the message, false otherwise
     */
    public boolean hasSIPTOPermission();

    /**
     * Returns the value of the SIP-TO-Permission AVP, of type Enumerated.
     *
     * @return the value of the SIP-TO-Permission AVP or null if it has not been set on this message
     */
    public SIPTOPermission getSIPTOPermission();

    /**
     * Sets the value of the SIP-TO-Permission AVP, of type Grouped.
     *
     * @param siptoPermission the new value for the SIP-TO-Permission AVP
     */
    public void setSIPTOPermission(SIPTOPermission siptoPermission);

    /**
     * Returns true if the LIPA-Permission AVP is present in the message.
     *
     * @return true if the LIPA-Permission AVP is present in the message, false otherwise
     */
    public boolean hasLIPAPermission();

    /**
     * Returns the value of the LIPA-Permission AVP, of type Enumerated.
     *
     * @return the value of the LIPA-Permission AVP or null if it has not been set on this message
     */
    public LIPAPermission getLIPAPermission();

    /**
     * Sets the value of the LIPA-Permission AVP, of type Grouped.
     *
     * @param lipaPermission the new value for the LIPA-Permission AVP
     */
    public void setLIPAPermission(LIPAPermission lipaPermission);

    /**
     * Returns true if the Restoration-Priority AVP is present in the message.
     *
     * @return true if the Restoration-Priority AVP is present in the message, false otherwise
     */
    public boolean hasRestorationPriority();

    /**
     * Returns the value of the Restoration-Priority AVP, of type Unsigned32.
     *
     * @return the value of the Restoration-Priority AVP or null if it has not been set on this message
     */
    public long getRestorationPriority();

    /**
     * Sets the value of the Restoration-Priority AVP, of type Grouped.
     *
     * @param restorationPriority the new value for the Restoration-Priority AVP
     */
    public void setRestorationPriority(long restorationPriority);

    /**
     * Returns true if the SIP-TO-Local-Network-Permission AVP is present in the message.
     *
     * @return true if the SIP-TO-Local-Network-Permission AVP is present in the message, false otherwise
     */
    public boolean hasSIPTOLocalNetworkPermission();

    /**
     * Returns the value of the SIP-TO-Local-Network-Permission AVP, of type Unsigned32.
     *
     * @return the value of the SIP-TO-Local-Network-Permission AVP or null if it has not been set on this message
     */
    public long getSIPTOLocalNetworkPermission();

    /**
     * Sets the value of the SIP-TO-Local-Network-Permission AVP, of type Grouped.
     *
     * @param siptoLocalNetworkPermission the new value for the SIP-TO-Local-Network-Permission AVP
     */
    public void setSIPTOLocalNetworkPermission(long siptoLocalNetworkPermission);

    /**
     * Returns true if the WLAN-offloadability AVP is present in the message.
     *
     * @return true if the WLAN-offloadability AVP is present in the message, false otherwise
     */
    public boolean hasWLANoffloadability();

    /**
     * Returns the value of the WLAN-offloadability AVP, of type Grouped.
     *
     * @return the value of the WLAN-offloadability AVP or null if it has not been set on this message
     */
    public WLANoffloadabilityAvp getWLANoffloadability();

    /**
     * Sets the value of the WLAN-offloadability AVP, of type Grouped.
     *
     * @param wlaNoffloadability the new value for theWLAN-offloadability AVP
     */
    public void setWLANoffloadability(WLANoffloadabilityAvp wlaNoffloadability);

    /**
     * Returns true if the Specific-APN-Info AVP is present in the message.
     *
     * @return true if the Specific-APN-Info AVP is present in the message, false otherwise
     */
    public boolean hasSpecificAPNInfo();

    /**
     * Sets the value of the Specific-APN-Info AVP, of type Grouped.
     *
     * @param specificAPNInfo the new value for the Specific-APN-Info AVP
     */
    public void setSpecificAPNInfo(SpecificAPNInfoAvp specificAPNInfo);

    /**
     * Returns a set with all the Specific-APN-Info AVPs present in the message.
     *
     * @return a set of values with Specific-APN-Info AVPs or null if it has not been set on this message
     */
    public SpecificAPNInfoAvp[] getSpecificAPNInfos();

    /**
     * Set of Specific-APN-Info APVs to be added into the message.
     *
     * @param specificAPNInfos set of Specific-APN-Info AVPs
     */
    public void setSpecificAPNInfos(SpecificAPNInfoAvp[] specificAPNInfos);
}