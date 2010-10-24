/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class SearchContest extends ActionSupport {

	private static final long serialVersionUID = -432342204L;
	private String diy;
	private String searchKey;
	private String searchType;
	private List<Contest> contests;
	public String getDiy() {
		return diy;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public String getSearchType() {
		return searchType;
	}
	public List<Contest> getContests() {
		return contests;
	}
	public void setDiy(String diy) {
		this.diy = diy;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public void setContests(List<Contest> contests) {
		this.contests = contests;
	}
	
	public String execute() {
		
		try {
			if("".equals(searchKey.trim()) || null == searchKey) {
				return INPUT;
			}
			if("Title".equals(searchType)) {
				contests = DAOFactory.getInstance().getContestDAO().findByTitle(searchKey.trim(), diy);
			} else {
				User user = DAOFactory.getInstance().getUserDAO().findById(searchKey.trim(), false);
				if(user == null) {
					return INPUT;
				}
				contests = DAOFactory.getInstance().getContestDAO().findByHolder(user, diy);
			}
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
