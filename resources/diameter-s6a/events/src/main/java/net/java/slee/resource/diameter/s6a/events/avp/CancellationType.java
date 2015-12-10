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

import java.io.Serializable;
import net.java.slee.resource.diameter.base.events.avp.Enumerated;

/**
 * Java class representing the Cancellation-Type enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 * 7.3.24 Cancellation-Type
 *
 * The Cancellation-Type AVP is of type Enumerated and indicates the type of cancellation. The following values are
 * defined:
 *      MME_UPDATE_PROCEDURE (0)
 *          This value is used when the Cancel Location is sent to the previous MME due to a received Update Location message
 *          from a new MME.
 *      SGSN_UPDATE_PROCEDURE (1)
 *          This value is used when the Cancel Location is sent to the previous SGSN due to a received Update Location message
 *          from a new SGSN.
 *      SUBSCRIPTION_WITHDRAWAL (2)
 *          This value is used:
 *          - when the Cancel Location is sent by the HSS to the current MME or SGSN due to withdrawal of the user"s
 *            subscription by the HSS operator;
 *          - when the Cancel VCSG Location is sent by the CSS to the current MME or SGSN due to withdrawal of the
 *            user"s VPLMN CSG subscription by the CSS operator.
 *      UPDATE_PROCEDURE_IWF (3)
 *          This value is used by an IWF when interworking with a pre-Rel-8 HSS.
 *      INITIAL_ATTACH_PROCEDURE (4)
 *          This value is used when the Cancel Location is sent to the MME or SGSN due to a received Update Location message
 *          during initial attach procedure from an SGSN or MME respectively.
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class CancellationType implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _MME_UPDATE_PROCEDURE     = 0;
  public static final int _SGSN_UPDATE_PROCEDURE    = 1;
  public static final int _SUBSCRIPTION_WITHDRAWAL  = 2;
  public static final int _UPDATE_PROCEDURE_IWF     = 3;
  public static final int _INITIAL_ATTACH_PROCEDURE = 4;

  public static final CancellationType MME_UPDATE_PROCEDURE = new CancellationType(_MME_UPDATE_PROCEDURE);
  public static final CancellationType SGSN_UPDATE_PROCEDURE = new CancellationType(_SGSN_UPDATE_PROCEDURE);
  public static final CancellationType SUBSCRIPTION_WITHDRAWAL = new CancellationType(_SUBSCRIPTION_WITHDRAWAL);
  public static final CancellationType UPDATE_PROCEDURE_IWF = new CancellationType(_UPDATE_PROCEDURE_IWF);
  public static final CancellationType INITIAL_ATTACH_PROCEDURE = new CancellationType(_INITIAL_ATTACH_PROCEDURE);

  private int value = -1;

  private CancellationType(int value) {
    this.value = value;
  }

  public static CancellationType fromInt(int type) {
    switch (type) {
      case _MME_UPDATE_PROCEDURE:
        return MME_UPDATE_PROCEDURE;
      case _SGSN_UPDATE_PROCEDURE:
        return SGSN_UPDATE_PROCEDURE;
      case _SUBSCRIPTION_WITHDRAWAL:
        return SUBSCRIPTION_WITHDRAWAL;
      case _UPDATE_PROCEDURE_IWF:
        return UPDATE_PROCEDURE_IWF;
      case _INITIAL_ATTACH_PROCEDURE:
        return INITIAL_ATTACH_PROCEDURE;
      default:
        throw new IllegalArgumentException("Invalid value: " + type);
    }
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    switch (value) {
      case _MME_UPDATE_PROCEDURE:
        return "MME_UPDATE_PROCEDURE";
      case _SGSN_UPDATE_PROCEDURE:
        return "SGSN_UPDATE_PROCEDURE";
      case _SUBSCRIPTION_WITHDRAWAL:
        return "SUBSCRIPTION_WITHDRAWAL";
      case _UPDATE_PROCEDURE_IWF:
        return "UPDATE_PROCEDURE_IWF";
      case _INITIAL_ATTACH_PROCEDURE:
        return "INITIAL_ATTACH_PROCEDURE";
      default:
        return "<Invalid Value>";
    }
  }

}