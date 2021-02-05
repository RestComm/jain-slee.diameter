/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.diameter.sh.events.avp.userdata;

import net.java.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension;
import net.java.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2;
import net.java.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * <p>Java class for  tPSLocationInformation-Extension complex type.
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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPSLocationInformationExtension", propOrder = {
    "userCSGInformation",
    "extension"
})
public class TPSLocationInformationExtension implements PSLocationInformationExtension {

    @XmlElement(name = "UserCSGInformation")
    protected TUserCSGInformation userCSGInformation;
    @XmlElement(name = "Extension")
    protected TPSLocationInformationExtension2 extension;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension#getUserCSGInformation()
     */
    public UserCSGInformation getUserCSGInformation() {
        return (UserCSGInformation) userCSGInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension#setUserCSGInformation(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation)
     */
    public void setUserCSGInformation(UserCSGInformation userCSGInformation) {
        this.userCSGInformation = (TUserCSGInformation) userCSGInformation;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension#getExtension()
     */
    public PSLocationInformationExtension2 getExtension() {
        return (PSLocationInformationExtension2) extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2)
     */
    public void setExtension(PSLocationInformationExtension2 epsLocationInformationExtension) {
        this.extension = (TPSLocationInformationExtension2) epsLocationInformationExtension;
    }

}
