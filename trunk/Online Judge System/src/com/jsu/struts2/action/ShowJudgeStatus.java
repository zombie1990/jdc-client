/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.Solution;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ShowJudgeStatus extends ActionSupport {

	private static final long serialVersionUID = -15980198L;
	
	private List<Solution> solutions;
	private int startJudgeStatus = 0;
	private int count;

	public int getStartJudgeStatus() {
		return startJudgeStatus;
	}

	public void setStartJudgeStatus(int startJudgeStatus) {
		this.startJudgeStatus = startJudgeStatus;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	
	public String execute() throws Exception {
		
		try {
			List<Solution> list = DAOFactory.getInstance().getSolutionDAO().findByPage(startJudgeStatus, 16);
			this.count = DAOFactory.getInstance().getSolutionDAO().getSolutionCount();
			solutions = list;
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}
	}

	
}
