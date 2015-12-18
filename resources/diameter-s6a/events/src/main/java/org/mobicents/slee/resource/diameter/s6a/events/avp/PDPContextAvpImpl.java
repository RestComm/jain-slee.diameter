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
import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import net.java.slee.resource.diameter.s6a.events.avp.*;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.PDPContextAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class PDPContextAvpImpl extends GroupedAvpImpl implements PDPContextAvp {

    public PDPContextAvpImpl() {
        super();
    }

    public PDPContextAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public boolean hasContextIdentifier() {
        return hasAvp(DiameterS6aAvpCodes.CONTEXT_IDENTIFIER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getContextIdentifier() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.CONTEXT_IDENTIFIER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setContextIdentifier(long contextIdentifier) {
        addAvp(DiameterS6aAvpCodes.CONTEXT_IDENTIFIER, DiameterS6aAvpCodes.S6A_VENDOR_ID, contextIdentifier);
    }

    public boolean hasPDPType() {
        return hasAvp(DiameterS6aAvpCodes.PDP_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getPDPType() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.PDP_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setPDPType(byte[] pdpType) {
        addAvp(DiameterS6aAvpCodes.PDP_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, pdpType);
    }

    public boolean hasPDPAddress() {
        return hasAvp(DiameterS6aAvpCodes.PDP_ADDRESS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public Address getPDPAddress() {
        return getAvpAsAddress(DiameterS6aAvpCodes.PDP_ADDRESS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setPDPAddress(Address pdpAddress) {
        addAvp(DiameterS6aAvpCodes.PDP_ADDRESS, DiameterS6aAvpCodes.S6A_VENDOR_ID, pdpAddress);
    }

    public boolean hasExtPDPType() {
        return hasAvp(DiameterS6aAvpCodes.EXT_PDP_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getExtPDPType() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.EXT_PDP_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setExtPDPType(byte[] extPDPType) {
        addAvp(DiameterS6aAvpCodes.EXT_PDP_TYPE, DiameterS6aAvpCodes.S6A_VENDOR_ID, extPDPType);
    }

    public boolean hasQoSSubscribed() {
        return hasAvp(DiameterS6aAvpCodes.QOS_SUBSCRIBED, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getQoSSubscribed() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.QOS_SUBSCRIBED, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setQoSSubscribed(byte[] qoSSubscribed) {
        addAvp(DiameterS6aAvpCodes.QOS_SUBSCRIBED, DiameterS6aAvpCodes.S6A_VENDOR_ID, qoSSubscribed);
    }

    public boolean hasVPLMNDynamicAddressAllowed() {
        return hasAvp(DiameterS6aAvpCodes.VPLMN_DYNAMIC_ADDRESS_ALLOWED, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public VPLMNDynamicAddressAllowed getVPLMNDynamicAddressAllowed() {
        return (VPLMNDynamicAddressAllowed) getAvpAsEnumerated(DiameterS6aAvpCodes.VPLMN_DYNAMIC_ADDRESS_ALLOWED,
                DiameterS6aAvpCodes.S6A_VENDOR_ID, VPLMNDynamicAddressAllowed.class);
    }

    public void setVPLMNDynamicAddressAllowed(VPLMNDynamicAddressAllowed vplmnDynamicAddressAllowed) {
        addAvp(DiameterS6aAvpCodes.VPLMN_DYNAMIC_ADDRESS_ALLOWED, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               vplmnDynamicAddressAllowed.getValue());
    }

    public boolean hasServiceSelection() {
        return hasAvp(DiameterS6aAvpCodes.SERVICE_SELECTION);
    }

    public String getServiceSelection() {
        return getAvpAsUTF8String(DiameterS6aAvpCodes.SERVICE_SELECTION);
    }

    public void setServiceSelection(String serviceSelection) {
        addAvp(DiameterS6aAvpCodes.SERVICE_SELECTION, serviceSelection);
    }

    public boolean hasExtPDPAddress() {
        return hasAvp(DiameterS6aAvpCodes.EXT_PDP_ADDRESS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public Address getExtPDPAddress() {
        return getAvpAsAddress(DiameterS6aAvpCodes.EXT_PDP_ADDRESS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setExtPDPAddress(Address extPDPAddress) {
        addAvp(DiameterS6aAvpCodes.EXT_PDP_ADDRESS, DiameterS6aAvpCodes.S6A_VENDOR_ID, extPDPAddress);
    }

    public boolean hasSIPTOPermission(){
        return hasAvp(DiameterS6aAvpCodes.SIPTO_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public SIPTOPermission getSIPTOPermission(){
        return (SIPTOPermission) getAvpAsEnumerated(DiameterS6aAvpCodes.SIPTO_PERMISSION,
                DiameterS6aAvpCodes.S6A_VENDOR_ID, SIPTOPermission.class);
    }

    public void setSIPTOPermission(SIPTOPermission siptoPermission){
        addAvp(DiameterS6aAvpCodes.SIPTO_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID, siptoPermission.getValue());
    }

    public boolean hasLIPAPermission(){
        return hasAvp(DiameterS6aAvpCodes.LIPA_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }
    public LIPAPermission getLIPAPermission(){
        return (LIPAPermission) getAvpAsEnumerated(DiameterS6aAvpCodes.LIPA_PERMISSION,
                                                   DiameterS6aAvpCodes.S6A_VENDOR_ID, LIPAPermission.class);
    }
    public void setLIPAPermission(LIPAPermission lipaPermission){
        addAvp(DiameterS6aAvpCodes.LIPA_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID, lipaPermission.getValue());
    }

    public boolean hasRestorationPriority() {
        return hasAvp(DiameterS6aAvpCodes.RESTORATION_PRIORITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getRestorationPriority() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.RESTORATION_PRIORITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setRestorationPriority(long restorationPriority) {
        addAvp(DiameterS6aAvpCodes.RESTORATION_PRIORITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, restorationPriority);
    }

    public boolean hasSIPTOLocalNetworkPermission() {
        return hasAvp(DiameterS6aAvpCodes.SIPTO_LOCAL_NETWORK_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getSIPTOLocalNetworkPermission() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.SIPTO_LOCAL_NETWORK_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setSIPTOLocalNetworkPermission(long siptoLocalNetworkPermission) {
        addAvp(DiameterS6aAvpCodes.SIPTO_LOCAL_NETWORK_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               siptoLocalNetworkPermission);
    }

    public boolean hasAMBR() {
        return hasAvp(DiameterS6aAvpCodes.AMBR, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public AMBRAvp getAMBR() {
        return (AMBRAvp) getAvpAsCustom(DiameterS6aAvpCodes.AMBR, DiameterS6aAvpCodes.S6A_VENDOR_ID, AMBRAvpImpl.class);
    }

    public void setAMBR(AMBRAvp ambr) {
        addAvp(ambr);
    }

    public boolean hasAPNOIReplacement() {
        return hasAvp(DiameterS6aAvpCodes.APN_OI_REPLACEMENT, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public String getAPNOIReplacement() {
        return getAvpAsUTF8String(DiameterS6aAvpCodes.APN_OI_REPLACEMENT, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setAPNOIReplacement(String apnoiReplacement) {
        addAvp(DiameterS6aAvpCodes.APN_OI_REPLACEMENT, DiameterS6aAvpCodes.S6A_VENDOR_ID, apnoiReplacement);
    }
}