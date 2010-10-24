/**
 * 
 */
package com.jsu.struts2.action;

import java.util.Date;

import com.jsu.hibernate.domains.Code;
import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Result;
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
public class SubmitCodeInContest extends ActionSupport {

	private static final long serialVersionUID = -98192204L;
	private Integer problemId;
	private Integer problemIdInContest;
	private Integer contestId;
	private String language;
	private String code;
	public Integer getProblemId() {
		return problemId;
	}
	public Integer getProblemIdInContest() {
		return problemIdInContest;
	}
	public Integer getContestId() {
		return contestId;
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
	public void setProblemIdInContest(Integer problemIdInContest) {
		this.problemIdInContest = problemIdInContest;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String execute() {
		
		try {
			Contest contest = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
			String username = (String)ActionContext.getContext().getSession().get("username");
			User user = DAOFactory.getInstance().getUserDAO().findById(username, false);
			Problem problem = DAOFactory.getInstance().getProblemDAO().findById(problemId, false);
			Result temp = DAOFactory.getInstance().getResultDAO().findByReferrence(user, contest, problem);
			if(temp == null) {
				Result result = new Result(user, contest, problem, problemIdInContest);
				DAOFactory.getInstance().getResultDAO().makePersistent(result);
			}
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
			solution.setProblemIdInContest(problemIdInContest);
			solution.setContest(contest);
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
	
	public void validate() {
		Contest contest = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
		if(contest.getStatus() == 0) {
			this.addFieldError("code", "the contest has not start yet");
		}
		if(contest.getStatus() == 2) {
			this.addFieldError("code", "the contest has already ended");
		}
	}
}
