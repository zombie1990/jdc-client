package edu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.domains.Permission;
import edu.domains.User;

/**
 * @author xiyu
 *
 */
public class Management extends ActionSupport {

	private List<Permission> mainBoards;
	
	public String execute() throws Exception {
		List<Permission> temp = new ArrayList<Permission>();
		Map map = new HashMap<Integer, Permission>();
		map.put(0, new Permission(0, "学校概况"));
		map.put(1, new Permission(1, "新闻频道"));
		map.put(2, new Permission(2, "教师教学"));
		map.put(3, new Permission(3, "雏鹰起飞"));
		map.put(4, new Permission(4, "图片中心"));
		map.put(5, new Permission(5, "资源下载"));
		map.put(6, new Permission(6, "乾小博客"));
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(null == user) {
			ActionContext.getContext().getSession().put("error", "请先登录");
			return SUCCESS;
		}
		String permission = user.getPermission();
		for(int i = 0; i < 7; i++) {
			if('1' == permission.charAt(i)) {
				temp.add((Permission)map.get((i)));
			}
		}
		mainBoards = temp;
		
		return SUCCESS;
	}

	public List<Permission> getMainBoards() {
		return mainBoards;
	}

	public void setMainBoards(List<Permission> mainBoards) {
		this.mainBoards = mainBoards;
	}


	
	
	
}
