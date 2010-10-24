/**
 * 
 */
package com.jsu.struts2.action;

import com.jsu.hibernate.domains.Genre;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class NewGenre extends ActionSupport {

	private static final long serialVersionUID = -123124504L;
	private String typeName;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String execute() {
		
		try {
			Genre genre = new Genre(typeName);
			DAOFactory.getInstance().getGenreDAO().makePersistent(genre);
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
	public void validate() {
		if (null == this.getTypeName() || "".equals(this.getTypeName())) {
			this.addFieldError("typeName", "required");
		} 
	}
}
