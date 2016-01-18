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

package net.java.slee.resource.diameter.cxdx.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.Serializable;

/**
 *
 * 3GPP TS 29.229 version 12.7.0 Release 12
 *
 * Java class representing the Priviledged-Sender-Indication AVP enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.7.0) specification:
 * 
 * <pre>
 * 6.3.58 Priviledged-Sender-Indication AVP
 *
 * The Priviledged-Sender-Indication AVP is of type Enumerated and indicates to the S-CSCF whether or not the Private
 * User Identity shall be considered as a priviledged sender. The following values are defined:
 * NOT_PRIVILEDGED_SENDER (0)PRIVILEDGED_SENDER (1)
 * </pre>
 * 
 */
public class PriviledgedSenderIndication implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _NOT_PRIVILEDGED_SENDER = 0;
  public static final int _PRIVILEDGED_SENDER = 1;

  public static final PriviledgedSenderIndication NOT_PRIVILEDGED_SENDER = new PriviledgedSenderIndication(_NOT_PRIVILEDGED_SENDER);
  public static final PriviledgedSenderIndication PRIVILEDGED_SENDER = new PriviledgedSenderIndication(_PRIVILEDGED_SENDER);

  private int value = -1;

  private PriviledgedSenderIndication(int value) {
    this.value = value;
  }

  public static PriviledgedSenderIndication fromInt(int type) {
    switch (type) {
      case _NOT_PRIVILEDGED_SENDER:
        return NOT_PRIVILEDGED_SENDER;
      case _PRIVILEDGED_SENDER:
        return PRIVILEDGED_SENDER;
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
      case _NOT_PRIVILEDGED_SENDER:
        return "NOT_PRIVILEDGED_SENDER";
      case _PRIVILEDGED_SENDER:
        return "PRIVILEDGED_SENDER";
      default:
        return "<Invalid Value>";
    }
  }
}