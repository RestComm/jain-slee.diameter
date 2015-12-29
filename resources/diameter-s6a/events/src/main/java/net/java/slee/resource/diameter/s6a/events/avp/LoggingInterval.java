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
 * 5.10.8 Logging Interval
 *
 * The parameter is mandatory if the job type is configured for Logged MDT. The parameter defines the periodicity for
 * logging MDT measurement results for periodic downlink pilot strength measurement when UE is in Idle.
 * Detailed definition of the parameter is in 3GPP TS 37.320 [30].
 *
 * The parameter is an enumerated type with the following values in UMTS and LTE as per defined in 3GPP TS 25.331
 * [31] and 36.331 [32]:
 *   ? 1.28 (0),
 *   ? 2.56 (1),
 *  ? 5.12 (2),
 *  ? 10.24 (3),
 *  ? 20.48 (4),
 *  ? 30.72 (5),
 *  ? 40.96 (6),
 *  ? 61.44 (7)
 * </pre>
 *
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class LoggingInterval implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

    public static final int _PERIODICITY_1_28 = 0;
    public static final int _PERIODICITY_2_56 = 1;
    public static final int _PERIODICITY_5_12 = 2;
    public static final int _PERIODICITY_10_24 = 3;
    public static final int _PERIODICITY_20_48 = 4;
    public static final int _PERIODICITY_30_72 = 5;
    public static final int _PERIODICITY_40_96 = 6;
    public static final int _PERIODICITY_61_44 = 7;

    public static final LoggingInterval PERIODICITY_1_28  = new LoggingInterval(_PERIODICITY_1_28 );
    public static final LoggingInterval PERIODICITY_2_56  = new LoggingInterval(_PERIODICITY_2_56 );
    public static final LoggingInterval PERIODICITY_5_12  = new LoggingInterval(_PERIODICITY_5_12 );
    public static final LoggingInterval PERIODICITY_10_24 = new LoggingInterval(_PERIODICITY_10_24);
    public static final LoggingInterval PERIODICITY_20_48 = new LoggingInterval(_PERIODICITY_20_48);
    public static final LoggingInterval PERIODICITY_30_72 = new LoggingInterval(_PERIODICITY_30_72);
    public static final LoggingInterval PERIODICITY_40_96 = new LoggingInterval(_PERIODICITY_40_96);
    public static final LoggingInterval PERIODICITY_61_44 = new LoggingInterval(_PERIODICITY_61_44);

  private int value = -1;

  private LoggingInterval(int value) {
    this.value = value;
  }

  public static LoggingInterval fromInt(int type) {
    switch (type) {
        case _PERIODICITY_1_28 : return PERIODICITY_1_28;
        case _PERIODICITY_2_56 : return PERIODICITY_2_56;
        case _PERIODICITY_5_12 : return PERIODICITY_5_12;
        case _PERIODICITY_10_24: return PERIODICITY_10_24;
        case _PERIODICITY_20_48: return PERIODICITY_20_48;
        case _PERIODICITY_30_72: return PERIODICITY_30_72;
        case _PERIODICITY_40_96: return PERIODICITY_40_96;
        case _PERIODICITY_61_44: return PERIODICITY_61_44;
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
        case _PERIODICITY_1_28 : return "Periodicity 1.28";
        case _PERIODICITY_2_56 : return "Periodicity 2.56";
        case _PERIODICITY_5_12 : return "Periodicity 5.12";
        case _PERIODICITY_10_24: return "Periodicity 10.24";
        case _PERIODICITY_20_48: return "Periodicity 20.48";
        case _PERIODICITY_30_72: return "Periodicity 30.72";
        case _PERIODICITY_40_96: return "Periodicity 40.96";
        case _PERIODICITY_61_44: return "Periodicity 61.44";
        default:
            return "<Invalid Value>";
    }
  }
}