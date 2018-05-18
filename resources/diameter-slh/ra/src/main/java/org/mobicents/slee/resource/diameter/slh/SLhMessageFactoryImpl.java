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

package org.mobicents.slee.resource.diameter.slh;

import net.java.slee.resource.diameter.base.events.DiameterHeader;
import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slh.SLhMessageFactory;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;

import org.apache.log4j.Logger;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.Message;
import org.jdiameter.api.Session;
import org.jdiameter.api.Stack;
import org.mobicents.slee.resource.diameter.base.DiameterMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.base.events.ExtensionDiameterMessageImpl;
import org.mobicents.slee.resource.diameter.slh.events.LCSRoutingInfoAnswerImpl;
import org.mobicents.slee.resource.diameter.slh.events.LCSRoutingInfoRequestImpl;

/**
 * Diameter SLh Reference Point Message Factory. Implementation of {@link SLhMessageFactory}.
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class SLhMessageFactoryImpl extends DiameterMessageFactoryImpl implements SLhMessageFactory {

  protected Logger logger = Logger.getLogger(SLhMessageFactoryImpl.class);

  private DiameterAvp[] EMPTY_AVP_ARRAY = new DiameterAvp[]{};

  // S6a: Vendor-Specific-Application-Id is set as optional and may be discarded in future releases; No Auth-Application-Id either;
  private ApplicationId slhAppId = ApplicationId.createByAuthAppId(_SLh_TGPP_VENDOR_ID, _SLh_AUTH_APP_ID);

  /**
   * @param session
   * @param stack
   * @param avps
   */
  public SLhMessageFactoryImpl(Session session, Stack stack, DiameterIdentity... avps) {
    super(session, stack, avps);
  }

  /**
   * @param stack
   */
  public SLhMessageFactoryImpl(Stack stack) {
    super(stack);
  }

  public void setApplicationId(long vendorId, long applicationId) {
    this.slhAppId = ApplicationId.createByAuthAppId(vendorId, applicationId);
  }

  public ApplicationId getApplicationId() {
    return this.slhAppId;
  }

  /**
   * Creates a SLh Message with specified command-code and avps filled. If a header is present an answer will be created, if not
   * it will generate a request.
   *
   * @param diameterHeader
   * @param avps
   * @param _commandCode
   * @param appId
   * @return
   * @throws InternalException
   */
  DiameterMessage createSLhMessage(DiameterHeader diameterHeader, DiameterAvp[] avps, int _commandCode, ApplicationId appId) throws InternalException {

    boolean creatingRequest = diameterHeader == null;
    Message msg = null;

    if (!creatingRequest) {
      Message raw = createMessage(diameterHeader, avps, 0, appId);
      raw.setProxiable(diameterHeader.isProxiable());
      raw.setRequest(false);
      raw.setReTransmitted(false); // just in case. answers never have T flag set
      // FIXME ? raw.getAvps().removeAvp(Avp.AUTH_APPLICATION_ID);
      msg = raw;
    } else {
      Message raw = createMessage(diameterHeader, avps, _commandCode, appId);
      raw.setProxiable(true);
      raw.setRequest(true);
      msg = raw;
    }

    int commandCode = creatingRequest ? _commandCode : diameterHeader.getCommandCode();
    DiameterMessage diamMessage;

    switch (commandCode) {
      case LCSRoutingInfoRequest.COMMAND_CODE:
        diamMessage = creatingRequest ? new LCSRoutingInfoRequestImpl(msg) : new LCSRoutingInfoAnswerImpl(msg);
        break;
      default:
        diamMessage = new ExtensionDiameterMessageImpl(msg);
    }

    // Finally, add Origin-Host and Origin-Realm, if not present.
    // FIXME: needed? addOriginHostAndRealm(diamMessage);

    if (!diamMessage.hasSessionId() && session != null) {
      diamMessage.setSessionId(session.getSessionId());
    }

    return diamMessage;
  }

  public LCSRoutingInfoRequest createLCSRoutingInfoRequest() {
    try {
      return (LCSRoutingInfoRequest) createSLhMessage(null, EMPTY_AVP_ARRAY, LCSRoutingInfoRequest.COMMAND_CODE, slhAppId);
    } catch (InternalException e) {
      logger.error("Failed to create LCS Routing-Info-Request", e);
    }
    return null;
  }

  public LCSRoutingInfoRequest createLCSRoutingInfoRequest(String sessionId) throws IllegalArgumentException {
    LCSRoutingInfoRequest rir = createLCSRoutingInfoRequest();
    rir.setSessionId(sessionId);
    return rir;
  }

}
