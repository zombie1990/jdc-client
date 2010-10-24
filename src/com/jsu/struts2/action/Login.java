/**
 * 
 */
package com.jsu.struts2.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.jsu.DAO.LoginLogDAO;
import com.jsu.DAO.UserDAO;
import com.jsu.hibernate.domains.LoginLog;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.jsu.util.MD5;
import com.jsu.util.OnlineUserList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class Login extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -14518195L;
	private String username;
	private String password;
	private String IP;
	private HttpServletRequest request;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String getIP() {
		return IP;
	}

	public void setIP(String ip) {
		IP = ip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
		User user = userDAO.findById(username, false);
		LoginLogDAO llDAO = DAOFactory.getInstance().getLoginLogDAO();
		LoginLog ll = new LoginLog();
		if ( null != user 
				&& user.getPassword().equals( MD5.getMD5( this.getPassword().trim() ) ) ) {
			IP = request.getRemoteAddr();
			
			if("Y".equals(user.getDefunct())) {
				this.addFieldError("username", "you have been locked, please contact with admin!");
				return INPUT;
			}
			
			user.setAccessTime(new Date());
			
			ll.setIp(IP);
			ll.setDate(new Date());
			ll.setUser(user);
			String admin = user.getAdmin();
			String role = admin == "Y" ? "administrtor" : "user";
			ll.setRole(role);
			llDAO.makePersistent(ll);
			userDAO.makePersistent(user);
			
			ActionContext actionContext = ActionContext.getContext();
			actionContext.getSession().put("username", getUsername());
			actionContext.getSession().put("IP", IP);
			OnlineUserList.addUser(username);
			return SUCCESS;
		} else {
			this.addFieldError("username", "username or password error");
			return INPUT;
		}
	}

	public void validate() {
		if (null == this.getUsername() || "".equals(this.getUsername())) {
			this.addFieldError("username", "required");
		} else if (null == this.getPassword() || "".equals(this.getPassword())) {
			this.addFieldError("password", "required");
		}
	}
}
