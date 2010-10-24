/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.DAO.UserDAO;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.jsu.util.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ChangePassword extends ActionSupport {

	private static final long serialVersionUID = -25763216L;
	
	private String lostUsername;
	private String lostPassword;
	public String getLostUsername() {
		return lostUsername;
	}
	public String getLostPassword() {
		return lostPassword;
	}
	public void setLostUsername(String lostUsername) {
		this.lostUsername = lostUsername;
	}
	public void setLostPassword(String lostPassword) {
		this.lostPassword = lostPassword;
	}
	
	public String execute() {
		
		try {
			UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
			User user = userDAO.findById(lostUsername, false);
			if(user == null) {
				this.addFieldError("lostUsername", "no user like this exist!");
				return INPUT;
			}
			user.setPassword(MD5.getMD5(lostPassword));
			userDAO.makePersistent(user);
			ActionContext.getContext().put("tip", "Operation success!");
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
	public void validate() {
		if(null == this.getLostUsername() || "".equals(this.getLostUsername()) || null == this.getLostPassword() || "".equals(this.getLostPassword())) {
			this.addFieldError("lostUsername", "can not be empty!");
		}
	}
}
