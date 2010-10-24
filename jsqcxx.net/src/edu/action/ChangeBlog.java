package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.Blog;
import edu.domains.User;

public class ChangeBlog extends ActionSupport {

	private String uuid;
	private int manageType;
	
	private String title;
	private String leftPicURL;
	private String rightPicURL;
	private String type;
	private String content;
	
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(null == user) {
			ActionContext.getContext().getSession().put("error", "请先登录 ");
			return INPUT;
		}
		if(null == title || "".equals(title)) {
			ActionContext.getContext().getSession().put("error", "请填写标题");
			return INPUT;
		}
		if(null == content || "".equals(content)) {
			ActionContext.getContext().getSession().put("error", "请编辑内容");
			return INPUT;
		}
		if(null == uuid || "".equals(uuid))
			return ERROR;
		Blog blog = DAOFactory.getInstance().getBlogDAO().findById(uuid, false);
		blog.setTitle(title);
		blog.setContent(content);
		blog.setType(type);
		if(null != leftPicURL && !"".equals(leftPicURL))
			blog.setLeftPicURL(leftPicURL);
		if(null != rightPicURL && !"".equals(rightPicURL))
			blog.setRightPicURL(rightPicURL);
		DAOFactory.getInstance().getBlogDAO().makePersistent(blog);
		ActionContext.getContext().getSession().put("error", "修改成功");
		
		return SUCCESS;
	}


	public int getManageType() {
		return manageType;
	}

	public void setManageType(int manageType) {
		this.manageType = manageType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLeftPicURL() {
		return leftPicURL;
	}

	public void setLeftPicURL(String leftPicURL) {
		this.leftPicURL = leftPicURL;
	}

	public String getRightPicURL() {
		return rightPicURL;
	}

	public void setRightPicURL(String rightPicURL) {
		this.rightPicURL = rightPicURL;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
