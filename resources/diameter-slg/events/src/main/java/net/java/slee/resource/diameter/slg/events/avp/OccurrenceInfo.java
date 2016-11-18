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
 * Java class representing the Occurrence-Info enumerated type.
 * From the Diameter-based ELP SLg Reference Point Protocol Details (3GPP TS 29.172 V13.0.0) specification
 *
 * <pre>
 * 7.4.43	Occurrence-Info
 * 	The Occurrence-Info AVP is of type Enumerated. The following values are defined:
 * 		ONE_TIME_EVENT (0)
 * 		MULTIPLE_TIME_EVENT (1)
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public class OccurrenceInfo implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _ONE_TIME_EVENT = 0;
  public static final int _MULTIPLE_TIME_EVENT = 1;

  public static final OccurrenceInfo ONE_TIME_EVENT = new OccurrenceInfo(_ONE_TIME_EVENT);
  public static final OccurrenceInfo MULTIPLE_TIME_EVENT = new OccurrenceInfo(_MULTIPLE_TIME_EVENT);

  private int value = -1;

  private OccurrenceInfo(int value) {
    this.value = value;
  }

  public static OccurrenceInfo fromInt(int type) {
    switch (type) {
      case _ONE_TIME_EVENT:
        return ONE_TIME_EVENT;
      case _MULTIPLE_TIME_EVENT:
        return MULTIPLE_TIME_EVENT;
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
      case _ONE_TIME_EVENT:
        return "ONE_TIME_EVENT";
      case _MULTIPLE_TIME_EVENT:
        return "MULTIPLE_TIME_EVENT";
      default:
        return "<Invalid Value>";
    }
  }

}
