=================================================
 Restcomm Diameter : SLg Resource Adaptor
=================================================
                                     v1.0.0.GA

 Welcome to the Restcomm Diameter SLg Resource Adaptor v1.0.0.GA release!

--------------
 Introduction
--------------

 This is the SLg RA release of Restcomm Diameter solution.

 This RA provides the SLg interface application implementation of Diameter
 for JAIN SLEE and depends on the Restcomm Diameter Mux to be deployed before using it.


------------------
 Release Contents
------------------

  diameter-slg-ra-DU-1.0.0.GA.jar (the JAIN SLEE Deployable Unit to be installed in Restcomm)

  slg-ratype-1.0.0.GA-sources.jar (source files for this Resource Adaptor Type)

  slg-ratype-1.0.0.GA-javadoc.jar (javadoc documentation for this Resource Adaptor Type)

  slg-ra-1.0.0.GA-sources.jar (source files for this Resource Adaptor)

  slg-ra-1.0.0.GA-javadoc.jar (javadoc documentation for this Resource Adaptor)

  du-management.xml (the auxiliar build file for managing deployment/undeployment)

  build.xml (the ant build file for deploying/undeploying the RA)

----------------
 How to Use it?
----------------

 In order to deploy/undeploy and correctly activate/deactivate the Resource Adaptor, you can:

 1) Simply copy the DU jar to the deploy folder of the JBoss running Restcomm or delete it from the deploy folder to
    uninstall it;

 2) Use the provided build.xml file and call the desired targets:
    - deploy/deploy-jmx for hard deploying or deploying via JMX interoace;
    - undeploy/undeploy-jmx for hard undeploying or undeploying via JMX interoace;

------------------
 More Information
------------------

 For more detailed information, please visit the following sites:

  * Restcomm Diameter SLg (RA & Examples) Page (http://groups.google.com/ group/restcomm-public/web/restcomm-diameter-slg)

  * Restcomm Diameter Page (http://groups.google.com/group/restcomm-public/web/restcomm-diameter)

  * jDiameter Homepage (http://jdiameter.dev.java.net)

  * Restcomm Google Group, for posting questions (http://groups.google.com/group/restcomm-public)

  * Restcomm Homepage (http://www.restcomm.com)
