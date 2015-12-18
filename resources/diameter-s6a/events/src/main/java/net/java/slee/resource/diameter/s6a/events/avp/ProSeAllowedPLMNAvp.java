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
 * Defines an interface representing the ProSe-Allowed-PLMN grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.344 V12.3.0) specification:
 * 
 * <pre>
 * 6.3.4 ProSe-Allowed-PLMN
 *
 * The ProSe-Allowed-PLMN AVP is of type Group. It shall contain the PLMN where the UE is authorised to announce
 * or monitor or both for ProSe Discovery or to use ProSe direct communication.
 * AVP format
 *      ProSe-Allowed-PLMN ::= <AVP header: 3703 10415>
 *                          [ Visited-PLMN-Id ]
 *                          [ Authorized-Discovery-Range ]
 *                          [ ProSe-Direct-Allowed ]
 *                          *[AVP]
 *
 * The Authorized-Discovery-Range Information Element should only be present if the Visited-PLMN-Id is the PLMN-Id
 * of the HPLMN; otherwise it should be absent.
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public interface ProSeAllowedPLMNAvp extends GroupedAvp {

    public boolean hasVisitedPLMNId();
    public byte[] getVisitedPLMNId();
    public void setVisitedPLMNId(byte[] visitedPLMNId);

    //FIXME :There is no CODE defined for this
    // public boolean hasAuthorizedDiscoveryRange();
    // public long getAuthorizedDiscoveryRange();
    //public void setAuthorizedDiscoveryRange(long authorizedDiscoveryRange);

    public boolean hasProSeDirectAllowed();
    public long getProSeDirectAllowed();
    public void setProSeDirectAllowed(long proSeDirectAllowed);
}
