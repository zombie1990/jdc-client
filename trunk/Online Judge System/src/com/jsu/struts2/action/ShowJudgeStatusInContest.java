/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Solution;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ShowJudgeStatusInContest extends ActionSupport {

	private static final long serialVersionUID = -5090978304L;
	private List<Solution> solutions;
	private int JudgeStatusPage = 0;
	private int count;
	private Integer contestId;
	private Contest contest;
	public List<Solution> getSolutions() {
		return solutions;
	}
	public int getJudgeStatusPage() {
		return JudgeStatusPage;
	}
	public int getCount() {
		return count;
	}
	public Integer getContestId() {
		return contestId;
	}
	public Contest getContest() {
		return contest;
	}
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	public void setJudgeStatusPage(int judgeStatusPage) {
		JudgeStatusPage = judgeStatusPage;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	
	public String execute() {
		
		try {
			contest = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
			List<Solution> list = DAOFactory.getInstance().getSolutionDAO().findByPageInContest(JudgeStatusPage, 16, contest);
			solutions = list;
			this.count = DAOFactory.getInstance().getSolutionDAO().getSolutionCount(contest);
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
