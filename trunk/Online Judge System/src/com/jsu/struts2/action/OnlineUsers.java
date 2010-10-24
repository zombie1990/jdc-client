/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.util.OnlineUserList;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class OnlineUsers extends ActionSupport {

	private static final long serialVersionUID = -15980198L;
	
	private List<String> users;

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}
	
	public String execute() throws Exception {
		try {
			users = OnlineUserList.list();
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
}
