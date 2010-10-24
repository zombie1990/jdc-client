/**
 * 
 */
package com.jsu.struts2.action;


import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ProblemDetails extends ActionSupport {

	private static final long serialVersionUID = -25763216L;
	
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
	private Integer accept;
	private Integer submit;
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
	public void setAccept(Integer accept) {
		this.accept = accept;
	}
	public void setSubmit(Integer submit) {
		this.submit = submit;
	}
	
	public String execute() {
		
		try {
			description = description.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			input = input.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			output = output.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			sampleInput = sampleInput.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			sampleOutput = sampleOutput.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			tips = tips.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>");
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
