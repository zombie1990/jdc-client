/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class MyContestList extends ActionSupport {

	private static final long serialVersionUID = -57186804L;
	private int status = 1;
	private int count;
	private int lastPage;
	private Integer contestPage = 1;
	private List<Contest> contests;
	public int getStatus() {
		return status;
	}
	public int getCount() {
		return count;
	}
	public int getLastPage() {
		return lastPage;
	}
	public Integer getContestPage() {
		return contestPage;
	}
	public List<Contest> getContests() {
		return contests;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public void setContestPage(Integer contestPage) {
		this.contestPage = contestPage;
	}
	public void setContests(List<Contest> contests) {
		this.contests = contests;
	}
	
	public String execute() {
		
		try {
			ActionContext actionContext = ActionContext.getContext();
			String username = (String)actionContext.getSession().get("username");
			User user = DAOFactory.getInstance().getUserDAO().findById(username, false);
			
			count = DAOFactory.getInstance().getContestDAO().getContestCount(user, status);
			lastPage = ( count % 16 > 0 ) ? (count>>>4)+1 :count>>>4;
			int start = (contestPage-1) << 4;
			contests = DAOFactory.getInstance().getContestDAO().getMyContests(user, status, start, 16);
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
