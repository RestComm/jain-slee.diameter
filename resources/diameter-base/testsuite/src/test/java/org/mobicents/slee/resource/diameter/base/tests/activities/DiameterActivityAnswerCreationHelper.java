package org.mobicents.slee.resource.diameter.base.tests.activities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import net.java.slee.resource.diameter.base.DiameterActivity;
import net.java.slee.resource.diameter.base.events.DiameterMessage;

import org.jdiameter.client.impl.parser.MessageImpl;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;

/**
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class DiameterActivityAnswerCreationHelper {

	public static void testAnswerCreation(DiameterActivity activity, String messageListFieldName, ArrayList<DiameterMessage> requestList) {
		try {
			Field f = activity.getClass().getDeclaredField(messageListFieldName);
			assertNotNull("There is no such field: " + messageListFieldName, f);
			f.setAccessible(true);
			boolean setOnIterate = false;
			if (f.get(activity) instanceof Collection) {
				f.set(activity, requestList);
			}
			else {
				setOnIterate = true;
			}

			for (DiameterMessage request : requestList) {
				if (setOnIterate) {
					f.set(activity, request);
				}
				DiameterMessageImpl requestImpl = (DiameterMessageImpl) request;
				// This is cause some of them are zeros :)
				((MessageImpl) requestImpl.getGenericData()).setEndToEndIdentifier((long) (Math.random() * 10000));
				((MessageImpl) requestImpl.getGenericData()).setHopByHopIdentifier((long) (Math.random() * 10000));
				Class<? extends DiameterActivity> activityClass = activity.getClass();
				String className = request.getClass().getName();
				String packageName = request.getClass().getPackage().getName();
				String methodName = "create" + (className.replace(packageName + ".", "").replace("RequestImpl", "Answer"));
				Method[] methods = activityClass.getMethods();
				// System.err.println("METHOD NAME: "+methodName);

				for (Method createAnswerMethod : methods) {
					if (!createAnswerMethod.getName().equals(methodName)) {
						// System.err.println("Skipping: "+createAnswerMethod.getName());
						continue;
					}

					// System.err.println("Doing magic for: "+createAnswerMethod.getName());
					// here we can have 3 types of methods:
					// #1 without parameters
					// #2 with long, boolean parameters
					// #3 with different param!!
					Object[] args = null;
					Class<?>[] parameters = createAnswerMethod.getParameterTypes();
					if (parameters.length == 0) {
						args = new Object[] {};
						// params are null
					}
					else {
						args = new Object[parameters.length];
						for (int i = 0; i < parameters.length; i++) {
							args[i] = instantiate(parameters[i]);
						}

					}
					// we only want to see that code matches and answer is not zero? do we want to test AVPs ?
					DiameterMessage answer = (DiameterMessage) createAnswerMethod.invoke(activity, args);
					assertNotNull("Answer is null for method name: " + methodName, answer);
					if (answer == null)
						return;

					// some basic tests, we don't test values passed, maybe we should ?
					assertEquals("Command code is not equal", request.getCommand().getCode(), answer.getCommand().getCode());
					assertFalse("Answer should have R flag set to false.", answer.getCommand().isRequest());
					assertEquals("E2E is not equal", request.getHeader().getEndToEndId(), answer.getHeader().getEndToEndId());
					assertEquals("HBH is not equal", request.getHeader().getHopByHopId(), answer.getHeader().getHopByHopId());
				}

			}

		}
		catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private static Object instantiate(Class<?> c) {
		Class<?> type = c;
		if (c.isArray()) {
			type = c.getComponentType();
		}

		if (type.getName().equals("boolean")) {
			boolean b = false;
			if (c.isArray()) {
				return new boolean[] { b };
			}
			return b;
		}

		if (type.getName().equals("long")) {
			long b = 0;
			if (c.isArray()) {
				return new long[] { b };
			}
			return b;
		}

		if (type.getName().equals("byte")) {
			byte b = 0;
			if (c.isArray()) {
				return new byte[] { b };
			}
			return b;
		}

		if (type.getName().equals("int")) {
			int b = 0;
			if (c.isArray()) {
				return new int[] { b };
			}
			return b;
		}

		if (type.getName().equals("char")) {
			char b = 0;
			if (c.isArray()) {
				return new char[] { b };
			}
			return b;
		}

		if (type.getName().equals("float")) {
			float b = 0;
			if (c.isArray()) {
				return new float[] { b };
			}
			return b;
		}

		if (type.getName().equals("double")) {
			double b = 0;
			if (c.isArray()) {
				return new double[] { b };
			}
			return b;
		}
		if (type.getName().equals("short")) {
			short b = 0;
			if (c.isArray()) {
				return new short[] { b };
			}
			return b;
		}
		try {
			Object o = type.newInstance();
			if (c.isArray()) {
				// BAD
				return new Object[] { o };
			}
			return o;

		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

}
