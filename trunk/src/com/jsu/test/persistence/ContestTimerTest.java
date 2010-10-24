/**
 * 
 */
package com.jsu.test.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Ranklist;
import com.jsu.hibernate.domains.Result;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.jsu.util.HibernateUtil;

/**
 * @author Administrator
 *
 */
public class ContestTimerTest extends TestCase {

	public void testContestTimer() {
		DAOFactory.getInstance().getContestDAO().updateContestStatus(new Date());
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
	
	public void testInContest() {
		
		Contest contest = DAOFactory.getInstance().getContestDAO().findById(1, false);
//		List<Solution> list = DAOFactory.getInstance().getSolutionDAO().findByPageInContest(1, 16, contest);
		System.out.println(contest);
	}
	
	public void testResult() {
		
		try {
			List<Ranklist> list = new ArrayList<Ranklist>();
			
			Contest contest = DAOFactory.getInstance().getContestDAO().findById(1, false);
			List<User> users = DAOFactory.getInstance().getResultDAO().getUsers(contest);
			Iterator<User> iter = users.iterator();
			while(iter.hasNext()) {
				Ranklist r = new Ranklist();
				User user = iter.next();
				System.out.println(user.getUsername());
				int totalSolved = DAOFactory.getInstance().getResultDAO().getTotalSolved(user, contest);
				int totalTime = DAOFactory.getInstance().getResultDAO().getTotalTime(user, contest);
				List<Result> results = DAOFactory.getInstance().getResultDAO().getUserResult(user, contest);
				r.setUser(user);
				r.setTotalSolved(totalSolved);
				r.setTotalTime(totalTime);
				r.setResults(results);
				list.add(r);
			}
			System.out.println(list);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
