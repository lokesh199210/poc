package com.honda.ws.soap.connection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;

/**
 * @author Vinisha Pathak
 *
 */
public class SOAPConnectionPool {
	public static SOAPConnectionPool soapConnectionPool = null;
	private final Set<SOAPConnection> pooledConnections = Collections.synchronizedSet(new HashSet<SOAPConnection>());
	private final Set<SOAPConnection> usedConnections = Collections.synchronizedSet(new HashSet<SOAPConnection>());

	private SOAPConnectionPool() {
	}

	/**
	 * Get Instance of SOAPConnectionPool
	 * 
	 * @return
	 */
	public static synchronized SOAPConnectionPool getInstance() {
		if (soapConnectionPool == null) {
			soapConnectionPool = new SOAPConnectionPool();
		}
		return soapConnectionPool;
	}

	/**
	 * Get soap connection
	 * 
	 * @return
	 * @throws SOAPException
	 */
	public SOAPConnection getConnection() throws SOAPException {
		Iterator<SOAPConnection> iter;
		SOAPConnection connection = null;
		if (pooledConnections.size() > 0) {
			iter = pooledConnections.iterator();
			connection = iter.next();
			pooledConnections.remove(connection);
			usedConnections.add(connection);
		} else {
			connection = createConnection();
			usedConnections.add(connection);
		}
		return connection;
	}

	/**
	 * Release soap connection
	 * 
	 * @param connection
	 */
	public void releaseConnection(SOAPConnection connection) {
		if (usedConnections.contains(connection)) {
			usedConnections.remove(connection);
			pooledConnections.add(connection);
		}
	}

	private synchronized SOAPConnection createConnection() throws SOAPException {
		return SOAPConnectionFactory.newInstance().createConnection();
	}

	/**
	 * finalize call
	 * 
	 */
	protected void finalize() throws SOAPException {
		if (usedConnections.isEmpty()) {
			for (SOAPConnection connection : pooledConnections) {
				connection.close();
			}
			pooledConnections.clear();
		}
	}
}
