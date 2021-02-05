package net.java.slee.resource.diameter.sh.events.avp.userdata;

import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TUserCSGInformation;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TPSLocationInformationExtension2;

/**
 *
 * <p>Interface for tPSLocationInformation-Extension complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <xs:complexType name="tPSLocationInformation-Extension">
 * 		<xs:sequence>
 * 			<xs:element name="UserCSGInformation" type="tUserCSGInformation" minOccurs="0"/>
 * 			<xs:element name="Extension" type="tPSLocationInformation-Extension2" minOccurs="0"/>
 * 		</xs:sequence>
 * 	</xs:complexType>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface PSLocationInformationExtension {

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
     *     {@link TPSLocationInformationExtension2 }
     *
     */
    public abstract PSLocationInformationExtension2 getExtension();

    /**
     * Sets the value of the extension property.
     *
     * @param value
     *     allowed object is
     *     {@link TPSLocationInformationExtension2 }
     *
     */
    public abstract void setExtension(PSLocationInformationExtension2 value);

}
