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

/**
 * @author: Luo Qiang
 * Last Modified: 2010-1-26
 */
public abstract class DAOFactory {

	private static final String CLASS_NAME = "com.jsu.util.HibernateDAOFactory";
    private static Object initLock = new Object();
    private static DAOFactory factory = null;

    /**
     * Abstract-Factory-Mode makes low coupling with JAVA Persistence.
     * In this case, We decide to use Hibernate as a persistence.
     * @return HibernateDAOFactory
     */
    @SuppressWarnings("unchecked")
    public static DAOFactory getInstance() {
        if (factory == null) {
            synchronized (initLock) {
                if (factory == null) {
                    try {
                        /**** Load the named Class, and instantiating it. ****/
                        Class clazz = Class.forName(CLASS_NAME);
                        factory = (DAOFactory) clazz.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return factory;
    }
    
    /**
     * Attach your DAO interfaces here.
     */
    public abstract CodeDAO getCodeDAO();
    public abstract ContestDAO getContestDAO();
    public abstract LoginLogDAO getLoginLogDAO();
    public abstract ProblemDAO getProblemDAO();
    public abstract ResultDAO getResultDAO();
    public abstract SolutionDAO getSolutionDAO();
    public abstract StatisticsDAO getStatisticsDAO();
    public abstract UserDAO getUserDAO();
    public abstract GradeDAO getGradeDAO();
    public abstract GenreDAO getGenreDAO();
    
}
