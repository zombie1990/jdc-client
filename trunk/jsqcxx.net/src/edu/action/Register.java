package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.DAO.UserDAO;
import edu.domains.User;

/**
 * @author xiyu
 * 
 */
public class Register extends ActionSupport {

	private String username;
	private String password;
	private String repassword;
	private String email;
	private String contact;
	private String question;
	private String answer;

	public String execute() throws Exception {
		username = username.trim();
		password = password.trim();
		repassword = repassword.trim();
		email = email.trim();
		contact = contact.trim();
		question = question.trim();
		answer = answer.trim();
		
		UserDAO dao = DAOFactory.getInstance().getUserDAO();
		if (null != dao.findById(this.username, false)) {
			addFieldError("username", "您注册的帐号已经被使用了");
			return INPUT;
		}
		User user = new User(username, password, question, answer);
		user.setEmail(email);
		user.setContact(contact);
		if("admin".equals(username))
			user.setPermission("11111111");
		dao.makePersistent(user);
		ActionContext.getContext().getSession().put("error", "注册成功");
		return SUCCESS;
	}
	
	public void validate() {
		
		if(null == username || "".equals(username.trim()) || username.length() < 4) {
			addFieldError("username", "用户名长度不能少于4个字符");
		}
		else if(null == password || "".equals(password.trim()) || password.length() < 6) {
			addFieldError("password", "密码长度不能少于6个字符");
		}
		else if(!repassword.trim().equals(password.trim())) {
			addFieldError("repassword", "二次输入密码不一致");
		}
		else if(null == question || "".equals(question.trim())) {
			addFieldError("question", "请输入密保提示问题");
		}
		else if(null == answer || "".equals(answer.trim())) {
			addFieldError("answer", "请输入密保答案");
		}
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
