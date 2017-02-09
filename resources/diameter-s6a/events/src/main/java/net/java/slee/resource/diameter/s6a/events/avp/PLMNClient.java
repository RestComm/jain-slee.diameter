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

package net.java.slee.resource.diameter.s6a.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.Serializable;

/**
 * Java class representing the PLMN-Client enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.93 PLMN-Client
 *
 * The PLMN-Client AVP is of type Enumerated. The following values are defined:
 *     BROADCAST_SERVICE (0)
 *     O_AND_M_HPLMN (1)
 *     O_AND_M_VPLMN (2)
 *     ANONYMOUS_LOCATION (3)
 *     TARGET_UE_SUBSCRIBED_SERVICE (4)
 *
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class PLMNClient implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _BROADCAST_SERVICE = 0;
  public static final int _O_AND_M_HPLMN = 1;
  public static final int _O_AND_M_VPLMN = 2;
  public static final int _ANONYMOUS_LOCATION = 3;
  public static final int _TARGET_UE_SUBSCRIBED_SERVICE = 4;


  public static final PLMNClient BROADCAST_SERVICE = new PLMNClient(_BROADCAST_SERVICE);
  public static final PLMNClient O_AND_M_HPLMN = new PLMNClient(_O_AND_M_HPLMN);
  public static final PLMNClient O_AND_M_VPLMN = new PLMNClient(_O_AND_M_VPLMN);
  public static final PLMNClient ANONYMOUS_LOCATION = new PLMNClient(_ANONYMOUS_LOCATION);
  public static final PLMNClient TARGET_UE_SUBSCRIBED_SERVICE = new PLMNClient(_TARGET_UE_SUBSCRIBED_SERVICE);

  private int value = -1;

  private PLMNClient(int value) {
    this.value = value;
  }

  public static PLMNClient fromInt(int type) {
    switch (type) {
      case _BROADCAST_SERVICE:
        return BROADCAST_SERVICE;
      case _O_AND_M_HPLMN:
        return O_AND_M_HPLMN;
      case _O_AND_M_VPLMN:
        return O_AND_M_VPLMN;
      case _ANONYMOUS_LOCATION:
        return ANONYMOUS_LOCATION;
      case _TARGET_UE_SUBSCRIBED_SERVICE:
        return TARGET_UE_SUBSCRIBED_SERVICE;
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
      case _BROADCAST_SERVICE:
        return "BROADCAST_SERVICE";
      case _O_AND_M_HPLMN:
        return "O_AND_M_HPLMN";
      case _O_AND_M_VPLMN:
        return "O_AND_M_VPLMN";
      case _ANONYMOUS_LOCATION:
        return "ANONYMOUS_LOCATION";
      case _TARGET_UE_SUBSCRIBED_SERVICE:
        return "TARGET_UE_SUBSCRIBED_SERVICE";
      default:
        return "<Invalid Value>";
    }
  }
}