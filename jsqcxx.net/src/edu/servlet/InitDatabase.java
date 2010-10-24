package edu.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import tools.Hbm2Ddl;

/**
 * @author xiyu
 *
 */
public class InitDatabase implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			Hbm2Ddl.main(null);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
