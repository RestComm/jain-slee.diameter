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
 * Defines an interface representing the Authentication-Info grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 *
 * <pre>
 * 7.3.17 Authentication-Info
 *
 *  The Authentication-Info AVP is of type Grouped. This AVP contains Authentication Vectors.
 *
 *  AVP format:
 *  Authentication-Info ::= < AVP header: 1413 10415 >
 *                         *[ E-UTRAN-Vector ]
 *                         *[ UTRAN-Vector ]
 *                         *[ GERAN-Vector ]
 *                         *[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface AuthenticationInfoAvp extends GroupedAvp {

  /*
    7.3.18 E-UTRAN-Vector
    The E-UTRAN-Vector AVP is of type Grouped. This AVP shall contain an E-UTRAN Vector.
    AVP format:
    E-UTRAN-Vector ::= <AVP header: 1414 10415>
                        [ Item-Number ]
                        { RAND }
                        { XRES }
                        { AUTN }
                        { KASME }
                        *[AVP]
   */
  public boolean hasEUTRANVector();
  public void setEUTRANVector(EUTRANVectorAvp EUTRANVector);
  public EUTRANVectorAvp[] getEUTRANVectors();
  public void setEUTRANVectors(EUTRANVectorAvp[] eutranVectors);

  /*
    7.3.19 UTRAN-Vector
    The UTRAN-Vector AVP is of type Grouped. This AVP shall contain an UTRAN Vector.
    AVP format:
    UTRAN-Vector ::= <AVP header: 1415 10415>
                        [ Item-Number ]
                        { RAND }
                        { XRES }
                        { AUTN }
                        { Confidentiality-Key }
                        { Integrity-Key }
                        *[AVP]
   */
  public boolean hasUTRANVector();
  public void setUTRANVector(UTRANVectorAvp utranVector);
  public UTRANVectorAvp[] getUTRANVectors();
  public void setUTRANVectors(UTRANVectorAvp[] utranVectors);

  /*
        7.3.20 GERAN-Vector
        The GERAN-Vector AVP is of type Grouped. This AVP shall contain a GERAN Vector.
        AVP format:
        GERAN-Vector ::= <AVP header: 1416 10415>
                        [ Item-Number ]
                        { RAND }
                        { SRES }
                        { Kc }
                        *[AVP]
  */
  public boolean hasGERANVector();
  public void setGERANVector(GERANVectorAvp geranVector);
  public GERANVectorAvp[] getGERANVectors();
  public void setGERANVectors(GERANVectorAvp[] geranVectors);
}