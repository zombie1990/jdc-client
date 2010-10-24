package edu.DAO;

import java.util.List;

import edu.domains.Blog;
import edu.domains.Comment;
import edu.domains.User;

/**
 * @author xiyu
 *
 */
public interface BlogDAO extends GenericDAO<Blog, String> {

	public List<Comment> getComments(Blog blog);
	
	public List<Blog> getBlogsByType(String type, int start, int end);
	
	public Blog getSpecialByTitle(String title);
	
	public List<Blog> searchBlogs(String title);
	
	public int getCount();
	public int getCount(User user);
	public int getCount(String type);
//	public List<Blog> getBlogsByType(String[] types, int start, int end);
}
