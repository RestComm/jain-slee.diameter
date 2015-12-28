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
 * Java class representing the Alert-Reason enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.2.46A CSG-Access-Mode AVP
 *
 * The CSG-Access-Mode AVP (AVP code 2317) is of type Enumerated and holds the mode in which the CSG cell User is
 * accessing to, operates. It has the following values:
 *  0 Closed mode
 *  1 Hybrid Mode
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class CSGAccessMode implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _CLOSED_MODE = 0;
  public static final int _HYBRID_MODE = 1;

  public static final CSGAccessMode CLOSED_MOMDE = new CSGAccessMode(_CLOSED_MODE);
  public static final CSGAccessMode HYBRID_MODE = new CSGAccessMode(_HYBRID_MODE);

  private int value = -1;

  private CSGAccessMode(int value) {
    this.value = value;
  }

  public static CSGAccessMode fromInt(int type) {
    switch (type) {
      case _CLOSED_MODE:
        return CLOSED_MOMDE;
      case _HYBRID_MODE:
        return HYBRID_MODE;
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
      case _CLOSED_MODE:
        return "CLOSED_MODE";
      case _HYBRID_MODE:
        return "HYBRID_MODE";
      default:
        return "<Invalid Value>";
    }
  }
}