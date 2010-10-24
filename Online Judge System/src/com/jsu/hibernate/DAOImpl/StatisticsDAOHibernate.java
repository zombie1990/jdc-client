/**
 * 
 */
package com.jsu.hibernate.DAOImpl;

import java.util.List;

import com.jsu.DAO.StatisticsDAO;
import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Statistics;

/**
 * @author Administrator
 *
 */
public class StatisticsDAOHibernate extends GeneralHibernateDAO<Statistics, String>
		implements StatisticsDAO {

	public Statistics findByReferrence(Contest contest, Problem problem) {
		
		String queryString = "from Statistics s"
							+ " where s.contest = :contest"
							+ " and s.problem = :problem";
		Statistics statics = (Statistics)getSession().createQuery(queryString)
													.setEntity("contest", contest)
													.setEntity("problem", problem)
													.setMaxResults(1)
													.uniqueResult();
		return statics;
	}
	
	public Integer getCount(Contest contest) {
		
		String query = "select count(s) from Statistics s"
					+ " where s.contest = :contest";
		
		Integer count = (Integer)getSession().createQuery(query)
											.setEntity("contest", contest)
											.uniqueResult();
		return count;
	}
	
	public List<Statistics> findAllInContest(Contest contest) {
		
		String query = "from Statistics s"
					+ " where s.contest = :contest"
					+ " order by s.problemIdInContest asc";
	    @SuppressWarnings("unchecked")
		List<Statistics> stcs = (List<Statistics>)getSession().createQuery(query)
															.setEntity("contest", contest)
															.list();
	    return stcs;
	}
}
