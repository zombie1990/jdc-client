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
public class UpdateInfo extends ActionSupport {

	private static final long serialVersionUID = -29181731L;
	
	private String password;
	private String repassword;
	private String nickname;
	private String email;
	private String school;
	private String motto;
	

	public String getPassword() {
		return password;
	}



	public String getRepassword() {
		return repassword;
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




	public void setPassword(String password) {
		this.password = password;
	}



	public void setRepassword(String repassword) {
		this.repassword = repassword;
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







	public String execute() throws Exception {

		ActionContext actionContext = ActionContext.getContext();
		String username = (String)actionContext.getSession().get("username");
		UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
		User user = userDAO.findById(username, false);
		if(null != user) {
			user.setPassword(MD5.getMD5(password));
			user.setNickname(nickname);
			user.setEmail(email);
			user.setSchool(school);
			user.setMotto(motto);
			userDAO.makePersistent(user);
		}
		actionContext.put("tip", "Update your information success!");
		return SUCCESS;
	}
	

}
