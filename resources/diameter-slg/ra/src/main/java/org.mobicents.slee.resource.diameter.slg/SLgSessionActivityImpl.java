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

package org.mobicents.slee.resource.diameter.slg;

import java.util.ArrayList;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slg.SLgAVPFactory;
import net.java.slee.resource.diameter.slg.SLgMessageFactory;
import net.java.slee.resource.diameter.slg.SLgSessionActivity;;

import org.jdiameter.api.Answer;
import org.jdiameter.api.EventListener;
import org.jdiameter.api.Request;
import org.jdiameter.api.Session;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.app.StateChangeListener;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.AvpNotAllowedException;
import org.mobicents.slee.resource.diameter.base.DiameterActivityImpl;

/**
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public abstract class SLgSessionActivityImpl extends DiameterActivityImpl implements SLgSessionActivity, StateChangeListener<AppSession> {

  private static final long serialVersionUID = 1L;

  protected boolean terminated = false;

  protected transient SLgMessageFactoryImpl slgMessageFactory = null;
  protected transient SLgAVPFactory slgAvpFactory = null;

  protected transient DiameterMessage lastRequest = null;
  protected transient ArrayList<DiameterAvp> sessionAvps = new ArrayList<DiameterAvp>();

  public SLgSessionActivityImpl(SLgMessageFactory messageFactory, SLgAVPFactory avpFactory, Session session, EventListener<Request, Answer> raEventListener, DiameterIdentity destinationHost, DiameterIdentity destinationRealm) {
    super(null, null, session, raEventListener, destinationHost, destinationRealm);

    this.slgMessageFactory = (SLgMessageFactoryImpl) messageFactory;
    this.slgAvpFactory = avpFactory;
  }

  public SLgAVPFactory getSLgAvpFactory() {
    return this.slgAvpFactory;
  }

  public SLgMessageFactory getSLgMessageFactory() {
    return (SLgMessageFactory) this.slgMessageFactory;
  }

  public void setSLgMessageFactory(SLgMessageFactoryImpl slgMessageFactory) {
    this.slgMessageFactory = slgMessageFactory;
  }

  public void setSLgAvpFactory(SLgAVPFactory slgAvpFactory) {
    this.slgAvpFactory = slgAvpFactory;
  }

  public String getSessionId() {
    return session.getSessionId();
  }

  public void fetchSessionData(DiameterMessage slgRequest) {
    this.lastRequest = slgRequest;
  }

  /**
   * Fills message with session AVPs if present and/or needed.
   *
   * @param message
   */
  protected void fillSessionAVPs(DiameterMessage message) {
    // If there's Destination-Host/Realm, add the AVPs
    if (message.getHeader().isRequest()) {
      if (destinationHost != null) {
        message.setDestinationHost(destinationHost);
      }

      if (destinationRealm != null) {
        message.setDestinationRealm(destinationRealm);
      }
    }

    // Fill extension avps if present
    if (sessionAvps.size() > 0) {
      try {
        message.setExtensionAvps(sessionAvps.toArray(new DiameterAvp[sessionAvps.size()]));
      } catch (AvpNotAllowedException e) {
        logger.error("Failed to add Session AVPs to request.", e);
      }
    }

    // Guarantee session-id is present
    if (!message.hasSessionId() && sessionId != null) {
      message.setSessionId(sessionId);
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (terminated ? 1231 : 1237);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    SLgSessionActivityImpl other = (SLgSessionActivityImpl) obj;
    if (terminated != other.terminated) {
      return false;
    }
    return true;
  }

}
