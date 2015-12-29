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
 * Defines an interface representing the Service-Type grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 *
 *    7.3.94 Service-Type
 *
 *    The Service-Type AVP is of type Grouped. This AVP shall contain the identities of the service type of the clients that
 *    are allowed to locate a target UE for an MT-LR.
 *    AVP format
 *       Service-Type ::= <AVP header: 1483 10415>
 *                        { ServiceTypeIdentity }
 *                        [ GMLC-Restriction ]
 *                        [ Notification-To-UE-User ]
 *                        *[AVP]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface ServiceTypeAvp extends GroupedAvp {
    /*
       7.3.95 ServiceTypeIdentity
       The ServiceTypeIdentity AVP is of type Unsigned32. For details on the values of this AVP, see 3GPP TS 29.002 [24].
    */
    public boolean hasServiceTypeIdentity();
    public long getServiceTypeIdentity();
    public void setServiceTypeIdentity(long serviceTypeIdentity);

    /*
       7.3.92 GMLC-Restriction
       The GMLC-Restriction AVP is of type Enumerated. The following values are defined:
          GMLC_LIST (0)
          HOME_COUNTRY (1)
     */
    public boolean hasGMLCRestriction();
    public GMLCRestriction getGMLCRestriction();
    public void setGMLCRestriction(GMLCRestriction gmlcRestriction);

    /*
        7.3.89 Notification-To-UE-User
        The Notification- To-UE-User AVP is of type Enumerated.
     */
    public boolean hasNotificationToUEUser();
    public NotificationToUEUser getNotificationToUEUser();
    public void setNotificationToUEUser(NotificationToUEUser notificationToUEUser);
}