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
public class Login extends ActionSupport {

	private String username;
	private String password;
	
	public String execute() throws Exception {
		
		if(null == username || "".equals(username)) {
			ActionContext.getContext().getSession().put("error", "用户名不能为空");
			return INPUT;
		}
		else if(null == password || "".equals(password)) {
			ActionContext.getContext().getSession().put("error", "密码不能为空");
			return INPUT;
		}
		username = username.trim();
		password = password.trim();
		
		UserDAO dao = DAOFactory.getInstance().getUserDAO();
		User ifExist = dao.findById(username, false);
		if(null == ifExist) {
			ActionContext.getContext().getSession().put("error", "用户名不存在");
			return INPUT;
		}
		else if(!password.equals(ifExist.getPassword())) {
			ActionContext.getContext().getSession().put("error", "密码错误");
			return INPUT;
		}
		ActionContext.getContext().getSession().put("user", ifExist);
		return SUCCESS;
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
}
