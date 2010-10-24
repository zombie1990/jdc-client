/**
 * 
 */
package com.jsu.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class Wait extends ActionSupport {

	private static final long serialVersionUID = -29181731L;



	public String execute() throws Exception {

		Thread.sleep(2500);
		return SUCCESS;
	}
}
