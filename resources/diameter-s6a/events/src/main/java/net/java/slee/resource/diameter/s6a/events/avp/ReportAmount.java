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
 * 5.10.6 Report Amount
 *
 * The parameter is mandatory if the reporting trigger is configured for periodical UE side measurement (such as M1
 * measurement in LTE and M1/M2 measurements in UMTS) and the jobtype is configured for Immediate MDT or
 * combined Immediate MDT and Trace. The parameter defines the number of measurement reports that shall be taken for
 * periodical reporting while UE is in connected. Detailed definition of the paremeter is in 3GPP TS 36.331 and 3GPP TS
 * 25.331[31].
 *
 * The parameter is an enumerated type with the following values in UMTS and in LTE:
 * ? 1 (0),
 * ? 2 (1),
 * ? 4 (2),
 * ? 8 (3),
 * ? 16 (4),
 * ? 32 (5),
 * ? 64 (6),
 * ? infinity (7)
 * </pre>
 *
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class ReportAmount implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

    public static final int _MEASUREMENT_REPORTS_1 = 0;
    public static final int _MEASUREMENT_REPORTS_2 = 1;
    public static final int _MEASUREMENT_REPORTS_4 = 2;
    public static final int _MEASUREMENT_REPORTS_8 = 3;
    public static final int _MEASUREMENT_REPORTS_16 = 4;
    public static final int _MEASUREMENT_REPORTS_32 = 5;
    public static final int _MEASUREMENT_REPORTS_64 = 6;
    public static final int _MEASUREMENT_REPORTS_INFINITY = 7;

    public static final ReportAmount MEASUREMENT_REPORTS_1        = new ReportAmount(_MEASUREMENT_REPORTS_1);
    public static final ReportAmount MEASUREMENT_REPORTS_2        = new ReportAmount(_MEASUREMENT_REPORTS_2);
    public static final ReportAmount MEASUREMENT_REPORTS_4        = new ReportAmount(_MEASUREMENT_REPORTS_4);
    public static final ReportAmount MEASUREMENT_REPORTS_8        = new ReportAmount(_MEASUREMENT_REPORTS_8);
    public static final ReportAmount MEASUREMENT_REPORTS_16       = new ReportAmount(_MEASUREMENT_REPORTS_16);
    public static final ReportAmount MEASUREMENT_REPORTS_32       = new ReportAmount(_MEASUREMENT_REPORTS_32);
    public static final ReportAmount MEASUREMENT_REPORTS_64       = new ReportAmount(_MEASUREMENT_REPORTS_64);
    public static final ReportAmount MEASUREMENT_REPORTS_INFINITY = new ReportAmount(_MEASUREMENT_REPORTS_INFINITY);

  private int value = -1;

  private ReportAmount(int value) {
    this.value = value;
  }

  public static ReportAmount fromInt(int type) {
    switch (type) {
        case _MEASUREMENT_REPORTS_1 :       return MEASUREMENT_REPORTS_1 ;
        case _MEASUREMENT_REPORTS_2 :       return MEASUREMENT_REPORTS_2 ;
        case _MEASUREMENT_REPORTS_4 :       return MEASUREMENT_REPORTS_4 ;
        case _MEASUREMENT_REPORTS_8 :       return MEASUREMENT_REPORTS_8 ;
        case _MEASUREMENT_REPORTS_16:       return MEASUREMENT_REPORTS_16;
        case _MEASUREMENT_REPORTS_32:       return MEASUREMENT_REPORTS_32;
        case _MEASUREMENT_REPORTS_64:       return MEASUREMENT_REPORTS_64;
        case _MEASUREMENT_REPORTS_INFINITY: return MEASUREMENT_REPORTS_INFINITY;
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
        case _MEASUREMENT_REPORTS_1 :    return "MEASUREMENT_REPORTS_1";
        case _MEASUREMENT_REPORTS_2 :    return "MEASUREMENT_REPORTS_2";
        case _MEASUREMENT_REPORTS_4 :    return "MEASUREMENT_REPORTS_4";
        case _MEASUREMENT_REPORTS_8 :    return "MEASUREMENT_REPORTS_8";
        case _MEASUREMENT_REPORTS_16:    return "MEASUREMENT_REPORTS_16";
        case _MEASUREMENT_REPORTS_32:    return "MEASUREMENT_REPORTS_32";
        case _MEASUREMENT_REPORTS_64:    return "MEASUREMENT_REPORTS_64";
        case _MEASUREMENT_REPORTS_INFINITY:    return "MEASUREMENT_REPORTS_INFINITY";
        default:
            return "<Invalid Value>";
    }
  }
}