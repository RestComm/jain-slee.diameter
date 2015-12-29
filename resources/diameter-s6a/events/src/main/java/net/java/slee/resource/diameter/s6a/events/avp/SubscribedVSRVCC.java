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
 * Java class representing the Subscribed-VSRVCC enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.150 Subscribed-VSRVCC
 *
 * The Subscribed-VSRVCC AVP is of type Enumerated. It shall indicate that the user is subscribed to the vSRVCC. The
 * following value is defined:
 *
 *      VSRVCC_SUBSCRIBED (0)
 *
 * Absence of this AVP in IDR shall be interpreted as the Subscribed-VSRVCC has not been modified.
 * Absence of this AVP in ULA shall be interpreted as the user is not subscribed to the vSRVCC.
 * </pre>
 *
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class SubscribedVSRVCC implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _VSRVCC_SUBSCRIBED = 0;

  public static final SubscribedVSRVCC VSRVCC_SUBSCRIBED  = new SubscribedVSRVCC(_VSRVCC_SUBSCRIBED);

  private int value = -1;

  private SubscribedVSRVCC(int value) {
    this.value = value;
  }

  public static SubscribedVSRVCC fromInt(int type) {
    switch (type) {
        case _VSRVCC_SUBSCRIBED :       return VSRVCC_SUBSCRIBED ;
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
        case _VSRVCC_SUBSCRIBED :    return "VSRVCC_SUBSCRIBED";
        default:
            return "<Invalid Value>";
    }
  }
}