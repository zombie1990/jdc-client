/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.hibernate.domains.Code;
import com.jsu.hibernate.domains.Solution;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ShowCompileErrorInfo extends ActionSupport {

	private static final long serialVersionUID = -29131731L;
	
	private String solutionId;
	private String errorInfo;
	public String getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	public String execute() {
		
		try {
			Solution solution = DAOFactory.getInstance().getSolutionDAO().findById(solutionId, false);
			Code code = solution.getCode();
			errorInfo = code.getCompileError();
			errorInfo = errorInfo.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
