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

import net.java.slee.resource.diameter.base.events.DiameterHeader;
import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;

import org.mobicents.slee.resource.diameter.base.DiameterMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.base.events.ExtensionDiameterMessageImpl;

import net.java.slee.resource.diameter.slg.SLgMessageFactory;
import net.java.slee.resource.diameter.slg.events.LocationReportRequest;
import net.java.slee.resource.diameter.slg.events.ProvideLocationRequest;

import org.mobicents.slee.resource.diameter.slg.events.ProvideLocationRequestImpl;
import org.mobicents.slee.resource.diameter.slg.events.ProvideLocationAnswerImpl;
import org.mobicents.slee.resource.diameter.slg.events.LocationReportRequestImpl;
import org.mobicents.slee.resource.diameter.slg.events.LocationReportAnswerImpl;

import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.Session;
import org.jdiameter.api.Stack;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.Message;

import org.apache.log4j.Logger;

/**
 * Implementation of {@link net.java.slee.resource.diameter.slg.SLgMessageFactory}.
 *
 * @author <a href="mailto:fernando.mendioroz@gmail.com"> Fernando Mendioroz </a>
 */
public class SLgMessageFactoryImpl extends DiameterMessageFactoryImpl implements SLgMessageFactory {

  private static Logger logger = Logger.getLogger(SLgMessageFactoryImpl.class);

  private DiameterAvp[] EMPTY_AVP_ARRAY = new DiameterAvp[]{};

  // SLg: Vendor-Specific-Application-Id is set as optional and may be discarded in future releases; No Auth-Application-Id either;
  private ApplicationId SLgAppId = ApplicationId.createByAuthAppId(_SLg_VENDOR, _SLg_AUTH_APP_ID);

  /**
   * @param session
   * @param stack
   * @param avps
   */
  public SLgMessageFactoryImpl(Session session, Stack stack, DiameterIdentity... avps) {
    super(session, stack, avps);
  }

  /**
   * @param stack
   */
  public SLgMessageFactoryImpl(Stack stack) {
    super(stack);
  }

  public void setApplicationId(long vendorId, long applicationId) {
    this.SLgAppId = ApplicationId.createByAuthAppId(vendorId, applicationId);
  }

  public ApplicationId getApplicationId() {
    return this.SLgAppId;
  }

  /**
   * Creates a SLg Message with specified command-code and avps filled. If a header is present an answer will be created, if not
   * it will generate a request.
   *
   * @param diameterHeader
   * @param avps
   * @param _commandCode
   * @param appId
   * @return
   * @throws InternalException
   */
  DiameterMessage createSLgMessage(DiameterHeader diameterHeader, DiameterAvp[] avps, int _commandCode, ApplicationId appId) throws InternalException {

    boolean creatingRequest = diameterHeader == null;
    Message msg;

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
    DiameterMessage diameterMessage;

    switch (commandCode) {
      case ProvideLocationRequest.COMMAND_CODE:
        diameterMessage = creatingRequest ? new ProvideLocationRequestImpl(msg) : new ProvideLocationAnswerImpl(msg);
        break;
      case LocationReportRequest.COMMAND_CODE:
        diameterMessage = creatingRequest ? new LocationReportRequestImpl(msg) : new LocationReportAnswerImpl(msg);
        break;
      default:
        diameterMessage = new ExtensionDiameterMessageImpl(msg);
    }

    // Finally, add Origin-Host and Origin-Realm, if not present.
    // FIXME: Alex: needed? addOriginHostAndRealm(diamMessage);

    if (!diameterMessage.hasSessionId() && session != null) {
      diameterMessage.setSessionId(session.getSessionId());
    }

    return diameterMessage;
  }

  public ProvideLocationRequest createProvideLocationRequest() {
    try {
      return (ProvideLocationRequest) createSLgMessage(null, EMPTY_AVP_ARRAY, ProvideLocationRequest.COMMAND_CODE, SLgAppId);
    } catch (InternalException e) {
      logger.error("Failed to create Provide-Location-Request", e);
    }

    return null;
  }

  public ProvideLocationRequest createProvideLocationRequest(String sessionId) throws IllegalArgumentException {
    ProvideLocationRequest plr = createProvideLocationRequest();
    plr.setSessionId(sessionId);
    return plr;
  }

  public LocationReportRequest createLocationReportRequest() {
    try {
      return (LocationReportRequest) createSLgMessage(null, EMPTY_AVP_ARRAY, LocationReportRequest.COMMAND_CODE, SLgAppId);
    } catch (InternalException e) {
      logger.error("Failed to create Location-Report-Request", e);
    }

    return null;
  }

  public LocationReportRequest createLocationReportRequest(String sessionId) throws IllegalArgumentException {
    LocationReportRequest lrr = createLocationReportRequest();
    lrr.setSessionId(sessionId);
    return lrr;
  }

}
