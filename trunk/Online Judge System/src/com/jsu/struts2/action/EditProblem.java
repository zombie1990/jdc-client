/**
 * 
 */
package com.jsu.struts2.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jsu.hibernate.domains.Genre;
import com.jsu.hibernate.domains.Grade;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class EditProblem extends ActionSupport {

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
	private String type;
	private String hardLevel;
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
	public String execute() {
		
		try {
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
			memoryLimit = memoryLimit >>> 10;
			javaMemoryLimit = javaMemoryLimit >>> 10;
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
