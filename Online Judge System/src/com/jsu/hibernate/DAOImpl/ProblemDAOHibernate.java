/**
 * 
 */
package com.jsu.hibernate.DAOImpl;

import java.util.List;

import com.jsu.DAO.ProblemDAO;
import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;

/**
 * @author Administrator
 *
 */
public class ProblemDAOHibernate extends GeneralHibernateDAO<Problem, Integer> implements
		ProblemDAO {

	public Integer getProblemCount() {
		
		String queryString = "select count(i) from Problem i where i.defunct = :defunct";
		Integer count = (Integer)getSession().createQuery(queryString)
										.setParameter("defunct", "N")
										.uniqueResult();
		return count;
	}
	
	public Integer getProblemCount(String contestProblem) {
		
		String queryString = "select count(i) from Problem i where i.contestProblem = :contestProblem";
		Integer count = (Integer)getSession().createQuery(queryString)
										.setParameter("contestProblem", contestProblem)
										.uniqueResult();
		return count;
	}
	
	
	public List<Problem> getPageProblems(int start) {
		
		String queryString = "from Problem p where p.defunct = :defunct";
		@SuppressWarnings("unchecked")
		List<Problem> problems = getSession().createQuery(queryString)
													.setParameter("defunct", "N")
													.setFirstResult(start)
													.setMaxResults(100)
													.list();
		return problems;
	}
	
	public List<Problem> getPageProblems(int start, String contestProblem) {
		
		String queryString = "from Problem p where p.contestProblem = :contestProblem";
		@SuppressWarnings("unchecked")
		List<Problem> problems = getSession().createQuery(queryString)
													.setParameter("contestProblem", contestProblem)
													.setFirstResult(start)
													.setMaxResults(100)
													.list();
		return problems;
	}
	
	public Problem findById(Integer problemId, String defunct) {
		
		String query = "from Problem p"
					+ " where p.problemId = :problemId"
					+ " and p.defunct = :defunct";
		
		Problem problem = (Problem)getSession().createQuery(query)
												.setParameter("problemId", problemId)
												.setParameter("defunct", defunct)
												.uniqueResult();
		return problem;
	}
	
	public List<Problem> findByTitle(String title, String defunct) {
		
		String query = "from Problem p"
					+ " where p.title like :title"
					+ " and p.defunct = :defunct";
		String t = "%" + title +"%";
		@SuppressWarnings("unchecked")
		List<Problem> list = getSession().createQuery(query)
										.setParameter("title", t)
										.setParameter("defunct", defunct)
										.list();
		return list;
	}
	
	public List<Problem> findByGradeAndGenre(String genre, String grade) {
		
		String query = "from Problem p"
					+ " where p.type = :genre"
					+ " and p.hardLevel = :grade"
					+ " and p.defunct = :defunct";
		@SuppressWarnings("unchecked")
		List<Problem> list = getSession().createQuery(query)
										.setParameter("genre", genre)
										.setParameter("grade", grade)
										.setParameter("defunct", "N")
										.list();
		return list;
	}
	
	public List<Problem> findByGradeAndGenre(String genre, String grade, String contestProblem) {
		
		String query = "from Problem p"
					+ " where p.type = :genre"
					+ " and p.hardLevel = :grade"
					+ " and p.contestProblem = :contestProblem";
		@SuppressWarnings("unchecked")
		List<Problem> list = getSession().createQuery(query)
										.setParameter("genre", genre)
										.setParameter("grade", grade)
										.setParameter("contestProblem", contestProblem)
										.list();
		return list;
	}

	public Problem findByIdInContest(Integer problemIdInContest, Contest contest) {
		String hql = "select s.problem from Solution s" +
				" where s.problemIdInContest = :problemIdInContest" +
				" and s.contest = :contest";
		Problem problem = (Problem)getSession().createQuery(hql)
										.setParameter("problemIdInContest", problemIdInContest)
										.setEntity("contest", contest)
										.uniqueResult();
		return problem;
	}
	
	
}
