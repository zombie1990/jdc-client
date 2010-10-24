/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.hibernate.domains.Problem;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class OneKeyToNormal extends ActionSupport {

	private static final long serialVersionUID = -1234112204L;
	private Integer problemId;
	private int pageNum;
	private String contestProblem;
	public Integer getProblemId() {
		return problemId;
	}
	public int getPageNum() {
		return pageNum;
	}
	public String getContestProblem() {
		return contestProblem;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public void setContestProblem(String contestProblem) {
		this.contestProblem = contestProblem;
	}
	
	public String execute() {
		
		try {
			Problem problem = DAOFactory.getInstance().getProblemDAO().findById(problemId, false);
			problem.setDefunct("N");
			DAOFactory.getInstance().getProblemDAO().makePersistent(problem);
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
