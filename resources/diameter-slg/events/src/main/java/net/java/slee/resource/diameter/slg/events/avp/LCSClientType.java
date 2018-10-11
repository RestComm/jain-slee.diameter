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
 * <p>
 * <pre>
 * 7.2.86	LCS-Client-Type AVP
 *  The LCS-Client-Type AVP (AVP code 1241) is of type Enumerated and contains the type of services requested by the LCS Client. It can be one of the following values:
 *  0	EMERGENCY_SERVICES
 *  1	VALUE_ADDED_SERVICES
 *  2	PLMN_OPERATOR_SERVICES
 *  3	LAWFUL_INTERCEPT_SERVICES
 *
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class LCSClientType implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _EMERGENCY_SERVICES = 0;
  public static final int _VALUE_ADDED_SERVICES = 1;
  public static final int _PLMN_OPERATOR_SERVICES = 2;
  public static final int _LAWFUL_INTERCEPT_SERVICES = 3;

  public static final LCSClientType EMERGENCY_SERVICES = new LCSClientType(_EMERGENCY_SERVICES);
  public static final LCSClientType VALUE_ADDED_SERVICES = new LCSClientType(_VALUE_ADDED_SERVICES);
  public static final LCSClientType PLMN_OPERATOR_SERVICES = new LCSClientType(_PLMN_OPERATOR_SERVICES);
  public static final LCSClientType LAWFUL_INTERCEPT_SERVICES = new LCSClientType(_LAWFUL_INTERCEPT_SERVICES);

  private int value = -1;

  private LCSClientType(int value) {
    this.value = value;
  }

  public static LCSClientType fromInt(int type) {
    switch (type) {
      case _EMERGENCY_SERVICES:
        return EMERGENCY_SERVICES;
      case _VALUE_ADDED_SERVICES:
        return VALUE_ADDED_SERVICES;
      case _PLMN_OPERATOR_SERVICES:
        return PLMN_OPERATOR_SERVICES;
      case _LAWFUL_INTERCEPT_SERVICES:
        return LAWFUL_INTERCEPT_SERVICES;
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
      case _EMERGENCY_SERVICES:
        return "EMERGENCY_SERVICES";
      case _VALUE_ADDED_SERVICES:
        return "VALUE_ADDED_SERVICES";
      case _PLMN_OPERATOR_SERVICES:
        return "PLMN_OPERATOR_SERVICES";
      case _LAWFUL_INTERCEPT_SERVICES:
        return "LAWFUL_INTERCEPT_SERVICES";
      default:
        return "<Invalid Value>";
    }
  }
}
