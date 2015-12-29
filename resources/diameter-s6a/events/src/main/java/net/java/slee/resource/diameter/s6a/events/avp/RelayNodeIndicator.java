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
 * Java class representing the Relay-Node-Indicator enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.147 Relay-Node-Indicator
 *
 * The Relay-Node-Indicator AVP is of type Enumerated. It shall indicate whether the subscription data belongs to a
 * Relay Node or not (see 3GPP TS 36.300 [40]). The following values are defined:
 *      NOT_RELAY_NODE (0)
 *          This value indicates that the subscription data does not belong to a Relay Node.
 *      RELAY_NODE (1)
 *      This value indicates that the subscription data belongs to a Relay Node.
 *
 * The default value when this AVP is not present is NOT_RELAY_NODE (0).
 * </pre>
 *
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public class RelayNodeIndicator implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

    public static final int _NOT_RELAY_NODE = 0;
    public static final int _RELAY_NODE = 1;

    public static final RelayNodeIndicator NOT_RELAY_NODE  = new RelayNodeIndicator(_NOT_RELAY_NODE);
    public static final RelayNodeIndicator RELAY_NODE      = new RelayNodeIndicator(_RELAY_NODE);

  private int value = -1;

  private RelayNodeIndicator(int value) {
    this.value = value;
  }

  public static RelayNodeIndicator fromInt(int type) {
    switch (type) {
        case _NOT_RELAY_NODE :       return NOT_RELAY_NODE ;
        case _RELAY_NODE     :       return RELAY_NODE ;
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
        case _NOT_RELAY_NODE :    return "NOT_RELAY_NODE";
        case _RELAY_NODE     :    return "RELAY_NODE";
        default:
            return "<Invalid Value>";
    }
  }
}