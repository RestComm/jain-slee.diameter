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

package org.mobicents.slee.resource.diameter.base.tests.factories;

import static org.jdiameter.client.impl.helpers.Parameters.*;
import static org.jdiameter.server.impl.helpers.Parameters.*;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import net.java.slee.resource.diameter.base.events.AccountingRequest;
import net.java.slee.resource.diameter.base.events.CapabilitiesExchangeRequest;
import net.java.slee.resource.diameter.base.events.DeviceWatchdogRequest;
import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.DisconnectPeerRequest;
import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.base.events.avp.AddressType;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.base.events.avp.DiameterURI;
import net.java.slee.resource.diameter.base.events.avp.Enumerated;
import net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp;
import net.java.slee.resource.diameter.base.events.avp.FailedAvp;
import net.java.slee.resource.diameter.base.events.avp.IPFilterRule;
import net.java.slee.resource.diameter.base.events.avp.ProxyInfoAvp;
import net.java.slee.resource.diameter.base.events.avp.VendorSpecificApplicationIdAvp;

import org.jdiameter.api.Avp;
import org.jdiameter.api.AvpSet;
import org.jdiameter.api.Message;
import org.jdiameter.api.Stack;
import org.jdiameter.api.validation.AvpRepresentation;
import org.jdiameter.client.impl.helpers.EmptyConfiguration;
import org.jdiameter.common.impl.validation.DictionaryImpl;
import org.junit.Assert;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.ExperimentalResultAvpImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.FailedAvpImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.ProxyInfoAvpImpl;
import org.mobicents.slee.resource.diameter.base.events.avp.VendorSpecificApplicationIdAvpImpl;

/**
 * 
 * Aux Class for assisting in testing AVP setters/getters
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 */
public class AvpAssistant {

	protected static String clientHost = "127.0.0.1";

	protected static String serverHost = "localhost";

	protected static String realmName = "mobicents.org";

	protected static final HashMap<Class<?>, Object> typeValues = new HashMap<Class<?>, Object>();

	public static final Collection<String> methodsToIgnore = new ArrayList<String>();

	public static final Collection<String> methodsToIgnoreInRequest = new ArrayList<String>();

	public static final Collection<String> methodsToIgnoreInAnswer = new ArrayList<String>();

	public static final Collection<String> methodsToIgnoreInCEX = new ArrayList<String>();

	public static final Collection<String> methodsToIgnoreInDPX = new ArrayList<String>();

	public static final Collection<String> methodsToIgnoreInDWX = new ArrayList<String>();

	public static final Collection<String> methodsToIgnoreInRfACR = new ArrayList<String>();

	protected byte[] dummyAvpBytes = "not-initialized".getBytes();

	public static AvpAssistant INSTANCE;

