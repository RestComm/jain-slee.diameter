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
 * Java class representing the VPLMN-LIPA-Allowed enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 *  7.3.132 VPLMN-LIPA-Allowed
 *
 *  The VPLMN-LIPA-Allowed AVP is of type Enumerated. It shall indicate whether the UE is allowed to use LIPA in the
 *  VPLMN where the UE is roaming. The following values are defined:
 *
 *     LIPA_NOTALLOWED (0)
 *        This value indicates that the UE is not allowed to use LIPA in the VPLMN where the UE is roaming.
 *     LIPA_ALLOWED (1)
 *        This value indicates that the UE is allowed to use LIPA in the VPLMN where the UE is roaming.
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class VPLMNLIPAAllowed implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _LIPA_NOTALLOWED = 0;
  public static final int _LIPA_ALLOWED = 1;

  public static final VPLMNLIPAAllowed LIPA_NOTALLOWED = new VPLMNLIPAAllowed(_LIPA_NOTALLOWED);
  public static final VPLMNLIPAAllowed LIPA_ALLOWED = new VPLMNLIPAAllowed(_LIPA_ALLOWED);

  private int value = -1;

  private VPLMNLIPAAllowed(int value) {
    this.value = value;
  }

  public static VPLMNLIPAAllowed fromInt(int type) {
    switch (type) {
      case _LIPA_NOTALLOWED:
        return LIPA_NOTALLOWED;
      case _LIPA_ALLOWED:
        return LIPA_ALLOWED;
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
      case _LIPA_NOTALLOWED:
        return "LIPA_NOTALLOWED";
      case _LIPA_ALLOWED:
        return "LIPA_ALLOWED";
      default:
        return "<Invalid Value>";
    }
  }
}