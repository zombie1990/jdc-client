/**
 * 
 */
package com.jsu.hibernate.DAOImpl;

import java.util.List;

import javax.xml.ws.WebEndpoint;

import com.jsu.DAO.SolutionDAO;
import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Solution;
import com.jsu.hibernate.domains.User;

/**
 * @author Administrator
 *
 */
public class SolutionDAOHibernate extends GeneralHibernateDAO<Solution, String> implements
		SolutionDAO {

	public List<Solution> findInStatus(User user, Problem problem, Integer status) {
		String queryString = "from Solution s"
							+ " where s.user = :user"
							+ " and s.problem = :problem"
							+ " and s.status = :status";
		@SuppressWarnings("unchecked")
		List<Solution> solutions = getSession().createQuery(queryString)
							      				  .setEntity("user", user)
							      				  .setEntity("problem", problem)
							      				  .setParameter("status", status)
							      				  .list();
							      				  
		return solutions;
	}
	
	public List<Solution> findNotInStatus(User user, Problem problem, Integer status) {
		String queryString = "from Solution s"
							+ " where s.user = :user"
							+ " and s.problem = :problem"
							+ " and s.status != :status"
							+ " and s.status != :judging";
		@SuppressWarnings("unchecked")
		List<Solution> solutions = getSession().createQuery(queryString)
							      				  .setEntity("user", user)
							      				  .setEntity("problem", problem)
							      				  .setParameter("status", status)
							      				  .setParameter("judging", 0)
							      				  .list();
							      				  
		return solutions;
	}
	
	public List<Solution> findByPageInContest(int start, int size, Contest contest) {
		
		String queryString = "from Solution s"
							+ " where s.contest = :contest"
							+ " order by s.date desc";
		@SuppressWarnings("unchecked")
		List<Solution> solutions = getSession().createQuery(queryString)
												.setEntity("contest", contest)
												.setFirstResult(start)
												.setMaxResults(size)
												.list();
		return solutions;
	}
	
	public List<Solution> findByPage(int start, int size) {
		
		String queryString = "from Solution s"
							+" where s.contest = null"
							+ " order by s.date desc";
		@SuppressWarnings("unchecked")
		List<Solution> solutions = getSession().createQuery(queryString)
												.setFirstResult(start)
												.setMaxResults(size)
												.list();
		return solutions;
	}
	
	public Integer getSolutionCount() {
		
		String queryString = "select count(i) from Solution i where i.contest = null";
		Integer count = (Integer)getSession().createQuery(queryString).uniqueResult();
		return count;
	}
	
	public Integer getSolutionCount(Contest contest) {
		
		String queryString = "select count(i) from Solution i where i.contest = :contest";
		Integer count = (Integer)getSession().createQuery(queryString).setEntity("contest", contest).uniqueResult();
		return count;
	}

	public Integer getCountByLanguage(Integer language, Contest contest) {
		String hql1 = "select count(s) from Solution s" +
				" where s.language = :language" +
				" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
				" where s.language = :language" +
				" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setParameter("language", language)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setParameter("language", language)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
		
	}

	public Integer getCountByLanguageAndStatus(Integer language,
			Integer status, Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.language = :language" +
					" and s.status = :status" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.language = :language" +
					" and s.status = :status" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
								.setParameter("language", language)
								.setParameter("status", status)
								.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
								.setParameter("language", language)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.uniqueResult();
		}
		return count;
	}

	public Integer getCountByProblem(Problem problem, Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("problem", problem)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("problem", problem)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByProblemAndLanguage(Problem problem,
			Integer language, Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.language = :language" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solutions" +
					" where s.problem = :problem" +
					" and s.language = :language" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("problem", problem)
										.setParameter("language", language)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("problem", problem)
										.setParameter("language", language)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByProblemAndLanguageAndStatus(Problem problem,
			Integer language, Integer status, Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.language = :language" +
					" and s.status = :status" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.language = :language" +
					" and s.status = :status" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("problem", problem)
										.setParameter("language", language)
										.setParameter("status", status)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("problem", problem)
										.setParameter("language", language)
										.setParameter("status", status)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByProblemAndStatus(Problem problem, Integer status,
			Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					"and s.status = :status" +
					"and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.status = :status" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("problem", problem)
										.setParameter("status", status)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("problem", problem)
										.setParameter("status", status)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByProblemAndUser(Problem problem, User user,
			Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.user = :user" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.user = :user" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("problem", problem)
										.setEntity("user", user)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("problem", problem)
										.setEntity("user", user)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByProblemAndUserAndLanguage(Problem problem,
			User user, Integer language, Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.user = :user" +
					" and s.language = :language" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.user = :user" +
					" and s.language = :language" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("problem", problem)
										.setEntity("user", user)
										.setParameter("language", language)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("problem", problem)
										.setEntity("user", user)
										.setParameter("language", language)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByProblemAndUserAndStatus(Problem problem,
			User user, Integer status, Contest contest) {

		String hql1 = "select count(s) from Solution s " +
					" where s.problem = :problem" +
					" and s.user = :user" +
					" and s.status = :status" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.problem = :problem" +
					" and s.user = :user" +
					" and s.status = :status" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("problem", problem)
										.setEntity("user", user)
										.setParameter("status", status)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("problem", problem)
										.setEntity("user", user)
										.setParameter("status", status)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByStatus(Integer status, Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.status = :status" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.status = :status" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setParameter("status", status)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setParameter("status", status)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByUser(User user, Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.user = :user" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.user = :user" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("user", user)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("user", user)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByUserAndLanguage(User user, Integer language,
			Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.user = :user" +
					" and s.language = :language" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.user = :user" +
					" and s.language = :language" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("user", user)
										.setParameter("language", language)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("user", user)
										.setParameter("language", language)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByUserAndLanguageAndStatus(User user,
			Integer language, Integer status, Contest contest) {
		String hql1 = "select count(s) Solution s" +
					" where s.user = :user" +
					" and s.language = :language" +
					" and s.status = :status" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.user = :user" +
					" and s.language = :language" +
					" and s.status = :status" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("user", user)
										.setParameter("language", language)
										.setParameter("status", status)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("user", user)
										.setParameter("language", language)
										.setParameter("status", status)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public Integer getCountByUserAndStatus(User user, Integer status,
			Contest contest) {
		String hql1 = "select count(s) from Solution s" +
					" where s.user = :user" +
					" and s.status = :status" +
					" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
					" where s.user = :user" +
					" and s.status = :status" +
					" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
										.setEntity("user", user)
										.setParameter("status", status)
										.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
										.setEntity("user", user)
										.setParameter("status", status)
										.setEntity("contest", contest)
										.uniqueResult();
		}
		return count;
	}

	public List<Solution> searchByLanguage(int start, int size,
			Integer language, Contest contest) {
		String hql1 = "from Solution s" +
					" where s.language = :language" +
					" and s.contest = null" +
					" order by s.date desc";
		
		String hql2 = "from Solution s" +
					" where s.language = :language" +
					" and s.contest = :contest" +
					" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setParameter("language", language)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setParameter("language", language)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByLanguageAndStatus(int start, int size,
			Integer language, Integer status, Contest contest) {
		String hql1 = "from Solution s" +
					" where s.language = :language" +
					" and s.status = :status" +
					" and s.contest = null" +
					" order by s.date desc";
		
		String hql2 = "from Solution s" +
					" where s.language = :language" +
					" and s.status = :status" +
					" and s.contest = :contest" +
					" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setParameter("language", language)
								.setParameter("status", status)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setParameter("language", language)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByProblem(int start, int size, Problem problem,
			Contest contest) {
		String hql1 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("problem", problem)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("problem", problem)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByProblemAndLanguage(int start, int size,
			Problem problem, Integer language, Contest contest) {
		String hql1 = "from Solution s" +
					" where s.problem = :problem" +
					" and s.language = :language" +
					" and s.contest = null" +
					" order by s.date desc";
		
		String hql2 = "from Solution s" +
					" where s.problem = :problem" +
					" and s.language = :language" +
					" and s.contest = :contest" +
					" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("problem", problem)
								.setParameter("language", language)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("problem", problem)
								.setParameter("language", language)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByProblemAndLanguageAndStatus(int start,
			int size, Problem problem, Integer language, Integer status,
			Contest contest) {
		String hql1 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.language = :language" +
				" and s.status = :status" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.language = :language" +
				" and s.status = :status" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("problem", problem)
								.setParameter("language", language)
								.setParameter("status", status)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("problem", problem)
								.setParameter("language", language)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByProblemAndStatus(int start, int size,
			Problem problem, Integer status, Contest contest) {
		String hql1 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.status = :status" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.status = :status" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("problem", problem)
								.setParameter("status", status)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("problem", problem)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByProblemAndUser(int start, int size,
			Problem problem, User user, Contest contest) {
		String hql1 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.user = :user" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.user = :user" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByProblemAndUserAndLanguage(int start,
			int size, Problem problem, User user, Integer language,
			Contest contest) {
		String hql1 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.user = :user" +
				" and s.language = :language" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.user = :user" +
				" and s.language = :language" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setParameter("language", language)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setParameter("language", language)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByProblemAndUserAndStatus(int start, int size,
			Problem problem, User user, Integer status, Contest contest) {
		String hql1 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.user = :user" +
				" and s.status = :status" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.problem = :problem" +
				" and s.user = :user" +
				" and s.status = :status" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setParameter("status", status)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByStatus(int start, int size, Integer status,
			Contest contest) {
		String hql1 = "from Solution s" +
				" where s.status = :status" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.status = :status" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setParameter("status", status)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByUser(int start, int size, User user,
			Contest contest) {
		String hql1 = "from Solution s" +
				" where s.user = :user" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.user = :user" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("user", user)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("user", user)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByUserAndLanguage(int start, int size,
			User user, Integer language, Contest contest) {
		String hql1 = "from Solution s" +
				" where s.user = :user" +
				" and s.language = :language" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.user = :user" +
				" and s.language = :language" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("user", user)
								.setParameter("language", language)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("user", user)
								.setParameter("language", language)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByUserAndLanguageAndStatus(int start, int size,
			User user, Integer language, Integer status, Contest contest) {
		String hql1 = "from Solution s" +
				" where s.user = :user" +
				" and s.language = :language" +
				" and s.status = :status" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.user = :user" +
				" and s.language = :language" +
				" and s.status = :status" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("user", user)
								.setParameter("language", language)
								.setParameter("status", status)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("user", user)
								.setParameter("language", language)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public List<Solution> searchByUserAndStatus(int start, int size, User user,
			Integer status, Contest contest) {
		String hql1 = "from Solution s" +
				" where s.user = :user" +
				" and s.status = :status" +
				" and s.contest = null" +
				" order by s.date desc";
		
		String hql2 = "from Solution s" +
				" where s.user = :user" +
				" and s.status = :status" +
				" and s.contest = :contest" +
				" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("user", user)
								.setParameter("status", status)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("user", user)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}

	public Integer getCountByProblemAndUserAndLanguageAndStatus(
			Problem problem, User user, Integer language, Integer status,
			Contest contest) {
		String hql1 = "select count(s) from Solution s" +
				" where s.problem = :problem" +
				" and s.user = :user" +
				" and s.language = :language" +
				" and s.status = :status" +
				" and s.contest = null";
		
		String hql2 = "select count(s) from Solution s" +
				" where s.problem = :problem" +
				" and s.user = :user" +
				" and s.language =:language" +
				" and s.status = :status" +
				" and s.contest = :contest";
		
		Integer count;
		if(contest == null) {
			count = (Integer)getSession().createQuery(hql1)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setParameter("language", language)
								.setParameter("status", status)
								.uniqueResult();
		} else {
			count = (Integer)getSession().createQuery(hql2)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setParameter("language", language)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.uniqueResult();
		}
		return count;
	}

	public List<Solution> searchByProblemAndUserAndLanguageAndStatus(int start,
			int size, Problem problem, User user, Integer language,
			Integer status, Contest contest) {
		String hql1 = "from Solution s" +
					" where s.problem = :problem" +
					" and s.user = :user" +
					" and s.language = :language" +
					" and s.status = :status" +
					" and s.contest = null" +
					" order by s.date desc";

		String hql2 = "from Solution s" +
					" where s.problem = :problem" +
					" and s.user = :user" +
					" and s.language =:language" +
					" and s.status = :status" +
					" and s.contest = :contest" +
					" order by s.date desc";
		
		List list;
		if(contest == null) {
			list = getSession().createQuery(hql1)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setParameter("language", language)
								.setParameter("status", status)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		} else {
			list = getSession().createQuery(hql2)
								.setEntity("problem", problem)
								.setEntity("user", user)
								.setParameter("language", language)
								.setParameter("status", status)
								.setEntity("contest", contest)
								.setFirstResult(start)
								.setMaxResults(size)
								.list();
		}
		@SuppressWarnings("unchecked")
		List<Solution> re = list;
		return re;
	}


	
}
