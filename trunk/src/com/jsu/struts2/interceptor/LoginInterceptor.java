/**
 * 
 */
package com.jsu.struts2.interceptor;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Administrator
 *
 */
public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -5718204L;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext actionContext = invocation.getInvocationContext();
		String username = (String)actionContext.getSession().get("username");
		if( null != username ) {
			return invocation.invoke();
		}
		actionContext.put("tip", "You have not login yet or already logoff, please login first!");
		return ActionSupport.LOGIN;
	}

}
