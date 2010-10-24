/**
 * 
 */
package com.jsu.DAO;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;

/**
 * @author Administrator
 *
 */
public interface ProblemDAO extends GeneralDAO<Problem, Integer> {

	public Integer getProblemCount();
	public Integer getProblemCount(String contestProblem);
	
	public List<Problem> getPageProblems(int start);
	public List<Problem> getPageProblems(int start, String contestProblem);
	
	public Problem findById(Integer problemId, String defunct);
	
	public List<Problem> findByTitle(String title, String defunct);
	public List<Problem> findByGradeAndGenre(String genre, String grade);
	public List<Problem> findByGradeAndGenre(String genre, String grade, String contestProblem);
	
	public Problem findByIdInContest(Integer problemIdInContest, Contest contest);
}
