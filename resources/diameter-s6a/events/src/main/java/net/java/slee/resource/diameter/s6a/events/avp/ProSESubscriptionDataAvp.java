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

import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the ProSe-Subscription-Data grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.344 V12.3.0) specification:
 * 
 * <pre>
 * 6.3.2 ProSe-Subscription-Data
 *
 * The ProSe-Subscription-Data AVP is of type Group. It shall contain the ProSe related subscription data.
 * AVP format
 *      ProSe-Subscription-Data ::= <AVP header: 3701 10415>
 *                                  { ProSe-Permission }
 *                                  *[ ProSe-Allowed-PLMN ]
 *                                  [ 3GPP-Charging-Characteristics ]
 *                                  *[AVP]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public interface ProSESubscriptionDataAvp extends GroupedAvp {

    /*
        6.3.3 ProSe-Permission
        The ProSe-Permission AVP is of type Unsigned32 and it shall contain a bit mask that indicates the permissions for
        ProSe subscribed by the user.
     */
    public boolean hasProSePermission();
    public long getProSePermission();
    public void setProSePermission(long proSePermission);

    /*
        6.3.4 ProSe-Allowed-PLMN
        The ProSe-Allowed-PLMN AVP is of type Group. It shall contain the PLMN where the UE is authorised to announce
        or monitor or both for ProSe Discovery or to use ProSe direct communication.
     */
    public boolean hasProSeAllowedPLMN();
    public void setProSeAllowedPLMN(ProSeAllowedPLMNAvp proSeAllowedPLMN);
    public ProSeAllowedPLMNAvp[] getProSeAllowedPLMNs();
    public void setProSeAllowedPLMNs(ProSeAllowedPLMNAvp[] proSeAllowedPLMNs);

    /*
     */
    public boolean has3GPPChargingCharacteristics();
    public String get3GPPChargingCharacteristics();
    public void set3GPPChargingCharacteristics(String threeGPPChargingCharacteristics);
}
