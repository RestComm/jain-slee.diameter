package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.Extension;
import net.java.slee.resource.diameter.sh.events.avp.userdata.LocalTimeZone;
import net.java.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tTWANLocationInformation complex type.
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTWANLocationInformation", propOrder = {
    "twanSsid",
    "twanBssid",
    "twanPlmnId",
    "civicAddress",
    "twanOperatorName",
    "localTimeZone",
    "logicalAccessID",
    "extension",
    "any"
})
public class TTWANLocationInformation implements TWANLocationInformation {

    @XmlElement(name = "TWAN-SSID")
    protected String twanSsid;
    @XmlElement(name = "TWAN-BSSID")
    protected String twanBssid;
    @XmlElement(name = "TWAN-PLMNID")
    protected Integer twanPlmnId;
    @XmlElement(name = "CivicAddress")
    protected byte[] civicAddress;
    @XmlElement(name = "TWANOperatorName")
    protected String twanOperatorName;
    @XmlElement(name = "LocalTimeZone")
    protected TLocalTimeZone localTimeZone;
    @XmlElement(name = "LogicalAccessID")
    protected String logicalAccessID;
    @XmlElement(name = "Extension")
    protected TExtension extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#getTwanSsid()
     */
    public String getTwanSsid() {
        return twanSsid;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#setTwanSsid(java.lang.String)
     */
    public void setTwanSsid(String twanSSID) {
        this.twanSsid = twanSSID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#getTwanBssid()
     */
    public String getTwanBssid() {
        return twanBssid;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#setTwanBssid(java.lang.String)
     */
    public void setTwanBssid(String twanBSSID) {
        this.twanBssid = twanBSSID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#getTwanPlmnId()
     */
    public Integer getTwanPlmnId() {
        return twanPlmnId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#setTwanPlmnId(java.lang.Integer)
     */
    public void setTwanPlmnId(Integer twanPlmnId) {
        this.twanPlmnId = twanPlmnId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#getCivicAddress()
     */
    public byte[] getCivicAddress() {
        return civicAddress;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#setCivicAddress(java.lang.byte[])
     */
    public void setCivicAddress(byte[] twanPlmnId) {
        this.civicAddress = twanPlmnId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#getTwanOperatorName()
     */
    public String getTwanOperatorName() {
        return twanOperatorName;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#setTwanOperatorName(java.lang.String)
     */
    public void setTwanOperatorName(String twanOperatorName) {
        this.twanOperatorName = twanOperatorName;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#getLocalTimeZone()
     */
    public LocalTimeZone getLocalTimeZone() {
        return localTimeZone;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#setLocalTimeZone(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TLocalTimeZone)
     */
    public void setLocalTimeZone(LocalTimeZone localTimeZone) {
        this.localTimeZone = (TLocalTimeZone) localTimeZone;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#getLogicalAccessID()
     */
    public String getLogicalAccessID() {
        return logicalAccessID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#setLogicalAccessID(java.lang.String)
     */
    public void setLogicalAccessID(String logicalAccessID) {
        this.logicalAccessID = logicalAccessID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#getExtension()
     */
    public Extension getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Extension)
     */
    public void setExtension(Extension value) {
        this.extension = (TExtension) value;
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
