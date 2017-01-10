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

package net.java.slee.resource.diameter.s13.events.avp;

import java.io.Serializable;
import net.java.slee.resource.diameter.base.events.avp.Enumerated;

/**
 * Java class representing the User-State enumerated type. From the Diameter S13
 * Reference Point Protocol Details (3GPP TS 29.272 V9.6.0) specification:
 *
 * <pre>
 * Equipment-Status
 *
 * The Equipment-Status AVP is of type Enumerated and indicates the IMEI state. The following values are defined:
 *
 * WHITELISTED (0)
 * BLACKLISTED (1)
 * GREYLISTED (2)
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class EquipmentStatus implements Enumerated, Serializable {

    private static final long serialVersionUID = 1L;

    public static final int _WHITELISTED = 0;
    public static final int _BLACKLISTED = 1;
    public static final int _GREYLISTED = 2;

    public static final EquipmentStatus WHITELISTED = new EquipmentStatus(_WHITELISTED);
    public static final EquipmentStatus BLACKLISTED = new EquipmentStatus(_BLACKLISTED);
    public static final EquipmentStatus GREYLISTED = new EquipmentStatus(_GREYLISTED);

    private int value = -1;

    private EquipmentStatus(int value) {
        this.value = value;
    }

    public static EquipmentStatus fromInt(int type) {
        switch (type) {
            case _WHITELISTED:
                return WHITELISTED;
            case _BLACKLISTED:
                return BLACKLISTED;
            case _GREYLISTED:
                return GREYLISTED;
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
            case _WHITELISTED:
                return "WHITELISTED";
            case _BLACKLISTED:
                return "BLACKLISTED";
            case _GREYLISTED:
                return "GREYLISTED";
            default:
                return "<Invalid Value>";
        }
    }

}
