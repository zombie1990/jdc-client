/**
 * 
 */
package com.jsu.struts2.interceptor;

import com.jsu.hibernate.domains.Contest;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Administrator
 *
 */
public class PrivateContestInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -57112204L;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext actionContext = invocation.getInvocationContext();
		Integer contestId = (Integer)actionContext.getValueStack().findValue("contestId");
		if(contestId == null) {
			return "error";
		}
		Contest contest = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
		if(contest == null) {
			return "error";
		}
		Integer logined = (Integer)actionContext.getSession().get("loginedContestId");
		if(contest.getPassword() != null && !contestId.equals(logined)) {
			actionContext.getValueStack().setValue("contestId", contestId);
			return "contestAccess";
		} else {
			return invocation.invoke();
		}
	}

}
