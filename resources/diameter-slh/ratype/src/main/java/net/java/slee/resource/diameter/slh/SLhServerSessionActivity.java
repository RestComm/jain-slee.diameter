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

import java.io.IOException;

import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer;

/**
 * An SLhServerSessionActivity represents a session between GMLC and HSS.
 *
 * A single SLhServerSessionActivity will be created for the Diameter session.
 * All requests received for the session will be fired as events on the same
 * SLhServerSessionActivity.
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface SLhServerSessionActivity extends SLhSessionActivity {

  /**
   * Create a SLh-specific Credit-Control-Answer message pre-populated with the
   * AVPs appropriate for this session.
   *
   * @return a new LCSRoutingInfoAnswer
   */
  public LCSRoutingInfoAnswer createLCSRoutingInfoAnswer();

  /**
   * Sends a Credit-Control-Answer message to the peer.
   *
   * @param ria
   *            the LCSRoutingInfoAnswer to send
   * @throws IOException
   *             if an error occured sending the request to the peer
   */
  public void sendLCSRoutingInfoAnswer(LCSRoutingInfoAnswer ria) throws IOException;


}
