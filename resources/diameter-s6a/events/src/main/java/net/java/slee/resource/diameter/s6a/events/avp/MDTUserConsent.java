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
 * Java class representing the MDT-User-Consent enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.148 MDT-User-Consent
 *
 * The MDT-User-Consent AVP is of type Enumerated. It shall indicate whether the user has given his consent for MDT
 * activation or not (see 3GPP TS 32.422 [23]). The following values are defined:
 *      CONSENT_NOT_GIVEN (0)
 *      CONSENT_GIVEN (1)
 *
 * The default value when this AVP is not present in ULA is CONSENT_NOT_GIVEN (0). Absence of this AVP in IDR
 * shall be interpreted as the MDT-User-Consent has not been modified.
 * </pre>
 *
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class MDTUserConsent implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

    public static final int _CONSENT_NOT_GIVEN = 0;
    public static final int _CONSENT_GIVEN = 1;

    public static final MDTUserConsent CONSENT_NOT_GIVEN  = new MDTUserConsent(_CONSENT_NOT_GIVEN);
    public static final MDTUserConsent CONSENT_GIVEN      = new MDTUserConsent(_CONSENT_GIVEN);

  private int value = -1;

  private MDTUserConsent(int value) {
    this.value = value;
  }

  public static MDTUserConsent fromInt(int type) {
    switch (type) {
        case _CONSENT_NOT_GIVEN :       return CONSENT_NOT_GIVEN ;
        case _CONSENT_GIVEN     :       return CONSENT_GIVEN ;
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
        case _CONSENT_NOT_GIVEN :    return "CONSENT_NOT_GIVEN";
        case _CONSENT_GIVEN     :    return "CONSENT_GIVEN";
        default:
            return "<Invalid Value>";
    }
  }
}