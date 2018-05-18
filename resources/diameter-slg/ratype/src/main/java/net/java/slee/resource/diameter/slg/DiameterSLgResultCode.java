/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2018, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */

package net.java.slee.resource.diameter.slg;

/**
 * Diameter SLg Result Codes
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class DiameterSLgResultCode {

  // ** Permanent Failures category ** //

  /**
   * 3GPP TS 29.172 v14.1.0
   * 7.5.3.1	DIAMETER_ERROR_USER_UNKNOWN (5001)
   * This result code shall be sent by the MME/SGSN to indicate that the user is unknown.
   * This error code is defined in 3GPP TS 29.229 [17]
   */
  public static final int DIAMETER_ERROR_USER_UNKNOWN = 5001;

  /**
   * 3GPP TS 29.172 v14.1.0
   * 7.5.3.2	DIAMETER_ERROR_UNAUTHORIZED_REQUESTING_NETWORK (5490)
   * This result code shall be sent by the MME/SGSN to indicate that the requesting GMLC's network is not authorized to request UE location information.
   * This error code is defined in 3GPP TS 29.173 [18]
   */
  public static final int DIAMETER_ERROR_UNAUTHORIZED_REQUESTING_NETWORK = 5490;


  // ** Transient Failures category ** //

  /**
   * 3GPP TS 29.172 v14.1.0
   * 7.5.4.1	DIAMETER_ERROR_UNREACHABLE_USER (4221)
   * This result code shall be sent by the MME/SGSN to indicate that the user could not be reached in order to perform positioning procedure.
   */
  public static final int DIAMETER_ERROR_UNREACHABLE_USER = 4221;

  /**
   * 3GPP TS 29.172 v14.1.0
   * 7.5.4.2	DIAMETER_ERROR_SUSPENDED_USER (4222)
   * This result code shall be sent by the MME/SGSN to indicate that the user is suspended in the MME.
   */
  public static final int DIAMETER_ERROR_SUSPENDED_USER = 4222;

  /**
   * 3GPP TS 29.172 v14.1.0
   * 7.5.4.3	DIAMETER_ERROR_DETACHED_USER (4223)
   * This result code shall be sent by the MME/SGSN to indicate that the user is detached in the MME.
   */
  public static final int DIAMETER_ERROR_DETACHED_USER = 4223;

  /**
   * 3GPP TS 29.172 v14.1.0
   * 7.5.4.4	DIAMETER_ERROR_POSITIONING_DENIED (4224)
   * This result code shall be sent by the MME/SGSN to indicate that the positioning procedure was denied.
   */
  public static final int DIAMETER_ERROR_POSITIONING_DENIED = 4224;

  /**
   * 3GPP TS 29.172 v14.1.0
   * 7.5.4.5	DIAMETER_ERROR_POSITIONING_FAILED (4225)
   * This result code shall be sent by the MME/SGSN to indicate that the positioning procedure failed.
   */
  public static final int DIAMETER_ERROR_POSITIONING_FAILED = 4225;

  /**
   * 3GPP TS 29.172 v14.1.0
   * 7.5.4.6	DIAMETER_ERROR_UNKNOWN_UNREACHABLE_LCS_CLIENT (4226)
   * This result code shall be sent by the GMLC to indicate that the LCS Client was not known or could not be reached.
   */
  public static final int DIAMETER_ERROR_UNKNOWN_UNREACHABLE_LCS_CLIENT = 4226;

}
