/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Administrator
 *
 */
public class Contest implements Serializable {

	/**
	 * Fields
	 */
	private static final long serialVersionUID = -15244131L;
	private Integer contestId;
	private String title;
	private String description;
	private Date startTime;
	private Date endTime;
	private Integer status; // 0:scheduled 1:running 2:finished
	private String password;
	private String defunct;
	private Set<Result> results;
	private Set<Statistics> statisticses;
	private Set<Solution> solutions;
	private User user;
	public String diy;
	
	public Contest(String diy) {
		this.defunct = "N";
		this.diy = diy;
		this.status = 0;
	}
	
	public Contest() {
	}
	
	public Integer getContestId() {
		return contestId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Integer getStatus() {
		return status;
	}

	public String getPassword() {
		return password;
	}

	public String getDefunct() {
		return defunct;
	}

	public Set<Result> getResults() {
		return results;
	}

	public Set<Statistics> getStatisticses() {
		return statisticses;
	}

	public Set<Solution> getSolutions() {
		return solutions;
	}

	public User getUser() {
		return user;
	}

	public String getDiy() {
		return diy;
	}

	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}

	public void setStatisticses(Set<Statistics> statisticses) {
		this.statisticses = statisticses;
	}

	public void setSolutions(Set<Solution> solutions) {
		this.solutions = solutions;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDiy(String diy) {
		this.diy = diy;
	}

}
