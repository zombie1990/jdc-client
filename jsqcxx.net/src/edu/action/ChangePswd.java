package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.User;

/**
 * @author xiyu
 *
 */
public class ChangePswd extends ActionSupport {

	private String oldPassword;
	private String newPassword;
	private String reNewPassword;
	
	public String execute() throws Exception {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(null == user) {
			ActionContext.getContext().getSession().put("error", "请先登录");
			return INPUT;
		}
		if(null == oldPassword || "".equals(oldPassword)) {
			ActionContext.getContext().getSession().put("error", "原始密码不能为空");
			return INPUT;
		}
		if(null == newPassword || "".equals(newPassword)) {
			ActionContext.getContext().getSession().put("error", "新密码不能为空");
			return INPUT;
		}
		if(null == reNewPassword || "".equals(reNewPassword)) {
			ActionContext.getContext().getSession().put("error", "重复新密码不能为空");
			return INPUT;
		}
		if(!newPassword.equals(reNewPassword)) {
			ActionContext.getContext().getSession().put("error", "两次输入新密码不一致");
			return INPUT;
		}
		if(!oldPassword.equals(user.getPassword())) {
			ActionContext.getContext().getSession().put("error", "原始密码不正确");
			return INPUT;
		}
		user.setPassword(reNewPassword.trim());
		DAOFactory.getInstance().getUserDAO().makePersistent(user);
		ActionContext.getContext().getSession().put("error", "修改成功");
		return SUCCESS;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getReNewPassword() {
		return reNewPassword;
	}

	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}
	
}
