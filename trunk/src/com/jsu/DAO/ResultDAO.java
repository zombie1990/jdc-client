/**
 * 
 */
package com.jsu.DAO;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Result;
import com.jsu.hibernate.domains.User;

/**
 * @author Administrator
 *
 */
public interface ResultDAO extends GeneralDAO<Result, String> {

	public Result findByReferrence(User user, Contest contest, Problem problem);
	public int getTotalTime(User user, Contest contest);
	public int getTotalSolved(User user, Contest contest);
	
	public List<User> getUsers(Contest contest);
	public List<Result> getUserResult(User user, Contest contest);
}
