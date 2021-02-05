package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension;
import net.java.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2;
import net.java.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tCSLocationInformation-Extension complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tCSLocationInformation-Extension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserCSGInformation" type="{}tUserCSGInformation" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tCSLocationInformationExtension2" minOccurs="0"/>
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
@XmlType(name = "tCSLocationInformation-Extension", propOrder = {
    "userCSGInformation",
    "extension",
    "any"
})
public class TCSLocationInformationExtension implements CSLocationInformationExtension {

    @XmlElement(name = "UserCSGInformation")
    protected TUserCSGInformation userCSGInformation;
    @XmlElement(name = "Extension")
    protected TCSLocationInformationExtension2 extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension#getUserCSGInformation()
     */
    public UserCSGInformation getUserCSGInformation() {
        return (UserCSGInformation) userCSGInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension#setUserCSGInformation(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation)
     */
    public void setUserCSGInformation(UserCSGInformation userCSGInformation) {
        this.userCSGInformation = (TUserCSGInformation) userCSGInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension#getExtension()
     */
    public CSLocationInformationExtension2 getExtension() {
        return (CSLocationInformationExtension2) extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension2)
     */
    public void setExtension(CSLocationInformationExtension2 csLocationInformationExtension) {
        this.extension = (TCSLocationInformationExtension2) csLocationInformationExtension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.CSLocationInformationExtension#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }
}
