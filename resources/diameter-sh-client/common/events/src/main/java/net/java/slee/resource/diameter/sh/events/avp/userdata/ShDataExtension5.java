package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TShDataExtension6;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TTWANLocationInformation;
import org.w3c.dom.Element;

import java.util.List;

/**
 * <p>Interface for tSh-Data-Extension5 complex type.
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
public interface ShDataExtension5 {

    /**
     * Gets the value of the imsi property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getIMSI();

    /**
     * Sets the value of the epsUserState property.
     *
     * @param imsi
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setIMSI(String imsi);

    /**
     * Gets the value of the twanLocationInformation property.
     *
     * @return
     *     possible object is
     *     {@link TTWANLocationInformation }
     *
     */
    public abstract TWANLocationInformation getTWANLocationInformation();

    /**
     * Sets the value of the twanLocationInformation property.
     *
     * @param twanLocationInformation
     *     allowed object is
     *     {@link TTWANLocationInformation }
     *
     */
    public abstract void setTWANLocationInformation(TWANLocationInformation twanLocationInformation);

    /**
     * Gets the value of the imsi property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getIMSPrivateUserIdentity();

    /**
     * Sets the value of the epsUserState property.
     *
     * @param imsPrivateUserIdentity
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setIMSPrivateUserIdentity(String imsPrivateUserIdentity);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TShDataExtension6 }
     *
     */
    public abstract ShDataExtension6 getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param shDataExtension6
     *     allowed object is
     *     {@link TShDataExtension6 }
     *
     */
    public abstract void setExtension(ShDataExtension6 shDataExtension6);

    /**
     * Gets the value of the any property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * {@link Element }
     *
     *
     */
    public abstract List<Object> getAny();
}
