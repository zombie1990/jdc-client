/**
 * 
 */
package com.jsu.struts2.action;


import com.jsu.util.WentForth;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class Inform extends ActionSupport {

	private static final long serialVersionUID = -25763216L;
	
	private String inform;

	public String getInform() {
		return inform;
	}

	public void setInform(String inform) {
		this.inform = inform;
	}
	
	public String execute() {
		
		try {
			ActionContext actionContext = ActionContext.getContext();
			actionContext.put("tip", "Operation Success!");
			WentForth.inform = inform;
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
