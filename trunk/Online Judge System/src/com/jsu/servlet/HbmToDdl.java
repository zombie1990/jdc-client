/**
 * 
 */
package com.jsu.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.jsu.hibernate.domains.Tools4hbm2ddl;

/**
 * @author Administrator
 *
 */
public class HbmToDdl implements ServletContextListener {

	private final static Logger log = Logger.getLogger(HbmToDdl.class);
	
	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try {
			
			Tools4hbm2ddl.main(null);
			
		} catch (Exception e) {
			log.error("----hbm to ddl error----");
		}
		
	}

}
