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
 * Java class representing the Pseudonym-Indicator enumerated type.
 * From the Diameter-based ELP SLg Reference Point Protocol Details (3GPP TS 29.172 V14.1.0) specification
 * <p>
 * <pre>
 * 7.4.21	Pseudonym-Indicator
 * 	The Pseudonym-Indicator AVP is of type Enumerated. The following values are defined:
 * 		PSEUDONYM_NOT_REQUESTED (0)
 * 		PSEUDONYM_REQUESTED (1)
 * 	Default value if AVP is not present is: PSEUDONYM_NOT_REQUESTED (0).
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class PseudonymIndicator implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _PSEUDONYM_NOT_REQUESTED = 0;
  public static final int _PSEUDONYM_REQUESTED = 1;

  public static final PseudonymIndicator PSEUDONYM_NOT_REQUESTED = new PseudonymIndicator(_PSEUDONYM_NOT_REQUESTED);
  public static final PseudonymIndicator PSEUDONYM_REQUESTED = new PseudonymIndicator(_PSEUDONYM_REQUESTED);

  private int value = -1;

  private PseudonymIndicator(int value) {
    this.value = value;
  }

  public static PseudonymIndicator fromInt(int type) {
    switch (type) {
      case _PSEUDONYM_NOT_REQUESTED:
        return PSEUDONYM_NOT_REQUESTED;
      case _PSEUDONYM_REQUESTED:
        return PSEUDONYM_REQUESTED;
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
      case _PSEUDONYM_NOT_REQUESTED:
        return "PSEUDONYM_NOT_REQUESTED";
      case _PSEUDONYM_REQUESTED:
        return "PSEUDONYM_REQUESTED";
      default:
        return "<Invalid Value>";
    }
  }

}
