package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension6;
import net.java.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tSh-Data-Extension6 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tSh-Data-Extension6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IMEISV" type="{}tString" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tSh-Data-Extension7" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSh-Data-Extension6", propOrder = {
    "imeisv",
    "extension",
    "any"
})
public class TShDataExtension6 implements ShDataExtension6 {

    @XmlElement(name = "IMEISV")
    protected String imeisv;
    @XmlElement(name = "Extension")
    protected TShDataExtension7 extension;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension6#getIMEISV()
     */
    public String getIMEISV() {
        return imeisv;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension6#setIMEISV(java.lang.String)
     */
    public void setIMEISV(String imeisv) {
        this.imeisv = imeisv;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension6#getExtension()
     */
    public ShDataExtension7 getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension6#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension7)
     */
    public void setExtension(ShDataExtension7 shDataExtension7) {
        this.extension = (TShDataExtension7) shDataExtension7;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ShDataExtension6#getAny()
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}
