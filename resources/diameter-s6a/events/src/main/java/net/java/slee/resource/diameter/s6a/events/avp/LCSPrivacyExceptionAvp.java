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
 * Defines an interface representing the LCS-PrivacyException grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.86 LCS-PrivacyException
 *
 * The LCS-PrivacyException AVP is of type Grouped. This AVP shall contain the classes of LCS Client that are allowed
 * to locate any target UE.
 *
 * AVP format
 * LCS-PrivacyException ::= <AVP header: 1475 10415>
 *                           { SS-Code }
 *                           { SS-Status }
 *                           [ Notification-To-UE-User ]
 *                           *[ External-Client ]
 *                           *[ PLMN-Client ]
 *                           *[ Service-Type ]
 *                           *[AVP]
 *
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface LCSPrivacyExceptionAvp extends GroupedAvp {

    /*
     7.3.87 SS-Code
     The SS-Code AVP is of type OctetString. Octets are coded according to 3GPP TS 29.002 [24].
     */
    public boolean hasSSCode();
    public byte[] getSSCode();
    public void setSSCode(byte[] ssCode);

    /*
      7.3.88 SS-Status
      The SS-Status AVP is of type OctetString. Octets are coded according to 3GPP TS 29.002 [24]. For details, see 3GPP
      TS 23.011 [29].
       */
    public boolean hasSSStatus();
    public byte[] getSSStatus();
    public void setSSStatus(byte[] ssStatus);

    /*
      7.3.89 Notification-To-UE-User
      The Privacy-Notification-UE-User AVP is of type Enumerated. The following values are defined:
          NOTIFY_LOCATION_ALLOWED (0)
          NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE (1)
          NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE (2)
          LOCATION_NOT_ALLOWED (3)
       */
    public boolean hasNotificationToUEUser();
    public NotificationToUEUser getNotificationToUEUser();
    public void setNotificationToUEUser(NotificationToUEUser notificationToUEUser);

    /*
      7.3.90 External-Client
      The External-Client AVP is of type Grouped. This AVP shall contain the identities of the external clients that are
      allowed to locate a target UE for a MT-LR.
      */
    public boolean hasExternalClient();
    public void setExternalClient(ExternalClientAvp externalClientAvp);
    public ExternalClientAvp[] getExternalClients();
    public void setExternalClients(ExternalClientAvp[] externalClients);

    /*
      7.3.93 PLMN-Client
      The PLMN-Client AVP is of type Enumerated. The following values are defined:
          BROADCAST_SERVICE (0)
          O_AND_M_HPLMN (1)
          O_AND_M_VPLMN (2)
          ANONYMOUS_LOCATION (3)
          TARGET_UE_SUBSCRIBED_SERVICE (4)
       */
    public boolean hasPLMNClient();
    public void setPLMNClient(PLMNClient plmnClient);
    public PLMNClient[] getPLMNClients();
    public void setPLMNClients(PLMNClient[] plmnClients);

    /*
      7.3.94 Service-Type
      The Service-Type AVP is of type Grouped. This AVP shall contain the identities of the service type of the clients that
      are allowed to locate a target UE for an MT-LR.
      AVP format
      Service-Type ::= <AVP header: 1483 10415>
          { ServiceTypeIdentity }
          [ GMLC-Restriction ]
          [ Notification-To-UE-User ]
          *[AVP]
      */
    public boolean hasServiceType();
    public void setServiceType(ServiceTypeAvp serviceType);
    public ServiceTypeAvp[] getServiceTypes();
    public void setServiceTypes(ServiceTypeAvp[] serviceTypes);
}