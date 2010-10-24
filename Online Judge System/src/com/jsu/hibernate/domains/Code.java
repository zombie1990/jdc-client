/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Code implements Serializable {

	private static final long serialVersionUID = -15244181L;
	/**
	 * Fields
	 */
	private String id;
	private String compileError;
	private String code;
	
	public Code() {}
	public Code(String code) {
		this.code = code;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the compileError
	 */
	public String getCompileError() {
		return compileError;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param compileError the compileError to set
	 */
	public void setCompileError(String compileError) {
		this.compileError = compileError;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	
}
