/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
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
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, TeleStax Inc. and individual contributors
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
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *   JBoss, Home of Professional Open Source
 *   Copyright 2007-2011, Red Hat, Inc. and individual contributors
 *   by the @authors tag. See the copyright.txt in the distribution for a
 *   full listing of individual contributors.
 *
 *   This is free software; you can redistribute it and/or modify it
 *   under the terms of the GNU Lesser General Public License as
 *   published by the Free Software Foundation; either version 2.1 of
 *   the License, or (at your option) any later version.
 *
 *   This software is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this software; if not, write to the Free
 *   Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *   02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.diameter.slh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.ObjectName;
import javax.naming.OperationNotSupportedException;
import javax.slee.Address;
import javax.slee.facilities.EventLookupFacility;
import javax.slee.facilities.Tracer;
import javax.slee.resource.ActivityFlags;
import javax.slee.resource.ActivityHandle;
import javax.slee.resource.ConfigProperties;
import javax.slee.resource.EventFlags;
import javax.slee.resource.FailureReason;
import javax.slee.resource.FireableEventType;
import javax.slee.resource.InvalidConfigurationException;
import javax.slee.resource.Marshaler;
import javax.slee.resource.ReceivableService;
import javax.slee.resource.ResourceAdaptor;
import javax.slee.resource.ResourceAdaptorContext;
import javax.slee.resource.SleeEndpoint;

import net.java.slee.resource.diameter.Validator;
import net.java.slee.resource.diameter.base.CreateActivityException;
import net.java.slee.resource.diameter.base.DiameterActivity;
import net.java.slee.resource.diameter.base.DiameterAvpFactory;
import net.java.slee.resource.diameter.base.DiameterException;
import net.java.slee.resource.diameter.base.events.AbortSessionAnswer;
import net.java.slee.resource.diameter.base.events.DiameterMessage;
import net.java.slee.resource.diameter.base.events.ReAuthAnswer;
import net.java.slee.resource.diameter.base.events.SessionTerminationAnswer;
import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.slh.SLhAvpFactory;
import net.java.slee.resource.diameter.slh.SLhClientSessionActivity;
import net.java.slee.resource.diameter.slh.SLhMessageFactory;
import net.java.slee.resource.diameter.slh.SLhProvider;
import net.java.slee.resource.diameter.slh.SLhServerSessionActivity;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoAnswer;
import net.java.slee.resource.diameter.slh.events.LCSRoutingInfoRequest;

import org.jboss.mx.util.MBeanServerLocator;
import org.jdiameter.api.Answer;
import org.jdiameter.api.ApplicationId;
import org.jdiameter.api.Avp;
import org.jdiameter.api.AvpDataException;
import org.jdiameter.api.AvpSet;
import org.jdiameter.api.Message;
import org.jdiameter.api.Peer;
import org.jdiameter.api.PeerTable;
import org.jdiameter.api.Request;
import org.jdiameter.api.Session;
import org.jdiameter.api.SessionFactory;
import org.jdiameter.api.Stack;
// import org.jdiameter.api.slh.ClientSLhSession;
// import org.jdiameter.api.slh.ServerSLhSession;
import org.jdiameter.client.api.ISessionFactory;
// import org.jdiameter.server.impl.app.slh.ServerSLhSessionImpl;
import org.mobicents.diameter.stack.DiameterListener;
import org.mobicents.diameter.stack.DiameterStackMultiplexerMBean;
import org.mobicents.slee.resource.cluster.FaultTolerantResourceAdaptorContext;
import org.mobicents.slee.resource.diameter.AbstractClusteredDiameterActivityManagement;
import org.mobicents.slee.resource.diameter.DiameterActivityManagement;
import org.mobicents.slee.resource.diameter.LocalDiameterActivityManagement;
import org.mobicents.slee.resource.diameter.ValidatorImpl;
import org.mobicents.slee.resource.diameter.base.DiameterActivityHandle;
import org.mobicents.slee.resource.diameter.base.DiameterActivityImpl;
import org.mobicents.slee.resource.diameter.base.DiameterAvpFactoryImpl;
import org.mobicents.slee.resource.diameter.base.DiameterBaseMarshaler;
import org.mobicents.slee.resource.diameter.base.DiameterMessageFactoryImpl;
import org.mobicents.slee.resource.diameter.base.EventIDFilter;
import org.mobicents.slee.resource.diameter.base.events.AbortSessionAnswerImpl;
import org.mobicents.slee.resource.diameter.base.events.AbortSessionRequestImpl;
import org.mobicents.slee.resource.diameter.base.events.DiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.events.ErrorAnswerImpl;
import org.mobicents.slee.resource.diameter.base.events.ExtensionDiameterMessageImpl;
import org.mobicents.slee.resource.diameter.base.events.SessionTerminationAnswerImpl;
import org.mobicents.slee.resource.diameter.base.events.SessionTerminationRequestImpl;
import org.mobicents.slee.resource.diameter.base.handlers.DiameterRAInterface;
import org.mobicents.slee.resource.diameter.slh.events.LCSRoutingInfoAnswerImpl;
import org.mobicents.slee.resource.diameter.slh.events.LCSRoutingInfoRequestImpl;
import org.mobicents.slee.resource.diameter.slh.handlers.SLhSessionFactory;


/**
 * Diameter SLh Resource Adaptor
 *
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 *
 */
public class DiameterSLhResourceAdaptor {
}

//public class DiameterSLhResourceAdaptor implements ResourceAdaptor, DiameterListener, DiameterRAInterface ,org.mobicents.slee.resource.cluster.FaultTolerantResourceAdaptor<String, DiameterActivity> {

