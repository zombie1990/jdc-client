package com.jsu.test.persistence;



import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.jsu.DAO.ContestDAO;
import com.jsu.DAO.UserDAO;
import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.jsu.util.HibernateUtil;

import junit.framework.TestCase;

public class GeneralDAOTest extends TestCase {
		
	public void testMakePersistent() {
		
		/**
		 * Test method: <code>GeneralDAO.makePersistent(T entity)</code>
		 */
		DAOFactory factory = DAOFactory.getInstance();

		ContestDAO dao = factory.getContestDAO();

		Contest contest = new Contest("N");
		contest.setTitle("my contest 4");
		contest.setDescription("contest for test");
		contest.setStartTime(new Date());
		contest.setEndTime(new Date());
		contest.setStatus(0);
		contest.setDefunct("N");

		dao.makePersistent(contest);

		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
	
	public void testFindById() {
		
		/**
		 * Test method: <code>GeneralDAO.findById(ID id, boolean lock)</code>
		 */
		DAOFactory factory = DAOFactory.getInstance();

		ContestDAO dao = factory.getContestDAO();
		
		Contest contest = dao.findById(1, false);
		System.out.println(contest.getContestId() + " | " + contest.getTitle() + " | " + contest.getDescription()
					+ " | " + contest.getStartTime() + " | " + contest.getEndTime() + " | " + contest.getStatus().toString()
					+ " | " + contest.getPassword() + " | " + contest.getDefunct());
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
	
	public void testFindAll() {
		
		/**
		 * Test method: <code>GeneralDAO.findAll()</code>
		 */
		DAOFactory factory = DAOFactory.getInstance();

		ContestDAO dao = factory.getContestDAO();
		
		List<Contest> contests = dao.findAll();
		Iterator<Contest> iter = contests.iterator();
		while (iter.hasNext()) {
			Contest contest = iter.next();
			System.out.println(contest.getContestId() + " | " + contest.getTitle() + " | " + contest.getDescription()
					+ " | " + contest.getStartTime() + " | " + contest.getEndTime() + " | " + contest.getStatus().toString()
					+ " | " + contest.getPassword() + " | " + contest.getDefunct());
		}
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
	
	public void testFindByExample() {
		
		/**
		 * Test method: <code>GeneralDAO.findByExample(T entity, String... excludeProperty)</code>
		 */
		DAOFactory factory = DAOFactory.getInstance();

		ContestDAO dao = factory.getContestDAO();
		
		Contest sample = new Contest("N");
		sample.setTitle("my contest 4");
		sample.setDefunct("N");
		
		List<Contest> contests = dao.findByExample(sample);
		Iterator<Contest> iter = contests.iterator();
		while (iter.hasNext()) {
			Contest contest = iter.next();
			System.out.println(contest.getContestId() + " | " + contest.getTitle() + " | " + contest.getDescription()
					+ " | " + contest.getStartTime() + " | " + contest.getEndTime() + " | " + contest.getStatus().toString()
					+ " | " + contest.getPassword() + " | " + contest.getDefunct());
		}
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
	
	public void testMakeTransient() {
		
		/**
		 * Test method: <code>GeneralDAO.makeTransient(T entity)</code>
		 */
		DAOFactory factory = DAOFactory.getInstance();

		ContestDAO dao = factory.getContestDAO();
		
		Contest contest = dao.findById(4, false);
		dao.makeTransient(contest);
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
	
	public void test() {
		UserDAO dao = DAOFactory.getInstance().getUserDAO();
		User p = dao.findById("sherry", false);
		System.out.println(p.getPassword());
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
	
}
