package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.TADSInformation;
import net.java.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tTADSinformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tTADSinformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IMSVoiceOverPSSessionSupport" type="{}tIMSVoiceOverPSSessionSupport"/>
 *         &lt;element name="RATtype" type="{}tRATtype" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tTADSinformationExtension" minOccurs="0"/>
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
@XmlType(name = "tTADSinformation", propOrder = {
    "imsVoiceOverPSSessionSupport",
    "ratType",
    "extension",
    "any"
})
public class TTADSInformation implements TADSInformation {

    @XmlElement(name = "IMSVoiceOverPSSessionSupport")
    protected Short imsVoiceOverPSSessionSupport;
    @XmlElement(name = "RATtype")
    protected Integer ratType;
    @XmlElement(name = "Extension")
    protected TTADSInformationExtension extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformation#getIMSVoiceOverPSSessionSupport()
     */
    public Short getIMSVoiceOverPSSessionSupport() {
        return imsVoiceOverPSSessionSupport;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformation#setIMSVoiceOverPSSessionSupport(java.lang.Short)
     */
    public void setIMSVoiceOverPSSessionSupport(Short imsVoiceOverPSSessionSupport) {
        this.imsVoiceOverPSSessionSupport = imsVoiceOverPSSessionSupport;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformation#getRATType()
     */
    public Integer getRATType() {
        return ratType;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformation#setRATType(java.lang.Integer)
     */
    public void setRATType(Integer ratType) {
        this.ratType = ratType;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformation#getExtension()
     */
    public TADSInformationExtension getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformation#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension)
     */
    public void setExtension(TADSInformationExtension tadsInformationExtension) {
        this.extension = (TTADSInformationExtension) tadsInformationExtension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformation#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }
}
