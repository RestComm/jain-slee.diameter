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

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.Serializable;

/**
 * Java class representing the Notification-To-UE-User enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.89 Notification-To-UE-User AVP
 *
 * The Privacy-Notification-UE-User AVP is of type Enumerated. The following values are defined:
 *     NOTIFY_LOCATION_ALLOWED (0)
 *     NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE (1)
 *     NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE (2)
 *     LOCATION_NOT_ALLOWED (3)
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class NotificationToUEUser implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _NOTIFY_LOCATION_ALLOWED = 0;
  public static final int _NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE = 1;
  public static final int _NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE = 2;
  public static final int _LOCATION_NOT_ALLOWED = 3;

  public static final NotificationToUEUser NOTIFY_LOCATION_ALLOWED = new NotificationToUEUser(_NOTIFY_LOCATION_ALLOWED);
  public static final NotificationToUEUser NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE =
          new NotificationToUEUser(_NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE);
  public static final NotificationToUEUser NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE =
            new NotificationToUEUser(_NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE);
  public static final NotificationToUEUser LOCATION_NOT_ALLOWED = new NotificationToUEUser(_LOCATION_NOT_ALLOWED);

  private int value = -1;

  private NotificationToUEUser(int value) {
    this.value = value;
  }

  public static NotificationToUEUser fromInt(int type) {
    switch (type) {
      case _NOTIFY_LOCATION_ALLOWED:
        return NOTIFY_LOCATION_ALLOWED;
      case _NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE:
        return NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE;
      case _NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE:
        return NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE;
      case _LOCATION_NOT_ALLOWED:
        return LOCATION_NOT_ALLOWED;
      default:
        throw new IllegalArgumentException("Invalid value: " + type);
    }
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    switch (value) {
      case _NOTIFY_LOCATION_ALLOWED:
        return "NOTIFY_LOCATION_ALLOWED";
      case _NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE:
        return "NOTIFYANDVERIFY_LOCATION_ALLOWED_IF_NO_RESPONSE";
      case _NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE:
        return "NOTIFYANDVERIFY_LOCATION_NOT_ALLOWED_IF_NO_RESPONSE";
      case _LOCATION_NOT_ALLOWED:
        return "LOCATION_NOT_ALLOWED";
      default:
        return "<Invalid Value>";
    }
  }
}