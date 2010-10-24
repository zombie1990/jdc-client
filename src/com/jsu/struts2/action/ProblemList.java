/**
 * 
 */
package com.jsu.struts2.action;

import java.util.ArrayList;
import java.util.List;

import com.jsu.DAO.ProblemDAO;
import com.jsu.hibernate.domains.Problem;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ProblemList extends ActionSupport {

	private static final long serialVersionUID = -29181731L;
	
	private List<Problem> problems;
	private List<Integer> pages;
	private int pageNum = 1;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public List<Problem> getProblems() {
		return problems;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}

	public String execute() {
		
		try {
			ProblemDAO problemDAO = DAOFactory.getInstance().getProblemDAO();
			List<Problem> list = problemDAO.getPageProblems((pageNum-1)*100);
			problems = list;
			Integer count = problemDAO.getProblemCount();
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
		}catch(Exception e) {
			return "error";
		}

	}
	
}
