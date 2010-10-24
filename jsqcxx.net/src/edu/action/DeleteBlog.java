package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.Blog;
import edu.domains.User;

public class DeleteBlog extends ActionSupport {

	private int manageType;
	private String uuid;
	
	public String execute() throws Exception {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(null == user) {
			ActionContext.getContext().getSession().put("error", "请先登录");
			return INPUT;
		}
		if("00000000".equals(user.getPermission())) {
			ActionContext.getContext().getSession().put("error", "您没有权利管理该板块");
			return INPUT;
		}
		if(manageType < 0 || manageType > 6) {
			return ERROR;
		}
		if(null == uuid || "".equals(uuid))
			return ERROR;
		
		Blog blog = DAOFactory.getInstance().getBlogDAO().findById(uuid, false);
		DAOFactory.getInstance().getBlogDAO().makeTransient(blog);
		ActionContext.getContext().getSession().put("error", "删除成功");
		return INPUT;
	}

	public int getManageType() {
		return manageType;
	}

	public void setManageType(int manageType) {
		this.manageType = manageType;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
