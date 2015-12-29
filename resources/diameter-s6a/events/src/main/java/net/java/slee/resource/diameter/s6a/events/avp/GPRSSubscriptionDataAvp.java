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
 * Defines an interface representing the GPRS-Subscription-Data grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.72 GPRS-Subscription-Data
 *
 * The GPRS-Subscription-Data AVP is of type Grouped. It shall contain the information related to the user profile
 * relevant for GPRS.
 * AVP format:
 * GPRS-Subscription-Data ::= <AVP header: 1467 10415>
 *                            { Complete-Data-List-Included-Indicator }
 *                            *50{PDP-Context}
 *                            *[AVP]
 * NOTE: The max number of PDP-Context AVP aligns with the value of maxNumOfPDP-Contexts as defined in
 * 3GPP TS 29.002[24].
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface GPRSSubscriptionDataAvp extends GroupedAvp {
    /*
        7.3.73 Complete-Data-List-Included-Indicator
        The Complete-Data-List-Included-Indicator AVP is of type Enumerated. The following values are defined:
        All_PDP_CONTEXTS_INCLUDED (0)
        MODIFIED/ADDED_PDP CONTEXTS_INCLUDED (1)
    */
    public boolean hasCompleteDataListIncludedIndicator();
    public CompleteDataListIncludedIndicator getCompleteDataListIncludedIndicator();
    public void setCompleteDataListIncludedIndicator(CompleteDataListIncludedIndicator completeDataListIncludedIndicator);

    /*
        7.3.74 PDP-Context
        The PDP-Context AVP is of type Grouped. For a particular GPRS user having multiple PDP Context configurations,
        the Service-Selection AVP values may be the same for different PDP-Context AVPs.
        AVP format
            PDP-Context ::= <AVP header: 1469 10415>
                            { Context-Identifier }
                            { PDP-Type }
                            [ PDP-Address ]
                            { QoS-Subscribed }
                            [ VPLMN-Dynamic-Address-Allowed ]
                            { Service-Selection }
                            [3GPP-Charging-Characteristics]
                            [ Ext-PDP-Type ]
                            [ Ext-PDP-Address ]
                            *[AVP]
    */
    public boolean hasPDPContext();
    public PDPContextAvp getPDPContext();
    public void setPDPContext(PDPContextAvp pdpContext);
}