/**
 * 
 */
package com.jsu.struts2.action;



import com.jsu.util.OnlineUserList;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class Logoff extends ActionSupport {

	private static final long serialVersionUID = -25763216L;



	public String execute() throws Exception {
		

		ActionContext actionContext = ActionContext.getContext();
		String username = (String)actionContext.getSession().get("username");
		actionContext.getSession().clear();

		
		if(OnlineUserList.removeUser(username));
		return SUCCESS;
	}
}
