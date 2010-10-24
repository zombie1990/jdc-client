/**
 * 
 */
package com.jsu.struts2.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jsu.hibernate.domains.Genre;
import com.jsu.hibernate.domains.Grade;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class Admin extends ActionSupport {

	private static final long serialVersionUID = -29181731L;
	private List<String> grades;
	private List<String> genres;

	public List<String> getGrades() {
		return grades;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGrades(List<String> grades) {
		this.grades = grades;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String execute() {
		
		try {
			Iterator<Grade> iter1 = DAOFactory.getInstance().getGradeDAO().findAll().iterator();
			Iterator<Genre> iter2 = DAOFactory.getInstance().getGenreDAO().findAll().iterator();
			List<String> list1 = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();
			while(iter1.hasNext()) {
				list1.add(iter1.next().getProblemLevel());
			}
			while(iter2.hasNext()) {
				list2.add(iter2.next().getProblemType());
			}
			grades = list1;
			genres = list2;
			return SUCCESS;
		} catch(Exception e) {
			return "error";
		}

	}
}
