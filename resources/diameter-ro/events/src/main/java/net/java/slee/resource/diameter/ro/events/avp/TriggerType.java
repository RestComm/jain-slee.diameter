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

package net.java.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Properties;

/**
 * Java class to represent the TriggerType enumerated type
 * based on the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.25.0) specification.
 * <p>
 *     When included in the Credit Control Answer command, the Trigger-Type AVP indicates the events that shall cause the credit control client to re-authorise the associated quota. The client shall not re-authorise the quota when events which are not included in the Trigger AVP occur.
 * </p>
 * <p>
 *     When included in the Credit Control Request command indicates the specific event which caused the re-authorisation request of the Reporting-Reason with value RATING_CONDITION_CHANGE associated.
 * </p>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel (ProIDS sp. z o.o.)</a>
 */
public class TriggerType implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  private static Logger LOG = Logger.getLogger(TriggerType.class);

  public static final int _CHANGE_IN_LOCATION = 3;

  public static final int _CHANGE_IN_QOS = 2;

  public static final int _CHANGE_IN_RAT = 4;

  public static final int _CHANGE_IN_SGSN_IP_ADDRESS = 1;

  public static final int _CHANGEINLOCATION_CellId = 34;

  public static final int _CHANGEINLOCATION_LAC = 33;

  public static final int _CHANGEINLOCATION_MCC = 30;

  public static final int _CHANGEINLOCATION_MNC = 31;

  public static final int _CHANGEINLOCATION_RAC = 32;

  public static final int _CHANGEINQOS_DELAY_CLASS = 12;

  public static final int _CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_DOWNLINK = 23;

  public static final int _CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_UPLINK = 22;

  public static final int _CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_DOWNLINK = 17;

  public static final int _CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_UPLINK = 16;

  public static final int _CHANGEINQOS_MEAN_THROUGHPUT = 15;

  public static final int _CHANGEINQOS_PEAK_THROUGHPUT = 13;

  public static final int _CHANGEINQOS_PRECEDENCE_CLASS = 14;

  public static final int _CHANGEINQOS_RELIABILITY_CLASS = 11;

  public static final int _CHANGEINQOS_RESIDUAL_BER = 18;

  public static final int _CHANGEINQOS_SDU_ERROR_RATIO = 19;

  public static final int _CHANGEINQOS_TRAFFIC_CLASS = 10;

  public static final int _CHANGEINQOS_TRAFFIC_HANDLING_PRIORITY = 21;

  public static final int _CHANGEINQOS_TRANSFER_DELAY = 20;

  public static final int _CHANGE_IN_MEDIA_COMPOSITION = 40;

  public static final int _CHANGEINPARTICIPANTS_Number = 50;

  public static final int _CHANGE_IN_THRSHLD_OF_PARTICIPANTS_NMB = 51;

  public static final int _CHANGE_IN_USER_PARTICIPATING_TYPE = 52;

  public static final int _CHANGE_IN_SERVICE_CONDITION = 60;

  public static final int _CHANGE_IN_SERVING_NODE = 61;

  private static final String TMPL_SPECIFIC_VALUE_CONFIG_PATH = "/tmpl/trigger-type.avp";
  private static final String TMPL_SERVED_IN_DEGRADED_MODE_PROPERTY = "served.in.degraded.mode";
  private static final String TMPL_SERVED_IN_DEGRADED_MODE_DEFAULT_VALUE = "999";
  public static final int _TMPL_SERVED_IN_DEGRADED_MODE = getTmplServeInDegradedModeValue();

  /* TMPL specific code */
  private static int getTmplServeInDegradedModeValue() {
    int value;
    Properties avpConfig = new Properties();
    try {
      InputStream inputStream = TriggerType.class.getResourceAsStream(TMPL_SPECIFIC_VALUE_CONFIG_PATH);
      try {
        avpConfig.load(inputStream);
      } finally {
        inputStream.close();
      }

      value = Integer.parseInt( avpConfig.getProperty(TMPL_SERVED_IN_DEGRADED_MODE_PROPERTY, TMPL_SERVED_IN_DEGRADED_MODE_DEFAULT_VALUE) );
    } catch(Throwable t) {
      LOG.warn("Cannot load TMPL SERVED_IN_DEGRADED_MODE Trigger-Type AVP value from file: " + TMPL_SPECIFIC_VALUE_CONFIG_PATH
              + " Cause: " +  t.toString()
              + " Using default value: " + TMPL_SERVED_IN_DEGRADED_MODE_DEFAULT_VALUE);
      value = Integer.parseInt(TMPL_SERVED_IN_DEGRADED_MODE_DEFAULT_VALUE);
    }
    return value;
  }

  /**
   * This value is used to indicate that a change in the end user location shall cause the credit control client to ask for a re- authorisation of the associated quota. This should not be used in conjunction with enumerated values 30 to 34.
   */
  public static final TriggerType CHANGE_IN_LOCATION = new TriggerType(_CHANGE_IN_LOCATION);

  /**
   * This value is used to indicate that a change in the end user negotiated QoS shall cause the credit control client to ask for a re- authorisation of the associated quota. This should not be used in conjunction with enumerated values 10 to 23.
   */
  public static final TriggerType CHANGE_IN_QOS = new TriggerType(_CHANGE_IN_QOS);

  /**
   * This value is used to indicate that a change in the radio access technology shall cause the credit control client to ask for a re- authorisation of the associated quota.
   */
  public static final TriggerType CHANGE_IN_RAT = new TriggerType(_CHANGE_IN_RAT);

  /**
   * This value is used to indicate that a change in the SGSN IP address shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGE_IN_SGSN_IP_ADDRESS = new TriggerType(_CHANGE_IN_SGSN_IP_ADDRESS);

  /**
   * This value is used to indicate that a change in the Cell Identity where the end user is located shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINLOCATION_CellId = new TriggerType(_CHANGEINLOCATION_CellId);

  /**
   * This value is used to indicate that a change in the LAC where the end user is located shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINLOCATION_LAC = new TriggerType(_CHANGEINLOCATION_LAC);

  /**
   * This value is used to indicate that a change in the MCC of the serving network shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINLOCATION_MCC = new TriggerType(_CHANGEINLOCATION_MCC);

  /**
   * This value is used to indicate that a change in the MNC of the serving network shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINLOCATION_MNC = new TriggerType(_CHANGEINLOCATION_MNC);

  /**
   * This value is used to indicate that a change in the RAC where the end user is located shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINLOCATION_RAC = new TriggerType(_CHANGEINLOCATION_RAC);

  /**
   * This value is used specifically for multi participating session to indicate that a change in the number of active participants within a session shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINPARTICIPANTS_Number = new TriggerType(_CHANGEINPARTICIPANTS_Number);

  /**
   * This value is used to indicate that a change in the end user negotiated delay class shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_DELAY_CLASS = new TriggerType(_CHANGEINQOS_DELAY_CLASS);

  /**
   * This value is used to indicate that a change in the end user negotiated downlink guaranteed bit rate shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_DOWNLINK = new TriggerType(_CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_DOWNLINK);

  /**
   * This value is used to indicate that a change in the end user negotiated uplink guaranteed bit rate shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_UPLINK = new TriggerType(_CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_UPLINK);

  /**
   * This value is used to indicate that a change in the end user negotiated downlink maximum bit rate shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_DOWNLINK = new TriggerType(_CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_DOWNLINK);

  /**
   * This value is used to indicate that a change in the end user negotiated uplink maximum bit rate shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_UPLINK = new TriggerType(_CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_UPLINK);

  /**
   * This value is used to indicate that a change in the end user negotiated mean throughput shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_MEAN_THROUGHPUT = new TriggerType(_CHANGEINQOS_MEAN_THROUGHPUT);

  /**
   * This value is used to indicate that a change in the end user negotiated peak throughput shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_PEAK_THROUGHPUT = new TriggerType(_CHANGEINQOS_PEAK_THROUGHPUT);

  /**
   * This value is used to indicate that a change in the end user negotiated precedence class shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_PRECEDENCE_CLASS = new TriggerType(_CHANGEINQOS_PRECEDENCE_CLASS);

  /**
   * This value is used to indicate that a change in the end user negotiated reliability class shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_RELIABILITY_CLASS = new TriggerType(_CHANGEINQOS_RELIABILITY_CLASS);

  /**
   * This value is used to indicate that a change in the end user negotiated residual BER shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_RESIDUAL_BER = new TriggerType(_CHANGEINQOS_RESIDUAL_BER);

  /**
   * This value is used to indicate that a change in the end user negotiated SDU error ratio shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_SDU_ERROR_RATIO = new TriggerType(_CHANGEINQOS_SDU_ERROR_RATIO);

  /**
   * This value is used to indicate that a change in the end user negotiated traffic class shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_TRAFFIC_CLASS = new TriggerType(_CHANGEINQOS_TRAFFIC_CLASS);

  /**
   * This value is used to indicate that a change in the end user negotiated traffic handling priority shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_TRAFFIC_HANDLING_PRIORITY = new TriggerType(_CHANGEINQOS_TRAFFIC_HANDLING_PRIORITY);

  /**
   * This value is used to indicate that a change in the end user negotiated transfer delay shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGEINQOS_TRANSFER_DELAY = new TriggerType(_CHANGEINQOS_TRANSFER_DELAY);

  /**
   * This value is used to indicate that a change in the media composition (as identified within SDP) for an existing SIP session shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGE_IN_MEDIA_COMPOSITION = new TriggerType(_CHANGE_IN_MEDIA_COMPOSITION);

  /**
   * This value is used specifically to indicate that a change in the threshold of participants number within a session shall cause the credit control client to ask for a re-authorisation of the associated quota.
   * NOTE 3.
   * The threshold and the granularity of threshold are operator configurable. This should not be used in conjunction with value 50.
   */
  public static final TriggerType CHANGE_IN_THRSHLD_OF_PARTICIPANTS_NMB = new TriggerType(_CHANGE_IN_THRSHLD_OF_PARTICIPANTS_NMB);

  /**
   * This value is used specifically to indicate that a change in the user participating type within a session shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGE_IN_USER_PARTICIPATING_TYPE = new TriggerType(_CHANGE_IN_USER_PARTICIPATING_TYPE);

  /**
   * This value is used to indicate that a change in rating conditions associated with a service occurs.
   * The description of the conditions causing a change are service specific and may be documented in middle-tier specifications or may be configurable.
   */
  public static final TriggerType CHANGE_IN_SERVICE_CONDITION = new TriggerType(_CHANGE_IN_SERVICE_CONDITION);

  /**
   * This value is used to indicate that a change in serving node shall cause the credit control client to ask for a re-authorisation of the associated quota.
   */
  public static final TriggerType CHANGE_IN_SERVING_NODE = new TriggerType(_CHANGE_IN_SERVING_NODE);

  /**
   * T-Mobile OCP specific value.
   * <p>
   * This value is used to indicate that special treatment should be applied for next CCR sent.
   * </p>
   */
  public static final TriggerType TMPL_SERVED_IN_DEGRADED_MODE = new TriggerType(_TMPL_SERVED_IN_DEGRADED_MODE);

  private TriggerType(int v) {
    value = v;
  }

  /**
   * Return the value of this instance of this enumerated type.
   */
  public static TriggerType fromInt(int type) {
    switch(type) {
    case _CHANGE_IN_LOCATION: return CHANGE_IN_LOCATION;

    case _CHANGE_IN_QOS: return CHANGE_IN_QOS;

    case _CHANGE_IN_RAT: return CHANGE_IN_RAT;

    case _CHANGE_IN_SGSN_IP_ADDRESS: return CHANGE_IN_SGSN_IP_ADDRESS;

    case _CHANGEINLOCATION_CellId: return CHANGEINLOCATION_CellId;

    case _CHANGEINLOCATION_LAC: return CHANGEINLOCATION_LAC;

    case _CHANGEINLOCATION_MCC: return CHANGEINLOCATION_MCC;

    case _CHANGEINLOCATION_MNC: return CHANGEINLOCATION_MNC;

    case _CHANGEINLOCATION_RAC: return CHANGEINLOCATION_RAC;

    case _CHANGEINPARTICIPANTS_Number: return CHANGEINPARTICIPANTS_Number;

    case _CHANGEINQOS_DELAY_CLASS: return CHANGEINQOS_DELAY_CLASS;

    case _CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_DOWNLINK: return CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_DOWNLINK;

    case _CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_UPLINK: return CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_UPLINK;

    case _CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_DOWNLINK: return CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_DOWNLINK;

    case _CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_UPLINK: return CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_UPLINK;

    case _CHANGEINQOS_MEAN_THROUGHPUT: return CHANGEINQOS_MEAN_THROUGHPUT; 

    case _CHANGEINQOS_PEAK_THROUGHPUT: return CHANGEINQOS_PEAK_THROUGHPUT;

    case _CHANGEINQOS_PRECEDENCE_CLASS: return CHANGEINQOS_PRECEDENCE_CLASS;

    case _CHANGEINQOS_RELIABILITY_CLASS: return CHANGEINQOS_RELIABILITY_CLASS;

    case _CHANGEINQOS_RESIDUAL_BER: return CHANGEINQOS_RESIDUAL_BER;

    case _CHANGEINQOS_SDU_ERROR_RATIO: return CHANGEINQOS_SDU_ERROR_RATIO;

    case _CHANGEINQOS_TRAFFIC_CLASS: return CHANGEINQOS_TRAFFIC_CLASS;

    case _CHANGEINQOS_TRAFFIC_HANDLING_PRIORITY: return CHANGEINQOS_TRAFFIC_HANDLING_PRIORITY;

    case _CHANGEINQOS_TRANSFER_DELAY: return CHANGEINQOS_TRANSFER_DELAY;

    case _CHANGE_IN_MEDIA_COMPOSITION: return CHANGE_IN_MEDIA_COMPOSITION;

    case _CHANGE_IN_THRSHLD_OF_PARTICIPANTS_NMB: return CHANGE_IN_THRSHLD_OF_PARTICIPANTS_NMB;

    case _CHANGE_IN_USER_PARTICIPATING_TYPE: return CHANGE_IN_USER_PARTICIPATING_TYPE;

    case _CHANGE_IN_SERVICE_CONDITION: return CHANGE_IN_SERVICE_CONDITION;

    case _CHANGE_IN_SERVING_NODE: return CHANGE_IN_SERVING_NODE;

    default: {
      if(type != _TMPL_SERVED_IN_DEGRADED_MODE) {
        throw new IllegalArgumentException("Invalid TriggerType value: " + type);
      } else {
        return TMPL_SERVED_IN_DEGRADED_MODE;
      }
    }
    }
  }

  public int getValue() {
    return value;
  }

  public String toString() {
    switch(value) {
    case _CHANGE_IN_LOCATION: return "CHANGE_IN_LOCATION";

    case _CHANGE_IN_QOS: return "CHANGE_IN_QOS";

    case _CHANGE_IN_RAT: return "CHANGE_IN_RAT";

    case _CHANGE_IN_SGSN_IP_ADDRESS: return "CHANGE_IN_SGSN_IP_ADDRESS";

    case _CHANGEINLOCATION_CellId: return "CHANGEINLOCATION_CellId";

    case _CHANGEINLOCATION_LAC: return "CHANGEINLOCATION_LAC";

    case _CHANGEINLOCATION_MCC: return "CHANGEINLOCATION_MCC";

    case _CHANGEINLOCATION_MNC: return "CHANGEINLOCATION_MNC";

    case _CHANGEINLOCATION_RAC: return "CHANGEINLOCATION_RAC";

    //representation unchanged due to backward compatibility
    case _CHANGEINPARTICIPANTS_Number: return "CHANGEINPARTICIPANTS_Number";

    case _CHANGEINQOS_DELAY_CLASS: return "CHANGEINQOS_DELAY_CLASS";

    case _CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_DOWNLINK: return "CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_DOWNLINK";

    case _CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_UPLINK: return "CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_UPLINK";

    case _CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_DOWNLINK: return "CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_DOWNLINK";

    case _CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_UPLINK: return "CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_UPLINK";

    case _CHANGEINQOS_MEAN_THROUGHPUT: return "CHANGEINQOS_MEAN_THROUGHPUT"; 

    case _CHANGEINQOS_PEAK_THROUGHPUT: return "CHANGEINQOS_PEAK_THROUGHPUT";

    case _CHANGEINQOS_PRECEDENCE_CLASS: return "CHANGEINQOS_PRECEDENCE_CLASS";

    case _CHANGEINQOS_RELIABILITY_CLASS: return "CHANGEINQOS_RELIABILITY_CLASS";

    case _CHANGEINQOS_RESIDUAL_BER: return "CHANGEINQOS_RESIDUAL_BER";

    case _CHANGEINQOS_SDU_ERROR_RATIO: return "CHANGEINQOS_SDU_ERROR_RATIO";

    case _CHANGEINQOS_TRAFFIC_CLASS: return "CHANGEINQOS_TRAFFIC_CLASS";

    case _CHANGEINQOS_TRAFFIC_HANDLING_PRIORITY: return "CHANGEINQOS_TRAFFIC_HANDLING_PRIORITY";

    case _CHANGEINQOS_TRANSFER_DELAY: return "CHANGEINQOS_TRANSFER_DELAY";

    case _CHANGE_IN_MEDIA_COMPOSITION: return "CHANGE_IN_MEDIA_COMPOSITION";

    case _CHANGE_IN_THRSHLD_OF_PARTICIPANTS_NMB: return "CHANGE_IN_THRSHLD_OF_PARTICIPANTS_NMB";

    case _CHANGE_IN_USER_PARTICIPATING_TYPE: return "CHANGE_IN_USER_PARTICIPATING_TYPE";

    case _CHANGE_IN_SERVICE_CONDITION: return "CHANGE_IN_SERVICE_CONDITION";

    case _CHANGE_IN_SERVING_NODE: return "CHANGE_IN_SERVING_NODE";

    default: {
      if(value != _TMPL_SERVED_IN_DEGRADED_MODE) {
        return "<Invalid Value>";
      } else {
        return "TMPL_SERVED_IN_DEGRADED_MODE";
      }
    }
    }
  }

  private Object readResolve() throws StreamCorruptedException {
    try {
      return fromInt(value);
    }
    catch (IllegalArgumentException iae) {
      throw new StreamCorruptedException("Invalid internal state found: " + value);
    }
  }

  private int value = 0;

}
