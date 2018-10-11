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

package net.java.slee.resource.diameter.slh.events.avp;

/*
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */

public class LCSRoutingInfoAVPCodes {

  private LCSRoutingInfoAVPCodes() {

  }

  public static final long SLh_VENDOR_ID = 10415L;
  public static final long SLh_AUTH_APP_ID = 16777291L;

  /**
   * <pre>
   * Name......: LMSI
   * Code......: 2400
   * Section...: 6.4.2
   * Type......: OctetString
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LMSI = 2400;

  /**
   * <pre>
   * Name......: Serving-Node
   * Code......: 2401
   * Section...: 6.4.3
   * Type......: Grouped
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int SERVING_NODE = 2401;

  /**
   * <pre>
   * Name......: MME-Name
   * Code......: 2403
   * Section...: 6.4.4
   * Type......: DiameterIdentity
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int MME_NAME = 2402;

  /**
   * <pre>
   * Name......: MSC-Number
   * Code......: 2403
   * Section...: 6.4.5
   * Type......: OctetString
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int MSC_NUMBER = 2403;

  /**
   * <pre>
   * Name......: LCS-Capabilities-Sets
   * Code......: 2404
   * Section...: 6.4.6
   * Type......: Unsigned32
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_CAPABILITIES_SETS = 2404;

  /**
   * <pre>
   * Name......: GMLC-Address
   * Code......: 2405
   * Section...: 6.4.7
   * Type......: Address
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int GMLC_ADDRESS = 2405;

  /**
   * <pre>
   * Name......: Additional-Serving-Node
   * Code......: 2406
   * Section...: 6.4.8
   * Type......: Grouped
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int ADDITIONAL_SERVING_NODE = 2406;

  /**
   * <pre>
   * Name......: PPR-Address
   * Code......: 2407
   * Section...: 6.4.9
   * Type......: Address
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int PPR_ADDRESS = 2407;

  /**
   * <pre>
   * Name......: MME-Realm
   * Code......: 2408
   * Section...: 6.4.12
   * Type......: DiameterIdentity
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int MME_REALM = 2408;

  /**
   * <pre>
   * Name......: SGSN-Name
   * Code......: 2409
   * Section...: 6.4.13
   * Type......: DiameterIdentity
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int SGSN_NAME = 2409;

  /**
   * <pre>
   * Name......: SGSN-Realm
   * Code......: 2410
   * Section...: 6.4.14
   * Type......: DiameterIdentity
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int SGSN_REALM = 2410;

  /**
   * <pre>
   * Name......: RIA-Flags
   * Code......: 2411
   * Section...: 6.4.15
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int RIA_FLAGS = 2411;

  // SLh re-used Diameter AVPs
  public static final int USER_NAME = 1; // IMSI
  // 3GPP TS 29.329
  public static final int MSISDN = 701;
  // 3GPP TS 29.272
  public static final int SGSN_NUMBER = 1489;
  // 3GPP TS 29.229
  public static final int SUPPORTED_FEATURES = 628;
  public static final int FEATURE_LIST_ID = 629;
  public static final int FEATURE_LIST = 630;
  public static final int GMLC_NUMBER = 1474;
  public static final int TGPP_AAA_SERVER_NAME = 318;

}

