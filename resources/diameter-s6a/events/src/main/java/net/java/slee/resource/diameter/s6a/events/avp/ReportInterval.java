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
 * 5.10.5 Report Interval
 * This parameter is mandatory if the Reporting trigger is configured for Periodic UE side measurements a(such as M1
 * measurement in LTE and M1/M2 measurements in UMTS)nd the jobtype is configured for Immediate MDT or
 * combined Immediate MDT and Trace. The parameter indicates the interval between the periodical measurements to be
 * taken when UE is in connected.
 *
 * The parameter is enumerated type with the following values in milliseconds in case of UMTS (detailed definition is in
 * 3GPP TS 25.331 [31]:
 *
 * ? 250 ms (0),
 * ? 500 ms (1),
 * ? 1000 ms (2),
 * ? 2000 ms (3),
 * ? 3000 ms (4),
 * ? 4000 ms (5),
 * ? 6000 ms (6),
 * ? 8000 ms (7),
 * ? 12000 ms (8),
 * ? 16000 ms (9),
 * ? 20000 ms (10),
 * ? 24000 ms (11),
 * ? 28000 ms (12),
 * ? 32000 ms (13),
 * ? 64000 ms (14)
 *
 * The parameter can have the following values in LTE (detailed definition is in 3GPP TS 36.331 [32]):
 * ? 120 ms (15),
 * ? 240 ms (16),
 * ? 480 ms (17),
 * ? 640 ms (18),
 * ? 1024 ms (19),
 * ? 2048 ms (20),
 * ? 5120 ms (21),
 * ? 10240ms (22),
 * ? 1 min=60000 ms (23),
 * ? 6 min=360000 ms (24),
 * ? 12 min=720000 ms (25),
 * ? 30 min=1800000 ms (26),
 * ? 60 min=3600000 ms (27)
 * </pre>
 *
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class ReportInterval implements Enumerated, Serializable {

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
    public static final int _MS_120= 15;
    public static final int _MS_240= 16;
    public static final int _MS_480= 17;
    public static final int _MS_640= 18;
    public static final int _MS_1024= 19;
    public static final int _MS_2048= 20;
    public static final int _MS_5120= 21;
    public static final int _MS_10240= 22;
    public static final int _MS_60000= 23;
    public static final int _MS_360000= 24;
    public static final int _MS_720000= 25;
    public static final int _MS_1800000= 26;
    public static final int _MS_3600000= 27;

    public static final ReportInterval MS_250     = new ReportInterval(_MS_250);
    public static final ReportInterval MS_500     = new ReportInterval(_MS_500);
    public static final ReportInterval MS_1000    = new ReportInterval(_MS_1000);
    public static final ReportInterval MS_2000    = new ReportInterval(_MS_2000);
    public static final ReportInterval MS_3000    = new ReportInterval(_MS_3000);
    public static final ReportInterval MS_4000    = new ReportInterval(_MS_4000);
    public static final ReportInterval MS_6000    = new ReportInterval(_MS_6000);
    public static final ReportInterval MS_8000    = new ReportInterval(_MS_8000);
    public static final ReportInterval MS_12000   = new ReportInterval(_MS_12000);
    public static final ReportInterval MS_16000   = new ReportInterval(_MS_16000);
    public static final ReportInterval MS_20000   = new ReportInterval(_MS_20000);
    public static final ReportInterval MS_24000   = new ReportInterval(_MS_24000);
    public static final ReportInterval MS_28000   = new ReportInterval(_MS_28000);
    public static final ReportInterval MS_32000   = new ReportInterval(_MS_32000);
    public static final ReportInterval MS_64000   = new ReportInterval(_MS_64000);
    public static final ReportInterval MS_120     = new ReportInterval(_MS_120);
    public static final ReportInterval MS_240     = new ReportInterval(_MS_240);
    public static final ReportInterval MS_480     = new ReportInterval(_MS_480);
    public static final ReportInterval MS_640     = new ReportInterval(_MS_640);
    public static final ReportInterval MS_1024    = new ReportInterval(_MS_1024);
    public static final ReportInterval MS_2048    = new ReportInterval(_MS_2048);
    public static final ReportInterval MS_5120    = new ReportInterval(_MS_5120);
    public static final ReportInterval MS_10240   = new ReportInterval(_MS_10240);
    public static final ReportInterval MS_60000   = new ReportInterval(_MS_60000);
    public static final ReportInterval MS_360000  = new ReportInterval(_MS_360000);
    public static final ReportInterval MS_720000  = new ReportInterval(_MS_720000);
    public static final ReportInterval MS_1800000 = new ReportInterval(_MS_1800000);
    public static final ReportInterval MS_3600000 = new ReportInterval(_MS_3600000);

  private int value = -1;

  private ReportInterval(int value) {
    this.value = value;
  }

  public static ReportInterval fromInt(int type) {
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
        case _MS_120:     return MS_120;
        case _MS_240:     return MS_240;
        case _MS_480:     return MS_480;
        case _MS_640:     return MS_640;
        case _MS_1024:    return MS_1024;
        case _MS_2048:    return MS_2048;
        case _MS_5120:    return MS_5120;
        case _MS_10240:   return MS_10240;
        case _MS_60000:   return MS_60000;
        case _MS_360000:  return MS_360000;
        case _MS_720000:  return MS_720000;
        case _MS_1800000: return MS_1800000;
        case _MS_3600000: return MS_3600000;
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
        case _MS_250:     return "MS_250";
        case _MS_500:     return "MS_500";
        case _MS_1000:    return "MS_1000";
        case _MS_2000:    return "MS_2000";
        case _MS_3000:    return "MS_3000";
        case _MS_4000:    return "MS_4000";
        case _MS_6000:    return "MS_6000";
        case _MS_8000:    return "MS_8000";
        case _MS_12000:   return "MS_12000";
        case _MS_16000:   return "MS_16000";
        case _MS_20000:   return "MS_20000";
        case _MS_24000:   return "MS_24000";
        case _MS_28000:   return "MS_28000";
        case _MS_32000:   return "MS_32000";
        case _MS_64000:   return "MS_64000";
        case _MS_120:     return "MS_120";
        case _MS_240:     return "MS_240";
        case _MS_480:     return "MS_480";
        case _MS_640:     return "MS_640";
        case _MS_1024:    return "MS_1024";
        case _MS_2048:    return "MS_2048";
        case _MS_5120:    return "MS_5120";
        case _MS_10240:   return "MS_10240";
        case _MS_60000:   return "MS_60000";
        case _MS_360000:  return "MS_360000";
        case _MS_720000:  return "MS_720000";
        case _MS_1800000: return "MS_1800000";
        case _MS_3600000: return "MS_3600000";
        default:
            return "<Invalid Value>";
    }
  }
}