/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

import com.jsu.hibernate.domains.Contest;
import com.jsu.hibernate.domains.Problem;
import com.jsu.hibernate.domains.Solution;
import com.jsu.hibernate.domains.User;
import com.jsu.util.DAOFactory;
import com.jsu.util.LongConverter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class SearchStatusInContest extends ActionSupport {

	private static final long serialVersionUID = -1243562131204L;
	private String problemIdInContest;
	private String author;
	private String language;
	private String result;
	private List<Solution> solutions;
	private int startJudgeStatus = 0;
	private int count;
	private Integer contestId;
	private Contest contest;
	public String getProblemIdInContest() {
		return problemIdInContest;
	}
	public void setProblemIdInContest(String problemIdInContest) {
		this.problemIdInContest = problemIdInContest;
	}
	public Integer getContestId() {
		return contestId;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	public List<Solution> getSolutions() {
		return solutions;
	}
	public int getStartJudgeStatus() {
		return startJudgeStatus;
	}
	public int getCount() {
		return count;
	}
	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}
	public void setStartJudgeStatus(int startJudgeStatus) {
		this.startJudgeStatus = startJudgeStatus;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getAuthor() {
		return author;
	}
	public String getLanguage() {
		return language;
	}
	public String getResult() {
		return result;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String execute() {
		
		try {
			contest = DAOFactory.getInstance().getContestDAO().findById(contestId, false);
			Integer lang = 0, status = 0;
			if(!"All".equals(language)) {
				lang = "GCC".equals(language)?0:"G++".equals(language)?1:"Java".equals(language)?2:3;
			}
			if(!"All".equals(result)) {
				status = "Accepted".equals(result)?1:"Presentation Error".equals(result)?2:"Time Limit Exceeded".equals(result)?3:"Memory Limit Exceeded".equals(result)?4:"Wrong Answer".equals(result)?5:"Compilation Error".equals(result)?6:"Runtime Error".equals(result)?7:8;
			}
			if("".equals(problemIdInContest.trim()) || problemIdInContest == null) {
				problemIdInContest = null;
			}
			if("".equals(author.trim()) || author == null) {
				author = null;
			}
			if(problemIdInContest == null && author == null && "All".equals(language) && "All".equals(result)) {
				solutions = DAOFactory.getInstance().getSolutionDAO().findByPageInContest(startJudgeStatus, 16, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getSolutionCount(contest);
			} else if(problemIdInContest != null && author == null && "All".equals(language) && "All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findByIdInContest((int)LongConverter.strToLong(problemIdInContest), contest);
				if(problem == null) {
					this.addFieldError("problemIdInContest", "no such problem");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblem(startJudgeStatus, 16, problem, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblem(problem, contest);
			} else if(problemIdInContest == null && author != null && "All".equals(language) && "All".equals(result)) {
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByUser(startJudgeStatus, 16, user, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByUser(user, contest);
			} else if(problemIdInContest == null && author == null && !"All".equals(language) && "All".equals(result)) {
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByLanguage(startJudgeStatus, 16, lang, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByLanguage(lang, null);
			} else if(problemIdInContest == null && author == null && "All".equals(language) && !"All".equals(result)) {
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByStatus(startJudgeStatus, 16, status, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByStatus(status, contest);
			} else if(problemIdInContest != null && author != null && "All".equals(language) && "All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById((int)LongConverter.strToLong(problemIdInContest)-999, "N");
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(problem == null) {
					this.addFieldError("problemIdInContest", "no such problem");
					return INPUT;
				}
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndUser(startJudgeStatus, 16, problem, user, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndUser(problem, user, contest);
			} else if(problemIdInContest != null && author == null && !"All".equals(language) && "All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findByIdInContest((int)LongConverter.strToLong(problemIdInContest), contest);
				if(problem == null) {
					this.addFieldError("problemIdInContest", "no such problem");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndLanguage(startJudgeStatus, 16, problem, lang, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndLanguage(problem, lang, contest);
			} else if(problemIdInContest != null && author == null && "All".equals(language) && !"All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findByIdInContest((int)LongConverter.strToLong(problemIdInContest), contest);
				if(problem == null) {
					this.addFieldError("problemIdInContest", "no such problem");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndStatus(startJudgeStatus, 16, problem, status, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndStatus(problem, status, contest);
			} else if(problemIdInContest == null && author != null && !"All".equals(language) && "All".equals(result)) {
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByUserAndLanguage(startJudgeStatus, 16, user, lang, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByUserAndLanguage(user, lang, contest);
			} else if(problemIdInContest == null && author != null && "All".equals(language) && !"All".equals(result)) {
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByUserAndStatus(startJudgeStatus, 16, user, status, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByUserAndStatus(user, status, contest);
			} else if(problemIdInContest == null && author == null && !"All".equals(language) && !"All".equals(result)) {
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByLanguageAndStatus(startJudgeStatus, 16, lang, status, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByLanguageAndStatus(lang, status, contest);
			} else if(problemIdInContest != null && author != null && !"All".equals(language) && "All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findByIdInContest((int)LongConverter.strToLong(problemIdInContest), contest);
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(problem == null) {
					this.addFieldError("problemIdInContest", "no such problem");
					return INPUT;
				}
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndUserAndLanguage(startJudgeStatus, 16, problem, user, lang, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndUserAndLanguage(problem, user, lang, contest);
			} else if(problemIdInContest != null && author != null && "All".equals(language) && !"All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findByIdInContest((int)LongConverter.strToLong(problemIdInContest), contest);
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(problem == null) {
					this.addFieldError("problemIdInContest", "no such problem");
					return INPUT;
				}
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndUserAndStatus(startJudgeStatus, 16, problem, user, status, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndUserAndStatus(problem, user, status, contest);
			} else if(problemIdInContest != null && author == null && !"All".equals(language) && !"All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findByIdInContest((int)LongConverter.strToLong(problemIdInContest), contest);
				if(problem == null) {
					this.addFieldError("problemIdInContest", "no such problem");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndLanguageAndStatus(startJudgeStatus, 16, problem, lang, status, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndLanguageAndStatus(problem, lang, status, contest);
			} else if(problemIdInContest == null && author != null && !"All".equals(language) && !"All".equals(result)) {
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByUserAndLanguageAndStatus(startJudgeStatus, 16, user, lang, status, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByUserAndLanguageAndStatus(user, lang, status, contest);
			} else if(problemIdInContest != null && author != null && !"All".equals(language) && !"All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findByIdInContest((int)LongConverter.strToLong(problemIdInContest), contest);
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(problem == null) {
					this.addFieldError("problemIdInContest", "no such problem");
					return INPUT;
				}
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndUserAndLanguageAndStatus(startJudgeStatus, 16, problem, user, lang, status, contest);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndUserAndLanguageAndStatus(problem, user, lang, status, contest);
			}
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
