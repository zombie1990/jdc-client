/**
 * 
 */
package com.jsu.DAO;

import java.util.List;

import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.User;

/**
 * @author Administrator
 *
 */
public interface UserDAO extends GeneralDAO<User, String> {

	public List<User> getPageUserRanklist(int start, int size);
	public List<User> getPageUserRanklist(String username, int start, int size);
	
	public Integer getUserCount();
	public Integer getUserCount(String username);
	
	public Integer getUserRank(User user);
	
	public List<Problem> getSolvedProblems(User user);
	
}
