package edu.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.Blog;
import edu.domains.Comment;

public class ShowContent extends ActionSupport {

	private String uuid;
	private Blog blog;
	private List<Comment> comments;
	
	public String execute() throws Exception {
		
		if(null == uuid)
			uuid = "";
		blog = DAOFactory.getInstance().getBlogDAO().findById(uuid, false);
		comments = DAOFactory.getInstance().getBlogDAO().getComments(blog);
		blog.setClicks(blog.getClicks()+1);
		DAOFactory.getInstance().getBlogDAO().makePersistent(blog);
		return SUCCESS;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
