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
import net.java.slee.resource.diameter.s6a.events.avp.*;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.GPRSSubscriptionDataAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class GPRSSubscriptionDataAvpImpl extends GroupedAvpImpl implements GPRSSubscriptionDataAvp {

    public GPRSSubscriptionDataAvpImpl() {
        super();
    }

    public GPRSSubscriptionDataAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public boolean hasCompleteDataListIncludedIndicator() {
        return hasAvp(DiameterS6aAvpCodes.COMPLETE_DATA_LIST_INCLUDED_INDICATOR, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public CompleteDataListIncludedIndicator getCompleteDataListIncludedIndicator() {
        return (CompleteDataListIncludedIndicator)
                getAvpAsEnumerated(DiameterS6aAvpCodes.COMPLETE_DATA_LIST_INCLUDED_INDICATOR,
                                   DiameterS6aAvpCodes.S6A_VENDOR_ID, CompleteDataListIncludedIndicator.class);
    }

    public void setCompleteDataListIncludedIndicator(CompleteDataListIncludedIndicator completeDataListIncludedIndicator) {
        addAvp(DiameterS6aAvpCodes.COMPLETE_DATA_LIST_INCLUDED_INDICATOR, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               completeDataListIncludedIndicator.getValue());
    }

    public boolean hasPDPContext() {
        return hasAvp(DiameterS6aAvpCodes.PDP_CONTEXT, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public PDPContextAvp getPDPContext() {
        return (PDPContextAvp) getAvpAsCustom(DiameterS6aAvpCodes.PDP_CONTEXT, DiameterS6aAvpCodes.S6A_VENDOR_ID,
                PDPContextAvpImpl.class);
    }

    public void setPDPContext(PDPContextAvp pdpContext) {
        addAvp(DiameterS6aAvpCodes.PDP_CONTEXT, DiameterS6aAvpCodes.S6A_VENDOR_ID, pdpContext.byteArrayValue());
    }
}