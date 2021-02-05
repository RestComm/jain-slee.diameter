package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TExtension;
import org.w3c.dom.Element;

import java.util.List;

/**
 * <p>Interface for tSh-5GSLocationInformation complex type.
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
public interface Sh5GSLocationInformation {

    /**
     * Gets the value of the NRCellGlobalId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getNRCellGlobalId();

    /**
     * Sets the value of the NRCellGlobalId property.
     *
     * @param eUTRANCellGlobalId
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setNRCellGlobalId(String eUTRANCellGlobalId);

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
     * Gets the value of the amfAddress property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getAMFAddress();

    /**
     * Sets the value of the amfAddress property.
     *
     * @param amfAddress
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setAMFAddress(String amfAddress);

    /**
     * Gets the value of the smsfAddress property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getSMSFAddress();

    /**
     * Sets the value of the smsfAddress property.
     *
     * @param smsfAddress
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setSMSFAddress(String smsfAddress);

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
     * Gets the value of the ratType property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public abstract Integer getRATtype();

    /**
     * Sets the value of the ratType property.
     *
     * @param ratType
     *     allowed object is
     *     {@link Integer }
     *
     */
    public abstract void setRATtype(Integer ratType);

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
