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
public class ShowSourceCode extends ActionSupport {

	private static final long serialVersionUID = -15980198L;
	
	private String sourceCode;
	private String solutionId;
	
	public String getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
	public String execute() {
		
		try {
			Solution solution = DAOFactory.getInstance().getSolutionDAO().findById(solutionId, false);
			Code code = solution.getCode();
			sourceCode = code.getCode();
			sourceCode = sourceCode.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
