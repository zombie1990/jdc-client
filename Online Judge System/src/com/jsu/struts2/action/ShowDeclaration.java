/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.hibernate.domains.Contest;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ShowDeclaration extends ActionSupport {

	private static final long serialVersionUID = -8971928604L;
	private Integer contestId;
	private Contest contest;
	public Integer getContestId() {
		return contestId;
	}
	public Contest getContest() {
		return contest;
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
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
