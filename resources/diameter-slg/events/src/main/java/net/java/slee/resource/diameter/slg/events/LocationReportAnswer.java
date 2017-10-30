/*
 *
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
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
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.base.events.avp.FailedAvp;
import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;
import net.java.slee.resource.diameter.slg.events.avp.*;

/**
 * Interface for LocationReportAnswer type of message. It has following structure:
 *
 * < Location-Report-Answer > ::=	< Diameter Header: 8388621, PXY, 16777255>
 *
 *                                  < Session-Id >
 *                                  [ Vendor-Specific-Application-Id ]
 *                                  [ Result-Code ]
 *                                  [ Experimental-Result ]
 *                                  { Auth-Session-State }
 *                                  { Origin-Host }
 *                                  { Origin-Realm }
 *                                  [ GMLC-Address ]
 *                                  [ LRA-Flags ]
 *                                  [ Reporting-PLMN-List  ]
 *                                  [ LCS-Reference-Number ]
 *                                  *[ Supported-Features ]
 *                                  *[ AVP ]
 *                                  *[ Failed-AVP ]
 *                                  *[ Proxy-Info ]
 *                                  *[ Route-Record ]
 *
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface LocationReportAnswer extends DiameterMessage {

  /**
   * Returns true if the Result-Code AVP is present in the message.
   */
  boolean hasResultCode();

  /**
   * Returns the value of the Result-Code AVP, of type Unsigned32. Use
   * {@link #hasResultCode()} to check the existence of this AVP.
   *
   * @return the value of the Result-Code AVP
   * @throws IllegalStateException if the Result-Code AVP has not been set on this message
   */
  long getResultCode();

  /**
   * Sets the value of the Result-Code AVP, of type Unsigned32.
   *
   * @throws IllegalStateException if setResultCode has already been called
   */
  void setResultCode(long resultCode);

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

  /**
   * Returns true if the GMLC-Address AVP is present in the message.
   *
   * @return
   */
  boolean hasGMLCAddress();

  /**
   * Returns the value of the GMLC-Address, of type Address.
   *
   * @return
   */
  Address getGMLCAddress();

  /**
   * Sets the value of the GMLC-Address AVP, of type Address.
   *
   * @param gmlcAddress
   * @throws IllegalStateException
   */
  void setGMLCAddress(Address gmlcAddress) throws IllegalStateException;

  /**
   * Returns true if the LRA-Flags AVP is present in the message.
   *
   * @return
   */
  boolean hasLRAFlags();

  /**
   * Returns the value of the LRA-Flags, of type Unsigned32.
   *
   * @return
   */
  long getLRAFlags();

  /**
   * Sets the value of the LRA-Flags AVP, of type Unsigned32.
   *
   * @param lraFlags
   * @throws IllegalStateException
   */
  void setLRAFlags(long lraFlags) throws IllegalStateException;

  /**
   * Returns true if the putAvp Reporting-PLMN-List is present in the message.
   *
   * @return
   */
  boolean hasReportingPLMNList();

  /**
   * Returns the value of the putAvp Reporting-PLMN-List, of type Grouped.
   *
   * @return
   */
  ReportingPLMNListAvp getReportingPLMNList();

  /**
   * Sets the value of the putAvp Reporting-PLMN-List, of type Grouped.
   *
   * @param reportingPLMNList
   * @throws IllegalStateException
   */
  void setReportingPLMNList(ReportingPLMNListAvp reportingPLMNList) throws IllegalStateException;

  /**
   * Returns true if the putAvp PLMN-ID-List is present in the message.
   *
   * @return
   */
  boolean hasPLMNIDList();

  /**
   * Returns the value of the putAvp PLMN-ID-List, of type Grouped.
   *
   * @return
   */
  PLMNIDListAvp getPLMNIDList();

  /**
   * Sets the value of the putAvp PLMN-ID-List, of type Grouped.
   *
   * @param plmnIDList
   * @throws IllegalStateException
   */
  void setPLMNIDList(PLMNIDListAvp plmnIDList) throws IllegalStateException;

  /**
   * Returns true if the Prioritized-List-Indicator AVP is present in the message.
   *
   * @return
   */
  boolean hasPrioritizedListIndicator();

  /**
   * Returns the value of the Prioritized-List-Indicator AVP, of type .
   *
   * @return
   */
  PrioritizedListIndicator getPrioritizedListIndicator();

  /**
   * Sets the value of the Prioritized-List-Indicator AVP, of type .
   *
   * @param prioritizedListIndicator
   * @throws IllegalStateException
   */
  void setPrioritizedListIndicator(PrioritizedListIndicator prioritizedListIndicator) throws IllegalStateException;

  /**
   * Returns true if the Visited-PLMN-Id AVP is present in the message.
   *
   * @return
   */
  boolean hasVisitedPLMNId();

  /**
   * Returns the value of the Visited-PLMN-Id AVP, of type OctetString.
   *
   * @return
   */
  byte[] getVisitedPLMNId();

  /**
   * Sets the value of the Visited-PLMN-Id AVP, of type OctetString.
   *
   * @param visitedPLMNId
   * @throws IllegalStateException
   */
  void setVisitedPLMNId(byte[] visitedPLMNId) throws IllegalStateException;

  /**
   * Returns true if the Periodic-Location-Support-Indicator AVP is present in the message.
   *
   * @return
   */
  boolean hasPeriodicLocationSupportIndicator();

  /**
   * Returns the value of the Periodic-Location-Support-Indicator AVP, of type Enumerated.
   *
   * @return
   */
  PeriodicLocationSupportIndicator getPeriodicLocationSupportIndicator();

  /**
   * Sets the value of the Periodic-Location-Support-Indicator AVP, of type Enumerated.
   *
   * @param periodicLocationSupportIndicator
   * @throws IllegalStateException
   */
  void setPeriodicLocationSupportIndicator(PeriodicLocationSupportIndicator periodicLocationSupportIndicator) throws IllegalStateException;

  /**
   * Returns true if the LCS-Reference-Number AVP is present in the message.
   *
   * @return
   */
  boolean hasLCSReferenceNumber();

  /**
   * Returns the value of the LCS-Reference-Number AVP, of type OctetString.
   *
   * @return
   */
  byte[] getLCSReferenceNumber();

  /**
   * Sets the value of the LCS-Reference-Number AVP, of type OctetString.
   *
   * @param lcsReferenceNumber
   * @throws IllegalStateException
   */
  void setLCSReferenceNumber(byte[] lcsReferenceNumber) throws IllegalStateException;

}
