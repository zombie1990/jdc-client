/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Statistics implements Serializable {

	/**
	 * Fields
	 */
	private static final long serialVersionUID = -12352116744131L;
	private String id;
	private Integer problemIdInContest;
	private Contest contest;
	private Problem problem;
	private Integer AC;
	private Integer PE;
	private Integer WA;
	private Integer RE;
	private Integer TLE;
	private Integer MLE;
	private Integer OLE;
	private Integer CE;
	private Integer SE;
	private Integer total;
	
	public Statistics(Integer problemIdInContest) {
		this.AC = 0;
		this.PE = 0;
		this.WA = 0;
		this.RE = 0;
		this.TLE = 0;
		this.MLE = 0;
		this.OLE = 0;
		this.CE = 0;
		this.SE = 0;
		this.total = 0;
		this.problemIdInContest = problemIdInContest;
	}
	
	public Statistics() {}
	
	public Integer getProblemIdInContest() {
		return problemIdInContest;
	}
	public void setProblemIdInContest(Integer problemIdInContest) {
		this.problemIdInContest = problemIdInContest;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the contest
	 */
	public Contest getContest() {
		return contest;
	}
	/**
	 * @return the problem
	 */
	public Problem getProblem() {
		return problem;
	}
	/**
	 * @return the aC
	 */
	public Integer getAC() {
		return AC;
	}
	/**
	 * @return the pE
	 */
	public Integer getPE() {
		return PE;
	}
	/**
	 * @return the wA
	 */
	public Integer getWA() {
		return WA;
	}
	/**
	 * @return the rE
	 */
	public Integer getRE() {
		return RE;
	}
	/**
	 * @return the tLE
	 */
	public Integer getTLE() {
		return TLE;
	}
	/**
	 * @return the mLE
	 */
	public Integer getMLE() {
		return MLE;
	}
	/**
	 * @return the oLE
	 */
	public Integer getOLE() {
		return OLE;
	}
	/**
	 * @return the cE
	 */
	public Integer getCE() {
		return CE;
	}
	/**
	 * @return the sE
	 */
	public Integer getSE() {
		return SE;
	}
	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param contest the contest to set
	 */
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	/**
	 * @param problem the problem to set
	 */
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	/**
	 * @param ac the aC to set
	 */
	public void setAC(Integer ac) {
		AC = ac;
	}
	/**
	 * @param pe the pE to set
	 */
	public void setPE(Integer pe) {
		PE = pe;
	}
	/**
	 * @param wa the wA to set
	 */
	public void setWA(Integer wa) {
		WA = wa;
	}
	/**
	 * @param re the rE to set
	 */
	public void setRE(Integer re) {
		RE = re;
	}
	/**
	 * @param tle the tLE to set
	 */
	public void setTLE(Integer tle) {
		TLE = tle;
	}
	/**
	 * @param mle the mLE to set
	 */
	public void setMLE(Integer mle) {
		MLE = mle;
	}
	/**
	 * @param ole the oLE to set
	 */
	public void setOLE(Integer ole) {
		OLE = ole;
	}
	/**
	 * @param ce the cE to set
	 */
	public void setCE(Integer ce) {
		CE = ce;
	}
	/**
	 * @param se the sE to set
	 */
	public void setSE(Integer se) {
		SE = se;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
