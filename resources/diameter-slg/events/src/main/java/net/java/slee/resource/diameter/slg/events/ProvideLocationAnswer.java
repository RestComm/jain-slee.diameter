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

package net.java.slee.resource.diameter.slg.events;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp;
import net.java.slee.resource.diameter.base.events.avp.VendorSpecificApplicationIdAvp;
import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.FailedAvp;

import net.java.slee.resource.diameter.slg.events.avp.AccuracyFulfilmentIndicator;
import net.java.slee.resource.diameter.slg.events.avp.GERANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.UTRANPositioningInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.ServingNodeAvp;
import net.java.slee.resource.diameter.slg.events.avp.ESMLCCellInfoAvp;
import net.java.slee.resource.diameter.slg.events.avp.SupportedFeaturesAvp;

/**
 * Interface for ProvideLocationAnswer type of message. It has following structure:
 *
 * < Provide-Location-Answer > ::=	< Diameter Header: 8388620, PXY, 16777255 >
 *
 *                                  < Session-Id >
 *                                  [ Vendor-Specific-Application-Id ]
 *                                  [ Result-Code ]
 *                                  [ Experimental-Result ]
 *                                  { Auth-Session-State }
 *                                  { Origin-Host }
 *                                  { Origin-Realm }
 *                                  [ Location-Estimate ]
 *                                  [ Accuracy-Fulfilment-Indicator ]
 *                                  [ Age-Of-Location-Estimate]
 *                                  [ Velocity-Estimate ]
 *                                  [ EUTRAN-Positioning-Data]
 *                                  [ ECGI ]
 *                                  [ GERAN-Positioning-Info ]
 *                                  [ Cell-Global-Identity ]
 *                                  [ UTRAN-Positioning-Info ]
 *                                  [ Service-Area-Identity ]
 *                                  [ Serving-Node ]
 *                                  [ PLA-Flags ]
 *                                  [ ESMLC-Cell-Info ]
 *                                  [ Civic-Address ]
 *                                  [ Barometric-Pressure ]
 *                                  *[ Supported-Features ]
 *                                  *[ AVP ]
 *                                  *[ Failed-AVP ]
 *                                  *[ Proxy-Info ]
 *                                  *[ Route-Record ]
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface ProvideLocationAnswer extends DiameterMessage {

  static final int COMMAND_CODE = 8388620;

  /**
   * Returns true if the Vendor-Specific-Application-Id AVP is present in the message.
   *
   * @return true if the Vendor-Specific-Application-Id AVP is present in the message, false otherwise
   */
  boolean hasVendorSpecificApplicationId();

  /**
   * Returns the value of the Vendor-Specific-Application-Id AVP, of type Grouped.
   *
   * @return the value of the Vendor-Specific-Application-Id AVP or null if it has not been set on this message
   */
  VendorSpecificApplicationIdAvp getVendorSpecificApplicationId();

  /**
   * Sets the value of the Vendor-Specific-Application-Id AVP, of type Grouped.
   *
   * @param vendorSpecificApplicationId the new value for the Vendor-Specific-Application-Id AVP
   */
  void setVendorSpecificApplicationId(VendorSpecificApplicationIdAvp vendorSpecificApplicationId);

  /**
   * Returns true if the Result-Code AVP is present in the message.
   *
   * @return
   */
  boolean hasResultCode();

  /**
   * Returns the value of the Result-Code AVP, of type Unsigned32.
   * Use {@link #hasResultCode()} to check the existence of this AVP.
   *
   * @return the value of the Result-Code AVP
   */
  long getResultCode();

  /**
   * Sets the value of the Result-Code AVP, of type Unsigned32.
   *
   * @param resultCode
   */
  void setResultCode(long resultCode);

  /**
   * Returns true if the Experimental-Result AVP is present in the message.
   *
   * @return true if the Experimental-Result AVP is present in the message, false otherwise
   */
  public boolean hasExperimentalResult();

  /**
   * Returns the value of the Experimental-Result AVP, of type Grouped.
   *
   * @return the value of the Experimental-Result AVP, of type Grouped.
   */
  public ExperimentalResultAvp getExperimentalResult();

  /**
   * Sets the value of the Experimental-Result AVP, of type Grouped.
   *
   * @param experimentalResult
   */
  public void setExperimentalResult(ExperimentalResultAvp experimentalResult);

  /**
   * Returns true if the Experimental-Result AVP is present in the message.
   *
   * @return true if the Experimental-Result AVP is present in the message, false otherwise
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
   * Returns true if the Location-Estimate AVP is present in the message.
   *
   * @return
   */
  boolean hasLocationEstimate();

  /**
   * Returns the value of the Location-Estimate AVP, of type OctetString.
   *
   * @return
   */
  byte[] getLocationEstimate();

  /**
   * Sets the value of the Location-Estimate AVP, of type OctetString.
   *
   * @param locationEstimate
   * @throws IllegalStateException
   */
  void setLocationEstimate(byte[] locationEstimate) throws IllegalStateException;

  /**
   * Returns true if the Accuracy-Fulfilment-Indicator AVP is present in the message.
   *
   * @return
   */
  boolean hasAccuracyFulfilmentIndicator();

  /**
   * Returns the value of the Accuracy-Fulfilment-Indicator AVP, of type Enumerated.
   *
   * @return
   */
  AccuracyFulfilmentIndicator getAccuracyFulfilmentIndicator();

  /**
   * Sets the value of the Accuracy-Fulfilment-Indicator AVP, of type Enumerated.
   *
   * @param accuracyFulfilmentIndicator
   * @throws IllegalStateException
   */
  void setAccuracyFulfilmentIndicator(AccuracyFulfilmentIndicator accuracyFulfilmentIndicator) throws IllegalStateException;

  /**
   * Returns true if the Age-Of-Location-Estimate AVP is present in the message.
   *
   * @return
   */
  boolean hasAgeOfLocationEstimate();

  /**
   * Returns the value of the Age-Of-Location-Estimate AVP, of type Unsigned32.
   *
   * @return
   */
  long getAgeOfLocationEstimate();

  /**
   * Sets the value of the Age-Of-Location-Estimate AVP, of type Unsigned32.
   *
   * @param ageOfLocationEstimate
   * @throws IllegalStateException
   */
  void setAgeOfLocationEstimate(long ageOfLocationEstimate) throws IllegalStateException;

  /**
   * Returns true if the Velocity-Estimate AVP is present in the message.
   *
   * @return
   */
  boolean hasVelocityEstimate();

  /**
   * Returns the value of the Velocity-Estimate AVP, of type OctetString.
   *
   * @return
   */
  byte[] getVelocityEstimate();

  /**
   * Sets the value of the Velocity-Estimate AVP, of type OctetString.
   *
   * @param velocityEstimate
   * @throws IllegalStateException
   */
  void setVelocityEstimate(byte[] velocityEstimate) throws IllegalStateException;

  /**
   * Returns true if the EUTRAN-Positioning-Data AVP is present in the message.
   *
   * @return
   */
  boolean hasEUTRANPositioningData();

  /**
   * Returns the value of the Velocity-Estimate AVP, of type OctetString.
   *
   * @return
   */
  byte[] getEUTRANPositioningData();

  /**
   * Sets the value of the Velocity-Estimate AVP, of type OctetString.
   *
   * @param eUTRANPositioningData
   * @throws IllegalStateException
   */
  void setEUTRANPositioningData(byte[] eUTRANPositioningData) throws IllegalStateException;

  /**
   * Returns true if the ECGI AVP is present in the message.
   *
   * @return
   */
  boolean hasECGI();

  /**
   * Returns the value of the ECGI AVP, of type OctetString.
   *
   * @return
   */
  byte[] getECGI();

  /**
   * Sets the value of the ECGI AVP, of type OctetString.
   *
   * @param ecgi
   * @throws IllegalStateException
   */
  void setECGI(byte[] ecgi) throws IllegalStateException;

  /**
   * Returns true if the GERAN-Positioning-Info AVP is present in the message.
   *
   * @return
   */
  boolean hasGERANPositioningInfo();

  /**
   * Returns the value of the GERAN-Positioning-Info AVP, of type Grouped.
   *
   * @return
   */
  GERANPositioningInfoAvp getGERANPositioningInfo();

  /**
   * Sets the value of the GERAN-Positioning-Info AVP, of type Grouped.
   *
   * @param geranPositioningInfo
   * @throws IllegalStateException
   */
  void setGERANPositioningInfo(GERANPositioningInfoAvp geranPositioningInfo) throws IllegalStateException;

  /**
   * Returns true if the Cell-Global-Identity AVP is present in the message.
   *
   * @return
   */
  boolean hasCellGlobalIdentity();

  /**
   * Returns the value of the Cell-Global-Identity AVP, of type OctetString.
   *
   * @return
   */
  byte[] getCellGlobalIdentity();

  /**
   * Sets the value of the Cell-Global-Identity AVP, of type OctetString.
   *
   * @param cellGlobalIdentity
   * @throws IllegalStateException
   */
  void setCellGlobalIdentity(byte[] cellGlobalIdentity) throws IllegalStateException;

  /**
   * Returns true if the UTRAN-Positioning-Info AVP is present in the message.
   *
   * @return
   */
  boolean hasUTRANPositioningInfo();

  /**
   * Returns the value of the UTRAN-Positioning-Info AVP, of type Grouped.
   *
   * @return
   */
  UTRANPositioningInfoAvp getUTRANPositioningInfo();

  /**
   * Sets the value of the UTRAN-Positioning-Info AVP, of type Grouped.
   *
   * @param utranPositioningInfo
   * @throws IllegalStateException
   */
  void setUTRANPositioningInfo(UTRANPositioningInfoAvp utranPositioningInfo) throws IllegalStateException;

  /**
   * Returns true if the Service-Area-Identity AVP is present in the message.
   *
   * @return
   */
  boolean hasServiceAreaIdentity();

  /**
   * Returns the value of the Service-Area-Identity AVP, of type OctetString.
   *
   * @return
   */
  byte[] getServiceAreaIdentity();

  /**
   * Sets the value of the Service-Area-Identity AVP, of type OctetString.
   *
   * @param serviceAreaIdentity
   * @throws IllegalStateException
   */
  void setServiceAreaIdentity(byte[] serviceAreaIdentity) throws IllegalStateException;

  /**
   * Returns true if the Serving-Node AVP is present in the message.
   *
   * @return
   */
  boolean hasServingNode();

  /**
   * Returns the value of the Serving-Node AVP, of type OctetString.
   *
   * @return
   */
  ServingNodeAvp getServingNode();

  /**
   * Sets the value of the Serving-Node AVP, of type OctetString.
   *
   * @param servingNode
   * @throws IllegalStateException
   */
  void setServingNode(ServingNodeAvp servingNode) throws IllegalStateException;

  /**
   * Returns true if the PLA-Flags AVP is present in the message.
   *
   * @return
   */
  boolean hasPLAFlags();

  /**
   * Returns the value of the PLA-Flags, of type Unsigned32.
   *
   * @return
   */
  long getPLAFlags();

  /**
   * Sets the value of the PLA-Flags AVP, of type Unsigned32.
   *
   * @param plaFlags
   * @throws IllegalStateException
   */
  void setPLAFlags(long plaFlags) throws IllegalStateException;

  /**
   * Returns true if the ESMLC-Cell-Info AVP is present in the message.
   *
   * @return
   */
  boolean hasESMLCCellInfo();

  /**
   * Returns the value of the ESMLC-Cell-Info, of type Grouped.
   *
   * @return
   */
  ESMLCCellInfoAvp getESMLCCellInfo();

  /**
   * Sets the value of the ESMLC-Cell-Info AVP, of type Grouped.
   *
   * @param eSMLCCellInfo
   * @throws IllegalStateException
   */
  void setESMLCCellInfo(ESMLCCellInfoAvp eSMLCCellInfo) throws IllegalStateException;

  /**
   * Returns true if the Civic-Address AVP is present in the message.
   *
   * @return
   */
  boolean hasCivicAddress();

  /**
   * Returns the value of the Civic-Address AVP, of type OctetString.
   *
   * @return
   */
  byte[] getCivicAddress();

  /**
   * Sets the value of the Civic-Address AVP, of type OctetString.
   *
   * @param civicAddress
   * @throws IllegalStateException
   */
  void setCivicAddress(byte[] civicAddress) throws IllegalStateException;

  /**
   * Returns true if the Barometric-Pressure AVP is present in the message.
   *
   * @return
   */
  boolean hasBarometricPressure();

  /**
   * Returns the value of the Barometric-Pressure, of type Unsigned32.
   *
   * @return
   */
  long getBarometricPressure();

  /**
   * Sets the value of the Barometric-Pressure AVP, of type Unsigned32.
   *
   * @param barometricPressure
   * @throws IllegalStateException
   */
  void setBarometricPressure(long barometricPressure) throws IllegalStateException;

  /**
   * Returns the value of the Supported-Features AVP, of type Grouped.
   *
   * @return
   */
  public SupportedFeaturesAvp[] getSupportedFeatureses();

  /**
   * Set a single instance value of the Supported-Features AVP, of type Grouped.
   *
   * @param supportedFeatures
   */
  public void setSupportedFeatures(SupportedFeaturesAvp supportedFeatures);

  /**
   * Set multiple instance value of the Supported-Features AVP, of type Grouped.
   *
   * @param supportedFeatureses
   */
  public void setSupportedFeatureses(SupportedFeaturesAvp[] supportedFeatureses);

  /**
   * Returns the set of Failed-AVP AVPs.
   *
   * @return
   */
  FailedAvp[] getFailedAvps();

  /**
   * Sets a single Failed-AVP AVP in the message, of type Grouped.
   *
   * @param failedAvp
   * @throws IllegalStateException
   */
  void setFailedAvp(FailedAvp failedAvp) throws IllegalStateException;

  /**
   * Sets the set of Failed-AVP AVPs, with all the values in the given array.
   *
   * @param failedAvps
   * @throws IllegalStateException
   */
  void setFailedAvps(FailedAvp[] failedAvps) throws IllegalStateException;

}