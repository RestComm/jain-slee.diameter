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

import net.java.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation;
import net.java.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformationExtension;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for tUserCSGInformation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *  <xs:complexType name="tUserCSGInformation">
 * 		<xs:sequence>
 * 			<xs:element name="CSGId" type="tCSGId" minOccurs="0" maxOccurs="unbounded"/>
 * 			<xs:element name="Extension" type="tUserCSGInformation-Extension" minOccurs="0"/>
 * 		</xs:sequence>
 * 	</xs:complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tUserCSGInformation", propOrder = {
    "csgId",
    "extension"
})
public class TUserCSGInformation implements UserCSGInformation {

    @XmlElement(name = "CSGId")
    protected String csgId;
    @XmlElement(name = "Extension")
    protected TUserCSGInformationExtension extension;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation#getCSGId()
     */
    public String getCSGId() {
        return csgId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation#setCSGId((java.lang.String)
     */
    public void setCSGId(String csgId) {
        this.csgId = csgId;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation#getExtension()
     */
    public UserCSGInformationExtension getExtension() {
        return (UserCSGInformationExtension) extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformation#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformationExtension)
     */
    public void setExtension(UserCSGInformationExtension userCSGInformationExtension) {
        this.extension = (TUserCSGInformationExtension) userCSGInformationExtension;
    }

}
