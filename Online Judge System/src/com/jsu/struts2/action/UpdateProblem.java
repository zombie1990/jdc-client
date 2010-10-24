/**
 * 
 */
package com.jsu.struts2.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jsu.DAO.ProblemDAO;
import com.jsu.hibernate.domains.Genre;
import com.jsu.hibernate.domains.Grade;
import com.jsu.hibernate.domains.Problem;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class UpdateProblem extends ActionSupport {

	private static final long serialVersionUID = -27737405L;
	
	private Integer problemId;
	private String title;
	private int timeLimit;
	private int memoryLimit;
	private int javaTimeLimit;
	private int javaMemoryLimit;
	private String description;
	private String input;
	private String output;
	private String sampleInput;
	private String sampleOutput;
	private String tips;
	private String author;
	private String type;
	private String hardLevel;
	private String contestProblem;
	private List<String> grades;
	private List<String> genres;
	public List<String> getGrades() {
		return grades;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGrades(List<String> grades) {
		this.grades = grades;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public String getContestProblem() {
		return contestProblem;
	}
	public void setContestProblem(String contestProblem) {
		this.contestProblem = contestProblem;
	}
	public String getHardLevel() {
		return hardLevel;
	}
	public void setHardLevel(String hardLevel) {
		this.hardLevel = hardLevel;
	}
	public String getTitle() {
		return title;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public int getMemoryLimit() {
		return memoryLimit;
	}
	public int getJavaTimeLimit() {
		return javaTimeLimit;
	}
	public int getJavaMemoryLimit() {
		return javaMemoryLimit;
	}
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
	public String getAuthor() {
		return author;
	}
	public String getType() {
		return type;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public void setMemoryLimit(int memoryLimit) {
		this.memoryLimit = memoryLimit;
	}
	public Integer getProblemId() {
		return problemId;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public void setJavaTimeLimit(int javaTimeLimit) {
		this.javaTimeLimit = javaTimeLimit;
	}
	public void setJavaMemoryLimit(int javaMemoryLimit) {
		this.javaMemoryLimit = javaMemoryLimit;
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
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public String execute() {
		
		try {
			ProblemDAO problemDAO = DAOFactory.getInstance().getProblemDAO();
			Problem problem = problemDAO.findById(problemId, false);
			problem.setTitle(title.trim());
			problem.setDescription(description.trim());
			problem.setInput(input.trim());
			problem.setOutput(output.trim());
			problem.setSampleInput(sampleInput.trim());
			problem.setSampleOutput(sampleOutput.trim());
			problem.setTips(tips.trim());
			problem.setAuthor(author.trim());
			problem.setType(type.trim());
			problem.setHardLevel(hardLevel.trim());
			problem.setContestProblem(contestProblem);
			problem.setDefunct("NO".equals(contestProblem) ? "N" : "Y");
			problem.setTimeLimit((long)timeLimit);
			problem.setMemoryLimit((long)(memoryLimit << 10));
			problem.setJavaTimeLimit((long)javaTimeLimit);
			problem.setJavaMemoryLimit((long)(javaMemoryLimit << 10));
			problemDAO.makePersistent(problem);
			ActionContext.getContext().put("tip", "Operation success!");
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}
	}
	
	public void validate() {
		Iterator<Grade> iter1 = DAOFactory.getInstance().getGradeDAO().findAll().iterator();
		Iterator<Genre> iter2 = DAOFactory.getInstance().getGenreDAO().findAll().iterator();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		while(iter1.hasNext()) {
			list1.add(iter1.next().getProblemLevel());
		}
		while(iter2.hasNext()) {
			list2.add(iter2.next().getProblemType());
		}
		grades = list1;
		genres = list2;
	}
}
