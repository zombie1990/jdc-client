package edu.DAOImpl;

import edu.DAO.BlogDAO;
import edu.DAO.CommentDAO;
import edu.DAO.DAOFactory;
import edu.DAO.UserDAO;

/**
 * @author xiyu
 *
 */
public class HibernateDAOFactory extends DAOFactory {

	@Override
	public BlogDAO getBlogDAO() {
		HibernateUtil.beginTransaction();
		return (BlogDAO) instantiateDAO(BlogHibernateDAO.class);
	}

	@Override
	public CommentDAO getCommentDAO() {
		HibernateUtil.beginTransaction();
		return (CommentDAO) instantiateDAO(CommentHibernateDAO.class);
	}

	@Override
	public UserDAO getUserDAO() {
		HibernateUtil.beginTransaction();
		return (UserDAO) instantiateDAO(UserHibernateDAO.class);
	}
	
	@SuppressWarnings("unchecked")
	private GenericHibernateDAO instantiateDAO(Class daoClass) {
		try {
			GenericHibernateDAO dao = (GenericHibernateDAO) daoClass.newInstance();
			return dao;
		} catch (Exception e) {
			throw new RuntimeException("Can not instantiate DAO: " + daoClass, e);
		}
	}

}
