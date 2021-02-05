package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TExtension;

/**
 * <p>Interface for tTADSinformationExtension2 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tTADSinformationExtension2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccessType" type="{}tAccessType" minOccurs="0"/>
 *         &lt;element name="Extension" type="{}tExtension" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface TADSInformationExtension2 {

    /**
     * Gets the value of the lastAccessType property.
     *
     * @return
     *     possible object is
     *     {@link Short }
     *
     */
    public abstract Short getAccessType();

    /**
     * Sets the value of the accessType property.
     *
     * @param accessType
     *     allowed object is
     *     {@link Short }
     *
     */
    public abstract void setAccessType(Short accessType);

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
}
