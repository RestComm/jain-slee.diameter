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
 * Java class representing the Location-Event enumerated type.
 * From the Diameter-based ELP SLg Reference Point Protocol Details (3GPP TS 29.172 V14.1.0) specification:
 * <p>
 * <pre>
 * 7.4.20	Location-Event
 * The Location-Event AVP is of type Enumerated. The following values are defined:
 *    EMERGENCY_CALL_ORIGINATION (0)
 *    EMERGENCY_CALL_RELEASE (1)
 *    MO_LR (2)
 *    EMERGENCY_CALL_HANDOVER (3)
 *    DEFERRED_MT_LR_RESPONSE (4)
 *    DEFERRED_MO_LR_TTTP_INITIATION (5)
 *    DELAYED_LOCATION_REPORTING (6)
 *
 * NOTE:	Values (4) and (5) are only applicable over Lgd interface. The MME cannot use these values over SLg interface.
 * DEFERRED_MT_LR_RESPONSE is applicable to the delivery of a location estimate for an LDR initiated earlier by either the network
 * (via an MT-LR activate deferred location) or the UE (via a periodic MO-LR TTTP initiation).
 * DELAYED_LOCATION_REPORTING is applicable to the delivery of a location estimate for an EPC-MT-LR or PS-MT-LR initiated earlier
 * by the network for a UE which was transiently not reachable.
 *
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class LocationEvent implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _EMERGENCY_CALL_ORIGINATION = 0;
  public static final int _EMERGENCY_CALL_RELEASE = 1;
  public static final int _MO_LR = 2;
  public static final int _EMERGENCY_CALL_HANDOVER = 3;
  public static final int _DEFERRED_MT_LR_RESPONSE = 4;
  public static final int _DEFERRED_MO_LR_TTTP_INITIATION = 5;
  public static final int _DELAYED_LOCATION_REPORTING = 6;

  public static final LocationEvent EMERGENCY_CALL_ORIGINATION = new LocationEvent(_EMERGENCY_CALL_ORIGINATION);
  public static final LocationEvent EMERGENCY_CALL_RELEASE = new LocationEvent(_EMERGENCY_CALL_RELEASE);
  public static final LocationEvent MO_LR = new LocationEvent(_MO_LR);
  public static final LocationEvent EMERGENCY_CALL_HANDOVER = new LocationEvent(_EMERGENCY_CALL_HANDOVER);
  public static final LocationEvent DEFERRED_MT_LR_RESPONSE = new LocationEvent(_DEFERRED_MT_LR_RESPONSE);
  public static final LocationEvent DEFERRED_MO_LR_TTTP_INITIATION = new LocationEvent(_DEFERRED_MO_LR_TTTP_INITIATION);
  public static final LocationEvent DELAYED_LOCATION_REPORTING = new LocationEvent(_DELAYED_LOCATION_REPORTING);

  private int value = -1;

  private LocationEvent(int value) {
    this.value = value;
  }

  public static LocationEvent fromInt(int type) {
    switch (type) {
      case _EMERGENCY_CALL_ORIGINATION:
        return EMERGENCY_CALL_ORIGINATION;
      case _EMERGENCY_CALL_RELEASE:
        return EMERGENCY_CALL_RELEASE;
      case _MO_LR:
        return MO_LR;
      case _EMERGENCY_CALL_HANDOVER:
        return EMERGENCY_CALL_HANDOVER;
      case _DEFERRED_MT_LR_RESPONSE:
        return DEFERRED_MT_LR_RESPONSE;
      case _DEFERRED_MO_LR_TTTP_INITIATION:
        return DEFERRED_MO_LR_TTTP_INITIATION;
      case _DELAYED_LOCATION_REPORTING:
        return DELAYED_LOCATION_REPORTING;
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
      case _EMERGENCY_CALL_ORIGINATION:
        return "EMERGENCY_CALL_ORIGINATION";
      case _EMERGENCY_CALL_RELEASE:
        return "EMERGENCY_CALL_RELEASE";
      case _MO_LR:
        return "MO_LR";
      case _EMERGENCY_CALL_HANDOVER:
        return "EMERGENCY_CALL_HANDOVER";
      case _DEFERRED_MT_LR_RESPONSE:
        return "DEFERRED_MT_LR_RESPONSE";
      case _DEFERRED_MO_LR_TTTP_INITIATION:
        return "DEFERRED_MO_LR_TTTP_INITIATION";
      case _DELAYED_LOCATION_REPORTING:
        return "DELAYED_LOCATION_REPORTING";
      default:
        return "<Invalid Value>";
    }
  }
}
