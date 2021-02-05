package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TTADSInformationExtension2;

import java.util.Calendar;

/**
 * <p>Interface for tTADSinformation complex type.
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
public interface TADSInformationExtension {

    /**
     * Gets the value of the lastUEActivityTime property.
     *
     * @return
     *     possible object is
     *     {@link Calendar }
     *
     */
    public abstract Calendar getLastUEActivityTime();

    /**
     * Sets the value of the lastUEActivityTime property.
     *
     * @param lastUEActivityTime
     *     allowed object is
     *     {@link Calendar }
     *
     */
    public abstract void setLastUEActivityTime(Calendar lastUEActivityTime);

    /**
     * Gets the value of the extension property.
     *
     * @return
     *     possible object is
     *     {@link TTADSInformationExtension2 }
     *
     */
    public abstract TADSInformationExtension2 getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param tadsInformationExtension2
     *     allowed object is
     *     {@link TTADSInformationExtension2 }
     *
     */
    public abstract void setExtension(TADSInformationExtension2 tadsInformationExtension2);


}
