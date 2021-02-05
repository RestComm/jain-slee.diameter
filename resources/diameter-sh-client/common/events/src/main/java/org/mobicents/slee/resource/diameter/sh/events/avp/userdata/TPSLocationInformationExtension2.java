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
import net.java.slee.resource.diameter.sh.events.avp.userdata.LocalTimeZone;
import net.java.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for  tPSLocationInformation-Extension2 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *  <xs:complexType name="tPSLocationInformation-Extension2">
 * 		    <xs:sequence>
 * 			    <xs:element name="VisitedPLMNID" type="tVisitedPLMNID" minOccurs="0"/>
 * 			    <xs:element name="LocalTimeZone" type="tLocalTimeZone" minOccurs="0"/>
 * 			    <xs:element name="Extension" type="tExtension" minOccurs="0"/>
 * 			    <xs:element name="RATtype" type="tRATtype" minOccurs="0"/>
 * 		    </xs:sequence>
 *  </xs:complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPSLocationInformationExtension2", propOrder = {
    "visitedPLMNID",
    "localTimeZone",
    "extension",
    "ratType"
})
public class TPSLocationInformationExtension2 implements PSLocationInformationExtension2 {

    @XmlElement(name = "VisitedPLMNID")
    protected Integer visitedPLMNID;
    @XmlElement(name = "LocalTimeZone")
    protected TLocalTimeZone localTimeZone;
    @XmlElement(name = "Extension")
    protected TExtension extension;
    @XmlElement(name = "RATtype")
    protected Integer ratType;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2#getVisitedPLMNID()
     */
    public Integer getVisitedPLMNID() {
        return visitedPLMNID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2#setVisitedPLMNID(java.lang.Integer)
     */
    public void setVisitedPLMNID(Integer visitedPLMNID) {
        this.visitedPLMNID = visitedPLMNID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2#getLocalTimeZone()
     */
    public LocalTimeZone getLocalTimeZone() {
        return (LocalTimeZone) localTimeZone;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2#setLocalTimeZone(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TLocalTimeZone)
     */
    public void setLocalTimeZone(LocalTimeZone localTimeZone) {
        this.localTimeZone = (TLocalTimeZone) localTimeZone;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2#getExtension()
     */
    public Extension getExtension() {
        return extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.Extension)
     */
    public void setExtension(Extension value) {
        this.extension = (TExtension) value;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2#getRATtype()
     */
    public Integer getRATtype() {
        return ratType;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.PSLocationInformationExtension2#setRATtype(java.lang.Integer)
     */
    public void setRATtype(Integer ratType) {
        this.ratType = ratType;
    }

}
