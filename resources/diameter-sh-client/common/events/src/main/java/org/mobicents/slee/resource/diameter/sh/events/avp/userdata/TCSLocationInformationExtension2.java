package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2;
import net.java.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tCSLocationInformationExtension2 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tCSLocationInformationExtension2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="E-UTRANCellGlobalId" type="{}tE-UTRANCellGlobalId" minOccurs="0"/>
 *          &lt;element name="TrackingAreaId" type="{}tTrackingAreaId" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tCSLocationInformationExtension3" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCSLocationInformationExtension2", propOrder = {
    "eUTRANCellGlobalId",
    "trackingAreaId",
    "extension",
    "any"
})
public class TCSLocationInformationExtension2 implements CSLocationInformationExtension2 {

    @XmlElement(name = "E-UTRANCellGlobalId")
    protected String eUTRANCellGlobalId;
    @XmlElement(name = "TrackingAreaId")
    protected String trackingAreaId;
    @XmlElement(name = "Extension")
    protected TCSLocationInformationExtension3 extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2#getEUTRANCellGlobalId()
     */
    public String getEUTRANCellGlobalId() {
        return eUTRANCellGlobalId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2#setEUTRANCellGlobalId(java.lang.String)
     */
    public void setEUTRANCellGlobalId(String value) {
        this.eUTRANCellGlobalId = value;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2#getTrackingAreaId()
     */
    public String getTrackingAreaId() {
        return trackingAreaId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2#setTrackingAreaId(java.lang.String)
     */
    public void setTrackingAreaId(String value) {
        this.trackingAreaId = value;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2#getExtension()
     */
    public CSLocationInformationExtension3 getExtension() {
        return (CSLocationInformationExtension3) extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension3)
     */
    public void setExtension(CSLocationInformationExtension3 epsLocationInformationExtension) {
        this.extension = (TCSLocationInformationExtension3) epsLocationInformationExtension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
