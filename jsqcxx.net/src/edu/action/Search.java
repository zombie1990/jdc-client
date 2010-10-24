package edu.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.Blog;

public class Search extends ActionSupport {

	private List<Blog> blogs;
	private String title;
	
	public String execute() throws Exception {
		
		blogs = DAOFactory.getInstance().getBlogDAO().searchBlogs(title);
		return SUCCESS;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
