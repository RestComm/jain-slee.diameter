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

package net.java.slee.resource.diameter.slg;

import net.java.slee.resource.diameter.slg.events.ProvideLocationRequest;
import net.java.slee.resource.diameter.slg.events.LocationReportRequest;

/**
 * Factory to support the creation of Diameter SLg messages.
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface SLgMessageFactory {

  /**
   * The SLg interface protocol is defined as an IETF vendor specific Diameter application, where
   * the vendor is 3GPP. The vendor identifier assigned by IANA to 3GPP
   * (http://www.iana.org/assignments/enterprise-numbers) is 10415.
   */
  public static final long _SLg_VENDOR = 10415L;

  /**
   * The Diameter application identifier assigned to the SLg interface application is 16777255
   * (allocated by IANA).
   */
  public static final long _SLg_AUTH_APP_ID = 16777255L;

  ProvideLocationRequest createProvideLocationRequest();

  ProvideLocationRequest createProvideLocationRequest(String sessionId) throws IllegalArgumentException;

  LocationReportRequest createLocationReportRequest();

  LocationReportRequest createLocationReportRequest(String sessionId) throws IllegalArgumentException;

}
