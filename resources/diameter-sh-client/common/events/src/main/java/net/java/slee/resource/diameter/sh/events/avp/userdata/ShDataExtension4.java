package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TEPSLocationInformation;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TShDataExtension5;
import org.w3c.dom.Element;

import java.util.List;

/**
 * <p>Interface for tSh-Data-Extension4 complex type.
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
public interface ShDataExtension4 {

    /**
     * Gets the value of the epsUserState property.
     *
     * @return
     *     possible object is
     *     {@link Short }
     *
     */
    public abstract Short getEPSUserState();

    /**
     * Sets the value of the epsUserState property.
     *
     * @param epsUserState
     *     allowed object is
     *     {@link Short }
     *
     */
    public abstract void setEPSUserState(Short epsUserState);

    /**
     * Gets the value of the epsUserState property.
     *
     * @return
     *     possible object is
     *     {@link TEPSLocationInformation }
     *
     */
    public abstract EPSLocationInformation getEPSLocationInformation();

    /**
     * Sets the value of the epsLocationInformation property.
     *
     * @param epsLocationInformation
     *     allowed object is
     *     {@link TEPSLocationInformation }
     *
     */
    public abstract void setEPSLocationInformation(EPSLocationInformation epsLocationInformation);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TShDataExtension5 }
     *
     */
    public abstract ShDataExtension5 getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param shDataExtension5
     *     allowed object is
     *     {@link TShDataExtension5 }
     *
     */
    public abstract void setExtension(ShDataExtension5 shDataExtension5);

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
