package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension;
import net.java.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * <p>Java class for tTADSinformationExtension complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tTADSinformationExtension">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LastUEActivityTime" type="{}tDateTime" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tTADSinformationExtension2" minOccurs="0"/>
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
@XmlType(name = "tTADSinformationExtension", propOrder = {
    "lastUEActivityTime",
    "extension",
    "any"
})
public class TTADSInformationExtension implements TADSInformationExtension {

    @XmlElement(name = "LastUEActivityTime")
    protected Calendar lastUEActivityTime;
    @XmlElement(name = "Extension")
    protected TTADSInformationExtension2 extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension#getLastUEActivityTime()
     */
    public Calendar getLastUEActivityTime() {
        return lastUEActivityTime;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension#setLastUEActivityTime(java.lang.Calendar)
     */
    public void setLastUEActivityTime(Calendar lastUEActivityTime) {
        this.lastUEActivityTime = lastUEActivityTime;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension#getExtension()
     */
    public TADSInformationExtension2 getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension2)
     */
    public void setExtension(TADSInformationExtension2 tadsInformationExtension2) {
        this.extension = (TTADSInformationExtension2) tadsInformationExtension2;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TADSInformationExtension#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }
}
