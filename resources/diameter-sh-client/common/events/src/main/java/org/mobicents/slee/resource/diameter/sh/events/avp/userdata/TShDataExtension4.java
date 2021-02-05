package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation;
import net.java.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4;
import net.java.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tSh-Data-Extension4 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tSh-Data-Extension4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EPSUserState" type="{}tPSUserState" minOccurs="0"/>
 *         &lt;element name="EPSLocationInformation" type="{}tEPSLocationInformation" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tSh-Data-Extension5" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSh-Data-Extension4", propOrder = {
    "epsUserState",
    "epsLocationInformation",
    "extension",
    "any"
})
public class TShDataExtension4 implements ShDataExtension4 {

    @XmlElement(name = "EPSUserState")
    protected Short epsUserState;
    @XmlElement(name = "EPSLocationInformation")
    protected TEPSLocationInformation epsLocationInformation;
    @XmlElement(name = "Extension")
    protected TShDataExtension5 extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4#getEPSUserState()
     */
    public Short getEPSUserState() {
        return epsUserState;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4#setEPSUserState(java.lang.Short)
     */
    public void setEPSUserState(Short epsUserState) {
        this.epsUserState = epsUserState;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4#getEPSLocationInformation()
     */
    public EPSLocationInformation getEPSLocationInformation() {
        return epsLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4#setEPSLocationInformation(net.java.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformation)
     */
    public void setEPSLocationInformation(EPSLocationInformation epsLocationInformation) {
        this.epsLocationInformation = (TEPSLocationInformation) epsLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4#getExtension()
     */
    public ShDataExtension5 getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5)
     */
    public void setExtension(ShDataExtension5 shDataExtension5) {
        this.extension = (TShDataExtension5) shDataExtension5;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension4#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
