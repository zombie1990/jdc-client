package edu.DAO;

/**
 * @author xiyu
 *
 */
public abstract class DAOFactory {

	private static DAOFactory factory = null;
	private static Object initLock = new Object();
	
	private static final String CLASS_NAME = "edu.DAOImpl.HibernateDAOFactory";
	
	/**
	 * 
	 * @return The Data Access Object(DAO) factory
	 */
	@SuppressWarnings("unchecked")
    public static DAOFactory getInstance() {
        if (factory == null) {
            synchronized (initLock) {
                if (factory == null) {
                    try {
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
	
	public abstract UserDAO getUserDAO();
	public abstract BlogDAO getBlogDAO();
	public abstract CommentDAO getCommentDAO();
}
