package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.Extension;
import net.java.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension7;
import net.java.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tSh-Data-Extension7 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tSh-Data-Extension7">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sh-5GSLocationInformation" type="{}tSh-5GSLocationInformation" minOccurs="0"/>
 *         &lt;element name="Sh-5GSUserState" type="{}tPSUserState" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tExtension" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSh-Data-Extension7", propOrder = {
    "sh5GSLocationInformation",
    "sh5GSUserState",
    "extension",
    "any"
})
public class TShDataExtension7 implements ShDataExtension7 {

    @XmlElement(name = "Sh-5GSLocationInformation")
    protected TSh5GSLocationInformation sh5GSLocationInformation;
    @XmlElement(name = "Sh-5GSUserState")
    protected Short sh5GSUserState;
    @XmlElement(name = "Extension")
    protected TExtension extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension7#getSh5GSLocationInformation()
     */
    public Sh5GSLocationInformation getSh5GSLocationInformation() {
        return sh5GSLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension7#setSh5GSLocationInformation(net.java.slee.resource.diameter.sh.events.avp.userdata.Sh5GSLocationInformation)
     */
    public void setSh5GSLocationInformation(Sh5GSLocationInformation sh5GSLocationInformation) {
        this.sh5GSLocationInformation = (TSh5GSLocationInformation) sh5GSLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension7#getSh5GSSUserState()
     */
    public Short getSh5GSSUserState() {
        return sh5GSUserState;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension7#setSh5GSSUserState(java.lang.Short)
     */
    public void setSh5GSSUserState(Short sh5GSSUserState) {
        this.sh5GSUserState = sh5GSSUserState;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension7#getExtension()
     */
    public Extension getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension7#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Extension)
     */
    public void setExtension(Extension value) {
        this.extension = (TExtension) value;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
