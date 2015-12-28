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
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 34.422 V12.4.0) specification:
 * 
 * <pre>
 * 5.9a Job type (CM)
 *
 * The Job type is a conditional mandatory parameter. The condition is either MDT or RLF or RCEF data collection
 * functionality is supported. It defines if a single trace job, a combined MDT and trace job or RLF report collection job or
 * RCEF report collection job is activated. This parameter also defines the MDT mode. The Job type parameter is an
 * enumerated type with the following values:
 *  - Immediate MDT only (0);
 *  - Logged MDT only (1);
 *  - Trace only (2);
 *  - Immediate MDT and Trace (3);
 *  - RLF reports only (4) ;
 *  - RCEF reports only (5).
 *
 *  NOTE: The Job type 'RLF reports only' and 'RCEF reports only' are applicable only in management based trace
 *  activation in E-UTRAN.
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class JobType implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _IMMEDIATE_MDT_ONLY = 0;
  public static final int _LOGGED_MDT_ONLY = 1;
  public static final int _TRACE_ONLY = 2;
  public static final int _IMMEDIATE_MDT_AND_TRACE = 3;
  public static final int _RLF_REPORTS_ONLY = 4;
  public static final int _RCEF_REPORTS_ONLY = 5;

  public static final JobType IMMEDIATE_MDT_ONLY      = new JobType(_IMMEDIATE_MDT_ONLY);
  public static final JobType LOGGED_MDT_ONLY         = new JobType(_LOGGED_MDT_ONLY);
  public static final JobType TRACE_ONLY              = new JobType(_TRACE_ONLY);
  public static final JobType IMMEDIATE_MDT_AND_TRACE = new JobType(_IMMEDIATE_MDT_AND_TRACE);
  public static final JobType RLF_REPORTS_ONLY        = new JobType(_RLF_REPORTS_ONLY);
  public static final JobType RCEF_REPORTS_ONLY       = new JobType(_RCEF_REPORTS_ONLY);

  private int value = -1;

  private JobType(int value) {
    this.value = value;
  }

  public static JobType fromInt(int type) {
    switch (type) {
      case _IMMEDIATE_MDT_ONLY:
        return IMMEDIATE_MDT_ONLY;
      case _LOGGED_MDT_ONLY:
        return LOGGED_MDT_ONLY;
      case _TRACE_ONLY:
        return TRACE_ONLY;
      case _IMMEDIATE_MDT_AND_TRACE:
        return IMMEDIATE_MDT_AND_TRACE;
      case _RLF_REPORTS_ONLY:
        return RLF_REPORTS_ONLY;
      case _RCEF_REPORTS_ONLY:
        return RCEF_REPORTS_ONLY;
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
        case _IMMEDIATE_MDT_ONLY:
            return "IMMEDIATE_MDT_ONLY";
        case _LOGGED_MDT_ONLY:
            return "LOGGED_MDT_ONLY";
        case _TRACE_ONLY:
            return "TRACE_ONLY";
        case _IMMEDIATE_MDT_AND_TRACE:
            return "IMMEDIATE_MDT_AND_TRACE";
        case _RLF_REPORTS_ONLY:
            return "RLF_REPORTS_ONLY";
        case _RCEF_REPORTS_ONLY:
            return "RCEF_REPORTS_ONLY";
      default:
        return "<Invalid Value>";
    }
  }
}