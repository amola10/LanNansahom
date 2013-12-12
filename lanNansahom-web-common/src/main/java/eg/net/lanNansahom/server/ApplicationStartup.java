package eg.net.lanNansahom.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class ApplicationStartup implements ServletContextListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1566710643710949366L;
	private static final Logger LOGGER = Logger.getLogger(ApplicationStartup.class);

	public void contextInitialized(ServletContextEvent arg0) {
		long start = System.currentTimeMillis();
		ServiceLocator.getInstance();
		long end = System.currentTimeMillis();
		LOGGER.error("System starts in :" + (end - start));

	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
