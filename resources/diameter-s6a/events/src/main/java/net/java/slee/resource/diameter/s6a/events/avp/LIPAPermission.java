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
 * 7.3.133 LIPA-Permission
 *
 * The LIPA-Permission AVP is of type Enumerated. It shall indicate whether the APN can be accessed via Local IP
 * Access. The following values are defined:
 *    LIPA_PROHIBITED (0)
 *       This value indicates that this APN is prohibited to be accessed via LIPA.
 *    LIPA_ONLY (1)
 *       This value indicates that this APN can be accessed only via LIPA.
 *    LIPA_CONDITIONAL (2)
 *       This value indicates that this APN can be accessed via both non LIPA and LIPA.
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class LIPAPermission implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _LIPA_PROHIBITED = 0;
  public static final int _LIPA_ONLY = 1;
  public static final int _LIPA_CONDITIONAL = 2;

  public static final LIPAPermission LIPA_PROHIBITED = new LIPAPermission(_LIPA_PROHIBITED);
  public static final LIPAPermission LIPA_ONLY = new LIPAPermission(_LIPA_ONLY);
  public static final LIPAPermission LIPA_CONDITIONAL = new LIPAPermission(_LIPA_CONDITIONAL);

  private int value = -1;

  private LIPAPermission(int value) {
    this.value = value;
  }

  public static LIPAPermission fromInt(int type) {
    switch (type) {
      case _LIPA_PROHIBITED:
        return LIPA_PROHIBITED;
      case _LIPA_ONLY:
        return LIPA_ONLY;
      case _LIPA_CONDITIONAL:
        return LIPA_CONDITIONAL;
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
      case _LIPA_PROHIBITED:
        return "LIPA_PROHIBITED";
      case _LIPA_ONLY:
        return "LIPA_ONLY";
      case _LIPA_CONDITIONAL:
        return "LIPA_CONDITIONAL";
      default:
        return "<Invalid Value>";
    }
  }
}