/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.hibernate.domains.Grade;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class NewGrade extends ActionSupport {

	private static final long serialVersionUID = -12312412204L;
	private String levelName;
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	public String execute() {
		
		try {
			Grade grade = new Grade(levelName);
			DAOFactory.getInstance().getGradeDAO().makePersistent(grade);
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
	public void validate() {
		if (null == this.getLevelName() || "".equals(this.getLevelName())) {
			this.addFieldError("levelName", "required");
		} 
	}
}
