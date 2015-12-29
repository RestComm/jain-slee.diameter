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
 * Java class representing the GMLC-Restriction enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.92 GMLC-Restriction
 *
 * The GMLC-Restriction AVP is of type Enumerated. The following values are defined:
 *    GMLC_LIST (0)
 *    HOME_COUNTRY (1)
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class GMLCRestriction implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _GMLC_LIST = 0;
  public static final int _HOME_COUNTRY = 1;

  public static final GMLCRestriction GMLC_LIST = new GMLCRestriction(_GMLC_LIST);
  public static final GMLCRestriction HOME_COUNTRY = new GMLCRestriction(_HOME_COUNTRY);

  private int value = -1;

  private GMLCRestriction(int value) {
    this.value = value;
  }

  public static GMLCRestriction fromInt(int type) {
    switch (type) {
      case _GMLC_LIST:
        return GMLC_LIST;
      case _HOME_COUNTRY:
        return HOME_COUNTRY;
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
      case _GMLC_LIST:
        return "GMLC_LIST";
      case _HOME_COUNTRY:
        return "HOME_COUNTRY";
      default:
        return "<Invalid Value>";
    }
  }
}