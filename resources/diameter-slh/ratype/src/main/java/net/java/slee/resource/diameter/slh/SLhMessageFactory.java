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

package net.java.slee.resource.diameter.slh;

import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;

/**
 * Used by applications to create Diameter SLh request messages.
 * SLh answer messages can be created using the SLhServerSessionActivity.createLCSRoutingInfoAnswer() method.
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public interface SLhMessageFactory {

  /**
   * The SLh interface protocol is defined as a vendor specific Diameter application, where
   * the vendor is 3GPP. The vendor identifier assigned by IANA to 3GPP
   * (http://www.iana.org/assignments/enterprise-numbers) is 10415.
   */
  public static final long _SLh_TGPP_VENDOR_ID = 10415L;

  /**
   * The Diameter application identifier assigned to the SLh interface application is 16777291
   * (allocated by IANA).
   */
  public static final long _SLh_AUTH_APP_ID = 16777291L;

  /**
   * Creates an LCS Routing-Info-Request message.
   *
   * @return
   */
  LCSRoutingInfoRequest createLCSRoutingInfoRequest();

  /**
   * Creates an LCS Routing-Info-Request message with the Session-Id AVP populated with the sessionId parameter.
   *
   * @param sessionId
   * @return
   */
  LCSRoutingInfoRequest createLCSRoutingInfoRequest(String sessionId) throws IllegalArgumentException;

}
