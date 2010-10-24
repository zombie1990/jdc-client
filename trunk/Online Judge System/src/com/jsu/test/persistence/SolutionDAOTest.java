/**
 * 
 */
package com.jsu.test.persistence;

import com.jsu.util.DAOFactory;

import junit.framework.TestCase;

/**
 * @author Administrator
 *
 */
public class SolutionDAOTest extends TestCase {

	public void testGetCount() {
		Integer i = DAOFactory.getInstance().getSolutionDAO().getCountByLanguageAndStatus(1, 1, null);
		System.out.println(i);
	}
}
