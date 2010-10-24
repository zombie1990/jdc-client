/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Grade implements Serializable {

	private static final long serialVersionUID = -1524534531L;
	public String problemLevel;

	public String getProblemLevel() {
		return problemLevel;
	}
	public void setProblemLevel(String problemLevel) {
		this.problemLevel = problemLevel;
	}
	
	public Grade() {}
	public Grade(String problemLevel) {
		this.problemLevel = problemLevel;
	}
}
