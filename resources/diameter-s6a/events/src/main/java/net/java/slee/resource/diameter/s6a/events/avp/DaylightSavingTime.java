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
 * Java class representing the Daylight-Saving-Time enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.3.164 Daylight-Saving-Time
 *
 * The Daylight-Saving-Time AVP is of type Enumerated and shall contain the Daylight Saving Time (in steps of 1 hour)
 * used to adjust for summertime the time zone of the location where the UE is attached in the visited network.
 *
 * The following values are defined:
 *      NO_ADJUSTMENT (0)
 *      PLUS_ONE_HOUR_ADJUSTMENT (1)
 *      PLUS_TWO_HOURS_ADJUSTMENT (2)
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class DaylightSavingTime implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _NO_ADJUSTMENT = 0;
  public static final int _PLUS_ONE_HOUR_ADJUSTMENT = 1;
  public static final int _PLUS_TWO_HOURS_ADJUSTMENT = 2;

  public static final DaylightSavingTime NO_ADJUSTMENT = new DaylightSavingTime(_NO_ADJUSTMENT);
  public static final DaylightSavingTime PLUS_ONE_HOUR_ADJUSTMENT = new DaylightSavingTime(_PLUS_ONE_HOUR_ADJUSTMENT);
  public static final DaylightSavingTime PLUS_TWO_HOURS_ADJUSTMENT = new DaylightSavingTime(_PLUS_TWO_HOURS_ADJUSTMENT);

  private int value = -1;

  private DaylightSavingTime(int value) {
    this.value = value;
  }

  public static DaylightSavingTime fromInt(int type) {
    switch (type) {
      case _NO_ADJUSTMENT:
        return NO_ADJUSTMENT;
      case _PLUS_ONE_HOUR_ADJUSTMENT:
        return PLUS_ONE_HOUR_ADJUSTMENT;
      case _PLUS_TWO_HOURS_ADJUSTMENT:
        return PLUS_TWO_HOURS_ADJUSTMENT;
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
      case _NO_ADJUSTMENT:
        return "NO_ADJUSTMENT";
      case _PLUS_ONE_HOUR_ADJUSTMENT:
        return "PLUS_ONE_HOUR_ADJUSTMENT";
      case _PLUS_TWO_HOURS_ADJUSTMENT:
        return "PLUS_TWO_HOURS_ADJUSTMENT";
      default:
        return "<Invalid Value>";
    }
  }
}