package by.htp.ex.controller.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.connection.ConnectionPool;
import by.htp.ex.connection.ConnectionPoolException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
	private final static Logger LOG = LogManager.getLogger(ContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ConnectionPool.getInstance().initPoolData();
		} catch (ConnectionPoolException e) {
			LOG.error(e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ConnectionPool.getInstance().dispose();
	}
}
