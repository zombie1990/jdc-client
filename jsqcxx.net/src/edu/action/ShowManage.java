package edu.action;

import java.beans.Encoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.DAO.DAOFactory;
import edu.domains.Blog;
import edu.domains.Permission;
import edu.domains.User;

/**
 * @author xiyu
 *
 */
public class ShowManage extends ActionSupport {

	private int manageType;
	private List<Blog> blogs;
	private List<Permission> mainBoards;
	private String selectType;
	
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
		if(null != selectType && !"".equals(selectType)) {
			if("admin".equals(user.getUsername())) {
				int count = DAOFactory.getInstance().getBlogDAO().getCount();
				blogs = DAOFactory.getInstance().getBlogDAO().getBlogsByType(selectType, 0, count);
			}
			else {
				int count = DAOFactory.getInstance().getBlogDAO().getCount(user);
				blogs = DAOFactory.getInstance().getUserDAO().getUserBlogs(user, selectType, 0, count);
			}
		}
		
		List<Permission> temp = new ArrayList<Permission>();
		Map map = new HashMap<Integer, Permission>();
		map.put(0, new Permission(0, "学校概况"));
		map.put(1, new Permission(1, "校园新闻"));
		map.put(2, new Permission(2, "教师教学"));
		map.put(3, new Permission(3, "雏鹰起飞"));
		map.put(4, new Permission(4, "图片中心"));
		map.put(5, new Permission(5, "资源下载"));
		map.put(6, new Permission(6, "乾小博客"));
		String permission = user.getPermission();
		for(int i = 0; i < 7; i++) {
			if('1' == permission.charAt(i)) {
				temp.add((Permission)map.get((i)));
			}
		}
		mainBoards = temp;
		
		return SUCCESS;
	}

	public int getManageType() {
		return manageType;
	}

	public void setManageType(int manageType) {
		this.manageType = manageType;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public List<Permission> getMainBoards() {
		return mainBoards;
	}

	public void setMainBoards(List<Permission> mainBoards) {
		this.mainBoards = mainBoards;
	}

	public String getSelectType() {
		return selectType;
	}

	public void setSelectType(String selectType) {
		this.selectType = selectType;
	}

}
