/**
 * 
 */
package com.jsu.DAO;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Solution;
import com.jsu.hibernate.domains.User;

/**
 * @author Administrator
 *
 */
public interface SolutionDAO extends GeneralDAO<Solution, String> {

	public List<Solution> findInStatus(User user, Problem problem, Integer status);
	public List<Solution> findNotInStatus(User user, Problem problem, Integer status);
	
	/*------search method in C(4,0)------*/
	public List<Solution> findByPageInContest(int start,int size, Contest contest);
	public List<Solution> findByPage(int start, int size);
	
	public Integer getSolutionCount();
	public Integer getSolutionCount(Contest contest);
	
	/*-------search method in C(4,1)--------*/
	public List<Solution> searchByProblem(int start,int size, Problem problem, Contest contest);
	public Integer getCountByProblem(Problem problem, Contest contest);
	
	public List<Solution> searchByUser(int start,int size, User user, Contest contest);
	public Integer getCountByUser(User user, Contest contest);
	
	public List<Solution> searchByLanguage(int start,int size, Integer language, Contest contest);
	public Integer getCountByLanguage(Integer language, Contest contest);
	
	public List<Solution> searchByStatus(int start,int size, Integer status, Contest contest);
	public Integer getCountByStatus(Integer status, Contest contest);
	
	/*-----search method in C(4,2)---------*/
	public List<Solution> searchByProblemAndUser(int start,int size, Problem problem, User user, Contest contest);
	public Integer getCountByProblemAndUser(Problem problem, User user, Contest contest);
	
	public List<Solution> searchByProblemAndLanguage(int start,int size, Problem problem, Integer language, Contest contest);
	public Integer getCountByProblemAndLanguage(Problem problem, Integer language, Contest contest);
	
	public List<Solution> searchByProblemAndStatus(int start,int size, Problem problem, Integer status, Contest contest);
	public Integer getCountByProblemAndStatus(Problem problem, Integer status, Contest contest);
	
	public List<Solution> searchByUserAndLanguage(int start,int size, User user, Integer language, Contest contest);
	public Integer getCountByUserAndLanguage(User user, Integer language, Contest contest);
	
	public List<Solution> searchByUserAndStatus(int start,int size, User user, Integer status, Contest contest);
	public Integer getCountByUserAndStatus(User user, Integer status, Contest contest);
	
	public List<Solution> searchByLanguageAndStatus(int start,int size, Integer language, Integer status, Contest contest);
	public Integer getCountByLanguageAndStatus(Integer language, Integer status, Contest contest);
	
	/*----search method in C(4,3)-------*/
	public List<Solution> searchByProblemAndUserAndLanguage(int start,int size, Problem problem, User user, Integer language, Contest contest);
	public Integer getCountByProblemAndUserAndLanguage(Problem problem, User user, Integer language, Contest contest);
	
	public List<Solution> searchByProblemAndUserAndStatus(int start,int size, Problem problem, User user, Integer status, Contest contest);
	public Integer getCountByProblemAndUserAndStatus(Problem problem, User user, Integer status, Contest contest);
	
	public List<Solution> searchByProblemAndLanguageAndStatus(int start,int size, Problem problem, Integer language, Integer status, Contest contest);
	public Integer getCountByProblemAndLanguageAndStatus(Problem problem, Integer language, Integer status, Contest contest);
	
	public List<Solution> searchByUserAndLanguageAndStatus(int start,int size, User user, Integer language, Integer status, Contest contest);
	public Integer getCountByUserAndLanguageAndStatus(User user, Integer language, Integer status, Contest contest);
	
	/*-----search method in C(4,4)--------*/
	public List<Solution> searchByProblemAndUserAndLanguageAndStatus(int start, int size, Problem problem, User user, Integer language, Integer status, Contest contest);
	public Integer getCountByProblemAndUserAndLanguageAndStatus(Problem problem, User user, Integer language, Integer status, Contest contest);
}
