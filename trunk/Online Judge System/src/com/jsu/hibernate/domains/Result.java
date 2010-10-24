/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Result implements Serializable {

	
	/**
	 * Fields
	 */
	private static final long serialVersionUID = -1124124131L;
	private String id;
	private User user;
	private Contest contest;
	private Problem problem;
	private Integer AC;  // if this contest result was AC, set 1, else 0.
	private Integer time;
	private Integer wrongs;
	private Integer problemIdInContest;
	
	public Result(User user, Contest contest, Problem problem, Integer problemIdInContest) {
		this.user = user;
		this.contest = contest;
		this.problem = problem;
		this.problemIdInContest = problemIdInContest;
		this.AC = 0;
		this.time = 0;
		this.wrongs = 0;
	}
	
	public Result() {}

	public String getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Contest getContest() {
		return contest;
	}

	public Problem getProblem() {
		return problem;
	}

	public Integer getAC() {
		return AC;
	}

	public Integer getTime() {
		return time;
	}

	public Integer getWrongs() {
		return wrongs;
	}

	public Integer getProblemIdInContest() {
		return problemIdInContest;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setContest(Contest contest) {
		this.contest = contest;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public void setAC(Integer ac) {
		AC = ac;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public void setWrongs(Integer wrongs) {
		this.wrongs = wrongs;
	}

	public void setProblemIdInContest(Integer problemIdInContest) {
		this.problemIdInContest = problemIdInContest;
	}

	
}
