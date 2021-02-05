package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TUserCSGInformation;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TCSLocationInformationExtension2;
import org.w3c.dom.Element;

import java.util.List;

/**
 * <p>Interface for tCSLocationInformation-Extension complex type.
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
public interface CSLocationInformationExtension {

    /**
     * Gets the value of the userCSGInformation property.
     *
     * @return
     *     possible object is
     *     {@link TUserCSGInformation }
     *
     */
    public abstract UserCSGInformation getUserCSGInformation();

    /**
     * Sets the value of the userCSGInformation property.
     *
     * @param userCSGInformation
     *     allowed object is
     *     {@link TUserCSGInformation }
     *
     */
    public abstract void setUserCSGInformation(UserCSGInformation userCSGInformation);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TCSLocationInformationExtension2 }
     *
     */
    public abstract CSLocationInformationExtension2 getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param value
     *     allowed object is
     *     {@link TCSLocationInformationExtension2 }
     *
     */
    public abstract void setExtension(CSLocationInformationExtension2 value);

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
