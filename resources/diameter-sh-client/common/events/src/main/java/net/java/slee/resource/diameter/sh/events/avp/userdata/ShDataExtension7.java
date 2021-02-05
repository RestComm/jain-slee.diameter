package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TExtension;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TSh5GSLocationInformation;
import org.w3c.dom.Element;

import java.util.List;

/**
 * <p>Interface for tSh-Data-Extension7 complex type.
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
public interface ShDataExtension7 {

    /**
     * Gets the value of the twanLocationInformation property.
     *
     * @return
     *     possible object is
     *     {@link TSh5GSLocationInformation }
     *
     */
    public abstract Sh5GSLocationInformation getSh5GSLocationInformation();

    /**
     * Sets the value of the twanLocationInformation property.
     *
     * @param sh5GSLocationInformation
     *     allowed object is
     *     {@link TSh5GSLocationInformation }
     *
     */
    public abstract void setSh5GSLocationInformation(Sh5GSLocationInformation sh5GSLocationInformation);

    /**
     * Gets the value of the sh5GSSUserState property.
     *
     * @return
     *     possible object is
     *     {@link Short }
     *
     */
    public abstract Short getSh5GSSUserState();

    /**
     * Sets the value of the psUserState property.
     *
     * @param sh5GSSUserState
     *     allowed object is
     *     {@link Short }
     *
     */
    public abstract void setSh5GSSUserState(Short sh5GSSUserState);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TExtension }
     *
     */
    public abstract Extension getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param extension
     *     allowed object is
     *     {@link TExtension }
     *
     */
    public abstract void setExtension(Extension extension);

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
