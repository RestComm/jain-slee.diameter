package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TShDataExtension7;
import org.w3c.dom.Element;

import java.util.List;

/**
 * <p>Interface for tSh-Data-Extension6 complex type.
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
public interface ShDataExtension6 {

    /**
     * Gets the value of the imeisv property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getIMEISV();

    /**
     * Sets the value of the imeisv property.
     *
     * @param imeisv
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setIMEISV(String imeisv);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TShDataExtension7 }
     *
     */
    public abstract ShDataExtension7 getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param shDataExtension7
     *     allowed object is
     *     {@link TShDataExtension7 }
     *
     */
    public abstract void setExtension(ShDataExtension7 shDataExtension7);

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
