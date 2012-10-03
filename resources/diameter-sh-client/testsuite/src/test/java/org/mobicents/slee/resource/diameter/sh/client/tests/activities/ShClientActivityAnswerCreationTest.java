package org.mobicents.slee.resource.diameter.sh.client.tests.activities;

import java.util.ArrayList;

import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.sh.client.ShClientMessageFactory;
import net.java.slee.resource.diameter.sh.events.PushNotificationRequest;

import org.jdiameter.api.Answer;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.IllegalDiameterStateException;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.OverloadException;
import org.jdiameter.api.Request;
import org.jdiameter.api.RouteException;
import org.jdiameter.api.Stack;
import org.jdiameter.api.app.AppAnswerEvent;
import org.jdiameter.api.app.AppRequestEvent;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.sh.ClientShSession;
import org.jdiameter.api.sh.ClientShSessionListener;
import org.jdiameter.api.sh.ServerShSession;
import org.jdiameter.api.sh.ServerShSessionListener;
import org.jdiameter.api.sh.events.ProfileUpdateAnswer;
import org.jdiameter.api.sh.events.ProfileUpdateRequest;
import org.jdiameter.api.sh.events.PushNotificationAnswer;
import org.jdiameter.api.sh.events.SubscribeNotificationsAnswer;
import org.jdiameter.api.sh.events.SubscribeNotificationsRequest;
import org.jdiameter.api.sh.events.UserDataAnswer;
import org.jdiameter.client.api.ISessionFactory;
import org.jdiameter.client.impl.app.sh.ShClientSessionDataLocalImpl;
import org.jdiameter.client.impl.app.sh.ShClientSessionImpl;
import org.jdiameter.common.api.app.sh.IShMessageFactory;
import org.junit.Test;
import org.mobicents.diameter.dictionary.AvpDictionary;
import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.base.tests.activities.DiameterActivityAnswerCreationHelper;
import org.mobicents.slee.resource.diameter.base.tests.factories.BaseFactoriesTest;
import org.mobicents.slee.resource.diameter.sh.DiameterShAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.sh.client.ShClientMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.sh.client.ShClientSubscriptionActivityImpl;
import org.mobicents.slee.resource.diameter.sh.events.PushNotificationRequestImpl;

/**
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class ShClientActivityAnswerCreationTest {

	protected static DiameterAvpFactoryImpl diameterAvpFactory = new DiameterAvpFactoryImpl();
	protected static DiameterShAvpFactoryImpl diameterShAvpFactory = new DiameterShAvpFactoryImpl(diameterAvpFactory);

	protected static final ApplicationId SH_APP_ID = org.jdiameter.api.ApplicationId.createByAuthAppId(ShClientMessageFactory._SH_VENDOR_ID,
			ShClientMessageFactory._SH_APP_ID);

	protected static Stack stack;

	static {
		stack = new org.jdiameter.client.impl.StackImpl();
		try {
			stack.init(new BaseFactoriesTest.MyConfiguration());
			AvpDictionary.INSTANCE.parseDictionary(ShClientActivityAnswerCreationTest.class.getClassLoader().getResourceAsStream("dictionary.xml"));
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to initialize the stack.");
		}
	}

	@Test
	public void testShClientActivityAnswerCreation() throws Exception {
		ClientShSession session = new ShClientSessionImpl(new ShClientSessionDataLocalImpl(), new IShMessageFactoryImpl(),
				(ISessionFactory) stack.getSessionFactory(), new ClientShSessionListenerImpl());
		PushNotificationRequest pnr = new PushNotificationRequestImpl(stack.getSessionFactory().getNewSession()
				.createRequest(PushNotificationRequest.commandCode, SH_APP_ID, "mobicents.org", "hss.mobicents"));
		ArrayList<DiameterMessage> list = new ArrayList<DiameterMessage>();
		list.add(pnr);
		ShClientSubscriptionActivityImpl activity = new ShClientSubscriptionActivityImpl(new ShClientMessageFactoryImpl(session.getSessions().get(0), stack),
				new DiameterShAvpFactoryImpl(diameterAvpFactory), session, null, null);

		DiameterActivityAnswerCreationHelper.testAnswerCreation(activity, "stateMessages", list);
	}

	protected class IShMessageFactoryImpl implements IShMessageFactory {

		public IShMessageFactoryImpl() {
		}

		public AppAnswerEvent createProfileUpdateAnswer(Answer answer) {
			return null;
		}

		public AppRequestEvent createProfileUpdateRequest(Request request) {
			return null;
		}

		public AppAnswerEvent createPushNotificationAnswer(Answer answer) {
			return null;
		}

		public AppRequestEvent createPushNotificationRequest(Request request) {
			return null;
		}

		public AppAnswerEvent createSubscribeNotificationsAnswer(Answer answer) {
			return null;
		}

		public AppRequestEvent createSubscribeNotificationsRequest(Request request) {
			return null;
		}

		public AppAnswerEvent createUserDataAnswer(Answer answer) {
			return null;
		}

		public AppRequestEvent createUserDataRequest(Request request) {
			return null;
		}

		public long getApplicationId() {
			return 0;
		}

		public long getMessageTimeout() {
			return 0;
		}

	}

	class ClientShSessionListenerImpl implements ClientShSessionListener {

		public void doOtherEvent(AppSession session, AppRequestEvent request, AppAnswerEvent answer) throws InternalException, IllegalDiameterStateException,
				RouteException, OverloadException {
		}

		public void doProfileUpdateAnswerEvent(ClientShSession session, ProfileUpdateRequest request, ProfileUpdateAnswer answer) throws InternalException,
				IllegalDiameterStateException, RouteException, OverloadException {
		}

		public void doPushNotificationRequestEvent(ClientShSession session, org.jdiameter.api.sh.events.PushNotificationRequest request)
				throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
		}

		public void doSubscribeNotificationsAnswerEvent(ClientShSession session, SubscribeNotificationsRequest request, SubscribeNotificationsAnswer answer)
				throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
		}

		public void doUserDataAnswerEvent(ClientShSession session, org.jdiameter.api.sh.events.UserDataRequest request, UserDataAnswer answer)
				throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
		}

	}

	protected class ServerShSessionListenerImpl implements ServerShSessionListener {

		public ServerShSessionListenerImpl() {
		}

		public void doOtherEvent(AppSession session, AppRequestEvent request, AppAnswerEvent answer) throws InternalException, IllegalDiameterStateException,
				RouteException, OverloadException {
		}

		public void doProfileUpdateRequestEvent(ServerShSession session, ProfileUpdateRequest request) throws InternalException, IllegalDiameterStateException,
				RouteException, OverloadException {
		}

		public void doPushNotificationAnswerEvent(ServerShSession session, org.jdiameter.api.sh.events.PushNotificationRequest request,
				PushNotificationAnswer answer) throws InternalException, IllegalDiameterStateException, RouteException, OverloadException {
		}

		public void doSubscribeNotificationsRequestEvent(ServerShSession session, SubscribeNotificationsRequest request) throws InternalException,
				IllegalDiameterStateException, RouteException, OverloadException {
		}

		public void doUserDataRequestEvent(ServerShSession session, org.jdiameter.api.sh.events.UserDataRequest request) throws InternalException,
				IllegalDiameterStateException, RouteException, OverloadException {
		}

	}
}
