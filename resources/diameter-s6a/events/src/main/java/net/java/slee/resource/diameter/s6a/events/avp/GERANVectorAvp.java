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
 * Defines an interface representing the GERAN-Vector grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 *   7.3.20 GERAN-Vector
 *   The GERAN-Vector AVP is of type Grouped. This AVP shall contain a GERAN Vector.
 *   AVP format:
 *      GERAN-Vector ::= <AVP header: 1416 10415>
 *                      [ Item-Number ]
 *                      { RAND }
 *                      { SRES }
 *                      { Kc }
 *                      *[AVP]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface GERANVectorAvp extends GroupedAvp {

  /*
     7.3.23 Item-Number
     The Item-Number AVP is of type Unsigned32. The Item Number is used to order Vectors received within one request.
  */
  public long getItemNumber();
  public void setItemNumber(long itemNumber);
  public boolean hasItemNumber();

  /*
     7.3.53 RAND
    The RAND AVP is of type OctetString. This AVP shall contain the RAND. See 3GPP TS 33.401 [5].
  */
  public boolean hasRAND();
  public byte[] getRAND();
  public void setRAND(byte[] rand);

  /*
    7.3.60 SRES
    The SRES AVP is of type OctetString. This AVP shall contain the SRES. See 3GPP TS 33.102 [18].
   */
  public boolean hasSRES();
  public byte[] getSRES();
  public void setSRES(byte[] sres);

  /*
    7.3.59 Kc AVP
    The Kc-Key is of type OctetString, and shall contain the Ciphering Key (Kc).
  */
  public boolean hasKc();
  public byte[] getKc();
  public void setKc(byte[] kc);
}