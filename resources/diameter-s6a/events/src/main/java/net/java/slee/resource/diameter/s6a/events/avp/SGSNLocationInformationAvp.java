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

package net.java.slee.resource.diameter.s6a.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the MME-Location-Information grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.3.116  SGSN-Location-Information
 * 
 * The SGSN-Location-Information AVP is of type Grouped. It shall contain the information related to the user location relevant for the SGSN. 
 * 
 * AVP format
 * SGSN-Location-Information ::= < AVP header: 1601 10415>
 *                               [ Cell-Global-Identity ]
 *                               [ Location-Area-Identity ]
 *                               [ Service-Area-Identity ]
 *                               [ Routing-Area-Identity ]
 *                               [ Geographical-Information ]
 *                               [ Geodetic-Information ]
 *                               [ Current-Location-Retrieved ]
 *                               [ Age-Of-Location-Information ]
 *                               [ User-CSG-Information ]
 *                              *[ AVP ]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public interface SGSNLocationInformationAvp extends GroupedAvp {

    /**
     * Returns true if the Cell-Global-Identity AVP is present in the message.
     *
     * @return true if the Cell-Global-Identity AVP is present in the message, false otherwise
     */
    public boolean hasCellGlobalIdentity();

    /**
     * Sets the value of the Cell-Global-Identity AVP, of type OctetString.
     *
     * @param eucgi
     */
    public void setCellGlobalIdentity(byte[] eucgi);

    /**
     * Returns the value of the Cell-Global-Identity AVP, of type OctetString.
     * A return value of null implies that the AVP has not been set.
     *
     * @return
     */
    public byte[] getCellGlobalIdentity();

    /**
     * Returns true if the Location-Area-Identity AVP is present in the message.
     *
     * @return true if the Location-Area-Identity AVP is present in the message, false otherwise
     */
    public boolean hasLocationAreaIdentity();

    /**
     * Sets the value of the Location-Area-Identity AVP, of type OctetString.
     *
     * @param lai
     */
    public void setLocationAreaIdentity(byte[] lai);

    /**
     * Returns the value of the Location-Area-Identity AVP, of type OctetString.
     * A return value of null implies that the AVP has not been set.
     *
     * @return
     */
    public byte[] getLocationAreaIdentity();

    /**
     * Returns true if the Service-Area-Identity AVP is present in the message.
     *
     * @return true if the Service-Area-Identity AVP is present in the message, false otherwise
     */
    public boolean hasServiceAreaIdentity();

    /**
     * Sets the value of the Service-Area-Identity AVP, of type OctetString.
     *
     * @param sai
     */
    public void setServiceAreaIdentity(byte[] sai);

    /**
     * Returns the value of the Service-Area-Identity AVP, of type OctetString.
     * A return value of null implies that the AVP has not been set.
     *
     * @return
     */
    public byte[] getServiceAreaIdentity();

    /**
     * Returns true if the Routing-Area-Identity AVP is present in the message.
     *
     * @return true if the Routing-Area-Identity AVP is present in the message, false otherwise
     */
    public boolean hasRoutingAreaIdentity();

    /**
     * Sets the value of the Routing-Area-Identity AVP, of type OctetString.
     *
     * @param rai
     */
    public void setRoutingAreaIdentity(byte[] rai);

    /**
     * Returns the value of the Routing-Area-Identity AVP, of type OctetString.
     * A return value of null implies that the AVP has not been set.
     *
     * @return
     */
    public byte[] getRoutingAreaIdentity();

    /**
     * Returns true if the Geographical-Information AVP is present in the message.
     *
     * @return true if the Geographical-Information AVP is present in the message, false otherwise
     */
    public boolean hasGeographicalInformation();

    /**
     * Sets the value of the Geographical-Information AVP, of type OctetString.
     *
     * @param gi
     */
    public void setGeographicalInformation(byte[] gi);

    /**
     * Returns the value of the Geographical-Information AVP, of type OctetString.
     * A return value of null implies that the AVP has not been set.
     *
     * @return
     */
    public byte[] getGeographicalInformation();

    /**
     * Returns true if the Geodetic-Information AVP is present in the message.
     *
     * @return true if the Geodetic-Information AVP is present in the message, false otherwise
     */
    public boolean hasGeodeticInformation();

    /**
     * Sets the value of the Geodetic-Information AVP, of type OctetString.
     *
     * @param gi
     */
    public void setGeodeticInformation(byte[] gi);

    /**
     * Returns the value of the Geodetic-Information AVP, of type OctetString.
     * A return value of null implies that the AVP has not been set.
     *
     * @return
     */
    public byte[] getGeodeticInformation();

    /**
     * Returns true if the Current-Location-Retrieved AVP is present in the message.
     *
     * @return true if the Current-Location-Retrieved AVP is present in the message, false otherwise
     */
    public boolean hasCurrentLocationRetrieved();

    /**
     * Sets the value of the Current-Location-Retrieved AVP, of type OctetString.
     *
     * @param clr
     */
    public void setCurrentLocationRetrieved(CurrentLocationRetrieved clr);

    /**
     * Returns the value of the Current-Location-Retrieved AVP, of type OctetString.
     * A return value of null implies that the AVP has not been set.
     *
     * @return
     */
    public CurrentLocationRetrieved getCurrentLocationRetrieved();

    /**
     * Returns true if the Age-Of-Location-Information AVP is present in the message.
     *
     * @return true if the Age-Of-Location-Information AVP is present in the message, false otherwise
     */
    public boolean hasAgeOfLocationInformation();

    /**
     * Sets the value of the Age-Of-Location-Information AVP, of type Unsigned32.
     *
     * @param aoli
     */
    public void setAgeOfLocationInformation(long aoli);

    /**
     * Returns the value of the Age-Of-Location-Information AVP, of type Unsigned32.
     * A return value of null implies that the AVP has not been set.
     *
     * @return
     */
    public long getAgeOfLocationInformation();

    /*
       UserCSGINformation
     */
    public boolean hasUserCSGInformation();

    public UserCSGInformationAvp getUserCSGInformation();

    public void setUserCSGInformation(UserCSGInformationAvp userCSGInformation);
}
