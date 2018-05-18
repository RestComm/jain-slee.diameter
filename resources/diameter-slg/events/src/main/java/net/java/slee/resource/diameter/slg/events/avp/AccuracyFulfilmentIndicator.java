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
 * Java class representing the Accuracy-Fulfilment-Indicator enumerated type.
 * From the Diameter-based ELP SLg Reference Point Protocol Details (3GPP TS 29.172 V14.1.0) specification
 * <p>
 * <pre>
 * 7.4.15	Accuracy-Fulfilment-Indicator
 * 	The Accuracy-Fulfilment-Indicator AVP is of type Enumerated. The following values are defined:
 * 		REQUESTED_ACCURACY_FULFILLED (0)
 * 		REQUESTED_ACCURACY_NOT_FULFILLED (1)
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class AccuracyFulfilmentIndicator implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _REQUESTED_ACCURACY_FULFILLED = 0;
  public static final int _REQUESTED_ACCURACY_NOT_FULFILLED = 1;

  public static final AccuracyFulfilmentIndicator REQUESTED_ACCURACY_FULFILLED = new AccuracyFulfilmentIndicator(_REQUESTED_ACCURACY_FULFILLED);
  public static final AccuracyFulfilmentIndicator REQUESTED_ACCURACY_NOT_FULFILLED = new AccuracyFulfilmentIndicator(_REQUESTED_ACCURACY_NOT_FULFILLED);

  private int value = -1;

  private AccuracyFulfilmentIndicator(int value) {
    this.value = value;
  }

  public static AccuracyFulfilmentIndicator fromInt(int type) {
    switch (type) {
      case _REQUESTED_ACCURACY_FULFILLED:
        return REQUESTED_ACCURACY_FULFILLED;
      case _REQUESTED_ACCURACY_NOT_FULFILLED:
        return REQUESTED_ACCURACY_NOT_FULFILLED;
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
      case _REQUESTED_ACCURACY_FULFILLED:
        return "REQUESTED_ACCURACY_FULFILLED";
      case _REQUESTED_ACCURACY_NOT_FULFILLED:
        return "REQUESTED_ACCURACY_NOT_FULFILLED";
      default:
        return "<Invalid Value>";
    }
  }

}
