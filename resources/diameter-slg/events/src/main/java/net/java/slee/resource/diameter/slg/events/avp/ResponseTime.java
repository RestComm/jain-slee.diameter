/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package net.java.slee.resource.diameter.slg.events.avp;

import java.io.Serializable;
import net.java.slee.resource.diameter.base.events.avp.Enumerated;

/**
 * Java class representing the Response-Time enumerated type.
 * From the Diameter-based ELP SLg Reference Point Protocol Details (3GPP TS 29.172 V13.0.0) specification
 * as element of LCS-QoS grouped AVP
 *
 * <pre>
 * 7.4.11	Response-Time
 * 	The Response-Time AVP is of type Enumerated. The following values are defined:
 * 		LOW_DELAY (0)
 * 		DELAY_TOLERANT (1)
 * 	Default value if AVP is not present is: LOW_DELAY (0).
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class ResponseTime implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _LOW_DELAY = 0;
  public static final int _DELAY_TOLERANT = 1;

  public static final ResponseTime LOW_DELAY = new ResponseTime(_LOW_DELAY);
  public static final ResponseTime DELAY_TOLERANT = new ResponseTime(_DELAY_TOLERANT);

  private int value = -1;

  private ResponseTime(int value) {
    this.value = value;
  }

  public static ResponseTime fromInt(int type) {
    switch (type) {
      case _LOW_DELAY:
        return LOW_DELAY;
      case _DELAY_TOLERANT:
        return DELAY_TOLERANT;
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
      case _LOW_DELAY:
        return "LOW_DELAY";
      case _DELAY_TOLERANT:
        return "DELAY_TOLERANT";
      default:
        return "<Invalid Value>";
    }
  }

}

