package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.Blog;
import edu.domains.Comment;
import edu.domains.User;

public class AddComment extends ActionSupport {

	private String blogId;
	private String reply;
	
	public String execute() throws Exception {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(null == user) {
			ActionContext.getContext().getSession().put("error", "请先登录");
			return INPUT;
		}
		if(null == blogId || "".equals(blogId))
			return ERROR;
		if(null == reply || "".equals(reply)) {
			ActionContext.getContext().getSession().put("error", "留言不能为空");
			return INPUT;
		}
		Blog blog = DAOFactory.getInstance().getBlogDAO().findById(blogId, false);
		if(null == blog)
			return ERROR;
		Comment comment = new Comment(reply, user, blog);
		DAOFactory.getInstance().getCommentDAO().makePersistent(comment);
		return SUCCESS;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
}
