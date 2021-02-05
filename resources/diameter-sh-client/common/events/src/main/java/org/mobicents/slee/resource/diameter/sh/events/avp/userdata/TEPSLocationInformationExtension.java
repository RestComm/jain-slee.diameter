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

import net.java.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension;
import net.java.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension2;
import net.java.slee.resource.diameter.sh.events.avp.userdata.LocalTimeZone;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for tEPSLocationInformation-Extension complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 *  <xs:complexType name="tEPSLocationInformation-Extension">
 * 		<xs:sequence>
 * 			<xs:element name="VisitedPLMNID" type="tVisitedPLMNID" minOccurs="0"/>
 * 			<xs:element name="LocalTimeZone" type="tLocalTimeZone" minOccurs="0"/>
 * 			<xs:element name="Extension" type="tEPSLocationInformation-Extension2" minOccurs="0"/>
 * 		</xs:sequence>
 * 	</xs:complexType>
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEPSLocationInformationExtension", propOrder = {
    "visitedPLMNID",
    "localTimeZone",
    "extension"
})
public class TEPSLocationInformationExtension implements EPSLocationInformationExtension {

    @XmlElement(name = "VisitedPLMNID")
    protected Integer visitedPLMNID;
    @XmlElement(name = "LocalTimeZone")
    protected TLocalTimeZone localTimeZone;
    @XmlElement(name = "Extension")
    protected TEPSLocationInformationExtension2 extension;

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension#getVisitedPLMNID()
     */
    public Integer getVisitedPLMNID() {
        return visitedPLMNID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension#setVisitedPLMNID(java.lang.Integer)
     */
    public void setVisitedPLMNID(Integer visitedPLMNID) {
        this.visitedPLMNID = visitedPLMNID;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension#getLocalTimeZone()
     */
    public LocalTimeZone getLocalTimeZone() {
        return (LocalTimeZone) localTimeZone;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension#setLocalTimeZone(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TLocalTimeZone)
     */
    public void setLocalTimeZone(LocalTimeZone localTimeZone) {
        this.localTimeZone = (TLocalTimeZone) localTimeZone;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension#getExtension()
     */
    public EPSLocationInformationExtension2 getExtension() {
        return (EPSLocationInformationExtension2) extension;
    }

    /* (non-Javadoc)
     * @see org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension#setExtension(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.EPSLocationInformationExtension2)
     */
    public void setExtension(EPSLocationInformationExtension2 epsLocationInformationExtension2) {
        this.extension = (TEPSLocationInformationExtension2) epsLocationInformationExtension2;
    }

}
