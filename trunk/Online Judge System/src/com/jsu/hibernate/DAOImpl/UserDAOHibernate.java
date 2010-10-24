/**
 * 
 */
package com.jsu.hibernate.DAOImpl;

import java.util.List;

import com.jsu.DAO.UserDAO;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.User;

/**
 * @author Administrator
 *
 */
public class UserDAOHibernate extends GeneralHibernateDAO<User, String> implements
		UserDAO {

	public List<User> getPageUserRanklist(int start, int size) {
		
	    String hql="from User user order by user.solved desc, user.accept desc, user.submit asc";
	    
	    @SuppressWarnings("unchecked")
		List<User> users = (List<User>)getSession().createQuery(hql)
											     .setFirstResult(start)
											     .setMaxResults(size)
											     .list();
		
		return users;
	}
	
	public List<User> getPageUserRanklist(String username, int start, int size) {
		
	    String hql="from User user"
	    		+ " where user.username like :username"
	    		+ " order by user.solved desc, user.accept desc, user.submit asc";
	    String temp = "%" + username + "%";
	    @SuppressWarnings("unchecked")
		List<User> users = (List<User>)getSession().createQuery(hql)
												.setParameter("username", temp)
											     .setFirstResult(start)
											     .setMaxResults(size)
											     .list();
		
		return users;
	}

	public Integer getUserCount() {
		
		String hql = "select count(u) from User u";
		
		return (Integer)getSession().createQuery(hql).uniqueResult();
	}
	
	public Integer getUserCount(String username) {
		
		String hql = "select count(u) from User u where u.username like :username";
		String temp = "%" + username + "%";
		return (Integer)getSession().createQuery(hql).setParameter("username", temp).uniqueResult();
	}
	
	public Integer getUserRank(User user) {
		
		String hql = "select count(u) from User u"
					+ " where u.solved > :solved"
					+ " or u.solved = :solved and u.submit < :submit"
					+ " or u.solved = :solved and u.submit = :submit and u.accept = :accept";

		Integer number = (Integer)getSession().createQuery(hql)
											.setParameter("solved", user.getSolved())
											.setParameter("submit", user.getSubmit())
											.setParameter("accept", user.getAccept())
											.uniqueResult();
		return (number + 1);
	}

	public List<Problem> getSolvedProblems(User user) {
		String hql = "select distinct s.problem from Solution s"
					+ " inner join s.problem as p"
					+ " where s.user = :user"
					+ " and s.status = 1"
					+ " and p.defunct = :defunct";
		@SuppressWarnings("unchecked")
		List<Problem> list = getSession().createQuery(hql)
										.setEntity("user", user)
										.setParameter("defunct", "N")
										.list();
		return list;
	}
	
}
