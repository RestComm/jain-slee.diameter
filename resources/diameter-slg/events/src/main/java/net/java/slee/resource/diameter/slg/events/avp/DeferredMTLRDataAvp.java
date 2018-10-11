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

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Deferred-MT-LR-Data AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
 * <p>
 * <pre>
 * 7.4.54	Deferred-MT-LR-Data
 * The Deferred-MT-LR-Data AVP is of type Grouped.
 * AVP format:
 * 						Deferred-MT-LR-Data ::= <AVP header: 2547 10415>
 *                                   { Deferred-Location-Type }
 * 																	 [ Termination-Cause ]
 * 																	 [ Serving-Node ]
 * 																	*[ AVP ]
 *
 * Serving-Node may be included only when the Termination-Cause is present indicating MT_LR_RESTART.
 * The Serving-Node refers to the node where the UE has moved to and shall be included, if available.
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public interface DeferredMTLRDataAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V14.1.0

		7.4.36	Deferred-Location-Type
		The Deferred-Location-Type AVP is of type Unsigned32 and it shall contain a bit mask. Each bit indicates a type of event,
		until when the location estimation is deferred. For details, please refer to 3GPP TS 23.271 [3] clause 4.4.2.
		The meaning of the bits shall be as defined in table 7.4.36/1:

		Table 7.4.36/1: Deferred-Location-Type
		Bit				Event Type							Description
			0				UE-Available						Any event in which the SGSN has established a contact with the UE.
			1				Entering-Into-Area			An event where the UE enters a pre-defined geographical area.
			2				Leaving-From-Area				An event where the UE leaves a pre-defined geographical area.
			3				Being-Inside-Area				An event where the UE is currently within the pre-defined geographical area.
																			For this event, the value of Occurrence-Info AVP is always treated as set to “ONE_TIME_EVENT”.
			4				Periodic-LDR						An event where a defined periodic timer expires in the UE and activates a location report or a location request.
  */
  boolean hasDeferredLocationType();

  long getDeferredLocationType();

  void setDeferredLocationType(long deferredLocationType);

  /*
		From 3GPP TS 29.172 V14.1.0

		7.4.55	Termination-Cause
		The Termination-Cause AVP is of type Unsigned32. The following values are defined:
			"Normal"																			0
			"Error Undefined"															1
			"Internal Timeout"														2
			"Congestion"																	3
			"MT_LR_Restart"																4
			"Privacy Violation"														5
			"Shape of Location Estimate Not Supported"		6
			"Subscriber Termination"											7
			"UE Termination"															8
			"Network Termination"													9
		"MT_LR_Restart" cause code shall be used to trigger the GMLC to restart the location procedure,
		either because the sending node knows that the terminal has moved under coverage of another SGSN or MME,
		or because the subscriber has been deregistered due to a Cancel Location received from HSS.
		Any unrecognized value of Termination-Cause shall be treated the same as value 1 ("Error Undefined").
	*/
  boolean hasTerminationCause();

  long getTerminationCause();

  void setTerminationCause(long terminationCause);

  /*
    From 3GPP TS 29.172 V14.1.0

    7.4.28	Serving-Node
    The Serving-Node AVP is of type Grouped. This AVP shall contain the information about the network node serving the targeted user.

  */
  boolean hasServingNode();

  ServingNodeAvp getServingNode();

  void setServingNode(ServingNodeAvp servingNode);

}
