package edu.DAO;

import java.util.List;

import edu.domains.Blog;
import edu.domains.User;

/**
 * @author xiyu
 *
 */
public interface UserDAO extends GenericDAO<User, String> {

	public List<Blog> getUserBlogs(User user, String type, int start, int end);
}
