/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class Ranklist implements Serializable {

	private static final long serialVersionUID = -11234244131L;
	private User user;
	private int totalSolved;
	private int totalTime;
	private List<Result> results;
	public User getUser() {
		return user;
	}
	public int getTotalSolved() {
		return totalSolved;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setTotalSolved(int totalSolved) {
		this.totalSolved = totalSolved;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	
	public Ranklist() {};
}
