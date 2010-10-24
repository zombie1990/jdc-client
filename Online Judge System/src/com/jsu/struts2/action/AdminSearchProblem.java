/**
 * 
 */
package com.jsu.struts2.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jsu.DAO.ProblemDAO;
import com.jsu.hibernate.domains.Genre;
import com.jsu.hibernate.domains.Grade;
import com.jsu.hibernate.domains.Problem;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class AdminSearchProblem extends ActionSupport {

	private static final long serialVersionUID = -5743523214L;
	private String type;
	private String level;
	private List<Problem> problems;
	private List<Integer> pages;
	private String contestProblem;
	private List<String> grades;
	private List<String> genres;
	public String getType() {
		return type;
	}
	public String getLevel() {
		return level;
	}
	public List<Problem> getProblems() {
		return problems;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public String getContestProblem() {
		return contestProblem;
	}
	public List<String> getGrades() {
		return grades;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	public void setContestProblem(String contestProblem) {
		this.contestProblem = contestProblem;
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
			ProblemDAO problemDAO = DAOFactory.getInstance().getProblemDAO();
			Integer count;
			if("NO".equals(contestProblem)) {
				problems = problemDAO.findByGradeAndGenre(type, level);
				count = problemDAO.getProblemCount();
			}else {
				problems = problemDAO.findByGradeAndGenre(type, level, contestProblem);
				count = problemDAO.getProblemCount(contestProblem);
			}
			List<Integer> volume = new ArrayList<Integer>();
			int num;
			if(count%100 != 0)
				num = (count/100) +1;
			else num = count/100;
			for(int i = 1; i <= num; i++) {
				volume.add(i);
			}
			pages = volume;
			return SUCCESS;
		} catch(Exception e) {
			return "error";
		}

	}
}
