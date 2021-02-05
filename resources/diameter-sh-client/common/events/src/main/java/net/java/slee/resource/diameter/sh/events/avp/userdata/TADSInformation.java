package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TTADSInformationExtension;
import org.w3c.dom.Element;

import java.util.List;

/**
 * <p>Interface for tTADSinformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tTADSinformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IMSVoiceOverPSSessionSupport" type="{}tIMSVoiceOverPSSessionSupport"/>
 *         &lt;element name="RATtype" type="{}tRATtype" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tTADSinformationExtension" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface TADSInformation {

    /**
     * Gets the value of the imsVoiceOverPSSessionSupport property.
     *
     * @return
     *     possible object is
     *     {@link Short }
     *
     */
    public abstract Short getIMSVoiceOverPSSessionSupport();

    /**
     * Sets the value of the imsVoiceOverPSSessionSupport property.
     *
     * @param imsVoiceOverPSSessionSupport
     *     allowed object is
     *     {@link Short }
     *
     */
    public abstract void setIMSVoiceOverPSSessionSupport(Short imsVoiceOverPSSessionSupport);

    /**
     * Gets the value of the ratType property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public abstract Integer getRATType();

    /**
     * Sets the value of the ratType property.
     *
     * @param ratType
     *     allowed object is
     *     {@link Integer }
     *
     */
    public abstract void setRATType(Integer ratType);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TTADSInformationExtension }
     *
     */
    public abstract TADSInformationExtension getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param value
     *     allowed object is
     *     {@link TTADSInformationExtension }
     *
     */
    public abstract void setExtension(TADSInformationExtension value);

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
