/**
 * 
 */
package com.jsu.struts2.action;

import java.util.Date;

import com.jsu.DAO.UserDAO;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.jsu.util.LongConverter;
import com.jsu.util.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class CreateUsers extends ActionSupport {

	private static final long serialVersionUID = -25763216L;
	
	private String start;
	private String end;
	private String passwords;
	public String getStart() {
		return start;
	}
	public String getEnd() {
		return end;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	
	public String execute() {
		try {
			long s = LongConverter.strToLong(start);
			long e = LongConverter.strToLong(end);
			UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
			for(long i = s; i <=e; i++) {
				Long j = (Long)i;
				User registered = userDAO.findById(j.toString().trim(), false);
				if(registered != null) {
					this.addFieldError("start", j.toString() + " has already registered");
					return INPUT;
				}
				User user = new User(j.toString().trim(), MD5.getMD5(passwords), new Date());
				userDAO.makePersistent(user);
			}
			ActionContext.getContext().put("tip", "Operation success!");
			return SUCCESS;
		} catch(Exception e) {
			return "error";
		}

	}
	
	public void validate() {

		long s = LongConverter.strToLong(start);
		long e = LongConverter.strToLong(end);
		if(null == start || "".equals(start) || null == end || "".equals(end) || null == passwords || "".equals(passwords)) {
			this.addFieldError("start", "can not be empty!");
		} else if(!start.matches("^[0-9_]{4,15}$") || !end.matches("^[0-9_]{4,15}$")) {
			this.addFieldError("start", "must be numbers, and length in 4~15");
		} else if(s > e || (e - s) > 100 ) {
			this.addFieldError("start", "end less than start! and can not create users more than 100!");
		}
	}
}
