/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Administrator
 *
 */
public class Problem implements Serializable {

	private static final long serialVersionUID = -15244181L;
	/**
	 * Fields
	 */
	private Integer problemId;
	private String title;
	private String description;
	private String input;
	private String output;
	private String sampleInput;
	private String sampleOutput;
	private String tips;
	private String author;
	private long timeLimit;
	private long memoryLimit;
	private long javaTimeLimit;
	private long javaMemoryLimit;
	private String type;
	private String hardLevel;
	private Set<Solution> solutions;
	private Set<Statistics> statisticses;
	private Integer accept;
	private Integer submit;
	private String defunct;
	private String contestProblem;
	
	public Problem(String contestProblem) {
		this.accept = 0;
		this.submit = 0;
		this.contestProblem = contestProblem;
	}
	
	public Problem() {}
	
	public String getDefunct() {
		return defunct;
	}

	public String getContestProblem() {
		return contestProblem;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
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

	public Integer getProblemId() {
		return problemId;
	}
	public String getTitle() {
		return title;
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
	public long getTimeLimit() {
		return timeLimit;
	}
	public long getMemoryLimit() {
		return memoryLimit;
	}
	public long getJavaTimeLimit() {
		return javaTimeLimit;
	}
	public long getJavaMemoryLimit() {
		return javaMemoryLimit;
	}
	public String getType() {
		return type;
	}
	public Set<Solution> getSolutions() {
		return solutions;
	}
	public Set<Statistics> getStatisticses() {
		return statisticses;
	}
	public Integer getAccept() {
		return accept;
	}
	public Integer getSubmit() {
		return submit;
	}
	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public void setTimeLimit(long timeLimit) {
		this.timeLimit = timeLimit;
	}
	public void setMemoryLimit(long memoryLimit) {
		this.memoryLimit = memoryLimit;
	}
	public void setJavaTimeLimit(long javaTimeLimit) {
		this.javaTimeLimit = javaTimeLimit;
	}
	public void setJavaMemoryLimit(long javaMemoryLimit) {
		this.javaMemoryLimit = javaMemoryLimit;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSolutions(Set<Solution> solutions) {
		this.solutions = solutions;
	}
	public void setStatisticses(Set<Statistics> statisticses) {
		this.statisticses = statisticses;
	}
	public void setAccept(Integer accept) {
		this.accept = accept;
	}
	public void setSubmit(Integer submit) {
		this.submit = submit;
	}

}
