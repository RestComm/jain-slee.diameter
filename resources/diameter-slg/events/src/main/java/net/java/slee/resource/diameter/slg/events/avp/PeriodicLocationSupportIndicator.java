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
 * Java class representing the Periodic-Location-Support-Indicator enumerated type.
 * From the Diameter-based ELP SLg Reference Point Protocol Details (3GPP TS 29.172 V14.1.0) specification
 * <p>
 * <pre>
 * 7.4.50	Periodic-Location-Support-Indicator
 *  The Periodic-Location-Support-Indicator AVP is of type Enumerated and it indicates if the given PLMN-ID (indicated by Visited-PLMN-Id)
 *  supports periodic location or not. The following values are defined:
 * 	  NOT_SUPPORTED (0)
 * 	  SUPPORTED (1)
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class PeriodicLocationSupportIndicator implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _NOT_SUPPORTED = 0;
  public static final int _SUPPORTED = 1;

  public static final PeriodicLocationSupportIndicator NOT_SUPPORTED = new PeriodicLocationSupportIndicator(_NOT_SUPPORTED);
  public static final PeriodicLocationSupportIndicator SUPPORTED = new PeriodicLocationSupportIndicator(_SUPPORTED);

  private int value = -1;

  private PeriodicLocationSupportIndicator(int value) {
    this.value = value;
  }

  public static PeriodicLocationSupportIndicator fromInt(int type) {
    switch (type) {
      case _NOT_SUPPORTED:
        return NOT_SUPPORTED;
      case _SUPPORTED:
        return SUPPORTED;
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
      case _NOT_SUPPORTED:
        return "NOT_SUPPORTED";
      case _SUPPORTED:
        return "SUPPORTED";
      default:
        return "<Invalid Value>";
    }
  }

}
