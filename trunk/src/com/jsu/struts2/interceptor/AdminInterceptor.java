/**
 * 
 */
package com.jsu.struts2.interceptor;


import com.jsu.DAO.UserDAO;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Administrator
 *
 */
public class AdminInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -5947507L;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		String username = (String)actionContext.getSession().get("username");
		UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
		User user = userDAO.findById(username, false);
		String isAdmin = user.getAdmin();
		if( isAdmin.equals("Y") ) 
			return invocation.invoke();
		else {
			actionContext.put("tip", "You do not have the permission!");
			return "access";
		}
	}

}
