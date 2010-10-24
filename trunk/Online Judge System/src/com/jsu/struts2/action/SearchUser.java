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
public class SearchUser extends ActionSupport {

	private static final long serialVersionUID = -87986204L;
	private List<User> users;
	private int startAuthorRanklist = 0;
	private int count;
	private String name;
	public List<User> getUsers() {
		return users;
	}
	public int getStartAuthorRanklist() {
		return startAuthorRanklist;
	}
	public int getCount() {
		return count;
	}
	public String getName() {
		return name;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void setStartAuthorRanklist(int startAuthorRanklist) {
		this.startAuthorRanklist = startAuthorRanklist;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String execute() {
		
		try {
			users = DAOFactory.getInstance().getUserDAO().getPageUserRanklist(name.trim(), startAuthorRanklist, 32);
			
			count = DAOFactory.getInstance().getUserDAO().getUserCount(name.trim());
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
