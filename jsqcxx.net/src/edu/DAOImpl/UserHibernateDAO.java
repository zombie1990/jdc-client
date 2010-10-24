package edu.DAOImpl;

import java.util.List;

import edu.DAO.UserDAO;
import edu.domains.Blog;
import edu.domains.User;

/**
 * @author xiyu
 *
 */
public class UserHibernateDAO extends GenericHibernateDAO<User, String> implements
		UserDAO {

	public List<Blog> getUserBlogs(User user,String type, int start, int end) {
		int length = end - start + 1;
		String query = "from Blog b where b.user = :user and b.type = :type" + " order by b.postTime desc";
		@SuppressWarnings("unchecked")
		List<Blog> myBlogs = getSession().createQuery(query)
											.setEntity("user", user)
											.setParameter("type", type)
											.setFirstResult(start)
											.setMaxResults(length)
											.list();
		return myBlogs;
	}

}
