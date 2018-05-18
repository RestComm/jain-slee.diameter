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
 * Java class representing the LCS-Format-Indicator enumerated type.
 * From the Diameter Charging Application (3GPP TS 32.299 V14.1.0) specification,
 * referenced in Diameter-based ELP SLg Reference Point Protocol Details (3GPP TS 29.172 V14.1.0) specification,
 * as element of 7.4.14	LCS-Privacy-Check-Session and 7.4.14	LCS-Privacy-Check-Non-Session grouped AVPs (section 7.4.3)
 * <p>
 * <pre>
 * 7.4.14	LCS-Privacy-Check
 *
 * The LCS-Privacy-Check AVP is of type Enumerated. The following values are defined:
 *  ALLOWED_WITHOUT_NOTIFICATION (0)
 *  ALLOWED_WITH_NOTIFICATION (1)
 *  ALLOWED_IF_NO_RESPONSE (2)
 *  RESTRICTED_IF_NO_RESPONSE (3)
 *  NOT_ALLOWED (4)
 * Default value if AVP is not present is: ALLOWED_WITHOUT_NOTIFICATION (0).
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class LCSPrivacyCheck implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _ALLOWED_WITHOUT_NOTIFICATION = 0;
  public static final int _ALLOWED_WITH_NOTIFICATION = 1;
  public static final int _ALLOWED_IF_NO_RESPONSE = 2;
  public static final int _RESTRICTED_IF_NO_RESPONSE = 3;
  public static final int _NOT_ALLOWED = 4;

  public static final LCSPrivacyCheck ALLOWED_WITHOUT_NOTIFICATION = new LCSPrivacyCheck(_ALLOWED_WITHOUT_NOTIFICATION);
  public static final LCSPrivacyCheck ALLOWED_WITH_NOTIFICATION = new LCSPrivacyCheck(_ALLOWED_WITH_NOTIFICATION);
  public static final LCSPrivacyCheck ALLOWED_IF_NO_RESPONSE = new LCSPrivacyCheck(_ALLOWED_IF_NO_RESPONSE);
  public static final LCSPrivacyCheck RESTRICTED_IF_NO_RESPONSE = new LCSPrivacyCheck(_RESTRICTED_IF_NO_RESPONSE);
  public static final LCSPrivacyCheck NOT_ALLOWED = new LCSPrivacyCheck(_NOT_ALLOWED);

  private int value = -1;

  private LCSPrivacyCheck(int value) {
    this.value = value;
  }

  public static LCSPrivacyCheck fromInt(int type) {
    switch (type) {
      case _ALLOWED_WITHOUT_NOTIFICATION:
        return ALLOWED_WITHOUT_NOTIFICATION;
      case _ALLOWED_WITH_NOTIFICATION:
        return ALLOWED_WITH_NOTIFICATION;
      case _ALLOWED_IF_NO_RESPONSE:
        return ALLOWED_IF_NO_RESPONSE;
      case _RESTRICTED_IF_NO_RESPONSE:
        return RESTRICTED_IF_NO_RESPONSE;
      case _NOT_ALLOWED:
        return NOT_ALLOWED;
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
      case _ALLOWED_WITHOUT_NOTIFICATION:
        return "ALLOWED_WITHOUT_NOTIFICATION";
      case _ALLOWED_WITH_NOTIFICATION:
        return "ALLOWED_WITH_NOTIFICATION";
      case _ALLOWED_IF_NO_RESPONSE:
        return "ALLOWED_IF_NO_RESPONSE";
      case _RESTRICTED_IF_NO_RESPONSE:
        return "RESTRICTED_IF_NO_RESPONSE";
      case _NOT_ALLOWED:
        return "NOT_ALLOWED";
      default:
        return "<Invalid Value>";
    }
  }
}
