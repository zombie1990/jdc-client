/**
 * 
 */
package com.jsu.test.persistence;

import java.util.Iterator;
import java.util.List;

import com.jsu.DAO.ProblemDAO;
import com.jsu.hibernate.domains.Problem;
import com.jsu.util.DAOFactory;
import com.jsu.util.HibernateUtil;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class ProblemDAOTest extends TestCase {

	public void testGetProblemCount() {
		
		ProblemDAO dao = DAOFactory.getInstance().getProblemDAO();
		System.out.println(dao.getProblemCount());
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
	
	public void testGetPageProblems() {
		
		ProblemDAO dao = DAOFactory.getInstance().getProblemDAO();
		List<Problem> l = dao.getPageProblems(0);
		Iterator<Problem> i = l.iterator();
		while(i.hasNext())
			System.out.println(i.next());
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
}
