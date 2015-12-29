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
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 32.422 V12.4.0) specification:
 *
 * <pre>
 * 5.10.9 Logging Duration
 * The parameter is mandatory if the the job type parameter is configured for Logged MDT. The parameter determines the
 * validity of MDT logged configuration for IDLE. The timer starts at time of receiving configuration by the UE, and
 * continues independent of UE state transitions and RAT or RPLMN changes.
 * Detailed definition of the parameter is in 3GPP TS 37.320 [30], 3GPP TS 25.331 [31] and 3GPP TS 36.331 [32]:
 * The parameter is an enumerated type with the following values in UMTS and LTE:
 *  ? 600 sec (0),
 *  ? 1200 sec (1),
 *  ? 2400 sec (2),
 *  ? 3600 sec (3),
 *  ? 5400 sec (4),
 *  ? 7200 sec (5)
 * </pre>
 *
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class LoggingDuration implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

    public static final int _SEC_600 = 0;
    public static final int _SEC_1200 = 1;
    public static final int _SEC_2400 = 2;
    public static final int _SEC_3600 = 3;
    public static final int _SEC_5400 = 4;
    public static final int _SEC_7200 = 5;

    public static final LoggingDuration SEC_600  = new LoggingDuration(_SEC_600 );
    public static final LoggingDuration SEC_1200 = new LoggingDuration(_SEC_1200);
    public static final LoggingDuration SEC_2400 = new LoggingDuration(_SEC_2400);
    public static final LoggingDuration SEC_3600 = new LoggingDuration(_SEC_3600);
    public static final LoggingDuration SEC_5400 = new LoggingDuration(_SEC_5400);
    public static final LoggingDuration SEC_7200 = new LoggingDuration(_SEC_7200);

  private int value = -1;

  private LoggingDuration(int value) {
    this.value = value;
  }

  public static LoggingDuration fromInt(int type) {
    switch (type) {
        case _SEC_600: return SEC_600;
        case _SEC_1200: return SEC_1200;
        case _SEC_2400: return SEC_2400;
        case _SEC_3600: return SEC_3600;
        case _SEC_5400: return SEC_5400;
        case _SEC_7200: return SEC_7200;
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
        case _SEC_600:  return "600 seconds";
        case _SEC_1200: return "1200 seconds";
        case _SEC_2400: return "2400 seconds";
        case _SEC_3600: return "3600 seconds";
        case _SEC_5400: return "5400 seconds";
        case _SEC_7200: return "7200 seconds";
        default:
            return "<Invalid Value>";
    }
  }
}