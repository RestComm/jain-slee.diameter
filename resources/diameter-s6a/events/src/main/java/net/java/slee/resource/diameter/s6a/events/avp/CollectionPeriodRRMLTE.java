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
public class CollectionPeriodRRMLTE implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

    public static final int _MS_1024  = 0;
    public static final int _MS_1280  = 1;
    public static final int _MS_2048  = 2;
    public static final int _MS_2560  = 3;
    public static final int _MS_5120  = 4;
    public static final int _MS_10240 = 5;
    public static final int _MIN_1    = 6;

    public static final CollectionPeriodRRMLTE MS_1024  = new CollectionPeriodRRMLTE(_MS_1024);
    public static final CollectionPeriodRRMLTE MS_1280  = new CollectionPeriodRRMLTE(_MS_1280);
    public static final CollectionPeriodRRMLTE MS_2048  = new CollectionPeriodRRMLTE(_MS_2048);
    public static final CollectionPeriodRRMLTE MS_2560  = new CollectionPeriodRRMLTE(_MS_2560);
    public static final CollectionPeriodRRMLTE MS_5120  = new CollectionPeriodRRMLTE(_MS_5120);
    public static final CollectionPeriodRRMLTE MS_10240 = new CollectionPeriodRRMLTE(_MS_10240);
    public static final CollectionPeriodRRMLTE MIN_1    = new CollectionPeriodRRMLTE(_MIN_1);

  private int value = -1;

  private CollectionPeriodRRMLTE(int value) {
    this.value = value;
  }

  public static CollectionPeriodRRMLTE fromInt(int type) {
    switch (type) {
        case _MS_1024 :    return MS_1024 ;
        case _MS_1280 :    return MS_1280 ;
        case _MS_2048 :    return MS_2048 ;
        case _MS_2560 :    return MS_2560 ;
        case _MS_5120 :    return MS_5120 ;
        case _MS_10240:    return MS_10240;
        case _MIN_1   :    return MIN_1   ;
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
        case _MS_1024 :    return "1024 milliseconds";
        case _MS_1280 :    return "1280 milliseconds";
        case _MS_2048 :    return "2048 milliseconds";
        case _MS_2560 :    return "2560 milliseconds";
        case _MS_5120 :    return "5120 milliseconds";
        case _MS_10240:    return "10240 milliseconds";
        case _MIN_1   :    return "1 minute";
        default:
            return "<Invalid Value>";
    }
  }
}