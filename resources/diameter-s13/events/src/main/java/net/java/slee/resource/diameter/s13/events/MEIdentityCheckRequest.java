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
package net.java.slee.resource.diameter.s13.events;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.VendorSpecificApplicationIdAvp;
import net.java.slee.resource.diameter.s13.events.avp.TerminalInformationAvp;

/**
 * Defines an interface representing the Authentication-Information-Request
 * message. From the Diameter S13 Reference Point Protocol Details (3GPP TS
 * 29.272 V9.6.0) specification:
 *
The ME-Identity-Check-Request (ECR) command, indicated by the Command-Code field set to 324 and the 'R' bit set
in the Command Flags field, is sent from MME or SGSN to EIR.
Message Format
< ME-Identity-Check-Request > ::= < Diameter Header: 324, REQ, PXY, 16777252 >
< Session-Id >
[ Vendor-Specific-Application-Id ]
{ Auth-Session-State }
{ Origin-Host }
{ Origin-Realm }
[ Destination-Host ]
{ Destination-Realm }
{ Terminal-Information }
[ User-Name ]
*[ AVP ]
*[ Proxy-Info ]
*[ Route-Record ]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown
 * </a>
 */
public interface MEIdentityCheckRequest extends DiameterMessage {

    public static final int COMMAND_CODE = 324;

    /**
     * Returns true if the Vendor-Specific-Application-Id AVP is present in the
     * message.
     *
     * @return true if the Vendor-Specific-Application-Id AVP is present in the
     * message, false otherwise
     */
    public boolean hasVendorSpecificApplicationId();

    /**
     * Returns the value of the Vendor-Specific-Application-Id AVP, of type
     * Grouped.
     *
     * @return the value of the Vendor-Specific-Application-Id AVP or null if it
     * has not been set on this message
     */
    public VendorSpecificApplicationIdAvp getVendorSpecificApplicationId();

    /**
     * Sets the value of the Vendor-Specific-Application-Id AVP, of type
     * Grouped.
     *
     * @param vendorSpecificApplicationId the new value for the
     * Vendor-Specific-Application-Id AVP
     */
    public void setVendorSpecificApplicationId(VendorSpecificApplicationIdAvp vendorSpecificApplicationId);

    /**
     * Returns true if the Auth-Session-State AVP is present in the message.
     *
     * @return true if the Auth-Session-State AVP is present in the message,
     * false otherwise
     */
    public boolean hasAuthSessionState();

    /**
     * Returns the value of the Auth-Session-State AVP, of type Enumerated.
     *
     * @return the value of the Auth-Session-State AVP, of type Enumerated
     */
    public AuthSessionStateType getAuthSessionState();

    /**
     * Sets the value of the Auth-Session-State AVP, of type Enumerated.
     *
     * @param authSessionState
     */
    public void setAuthSessionState(AuthSessionStateType authSessionState);

    /**
     * Returns true if the User-Name AVP is present in the message.
     *
     * @return
     */
    public boolean hasUserName();

    /**
     * Returns the value of the User-Name AVP, of type UTF8String.
     *
     * @return
     */
    public String getUserName();

    /**
     * Sets the value of the User-Name AVP, of type UTF8String.
     *
     * @param userName
     */
    public void setUserName(String userName);

    /**
     * Returns true if the Terminal-Information AVP is present in the message.
     *
     * @return true if the Terminal-Information AVP is present in the message,
     * false otherwise
     */
    public boolean hasTerminalInformation();

    /**
     * Returns the value of the Terminal-Information AVP, of type Grouped.
     *
     * @return the value of the Terminal-Information AVP or null if it has not
     * been set on this message
     */
    public TerminalInformationAvp getTerminalInformation();

    /**
     * Sets the value of the Terminal-Information AVP, of type Grouped.
     *
     * @param terminalInformation
     */
    public void setTerminalInformation(TerminalInformationAvp terminalInformation);
}
