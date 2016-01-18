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
 * Implementation for {@link SubscriptionDataAvp}
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class SubscriptionDataAvpImpl extends GroupedAvpImpl implements SubscriptionDataAvp {

    public SubscriptionDataAvpImpl() {
        super();
    }

    public SubscriptionDataAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public boolean hasSubscriberStatus() {
        return hasAvp(DiameterS6aAvpCodes.SUBSCRIBER_STATUS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setSubscriberStatus(SubscriberStatus ss) {
        addAvp(DiameterS6aAvpCodes.SUBSCRIBER_STATUS, DiameterS6aAvpCodes.S6A_VENDOR_ID, ss.getValue());
    }

    public SubscriberStatus getSubscriberStatus() {
        return (SubscriberStatus) getAvpAsEnumerated(DiameterS6aAvpCodes.SUBSCRIBER_STATUS, DiameterS6aAvpCodes.S6A_VENDOR_ID, SubscriberStatus.class);
    }

    public boolean hasMSISDN() {
        return hasAvp(DiameterS6aAvpCodes.MSISDN, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getMSISDN() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.MSISDN, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setMSISDN(byte[] msisdn) {
        addAvp(DiameterS6aAvpCodes.MSISDN, DiameterS6aAvpCodes.S6A_VENDOR_ID, msisdn);
    }

    public boolean hasSTNSR() {
        return hasAvp(DiameterS6aAvpCodes.STN_SR, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getSTNSR() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.STN_SR, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setSTNSR(byte[] stnsr) {
        addAvp(DiameterS6aAvpCodes.STN_SR, DiameterS6aAvpCodes.S6A_VENDOR_ID, stnsr);
    }

    public boolean hasICSIndicator() {
        return hasAvp(DiameterS6aAvpCodes.ICS_INDICATOR, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public ICSIndicator getICSIndicator() {
        return (ICSIndicator) getAvpAsEnumerated(DiameterS6aAvpCodes.ICS_INDICATOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, ICSIndicator.class);
    }

    public void setICSIndicator(ICSIndicator icsIndicator) {
        addAvp(DiameterS6aAvpCodes.ICS_INDICATOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, icsIndicator.getValue());
    }

    public boolean hasNetworkAccessMode() {
        return hasAvp(DiameterS6aAvpCodes.NETWORK_ACCESS_MODE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setNetworkAccessMode(NetworkAccessMode nam) {
        addAvp(DiameterS6aAvpCodes.NETWORK_ACCESS_MODE, DiameterS6aAvpCodes.S6A_VENDOR_ID, nam.getValue());
    }

    public NetworkAccessMode getNetworkAccessMode() {
        return (NetworkAccessMode) getAvpAsEnumerated(DiameterS6aAvpCodes.NETWORK_ACCESS_MODE, DiameterS6aAvpCodes.S6A_VENDOR_ID, NetworkAccessMode.class);
    }

    public boolean has3GPPChargingCharacteristics() {
        return hasAvp(DiameterS6aAvpCodes.TGPP_CHARGING_CHARACTERISTICS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public String get3GPPChargingCharacteristics() {
        return getAvpAsUTF8String(DiameterS6aAvpCodes.TGPP_CHARGING_CHARACTERISTICS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void set3GPPChargingCharacteristics(String threeGPPChargingCharacteristics) {
        addAvp(DiameterS6aAvpCodes.TGPP_CHARGING_CHARACTERISTICS, DiameterS6aAvpCodes.S6A_VENDOR_ID, threeGPPChargingCharacteristics);
    }

    public boolean hasAMBR() {
        return hasAvp(DiameterS6aAvpCodes.AMBR, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public AMBRAvp getAMBR() {
        return (AMBRAvp) getAvpAsCustom(DiameterS6aAvpCodes.AMBR, DiameterS6aAvpCodes.S6A_VENDOR_ID, AMBRAvpImpl.class);
    }

    public void setAMBR(AMBRAvp ambr) {
        addAvp(DiameterS6aAvpCodes.AMBR, DiameterS6aAvpCodes.S6A_VENDOR_ID, ambr.byteArrayValue());
    }

    public boolean hasAPNConfigurationProfile() {
        return hasAvp(DiameterS6aAvpCodes.APN_CONFIGURATION_PROFILE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public APNConfigurationProfileAvp getAPNConfigurationProfile() {
        return (APNConfigurationProfileAvp) getAvpAsCustom(DiameterS6aAvpCodes.APN_CONFIGURATION_PROFILE, DiameterS6aAvpCodes.S6A_VENDOR_ID, APNConfigurationProfileAvpImpl.class);
    }

    public void setAPNConfigurationProfile(APNConfigurationProfileAvp apnconfig) {
        addAvp(DiameterS6aAvpCodes.APN_CONFIGURATION_PROFILE, DiameterS6aAvpCodes.S6A_VENDOR_ID, apnconfig.byteArrayValue());
    }

    public boolean hasOperatorDeterminedBarring() {
        return hasAvp(DiameterS6aAvpCodes.OPERATOR_DETERMINED_BARRING, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getOperatorDeterminedBarring() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.OPERATOR_DETERMINED_BARRING, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setOperatorDeterminedBarring(long operatorDeterminedBarring) {
        addAvp(DiameterS6aAvpCodes.OPERATOR_DETERMINED_BARRING, DiameterS6aAvpCodes.S6A_VENDOR_ID, operatorDeterminedBarring);
    }

    public boolean hasHPLMNODB() {
        return hasAvp(DiameterS6aAvpCodes.HPLMN_ODB, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getHPLMNODB() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.HPLMN_ODB, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setHPLMNODB(long hplmnOdb) {
        addAvp(DiameterS6aAvpCodes.HPLMN_ODB, DiameterS6aAvpCodes.S6A_VENDOR_ID, hplmnOdb);
    }

    public byte[][] getRegionalSubscriptionZoneCodes() {
        return getAvpsAsOctetString(DiameterS6aAvpCodes.REGIONAL_SUBSCRIPTION_ZONE_CODE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setRegionalSubscriptionZoneCode(byte[] rszc) {
        addAvp(DiameterS6aAvpCodes.REGIONAL_SUBSCRIPTION_ZONE_CODE, DiameterS6aAvpCodes.S6A_VENDOR_ID, rszc);
    }

    public void setRegionalSubscriptionZoneCodes(byte[][] rszcs) {
        for (byte[] rszc : rszcs) {
            setRegionalSubscriptionZoneCode(rszc);
        }
    }

    public boolean hasAccessRestrictionData() {
        return hasAvp(DiameterS6aAvpCodes.ACCESS_RESTRICTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getAccessRestrictionData() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.ACCESS_RESTRICTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setAccessRestrictionData(long ard) {
        addAvp(DiameterS6aAvpCodes.ACCESS_RESTRICTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, ard);
    }

    public boolean hasAPNOIReplacement() {
        return hasAvp(DiameterS6aAvpCodes.APN_OI_REPLACEMENT, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public String getAPNOIReplacement() {
        return getAvpAsUTF8String(DiameterS6aAvpCodes.APN_OI_REPLACEMENT, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setAPNOIReplacement(String apnOiReplacement) {
        addAvp(DiameterS6aAvpCodes.APN_OI_REPLACEMENT, DiameterS6aAvpCodes.S6A_VENDOR_ID, apnOiReplacement);
    }

    public boolean hasLCSInfo() {
        return hasAvp(DiameterS6aAvpCodes.LCS_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public LCSInfoAvp getLCSInfo() {
        return (LCSInfoAvp) getAvpAsCustom(DiameterS6aAvpCodes.LCS_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                LCSInfoAvpImpl.class);
    }

    public void setLCSInfo(LCSInfoAvp lcsInfoAvp) {
        addAvp(DiameterS6aAvpCodes.LCS_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID, lcsInfoAvp.byteArrayValue());
    }

    public boolean hasTeleserviceList() {
        return hasAvp(DiameterS6aAvpCodes.TELESERVICE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public TeleserviceListAvp getTeleserviceList() {
        return (TeleserviceListAvp) getAvpAsCustom(DiameterS6aAvpCodes.TELESERVICE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                TeleserviceListAvpImpl.class);
    }

    public void setTeleserviceList(TeleserviceListAvp teleserviceList) {
        addAvp(DiameterS6aAvpCodes.TELESERVICE_LIST, DiameterS6aAvpCodes.S6A_VENDOR_ID, teleserviceList.byteArrayValue());
    }

    public boolean hasCallBarringInfo() {
        return hasAvp(DiameterS6aAvpCodes.CALL_BARRING_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public CallBarringInfoAvp getCallBarringInfo() {
        return (CallBarringInfoAvp) getAvpAsCustom(DiameterS6aAvpCodes.CALL_BARRING_INFO,
                DiameterS6aAvpCodes.S6A_VENDOR_ID,
                CallBarringInfoAvpImpl.class);
    }

    public void setCallBarringInfo(CallBarringInfoAvp callBarringInfo) {
        addAvp(DiameterS6aAvpCodes.CALL_BARRING_INFO, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                callBarringInfo.byteArrayValue());
    }

    public boolean hasRATFrequencySelectionPriorityID() {
        return hasAvp(DiameterS6aAvpCodes.RAT_FREQUENCY_SELECTION_PRIORITY_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getRATFrequencySelectionPriorityID() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.RAT_FREQUENCY_SELECTION_PRIORITY_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setRATFrequencySelectionPriorityID(long rfspid) {
        addAvp(DiameterS6aAvpCodes.RAT_FREQUENCY_SELECTION_PRIORITY_ID, DiameterS6aAvpCodes.S6A_VENDOR_ID, rfspid);
    }

    public boolean hasTraceData() {
        return hasAvp(DiameterS6aAvpCodes.TRACE_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public TraceDataAvp getTraceData() {
        return (TraceDataAvp) getAvpAsCustom(DiameterS6aAvpCodes.TRACE_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                TraceDataAvpImpl.class);
    }

    public void setTraceData(TraceDataAvp traceData) {
        addAvp(DiameterS6aAvpCodes.TRACE_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID, traceData.byteArrayValue());
    }

    public boolean hasGPRSSubscriptionData() {
        return hasAvp(DiameterS6aAvpCodes.GPRS_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public GPRSSubscriptionDataAvp getGPRSSubscriptionData() {
        return (GPRSSubscriptionDataAvp) getAvpAsCustom(DiameterS6aAvpCodes.GPRS_SUBSCRIPTION_DATA,
                DiameterS6aAvpCodes.S6A_VENDOR_ID,
                GPRSSubscriptionDataAvpImpl.class);
    }

    public void setGPRSSubscriptionData(GPRSSubscriptionDataAvp gprsSubscriptionData) {
        addAvp(DiameterS6aAvpCodes.GPRS_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                gprsSubscriptionData.byteArrayValue());
    }

    public boolean hasCSGSubscriptionData() {
        return hasAvp(DiameterS6aAvpCodes.CSG_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setCSGSubscriptionData(CSGSubscriptionDataAvp csgSubscriptionData) {
        addAvp(DiameterS6aAvpCodes.CSG_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                csgSubscriptionData.byteArrayValue());
    }

    public CSGSubscriptionDataAvp[] getCSGSubscriptionDatas(){
        return (CSGSubscriptionDataAvp[]) getAvpsAsCustom(DiameterS6aAvpCodes.CSG_SUBSCRIPTION_DATA,
                                                DiameterS6aAvpCodes.S6A_VENDOR_ID, CSGSubscriptionDataAvpImpl.class);
    }

    public void setCSGSubscriptionDatas(CSGSubscriptionDataAvp[] csgSubscriptionDatas){
        for (CSGSubscriptionDataAvp aux : csgSubscriptionDatas){
            setCSGSubscriptionData(aux);
        }
    }

    public boolean hasRoamingRestrictedDueToUnsupportedFeature() {
        return hasAvp(DiameterS6aAvpCodes.ROAMING_RESTRICTED_DUE_TO_UNSUPPORTED_FEATURE, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setRoamingRestrictedDueToUnsupportedFeature(RoamingRestrictedDueToUnsupportedFeature rrdtuf) {
        addAvp(DiameterS6aAvpCodes.ROAMING_RESTRICTED_DUE_TO_UNSUPPORTED_FEATURE, DiameterS6aAvpCodes.S6A_VENDOR_ID, rrdtuf.getValue());
    }

    public RoamingRestrictedDueToUnsupportedFeature getRoamingRestrictedDueToUnsupportedFeature() {
        return (RoamingRestrictedDueToUnsupportedFeature) getAvpAsEnumerated(DiameterS6aAvpCodes.ROAMING_RESTRICTED_DUE_TO_UNSUPPORTED_FEATURE, DiameterS6aAvpCodes.S6A_VENDOR_ID, RoamingRestrictedDueToUnsupportedFeature.class);
    }

    public boolean hasMPSPriority() {
        return hasAvp(DiameterS6aAvpCodes.MPS_PRIORITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getMPSPriority() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.MPS_PRIORITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setMPSPriority(long mpsPriority) {
        addAvp(DiameterS6aAvpCodes.MPS_PRIORITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, mpsPriority);
    }

    public boolean hasVPLMNLIPAAllowed() {
        return hasAvp(DiameterS6aAvpCodes.VPLMNLIPA_ALLOWED, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public VPLMNLIPAAllowed getVPLMNLIPAAllowed() {
        return (VPLMNLIPAAllowed) getAvpAsEnumerated(DiameterS6aAvpCodes.VPLMNLIPA_ALLOWED,
                DiameterS6aAvpCodes.S6A_VENDOR_ID, VPLMNLIPAAllowed.class);
    }

    public void setVPLMNLIPAAllowed(VPLMNLIPAAllowed vplmnlipaAllowed) {
        addAvp(DiameterS6aAvpCodes.VPLMNLIPA_ALLOWED, DiameterS6aAvpCodes.S6A_VENDOR_ID, vplmnlipaAllowed.getValue());
    }

    public boolean hasSubscribedPeriodicRAUTAUTimer(){
        return hasAvp(DiameterS6aAvpCodes.SUBSCRIBED_PERIODIC_RAU_TAU_TIMER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }
    public long getSubscribedPeriodicRAUTAUTimer(){
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.SUBSCRIBED_PERIODIC_RAU_TAU_TIMER,
                                  DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }
    public void setSubscribedPeriodicRAUTAUTimer(long subscribedPeriodicRAUTAUTimer){
        addAvp(DiameterS6aAvpCodes.SUBSCRIBED_PERIODIC_RAU_TAU_TIMER, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               subscribedPeriodicRAUTAUTimer);
    }

    public boolean hasRelayNodeIndicator() {
        return hasAvp(DiameterS6aAvpCodes.RELAY_NODE_INDICATOR, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public RelayNodeIndicator getRelayNodeIndicator() {
        return (RelayNodeIndicator) getAvpAsEnumerated(DiameterS6aAvpCodes.RELAY_NODE_INDICATOR,
                                                       DiameterS6aAvpCodes.S6A_VENDOR_ID, RelayNodeIndicator.class);
    }

    public void setRelayNodeIndicator(RelayNodeIndicator relayNodeIndicator) {
        addAvp(DiameterS6aAvpCodes.RELAY_NODE_INDICATOR, DiameterS6aAvpCodes.S6A_VENDOR_ID, relayNodeIndicator.getValue());
    }

    public boolean hasMDTUserConsent() {
        return hasAvp(DiameterS6aAvpCodes.MDT_USER_CONSENT, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public MDTUserConsent getMDTUserConsent() {
        return (MDTUserConsent) getAvpAsEnumerated(DiameterS6aAvpCodes.MDT_USER_CONSENT, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                                                   MDTUserConsent.class);
    }

    public void setMDTUserConsent(MDTUserConsent mdtUserConsent) {
        addAvp(DiameterS6aAvpCodes.MDT_USER_CONSENT, DiameterS6aAvpCodes.S6A_VENDOR_ID, mdtUserConsent.getValue());
    }

    public boolean hasSubscribedVSRVCC() {
        return hasAvp(DiameterS6aAvpCodes.SUBSCRIBED_VSRVCC, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public SubscribedVSRVCC getSubscribedVSRVCC() {
        return (SubscribedVSRVCC) getAvpAsEnumerated(DiameterS6aAvpCodes.SUBSCRIBED_VSRVCC,
                                                     DiameterS6aAvpCodes.S6A_VENDOR_ID, SubscribedVSRVCC.class);
    }

    public void setSubscribedVSRVCC(SubscribedVSRVCC subscribedVSRVCC) {
        addAvp(DiameterS6aAvpCodes.SUBSCRIBED_VSRVCC, DiameterS6aAvpCodes.S6A_VENDOR_ID, subscribedVSRVCC.getValue());
    }

    public boolean hasAMSISDN() {
        return hasAvp(DiameterS6aAvpCodes.A_MSISDN, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public byte[] getAMSISDN() {
        return getAvpAsOctetString(DiameterS6aAvpCodes.A_MSISDN, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setAMSISDN(byte[] amsisdn) {
        addAvp(DiameterS6aAvpCodes.A_MSISDN, DiameterS6aAvpCodes.S6A_VENDOR_ID, amsisdn);
    }

    public boolean hasSubscriptionDataFlags() {
        return hasAvp(DiameterS6aAvpCodes.SUBSCRIPTION_DATA_FLAGS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getSubscriptionDataFlags() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.SUBSCRIPTION_DATA_FLAGS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setSubscriptionDataFlags(long subscriptionDataFlags) {
        addAvp(DiameterS6aAvpCodes.SUBSCRIPTION_DATA_FLAGS, DiameterS6aAvpCodes.S6A_VENDOR_ID, subscriptionDataFlags);
    }

    public boolean hasProSeSubscriptionData() {
        return hasAvp(DiameterS6aAvpCodes.PROSE_SUBSCRIPTION_DATA, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public ProSESubscriptionDataAvp getProSeSubscriptionData() {
        return (ProSESubscriptionDataAvp) getAvpAsCustom(DiameterS6aAvpCodes.PROSE_SUBSCRIPTION_DATA,
                                                         DiameterS6aAvpCodes.S6A_VENDOR_ID,
                                                         ProSeSubscriptionDataAvpImpl.class);
    }

    public void setProSeSubscriptionData(ProSESubscriptionDataAvp proSeSubscriptionDataAvp) {
        addAvp(proSeSubscriptionDataAvp);
    }
}