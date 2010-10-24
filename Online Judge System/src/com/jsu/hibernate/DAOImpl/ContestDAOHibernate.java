/**
 * 
 */
package com.jsu.hibernate.DAOImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

import com.jsu.DAO.ContestDAO;
import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.User;

/**
 * @author Administrator
 *
 */
public class ContestDAOHibernate extends GeneralHibernateDAO<Contest, Integer> implements
		ContestDAO {

	public List<Contest> findByReferrence(String diy, Integer status, int start, int size, String defunct) {
		
		String desc = "from Contest c"
					+ " where c.diy = :diy"
					+ " and c.status = :status"
					+ " and c.defunct = :defunct"
					+ " order by c.startTime desc";
		
		String asc = "from Contest c"
			+ " where c.diy = :diy"
			+ " and c.status = :status"
			+ " and c.defunct = :defunct"
			+ " order by c.startTime asc";

		@SuppressWarnings("unchecked")
		List<Contest> contests = getSession().createQuery(status==2?desc:asc)
											.setParameter("diy", diy)
											.setParameter("status", status)
											.setParameter("defunct", defunct)
											.setFirstResult(start)
											.setMaxResults(size)
											.list();
		return contests;
	}
	
	public List<Contest> getMyContests(User user, Integer status, int start, int size) {
		
		String hql = "from Contest c"
			+ " where c.user = :user"
			+ " and c.status = :status"
			+ " order by c.startTime desc";
		
		@SuppressWarnings("unchecked")
		List<Contest> contests = getSession().createQuery(hql)
											.setParameter("user", user)
											.setParameter("status", status)
											.setFirstResult(start)
											.setMaxResults(size)
											.list();
		return contests;
	}
	
	public Integer getContestCount(String diy, Integer status, String defunct) {
		
		String hql = "select count(i) from Contest i"
					+ " where i.diy = :diy"
					+ " and i.status = :status"
					+ " and i.defunct = :defunct";
		Integer count = (Integer)getSession().createQuery(hql)
											.setParameter("diy", diy)
											.setParameter("status", status)
											.setParameter("defunct", defunct)
											.uniqueResult();
		return count;
	}
	
	public Integer getContestCount(User user, Integer status) {
		
		String hql = "select count(i) from Contest i"
					+ " where i.user = :user"
					+ " and i.status = :status";
		Integer count = (Integer)getSession().createQuery(hql)
											.setParameter("user", user)
											.setParameter("status", status)
											.uniqueResult();
		return count;
	}
	
	public void updateContestStatus(Date now) {
		
		String query = "from Contest c"
					+ " where c.status = 0"
					+ " or c.status = 1";
		ScrollableResults contests = getSession().createQuery(query)
												.setCacheMode(CacheMode.IGNORE)
												.scroll(ScrollMode.FORWARD_ONLY);
		int count=0;
		while ( contests.next() ) {
		    Contest contest = (Contest) contests.get(0);
		    if(contest.getStartTime().before(now)) {
		    	contest.setStatus(1);
		    }
		    if(contest.getEndTime().before(now)) {
		    	contest.setStatus(2);
		    }
		    if ( ++count % 20 == 0 ) {
		        //flush a batch of updates and release memory:
		        this.flush();
		        this.clear();
		    }
		}
	}

	public List<Contest> findByHolder(User user, String diy) {
		String hql = "from Contest c"
				+ " where c.user = :user"
				+ " and c.diy = :diy"
				+ " and c.defunct = :defunct"
				+ " order by c.startTime desc";
		@SuppressWarnings("unchecked")
		List<Contest> list = getSession().createQuery(hql)
										.setEntity("user", user)
										.setParameter("diy", diy)
										.setParameter("defunct", "N")
										.list();
		return list;
	}

	public List<Contest> findByTitle(String title, String diy) {
		String hql = "from Contest c"
			+ " where c.title like :title"
			+ " and c.diy = :diy"
			+ " and c.defunct = :defunct"
			+ " order by c.startTime desc";
		String temp = "%" + title + "%";
		@SuppressWarnings("unchecked")
		List<Contest> list = getSession().createQuery(hql)
										.setParameter("title", temp)
										.setParameter("diy", diy)
										.setParameter("defunct", "N")
										.list();
		return list;
	}
	
	
}