	static {
		try {
			INSTANCE = new AvpAssistant();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected AvpAssistant() throws Exception {
		methodsToIgnore.add("getAvps");
		methodsToIgnore.add("getCommand");
		methodsToIgnore.add("getExtensionAvps");
		methodsToIgnore.add("setExtensionAvps");
		methodsToIgnore.add("getGenericData");

		methodsToIgnore.add("getHeader");
		methodsToIgnore.add("getClass");
		methodsToIgnore.add("getCode");
		methodsToIgnore.add("getVendorId");
		methodsToIgnore.add("getMandatoryRule");
		methodsToIgnore.add("getProtectedRule");
		methodsToIgnore.add("getName");
		methodsToIgnore.add("getType");

		methodsToIgnore.add("hasExtensionAvps");
		methodsToIgnore.add("hashCode");

		methodsToIgnoreInRequest.add("getResultCode");

		methodsToIgnoreInAnswer.add("getDestinationHost");
		methodsToIgnoreInAnswer.add("getDestinationRealm");

		methodsToIgnoreInCEX.add("getDestinationHost");
		methodsToIgnoreInCEX.add("getDestinationRealm");
		methodsToIgnoreInCEX.add("getSessionId");

		methodsToIgnoreInDPX.add("getDestinationHost");
		methodsToIgnoreInDPX.add("getDestinationRealm");
		methodsToIgnoreInDPX.add("getSessionId");

		methodsToIgnoreInDWX.add("getDestinationHost");
		methodsToIgnoreInDWX.add("getDestinationRealm");
		methodsToIgnoreInDWX.add("getSessionId");

		methodsToIgnoreInRfACR.add("getLocationType");
		methodsToIgnoreInRfACR.add("setLocationType");
		methodsToIgnoreInRfACR.add("hasLocationType");

		Stack stack = new org.jdiameter.client.impl.StackImpl();
		stack.init(new MyConfiguration());
		Message createMessage = stack.getSessionFactory().getNewRawSession().createMessage(0, org.jdiameter.api.ApplicationId.createByAccAppId(0L));
		AvpSet rawAvp = createMessage.getAvps();
		rawAvp.addGroupedAvp(0).addAvp(Avp.ERROR_MESSAGE, "pwning_more", true);
		dummyAvpBytes = rawAvp.getAvp(0).getRawData();

		typeValues.put(String.class, "alexandre_and_bartosz_pwn_diameter");
		typeValues.put(String[].class, new String[] { "alexandre_and_bartosz_pwn_diameter" });

		typeValues.put(int.class, 2805);
		typeValues.put(int[].class, new int[] { 2805 });

		typeValues.put(Integer.class, 2805);
		typeValues.put(Integer[].class, new Integer[] { 2805 });

		typeValues.put(long.class, 28052009L);
		typeValues.put(long[].class, new long[] { 28052009L });

		typeValues.put(Long.class, 28052009L);
		typeValues.put(Long[].class, new Long[] { 28052009L });

		typeValues.put(short.class, 28);
		typeValues.put(short[].class, new short[] { 28 });

		typeValues.put(Short.class, 28);
		typeValues.put(Short[].class, new Short[] { 28 });

		typeValues.put(boolean.class, true);
		typeValues.put(boolean[].class, new boolean[] { true });

		typeValues.put(Boolean.class, true);
		typeValues.put(Boolean[].class, new Boolean[] { true });

		typeValues.put(Date.class, new Date(1243500000000L));
		typeValues.put(Date[].class, new Date[] { new Date(1243500000000L) });

		typeValues.put(DiameterIdentity.class, new DiameterIdentity("diameter.mobicents.org"));
		typeValues.put(DiameterIdentity[].class, new DiameterIdentity[] { new DiameterIdentity("diameter.mobicents.org") });

		typeValues.put(DiameterURI.class, new DiameterURI("aaa://diameter.mobicents.org"));
		typeValues.put(DiameterURI[].class, new DiameterURI[] { new DiameterURI("aaa://diameter.mobicents.org") });

		typeValues.put(Address.class, new Address(AddressType.ADDRESS_IP, "127.0.0.2".getBytes()));
		typeValues.put(Address[].class, new Address[] { new Address(AddressType.ADDRESS_IP, "127.0.0.2".getBytes()) });

		typeValues.put(byte.class, (byte) 'm');
		typeValues.put(byte[].class, "mobicents".getBytes());

		typeValues.put(byte[][].class, new byte[][] { { (byte) 'm' }, { (byte) 'm' } });

		typeValues.put(Byte.class, Byte.valueOf((byte) 'M'));
		typeValues.put(Byte[].class, new Byte[] { Byte.valueOf((byte) 'M') });

		typeValues.put(ProxyInfoAvp.class, new ProxyInfoAvpImpl(Avp.PROXY_INFO, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(ProxyInfoAvp[].class, new ProxyInfoAvpImpl[] { new ProxyInfoAvpImpl(Avp.PROXY_INFO, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(VendorSpecificApplicationIdAvp.class, new VendorSpecificApplicationIdAvpImpl(Avp.VENDOR_SPECIFIC_APPLICATION_ID, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(VendorSpecificApplicationIdAvp[].class, new VendorSpecificApplicationIdAvpImpl[] { new VendorSpecificApplicationIdAvpImpl(Avp.VENDOR_SPECIFIC_APPLICATION_ID,
				0L, 0, 1, dummyAvpBytes) });

		typeValues.put(ExperimentalResultAvp.class, new ExperimentalResultAvpImpl(Avp.EXPERIMENTAL_RESULT, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(ExperimentalResultAvp[].class, new ExperimentalResultAvpImpl[] { new ExperimentalResultAvpImpl(Avp.EXPERIMENTAL_RESULT, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(FailedAvp.class, new FailedAvpImpl(Avp.FAILED_AVP, 0L, 0, 1, dummyAvpBytes));
		typeValues.put(FailedAvp[].class, new FailedAvpImpl[] { new FailedAvpImpl(Avp.FAILED_AVP, 0L, 0, 1, dummyAvpBytes) });

		typeValues.put(IPFilterRule.class, new IPFilterRule("permit in ip from 192.168.0.0/24 10,11,12,20-30 to 192.168.1.1 99 frag established"));
		typeValues.put(IPFilterRule[].class, new IPFilterRule[] { new IPFilterRule("permit in ip from 192.168.0.0/24 10,11,12,20-30 to 192.168.1.1 99 frag established") });

	}

	public static Object getValueFromEnumerated(Class<?> clazz) throws IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Class<?> realClazz = clazz.isArray() ? clazz.getComponentType() : clazz;

		for (Class<?> interfaze : realClazz.getInterfaces()) {
			if (interfaze == Enumerated.class) {
				Object object = null;

				for (Field f : realClazz.getFields()) {
					if (f.getType() == realClazz) {
						object = f.get(null);
						break;
					}
				}

				if (object != null && clazz.isArray()) {
					Object array = Array.newInstance(realClazz, 1);
					Array.set(array, 0, object);
					return array;
				}
				return object;
			}
		}

		return null;
	}

	public static Object getValueFromClass(Class<?> clazz) {
		return typeValues.get(clazz);
	}

	protected static void clearAVPsInMessage(DiameterMessage message) {
		// Clear all AVP's...
		AvpSet set = ((DiameterMessageImpl) message).getGenericData().getAvps();
		while (set.size() > 0)
			set.removeAvpByIndex(0);
	}

	public int testMethods(DiameterMessage message, Class<?> interfaze) throws Exception {
		System.out.println(":::::::: Testing accessors for Class " + message.getClass().getSimpleName() + " ::::::::");

		int nFailures = 0;

		for (Method m : interfaze.getMethods()) {
			clearAVPsInMessage(message);

			int commandCode = message.getCommand().getCode();

			String methodName = m.getName();

			if (AvpAssistant.methodsToIgnore.contains(methodName)) {
				continue;
			}
			else if (message.getHeader().isRequest() && AvpAssistant.methodsToIgnoreInRequest.contains(methodName)) {
				continue;
			}
			else if (!message.getHeader().isRequest() && AvpAssistant.methodsToIgnoreInAnswer.contains(methodName)) {
				continue;
			}
			else if (commandCode == CapabilitiesExchangeRequest.commandCode && AvpAssistant.methodsToIgnoreInCEX.contains(methodName)) {
				continue;
			}
			else if (commandCode == DeviceWatchdogRequest.commandCode && AvpAssistant.methodsToIgnoreInDWX.contains(methodName)) {
				continue;
			}
			else if (commandCode == DisconnectPeerRequest.commandCode && AvpAssistant.methodsToIgnoreInDPX.contains(methodName)) {
				continue;
			}
			else if (commandCode == AccountingRequest.commandCode && AvpAssistant.methodsToIgnoreInRfACR.contains(methodName)) {
				continue;
			}
			else if (methodName.startsWith("get")) {
				Class<?> avpType = m.getReturnType();

				Object toGo = AvpAssistant.getValueFromEnumerated(avpType);

				if (toGo == null)
					toGo = AvpAssistant.getValueFromClass(avpType);

				if (toGo != null) {
					Method hasser = null;

					try {
						hasser = interfaze.getMethod(getSingularMethodName(methodName.replaceFirst("get", "has")));

						Object hasAvpBeforeSet = hasser.invoke(message);

						Assert.assertFalse("Message already has value before setting for " + methodName.replaceAll("get", "") + "... aborting", (Boolean) hasAvpBeforeSet);
					}
					catch (NoSuchMethodException e) {
						// skip it...
					}

					Method setter = interfaze.getMethod(methodName.replaceFirst("g", "s"), avpType);

					// System.out.println("Setting value " + setter.getName() +"(" + toGo.toString() +")");

					setter.invoke(message, toGo);

					if (hasser != null) {
						Object hasAvpAfterSet = hasser.invoke(message);

						Assert.assertTrue("Message does not has value after setting for " + methodName.replaceAll("get", "") + "... aborting", (Boolean) hasAvpAfterSet);
					}

					// System.out.println("Current message: \r\n" + snr);

					Object obtained = m.invoke(message);
					// System.out.println("Got value " + obtained.toString());
					boolean passed = false;
					try {
						if (avpType == byte[].class) {
							passed = Arrays.equals((byte[]) toGo, (byte[]) obtained);
						}
						else if (avpType == long[].class) {
							passed = Arrays.equals((long[]) toGo, (long[]) obtained);
						}
						else {
							passed = (avpType.isArray() ? Arrays.equals((Object[]) toGo, (Object[]) obtained) : obtained.equals(toGo));
						}
					}
					catch (Exception e) {
						e.printStackTrace();
						// ignore... we fail!
					}

					// Validate AVP Flags
					ArrayList<String> failedAvpFlags = checkAvpFlags(((DiameterMessageImpl) message).getGenericData().getAvps());
					if (failedAvpFlags.size() > 0) {
						System.err.println("The following AVPs flags have failed to check against dictionary:");
						for (String failedAvpFlag : failedAvpFlags) {
							System.err.println(failedAvpFlag);
						}
						Assert.fail(failedAvpFlags.toString());
					}

					nFailures = passed ? nFailures : nFailures + 1;
					System.out.println("[" + (passed ? "PASSED" : "FAILED") + "] " + methodName.replace("get", "") + " with param of type '" + avpType.getName() + "' "
							+ (hasser != null ? " WITH has" : " WITHOUT has"));
				}
				else {
					System.out.println("[??????] Unable to test " + methodName.replace("get", "") + " with param of type '" + avpType.getName() + "'.");
					Assert.fail("Missing AVP Implementation class to test " + methodName);
				}
			}
		}

		return nFailures;
	}

	public int testMethods(DiameterAvp avp, Class<?> interfaze) throws Exception {
		System.out.println(":::::::: Testing accessors for Class " + avp.getClass().getSimpleName() + " ::::::::");

		int nFailures = 0;

		for (Method m : interfaze.getMethods()) {
			// clearAVPsInMessage(message);

			// int commandCode = message.getCommand().getCode();

			String methodName = m.getName();

			if (AvpAssistant.methodsToIgnore.contains(methodName)) {
				continue;
			}
			else if (methodName.startsWith("get")) {
				Class<?> avpType = m.getReturnType();

				Object toGo = AvpAssistant.getValueFromEnumerated(avpType);

				if (toGo == null)
					toGo = AvpAssistant.getValueFromClass(avpType);

				if (toGo != null) {
					Method hasser = null;

					try {
						hasser = interfaze.getMethod(getSingularMethodName(methodName.replaceFirst("get", "has")));

						Object hasAvpBeforeSet = hasser.invoke(avp);

						Assert.assertFalse("Message already has value before setting for " + methodName.replaceAll("get", "") + "... aborting", (Boolean) hasAvpBeforeSet);
					}
					catch (NoSuchMethodException e) {
						// skip it...
					}

					Method setter = interfaze.getMethod(methodName.replaceFirst("g", "s"), avpType);

					// System.out.println("Setting value " + setter.getName() +"(" + toGo.toString() +")");

					setter.invoke(avp, toGo);

					if (hasser != null) {
						Object hasAvpAfterSet = hasser.invoke(avp);

						Assert.assertTrue("Message does not has value after setting for " + methodName.replaceAll("get", "") + "... aborting", (Boolean) hasAvpAfterSet);
					}

					// System.out.println("Current message: \r\n" + snr);

					Object obtained = m.invoke(avp);
					// System.out.println("Got value " + obtained.toString());
					boolean passed = false;
					try {
						if (avpType == byte[].class) {
							passed = Arrays.equals((byte[]) toGo, (byte[]) obtained);
						}
						else if (avpType == long[].class) {
							passed = Arrays.equals((long[]) toGo, (long[]) obtained);
						}
						else {
							passed = (avpType.isArray() ? Arrays.equals((Object[]) toGo, (Object[]) obtained) : obtained.equals(toGo));
						}
					}
					catch (Exception e) {
						e.printStackTrace();
						// ignore... we fail!
					}

					// Validate AVP Flags
					ArrayList<String> failedAvpFlags = checkAvpFlags(((GroupedAvpImpl) avp).getGenericData());
					if (failedAvpFlags.size() > 0) {
						System.err.println("The following AVPs flags have failed to check against dictionary:");
						for (String failedAvpFlag : failedAvpFlags) {
							System.err.println(failedAvpFlag);
						}
						Assert.fail(failedAvpFlags.toString());
					}

					nFailures = passed ? nFailures : nFailures + 1;
					System.out.println("[" + (passed ? "PASSED" : "FAILED") + "] " + methodName.replace("get", "") + " with param of type '" + avpType.getName() + "' "
							+ (hasser != null ? " WITH has" : " WITHOUT has"));
				}
				else {
					System.out.println("[??????] Unable to test " + methodName.replace("get", "") + " with param of type '" + avpType.getName() + "'.");
					Assert.fail("Missing AVP Implementation class to test " + methodName);
				}
			}
		}

		return nFailures;
	}

	public void testSetters(Object object) throws Exception {
		for (Method m : object.getClass().getMethods()) {
			if (!methodsToIgnore.contains(m.getName()) && m.getName().startsWith("set")) {
				// System.out.println("==> " + m.getName() + " <==");
				Class<?>[] pTypes = m.getParameterTypes();

				Object[] params = new Object[pTypes.length];

				for (int i = 0; i < params.length; i++) {
					params[i] = AvpAssistant.getValueFromEnumerated(pTypes[i]);

					if (params[i] == null) {
						params[i] = getValueFromClass(pTypes[i]);
					}

					if (params[i] == null) {
						System.out.println("Could not find value for " + pTypes[i]);
						throw new NullPointerException("Could not find value for " + pTypes[i]);
					}
				}

				m.invoke(object, params);
			}
		}
	}

	public void testGetters(Object object) throws Exception {
		for (Method m : object.getClass().getMethods()) {
			if (!methodsToIgnore.contains(m.getName()) && m.getName().startsWith("get")) {
				// System.out.println("==> " + m.getName() + " <==");
				Class<?> rType = m.getReturnType();

				if (rType.isArray() && rType != byte[].class) {
					continue;
				}

				Object expected = AvpAssistant.getValueFromEnumerated(rType);

				if (expected == null) {
					expected = getValueFromClass(rType);
				}

				if (expected == null) {
					System.out.println("Could not find value for " + rType + " in method " + m.getName());
					throw new NullPointerException("Could not find value for " + rType + " in method " + m.getName());
				}

				Object obtained = m.invoke(object);

				boolean passed;
				if (rType == byte[].class) {
					passed = Arrays.equals((byte[]) expected, (byte[]) obtained);
				}
				else if (rType == long[].class) {

					passed = Arrays.equals((long[]) expected, (long[]) obtained);
				}
				else if (rType.isArray()) {
					passed = Arrays.equals((Object[]) expected, (Object[]) obtained);
				}
				else {
					passed = obtained.equals(expected);
				}

				if (!passed)
					Assert.fail("Getter " + m.getName() + " did not return expected value.");
			}
		}
	}

	public void testHassers(Object object, boolean expected) throws Exception {
		for (Method m : object.getClass().getMethods()) {
			if (!methodsToIgnore.contains(m.getName()) && m.getName().startsWith("has")) {

				Object obtained = m.invoke(object);

				Assert.assertEquals("Hasser " + m.getName() + " did not return expected value.", expected, obtained);
			}
		}
	}

	protected static String getSingularMethodName(String pluralMethodName) {
		if (pluralMethodName.endsWith("eses"))
			return pluralMethodName.substring(0, pluralMethodName.length() - 2);
		else if (pluralMethodName.endsWith("s"))
			return pluralMethodName.substring(0, pluralMethodName.length() - 1);
		else
			return pluralMethodName;
	}

	/**
	 * 
	 * @param set
	 *          the set to check
	 * @return an array of offending AVPs
	 */
	protected static ArrayList<String> checkAvpFlags(AvpSet set) {
		ArrayList<String> failedAvps = new ArrayList<String>();

		for (Avp avp : set) {
			// System.out.println(avp.getVendorId() + ":" + avp.getCode() + " V[" + avp.isVendorId() + "] M[" +
			// avp.isMandatory() + "] P[" + avp.isEncrypted() + "]");
			AvpRepresentation avpRep = DictionaryImpl.INSTANCE.getAvp(avp.getCode(), avp.getVendorId());
			// System.out.println(avpRep.getVendorId() + ":" + avpRep.getCode() + " V[" + avpRep.getRuleVendorBit() + "] M[" +
			// avpRep.getRuleMandatory() + "] P[" + avpRep.getRuleProtected() + "]");

			// Mandatory must not be set if rule is MUST NOT or SHOULD NOT
			if (avp.isMandatory() && (avpRep.getRuleMandatory().equals("mustnot") || avpRep.getRuleMandatory().equals("shouldnot"))) {
				failedAvps.add("- Code[" + avp.getCode() + "], Vendor-Id[" + avp.getVendorId() + "], Flag[M / '" + avp.isMandatory() + "' vs '" + avpRep.getRuleMandatory() + "']");
			}

			// Protected must not be set if rule is MUST or MAY
			if (avp.isEncrypted() && !(avpRep.getRuleProtected().equals("must") || avpRep.getRuleProtected().equals("may"))) {
				failedAvps.add("- Code[" + avp.getCode() + "], Vendor-Id[" + avp.getVendorId() + "], Flag[P / '" + avp.isEncrypted() + "' vs '" + avpRep.getRuleProtected() + "']");
			}

			// Vendor must be set if rule is MUST or MAY
			if (avp.isEncrypted() && !(avpRep.getRuleProtected().equals("must") || avpRep.getRuleProtected().equals("may"))) {
				failedAvps.add("- Code[" + avp.getCode() + "], Vendor-Id[" + avp.getVendorId() + "], Flag[P / '" + avp.isEncrypted() + "' vs '" + avpRep.getRuleProtected() + "']");
			}

			AvpSet subAvps = null;
			try {
				subAvps = avp.getGrouped();
			}
			catch (Exception e) {
			}

			if (subAvps != null) {
				failedAvps.addAll(checkAvpFlags(subAvps));
			}
		}

		return failedAvps;
	}

	public static class MyConfiguration extends EmptyConfiguration {

		public MyConfiguration() {
			super();

			add(Assembler, Assembler.defValue());
			add(OwnDiameterURI, "aaa://localhost");
			add(OwnRealm, "dummy");
			add(OwnVendorID, 193L);
			// Set Ericsson SDK feature
			// add(UseUriAsFqdn, true);
			// Set Common Applications
			add(org.jdiameter.client.impl.helpers.Parameters.ApplicationId,
			// AppId 1
					getInstance().add(VendorId, 193L).add(AuthApplId, 0L).add(AcctApplId, 19302L));
			// Set peer table
			add(PeerTable,
			// Peer 1
					getInstance().add(PeerRating, 1).add(PeerName, "aaa://localhost"));
			// Set realm table
			add(RealmTable,
					// Realm 1
					getInstance().add(
							RealmEntry,
							getInstance().add(RealmName, realmName).add(ApplicationId, getInstance().add(VendorId, 193L).add(AuthApplId, 0L).add(AcctApplId, 19302L))
									.add(RealmHosts, clientHost + ", " + serverHost).add(RealmLocalAction, "LOCAL").add(RealmEntryIsDynamic, false).add(RealmEntryExpTime, 1000L)));
		}
	}

}
