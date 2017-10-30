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

package net.java.slee.resource.diameter.slg;

import javax.slee.ActivityContextInterface;

/**
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 */
public interface SLgActivityContextInterfaceFactory {

  /**
   * Method for obtaining an ACI wrapping the given SLg Client Session.
   * @param slgcs the SLg Client Session
   * @return an ActivityContextInterface
   */
  public ActivityContextInterface getActivityContextInterface(SLgClientSessionActivity slgcs);

  /**
   * Method for obtaining an ACI wrapping the given SLg Server Session.
   * @param slgss the SLg Server Session
   * @return an ActivityContextInterface
   */
  public ActivityContextInterface getActivityContextInterface(SLgServerSessionActivity slgss);

}
