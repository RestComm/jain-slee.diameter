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
 * Java class representing the Measurement-Period-UMTS enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 32.422 V12.4.0) specification:
 *
 * <pre>
 * 5.10.22 Measurement period UMTS
 *
 * This parameter is mandatory if the job type is set to Immediate MDT or Immediate MDT and Trace and either the bit 6
 * or bit 7 or bit 8 or bit 9 of list of measurements parameter in UMTS (M6 for DL or M6 for UL or M7 for DL or M7 for
 * UL) is set to 1.
 * This measurement parameter defines the measuremet period that should be used for the Data Volume and Throughput
 * measurements made by the RNC. The same measurement period should be used for the UL and DL.
 *
 *  The parameter is an enumerated type with the following values (the values 250ms (0) and 500ms (1) are not valid for
 * this parameter):
 *
 *  ? 250 ms (0),
 *  ? 500 ms (1),
 *  ? 1000 ms (2),
 *  ? 2000 ms (3),
 *  ? 3000 ms (4),
 *  ? 4000 ms (5),
 *  ? 6000 ms (6),
 *  ? 8000 ms (7),
 *  ? 12000 ms (8),
 *  ? 16000 ms (9),
 *  ? 20000 ms (10),
 *  ? 24000 ms (11),
 *  ? 28000 ms (12),
 *  ? 32000 ms (13),
 *  ? 64000 ms (14).
 * </pre>
 *
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class MeasurementPeriodUMTS implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

    public static final int _MS_250 = 0;
    public static final int _MS_500 = 1;
    public static final int _MS_1000= 2;
    public static final int _MS_2000= 3;
    public static final int _MS_3000= 4;
    public static final int _MS_4000= 5;
    public static final int _MS_6000= 6;
    public static final int _MS_8000= 7;
    public static final int _MS_12000= 8;
    public static final int _MS_16000= 9;
    public static final int _MS_20000= 10;
    public static final int _MS_24000= 11;
    public static final int _MS_28000= 12;
    public static final int _MS_32000= 13;
    public static final int _MS_64000= 14;

    public static final MeasurementPeriodUMTS MS_250     = new MeasurementPeriodUMTS(_MS_250);
    public static final MeasurementPeriodUMTS MS_500     = new MeasurementPeriodUMTS(_MS_500);
    public static final MeasurementPeriodUMTS MS_1000    = new MeasurementPeriodUMTS(_MS_1000);
    public static final MeasurementPeriodUMTS MS_2000    = new MeasurementPeriodUMTS(_MS_2000);
    public static final MeasurementPeriodUMTS MS_3000    = new MeasurementPeriodUMTS(_MS_3000);
    public static final MeasurementPeriodUMTS MS_4000    = new MeasurementPeriodUMTS(_MS_4000);
    public static final MeasurementPeriodUMTS MS_6000    = new MeasurementPeriodUMTS(_MS_6000);
    public static final MeasurementPeriodUMTS MS_8000    = new MeasurementPeriodUMTS(_MS_8000);
    public static final MeasurementPeriodUMTS MS_12000   = new MeasurementPeriodUMTS(_MS_12000);
    public static final MeasurementPeriodUMTS MS_16000   = new MeasurementPeriodUMTS(_MS_16000);
    public static final MeasurementPeriodUMTS MS_20000   = new MeasurementPeriodUMTS(_MS_20000);
    public static final MeasurementPeriodUMTS MS_24000   = new MeasurementPeriodUMTS(_MS_24000);
    public static final MeasurementPeriodUMTS MS_28000   = new MeasurementPeriodUMTS(_MS_28000);
    public static final MeasurementPeriodUMTS MS_32000   = new MeasurementPeriodUMTS(_MS_32000);
    public static final MeasurementPeriodUMTS MS_64000   = new MeasurementPeriodUMTS(_MS_64000);

  private int value = -1;

  private MeasurementPeriodUMTS(int value) {
    this.value = value;
  }

  public static MeasurementPeriodUMTS fromInt(int type) {
    switch (type) {
        case _MS_250:     return MS_250;
        case _MS_500:     return MS_500;
        case _MS_1000:    return MS_1000;
        case _MS_2000:    return MS_2000;
        case _MS_3000:    return MS_3000;
        case _MS_4000:    return MS_4000;
        case _MS_6000:    return MS_6000;
        case _MS_8000:    return MS_8000;
        case _MS_12000:   return MS_12000;
        case _MS_16000:   return MS_16000;
        case _MS_20000:   return MS_20000;
        case _MS_24000:   return MS_24000;
        case _MS_28000:   return MS_28000;
        case _MS_32000:   return MS_32000;
        case _MS_64000:   return MS_64000;
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
        case _MS_250:     return "250 milliseconds";
        case _MS_500:     return "500 milliseconds";
        case _MS_1000:    return "1000 milliseconds";
        case _MS_2000:    return "2000 milliseconds";
        case _MS_3000:    return "3000 milliseconds";
        case _MS_4000:    return "4000 milliseconds";
        case _MS_6000:    return "6000 milliseconds";
        case _MS_8000:    return "8000 milliseconds";
        case _MS_12000:   return "12000 milliseconds";
        case _MS_16000:   return "16000 milliseconds";
        case _MS_20000:   return "20000 milliseconds";
        case _MS_24000:   return "24000 milliseconds";
        case _MS_28000:   return "28000 milliseconds";
        case _MS_32000:   return "32000 milliseconds";
        case _MS_64000:   return "64000 milliseconds";
        default:
            return "<Invalid Value>";
    }
  }
}