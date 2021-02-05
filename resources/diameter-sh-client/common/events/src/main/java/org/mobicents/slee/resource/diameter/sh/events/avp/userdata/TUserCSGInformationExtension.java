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

import net.java.slee.resource.diameter.sh.events.avp.userdata.Extension;
import net.java.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformationExtension;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * <p>Java class for tUserCSGInformation-Extension complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *  <xs:complexType name="tUserCSGInformation-Extension">
 * 		    <xs:sequence>
 * 			    <xs:element name="AccessMode" type="tAccessMode" minOccurs="0"/>
 * 			    <xs:element name="CMI" type="tBool" minOccurs="0"/>
 * 			    <xs:element name="Extension" type="tExtension" minOccurs="0"/>
 * 		    </xs:sequence>
 *  </xs:complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tUserCSGInformationExtension", propOrder = {
    "accessMode",
    "cmi",
    "extension"
})
public class TUserCSGInformationExtension implements UserCSGInformationExtension {

    @XmlElement(name = "AccessMode")
    protected String accessMode;
    @XmlElement(name = "CMI")
    protected Boolean cmi;
    @XmlElement(name = "Extension")
    protected TExtension extension;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformationExtension#getAccessMode()
     */
    public String getAccessMode() {
        return accessMode;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformationExtension#setAccessMode((java.lang.String)
     */
    public void setAccessMode(String accessMode) {
        this.accessMode = accessMode;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformationExtension#getCMI()
     */
    public Boolean getCMI() {
        return cmi;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformationExtension#setCSGId((java.lang.Boolean)
     */
    public void setCMI(Boolean cmi) {
        this.cmi = cmi;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformationExtension#getExtension()
     */
    public Extension getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserCSGInformationExtension#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Extension)
     */
    public void setExtension(Extension extension) {
        this.extension = (TExtension) extension;
    }

}
