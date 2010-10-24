package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.User;

/**
 * @author xiyu
 *
 */
public class RetrievePswd extends ActionSupport {

	private String answer;
	private String newPassword1;
	private String reNewPassword1;
	
	public String execute() throws Exception {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(null == user) {
			ActionContext.getContext().getSession().put("error", "请先登录");
			return INPUT;
		}
		if(null == answer || "".equals(answer)) {
			ActionContext.getContext().getSession().put("error", "答案不能为空");
			return INPUT;
		}
		if(null == newPassword1 || "".equals(newPassword1)) {
			ActionContext.getContext().getSession().put("error", "新密码不能为空");
			return INPUT;
		}
		if(null == reNewPassword1 || "".equals(reNewPassword1)) {
			ActionContext.getContext().getSession().put("error", "重复新密码不能为空");
			return INPUT;
		}
		if(!answer.equals(user.getAnswer())) {
			ActionContext.getContext().getSession().put("error", "答案不正确");
			return INPUT;
		}
		if(!newPassword1.equals(reNewPassword1)) {
			ActionContext.getContext().getSession().put("error", "两次输入新密码不一致");
			return INPUT;
		}
		user.setPassword(reNewPassword1.trim());
		DAOFactory.getInstance().getUserDAO().makePersistent(user);
		ActionContext.getContext().getSession().put("error", "修改成功");
		return SUCCESS;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}

	public String getReNewPassword1() {
		return reNewPassword1;
	}

	public void setReNewPassword1(String reNewPassword1) {
		this.reNewPassword1 = reNewPassword1;
	}
}
