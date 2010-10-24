/**
 * 
 */
package com.jsu.struts2.action;

import java.util.Date;

import com.jsu.hibernate.domains.Code;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Solution;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.jsu.util.JudgeQueue;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class SubmitCode extends ActionSupport {

	private static final long serialVersionUID = -15980198L;
	
	private Integer problemId;
	private String language;
	private String code;
	public Integer getProblemId() {
		return problemId;
	}
	public String getLanguage() {
		return language;
	}
	public String getCode() {
		return code;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String execute() {
		
		try {
			String username = (String)ActionContext.getContext().getSession().get("username");
			User user = DAOFactory.getInstance().getUserDAO().findById(username, false);
			Problem problem = DAOFactory.getInstance().getProblemDAO().findById((problemId-999), false);
			Code c = new Code(code.trim());
			DAOFactory.getInstance().getCodeDAO().makePersistent(c);
			Integer lang = this.language.equals("GCC")?0:(this.language.equals("G++")?1:(this.language.equals("Java")?2:3));
			Solution solution = new Solution(lang);
			solution.setCode(c);
			solution.setCodeLength(code.length());
			solution.setDate(new Date());
			solution.setIp((String)ActionContext.getContext().getSession().get("IP"));
			solution.setProblem(problem);
			solution.setUser(user);
			DAOFactory.getInstance().getSolutionDAO().makePersistent(solution);
			String runId = solution.getId();
			switch(lang) {
			case 0 : JudgeQueue.addGCC(runId);break;
			case 1 : JudgeQueue.addGPP(runId);break;
			case 2 : JudgeQueue.addJava(runId);break;
			case 3 : JudgeQueue.addPascal(runId);break;
			default : break;
			}
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
}
