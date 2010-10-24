/**
 * 
 */
package com.jsu.DAO;

import java.util.Date;
import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.User;

/**
 * @author Administrator
 *
 */
public interface ContestDAO extends GeneralDAO<Contest, Integer> {

	public List<Contest> findByReferrence(String diy, Integer status, int start, int size, String defunct);
	public List<Contest> getMyContests(User user, Integer status, int start, int size);
	
	public Integer getContestCount(String diy, Integer status, String defunct);
	public Integer getContestCount(User user, Integer status);
	
	public void updateContestStatus(Date now);
	
	public List<Contest> findByTitle(String title, String diy);
	public List<Contest> findByHolder(User user, String diy);
}
