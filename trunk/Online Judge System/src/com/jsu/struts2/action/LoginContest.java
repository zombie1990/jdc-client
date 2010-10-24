/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.hibernate.domains.Contest;
import com.jsu.util.DAOFactory;
import com.jsu.util.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class LoginContest extends ActionSupport {

	private static final long serialVersionUID = -556542204L;
	private Integer contestId;
	private String contestPassword;
	private Contest contest;
	public Integer getContestId() {
		return contestId;
	}
	public String getContestPassword() {
		return contestPassword;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public void setContestPassword(String contestPassword) {
		this.contestPassword = contestPassword;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	
	public String execute() {
		
		try {
			Contest temp = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
			if(!MD5.getMD5(contestPassword).equals(temp.getPassword())) {
				this.addFieldError("contestPassword", "password error");
				return INPUT;
			} else {
				contest = temp;
			}
			Integer logined = contestId;
			ActionContext.getContext().getSession().put("loginedContestId", logined);
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
	public void validate() {
		
		if (null == this.getContestPassword() || "".equals(this.getContestPassword())) {
			this.addFieldError("contestPassword", "required");
		}
	}
}
