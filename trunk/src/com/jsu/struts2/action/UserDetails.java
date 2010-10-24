package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetails extends ActionSupport {

	private static final long serialVersionUID = -5711298911L;
	private String username;
	private Integer rank;
	private User user;
	private List<Problem> solvedProblems;
	private String school;
	private String motto;
	public String getSchool() {
		return school;
	}
	public String getMotto() {
		return motto;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public String getUsername() {
		return username;
	}
	public Integer getRank() {
		return rank;
	}
	public User getUser() {
		return user;
	}
	public List<Problem> getSolvedProblems() {
		return solvedProblems;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setSolvedProblems(List<Problem> solvedProblems) {
		this.solvedProblems = solvedProblems;
	}
	
	public String execute() {
		
		try {
			user = DAOFactory.getInstance().getUserDAO().findById(username, false);
			school = user.getSchool();
			motto = user.getMotto();
			if("".equals(school) || null == school) {
				school = "unknown";
			}
			if("".equals(motto) || null == motto) {
				motto = "This fellow left nothing here.";
			}
			rank = DAOFactory.getInstance().getUserDAO().getUserRank(user);
			solvedProblems = DAOFactory.getInstance().getUserDAO().getSolvedProblems(user);
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
