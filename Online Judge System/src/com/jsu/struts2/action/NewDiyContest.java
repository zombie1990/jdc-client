/**
 * 
 */
package com.jsu.struts2.action;

import java.util.Date;

import com.jsu.DAO.ContestDAO;
import com.jsu.DAO.UserDAO;
import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.jsu.util.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class NewDiyContest extends ActionSupport {

	private static final long serialVersionUID = -25764216L;
	
	private String title;
	private String description;
	private String password;
	private Date startDate;
	private Date startTime;
	private Date endDate;
	private Date endTime;
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getPassword() {
		return password;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String execute() {
		
		try {
			password = password.trim();
			if("".equals(password) || null == password) {
				password = null;
			}
			Date start = new Date( startDate.getTime() + startTime.getTime()%86400000 + 28800000 );
			Date end = new Date( endDate.getTime() + endTime.getTime()%86400000 + 28800000 );
			if(end.before(start)) {
				this.addFieldError("endDate", "end time can not before start time");
				return INPUT;
			} else if(start.before(new Date())) {
				this.addFieldError("startDate", "start time can not before nowadays");
				return INPUT;
			}
			ContestDAO contestDAO = DAOFactory.getInstance().getContestDAO();
			UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
			User user = userDAO.findById((String)ActionContext.getContext().getSession().get("username"), false);
			Contest contest = new Contest("Y");
			contest.setUser(user);
			contest.setTitle(title.trim());
			contest.setDescription(description.trim());
			contest.setPassword(password==null?null:MD5.getMD5(password));
			contest.setStartTime(start);
			contest.setEndTime(end);
			contestDAO.makePersistent(contest);
			ActionContext.getContext().put("tip", "Operation success!");
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
