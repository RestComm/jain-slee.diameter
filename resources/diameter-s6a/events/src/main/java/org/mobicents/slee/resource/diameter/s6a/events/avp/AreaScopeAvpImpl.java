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

package org.mobicents.slee.resource.diameter.s6a.events.avp;

import net.java.slee.resource.diameter.s6a.events.avp.AreaScopeAvp;
import net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes;
import net.java.slee.resource.diameter.s6a.events.avp.WLANoffloadabilityAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.WLANoffloadabilityAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class AreaScopeAvpImpl extends GroupedAvpImpl implements AreaScopeAvp {

    public AreaScopeAvpImpl() {
        super();
    }

    public AreaScopeAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }


    public boolean hasCellGlobalIdentity() {
        return hasAvp(DiameterS6aAvpCodes.CELL_GLOBAL_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setCellGlobalIdentity(byte[] cellGlobalIdentity) {
        addAvp(DiameterS6aAvpCodes.CELL_GLOBAL_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, cellGlobalIdentity);
    }

    public void setCellGlobalIdentities(byte[][] cellGlobalIdentities){
        for (byte[] aux : cellGlobalIdentities){
            setCellGlobalIdentity(aux);
        }
    }

    public byte[][] getCellGlobalIdentities(){
        return getAvpsAsOctetString(DiameterS6aAvpCodes.CELL_GLOBAL_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public boolean hasEUTRANCellGlobalIdentity() {
        return hasAvp(DiameterS6aAvpCodes.E_UTRAN_CELL_GLOBAL_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setEUTRANCellGlobalIdentity(byte[] eutranCellGlobalIdentity) {
        addAvp(DiameterS6aAvpCodes.E_UTRAN_CELL_GLOBAL_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, eutranCellGlobalIdentity);
    }

    public byte[][] getEUTRANCellGlobalIdentities(){
        return getAvpsAsOctetString(DiameterS6aAvpCodes.E_UTRAN_CELL_GLOBAL_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setEUTRANCellGlobalIdentities(byte[][] eutranCellGlobalIdentities){
        for (byte[] aux : eutranCellGlobalIdentities){
            setEUTRANCellGlobalIdentity(aux);
        }
    }

    public boolean hasRoutingAreaIdentity() {
        return hasAvp(DiameterS6aAvpCodes.ROUTING_AREA_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setRoutingAreaIdentity(byte[] routingAreaIdentity) {
        addAvp(DiameterS6aAvpCodes.ROUTING_AREA_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, routingAreaIdentity);
    }

    public byte[][] getRoutingAreaIdentities(){
        return getAvpsAsOctetString(DiameterS6aAvpCodes.ROUTING_AREA_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setRoutingAreaIdentities(byte[][] routingAreaIdentities){
        for (byte[] aux : routingAreaIdentities){
            setRoutingAreaIdentity(aux);
        }
    }

    public boolean hasLocationAreaIdentity() {
        return hasAvp(DiameterS6aAvpCodes.LOCATION_AREA_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setLocationAreaIdentity(byte[] locationAreaIdentity) {
        addAvp(DiameterS6aAvpCodes.LOCATION_AREA_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, locationAreaIdentity);
    }

    public byte[][] getLocationAreaIdentities(){
        return getAvpsAsOctetString(DiameterS6aAvpCodes.LOCATION_AREA_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setLocationAreaIdentities(byte[][] locationAreaIdentities){
        for (byte[] aux: locationAreaIdentities){
            setLocationAreaIdentity(aux);
        }
    }

    public boolean hasTrackingAreaIdentity() {
        return hasAvp(DiameterS6aAvpCodes.TRACKING_AREA_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setTrackingAreaIdentity(byte[] trackingAreaIdentity) {
        addAvp(DiameterS6aAvpCodes.TRACKING_AREA_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID, trackingAreaIdentity);
    }

    public byte[][] getTrackingAreaIdentities(){
        return getAvpsAsOctetString(DiameterS6aAvpCodes.TRACKING_AREA_IDENTITY, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setTrackingAreaIdentities(byte[][] trackingAreaIdentities){
        for (byte[] aux : trackingAreaIdentities){
            setTrackingAreaIdentity(aux);
        }
    }
}