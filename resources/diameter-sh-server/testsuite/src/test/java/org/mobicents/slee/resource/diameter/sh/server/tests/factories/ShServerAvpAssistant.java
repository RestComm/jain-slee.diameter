/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008-2011, Red Hat, Inc. and individual contributors
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

package org.mobicents.slee.resource.diameter.sh.server.tests.factories;

import net.java.slee.resource.diameter.sh.events.avp.DiameterShAvpCodes;
import net.java.slee.resource.diameter.sh.events.avp.SupportedFeaturesAvp;
import net.java.slee.resource.diameter.sh.events.avp.UserIdentityAvp;
import net.java.slee.resource.diameter.sh.events.avp.userdata.ShData;

import org.mobicents.slee.resource.diameter.sh.events.avp.SupportedFeaturesAvpImpl;
import org.mobicents.slee.resource.diameter.sh.events.avp.UserIdentityAvpImpl;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ObjectFactory;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserDataObjectFactoryImpl;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class ShServerAvpAssistant extends org.mobicents.slee.resource.diameter.base.tests.factories.AvpAssistant {

	public static ShServerAvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new ShServerAvpAssistant();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected ShServerAvpAssistant() throws Exception {
		super();

		typeValues.put(UserIdentityAvp.class, new UserIdentityAvpImpl(DiameterShAvpCodes.USER_IDENTITY, DiameterShAvpCodes.SH_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(UserIdentityAvp[].class, new UserIdentityAvpImpl[] { new UserIdentityAvpImpl(DiameterShAvpCodes.USER_IDENTITY, DiameterShAvpCodes.SH_VENDOR_ID, 0, 1,
				dummyAvpBytes) });

		typeValues.put(ShData.class, new UserDataObjectFactoryImpl(new ObjectFactory()).createShData());
		typeValues.put(ShData[].class, new ShData[] { new UserDataObjectFactoryImpl(new ObjectFactory()).createShData() });

		typeValues.put(SupportedFeaturesAvp.class, new SupportedFeaturesAvpImpl(DiameterShAvpCodes.SUPPORTED_FEATURES, DiameterShAvpCodes.SH_VENDOR_ID, 0, 1, dummyAvpBytes));
		typeValues.put(SupportedFeaturesAvp[].class, new SupportedFeaturesAvpImpl[] { new SupportedFeaturesAvpImpl(DiameterShAvpCodes.SUPPORTED_FEATURES,
				DiameterShAvpCodes.SH_VENDOR_ID, 0, 1, dummyAvpBytes) });

	}

}
