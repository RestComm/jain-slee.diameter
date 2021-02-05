package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.Extension;
import net.java.slee.resource.diameter.sh.events.avp.userdata.LocalTimeZone;
import net.java.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tSh-5GSLocationInformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *  <xs:complexType name="tSh-5GSLocationInformation">
 * 	    <xs:sequence>
 * 		    <xs:element name="NRCellGlobalId" type="tNRCellGlobalId" minOccurs="0"/>
 * 			<xs:element name="E-UTRANCellGlobalId" type="tE-UTRANCellGlobalId" minOccurs="0"/>
 * 			<xs:element name="TrackingAreaId" type="tTrackingAreaId" minOccurs="0"/>
 * 			<xs:element name="GeographicalInformation" type="tGeographicalInformation" minOccurs="0"/>
 * 			<xs:element name="AMFAddress" type="tString" minOccurs="0"/>
 * 			<xs:element name="SMSFAddress" type="tString" minOccurs="0"/>
 * 			<xs:element name="CurrentLocationRetrieved" type="tBool" minOccurs="0"/>
 * 			<xs:element name="AgeOfLocationInformation" type="tAgeOfLocationInformation" minOccurs="0"/>
 * 			<xs:element name="VisitedPLMNID" type="tVisitedPLMNID" minOccurs="0"/>
 * 			<xs:element name="LocalTimeZone" type="tLocalTimeZone" minOccurs="0"/>
 * 			<xs:element name="RATtype" type="tRATtype" minOccurs="0"/>
 * 			<xs:element name="Extension" type="tExtension" minOccurs="0"/>
 * 		</xs:sequence>
 *   </xs:complexType>
 * 	</pre>
 *
 * 	@author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSh-5GSLocationInformation", propOrder = {
    "nrCellGlobalId",
    "eUTRANCellGlobalId",
    "trackingAreaId",
    "geographicalInformation",
    "amfAddress",
    "smsfAddress",
    "currentLocationRetrieved",
    "ageOfLocationInformation",
    "visitedPLMNID",
    "localTimeZone",
    "ratType",
    "extension",
    "any"
})

public class TSh5GSLocationInformation implements Sh5GSLocationInformation {

    @XmlElement(name = "NRCellGlobalId")
    protected String nrCellGlobalId;
    @XmlElement(name = "E-UTRANCellGlobalId")
    protected String eUTRANCellGlobalId;
    @XmlElement(name = "TrackingAreaId")
    protected String trackingAreaId;
    @XmlElement(name = "GeographicalInformation")
    protected String geographicalInformation;
    @XmlElement(name = "AMFAddress")
    protected String amfAddress;
    @XmlElement(name = "SMSFAddress")
    protected String smsfAddress;
    @XmlElement(name = "CurrentLocationRetrieved")
    protected Boolean currentLocationRetrieved;
    @XmlElement(name = "AgeOfLocationInformation")
    protected Integer ageOfLocationInformation;
    @XmlElement(name = "VisitedPLMNID")
    protected Integer visitedPLMNID;
    @XmlElement(name = "LocalTimeZone")
    protected TLocalTimeZone localTimeZone;
    @XmlElement(name = "RATtype")
    protected Integer ratType;
    @XmlElement(name = "Extension")
    protected TExtension extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getNRCellGlobalId()
     */
    public String getNRCellGlobalId() {
        return nrCellGlobalId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setNRCellGlobalId(java.lang.String)
     */
    public void setNRCellGlobalId(String nrCellGlobalId) {
        this.nrCellGlobalId = nrCellGlobalId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getEUTRANCellGlobalId()
     */
    public String getEUTRANCellGlobalId() {
        return eUTRANCellGlobalId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setEUTRANCellGlobalId(java.lang.String)
     */
    public void setEUTRANCellGlobalId(String eUTRANCellGlobalId) {
        this.eUTRANCellGlobalId = eUTRANCellGlobalId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getTrackingAreaId()
     */
    public String getTrackingAreaId() {
        return trackingAreaId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setTrackingAreaId(java.lang.String)
     */
    public void setTrackingAreaId(String trackingAreaId) {
        this.trackingAreaId = trackingAreaId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getGeographicalInformation()
     */
    public String getGeographicalInformation() {
        return geographicalInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setGeographicalInformation(java.lang.String)
     */
    public void setGeographicalInformation(String geographicalInformation) {
        this.geographicalInformation = geographicalInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getAMFAddress()
     */
    public String getAMFAddress() {
        return amfAddress;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setAMFAddress(java.lang.String)
     */
    public void setAMFAddress(String amfAddress) {
        this.amfAddress = amfAddress;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getSMSFAddress()
     */
    public String getSMSFAddress() {
        return smsfAddress;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setSMSFAddress(java.lang.String)
     */
    public void setSMSFAddress(String smfAddress) {
        this.smsfAddress = smsfAddress;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#isCurrentLocationRetrieved()
     */
    public Boolean isCurrentLocationRetrieved() {
        return currentLocationRetrieved;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setCurrentLocationRetrieved(java.lang.Boolean)
     */
    public void setCurrentLocationRetrieved(Boolean currentLocationRetrieved) {
        this.currentLocationRetrieved = currentLocationRetrieved;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getAgeOfLocationInformation()
     */
    public Integer getAgeOfLocationInformation() {
        return ageOfLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setAgeOfLocationInformation(java.lang.Integer)
     */
    public void setAgeOfLocationInformation(Integer ageOfLocationInformation) {
        this.ageOfLocationInformation = ageOfLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getVisitedPLMNID()
     */
    public Integer getVisitedPLMNID() {
        return visitedPLMNID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setVisitedPLMNID(java.lang.Integer)
     */
    public void setVisitedPLMNID(Integer visitedPLMNID) {
        this.visitedPLMNID = visitedPLMNID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getLocalTimeZone()
     */
    public LocalTimeZone getLocalTimeZone() {
        return (LocalTimeZone) localTimeZone;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setLocalTimeZone(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TLocalTimeZone)
     */
    public void setLocalTimeZone(LocalTimeZone localTimeZone) {
        this.localTimeZone = (TLocalTimeZone) localTimeZone;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getRATtype()
     */
    public Integer getRATtype() {
        return ratType;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setRATtype(java.lang.Integer)
     */
    public void setRATtype(Integer ratType) {
        this.ratType = ratType;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getExtension()
     */
    public Extension getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Extension)
     */
    public void setExtension(Extension value) {
        this.extension = (TExtension) value;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }
}
