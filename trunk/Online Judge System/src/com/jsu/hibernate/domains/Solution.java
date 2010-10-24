/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class Solution implements Serializable {

	private static final long serialVersionUID = -15244181L;
	/**
	 * Fields
	 */
	private String id;
	private User user;
	private Problem problem;
	private Code code;
	private Integer codeLength;
	private Date date;
	private String ip;
	private Integer language;
	private Integer numberOfWrongTestCase;
	private Integer useTime;
	private Integer useMemory;
	private Integer status;
	private Contest contest;
	private Integer problemIdInContest;
	public Solution(Integer language) {
		this.language = language;
		this.status = 0;
	}
	public Solution() {}
	
	public Integer getProblemIdInContest() {
		return problemIdInContest;
	}
	public void setProblemIdInContest(Integer problemIdInContest) {
		this.problemIdInContest = problemIdInContest;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @return the problem
	 */
	public Problem getProblem() {
		return problem;
	}
	/**
	 * @return the code
	 */
	public Code getCode() {
		return code;
	}
	/**
	 * @return the codeLength
	 */
	public Integer getCodeLength() {
		return codeLength;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @return the language
	 */
	public Integer getLanguage() {
		return language;
	}
	/**
	 * @return the numberOfWrongTestCase
	 */
	public Integer getNumberOfWrongTestCase() {
		return numberOfWrongTestCase;
	}
	/**
	 * @return the useTime
	 */
	public Integer getUseTime() {
		return useTime;
	}
	/**
	 * @return the useMemory
	 */
	public Integer getUseMemory() {
		return useMemory;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @return the contest
	 */
	public Contest getContest() {
		return contest;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @param problem the problem to set
	 */
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Code code) {
		this.code = code;
	}
	/**
	 * @param codeLength the codeLength to set
	 */
	public void setCodeLength(Integer codeLength) {
		this.codeLength = codeLength;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(Integer language) {
		this.language = language;
	}
	/**
	 * @param numberOfWrongTestCase the numberOfWrongTestCase to set
	 */
	public void setNumberOfWrongTestCase(Integer numberOfWrongTestCase) {
		this.numberOfWrongTestCase = numberOfWrongTestCase;
	}
	/**
	 * @param useTime the useTime to set
	 */
	public void setUseTime(Integer useTime) {
		this.useTime = useTime;
	}
	/**
	 * @param useMemory the useMemory to set
	 */
	public void setUseMemory(Integer useMemory) {
		this.useMemory = useMemory;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @param contest the contest to set
	 */
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	
	

	
}
