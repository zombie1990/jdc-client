/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Statistics;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class DeleteProblem extends ActionSupport {

	private static final long serialVersionUID = -52343242204L;
	private String id;
	private Integer contestId;
	public String getId() {
		return id;
	}
	public Integer getContestId() {
		return contestId;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	
	public String execute() {
		
		try {
			Contest contest = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
			Statistics stcs = DAOFactory.getInstance().getStatisticsDAO().findById(id, false);
			DAOFactory.getInstance().getStatisticsDAO().makeTransient(stcs);
			List<Statistics> list = DAOFactory.getInstance().getStatisticsDAO().findAllInContest(contest);
			for(int i = 1; i <= list.size(); i++) {
				Statistics temp = list.get(i-1);
				temp.setProblemIdInContest(i);
				DAOFactory.getInstance().getStatisticsDAO().makePersistent(temp);
			}
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
