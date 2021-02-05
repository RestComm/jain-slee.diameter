package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TExtension;
import org.w3c.dom.Element;

import java.util.List;

/**
 * <p>Interface for tTWANLocationInformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *  &lt;xs:complexType name="tTWANLocationInformation">
 * 		&lt;xs:sequence>
 * 			&lt;xs:element name="TWAN-SSID" type="tTWAN-SSID" minOccurs="0"/>
 * 			&lt;xs:element name="TWAN-BSSID" type="tTWAN-BSSID" minOccurs="0"/>
 * 			&lt;xs:element name="TWAN-PLMNID" type="tVisitedPLMNID" minOccurs="0"/>
 * 			&lt;xs:element name="CivicAddress" type="tCivicAddress" minOccurs="0" maxOccurs="unbounded"/>
 * 			&lt;xs:element name="TWANOperatorName" type="tTWANOperatorName" minOccurs="0"/>
 * 			&lt;xs:element name="LocalTimeZone" type="tLocalTimeZone" minOccurs="0"/>
 * 			&lt;xs:element name="LogicalAccessID" type="tLogicalAccessID" minOccurs="0"/>
 * 			&lt;xs:element name="Extension" type="tExtension" minOccurs="0"/>
 * 			&lt;xs:any namespace="##other" processContents="lax" minOccurs="0" maxOccurs="unbounded"/>
 * 		&lt;/xs:sequence>
 * 	&lt;/xs:complexType>
 * </pre>
 *
 * 	@author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface TWANLocationInformation {

    /**
     * Gets the value of the twanSsid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getTwanSsid();

    /**
     * Sets the value of the twanSsid property.
     *
     * @param twanSsid
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setTwanSsid(String twanSsid);

    /**
     * Gets the value of the twanBssid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getTwanBssid();

    /**
     * Sets the value of the twanBssid property.
     *
     * @param twanBssid
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setTwanBssid(String twanBssid);

    /**
     * Gets the value of the twanPlmnInd property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public abstract Integer getTwanPlmnId();

    /**
     * Sets the value of the twanPlmnInd property.
     *
     * @param twanPlmnInd
     *     allowed object is
     *     {@link Integer }
     *
     */
    public abstract void setTwanPlmnId(Integer twanPlmnInd);

    /**
     * Gets the value of the civicAddress property.
     *
     * @return
     *     possible object is
     *     {@link Byte }
     *
     */
    public abstract byte[] getCivicAddress();

    /**
     * Sets the value of the civicAddress property.
     *
     * @param civicAddress
     *     allowed object is
     *     {@link Byte }
     *
     */
    public abstract void setCivicAddress(byte[] civicAddress);

    /**
     * Gets the value of the twanOperatorName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getTwanOperatorName();

    /**
     * Sets the value of the twanOperatorName property.
     *
     * @param twanOperatorName
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setTwanOperatorName(String twanOperatorName);

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
     * Gets the value of the logicalAccessID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getLogicalAccessID();

    /**
     * Sets the value of the logicalAccessID property.
     *
     * @param logicalAccessID
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setLogicalAccessID(String logicalAccessID);

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
     * @param extension
     *     allowed object is
     *     {@link TExtension }
     *
     */
    public abstract void setExtension(Extension extension);

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
