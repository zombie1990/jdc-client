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
public class ContestEntry extends ActionSupport {

	private static final long serialVersionUID = -571246765604L;
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
			Contest temp = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
			if("".equals(temp.getPassword()) || null == temp.getPassword()) {
				contest = temp;
				return "public";
			}
			return "private";
		}catch(Exception e) {
			return "error";
		}

	}
}
