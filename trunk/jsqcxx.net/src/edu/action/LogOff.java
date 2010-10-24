package edu.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author xiyu
 *
 */
public class LogOff extends ActionSupport {

	public String execute() {
		ActionContext.getContext().getSession().remove("user");
		return SUCCESS;
	}
}
