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

package net.java.slee.resource.diameter.s13;

import net.java.slee.resource.diameter.s13.events.MEIdentityCheckRequest;

/**
 * Factory to support the creation of Diameter S13 messages.
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface S13MessageFactory {

  /**
   * The S13 interface protocol is defined as an IETF vendor specific Diameter application, where
   * the vendor is 3GPP. The vendor identifier assigned by IANA to 3GPP 
   * (http://www.iana.org/assignments/enterprise-numbers) is 10415.
   */
  public static final long _S13_VENDOR = 10415L;

  /**
   * The Diameter application identifier assigned to the S13 interface application is 16777252 
   * (allocated by IANA).
   */
  public static final long _S13_AUTH_APP_ID = 16777252L;

  MEIdentityCheckRequest createMEIdentityCheckRequest();
  MEIdentityCheckRequest createMEIdentityCheckRequest(String sessionId) throws IllegalArgumentException;
}