//  private static final long serialVersionUID = 1L;
//
//  // Config Properties Names ---------------------------------------------
//
//  private static final String AUTH_APPLICATION_IDS = "authApplicationIds";
//
//  // Config Properties Values --------------------------------------------
//
//  private List<ApplicationId> authApplicationIds;
//
//  /**
//   * caches the eventIDs, avoiding lookup in container
//   */
//  public final EventIDCache eventIdCache = new EventIDCache();
//
//  /**
//   * tells the RA if an event with a specified ID should be filtered or not
//   */
//  private final EventIDFilter eventIDFilter = new EventIDFilter();
//
//  /**
//   * The ResourceAdaptorContext interface is implemented by the SLEE. It provides the Resource
//   * Adaptor with the required capabilities in the SLEE to execute its work. The ResourceAdaptorCon-
//   * text object holds references to a number of objects that are of interest to many Resource Adaptors. A
//   * resource adaptor object is provided with a ResourceAdaptorContext object when the setResour-
//   * ceAdaptorContext method of the ResourceAdaptor interface is invoked on the resource adaptor
//   * object.
//   */
//  private ResourceAdaptorContext raContext;
//
//  /**
//   * FT/HA version of RA context.
//   */
//  private FaultTolerantResourceAdaptorContext<String, DiameterActivity> ftRAContext;
//
//  /**
//   * The SLEE endpoint defines the contract between the SLEE and the resource
//   * adaptor that enables the resource adaptor to deliver events
//   * asynchronously to SLEE endpoints residing in the SLEE. This contract
//   * serves as a generic contract that allows a wide range of resources to be
//   * plugged into a SLEE environment via the resource adaptor architecture.
//   * For further information see JSLEE v1.1 Specification Page 307 The
//   * sleeEndpoint will be initialized in entityCreated() method.
//   */
//  private transient SleeEndpoint sleeEndpoint = null;
//
//  /**
//   * A tracer is represented in the SLEE by the Tracer interface. Notification sources access the Tracer Facil-
//   * ity through a Tracer object that implements the Tracer interface. A Tracer object can be obtained by
//   * SBBs via the SbbContext interface, by resource adaptor entities via the ResourceAdaptorContext
//   * interface, and by profiles via the ProfileContext interface.
//   */
//  private Tracer tracer;
//
//  protected DiameterBaseMarshaler marshaler = new DiameterBaseMarshaler();
//  // Diameter Specific Properties ----------------------------------------
//
//  private Stack stack;
//
//  private ObjectName diameterMultiplexerObjectName = null;
//  private DiameterStackMultiplexerMBean diameterMux = null;
//
//  // Default Failure Handling
//  protected int defaultDirectDebitingFailureHandling = 0;
//  protected int defaultLCSRoutingInfoFailureHandling = 0;
//
//  // Validity and TxTimer values (in seconds)
//  protected long defaultValidityTime = 30;
//  protected long defaultTxTimerValue = 10;
//
//  protected long activityRemoveDelay = 30000;
//
//  // Base Factories
//  private DiameterAvpFactory baseAvpFactory = null;
//  private DiameterMessageFactoryImpl baseMessageFactory;
//
//  private SessionFactory sessionFactory = null;
//
//  // SLh RA Factories
//  protected SLhSessionFactory riaSessionFactory = null;
//
//  protected SLhAvpFactory slhAvpFactory = null;
//
//  protected SLhMessageFactory slhMessageFactory;
//
//  /**
//   * the EventLookupFacility is used to look up the event id of incoming
//   * events
//   */
//  private transient EventLookupFacility eventLookup = null;
//
//  /**
//   * The list of activities stored in this resource adaptor. If this resource
//   * adaptor were a distributed and highly available solution, this storage
//   * were one of the candidates for distribution.
//   */
//  //private transient ConcurrentHashMap<ActivityHandle, DiameterActivity> activities = null;
//  private transient DiameterActivityManagement activities = null;
//
//  /**
//   * A link to the DiameterProvider which then will be exposed to Sbbs
//   */
//  protected transient SLhProviderImpl raProvider = null;
//
//  /**
//   * for all events we are interested in knowing when the event failed to be processed
//   */
//  private static final int EVENT_FLAGS = getEventFlags();
//
//  private static int getEventFlags() {
//    int eventFlags = EventFlags.REQUEST_EVENT_UNREFERENCED_CALLBACK;
//    eventFlags = EventFlags.setRequestProcessingFailedCallback(eventFlags);
//    eventFlags = EventFlags.setRequestProcessingSuccessfulCallback(eventFlags);
//    return eventFlags;
//  }
//
//  private static final int DEFAULT_ACTIVITY_FLAGS = ActivityFlags.REQUEST_ENDED_CALLBACK;
//  private static final int MARSHALABLE_ACTIVITY_FLAGS = ActivityFlags.setSleeMayMarshal(DEFAULT_ACTIVITY_FLAGS);
//
//  public DiameterSLhResourceAdaptor() {
//    // TODO: Initialize any default values.
//  }
//
//  // Lifecycle methods ---------------------------------------------------
//
//  public void setResourceAdaptorContext(ResourceAdaptorContext context) {
//    this.raContext = context;
//    this.tracer = context.getTracer("DiameterSLhResourceAdaptor");
//    this.sleeEndpoint = context.getSleeEndpoint();
//    this.eventLookup = context.getEventLookupFacility();
//    this.raProvider = new SLhProviderImpl(this);
//  }
//
//  public void unsetResourceAdaptorContext() {
//    this.raContext = null;
//    this.tracer = null;
//    this.sleeEndpoint = null;
//    this.eventLookup = null;
//    this.raProvider = null;
//  }
//
//  // FT Lifecycle methods ------------------------------------------------
//
//  /*
//   * (non-Javadoc)
//   * @see org.mobicents.slee.resource.cluster.FaultTolerantResourceAdaptor#setFaultTolerantResourceAdaptorContext
//   * (org.mobicents.slee.resource.cluster.FaultTolerantResourceAdaptorContext)
//   */
//  public void setFaultTolerantResourceAdaptorContext(FaultTolerantResourceAdaptorContext<String, DiameterActivity> ctx) {
//    this.ftRAContext = ctx;
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see org.mobicents.slee.resource.cluster.FaultTolerantResourceAdaptor#unsetFaultTolerantResourceAdaptorContext()
//   */
//  public void unsetFaultTolerantResourceAdaptorContext() {
//    this.ftRAContext = null;
//    //clear this.activities ??
//  }
//
//  // FT methods ----------------------------------------------------------
//
//  /*
//   * (non-Javadoc)
//   * @see org.mobicents.slee.resource.cluster.FaultTolerantResourceAdaptor#dataRemoved(java.io.Serializable)
//   */
//  public void dataRemoved(String arg0) {
//    this.activities.remove(getActivityHandle(arg0));
//  }
//
//  /* (non-Javadoc)
//   * @see org.mobicents.slee.resource.cluster.FaultTolerantResourceAdaptor#failOver(java.io.Serializable)
//   */
//  public void failOver(String arg0) {
//    throw new UnsupportedOperationException();
//  }
//
//  @Override
//  public ApplicationId[] getSupportedApplications() {
//    //FIXME: fill this , Alex what should go here?
//    return null;
//  }
//
//  public void raActive() {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: raActive.");
//    }
//
//    try {
//      if(tracer.isInfoEnabled()) {
//        tracer.info("Activating Diameter SLh RA Entity");
//      }
//
//      this.diameterMultiplexerObjectName = new ObjectName("diameter.mobicents:service=DiameterStackMultiplexer");
//
//      Object object = MBeanServerLocator.locateJBoss().invoke(this.diameterMultiplexerObjectName, "getMultiplexerMBean", new Object[]{}, new String[]{});
//
//      if(object instanceof DiameterStackMultiplexerMBean) {
//        this.diameterMux = (DiameterStackMultiplexerMBean) object;
//      }
//
//      //this.activities = new ConcurrentHashMap<ActivityHandle, DiameterActivity>();
//
//      // Initialize the protocol stack
//      initStack();
//
//      //Initialize activities mgmt
//      initActivitiesMgmt();
//
//      // Initialize factories
//      this.baseAvpFactory = new DiameterAvpFactoryImpl();
//      this.baseMessageFactory = new DiameterMessageFactoryImpl(stack);
//
//      this.slhAvpFactory = new SLhAvpFactoryImpl(baseAvpFactory);
//      this.slhMessageFactory = new SLhMessageFactoryImpl(baseMessageFactory, null, stack);
//
//      // Set the first configured Application-Id as default for message factory
//      ApplicationId firstAppId = authApplicationIds.get(0);
//      ((SLhMessageFactoryImpl)this.slhMessageFactory).setApplicationId(firstAppId.getVendorId(), firstAppId.getAuthAppId());
//
//      this.sessionFactory = this.stack.getSessionFactory();
//      this.riaSessionFactory = new SLhSessionFactory( this, sessionFactory,defaultDirectDebitingFailureHandling, defaultLCSRoutingInfoFailureHandling,  defaultValidityTime, defaultTxTimerValue);
//
//      // Register RIA App Session Factories
//      ((ISessionFactory) sessionFactory).registerAppFacory(ServerSLhSession.class, this.riaSessionFactory);
//      ((ISessionFactory) sessionFactory).registerAppFacory(ClientSLhSession.class, this.riaSessionFactory);
//    }
//    catch (Exception e) {
//      tracer.severe("Error Activating Diameter SLh RA Entity", e);
//    }
//  }
//
//  public void raStopping() {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: raStopping.");
//    }
//
//    try {
//      diameterMux.unregisterListener(this);
//    }
//    catch (Exception e) {
//      tracer.severe("Failed to unregister SLh RA from Diameter Mux.", e);
//    }
//
//    if(tracer.isInfoEnabled()) {
//      tracer.info("Diameter SLh RA :: raStopping completed.");
//    }
//  }
//
//  public void raInactive() {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: raInactive.");
//    }
//
//    //synchronized (this.activities) {
//    //  activities.clear();
//    //}
//    activities = null;
//
//    if(tracer.isInfoEnabled()) {
//      tracer.info("Diameter SLh RA :: raInactive completed.");
//    }
//  }
//
//  public void raConfigure(ConfigProperties properties) {
//    parseApplicationIds((String) properties.getProperty(AUTH_APPLICATION_IDS).getValue());
//  }
//
//  private void parseApplicationIds(String appIdsStr) {
//    if(appIdsStr != null) {
//      appIdsStr = appIdsStr.replaceAll(" ", "");
//
//      String[] appIdsStrings  = appIdsStr.split(",");
//
//      authApplicationIds = new ArrayList<ApplicationId>(appIdsStrings.length);
//
//      for(String appId : appIdsStrings) {
//        String[] vendorAndAppId = appId.split(":");
//        authApplicationIds.add(ApplicationId.createByAuthAppId(Long.valueOf(vendorAndAppId[0]), Long.valueOf(vendorAndAppId[1])));
//      }
//    }
//  }
//
//  public void raUnconfigure() {
//    // Clean up!
//    this.activities = null;
//    this.raContext = null;
//    this.eventLookup = null;
//    this.raProvider = null;
//    this.sleeEndpoint = null;
//    this.stack = null;
//  }
//
//  // Configuration management methods ------------------------------------
//
//  public void raVerifyConfiguration(ConfigProperties properties) throws InvalidConfigurationException {
//    // TODO Auto-generated method stub
//  }
//
//  public void raConfigurationUpdate(ConfigProperties properties) {
//    // this ra does not support config update while entity is active
//  }
//
//  // Interface access methods --------------------------------------------
//
//  public Object getResourceAdaptorInterface(String className) {
//    // this ra implements a single ra type
//    return raProvider;
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see javax.slee.resource.ResourceAdaptor#getMarshaler()
//   */
//  public Marshaler getMarshaler() {
//    return marshaler;
//  }
//
//  // Event filtering methods ---------------------------------------------
//
//  public void serviceActive(ReceivableService serviceInfo) {
//    eventIDFilter.serviceActive(serviceInfo);
//  }
//
//  public void serviceStopping(ReceivableService serviceInfo) {
//    eventIDFilter.serviceStopping(serviceInfo);
//  }
//
//  public void serviceInactive(ReceivableService serviceInfo) {
//    eventIDFilter.serviceInactive(serviceInfo);
//  }
//
//  // Mandatory callback methods ------------------------------------------
//
//  public void queryLiveness(ActivityHandle handle) {
//    tracer.info("Diameter SLh RA :: queryLiveness :: handle[" + handle + "].");
//
//    DiameterActivityImpl activity = (DiameterActivityImpl) activities.get((DiameterActivityHandle)handle);
//
//    if (activity != null && !activity.isValid()) {
//      try {
//        sleeEndpoint.endActivity(handle);
//      }
//      catch (Exception e) {
//        tracer.severe("Failure ending non-live activity.", e);
//      }
//    }
//  }
//
//  public Object getActivity(ActivityHandle handle) {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: getActivity :: handle[" + handle + "].");
//    }
//
//    return this.activities.get((DiameterActivityHandle)handle);
//  }
//
//  public ActivityHandle getActivityHandle(Object activity) {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: getActivityHandle :: activity[" + activity + "].");
//    }
//
//    if (!(activity instanceof DiameterActivity)) {
//      return null;
//    }
//
//    DiameterActivityImpl inActivity = (DiameterActivityImpl) activity;
//
//    //for (Map.Entry<ActivityHandle, DiameterActivity> activityInfo : this.activities.entrySet()) {
//    //  Object curActivity = activityInfo.getValue();
//    //
//    //  if (curActivity.equals(inActivity)) {
//    //    return activityInfo.getKey();
//    //  }
//    //}
//    //
//    //return null;
//    return inActivity.getActivityHandle();
//  }
//
//  public void administrativeRemove(ActivityHandle handle) {
//    // TODO what to do here?
//  }
//
//  // Optional callback methods -------------------------------------------
//
//  public void eventProcessingFailed(ActivityHandle handle, FireableEventType eventType, Object event, Address address, ReceivableService service, int flags, FailureReason reason) {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: eventProcessingFailed :: handle[" + handle + "], eventType[" + eventType + "], event[" + event + "], address[" + address + "], flags[" + flags + "], reason[" + reason + "].");
//    }
//    if(!(handle instanceof DiameterActivityHandle)) {
//      return;
//    }
//
//    processAfterEventDelivery(handle, eventType, event, address, service, flags);
//  }
//
//  public void eventProcessingSuccessful(ActivityHandle handle, FireableEventType eventType, Object event, Address address, ReceivableService service, int flags) {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: eventProcessingSuccessful :: handle[" + handle + "], eventType[" + eventType + "], event[" + event + "], address[" + address + "], flags[" + flags + "].");
//    }
//
//    if(!(handle instanceof DiameterActivityHandle)) {
//      return;
//    }
//
//    processAfterEventDelivery(handle, eventType, event, address, service, flags);
//  }
//
//  public void eventUnreferenced(ActivityHandle handle, FireableEventType eventType, Object event, Address address, ReceivableService service, int flags) {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: eventUnreferenced :: handle[" + handle + "], eventType[" + eventType + "], event[" + event + "], address[" + address + "], service[" + service + "], flags[" + flags + "].");
//    }
//    if(!(handle instanceof DiameterActivityHandle)) {
//      return;
//    }
//
//    processAfterEventDelivery(handle, eventType, event, address, service, flags);
//  }
//
//  private void processAfterEventDelivery(ActivityHandle handle, FireableEventType eventType, Object event, Address address, ReceivableService service, int flags) {
//    DiameterActivityImpl activity = (DiameterActivityImpl) getActivity(handle);
//    if (activity != null) {
//      synchronized (activity) {
//        if (activity.isTerminateAfterProcessing()) {
//          activity.endActivity();
//        }
//      }
//    }
//  }
//
//  public void activityEnded(ActivityHandle handle) {
//    if(tracer.isInfoEnabled()) {
//      tracer.info("Diameter SLh RA :: activityEnded :: handle[" + handle + "].");
//    }
//
//    if(this.activities != null) {
//      synchronized (this.activities) {
//        this.activities.remove((DiameterActivityHandle)handle);
//      }
//    }
//  }
//
//  public void activityUnreferenced(ActivityHandle handle) {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: activityUnreferenced :: handle[" + handle + "].");
//    }
//
//    //this.activityEnded(handle);
//    if(handle instanceof DiameterActivityHandle) {
//      this.endActivity((DiameterActivityHandle) handle);
//    }
//  }
//
//  // Event and Activities management -------------------------------------
//
//  public boolean fireEvent(Object event, ActivityHandle handle, FireableEventType eventID, Address address, boolean useFiltering, boolean transacted) {
//
//    if (useFiltering && eventIDFilter.filterEvent(eventID)) {
//      if (tracer.isFineEnabled()) {
//        tracer.fine("Event " + eventID + " filtered");
//      }
//    }
//    else if (eventID == null) {
//      tracer.severe("Event ID for " + eventID + " is unknown, unable to fire.");
//    }
//    else {
//      if (tracer.isFineEnabled()) {
//        tracer.fine("Firing event " + event + " on handle " + handle);
//      }
//      try {
//        Object o = getActivity(handle);
//        if(o == null) {
//          throw new IllegalStateException("No activity for handle: "+handle);
//        }
//
//        if(o instanceof SLhServerSessionActivityImpl && event instanceof LCSRoutingInfoRequest) {
//          ((SLhServerSessionActivityImpl)o).fetchCurrentState((LCSRoutingInfoRequest)event);
//        }
//        this.raContext.getSleeEndpoint().fireEvent(handle, eventID, event, address, null, EVENT_FLAGS);
//
//        return true;
//      }
//      catch (Exception e) {
//        tracer.severe("Error firing event.", e);
//      }
//    }
//
//    return false;
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see org.mobicents.slee.resource.diameter.base.handlers.BaseSessionCreationListener#fireEvent(java.lang.String, org.jdiameter.api.Request, org.jdiameter.api.Answer)
//   */
//  public void fireEvent(String sessionId, Message message) {
//    DiameterMessage event = (DiameterMessage) createEvent(message);
//
//    FireableEventType eventId = eventIdCache.getEventId(eventLookup, message);
//
//    this.fireEvent(event, getActivityHandle(sessionId), eventId, null, true, message.isRequest());
//  }
//
//  /**
//   * {@inheritDoc}
//   */
//  @Override
//  public void endActivity(DiameterActivityHandle arg0) {
//    this.sleeEndpoint.endActivity(arg0);
//  }
//
//  /**
//   * {@inheritDoc}
//   */
//  @Override
//  public void startActivityRemoveTimer(DiameterActivityHandle handle) {
//    try {
//      this.activities.startActivityRemoveTimer(handle);
//    }
//    catch (Exception e) {
//      tracer.warning("Failed to start activity remove timer.", e);
//    }
//  }
//
//  /**
//   * {@inheritDoc}
//   */
//  @Override
//  public void stopActivityRemoveTimer(DiameterActivityHandle handle) {
//    try {
//      this.activities.stopActivityRemoveTimer(handle);
//    }
//    catch (Exception e) {
//      tracer.warning("Failed to stop activity remove timer.", e);
//    }
//  }
//
//  /**
//   * {@inheritDoc}
//   */
//  @Override
//  public void update(DiameterActivityHandle arg0, DiameterActivity arg1) {
//    this.activities.update(arg0, arg1);
//  }
//
//  /**
//   * Create Event object from a JDiameter message (request or answer)
//   *
//   * @return a DiameterMessage object wrapping the request/answer
//   * @throws OperationNotSupportedException
//   */
//  private DiameterMessage createEvent(Message message) {
//    if (message == null) {
//      throw new NullPointerException("Message argument cannot be null while creating event.");
//    }
//
//    int commandCode = message.getCommandCode();
//
//    if (message.isError()) {
//      return new ErrorAnswerImpl(message);
//    }
//
//    boolean isRequest = message.isRequest();
//
//    switch (commandCode) {
//      case LCSRoutingInfoRequest.commandCode: // RIR/RIA
//        return isRequest ? new LCSRoutingInfoRequestImpl(message) : new LCSRoutingInfoAnswerImpl(message);
//      case AbortSessionAnswer.commandCode: // ASR/ASA
//        return isRequest ? new AbortSessionRequestImpl(message) : new AbortSessionAnswerImpl(message);
//      case SessionTerminationAnswer.commandCode: // STR/STA
//        return isRequest ? new SessionTerminationRequestImpl(message) : new SessionTerminationAnswerImpl(message);
//      case ReAuthAnswer.commandCode: // RAR/RAA
//        return isRequest ? new ReAuthRequestImpl(message) : new ReAuthAnswerImpl(message);
//
//      default:
//        return new ExtensionDiameterMessageImpl(message);
//    }
//  }
//
//  // Session Management --------------------------------------------------
//
//  /**
//   * Method for performing tasks when activity is created, such as informing SLEE about it and storing into internal map.
//   *
//   * @param ac the activity that has been created
//   */
//  private void addActivity(DiameterActivity ac, boolean suspended) {
//    try {
//      // Inform SLEE that Activity Started
//      DiameterActivityImpl activity = (DiameterActivityImpl) ac;
//
//      if (suspended) {
//        sleeEndpoint.startActivitySuspended(activity.getActivityHandle(), activity, MARSHALABLE_ACTIVITY_FLAGS);
//      }
//      else {
//        sleeEndpoint.startActivity(activity.getActivityHandle(), activity, MARSHALABLE_ACTIVITY_FLAGS);
//      }
//
//      // Set the listener
//      activity.setSessionListener(this);
//
//      // Put it into our activities map
//      activities.put(activity.getActivityHandle(), activity);
//
//      if(tracer.isInfoEnabled()) {
//        tracer.info("Activity started [" + activity.getActivityHandle() + "]");
//      }
//    }
//    catch (Exception e) {
//      tracer.severe("Error creating activity", e);
//
//      throw new RuntimeException("Error creating activity", e);
//    }
//  }
//
//  // Private Methods -----------------------------------------------------
//
//  /**
//   * Initializes the RA Diameter Stack.
//   *
//   * @throws Exception
//   */
//  private synchronized void initStack() throws Exception {
//    // Register in the Mux as an app listener.
//    this.diameterMux.registerListener(this, (ApplicationId[]) authApplicationIds.toArray(new ApplicationId[authApplicationIds.size()]));
//
//    // Get the stack (should not mess with)
//    this.stack = this.diameterMux.getStack();
//
//    if(tracer.isInfoEnabled()) {
//      tracer.info("Diameter SLh RA :: Successfully initialized stack.");
//    }
//  }
//
//  private void initActivitiesMgmt() {
//    final DiameterRAInterface lst = this;
//    if (this.ftRAContext.isLocal()) {
//      // local mgmt;
//      if(tracer.isInfoEnabled()) {
//        tracer.info(raContext.getEntityName() + " -- running in LOCAL mode.");
//      }
//      this.activities = new LocalDiameterActivityManagement(this.raContext, activityRemoveDelay);
//    }
//    else {
//      if(tracer.isInfoEnabled()) {
//        tracer.info(raContext.getEntityName() + " -- running in CLUSTER mode.");
//      }
//      final org.mobicents.slee.resource.cluster.ReplicatedData<String, DiameterActivity> clusteredData = this.ftRAContext.getReplicateData(true);
//      // get special one
//      this.activities = new AbstractClusteredDiameterActivityManagement(this.ftRAContext, activityRemoveDelay,this.raContext.getTracer(""), stack, this.raContext.getSleeTransactionManager(), clusteredData) {
//
//        @Override
//        protected void performBeforeReturn(DiameterActivityImpl activity) {
//          // do all the dirty work;
//          try {
//            Session session = null;
//            if (activity.getClass().equals(DiameterActivityImpl.class)) {
//              // check as first. since it requires session recreation.
//              // JIC: is this required?
//              session = this.diameterStack.getSessionFactory().getNewSession(activity.getSessionId());
//              performBeforeReturnOnBase(activity, session);
//              return;
//            }
//            else if (activity instanceof SLhClientSessionActivity) {
//              SLhClientSessionActivityImpl acc = (SLhClientSessionActivityImpl) activity;
//              ClientSLhSession appSession = this.diameterStack.getSession(activity.getSessionId(), ClientSLhSession.class);
//              session = appSession.getSessions().get(0);
//              performBeforeReturnOnBase(activity, session);
//              performBeforeReturnSLh(acc, session);
//              performBeforeReturnCC(acc);
//              acc.setSession(appSession);
//            }
//            else if (activity instanceof SLhServerSessionActivity) {
//              SLhServerSessionActivityImpl acc = (SLhServerSessionActivityImpl) activity;
//              ServerSLhSession appSession = this.diameterStack.getSession(activity.getSessionId(), ServerSLhSession.class);
//              session = appSession.getSessions().get(0);
//              performBeforeReturnOnBase(activity, session);
//              performBeforeReturnSLh(acc, session);
//              performBeforeReturnCC(acc);
//              acc.setSession(appSession);
//            }
//            else {
//              throw new IllegalArgumentException("Unknown activity type: " + activity);
//            }
//          }
//          catch (Exception e) {
//            throw new DiameterException(e);
//          }
//        }
//
//        private void performBeforeReturnSLh(SLhServerSessionActivityImpl acc, Session session) {
//          SLhMessageFactoryImpl messageFactory = new SLhMessageFactoryImpl(baseMessageFactory, session.getSessionId(), stack);
//
//          // Set the first configured Application-Id as default for message factory
//          ApplicationId firstAppId = authApplicationIds.get(0);
//          messageFactory.setApplicationId(firstAppId.getVendorId(), firstAppId.getAuthAppId());
//
//          acc.setSLhMessageFactory(messageFactory);
//          // acc.setSLhAvpFactory(slhAvpFactory);
//        }
//
//        private void performBeforeReturnSLh(SLhClientSessionActivityImpl acc, Session session) {
//          SLhMessageFactoryImpl messageFactory = new SLhMessageFactoryImpl(baseMessageFactory, session.getSessionId(), stack);
//
//          // Set the first configured Application-Id as default for message factory
//          ApplicationId firstAppId = authApplicationIds.get(0);
//          messageFactory.setApplicationId(firstAppId.getVendorId(), firstAppId.getAuthAppId());
//
//          acc.setSLhMessageFactory(messageFactory);
//          // acc.setSLhAvpFactory(slhAvpFactory);
//        }
//
//        private void performBeforeReturnOnBase(DiameterActivityImpl ac, Session session) {
//          DiameterMessageFactoryImpl msgFactory = new DiameterMessageFactoryImpl(session, stack, new DiameterIdentity[] {});
//          ac.setAvpFactory(baseAvpFactory);
//          ac.setMessageFactory(msgFactory);
//          ac.setCurrentWorkingSession(session);
//          ac.setSessionListener(lst);
//        }
//
//        @Override
//        public DiameterActivity get(DiameterActivityHandle handle) {
//          return super.get(handle);
//        }
//
//        @Override
//        public void put(DiameterActivityHandle handle, DiameterActivity activity) {
//          super.put(handle, activity);
//        }
//
//        @Override
//        public DiameterActivity remove(DiameterActivityHandle handle) {
//          return super.remove(handle);
//        }
//      };
//    }
//  }
//
//  /**
//   * Create the Diameter Activity Handle for an given session id
//   *
//   * @param sessionId the session identifier to create the activity handle from
//   * @return a DiameterActivityHandle for the provided sessionId
//   */
//  protected DiameterActivityHandle getActivityHandle(String sessionId) {
//    return new DiameterActivityHandle(sessionId);
//  }
//
//  // NetworkReqListener Implementation -----------------------------------
//
//  public Answer processRequest(Request request) {
//    if(tracer.isInfoEnabled()) {
//      tracer.info("Diameter SLh RA :: Got Request. Command-Code[" + request.getCommandCode() + "]");
//    }
//
//    // Here we receive initial request for which session does not exist!
//    // Valid messages are:
//    // * RIR - if we act as server, this is the message we receive
//    // * NO other message should make it here, if it gets its an error ?
//    // FIXME: baranowb: check if ACR is vald here also
//    if(request.getCommandCode() == LCSRoutingInfoRequest.commandCode) {
//      DiameterActivity activity;
//
//      try {
//        activity = raProvider.createActivity(request);
//
//        if(activity == null) {
//          tracer.severe("Diameter SLh RA :: Failed to create session, Command-Code: " + request.getCommandCode() + ", Session-Id: " + request.getSessionId());
//        }
//        else {
//          // We can only have server session?, but for sake error catching
//          if(activity instanceof SLhServerSessionActivity) {
//            SLhServerSessionActivityImpl session = (SLhServerSessionActivityImpl) activity;
//            ((ServerSLhSessionImpl)session.getSession()).processRequest(request);
//          }
//        }
//      }
//      catch (CreateActivityException e) {
//        tracer.severe("Failure trying to create SLh Activity.", e);
//      }
//
//      // Returning null so we can answer later
//      return null;
//    }
//    else {
//      if(tracer.isInfoEnabled()) {
//        tracer.info("Diameter SLh RA :: Received unexpected Request. Either its not RIR or session should exist to handle this, Command-Code: " + request.getCommandCode() + ", Session-Id: " + request.getSessionId());
//      }
//    }
//
//    return null;
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see org.jdiameter.api.EventListener#receivedSuccessMessage(org.jdiameter.api.Message, org.jdiameter.api.Message)
//   */
//  public void receivedSuccessMessage(Request request, Answer answer) {
//    if(tracer.isFineEnabled()) {
//      tracer.fine("Diameter SLh RA :: receivedSuccessMessage :: " + "Request[" + request + "], Answer[" + answer + "].");
//    }
//
//    tracer.warning("Resource Adaptor should not receive this (receivedSuccessMessage), a session should exist to handle it.");
//
//    try {
//      if(tracer.isInfoEnabled()) {
//        tracer.info("Received Message Result-Code: " + answer.getResultCode().getUnsigned32());
//      }
//    }
//    catch (AvpDataException ignore) {
//      // ignore, this was just for informational purposes...
//    }
//  }
//
//  /*
//   * (non-Javadoc)
//   * @see org.jdiameter.api.EventListener#timeoutExpired(org.jdiameter.api.Message)
//   */
//  public void timeoutExpired(Request request) {
//    if(tracer.isInfoEnabled()) {
//      tracer.info("Diameter SLh RA :: timeoutExpired :: " + "Request[" + request + "].");
//    }
//
//    tracer.warning("Resource Adaptor should not receive this (timeoutExpired), a session should exist to handle it.");
//
//    try {
//      // Message delivery timed out - we have to remove activity
//      ((DiameterActivity) getActivity(getActivityHandle(request.getSessionId()))).endActivity();
//    }
//    catch (Exception e) {
//      tracer.severe("Failure processing timeout message.", e);
//    }
//  }
//
//  // SLh/RIA Session Creation Listener --------------------------------------
//
//  public void sessionCreated(ClientSLhSession ccClientSession) {
//    // Make sure it's a new session and there's no activity created yet.
//    if(this.getActivity(getActivityHandle(ccClientSession.getSessions().get(0).getSessionId())) != null) {
//      tracer.warning("Activity found for created Credit-Control Client Session. Shouldn't exist. Aborting.");
//      return;
//    }
//
//    // Create Client Activity
//    SLhClientSessionActivityImpl activity = new SLhClientSessionActivityImpl(slhMessageFactory, slhAvpFactory, ccClientSession, null, null, stack);
//
//    //FIXME: baranowb: add basic session mgmt for base? or do we rely on responses?
//    //session.addStateChangeNotification(activity);
//    activity.setSessionListener(this);
//    addActivity(activity, false /*true*/);
//  }
//
//  public void sessionCreated(ServerSLhSession ccServerSession)
//  {
//    // Make sure it's a new session and there's no activity created yet.
//    if(this.getActivity(getActivityHandle(ccServerSession.getSessions().get(0).getSessionId())) != null) {
//      tracer.warning("Activity found for created LCS Routing-Info Server Session. Shouldn't exist. Aborting.");
//      return;
//    }
//
//    // Create Server Activity
//    SLhServerSessionActivityImpl activity = new SLhServerSessionActivityImpl(slhMessageFactory, slhAvpFactory, ccServerSession, null, null, stack);
//
//    //FIXME: baranowb: add basic session mgmt for base? or do we rely on responses?
//    //session.addStateChangeNotification(activity);
//    activity.setSessionListener(this);
//    addActivity(activity, false);
//  }
//
//  public boolean sessionExists(String sessionId) {
//    return this.activities.containsKey(getActivityHandle(sessionId));
//  }
//
//  public void sessionDestroyed(String sessionId, Object appSession) {
//    try {
//      this.sleeEndpoint.endActivity(getActivityHandle(sessionId));
//    }
//    catch (Exception e) {
//      tracer.severe("Failure Ending Activity with Session-Id[" + sessionId + "]", e);
//    }
//  }
//
//  // Provider Implementation ---------------------------------------------
//
//  private class SLhProviderImpl implements SLhProvider {
//
//    private DiameterSLhResourceAdaptor ra;
//    private Validator validator = new ValidatorImpl();
//
//    public SLhProviderImpl(DiameterSLhResourceAdaptor ra) {
//      this.ra = ra;
//    }
//
//    public SLhClientSessionActivity createSLhClientSessionActivity() throws CreateActivityException {
//      try {
//        ClientSLhSession session = ((ISessionFactory) stack.getSessionFactory()).getNewAppSession(null, authApplicationIds.get(0), ClientSLhSession.class, new Object[]{});
//        sessionCreated(session);
//        if (session == null) {
//          tracer.severe("Failure creating SLh Client Session (null).");
//          return null;
//        }
//
//        return  (SLhClientSessionActivity) getActivity(getActivityHandle(session.getSessions().get(0).getSessionId()));
//      }
//      catch (Exception e) {
//        throw new CreateActivityException(e);
//      }
//    }
//
//    public SLhClientSessionActivity createSLhClientSessionActivity(DiameterIdentity destinationHost, DiameterIdentity destinationRealm) throws CreateActivityException {
//      SLhClientSessionActivityImpl clientSession = (SLhClientSessionActivityImpl) this.createSLhClientSessionActivity();
//
//      clientSession.setDestinationHost(destinationHost);
//      clientSession.setDestinationRealm(destinationRealm);
//
//      return clientSession;
//    }
//
//    public SLhAvpFactory getSLhAvpFactory() {
//      return this.ra.slhAvpFactory;
//    }
//
//    public SLhMessageFactory getSLhMessageFactory() {
//      return this.ra.slhMessageFactory;
//    }
//
//    public LCSRoutingInfoAnswer sendLCSRoutingInfoRequest(LCSRoutingInfoRequest rir) throws IOException {
//      try {
//        DiameterActivityImpl activity = (DiameterActivityImpl) getActivity(getActivityHandle(rir.getSessionId()));
//
//        if (activity == null) {
//          activity = (DiameterActivityImpl) createActivity(((DiameterMessageImpl)rir).getGenericData());
//        }
//
//        return (LCSRoutingInfoAnswer) activity.sendSyncMessage(rir);
//      }
//      catch (Exception e) {
//        tracer.severe("Failure sending sync request.", e);
//      }
//
//      // FIXME Throw unknown message exception?
//      return null;
//    }
//
//
//    private DiameterActivity createActivity(Message message) throws CreateActivityException {
//      DiameterActivity activity = activities.get(getActivityHandle(message.getSessionId()));
//
//      if (activity == null) {
//        if (message.isRequest()) {
//          return createSLhServerSessionActivity((Request) message);
//        }
//        else {
//          AvpSet avps = message.getAvps();
//          Avp avp = null;
//
//          DiameterIdentity destinationHost = null;
//          DiameterIdentity destinationRealm = null;
//
//          if ((avp = avps.getAvp(Avp.DESTINATION_HOST)) != null) {
//            try {
//              destinationHost = new DiameterIdentity(avp.getDiameterIdentity());
//            }
//            catch (AvpDataException e) {
//              tracer.severe("Failed to extract Destination-Host from Message.", e);
//            }
//          }
//
//          if ((avp = avps.getAvp(Avp.DESTINATION_REALM)) != null) {
//            try {
//              destinationRealm = new DiameterIdentity(avp.getDiameterIdentity());
//            }
//            catch (AvpDataException e) {
//              tracer.severe("Failed to extract Destination-Realm from Message.", e);
//            }
//          }
//
//          return (DiameterActivity) createSLhClientSessionActivity(destinationHost, destinationRealm);
//        }
//      }
//
//      return activity;
//    }
//
//    private DiameterActivity createSLhServerSessionActivity(Request message) throws CreateActivityException {
//      try {
//        ServerSLhSession session = ((ISessionFactory) stack.getSessionFactory()).getNewAppSession(message.getSessionId(), authApplicationIds.get(0), ServerSLhSession.class, new Object[]{});
//        sessionCreated(session);
//        if (session == null) {
//          tracer.severe("Failure creating SLh Server Session (null).");
//          return null;
//        }
//
//        return  (DiameterActivity) getActivity(getActivityHandle(session.getSessions().get(0).getSessionId()));
//      }
//      catch (Exception e) {
//        throw new CreateActivityException(e);
//      }
//    }
//
//    public DiameterIdentity[] getConnectedPeers() {
//      return ra.getConnectedPeers();
//    }
//
//    public int getPeerCount() {
//      return ra.getConnectedPeers().length;
//    }
//
//    /* (non-Javadoc)
//     * @see net.java.slee.resource.diameter.slh.SLhProvider#getValidator()
//     */
//    @Override
//    public Validator getValidator() {
//      return this.validator;
//    }
//  }
//
//  public DiameterIdentity[] getConnectedPeers() {
//    if (this.stack != null) {
//      try {
//        // Get the list of peers from the stack
//        List<Peer> peers = stack.unwrap(PeerTable.class).getPeerTable();
//
//        DiameterIdentity[] result = new DiameterIdentity[peers.size()];
//
//        int i = 0;
//
//        // Get each peer from the list and make a DiameterIdentity
//        for (Peer peer : peers) {
//          DiameterIdentity identity = new DiameterIdentity(peer.getUri().toString());
//
//          result[i++] = identity;
//        }
//
//        return result;
//      }
//      catch (Exception e) {
//        tracer.severe("Failure getting peer list.", e);
//      }
//    }
//
//    return new DiameterIdentity[0];
//  }
//
//}
