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

import net.java.slee.resource.diameter.base.events.DiameterHeader;
import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.s13.S13MessageFactory;
import net.java.slee.resource.diameter.s13.events.MEIdentityCheckRequest;

import org.apache.log4j.Logger;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.Message;
import org.jdiameter.api.Session;
import org.jdiameter.api.Stack;
import org.mobicents.slee.resource.diameter.base.DiameterMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.base.events.ExtensionDiameterMessageImpl;
import org.mobicents.slee.resource.diameter.s13.events.MEIdentityCheckAnswerImpl;
import org.mobicents.slee.resource.diameter.s13.events.MEIdentityCheckRequestImpl;

/**
 * Diameter S13 Reference Point Message Factory. Implementation for {@link S13MessageFactory}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class S13MessageFactoryImpl extends DiameterMessageFactoryImpl implements S13MessageFactory {

  private static Logger logger = Logger.getLogger(S13MessageFactoryImpl.class);

  private DiameterAvp[] EMPTY_AVP_ARRAY = new DiameterAvp[]{};

  // S13: Vendor-Specific-Application-Id is set as optional and may be discarded in future releases; No Auth-Application-Id either;
  private ApplicationId s13AppId = ApplicationId.createByAuthAppId(_S13_VENDOR, _S13_AUTH_APP_ID);

  /**
   * @param session
   * @param stack
   * @param avps
   */
  public S13MessageFactoryImpl(Session session, Stack stack, DiameterIdentity... avps) {
    super(session, stack, avps);
  }

  /**
   * @param stack
   */
  public S13MessageFactoryImpl(Stack stack) {
    super(stack);
  }

  public void setApplicationId(long vendorId, long applicationId) {
    this.s13AppId = ApplicationId.createByAuthAppId(vendorId, applicationId);      
  }
  
  public ApplicationId getApplicationId() {
    return this.s13AppId;      
  }
  
  /**
   * Creates a S13 Message with specified command-code and avps filled. If a header is present an answer will be created, if not
   * it will generate a request.
   * 
   * @param diameterHeader
   * @param avps
   * @param _commandCode
   * @param appId
   * @return
   * @throws InternalException
   */
  DiameterMessage createS13Message(DiameterHeader diameterHeader, DiameterAvp[] avps, int _commandCode, ApplicationId appId) throws InternalException {

    boolean creatingRequest = diameterHeader == null;
    Message msg = null;

    if (!creatingRequest) {
      Message raw = createMessage(diameterHeader, avps, 0, appId);
      raw.setProxiable(diameterHeader.isProxiable());
      raw.setRequest(false);
      raw.setReTransmitted(false); // just in case. answers never have T flag set
      // FIXME ? raw.getAvps().removeAvp(Avp.AUTH_APPLICATION_ID);
      msg = raw;
    }
    else {
      Message raw = createMessage(diameterHeader, avps, _commandCode, appId);
      raw.setProxiable(true);
      raw.setRequest(true);
      msg = raw;
    }

    int commandCode = creatingRequest ? _commandCode : diameterHeader.getCommandCode();
    DiameterMessage diamMessage = null;

    switch (commandCode) {
      case MEIdentityCheckRequest.COMMAND_CODE:
        diamMessage = creatingRequest ? new MEIdentityCheckRequestImpl(msg) : new MEIdentityCheckAnswerImpl(msg);
        break;
      default:
        diamMessage = new ExtensionDiameterMessageImpl(msg);
    }

    // Finally, add Origin-Host and Origin-Realm, if not present.
    // FIXME: Alex: needed? addOriginHostAndRealm(diamMessage);

    if (!diamMessage.hasSessionId() && session != null) {
      diamMessage.setSessionId(session.getSessionId());
    }

    return diamMessage;
  }

  public MEIdentityCheckRequest createMEIdentityCheckRequest() {
    try {
      return (MEIdentityCheckRequest) createS13Message(null, EMPTY_AVP_ARRAY, MEIdentityCheckRequest.COMMAND_CODE, s13AppId);
    }
    catch (InternalException e) {
      logger.error("Failed to create Authentication-Information-Request", e);
    }

    return null;
  }

  public MEIdentityCheckRequest createMEIdentityCheckRequest(String sessionId) throws IllegalArgumentException {
    MEIdentityCheckRequest ecr = createMEIdentityCheckRequest();
    ecr.setSessionId(sessionId);
    return ecr;
  }
}
