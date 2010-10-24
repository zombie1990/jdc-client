package edu.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.Blog;

public class FindSpecialBlog extends ActionSupport {

	private String titleName;
	private Blog blog;
	
	public String execute() throws Exception {
		
		if(null == titleName || "".equals(titleName))
			return ERROR;
		
		String title;
		if("xzjy".equals(titleName))
			title = "校长寄语";
		else if("xx".equals(titleName))
			title = "校训";
		else 
			return ERROR;
		
		blog = DAOFactory.getInstance().getBlogDAO().getSpecialByTitle(title);
		blog.setClicks(blog.getClicks()+1);
		DAOFactory.getInstance().getBlogDAO().makePersistent(blog);
		return SUCCESS;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
}
