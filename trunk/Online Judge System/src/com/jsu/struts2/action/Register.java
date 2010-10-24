/**
 * 
 */
package com.jsu.struts2.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.jsu.DAO.UserDAO;
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
public class Register extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = -28380483L;
	
	private HttpServletRequest request;
	private String username;
	private String password;
	private String repassword;
	private String nickname;
	private String email;
	private String school;
	private String motto;



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getSchool() {
		return school;
	}

	public String getMotto() {
		return motto;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute() throws Exception {
		
		UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
		if(userDAO.findById(username, false) == null) {
			User user = new User();
			user.setUsername(getUsername());
			user.setPassword(MD5.getMD5(getPassword()));
			user.setNickname(getNickname());
			user.setEmail(getEmail());
			user.setSchool(getSchool());
			user.setMotto(getMotto());
			user.setRegisterTime(new Date());
			user.setAccessTime(new Date());
			userDAO.makePersistent(user);
			String IP = request.getRemoteAddr();
			ActionContext actionContext = ActionContext.getContext();
			actionContext.getSession().put("username", getUsername());
			actionContext.getSession().put("IP", IP);
			if(OnlineUserList.addUser(username));
			return SUCCESS;

		}
		else {
			this.addFieldError("username", "this username has been used, please choose another.");
			return INPUT;
		}

	}
	
	public void validate() {
		if (null == this.getUsername() || "".equals(this.getUsername()) || !this.getUsername().matches("^[a-zA-Z][a-zA-Z0-9_]{4,15}$")) {
			if(null == this.getUsername() || "".equals(this.getUsername()))
				this.addFieldError("username", "username required");
			else if(!this.getUsername().matches("^[a-zA-Z][a-zA-Z0-9_]{5,15}$"))
				this.addFieldError("username", "length should be more than 5 chars and can's start with a number, Not Supported Chinese");
		}
		if (!this.getRepassword().equals(this.getPassword())) {
			this.addFieldError("password", "re-password not match password");
		}
	}
}
