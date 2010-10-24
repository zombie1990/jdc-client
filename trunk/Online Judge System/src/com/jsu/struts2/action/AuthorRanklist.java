/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class AuthorRanklist extends ActionSupport {

	private static final long serialVersionUID = 2943652635813100778L;
	private List<User> users;
	private int startAuthorRanklist = 0;
	private int count;
	public int getStartAuthorRanklist() {
		return startAuthorRanklist;
	}
	public void setStartAuthorRanklist(int startAuthorRanklist) {
		this.startAuthorRanklist = startAuthorRanklist;
	}
	public List<User> getUsers() {
		return users;
	}
	public int getCount() {
		return count;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String execute() {
		
		try {
			List<User> list = DAOFactory.getInstance().getUserDAO().getPageUserRanklist(startAuthorRanklist, 32);
			users=list;
			
			count = DAOFactory.getInstance().getUserDAO().getUserCount();

			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
