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

package org.mobicents.slee.resource.diameter.slg;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.slee.EventTypeID;
import javax.slee.facilities.EventLookupFacility;
import javax.slee.resource.FireableEventType;

import net.java.slee.resource.diameter.slg.events.ProvideLocationRequest;
import net.java.slee.resource.diameter.slg.events.LocationReportRequest;

import org.jdiameter.api.Message;

/**
 * Caches event IDs for the Diameter SLh RAs.
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class EventIDCache {

  private static final String BASE_PACKAGE_PREFIX = "net.java.slee.resource.diameter.base.events.";
  private static final String SLg_PACKAGE_PREFIX = "net.java.slee.resource.diameter.slg.events.";
  public static Map<Integer, String> eventNames = new ConcurrentHashMap<Integer, String>();

  static {
    Map<Integer, String> eventsTemp = new HashMap<Integer, String>();

    eventsTemp.put(ProvideLocationRequest.COMMAND_CODE, SLg_PACKAGE_PREFIX + "ProvideLocation");
    eventsTemp.put(LocationReportRequest.COMMAND_CODE, SLg_PACKAGE_PREFIX + "LocationReport");

    eventNames = Collections.unmodifiableMap(eventsTemp);
  }

  public static final String ERROR_ANSWER = BASE_PACKAGE_PREFIX + "ErrorAnswer";
  public static final String EXTENSION_DIAMETER_MESSAGE = BASE_PACKAGE_PREFIX + "ExtensionDiameterMessage";
  private static final String VENDOR = "java.net";
  private static final String VERSION = "0.8";
  private ConcurrentHashMap<String, FireableEventType> eventIds = new ConcurrentHashMap<String, FireableEventType>();

  public EventIDCache() {
  }

  /**
   * @param eventLookupFacility
   * @param message
   * @return
   */
  public FireableEventType getEventId(EventLookupFacility eventLookupFacility, Message message) {

    FireableEventType eventID = null;

    // Error is always the same.
    if (message.isError()) {
      eventID = getEventId(eventLookupFacility, ERROR_ANSWER);
    } else {
      final int commandCode = message.getCommandCode();
      final boolean isRequest = message.isRequest();

      String eventName = eventNames.get(commandCode);

      if (eventName != null) {
        eventID = getEventId(eventLookupFacility, eventName + (isRequest ? "Request" : "Answer"));
      } else {
        eventID = getEventId(eventLookupFacility, EXTENSION_DIAMETER_MESSAGE);
      }
    }

    return eventID;
  }

  /**
   * @param eventLookupFacility
   * @param eventName
   * @return
   */
  private FireableEventType getEventId(EventLookupFacility eventLookupFacility, String eventName) {

    FireableEventType eventType = eventIds.get(eventName);
    if (eventType == null) {
      try {
        eventType = eventLookupFacility.getFireableEventType(new EventTypeID(eventName, VENDOR, VERSION));
      } catch (Throwable e) {
        e.printStackTrace();
      }
      if (eventType != null) {
        eventIds.put(eventName, eventType);
      }
    }
    return eventType;
  }
}
