package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5;
import net.java.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension6;
import net.java.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tSh-Data-Extension5 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tSh-Data-Extension5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IMSI" type="{}tIMSI" minOccurs="0"/>
 *         &lt;element name="TWANLocationInformation" type="{}tTWANLocationInformation" minOccurs="0"/>
 *         &lt;element name="IMSPrivateUserIdentity" type="{}tIMSPrivateUserIdentity" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tSh-Data-Extension6" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSh-Data-Extension5", propOrder = {
    "imsi",
    "twanLocationInformation",
    "imsPrivateUserIdentity",
    "extension",
    "any"
})
public class TShDataExtension5 implements ShDataExtension5 {

    @XmlElement(name = "IMSI")
    protected String imsi;
    @XmlElement(name = "TWANLocationInformation")
    protected TTWANLocationInformation twanLocationInformation;
    @XmlElement(name = "IMSPrivateUserIdentity")
    protected String imsPrivateUserIdentity;
    @XmlElement(name = "Extension")
    protected TShDataExtension6 extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5#getIMSI()
     */
    public String getIMSI() {
        return imsi;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5#setEPSUserState(java.lang.String)
     */
    public void setIMSI(String imsi) {
        this.imsi = imsi;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5#getTWANLocationInformation()
     */
    public TWANLocationInformation getTWANLocationInformation() {
        return twanLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5#setTWANLocationInformation(net.java.slee.resource.diameter.sh.events.avp.userdata.TWANLocationInformation)
     */
    public void setTWANLocationInformation(TWANLocationInformation twanLocationInformation) {
        this.twanLocationInformation = (TTWANLocationInformation) twanLocationInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5#getIMSPrivateUserIdentity()
     */
    public String getIMSPrivateUserIdentity() {
        return imsPrivateUserIdentity;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5#setIMSPrivateUserIdentity(java.lang.String)
     */
    public void setIMSPrivateUserIdentity(String imsPrivateUserIdentity) {
        this.imsPrivateUserIdentity = imsPrivateUserIdentity;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5#getExtension()
     */
    public ShDataExtension6 getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension5#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension6)
     */
    public void setExtension(ShDataExtension6 shDataExtension6) {
        this.extension = (TShDataExtension6) shDataExtension6;
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
