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

package net.java.slee.resource.diameter.slg.events.avp;

/**
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class ELPAVPCodes {

  public ELPAVPCodes() {
  }

  public static final long SLg_VENDOR_ID = 10415L;
  public static final long SLg_AUTH_APP_ID = 16777255L;

  /**
   * <pre>
   * Name......: SLg-Location-Type
   * Code......: 2500
   * Section...: 7.4.2
   * Type......: Enumerated
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int SLg_LOCATION_TYPE = 2500;

  /**
   * <pre>
   * Name......: LCS-EPS-Client-Name
   * Code......: 2501
   * Section...: 7.4.3
   * Type......: Grouped
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_EPS_CLIENT_NAME = 2501;

  /**
   * <pre>
   * Name......: LCS-Requestor-Name
   * Code......: 2502
   * Section...: 7.4.4
   * Type......: Grouped
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_REQUESTOR_NAME = 2502;

  /**
   * <pre>
   * Name......: LCS-Priority
   * Code......: 2503
   * Section...: 7.4.5
   * Type......: Unsigned32
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_PRIORITY = 2503;

  /**
   * <pre>
   * Name......: LCS-QoS
   * Code......: 2504
   * Section...: 7.4.6
   * Type......: Grouped
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_QoS = 2504;

  /**
   * <pre>
   * Name......: Horizontal-Accuracy
   * Code......: 2505
   * Section...: 7.4.7
   * Type......: Unsigned32
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int HORIZONTAL_ACCURACY = 2505;

  /**
   * <pre>
   * Name......: Vertical-Accuracy
   * Code......: 2506
   * Section...: 7.4.8
   * Type......: Unsigned32
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int VERTICAL_ACCURACY = 2506;

  /**
   * <pre>
   * Name......: Vertical-Requested
   * Code......: 2507
   * Section...: 7.4.9
   * Type......: Enumerated
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int VERTICAL_REQUESTED = 2507;

  /**
   * <pre>
   * Name......: Velocity-Requested
   * Code......: 2508
   * Section...: 7.4.10
   * Type......: Enumerated
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int VELOCITY_REQUESTED = 2508;

  /**
   * <pre>
   * Name......: Response-Time
   * Code......: 2509
   * Section...: 7.4.11
   * Type......: Enumerated
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int RESPONSE_TIME = 2509;

  /**
   * <pre>
   * Name......: Supported-GAD-Shapes
   * Code......: 2510
   * Section...: 7.4.12
   * Type......: Unsigned32
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int SUPPORTED_GAD_SHAPES = 2510;

  /**
   * <pre>
   * Name......: LCS-Codeword
   * Code......: 2511
   * Section...: 7.4.13
   * Type......: UTF8String
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_CODEWORD = 2511;

  /**
   * <pre>
   * Name......: LCS-Privacy-Check
   * Code......: 2512
   * Section...: 7.4.14
   * Type......: Enumerated
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_PRIVACY_CHECK = 2512;

  /**
   * <pre>
   * Name......: Accuracy-Fulfilment-Indicator
   * Code......: 2513
   * Section...: 7.4.15
   * Type......: Enumerated
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int ACCURACY_FULFILMENT_INDICATOR = 2512;

  /**
   * <pre>
   * Name......: Age-Of-Location-Estimate
   * Code......: 2514
   * Section...: 7.4.16
   * Type......: Unsigned32
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int AGE_OF_LOCATION_ESTIMATE = 2514;

  /**
   * <pre>
   * Name......: Velocity-Estimate
   * Code......: 2515
   * Section...: 7.4.17
   * Type......: OctetString
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int VELOCITY_ESTIMATE = 2515;

  /**
   * <pre>
   * Name......: EUTRAN-Positioning-Data
   * Code......: 2516
   * Section...: 7.4.18
   * Type......: OctetString
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int EUTRAN_POSITIONING_DATA = 2516;

  /**
   * <pre>
   * Name......: ECGI
   * Code......: 2517
   * Section...: 7.4.19
   * Type......: OctetString
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int ECGI = 2517;

  /**
   * <pre>
   * Name......: Location-Event
   * Code......: 2518
   * Section...: 7.4.20
   * Type......: Enumerated
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LOCATION_EVENT = 2518;

  /**
   * <pre>
   * Name......: Pseudonym-Indicator
   * Code......: 2519
   * Section...: 7.4.21
   * Type......: Enumerated
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int PSEUDONYM_INDICATOR = 2519;

  /**
   * <pre>
   * Name......: LCS-Service-Type-ID
   * Code......: 2520
   * Section...: 7.4.22
   * Type......: Unsigned32
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_SERVICE_TYPE_ID = 2520;

  /**
   * <pre>
   * Name......: LCS-Privacy-Check-Non-Session
   * Code......: 2521
   * Section...: 7.4.23
   * Type......: Grouped
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_PRIVACY_CHECK_NON_SESSION = 2521;

  /**
   * <pre>
   * Name......: LCS-Privacy-Check-Session
   * Code......: 2522
   * Section...: 7.4.24
   * Type......: Grouped
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_PRIVACY_CHECK_SESSION = 2522;

  /**
   * <pre>
   * Name......: LCS-QoS-Class
   * Code......: 2523
   * Section...: 7.4.27
   * Type......: Enumerated
   * Must......: M,V
   * May.......: -
   * Should....: -
   * MustNot...: -
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_QoS_CLASS = 2523;

  /**
   * <pre>
   * Name......: GERAN-Positioning-Info
   * Code......: 2524
   * Section...: 7.4.29
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int GERAN_POSITIONING_INFO = 2524;

  /**
   * <pre>
   * Name......: GERAN-Positioning-Data
   * Code......: 2525
   * Section...: 7.4.30
   * Type......: OctetString
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int GERAN_POSITIONING_DATA = 2525;

  /**
   * <pre>
   * Name......: GERAN-GANSS-Positioning-Data
   * Code......: 2526
   * Section...: 7.4.31
   * Type......: OctetString
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int GERAN_GANSS_POSITIONING_DATA = 2526;

  /**
   * <pre>
   * Name......: UTRAN-Positioning-Info
   * Code......: 2527
   * Section...: 7.4.32
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int UTRAN_POSITIONING_INFO = 2527;

  /**
   * <pre>
   * Name......: UTRAN-Positioning-Data
   * Code......: 2528
   * Section...: 7.4.33
   * Type......: OctetString
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int UTRAN_POSITIONING_DATA = 2528;

  /**
   * <pre>
   * Name......: UTRAN-GANSS-Positioning-Data
   * Code......: 2529
   * Section...: 7.4.34
   * Type......: OctetString
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int UTRAN_GANSS_POSITIONING_DATA = 2529;

  /**
   * <pre>
   * Name......: LRR-Flags
   * Code......: 2530
   * Section...: 7.4.35
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int LRR_FLAGS = 2530;

  /**
   * <pre>
   * Name......: LCS-Reference-Number
   * Code......: 2531
   * Section...: 7.4.37
   * Type......: OctetString
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int LCS_REFERENCE_NUMBER = 2531;

  /**
   * <pre>
   * Name......: Deferred-Location-Type
   * Code......: 2532
   * Section...: 7.4.36
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int DEFERRED_LOCATION_TYPE = 2532;

  /**
   * <pre>
   * Name......: Area-Event-Info
   * Code......: 2533
   * Section...: 7.4.38
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int AREA_EVENT_INFO = 2533;

  /**
   * <pre>
   * Name......: Area-Definition
   * Code......: 2534
   * Section...: 7.4.39
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int AREA_DEFINITION = 2534;

  /**
   * <pre>
   * Name......: Area
   * Code......: 2535
   * Section...: 7.4.40
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int AREA = 2535;

  /**
   * <pre>
   * Name......: Area-Type
   * Code......: 2536
   * Section...: 7.4.41
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int AREA_TYPE = 2536;

  /**
   * <pre>
   * Name......: Area-Identification
   * Code......: 2537
   * Section...: 7.4.42
   * Type......: OctetString (inconsistently defined initially spec, using section 7.4.42)
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int AREA_IDENTIFICATION = 2537;

  /**
   * <pre>
   * Name......: Occurrence-Info
   * Code......: 2538
   * Section...: 7.4.43
   * Type......: Enumerated
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int OCCURRENCE_INFO = 2538;

  /**
   * <pre>
   * Name......: Interval-Time
   * Code......: 2539
   * Section...: 7.4.44
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int INTERVAL_TIME = 2539;

  /**
   * <pre>
   * Name......: Periodic-LDR-Information
   * Code......: 2540
   * Section...: 7.4.45
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int PERIODIC_LDR_INFORMATION = 2540;

  /**
   * <pre>
   * Name......: Reporting-Amount
   * Code......: 2541
   * Section...: 7.4.46
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int REPORTING_AMOUNT = 2541;

  /**
   * <pre>
   * Name......: Reporting-Interval
   * Code......: 2542
   * Section...: 7.4.47
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int REPORTING_INTERVAL = 2542;

  /**
   * <pre>
   * Name......: Reporting-PLMN-List
   * Code......: 2543
   * Section...: 7.4.48
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int REPORTING_PLMN_LIST = 2543;

  /**
   * <pre>
   * Name......: PLMN-ID-List
   * Code......: 2544
   * Section...: 7.4.49
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int PLMN_ID_LIST = 2544;

  /**
   * <pre>
   * Name......: PLR-Flags
   * Code......: 2545
   * Section...: 7.4.52
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int PLR_FLAGS = 2545;

  /**
   * <pre>
   * Name......: PLA-Flags
   * Code......: 2546
   * Section...: 7.4.53
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int PLA_FLAGS = 2546;

  /**
   * <pre>
   * Name......: Deferred-MT-LR-Data
   * Code......: 2547
   * Section...: 7.4.54
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int DEFERRED_MT_LR_DATA = 2547;

  /**
   * <pre>
   * Name......: Termination-Cause
   * Code......: 2548
   * Section...: 7.4.55
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int TERMINATION_CAUSE = 2548;

  /**
   * <pre>
   * Name......: LRA-Flags
   * Code......: 2549
   * Section...: 7.4.56
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int LRA_FLAGS = 2549;

  /**
   * <pre>
   * Name......: Periodic-Location-Support-Indicator
   * Code......: 2550
   * Section...: 7.4.50
   * Type......: Enumerated
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int PERIODIC_LOCATION_SUPPORT_INDICATOR = 2550;

  /**
   * <pre>
   * Name......: Prioritized-List-Indicator
   * Code......: 2551
   * Section...: 7.4.51
   * Type......: Enumerated
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int PRIORITIZED_LIST_INDICATOR = 2551;

  /**
   * <pre>
   * Name......: ESMLC-Cell-Info
   * Code......: 2552
   * Section...: 7.4.57
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int ESMLC_CELL_INFO = 2552;

  /**
   * <pre>
   * Name......: Cell-Portion-ID
   * Code......: 2553
   * Section...: 7.4.58
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int CELL_PORTION_ID = 2553;

  /**
   * <pre>
   * Name......: 1xRTT-RCID
   * Code......: 2554
   * Section...: 7.4.59
   * Type......: OctetString
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int ONExRTT_RCID = 2554;

  /**
   * 3GPP TS 29.172 v13.1.0
   * <pre>
   * Name......: Delayed-Location-Reporting-Data
   * Code......: 2555
   * Section...: 7.4.60
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int DELAYED_LOCATION_REPORTING_DATA = 2555;

  /**
   * <pre>
   * Name......: Civic-Address
   * Code......: 2556
   * Section...: 7.4.61
   * Type......: UTF8String
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int CIVIC_ADDRESS = 2556;

  /**
   * <pre>
   * Name......: Barometric-Pressure
   * Code......: 2557
   * Section...: 7.4.62
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int BAROMETRIC_PRESSURE = 2557;

  /**
   * <pre>
   * Name......: UTRAN-Additional-Positioning-Data
   * Code......: 2558
   * Section...: 7.4.63
   * Type......: OctetString
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int UTRAN_ADDITIONAL_POSITIONING_DATA = 2558;

  /**
   * <pre>
   * Name......: Motion-Event-Info
   * Code......: 2559
   * Section...: 7.4.64
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int MOTION_EVENT_INFO = 2559;

  /**
   * <pre>
   * Name......: Linear-Distance
   * Code......: 2560
   * Section...: 7.4.65
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int LINEAR_DISTANCE = 2560;

  /**
   * <pre>
   * Name......: Maximum-Interval
   * Code......: 2561
   * Section...: 7.4.66
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int MAXIMUM_INTERVAL = 2561;

  /**
   * <pre>
   * Name......: Sampling-Interval
   * Code......: 2562
   * Section...: 7.4.67
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int SAMPLING_INTERVAL = 2562;

  /**
   * <pre>
   * Name......: Reporting-Duration
   * Code......: 2563
   * Section...: 7.4.68
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int REPORTING_DURATION = 2563;

  /**
   * <pre>
   * Name......: Reporting-Location-Requirements
   * Code......: 2564
   * Section...: 7.4.69
   * Type......: Unsigned32
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int REPORTING_LOCATION_REQUIREMENTS = 2564;

  /**
   * <pre>
   * Name......: Additional-Area
   * Code......: 2565
   * Section...: 7.4.70
   * Type......: Grouped
   * Must......: V
   * May.......: -
   * Should....: -
   * MustNot...: M
   * May Encr..: No
   * </pre>
   */
  public static final int ADDITIONAL_AREA = 2565;


  // SLh re-used Diameter AVPs
  // IETF RFC 3588
  public static final int USER_NAME = 1; // IMSI
  // 3GPP TS 29.329
  public static final int MSISDN = 701;
  // 3GPP TS 29.272
  public static final int IMEI = 1402;
  public static final int CELL_GLOBAL_IDENTITY = 1604;
  public static final int SERVICE_AREA_IDENTITY = 1607;
  public static final int VISITED_PLMN_ID = 1407;
  public static final int SERVICE_SELECTION = 493;
  public static final int SGSN_NUMBER = 1489;
  // 3GPP TS 29.229
  public static final int SUPPORTED_FEATURES = 628;
  public static final int FEATURE_LIST_ID = 629;
  public static final int FEATURE_LIST = 630;
  public static final int TGPP_AAA_SERVER_NAME = 318;
  // 3GPP TS 32.299
  public static final int LCS_FORMAT_INDICATOR = 1237;
  public static final int LCS_NAME_STRING = 1238;
  public static final int LCS_CLIENT_TYPE = 1241;
  public static final int LCS_REQUESTOR_ID_STRING = 1240;
  public static final int LOCATION_ESTIMATE = 1242;
  // 3GPP TS 29.173
  public static final int GMLC_ADDRESS = 2405;
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

}
