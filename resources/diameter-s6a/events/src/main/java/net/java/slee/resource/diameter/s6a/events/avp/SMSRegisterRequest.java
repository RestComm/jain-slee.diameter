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

package net.java.slee.resource.diameter.s6a.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.Serializable;

/**
 * Java class representing the SMS-Register-Request enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V12.8.0) specification:
 * 
 * <pre>
 *  7.3.162 SMS-Register-Request
 *
 *  The SMS-Register-Request AVP is of type Enumerated and it shall indicate whether the MME or the SGSN requires to
 *  be registered for SMS (e.g. SGs interface not supported) or if the MME or the SGSN prefers not to be registered for
 *  SMS or if the MME or the SGSN has no preference.
 *  The following values are defined:
 *      SMS_REGISTRATION_REQUIRED (0)
 *      SMS_REGISTRATION_NOT_PREFERRED (1)
 *      NO_PREFERENCE (2)
 *
 *  The criteria for setting these values are defined in 3GPP TS 23.272 [44] and 3GPP TS 23.060 [12].
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class SMSRegisterRequest implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _SMS_REGISTRATION_REQUIRED = 0;
  public static final int _SMS_REGISTRATION_NOT_PREFERRED = 1;
  public static final int _NO_PREFERENCE = 2;

  public static final SMSRegisterRequest SMS_REGISTRATION_REQUIRED = new SMSRegisterRequest(_SMS_REGISTRATION_REQUIRED);
  public static final SMSRegisterRequest SMS_REGISTRATION_NOT_PREFERRED = new SMSRegisterRequest(_SMS_REGISTRATION_NOT_PREFERRED);
  public static final SMSRegisterRequest NO_PREFERENCE = new SMSRegisterRequest(_NO_PREFERENCE);

  private int value = -1;

  private SMSRegisterRequest(int value) {
    this.value = value;
  }

  public static SMSRegisterRequest fromInt(int type) {
    switch (type) {
      case _SMS_REGISTRATION_REQUIRED:
        return SMS_REGISTRATION_REQUIRED;
      case _SMS_REGISTRATION_NOT_PREFERRED:
        return SMS_REGISTRATION_NOT_PREFERRED;
      case _NO_PREFERENCE:
        return NO_PREFERENCE;
      default:
        throw new IllegalArgumentException("Invalid value: " + type);
    }
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    switch (value) {
      case _SMS_REGISTRATION_REQUIRED:
        return "SMS_REGISTRATION_REQUIRED";
      case _SMS_REGISTRATION_NOT_PREFERRED:
        return "SMS_REGISTRATION_NOT_PREFERRED";
      case _NO_PREFERENCE:
        return "NO_PREFERENCE";
      default:
        return "<Invalid Value>";
    }
  }
}