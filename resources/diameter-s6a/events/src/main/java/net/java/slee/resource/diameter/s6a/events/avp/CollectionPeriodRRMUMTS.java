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
 * Java class representing the Collection-Period-RRM-LTE enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 32.422 V12.4.0) specification:
 *
 * <pre>
 * 5.10.20 Collection period for RRM measurements LTE
 *
 * This parameter is mandatory if the job type is set to Immediate MDT or Immediate MDT and Trace and any of the bits
 * 2 (M2) or 3 (M3) of the list of measurements parameter (defined in Section 5.10.3) in LTE is set to 1. The parameter is
 * used only in case of RAN side measurements whose configuration is determined by RRM.
 *
 * This measurement parameter defines the collection period that should be used to collect available measurement samples
 * in case of RRM configured measurements. The same collection period should be used for all such measurements that
 * are requested in the same MDT or combined Trace and MDT job.
 *
 * The parameter is an enumerated type with the following values:
 *      1024 ms (0),
 *      1280 ms (1),
 *      2048 ms (2),
 *      2560 ms (3),
 *      5120 ms (4),
 *      10240 ms (5),
 *      1 min (6).
 *
 * Some values may not be always available e.g., due to the large amount of logging they would generate in a highly
 * loaded network. The selection of a specific subset of supported values at the eNB is vendor-specific.  * </pre>
 *
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class CollectionPeriodRRMUMTS implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

    public static final int _MS_250   = 0;
    public static final int _MS_500   = 1;
    public static final int _MS_1000  = 2;
    public static final int _MS_2000  = 3;
    public static final int _MS_3000  = 4;
    public static final int _MS_4000  = 5;
    public static final int _MS_6000  = 6;
    public static final int _MS_8000  = 7;
    public static final int _MS_12000 = 8;
    public static final int _MS_16000 = 9;
    public static final int _MS_20000 = 10;
    public static final int _MS_24000 = 11;
    public static final int _MS_28000 = 12;
    public static final int _MS_32000 = 13;
    public static final int _MS_64000 = 14;

    public static final CollectionPeriodRRMUMTS MS_250   = new CollectionPeriodRRMUMTS(_MS_250);
    public static final CollectionPeriodRRMUMTS MS_500   = new CollectionPeriodRRMUMTS(_MS_500);
    public static final CollectionPeriodRRMUMTS MS_1000  = new CollectionPeriodRRMUMTS(_MS_1000);
    public static final CollectionPeriodRRMUMTS MS_2000  = new CollectionPeriodRRMUMTS(_MS_2000);
    public static final CollectionPeriodRRMUMTS MS_3000  = new CollectionPeriodRRMUMTS(_MS_3000);
    public static final CollectionPeriodRRMUMTS MS_4000  = new CollectionPeriodRRMUMTS(_MS_4000);
    public static final CollectionPeriodRRMUMTS MS_6000  = new CollectionPeriodRRMUMTS(_MS_6000);
    public static final CollectionPeriodRRMUMTS MS_8000  = new CollectionPeriodRRMUMTS(_MS_8000);
    public static final CollectionPeriodRRMUMTS MS_12000 = new CollectionPeriodRRMUMTS(_MS_12000);
    public static final CollectionPeriodRRMUMTS MS_16000 = new CollectionPeriodRRMUMTS(_MS_16000);
    public static final CollectionPeriodRRMUMTS MS_20000 = new CollectionPeriodRRMUMTS(_MS_20000);
    public static final CollectionPeriodRRMUMTS MS_24000 = new CollectionPeriodRRMUMTS(_MS_24000);
    public static final CollectionPeriodRRMUMTS MS_28000 = new CollectionPeriodRRMUMTS(_MS_28000);
    public static final CollectionPeriodRRMUMTS MS_32000 = new CollectionPeriodRRMUMTS(_MS_32000);
    public static final CollectionPeriodRRMUMTS MS_64000 = new CollectionPeriodRRMUMTS(_MS_64000);

  private int value = -1;

  private CollectionPeriodRRMUMTS(int value) {
    this.value = value;
  }

  public static CollectionPeriodRRMUMTS fromInt(int type) {
    switch (type) {
        case _MS_250  :    return MS_250  ;
        case _MS_500  :    return MS_500  ;
        case _MS_1000 :    return MS_1000 ;
        case _MS_2000 :    return MS_2000 ;
        case _MS_3000 :    return MS_3000 ;
        case _MS_4000 :    return MS_4000 ;
        case _MS_6000 :    return MS_6000 ;
        case _MS_8000 :    return MS_8000 ;
        case _MS_12000:    return MS_12000;
        case _MS_16000:    return MS_16000;
        case _MS_20000:    return MS_20000;
        case _MS_24000:    return MS_24000;
        case _MS_28000:    return MS_28000;
        case _MS_32000:    return MS_32000;
        case _MS_64000:    return MS_64000;
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
        case _MS_250  :    return "250 milliseconds";
        case _MS_500  :    return "500 milliseconds";
        case _MS_1000 :    return "1000 milliseconds";
        case _MS_2000 :    return "2000 milliseconds";
        case _MS_3000 :    return "3000 milliseconds";
        case _MS_4000 :    return "4000 milliseconds";
        case _MS_6000 :    return "6000 milliseconds";
        case _MS_8000 :    return "8000 milliseconds";
        case _MS_12000:    return "12000 milliseconds";
        case _MS_16000:    return "16000 milliseconds";
        case _MS_20000:    return "20000 milliseconds";
        case _MS_24000:    return "24000 milliseconds";
        case _MS_28000:    return "28000 milliseconds";
        case _MS_32000:    return "32000 milliseconds";
        case _MS_64000:    return "64000 milliseconds";
        default:
            return "<Invalid Value>";
    }
  }
}