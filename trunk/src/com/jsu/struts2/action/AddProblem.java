/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Statistics;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.jsu.util.LongConverter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class AddProblem extends ActionSupport {

	private static final long serialVersionUID = -57134204L;
	private Integer contestId;
	private String problemId;
	public Integer getContestId() {
		return contestId;
	}
	public String getProblemId() {
		return problemId;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}
	
	public String execute() {
		
		try {
			Contest contest = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
			User user = contest.getUser();
			Problem problem;
			int i = (int)LongConverter.strToLong(problemId.trim()) - 999;
			if("N".equals(user.getAdmin())) {
				problem = DAOFactory.getInstance().getProblemDAO().findById(i, "N");
			} else {
				problem = DAOFactory.getInstance().getProblemDAO().findById(i, false);
			}
			if("".equals(problemId) || null == problemId) {
				this.addFieldError("problemId", "required");
				return INPUT;
			}
			if(problem == null) {
				this.addFieldError("problemId", "No such problem");
				return INPUT;
			}
			
			int count = DAOFactory.getInstance().getStatisticsDAO().getCount(contest);
			Statistics stcs = new Statistics(count+1);
			stcs.setContest(contest);
			stcs.setProblem(problem);
			DAOFactory.getInstance().getStatisticsDAO().makePersistent(stcs);
			return SUCCESS;
		} catch(Exception e) {
			return "error";
		}

	}
}
