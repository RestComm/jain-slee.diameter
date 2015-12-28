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

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Local-Time-Zone grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.3.156 Local-Time-Zone
 *
 * The Local-Time-Zone AVP is of type Grouped and shall contain the Time Zone and the Daylight Saving Time (DST)
 * adjustment of the location in the visited network where the UE is attached.
 *
 * The AVP format shall conform to:
 * Local-Time-Zone ::= <AVP header: 1649 10415>
 *                      { Time-Zone }
 *                      { Daylight-Saving-Time }
 *                      * [ AVP ]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface LocalTimeZoneAvp extends GroupedAvp {

    /*
        7.3.163 Time-Zone
        The Time-Zone AVP is of type UTF8String and shall contain the time zone of the location in the visited network
        where the UE is attached.
     */
    public boolean hasTimeZone();
    public String getTimeZone();
    public void setTimeZone(String timeZone);

    /*
        7.3.164 Daylight-Saving-Time
        The Daylight-Saving-Time AVP is of type Enumerated and shall contain the Daylight Saving Time (in steps of 1 hour)
        used to adjust for summertime the time zone of the location where the UE is attached in the visited network.
     */
    public boolean hasDaylightSavingTime();
    public DaylightSavingTime getDaylightSavingTime();
    public void setDaylightSavingTime(DaylightSavingTime daylightSavingTime);
}