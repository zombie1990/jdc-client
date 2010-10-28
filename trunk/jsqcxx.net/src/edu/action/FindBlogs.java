package edu.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.Blog;

public class FindBlogs extends ActionSupport {

	private String section;
	private String type;
	private int op = 0;
	private int count;
	private List<Blog> blogs;
	
	public String execute() throws Exception {
		
		if(null == type || "".equals(type) || null == section || "".equals(section))
			return ERROR;
		count = DAOFactory.getInstance().getBlogDAO().getCount(type);
		blogs = DAOFactory.getInstance().getBlogDAO().getBlogsByType(type, op, op+4);
		
		if("xxgk".equals(section))
			return "xxgk";
		else if("xwpd".equals(section))
			return "xwpd";
		else if("jsjx".equals(section))
			return "jsjx";
		else if("cyqf".equals(section))
			return "cyqf";
		else if("tpzx".equals(section))
			return "tpzx";
		else if("zyxz".equals(section))
			return "zyxz";
		else if("qxbk".equals(section))
			return "qxbk";
		else 
			return ERROR;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
}
