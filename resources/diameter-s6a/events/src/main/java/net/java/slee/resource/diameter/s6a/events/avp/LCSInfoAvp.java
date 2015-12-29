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
 * Defines an interface representing the LCS-Info grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.84 LCS-Info
 *
 * The LCS-Info AVP is of type Grouped. This AVP shall contain the following LCS related information for a subscriber:
 *  - list of GMLCs in the HPLMN that are permitted to issue a call/session unrelated or call/session related MT-LR
 *    location request for this UE;
 *  - privacy exception list that is applicable only over the S6d interface;
 *  - MO-LR list
 *
 * AVP format
 *    LCS-Info ::= <AVP header: 1473 10415>
 *                 *[ GMLC-Number]
 *                 *[ LCS-PrivacyException ]
 *                 *[ MO-LR ]
 *                 *[AVP]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 * @author <a href="mailto:oscar.perez@gmail.com"> Oscar Perez Lozano </a>
 */
public interface LCSInfoAvp extends GroupedAvp {

  /*
    7.3.85 GMLC-Number
    The GMLC-Number AVP is of type OctetString. This AVP shall contain the ISDN number of the GMLC. For further
    details on the encoding of this AVP, see 3GPP TS 23.003[3].
  */

    public boolean hasGMLCNumber();
    public void setGMLCNumber(byte[] gmlcNumber);
    public byte[][] getGMLCNumbers();
    public void setGMLCNumbers(byte[][] gmlcNumbers);

    /*
      7.3.86 LCS-PrivacyException
      The LCS-PrivacyException AVP is of type Grouped. This AVP shall contain the classes of LCS Client that are allowed
      to locate any target UE.
      AVP format
      LCS-PrivacyException ::= <AVP header: 1475 10415>
                               { SS-Code }
                               { SS-Status }
                               [ Notification-To-UE-User ]
                               *[ External-Client ]
                               *[ PLMN-Client ]
                               *[ Service-Type ]
                               *[AVP]
     */
    public boolean hasLCSPrivacyException();
    public void setLCSPrivacyException(LCSPrivacyExceptionAvp lcsPrivacyException);
    public LCSPrivacyExceptionAvp[] getLCSPrivacyExceptions();
    public void setLCSPrivacyExceptions(LCSPrivacyExceptionAvp[] lcsPrivacyExceptionAvps);

    /*
      7.3.96 MO-LR
      The MO-LR AVP is of type Grouped. This AVP shall contain the classes of MO-LR for which a subscription exists for
      a particular UE.
      AVP format
            MO-LR ::= <AVP header: 1485 10415>
                      { SS-Code }
                      { SS-Status }
                      *[AVP]
     */
    public boolean hasMOLR();
    public void setMOLR(MOLRAvp molrAvp);
    public MOLRAvp[] getMOLRs();
    public void setMOLRs(MOLRAvp[] molrs);
}