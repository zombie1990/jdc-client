/**
 * 
 */
package com.jsu.struts2.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Ranklist;
import com.jsu.hibernate.domains.Result;
import com.jsu.hibernate.domains.Statistics;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class ShowRanklist extends ActionSupport {

	private static final long serialVersionUID = -123511112204L;
	private Integer contestId;
	private Contest contest;
	private List<Ranklist> ranklist;
	private List<Statistics> problems;
	
	public List<Statistics> getProblems() {
		return problems;
	}
	public void setProblems(List<Statistics> problems) {
		this.problems = problems;
	}
	public List<Ranklist> getRanklist() {
		return ranklist;
	}
	public void setRanklist(List<Ranklist> ranklist) {
		this.ranklist = ranklist;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	public Integer getContestId() {
		return contestId;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	
	public String execute() {
		
		try {
			List<Ranklist> list = new ArrayList<Ranklist>();
			
			contest = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
			problems = DAOFactory.getInstance().getStatisticsDAO().findAllInContest(contest);
			List<User> users = DAOFactory.getInstance().getResultDAO().getUsers(contest);
			Iterator<User> iter = users.iterator();
			while(iter.hasNext()) {
				Ranklist r = new Ranklist();
				User user = iter.next();
				int totalSolved = DAOFactory.getInstance().getResultDAO().getTotalSolved(user, contest);
				int totalTime = DAOFactory.getInstance().getResultDAO().getTotalTime(user, contest);
				List<Result> results = DAOFactory.getInstance().getResultDAO().getUserResult(user, contest);
				r.setUser(user);
				r.setTotalSolved(totalSolved);
				r.setTotalTime(totalTime);
				r.setResults(results);
				list.add(r);
			}
			ranklist = list;
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
	
}
