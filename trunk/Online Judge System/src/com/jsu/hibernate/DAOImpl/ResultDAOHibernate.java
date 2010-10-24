/**
 * 
 */
package com.jsu.hibernate.DAOImpl;

import java.util.Iterator;
import java.util.List;

import com.jsu.DAO.ResultDAO;
import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Result;
import com.jsu.hibernate.domains.User;

/**
 * @author Administrator
 *
 */
public class ResultDAOHibernate extends GeneralHibernateDAO<Result, String> implements
		ResultDAO {
	
	public Result findByReferrence(User user, Contest contest, Problem problem) {
		
		String queryString = "from Result r"
							+ " where r.user = :user"
							+ " and r.contest = :contest"
							+ " and r.problem = :problem";
		Result result = (Result)getSession().createQuery(queryString)
											.setEntity("user", user)
											.setEntity("contest", contest)
											.setEntity("problem", problem)
											.setMaxResults(1)
											.uniqueResult();
		return result;
	}
	
	public int getTotalSolved(User user, Contest contest) {
		
		String queryString = "select count(r) from Result r"
							+ " where r.user = :user"
							+ " and r.contest= :contest"
							+ " and r.AC = :isSolved";
		Integer SolvedCount = (Integer)getSession().createQuery(queryString)
											 .setEntity("user", user)
											 .setEntity("contest", contest)
											 .setParameter("isSolved", 1)
											 .uniqueResult();
		return SolvedCount;
	}
	
	public int getTotalTime(User user, Contest contest) {
		
		String queryString = "select r.time from Result r"
							+ " where r.user = :user"
							+ " and r.contest = :contest";
		@SuppressWarnings("unchecked")
		List<Integer> list = getSession().createQuery(queryString)
										 .setEntity("user", user)
										 .setEntity("contest", contest)
										 .list();
		Iterator<Integer> iter = list.iterator();
		int TotalTime = 0;
		while (iter.hasNext()) {
			TotalTime += iter.next();
		}
		return TotalTime;
	}
	
	public List<User> getUsers(Contest contest) {
		
		String query = "select distinct r.user from Result r"
					+ " where r.contest = :contest"
					+ " group by r.user"
					+ " order by sum(r.AC) desc, sum(r.time) asc";
		@SuppressWarnings("unchecked")
		List<User> list = getSession().createQuery(query)
										 .setEntity("contest", contest)
										 .list();
		return list;
	}
	
	public List<Result> getUserResult(User user, Contest contest) {
		
		String queryString = "from Result r"
							+ " where r.user = :user"
							+ " and r.contest = :contest"
							+ " order by r.problemIdInContest asc";
		@SuppressWarnings("unchecked")
		List<Result> list = getSession().createQuery(queryString)
										 .setEntity("user", user)
										 .setEntity("contest", contest)
										 .list();
		
		return list;
	}

}
