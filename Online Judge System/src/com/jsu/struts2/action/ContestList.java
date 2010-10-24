/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ContestList extends ActionSupport {

	private static final long serialVersionUID = -15982198L;
	private String diy;
	private int status = 1;
	private int count;
	private int lastPage;
	private Integer contestPage = 1;
	private List<Contest> contests;
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public List<Contest> getContests() {
		return contests;
	}
	public void setContests(List<Contest> contests) {
		this.contests = contests;
	}
	public String getDiy() {
		return diy;
	}
	public int getStatus() {
		return status;
	}
	public int getCount() {
		return count;
	}
	public Integer getContestPage() {
		return contestPage;
	}
	public void setDiy(String diy) {
		this.diy = diy;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setContestPage(Integer contestPage) {
		this.contestPage = contestPage;
	}
	
	public String execute() {
		
		try {
			count = DAOFactory.getInstance().getContestDAO().getContestCount(diy, status, "N");
			lastPage = ( count % 16 > 0 ) ? (count>>>4)+1 :count>>>4;
			int start = (contestPage-1) << 4;
			List<Contest> list = DAOFactory.getInstance().getContestDAO().findByReferrence(diy, status, start, 16, "N");
			contests = list;
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
