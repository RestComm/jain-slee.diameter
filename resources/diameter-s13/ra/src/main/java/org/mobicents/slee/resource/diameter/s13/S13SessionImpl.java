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

import java.util.ArrayList;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.AvpNotAllowedException;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.s13.S13AVPFactory;
import net.java.slee.resource.diameter.s13.S13MessageFactory;
import net.java.slee.resource.diameter.s13.S13SessionActivity;

import org.jdiameter.api.Answer;
import org.jdiameter.api.EventListener;
import org.jdiameter.api.Request;
import org.jdiameter.api.Session;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.app.StateChangeListener;
import org.mobicents.slee.resource.diameter.base.DiameterActivityImpl;

/**
 * Implementation for {@link S13SessionActivity}
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public abstract class S13SessionImpl extends DiameterActivityImpl implements S13SessionActivity, StateChangeListener<AppSession>{

  private static final long serialVersionUID = 4374137032596394588L;

  protected boolean terminated = false;

  protected transient S13MessageFactoryImpl s13MessageFactory = null;
  protected transient S13AVPFactory s13AvpFactory = null;

  protected transient DiameterMessage lastRequest = null;
  protected transient ArrayList<DiameterAvp> sessionAvps = new ArrayList<DiameterAvp>();

  public S13SessionImpl(S13MessageFactory messageFactory, S13AVPFactory avpFactory, Session session, EventListener<Request, Answer> raEventListener, DiameterIdentity destinationHost, DiameterIdentity destinationRealm) {
    super(null, null, session, raEventListener, destinationHost, destinationRealm);

    this.s13MessageFactory = (S13MessageFactoryImpl) messageFactory;
    this.s13AvpFactory = avpFactory;
  }

  public S13AVPFactory getS13AvpFactory() {
    return this.s13AvpFactory;
  }

  public S13MessageFactory getS13MessageFactory() {
    return this.s13MessageFactory;
  }

  public void setS13MessageFactory(S13MessageFactoryImpl s13MessageFactory) {
    this.s13MessageFactory = s13MessageFactory;
  }

  public void setS13AvpFactory(S13AVPFactory s13AvpFactory) {
    this.s13AvpFactory = s13AvpFactory;
  }

  public String getSessionId() {
    return session.getSessionId();
  }

  public void fetchSessionData(DiameterMessage s13Request) {
    this.lastRequest = s13Request;
  }

  /**
   * Fills message with session AVPs if present and/or needed.
   * 
   * @param message
   */
  protected void fillSessionAVPs(DiameterMessage message) {
    // If there's Destination-Host/Realm, add the AVPs
    if(message.getHeader().isRequest()) {
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
      }
      catch (AvpNotAllowedException e) {
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
    S13SessionImpl other = (S13SessionImpl) obj;
    if (terminated != other.terminated) {
      return false;
    }
    return true;
  }

}
