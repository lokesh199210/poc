package com.liferay.logviewer.websocket;

import com.liferay.logviewer.appender.LogAppender;

import java.util.Enumeration;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.osgi.service.component.annotations.Component;


@Component(immediate = true, property = {
		"org.osgi.http.websocket.endpoint.path=" + LogViewerWebSocket.ECHO_WEBSOCKET_PATH }, service = Endpoint.class)
public class LogViewerWebSocket extends Endpoint {

	public static final String ECHO_WEBSOCKET_PATH = "/o/echo";
	private static LogAppender lAppender = null;
	public static Session socket_session;

	@Override
	public void onOpen(final Session session, EndpointConfig endpointConfig) {

		socket_session = session;

		session.addMessageHandler(new MessageHandler.Whole<String>() {

			@Override
			public void onMessage(String text) {

				Logger appLog = Logger.getRootLogger();
				lAppender = new LogAppender();
				lAppender.setThreshold(Level.toLevel(text));
				
				appLog.addAppender(lAppender);
			}
		});
	}

	@Override
	public void onClose(Session session, CloseReason closeReason) {

		Logger appLog = Logger.getRootLogger();
		lAppender.close();
		@SuppressWarnings("rawtypes")
		Enumeration appenders = appLog.getAllAppenders();
		while (appenders.hasMoreElements()) {
			Appender apndr = (Appender) appenders.nextElement();
			if (apndr.getClass().getName() == LogAppender.class.getName()) {
				appLog.removeAppender(lAppender);
			}
		}
		super.onClose(session, closeReason);
	}
}
