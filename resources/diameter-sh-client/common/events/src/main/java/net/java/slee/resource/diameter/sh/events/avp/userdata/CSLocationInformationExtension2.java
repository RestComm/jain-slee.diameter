package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TCSLocationInformationExtension3;
import org.w3c.dom.Element;

import java.util.List;

/**
 * <p>Interface for tCSLocationInformationExtension2 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tCSLocationInformationExtension2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="E-UTRANCellGlobalId" type="{}tE-UTRANCellGlobalId" minOccurs="0"/>
 *          &lt;element name="TrackingAreaId" type="{}tTrackingAreaId" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tCSLocationInformationExtension3" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface CSLocationInformationExtension2 {

    /**
     * Gets the value of the eUTRANCellGlobalId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getEUTRANCellGlobalId();

    /**
     * Sets the value of the eUTRANCellGlobalId property.
     *
     * @param eUTRANCellGlobalId
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setEUTRANCellGlobalId(String eUTRANCellGlobalId);

    /**
     * Gets the value of the trackingAreaId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public abstract String getTrackingAreaId();

    /**
     * Sets the value of the trackingAreaId property.
     *
     * @param trackingAreaId
     *     allowed object is
     *     {@link String }
     *
     */
    public abstract void setTrackingAreaId(String trackingAreaId);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TCSLocationInformationExtension3 }
     *
     */
    public abstract CSLocationInformationExtension3 getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param value
     *     allowed object is
     *     {@link TCSLocationInformationExtension3 }
     *
     */
    public abstract void setExtension(CSLocationInformationExtension3 value);

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
