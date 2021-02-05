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

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TExtension;

/**
 *
 * <p>Interface for tUserCSGInformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *  <xs:complexType name="tUserCSGInformation-Extension">
 * 		    <xs:sequence>
 * 			    <xs:element name="AccessMode" type="tAccessMode" minOccurs="0"/>
 * 			    <xs:element name="CMI" type="tBool" minOccurs="0"/>
 * 			    <xs:element name="Extension" type="tExtension" minOccurs="0"/>
 * 		    </xs:sequence>
 *  </xs:complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface UserCSGInformationExtension {

    /**
     * Gets the value of the accessMode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getAccessMode();

    /**
     * Sets the value of the accessMode property.
     *
     * @param accessMode
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setAccessMode(String accessMode);

    /**
     * Gets the value of the cMI property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public abstract Boolean getCMI();

    /**
     * Sets the value of the cMI property.
     *
     * @param cmi
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public abstract void setCMI(Boolean cmi);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TExtension }
     *
     */
    public abstract Extension getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param value
     *     allowed object is
     *     {@link TExtension }
     *
     */
    public abstract void setExtension(Extension value);

}
