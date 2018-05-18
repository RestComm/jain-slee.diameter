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
 * as element of LCS-EPS-Client-Name grouped AVP (section 7.4.3).
 * <p>
 * <pre>
 * 7.2.88	LCS-Format-Indicator AVP
 *
 * The LCS-Format-Indicator AVP (AVP code 1237) is of type Enumerated and contains the format of the LCS Client name.
 * It can be one of the following values:
 *
 *  0	LOGICAL_NAME
 *  1	EMAIL_ADDRESS
 *  2	MSISDN
 *  3	URL
 *  4	SIP_URL
 *
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class LCSFormatIndicator implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _LOGICAL_NAME = 0;
  public static final int _EMAIL_ADDRESS = 1;
  public static final int _MSISDN = 2;
  public static final int _URL = 3;
  public static final int _SIP_URL = 4;

  public static final LCSFormatIndicator LOGICAL_NAME = new LCSFormatIndicator(_LOGICAL_NAME);
  public static final LCSFormatIndicator EMAIL_ADDRESS = new LCSFormatIndicator(_EMAIL_ADDRESS);
  public static final LCSFormatIndicator MSISDN = new LCSFormatIndicator(_MSISDN);
  public static final LCSFormatIndicator URL = new LCSFormatIndicator(_URL);
  public static final LCSFormatIndicator SIP_URL = new LCSFormatIndicator(_SIP_URL);

  private int value = -1;

  private LCSFormatIndicator(int value) {
    this.value = value;
  }

  public static LCSFormatIndicator fromInt(int type) {
    switch (type) {
      case _LOGICAL_NAME:
        return LOGICAL_NAME;
      case _EMAIL_ADDRESS:
        return EMAIL_ADDRESS;
      case _MSISDN:
        return MSISDN;
      case _URL:
        return URL;
      case _SIP_URL:
        return SIP_URL;
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
      case _LOGICAL_NAME:
        return "LOGICAL_NAME";
      case _EMAIL_ADDRESS:
        return "EMAIL_ADDRESS";
      case _MSISDN:
        return "MSISDN";
      case _URL:
        return "URL";
      case _SIP_URL:
        return "SIP_URL";
      default:
        return "<Invalid Value>";
    }
  }
}
