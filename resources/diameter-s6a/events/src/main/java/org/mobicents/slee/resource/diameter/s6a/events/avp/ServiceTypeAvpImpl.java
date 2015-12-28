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
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.ServiceTypeAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class ServiceTypeAvpImpl extends GroupedAvpImpl implements ServiceTypeAvp {

    public ServiceTypeAvpImpl() {
        super();
    }

    public ServiceTypeAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }


    public boolean hasServiceTypeIdentity() {
        return hasAvp(DiameterS6aAvpCodes.SERVICETYPEIDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getServiceTypeIdentity() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.SERVICETYPEIDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setServiceTypeIdentity(long serviceTypeIdentity) {
        addAvp(DiameterS6aAvpCodes.SERVICETYPEIDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, serviceTypeIdentity);
    }

    public boolean hasGMLCRestriction() {
        return hasAvp(DiameterS6aAvpCodes.GMLC_RESTRICTION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public GMLCRestriction getGMLCRestriction() {
        return (GMLCRestriction) getAvpAsEnumerated(DiameterS6aAvpCodes.GMLC_RESTRICTION,
                                                    DiameterS6aAvpCodes.S6A_VENDOR_ID, GMLCRestriction.class);
    }

    public void setGMLCRestriction(GMLCRestriction gmlcRestriction) {
        addAvp(DiameterS6aAvpCodes.GMLC_RESTRICTION, DiameterS6aAvpCodes.S6A_VENDOR_ID, gmlcRestriction.getValue());
    }

    public boolean hasNotificationToUEUser() {
        return hasAvp(DiameterS6aAvpCodes.NOTIFICATION_TO_UE_USER, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public NotificationToUEUser getNotificationToUEUser() {
        return (NotificationToUEUser)getAvpAsEnumerated(DiameterS6aAvpCodes.NOTIFICATION_TO_UE_USER,
                                                        DiameterS6aAvpCodes.S6A_VENDOR_ID, NotificationToUEUser.class);
    }

    public void setNotificationToUEUser(NotificationToUEUser notificationToUEUser) {
        addAvp(DiameterS6aAvpCodes.NOTIFICATION_TO_UE_USER, DiameterS6aAvpCodes.S6A_VENDOR_ID,
               notificationToUEUser.getValue());
    }
}