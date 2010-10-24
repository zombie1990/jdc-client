/**
 * 
 */
package com.jsu.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.jsu.judge.GCCThread;
import com.jsu.judge.GPPThread;
import com.jsu.judge.JavaThread;
import com.jsu.judge.PascalThread;
import com.jsu.util.ContestTimer;

/**
 * @author Administrator
 *
 */
public class JudgeCoreListener implements ServletContextListener {

	private final static Logger log = Logger.getLogger(JudgeCoreListener.class);
	private GCCThread gcc = new GCCThread();
	private GPPThread gpp = new GPPThread();
	private JavaThread java = new JavaThread();
	private PascalThread pascal = new PascalThread();
	private ContestTimer contestTimer = new ContestTimer();
	
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		log.info("----Judge Core Has Been Closed----");
		
	}

	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try {
			gcc.setDaemon(true);
			gpp.setDaemon(true);
			java.setDaemon(true);
			pascal.setDaemon(true);
			contestTimer.setDaemon(true);
			
			contestTimer.start();
			gcc.start();
			gpp.start();
			java.start();
			pascal.start();
			log.info("----Judge Core Has Been Initialized----");
			
		} catch (Exception e) {
			log.error("----Start Judge Core Error----");
		}
		
	}

}
