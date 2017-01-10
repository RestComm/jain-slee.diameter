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

package org.mobicents.slee.resource.diameter.s13.events;

import net.java.slee.resource.diameter.s13.events.avp.EquipmentStatus;
import static net.java.slee.resource.diameter.s13.events.avp.DiameterS13AvpCodes.*;
import net.java.slee.resource.diameter.s13.events.MEIdentityCheckAnswer;

import net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp;
import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.ExperimentalResultAvpImpl;


/**
 * Implementation for {@link AuthenticationInformationAnswer}
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class MEIdentityCheckAnswerImpl extends DiameterMessageImpl implements MEIdentityCheckAnswer {

  /**
   * @param message
   */
  public MEIdentityCheckAnswerImpl(Message message) {
    super(message);
  }

  /* (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getLongName()
   */
  public String getLongName() {
    return "ME-Identity-Check-Answer";
  }

  /* (non-Javadoc)
   * @see org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl#getShortName()
   */
  public String getShortName() {
    return "ECA";
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#hasErrorDiagnostic()
   */
  public boolean hasEquipmentStatus() {
    return hasAvp(EQUIPMENT_STATUS, S13_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#getErrorDiagnostic()
   */
  public EquipmentStatus getEquipmentStatus() {
    return (EquipmentStatus) getAvpAsEnumerated(EQUIPMENT_STATUS, S13_VENDOR_ID, EquipmentStatus.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#setErrorDiagnostic(net.java.slee.resource.diameter.s13.events.avp.EquipmentStatus)
   */
  public void setEquipmentStatus(EquipmentStatus equipmentStatus) {
    addAvp(EQUIPMENT_STATUS, S13_VENDOR_ID, equipmentStatus.getValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#getAuthSessionState()
   */
  public AuthSessionStateType getAuthSessionState() {
    return (AuthSessionStateType) getAvpAsEnumerated(DiameterAvpCodes.AUTH_SESSION_STATE, AuthSessionStateType.class);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#getExperimentalResult()
   */
  public ExperimentalResultAvp getExperimentalResult() {
    return (ExperimentalResultAvp) getAvpAsCustom(DiameterAvpCodes.EXPERIMENTAL_RESULT, ExperimentalResultAvpImpl.class);
  }

  
  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#hasAuthSessionState()
   */
  public boolean hasAuthSessionState() {
    return hasAvp(DiameterAvpCodes.AUTH_SESSION_STATE);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#hasExperimentalResult()
   */
  public boolean hasExperimentalResult() {
    return hasAvp(DiameterAvpCodes.EXPERIMENTAL_RESULT);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#setAuthSessionState(net.java.slee.resource.diameter.base.events.avp.AuthSessionStateType)
   */
  public void setAuthSessionState(AuthSessionStateType authSessionState) {
    addAvp(DiameterAvpCodes.AUTH_SESSION_STATE, authSessionState.getValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#setExperimentalResult(net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp)
   */
  public void setExperimentalResult(ExperimentalResultAvp experimentalResult) {
    addAvp(DiameterAvpCodes.EXPERIMENTAL_RESULT, experimentalResult.byteArrayValue());
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.s13.events.AuthenticationInformationAnswer#setSupportedFeatures(net.java.slee.resource.diameter.s13.events.avp.SupportedFeaturesAvp)
   */
}
