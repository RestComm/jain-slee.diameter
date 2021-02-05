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

package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.java.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation;
import net.java.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension;
import net.java.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation;

/**
 * <p>Java class for tEPSLocationInformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *	<xs:complexType name="tEPSLocationInformation">
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
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEPSLocationInformation", propOrder = {
    "eUTRANCellGlobalId",
    "trackingAreaId",
    "geographicalInformation",
    "geodeticInformation",
    "mmeName",
    "currentLocationRetrieved",
    "ageOfLocationInformation",
    "userCSGInformation",
    "extension",
    "any"
})
public class TEPSLocationInformation implements EPSLocationInformation {

    @XmlElement(name = "E-UTRANCellGlobalId")
    protected String eUTRANCellGlobalId;
    @XmlElement(name = "TrackingAreaId")
    protected String trackingAreaId;
    @XmlElement(name = "GeographicalInformation")
    protected String geographicalInformation;
    @XmlElement(name = "GeodeticInformation")
    protected String geodeticInformation;
    @XmlElement(name = "MMEName")
    protected String mmeName;
    @XmlElement(name = "CurrentLocationRetrieved")
    protected Boolean currentLocationRetrieved;
    @XmlElement(name = "AgeOfLocationInformation")
    protected Integer ageOfLocationInformation;
    @XmlElement(name = "UserCSGInformation")
    protected TUserCSGInformation userCSGInformation;
    @XmlElement(name = "Extension")
    protected TEPSLocationInformationExtension extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#getEUTRANCellGlobalId()
     */
    public String getEUTRANCellGlobalId() {
        return eUTRANCellGlobalId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#setEUTRANCellGlobalId(java.lang.String)
     */
    public void setEUTRANCellGlobalId(String value) {
        this.eUTRANCellGlobalId = value;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#getTrackingAreaId()
     */
    public String getTrackingAreaId() {
        return trackingAreaId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#setTrackingAreaId(java.lang.String)
     */
    public void setTrackingAreaId(String value) {
        this.trackingAreaId = value;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#getGeographicalInformation()
     */
    public String getGeographicalInformation() {
        return geographicalInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#setGeographicalInformation(java.lang.String)
     */
    public void setGeographicalInformation(String value) {
        this.geographicalInformation = value;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#getGeodeticInformation()
     */
    public String getGeodeticInformation() {
        return geodeticInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#setGeodeticInformation(java.lang.String)
     */
    public void setGeodeticInformation(String value) {
        this.geodeticInformation = value;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#getMMEName()
     */
    public String getMMEName() {
        return mmeName;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#setMMEName(java.lang.String)
     */
    public void setMMEName(String mmeName) {
        this.mmeName = mmeName;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#isCurrentLocationRetrieved()
     */
    public Boolean isCurrentLocationRetrieved() {
        return currentLocationRetrieved;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#setCurrentLocationRetrieved(java.lang.Boolean)
     */
    public void setCurrentLocationRetrieved(Boolean currentLocationRetrieved) {
        this.currentLocationRetrieved = currentLocationRetrieved;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#getAgeOfLocationInformation()
     */
    public Integer getAgeOfLocationInformation() {
        return ageOfLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#setAgeOfLocationInformation(java.lang.Integer)
     */
    public void setAgeOfLocationInformation(Integer ageOfLocationInformation) {
        this.ageOfLocationInformation = ageOfLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#getUserCSGInformation()
     */
    public UserCSGInformation getUserCSGInformation() {
        return (UserCSGInformation) userCSGInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#setUserCSGInformation(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation)
     */
    public void setUserCSGInformation(UserCSGInformation userCSGInformation) {
        this.userCSGInformation = (TUserCSGInformation) userCSGInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#getExtension()
     */
    public EPSLocationInformationExtension getExtension() {
        return (EPSLocationInformationExtension) extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension)
     */
    public void setExtension(EPSLocationInformationExtension epsLocationInformationExtension) {
        this.extension = (TEPSLocationInformationExtension) epsLocationInformationExtension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
