/**
 * 
 */
package com.jsu.struts2.action;

import java.util.List;

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
public class SearchStatus extends ActionSupport {

	private static final long serialVersionUID = -1243562131204L;
	private String problemId;
	private String author;
	private String language;
	private String result;
	private List<Solution> solutions;
	private int startJudgeStatus = 0;
	private int count;
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
	public String getProblemId() {
		return problemId;
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
	public void setProblemId(String problemId) {
		this.problemId = problemId;
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
			Integer lang = 0, status = 0;
			if(!"All".equals(language)) {
				lang = "GCC".equals(language)?0:"G++".equals(language)?1:"Java".equals(language)?2:3;
			}
			if(!"All".equals(result)) {
				status = "Accepted".equals(result)?1:"Presentation Error".equals(result)?2:"Time Limit Exceeded".equals(result)?3:"Memory Limit Exceeded".equals(result)?4:"Wrong Answer".equals(result)?5:"Compilation Error".equals(result)?6:"Runtime Error".equals(result)?7:8;
			}
			if("".equals(problemId.trim()) || problemId == null) {
				problemId = null;
			}
			if("".equals(author.trim()) || author == null) {
				author = null;
			}
			if(problemId == null && author == null && "All".equals(language) && "All".equals(result)) {
				solutions = DAOFactory.getInstance().getSolutionDAO().findByPage(startJudgeStatus, 16);
				count = DAOFactory.getInstance().getSolutionDAO().getSolutionCount();
			} else if(problemId != null && author == null && "All".equals(language) && "All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById((int)LongConverter.strToLong(problemId)-999, "N");
				if(problem == null) {
					this.addFieldError("problemId", "no such problem");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblem(startJudgeStatus, 16, problem, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblem(problem, null);
			} else if(problemId == null && author != null && "All".equals(language) && "All".equals(result)) {
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByUser(startJudgeStatus, 16, user, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByUser(user, null);
			} else if(problemId == null && author == null && !"All".equals(language) && "All".equals(result)) {
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByLanguage(startJudgeStatus, 16, lang, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByLanguage(lang, null);
			} else if(problemId == null && author == null && "All".equals(language) && !"All".equals(result)) {
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByStatus(startJudgeStatus, 16, status, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByStatus(status, null);
			} else if(problemId != null && author != null && "All".equals(language) && "All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById((int)LongConverter.strToLong(problemId)-999, "N");
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(problem == null) {
					this.addFieldError("problemId", "no such problem");
					return INPUT;
				}
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndUser(startJudgeStatus, 16, problem, user, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndUser(problem, user, null);
			} else if(problemId != null && author == null && !"All".equals(language) && "All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById((int)LongConverter.strToLong(problemId)-999, "N");
				if(problem == null) {
					this.addFieldError("problemId", "no such problem");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndLanguage(startJudgeStatus, 16, problem, lang, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndLanguage(problem, lang, null);
			} else if(problemId != null && author == null && "All".equals(language) && !"All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById((int)LongConverter.strToLong(problemId)-999, "N");
				if(problem == null) {
					this.addFieldError("problemId", "no such problem");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndStatus(startJudgeStatus, 16, problem, status, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndStatus(problem, status, null);
			} else if(problemId == null && author != null && !"All".equals(language) && "All".equals(result)) {
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByUserAndLanguage(startJudgeStatus, 16, user, lang, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByUserAndLanguage(user, lang, null);
			} else if(problemId == null && author != null && "All".equals(language) && !"All".equals(result)) {
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByUserAndStatus(startJudgeStatus, 16, user, status, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByUserAndStatus(user, status, null);
			} else if(problemId == null && author == null && !"All".equals(language) && !"All".equals(result)) {
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByLanguageAndStatus(startJudgeStatus, 16, lang, status, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByLanguageAndStatus(lang, status, null);
			} else if(problemId != null && author != null && !"All".equals(language) && "All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById((int)LongConverter.strToLong(problemId)-999, "N");
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(problem == null) {
					this.addFieldError("problemId", "no such problem");
					return INPUT;
				}
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndUserAndLanguage(startJudgeStatus, 16, problem, user, lang, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndUserAndLanguage(problem, user, lang, null);
			} else if(problemId != null && author != null && "All".equals(language) && !"All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById((int)LongConverter.strToLong(problemId)-999, "N");
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(problem == null) {
					this.addFieldError("problemId", "no such problem");
					return INPUT;
				}
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndUserAndStatus(startJudgeStatus, 16, problem, user, status, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndUserAndStatus(problem, user, status, null);
			} else if(problemId != null && author == null && !"All".equals(language) && !"All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById((int)LongConverter.strToLong(problemId)-999, "N");
				if(problem == null) {
					this.addFieldError("problemId", "no such problem");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndLanguageAndStatus(startJudgeStatus, 16, problem, lang, status, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndLanguageAndStatus(problem, lang, status, null);
			} else if(problemId == null && author != null && !"All".equals(language) && !"All".equals(result)) {
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByUserAndLanguageAndStatus(startJudgeStatus, 16, user, lang, status, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByUserAndLanguageAndStatus(user, lang, status, null);
			} else if(problemId != null && author != null && !"All".equals(language) && !"All".equals(result)) {
				Problem problem = DAOFactory.getInstance().getProblemDAO().findById((int)LongConverter.strToLong(problemId)-999, "N");
				User user = DAOFactory.getInstance().getUserDAO().findById(author, false);
				if(problem == null) {
					this.addFieldError("problemId", "no such problem");
					return INPUT;
				}
				if(user == null) {
					this.addFieldError("author", "no such user");
					return INPUT;
				}
				solutions = DAOFactory.getInstance().getSolutionDAO().searchByProblemAndUserAndLanguageAndStatus(startJudgeStatus, 16, problem, user, lang, status, null);
				count = DAOFactory.getInstance().getSolutionDAO().getCountByProblemAndUserAndLanguageAndStatus(problem, user, lang, status, null);
			}
			return SUCCESS;
		}catch(Exception e) {
			return "error";
		}

	}
}
