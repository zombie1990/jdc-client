/**
 * 
 */
package com.jsu.struts2.action;

import java.util.ArrayList;
import java.util.List;

import com.jsu.hibernate.domains.Problem;
import com.jsu.util.DAOFactory;
import com.jsu.util.LongConverter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class SearchProblem extends ActionSupport {

	private static final long serialVersionUID = -123567204L;
	private String searchKey;
	private String searchType;
	private List<Problem> problems;
	private List<Integer> pages;
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
	public String getSearchKey() {
		return searchKey;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String execute() {
		
		try {
			Integer count = DAOFactory.getInstance().getProblemDAO().getProblemCount();
			List<Integer> volume = new ArrayList<Integer>();
			int num;
			if(count%100 != 0)
				num = (count/100) +1;
			else num = count/100;
			for(int i = 1; i <= num; i++) {
				volume.add(i);
			}
			pages = volume;
			if("".equals(searchKey) || null == searchKey) {
				return INPUT;
			}
			if("ID".equals(searchType)) {
				Integer problemId = (int)LongConverter.strToLong(searchKey);
				problemId = problemId - 999;
				Integer max = DAOFactory.getInstance().getProblemDAO().getProblemCount();
				if(problemId < 1 || problemId > max) {
					return INPUT;
				}
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById(problemId, "N");
				List<Problem> list = new ArrayList<Problem>();
				list.add(problem);
				problems = list;
			} else {
				problems = DAOFactory.getInstance().getProblemDAO().findByTitle(searchKey, "N");
			}
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
