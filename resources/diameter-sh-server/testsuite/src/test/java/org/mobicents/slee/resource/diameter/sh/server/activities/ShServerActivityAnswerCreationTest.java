package org.mobicents.slee.resource.diameter.sh.server.activities;

import java.util.ArrayList;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.sh.events.UserDataRequest;

import org.jdiameter.api.sh.ServerShSession;
import org.jdiameter.client.api.ISessionFactory;
import org.jdiameter.server.impl.app.sh.ShServerSessionDataLocalImpl;
import org.jdiameter.server.impl.app.sh.ShServerSessionImpl;
import org.junit.Test;
import org.mobicents.slee.resource.diameter.base.DiameterMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.base.tests.activities.DiameterActivityAnswerCreationHelper;
import org.mobicents.slee.resource.diameter.sh.client.ShClientMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.sh.client.tests.activities.ShClientActivityAnswerCreationTest;
import org.mobicents.slee.resource.diameter.sh.server.ShServerActivityImpl;
import org.mobicents.slee.resource.diameter.sh.server.ShServerMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.sh.server.ShServerSubscriptionActivityImpl;

/**
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class ShServerActivityAnswerCreationTest extends ShClientActivityAnswerCreationTest {

	@Test
	public void testShServerActivityAnswerCreation() throws Exception {
		ServerShSession session = new ShServerSessionImpl(new ShServerSessionDataLocalImpl(), new IShMessageFactoryImpl(),
				(ISessionFactory) stack.getSessionFactory(), new ServerShSessionListenerImpl());
		DiameterMessageFactoryImpl msgFactory = new DiameterMessageFactoryImpl(session.getSessions().get(0), stack, null, null);
		ShClientMessageFactoryImpl factory = new ShClientMessageFactoryImpl(session.getSessions().get(0), stack);
		UserDataRequest udr = factory.createUserDataRequest();
		net.java.slee.resource.diameter.sh.events.ProfileUpdateRequest pur = factory.createProfileUpdateRequest();
		net.java.slee.resource.diameter.sh.events.SubscribeNotificationsRequest snr = factory.createSubscribeNotificationsRequest();
		ArrayList<DiameterMessage> list = new ArrayList<DiameterMessage>();
		list.add(udr);
		list.add(pur);
		list.add(snr);

		ShServerActivityImpl activity = new ShServerActivityImpl(new ShServerMessageFactoryImpl(msgFactory, session.getSessions().get(0), stack,
				diameterShAvpFactory), diameterShAvpFactory, session, null, null);

		DiameterActivityAnswerCreationHelper.testAnswerCreation(activity, "stateMessages", list);
	}

	@Test
	public void testShServerSubscriptionActivityAnswerCreation() throws Exception {
		ServerShSession session = new ShServerSessionImpl(new ShServerSessionDataLocalImpl(), new IShMessageFactoryImpl(),
				(ISessionFactory) stack.getSessionFactory(), new ServerShSessionListenerImpl());
		DiameterMessageFactoryImpl msgFactory = new DiameterMessageFactoryImpl(session.getSessions().get(0), stack, null, null);
		ShClientMessageFactoryImpl factory = new ShClientMessageFactoryImpl(session.getSessions().get(0), stack);
		UserDataRequest udr = factory.createUserDataRequest();
		net.java.slee.resource.diameter.sh.events.ProfileUpdateRequest pur = factory.createProfileUpdateRequest();
		net.java.slee.resource.diameter.sh.events.SubscribeNotificationsRequest snr = factory.createSubscribeNotificationsRequest();

		ArrayList<DiameterMessage> list = new ArrayList<DiameterMessage>();
		list.add(udr);
		list.add(pur);
		list.add(snr);

		ShServerSubscriptionActivityImpl activity = new ShServerSubscriptionActivityImpl(new ShServerMessageFactoryImpl(msgFactory, session.getSessions()
				.get(0), stack, diameterShAvpFactory), diameterShAvpFactory, session, null, null);

		DiameterActivityAnswerCreationHelper.testAnswerCreation(activity, "stateMessages", list);
	}
}
