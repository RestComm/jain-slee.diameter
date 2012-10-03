package org.mobicents.slee.resource.diameter.gx.tests.avp;

import java.util.ArrayList;
import java.util.List;

import net.java.slee.resource.diameter.base.events.avp.AvpUtilities;
import net.java.slee.resource.diameter.base.events.avp.DiameterAvp;
import net.java.slee.resource.diameter.gx.events.GxCreditControlAnswer;
import net.java.slee.resource.diameter.gx.events.GxCreditControlRequest;

import org.jdiameter.api.Avp;
import org.jdiameter.api.Message;
import org.jdiameter.client.impl.StackImpl;
import org.jdiameter.common.impl.validation.DictionaryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mobicents.slee.resource.diameter.base.DiameterMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.tests.factories.BaseFactoriesTest.MyConfiguration;
import org.mobicents.slee.resource.diameter.gx.GxMessageFactoryImpl;

public class AvpFlagsTest extends org.mobicents.slee.resource.diameter.base.tests.avp.AvpFlagsTest {

	private static final long TGPP_VENDOR_ID = 10415L;

	private static StackImpl stack;

	private static GxMessageFactoryImpl gxMessageFactory;

	static {
		stack = new org.jdiameter.client.impl.StackImpl();
		try {
			stack.init(new MyConfiguration());
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to initialize the stack.");
		}

		try {
			gxMessageFactory = new GxMessageFactoryImpl(new DiameterMessageFactoryImpl(stack), stack.getSessionFactory().getNewSession().getSessionId(), stack);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			DictionaryImpl.INSTANCE.configure(AvpFlagsTest.class.getClassLoader().getResourceAsStream("dictionary.xml"));
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to parse dictionary file.");
		}
	}

	@Test
	public void testCorrectFlagsSupportedFeatures() {
		List<DiameterAvp> avps = new ArrayList<DiameterAvp>();
		DiameterAvp avpFeatureListID = AvpUtilities.createAvp(Avp.FEATURE_LIST_ID, TGPP_VENDOR_ID, 1);
		avps.add(AvpUtilities.createAvp(Avp.SUPPORTED_FEATURES, TGPP_VENDOR_ID, new DiameterAvp[] { avpFeatureListID }));

		GxCreditControlRequest ccr = gxMessageFactory.createGxCreditControlRequest();
		GxCreditControlAnswer cca = gxMessageFactory.createGxCreditControlAnswer(ccr);
		cca.setExtensionAvps(avps.toArray(avps.toArray(new DiameterAvp[avps.size()])));

		Message msg = ((DiameterMessageImpl) cca).getGenericData();

		AvpUtilities.addAvp(msg, Avp.SUPPORTED_FEATURES, TGPP_VENDOR_ID, msg.getAvps(), new DiameterAvp[] { avpFeatureListID });

		// Attribute Name AVP Code Section Value Type Must May Should not Must not May Encr.
		// Supported-Features 628 6.3.29 Grouped V M - - - No

		ArrayList<String> failures = checkAvpFlags(msg.getAvps());

		if (failures.size() > 0) {
			System.err.println("The following AVPs flags have failed to check against dictionary:");
			for (String failure : failures) {
				System.err.println(failure);
			}
			Assert.fail(failures.toString());
		}
	}
}
