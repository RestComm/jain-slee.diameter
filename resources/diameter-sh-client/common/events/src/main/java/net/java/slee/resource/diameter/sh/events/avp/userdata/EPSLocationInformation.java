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

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TEPSLocationInformationExtension;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TUserCSGInformation;
import org.w3c.dom.Element;
import java.util.List;

/**
 * <p>Interface for tEPSLocationInformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *  <xs:complexType name="tEPSLocationInformation">
 * 		<xs:sequence>
 * 			<xs:element name="E-UTRANCellGlobalId" type="tE-UTRANCellGlobalId" minOccurs="0"/>
 * 			<xs:element name="TrackingAreaId" type="tTrackingAreaId" minOccurs="0"/>
 * 			<xs:element name="GeographicalInformation" type="tGeographicalInformation" minOccurs="0"/>
 * 			<xs:element name="GeodeticInformation" type="tGeodeticInformation" minOccurs="0"/>
 * 			<xs:element name="MMEName" type="tString" minOccurs="0"/>
 * 			<xs:element name="CurrentLocationRetrieved" type="tBool" minOccurs="0"/>
 * 			<xs:element name="AgeOfLocationInformation" type="tAgeOfLocationInformation" minOccurs="0"/>
 * 			<xs:element name="UserCSGInformation" type="tUserCSGInformation" minOccurs="0"/>
 * 			<xs:element name="Extension" type="tEPSLocationInformation-Extension" minOccurs="0"/>
 * 			<xs:any namespace="##other" processContents="lax" minOccurs="0" maxOccurs="unbounded"/>
 * 		</xs:sequence>
 * 	</xs:complexType>
 * </pre>
 *
 * 	@author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface EPSLocationInformation {

    /**
     * Gets the value of the eUTRANCellGlobalId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getEUTRANCellGlobalId();

    /**
     * Sets the value of the eUTRANCellGlobalId property.
     *
     * @param eUTRANCellGlobalId
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setEUTRANCellGlobalId(String eUTRANCellGlobalId);

    /**
     * Gets the value of the trackingAreaId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getTrackingAreaId();

    /**
     * Sets the value of the trackingAreaId property.
     *
     * @param trackingAreaId
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setTrackingAreaId(String trackingAreaId);

    /**
     * Gets the value of the geographicalInformation property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getGeographicalInformation();

    /**
     * Sets the value of the geographicalInformation property.
     *
     * @param geographicalInformation
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setGeographicalInformation(String geographicalInformation);

    /**
     * Gets the value of the geodeticInformation property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getGeodeticInformation();

    /**
     * Sets the value of the geodeticInformation property.
     *
     * @param geodeticInformation
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setGeodeticInformation(String geodeticInformation);

    /**
     * Gets the value of the mmeName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getMMEName();

    /**
     * Sets the value of the mmeName property.
     *
     * @param mmeName
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setMMEName(String mmeName);

    /**
     * Gets the value of the currentLocationRetrieved property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public abstract Boolean isCurrentLocationRetrieved();

    /**
     * Sets the value of the currentLocationRetrieved property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public abstract void setCurrentLocationRetrieved(Boolean value);

    /**
     * Gets the value of the ageOfLocationInformation property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public abstract Integer getAgeOfLocationInformation();

    /**
     * Sets the value of the ageOfLocationInformation property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public abstract void setAgeOfLocationInformation(Integer value);

    /**
     * Gets the value of the userCSGInformation property.
     *
     * @return
     *     possible object is
     *     {@link TUserCSGInformation }
     *
     */
    public abstract UserCSGInformation getUserCSGInformation();

    /**
     * Sets the value of the userCSGInformation property.
     *
     * @param userCSGInformation
     *     allowed object is
     *     {@link TUserCSGInformation }
     *
     */
    public abstract void setUserCSGInformation(UserCSGInformation userCSGInformation);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TEPSLocationInformationExtension }
     *
     */
    public abstract EPSLocationInformationExtension getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param value
     *     allowed object is
     *     {@link TEPSLocationInformationExtension }
     *
     */
    public abstract void setExtension(EPSLocationInformationExtension value);

    /**
     * Gets the value of the any property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     *
     *
     */
    public abstract List<Object> getAny();

}
