/**
 * 
 */
package com.jsu.util;


import com.jsu.DAO.CodeDAO;
import com.jsu.DAO.ContestDAO;
import com.jsu.DAO.GenreDAO;
import com.jsu.DAO.GradeDAO;
import com.jsu.DAO.LoginLogDAO;
import com.jsu.DAO.ProblemDAO;
import com.jsu.DAO.ResultDAO;
import com.jsu.DAO.SolutionDAO;
import com.jsu.DAO.StatisticsDAO;
import com.jsu.DAO.UserDAO;
import com.jsu.hibernate.DAOImpl.CodeDAOHibernate;
import com.jsu.hibernate.DAOImpl.ContestDAOHibernate;
import com.jsu.hibernate.DAOImpl.GeneralHibernateDAO;
import com.jsu.hibernate.DAOImpl.GenreDAOHibernate;
import com.jsu.hibernate.DAOImpl.GradeDAOHibernate;
import com.jsu.hibernate.DAOImpl.LoginLogDAOHibernate;
import com.jsu.hibernate.DAOImpl.ProblemDAOHibernate;
import com.jsu.hibernate.DAOImpl.ResultDAOHibernate;
import com.jsu.hibernate.DAOImpl.SolutionDAOHibernate;
import com.jsu.hibernate.DAOImpl.StatisticsDAOHibernate;
import com.jsu.hibernate.DAOImpl.UserDAOHibernate;

/**
 * @author: Luo Qiang
 * Last Modified: 2010-1-26
 */
public class HibernateDAOFactory extends DAOFactory {

	/**
	 * Instantiate XXXDAOHibernate.
	 * @param daoClass
	 * @return dao
	 */
	@SuppressWarnings("unchecked")
	private GeneralHibernateDAO instantiateDAO(Class daoClass) {
		try {
			GeneralHibernateDAO dao = (GeneralHibernateDAO) daoClass.newInstance();
			return dao;
		} catch (Exception e) {
			throw new RuntimeException("Can not instantiate DAO: " + daoClass, e);
		}
	}
	
	@Override
    public CodeDAO getCodeDAO() {
    	HibernateUtil.beginTransaction();
    	return (CodeDAO) instantiateDAO(CodeDAOHibernate.class);
    }
    
    @Override
    public ContestDAO getContestDAO() {
    	HibernateUtil.beginTransaction();
    	return (ContestDAO) instantiateDAO(ContestDAOHibernate.class);
    }
    
    @Override
    public LoginLogDAO getLoginLogDAO() {
    	HibernateUtil.beginTransaction();
    	return (LoginLogDAO) instantiateDAO(LoginLogDAOHibernate.class);
    }
    
    @Override
    public ProblemDAO getProblemDAO() {
    	HibernateUtil.beginTransaction();
    	return (ProblemDAO) instantiateDAO(ProblemDAOHibernate.class);
    }
    
    @Override
    public ResultDAO getResultDAO() {
    	HibernateUtil.beginTransaction();
    	return (ResultDAO) instantiateDAO(ResultDAOHibernate.class);
    }
    
    public SolutionDAO getSolutionDAO() {
    	HibernateUtil.beginTransaction();
    	return (SolutionDAO) instantiateDAO(SolutionDAOHibernate.class);
    }
    
    @Override
    public StatisticsDAO getStatisticsDAO() {
    	HibernateUtil.beginTransaction();
    	return (StatisticsDAO) instantiateDAO(StatisticsDAOHibernate.class);
    }
    
    @Override
    public UserDAO getUserDAO() {
    	HibernateUtil.beginTransaction();
    	return (UserDAO) instantiateDAO(UserDAOHibernate.class);
    }
    
    @Override
    public GradeDAO getGradeDAO() {
    	HibernateUtil.beginTransaction();
    	return (GradeDAO) instantiateDAO(GradeDAOHibernate.class);
    }
    
    @Override
    public GenreDAO getGenreDAO() {
    	HibernateUtil.beginTransaction();
    	return (GenreDAO) instantiateDAO(GenreDAOHibernate.class);
    }
    
}
