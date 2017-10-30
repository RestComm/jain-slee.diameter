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

package net.java.slee.resource.diameter.slg.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the Area-Definition AVP type.
 * From the Diameter-based ELP SLg interface for Control Plane LCS (3GPP TS 29.172 V13.0.0) specification.
 *
 * <pre>
 * 7.4.39	Area
 * The Area-Definition AVP is of type Grouped.
 * AVP format:
 * 						Area-Definition ::= <AVP header: 2534 10415>
 * 						1*10{ Area }
 * 						[ AVP ]
 * </pre>
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface AreaDefinitionAvp extends GroupedAvp {

  /*
    From 3GPP TS 29.172 V13.0.0

		7.4.40	Area
		The Area AVP is of type Grouped.
		AVP format:
			Area ::= <AVP header: 2535 10415>
						{ Area-Type }
						{ Area-Identification }
						*[ AVP ]
  */
  public boolean hasArea();
  public AreaAvp getArea();
  public void setArea (AreaAvp area);

}
