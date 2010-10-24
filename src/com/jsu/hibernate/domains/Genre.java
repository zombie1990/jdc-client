/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Genre implements Serializable {

	private static final long serialVersionUID = -15123124131L;
	private String problemType;
	public String getProblemType() {
		return problemType;
	}
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	
	public Genre() {}
	public Genre(String problemType) {
		this.problemType = problemType;
	}
}
