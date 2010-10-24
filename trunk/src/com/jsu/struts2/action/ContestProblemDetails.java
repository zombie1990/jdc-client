/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.hibernate.domains.Problem;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ContestProblemDetails extends ActionSupport {

	private static final long serialVersionUID = -52235204L;
	private Integer problemIdInContest;
	private Integer problemId;
	private Integer contestId;
	private Integer accept;
	private Integer submit;
	private Problem problem;
	private String description;
	private String input;
	private String output;
	private String sampleInput;
	private String sampleOutput;
	private String tips;
	public String getDescription() {
		return description;
	}
	public String getInput() {
		return input;
	}
	public String getOutput() {
		return output;
	}
	public String getSampleInput() {
		return sampleInput;
	}
	public String getSampleOutput() {
		return sampleOutput;
	}
	public String getTips() {
		return tips;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public void setSampleInput(String sampleInput) {
		this.sampleInput = sampleInput;
	}
	public void setSampleOutput(String sampleOutput) {
		this.sampleOutput = sampleOutput;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public Integer getProblemIdInContest() {
		return problemIdInContest;
	}
	public Integer getProblemId() {
		return problemId;
	}
	public Integer getContestId() {
		return contestId;
	}
	public Integer getAccept() {
		return accept;
	}
	public Integer getSubmit() {
		return submit;
	}
	public Problem getProblem() {
		return problem;
	}
	public void setProblemIdInContest(Integer problemIdInContest) {
		this.problemIdInContest = problemIdInContest;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public void setAccept(Integer accept) {
		this.accept = accept;
	}
	public void setSubmit(Integer submit) {
		this.submit = submit;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	
	public String execute() {
		
		try {
			problem = DAOFactory.getInstance().getProblemDAO().findById(problemId, false);
			
			description = problem.getDescription().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			input = problem.getInput().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			output = problem.getOutput().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			sampleInput = problem.getSampleInput().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			sampleOutput = problem.getSampleOutput().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			tips = problem.getTips().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
}
