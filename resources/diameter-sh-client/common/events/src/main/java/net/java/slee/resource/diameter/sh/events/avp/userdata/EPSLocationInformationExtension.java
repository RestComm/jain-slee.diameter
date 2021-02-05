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

package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.w3c.dom.Element;
import java.util.List;

/**
 * <p>Interface for tEPSLocationInformation-Extension complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *  <xs:complexType name="tEPSLocationInformation-Extension">
 * 		<xs:sequence>
 * 			<xs:element name="VisitedPLMNID" type="tVisitedPLMNID" minOccurs="0"/>
 * 			<xs:element name="LocalTimeZone" type="tLocalTimeZone" minOccurs="0"/>
 * 			<xs:element name="Extension" type="tEPSLocationInformation-Extension2" minOccurs="0"/>
 * 		</xs:sequence>
 * 	</xs:complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface EPSLocationInformationExtension {

    /**
     * Gets the value of the visitedPLMNID property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public abstract Integer getVisitedPLMNID();

    /**
     * Sets the value of the localTimeZone property.
     *
     * @param visitedPLMNID
     *     allowed object is
     *     {@link Integer }
     *
     */
    public abstract void setVisitedPLMNID(Integer visitedPLMNID);

    /**
     * Gets the value of the localTimeZone property.
     *
     * @return
     *     possible object is
     *     {@link LocalTimeZone }
     *
     */
    public abstract LocalTimeZone getLocalTimeZone();

    /**
     * Sets the value of the localTimeZone property.
     *
     * @param localTimeZone
     *     allowed object is
     *     {@link LocalTimeZone }
     *
     */
    public abstract void setLocalTimeZone(LocalTimeZone localTimeZone);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TEPSLocationInformationExtension2 }
     *
     */
    public abstract EPSLocationInformationExtension2 getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param epsLocationInformationExtension2
     *     allowed object is
     *     {@link org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TEPSLocationInformationExtension2 }
     *
     */
    public abstract void setExtension(EPSLocationInformationExtension2 epsLocationInformationExtension2);

}
