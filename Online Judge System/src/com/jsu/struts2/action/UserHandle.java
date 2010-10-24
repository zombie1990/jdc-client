/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.DAO.UserDAO;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class UserHandle extends ActionSupport {

	private static final long serialVersionUID = -15980198L;
	
	private String handler;
	private String username;
	public String getHandler() {
		return handler;
	}
	public String getUsername() {
		return username;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String execute() {
		try {
			UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
			User user = userDAO.findById(username, false);
			ActionContext actionContext = ActionContext.getContext();
			String currentUser = (String)actionContext.getSession().get("username");
			if (null == user) {
				this.addFieldError("username", "username does not exist!");
				return INPUT;
			} else if ( (!currentUser.equals("root")) && (getHandler().equals("admin") || getHandler().equals("user")) ) {
				this.addFieldError("handler", "only [root] can use admin or user operator!");
				return INPUT;
			}
			
			if("lock".equals(handler)) {
				user.setDefunct("Y");
				userDAO.makePersistent(user);
			} else if ("unlock".equals(handler)) {
				user.setDefunct("N");
				userDAO.makePersistent(user);
			} else if ("admin".equals(handler)) {
				user.setAdmin("Y");
				userDAO.makePersistent(user);
			} else if ("user".equals(handler)) {
				user.setAdmin("N");
				userDAO.makePersistent(user);
			}
			actionContext.put("tip", "Operatioin success!");
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
	public void validate() {
		if (null == this.getUsername() || "".equals(this.getUsername())) {
			this.addFieldError("username", "required");
		} else if (null == this.getHandler() ) {
			this.addFieldError("handler", "required");
		}
	}
	
}
