/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Solution;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class SearchSolved extends ActionSupport {

	private Integer solvedProblemId;
	private String username;
	private List<Solution> solutions;
	private int startJudgeStatus = 0;
	private int count;
	public Integer getSolvedProblemId() {
		return solvedProblemId;
	}
	public void setSolvedProblemId(Integer solvedProblemId) {
		this.solvedProblemId = solvedProblemId;
	}
	public String getUsername() {
		return username;
	}
	public List<Solution> getSolutions() {
		return solutions;
	}
	public int getStartJudgeStatus() {
		return startJudgeStatus;
	}
	public int getCount() {
		return count;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	public void setStartJudgeStatus(int startJudgeStatus) {
		this.startJudgeStatus = startJudgeStatus;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String execute() {
		
		try {
			User user = DAOFactory.getInstance().getUserDAO().findById(username, false);
			Problem problem = DAOFactory.getInstance().getProblemDAO().findById(solvedProblemId, "N");
			solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndUserAndStatus(startJudgeStatus, 16, problem, user, 1, null);
			count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndUserAndStatus(problem, user, 1, null);
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
