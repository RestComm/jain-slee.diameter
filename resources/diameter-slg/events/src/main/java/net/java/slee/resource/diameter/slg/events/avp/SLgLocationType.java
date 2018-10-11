/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2018, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */

package net.java.slee.resource.diameter.slg.events.avp;

import java.io.Serializable;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

/**
 * Java class representing the SLg-Location-Type enumerated type.
 * From the Diameter-based ELP SLg Reference Point Protocol Details (3GPP TS 29.172 V14.1.0) specification:
 * <p>
 * <pre>
 * 7.4.2	SLg-Location-Type
 * The SLg-Location-Type AVP is of type Enumerated. The following values are defined:
 *    CURRENT_LOCATION (0)
 *    CURRENT_OR_LAST_KNOWN_LOCATION (1)
 *    INITIAL_LOCATION (2)
 *    ACTIVATE_DEFERRED_LOCATION (3)
 *    CANCEL_DEFERRED_LOCATION (4)
 *    NOTIFICATION_VERIFICATION_ONLY (5)
 * NOTE:	Values (3) and (4) are only applicable over Lgd interface. If received over SLg interface, these values are treated as reserved.
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class SLgLocationType implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _CURRENT_LOCATION = 0;
  public static final int _CURRENT_OR_LAST_KNOWN_LOCATION = 1;
  public static final int _INITIAL_LOCATION = 2;
  public static final int _ACTIVATE_DEFERRED_LOCATION = 3;
  public static final int _CANCEL_DEFERRED_LOCATION = 4;
  public static final int _NOTIFICATION_VERIFICATION_ONLY = 5;

  public static final SLgLocationType CURRENT_LOCATION = new SLgLocationType(_CURRENT_LOCATION);
  public static final SLgLocationType CURRENT_OR_LAST_KNOWN_LOCATION = new SLgLocationType(_CURRENT_OR_LAST_KNOWN_LOCATION);
  public static final SLgLocationType INITIAL_LOCATION = new SLgLocationType(_INITIAL_LOCATION);
  public static final SLgLocationType ACTIVATE_DEFERRED_LOCATION = new SLgLocationType(_ACTIVATE_DEFERRED_LOCATION);
  public static final SLgLocationType CANCEL_DEFERRED_LOCATION = new SLgLocationType(_CANCEL_DEFERRED_LOCATION);
  public static final SLgLocationType NOTIFICATION_VERIFICATION_ONLY = new SLgLocationType(_NOTIFICATION_VERIFICATION_ONLY);

  private int value = -1;

  private SLgLocationType(int value) {
    this.value = value;
  }

  public static SLgLocationType fromInt(int type) {
    switch (type) {
      case _CURRENT_LOCATION:
        return CURRENT_LOCATION;
      case _CURRENT_OR_LAST_KNOWN_LOCATION:
        return CURRENT_OR_LAST_KNOWN_LOCATION;
      case _INITIAL_LOCATION:
        return INITIAL_LOCATION;
      case _ACTIVATE_DEFERRED_LOCATION:
        return ACTIVATE_DEFERRED_LOCATION;
      case _CANCEL_DEFERRED_LOCATION:
        return CANCEL_DEFERRED_LOCATION;
      case _NOTIFICATION_VERIFICATION_ONLY:
        return NOTIFICATION_VERIFICATION_ONLY;
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
      case _CURRENT_LOCATION:
        return "CURRENT_LOCATION";
      case _CURRENT_OR_LAST_KNOWN_LOCATION:
        return "CURRENT_OR_LAST_KNOWN_LOCATION";
      case _INITIAL_LOCATION:
        return "INITIAL_LOCATION";
      case _ACTIVATE_DEFERRED_LOCATION:
        return "ACTIVATE_DEFERRED_LOCATION";
      case _CANCEL_DEFERRED_LOCATION:
        return "CANCEL_DEFERRED_LOCATION";
      case _NOTIFICATION_VERIFICATION_ONLY:
        return "NOTIFICATION_VERIFICATION_ONLY";
      default:
        return "<Invalid Value>";
    }
  }

}
