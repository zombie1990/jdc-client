/**
 * 
 */
package com.jsu.util;

import java.util.Date;


/**
 * @author Administrator
 *
 */
public class ContestTimer extends Thread {

	public void run() {
		while (true) {
			try {
				Date now = new Date();
				DAOFactory.getInstance().getContestDAO().updateContestStatus(now);
				HibernateUtil.commitTransaction();
				HibernateUtil.closeSession();
			
				Thread.sleep(60000);
			} catch(Exception e) {
			}
			
		}
	}
}
