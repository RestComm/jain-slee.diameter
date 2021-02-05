package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension3;
import net.java.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4;
import net.java.slee.resource.diameter.sh.events.avp.userdata.TADSInformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tSh-Data-Extension3 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tSh-Data-Extension3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TADSinformation" type="{}tTADSinformation" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tSh-Data-Extension4" minOccurs="0"/>
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
@XmlType(name = "tSh-Data-Extension3", propOrder = {
    "tadsInformation",
    "extension",
    "any"
})
public class TShDataExtension3 implements ShDataExtension3 {

    @XmlElement(name = "TADSinformation")
    protected TTADSInformation tadsInformation;
    @XmlElement(name = "Extension")
    protected TShDataExtension4 extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension3#getTADSInformation()
     */
    public TADSInformation getTADSInformation() {
         return tadsInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension3#setTADSInformation(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformation)
     */
    public void setTADSInformation(TADSInformation tadsInformation) {
        this.tadsInformation = (TTADSInformation) tadsInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension3#getExtension()
     */
    public ShDataExtension4 getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension3#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4)
     */
    public void setExtension(ShDataExtension4 shDataExtension4) {
        this.extension = (TShDataExtension4) shDataExtension4;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension3#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }
}
