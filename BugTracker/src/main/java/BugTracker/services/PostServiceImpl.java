package BugTracker.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import BugTracker.dao.PostDao;
import BugTracker.pojos.Post;
import BugTracker.pojos.Ticket;

@Service(value="postService")
public class PostServiceImpl implements PostService {
	



	PostDao postDao;
	
	
	EmployeeService employeeService;
	
	@Autowired
	@Qualifier(value = "postDao")
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	@Autowired
	@Qualifier(value = "employeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	

	/**
	 * createPost takes in a new post, passes it to the postDao, then returns
	 * the post that has been added to the database
	 * @param post
	 * @returns post
	 * @author Hannah and Acacia
	 */
	@Override
	public Post createPost(Post post) {
		return postDao.createPost(post);

	}

	@Override
	public void deletePost(Post post) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPostsInTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post updatePost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

}
