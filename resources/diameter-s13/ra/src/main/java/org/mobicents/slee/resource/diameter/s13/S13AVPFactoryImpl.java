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

package org.mobicents.slee.resource.diameter.s13;

import static net.java.slee.resource.diameter.s13.events.avp.DiameterS13AvpCodes.*;
import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.base.events.avp.AvpUtilities;
import net.java.slee.resource.diameter.s13.S13AVPFactory;
import net.java.slee.resource.diameter.s13.events.avp.TerminalInformationAvp;

import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.s13.events.avp.TerminalInformationAvpImpl;

/**
 * Diameter S13 Reference Point AVP Factory. Implementation for {@link S13AVPFactory}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class S13AVPFactoryImpl extends DiameterAvpFactoryImpl implements S13AVPFactory {

  // TODO: Add helper create methods for the composite AVPs
  protected DiameterAvpFactory baseAvpFactory;

  public S13AVPFactoryImpl(final DiameterAvpFactory baseAvpFactory) {
    this.baseAvpFactory = baseAvpFactory;
  }

  public DiameterAvpFactory getBaseFactory() {
    return this.baseAvpFactory;
  }

  public TerminalInformationAvp createTerminalInformation() {
    return (TerminalInformationAvp) AvpUtilities.createAvp(TERMINAL_INFORMATION, S13_VENDOR_ID, null, TerminalInformationAvpImpl.class);
  }

}
