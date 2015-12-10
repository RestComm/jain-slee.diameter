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

import java.io.Serializable;
import net.java.slee.resource.diameter.base.events.avp.Enumerated;

/**
 * Java class representing the Error-Diagnostic enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.3.128 Error-Diagnostic
 *
 * The Error-Diagnostic AVP is of type Enumerated. The following values are defined:
 *   - GPRS_DATA_SUBSCRIBED (0)
 *     This value shall be used when Experimental-Error is
 *     DIAMETER_ERROR_UNKNOWN_EPS_SUBSCRIPTION and there is GPRS Subscription Data for the
 *     user.
 *   - NO_GPRS_DATA_SUBSCRIBED (1)
 *     This value shall be used when Experimental-Error is
 *     DIAMETER_ERROR_UNKNOWN_EPS_SUBSCRIPTION and there is not GPRS Subscription Data for
 *     the user.
 *   - ODB_ALL_APN (2)
 *     This value shall be used when Experimental-Error is DIAMETER_ERROR_ROAMING_NOT_ALLOWED
 *     and the Operator Determined Barring indicates "All Packet Oriented Services Barred" (see clause 7.3.30).
 *   - ODB_HPLMN_APN (3)
 *     This value shall be used when Experimental-Error is DIAMETER_ERROR_ROAMING_NOT_ALLOWED
 *     and the Operator Determined Barring indicates "Roamer Access HPLMN-AP Barred" (see clause 7.3.30).
 *   - ODB_VPLMN_APN (4)
 *     This value shall be used when Experimental-Error is DIAMETER_ERROR_ROAMING_NOT_ALLOWED
 *     and the Operator Determined Barring indicates "Roamer Access to VPLMN-AP Barred" (see clause 7.3.30).
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class ErrorDiagnostic implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

    public static final int _GPRS_DATA_SUBSCRIBED = 0;
    public static final int _NO_GPRS_DATA_SUBSCRIBED = 1;
    public static final int _ODB_ALL_APN = 2;
    public static final int _ODB_HPLMN_APN = 3;
    public static final int _ODB_VPLMN_APN = 4;

    public static final ErrorDiagnostic GPRS_DATA_SUBSCRIBED = new ErrorDiagnostic(_GPRS_DATA_SUBSCRIBED);
    public static final ErrorDiagnostic NO_GPRS_DATA_SUBSCRIBED = new ErrorDiagnostic(_NO_GPRS_DATA_SUBSCRIBED);
    public static final ErrorDiagnostic ODB_ALL_APN = new ErrorDiagnostic(_ODB_ALL_APN);
    public static final ErrorDiagnostic ODB_HPLMN_APN = new ErrorDiagnostic(_ODB_HPLMN_APN);
    public static final ErrorDiagnostic ODB_VPLMN_APN = new ErrorDiagnostic(_ODB_VPLMN_APN);

  private int value = -1;

  private ErrorDiagnostic(int value) {
    this.value = value;
  }

  public static ErrorDiagnostic fromInt(int type) {
    switch (type) {
      case _GPRS_DATA_SUBSCRIBED:
        return GPRS_DATA_SUBSCRIBED;
      case _NO_GPRS_DATA_SUBSCRIBED:
        return NO_GPRS_DATA_SUBSCRIBED;
      case _ODB_ALL_APN:
        return ODB_ALL_APN;
      case _ODB_HPLMN_APN:
        return ODB_HPLMN_APN;
      case _ODB_VPLMN_APN:
        return ODB_VPLMN_APN;
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
      case _GPRS_DATA_SUBSCRIBED:
        return "GPRS_DATA_SUBSCRIBED";
      case _NO_GPRS_DATA_SUBSCRIBED:
        return "NO_GPRS_DATA_SUBSCRIBED";
      case _ODB_ALL_APN:
        return "ODB_ALL_APN";
      case _ODB_HPLMN_APN:
        return "ODB_HPLMN_APN";
      case _ODB_VPLMN_APN:
        return "ODB_VPLMN_APN";
      default:
        return "<Invalid Value>";
    }
  }
}