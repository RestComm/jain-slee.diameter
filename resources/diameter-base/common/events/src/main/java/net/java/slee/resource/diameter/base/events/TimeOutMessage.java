
package net.java.slee.resource.diameter.base.events;

import net.java.slee.resource.diameter.base.events.avp.DiameterIdentity;
import net.java.slee.resource.diameter.base.events.avp.ProxyInfoAvp;

/**
 * 
 * Defines an interface representing the Time out message command.
 *
 */
public interface TimeOutMessage extends DiameterMessage {
   int commandCode = 999;
}

