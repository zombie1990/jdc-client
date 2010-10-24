/**
 * 
 */
package com.jsu.DAO;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Statistics;

/**
 * @author Administrator
 *
 */
public interface StatisticsDAO extends GeneralDAO<Statistics, String> {

	public Statistics findByReferrence(Contest contest, Problem problem);
	
	public Integer getCount(Contest contest);
	
	public List<Statistics> findAllInContest(Contest contest);
}
