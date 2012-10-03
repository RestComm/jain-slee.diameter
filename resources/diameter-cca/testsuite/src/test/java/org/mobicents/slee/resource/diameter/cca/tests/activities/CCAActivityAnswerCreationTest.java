package org.mobicents.slee.resource.diameter.cca.tests.activities;

import java.io.Serializable;
import java.util.ArrayList;

import net.java.slee.resource.diameter.base.events.DiameterMessage;

import org.jdiameter.api.Answer;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.IllegalDiameterStateException;
import org.jdiameter.api.InternalException;
import org.jdiameter.api.OverloadException;
import org.jdiameter.api.Request;
import org.jdiameter.api.RouteException;
import org.jdiameter.api.Stack;
import org.jdiameter.api.acc.events.AccountAnswer;
import org.jdiameter.api.acc.events.AccountRequest;
import org.jdiameter.api.app.AppAnswerEvent;
import org.jdiameter.api.app.AppRequestEvent;
import org.jdiameter.api.app.AppSession;
import org.jdiameter.api.auth.events.AbortSessionAnswer;
import org.jdiameter.api.auth.events.AbortSessionRequest;
import org.jdiameter.api.auth.events.ReAuthAnswer;
import org.jdiameter.api.auth.events.ReAuthRequest;
import org.jdiameter.api.auth.events.SessionTermAnswer;
import org.jdiameter.api.auth.events.SessionTermRequest;
import org.jdiameter.api.cca.ServerCCASession;
import org.jdiameter.api.cca.ServerCCASessionListener;
import org.jdiameter.api.cca.events.JCreditControlAnswer;
import org.jdiameter.api.cca.events.JCreditControlRequest;
import org.jdiameter.client.api.ISessionFactory;
import org.jdiameter.common.api.app.cca.ICCAMessageFactory;
import org.jdiameter.common.api.app.cca.ServerCCASessionState;
import org.jdiameter.common.impl.app.cca.CCASessionFactoryImpl;
import org.jdiameter.server.impl.app.cca.IServerCCASessionData;
import org.jdiameter.server.impl.app.cca.ServerCCASessionImpl;
import org.junit.Test;
import org.mobicents.diameter.dictionary.AvpDictionary;
import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.base.DiameterMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.base.tests.activities.DiameterActivityAnswerCreationHelper;
import org.mobicents.slee.resource.diameter.base.tests.factories.BaseFactoriesTest;
import org.mobicents.slee.resource.diameter.cca.CreditControlAVPFactoryImpl;
import org.mobicents.slee.resource.diameter.cca.CreditControlMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.cca.CreditControlServerSessionImpl;

/**
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class CCAActivityAnswerCreationTest {

	private static DiameterAvpFactoryImpl diameterAvpFactory = new DiameterAvpFactoryImpl();
	private static CreditControlAVPFactoryImpl ccaAvpFactory = new CreditControlAVPFactoryImpl(diameterAvpFactory);
	private static DiameterMessageFactoryImpl baseMessageFactory;

	private static Stack stack;
	static {
		stack = new org.jdiameter.client.impl.StackImpl();
		try {
			stack.init(new BaseFactoriesTest.MyConfiguration());
			AvpDictionary.INSTANCE.parseDictionary(CCAActivityAnswerCreationTest.class.getClassLoader().getResourceAsStream("dictionary.xml"));
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to initialize the stack.");
		}

		baseMessageFactory = new DiameterMessageFactoryImpl(stack);
	}

	@Test
	public void testCCAServerActivityAnswerCreation() throws Exception {
		CCASessionFactoryImpl ccaSF = new CCASessionFactoryImpl();
		ServerCCASessionImpl session = new ServerCCASessionImpl(new ICCASessionDataImpl(), ccaSF, (ISessionFactory) stack.getSessionFactory(),
				new LocalServerCCASessionListenerImpl(), ccaSF, ccaSF);
		CreditControlMessageFactoryImpl ccaMessageFactory = new CreditControlMessageFactoryImpl(baseMessageFactory, session.getSessions().get(0), stack,
				ccaAvpFactory);
		ArrayList<DiameterMessage> list = new ArrayList<DiameterMessage>();
		list.add(ccaMessageFactory.createCreditControlRequest());
		CreditControlServerSessionImpl activity = new CreditControlServerSessionImpl(ccaMessageFactory, ccaAvpFactory, session, null, null);
		DiameterActivityAnswerCreationHelper.testAnswerCreation(activity, "lastRequest", list);
	}

	class ICCASessionDataImpl implements IServerCCASessionData {

		public ApplicationId getApplicationId() {
			return null;
		}

		public String getSessionId() {
			return null;
		}

		public boolean remove() {
			return false;
		}

		public void setApplicationId(ApplicationId appId) {
		}

		public ServerCCASessionState getServerCCASessionState() {
			return null;
		}

		public Serializable getTccTimerId() {
			return null;
		}

		public boolean isStateless() {
			return false;
		}

		public void setServerCCASessionState(ServerCCASessionState state) {
		}

		public void setStateless(boolean stateless) {
		}

		public void setTccTimerId(Serializable id) {
		}

	}

	class ICCAMessageFactoryImpl implements ICCAMessageFactory {

		public JCreditControlAnswer createCreditControlAnswer(Answer answer) {
			return null;
		}

		public JCreditControlRequest createCreditControlRequest(Request req) {
			return null;
		}

		public ReAuthAnswer createReAuthAnswer(Answer answer) {
			return null;
		}

		public ReAuthRequest createReAuthRequest(Request req) {
			return null;
		}

		public long[] getApplicationIds() {
			return new long[] { 1 };
		}
	}

	class LocalServerCCASessionListenerImpl implements ServerCCASessionListener {

		public void doAbortSessionAnswer(ServerCCASession session, AbortSessionRequest request, AbortSessionAnswer answer) throws InternalException,
				IllegalDiameterStateException, RouteException, OverloadException {
		}

		public void doAbortSessionRequest(ServerCCASession session, AbortSessionRequest request) throws InternalException, IllegalDiameterStateException,
				RouteException, OverloadException {
		}

		public void doAccountingAnswer(ServerCCASession session, AccountRequest request, AccountAnswer answer) throws InternalException,
				IllegalDiameterStateException, RouteException, OverloadException {
		}

		public void doAccountingRequest(ServerCCASession session, AccountRequest request) throws InternalException, IllegalDiameterStateException,
				RouteException, OverloadException {
		}

		public void doCreditControlRequest(ServerCCASession session, JCreditControlRequest request) throws InternalException, IllegalDiameterStateException,
				RouteException, OverloadException {
		}

		public void doOtherEvent(AppSession session, AppRequestEvent request, AppAnswerEvent answer) throws InternalException, IllegalDiameterStateException,
				RouteException, OverloadException {
		}

		public void doReAuthAnswer(ServerCCASession session, ReAuthRequest request, ReAuthAnswer answer) throws InternalException,
				IllegalDiameterStateException, RouteException, OverloadException {
		}

		public void doSessionTerminationAnswer(ServerCCASession session, SessionTermRequest request, SessionTermAnswer answer) throws InternalException,
				IllegalDiameterStateException, RouteException, OverloadException {
		}

		public void doSessionTerminationRequest(ServerCCASession session, SessionTermRequest request) throws InternalException, IllegalDiameterStateException,
				RouteException, OverloadException {
		}
	}
}
