/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
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
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.java.slee.resource.diameter.slh;

import net.java.slee.resource.diameter.base.DiameterMessageFactory;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;

/**
 * Used by applications to create Diameter Ro request messages.
 * Ro answer messages can be created using the RoServerSessionActivity.createLCSRoutingInfoAnswer() method.
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
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
  public LCSRoutingInfoRequest createLCSRoutingInfoRequest();

  /**
   * Creates an LCS Routing-Info-Request message with the Session-Id AVP populated with the sessionId parameter.
   *
   * @param sessionId
   * @return
   */
  public LCSRoutingInfoRequest createLCSRoutingInfoRequest(String sessionId) throws IllegalArgumentException;

}

