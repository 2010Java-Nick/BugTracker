package BugTracker.services;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import BugTracker.dao.EmployeeDao;
import BugTracker.dao.PostDao;
import BugTracker.dao.TicketDao;
import BugTracker.dtos.PostDto;
import BugTracker.pojos.Post;
import BugTracker.pojos.Ticket;

@Service(value="postService")
public class PostServiceImpl implements PostService {
	
	SessionFactory sessionFactory;


	PostDao postDao;
	EmployeeDao employeeDao;
	TicketDao ticketDao;

	
	@Autowired
	@Qualifier(value = "employeeDao")
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	@Autowired
	@Qualifier(value = "postDao")
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	@Autowired
	@Qualifier(value = "ticketDao")
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
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
	public List<Post> getAllPostsInTicket(long ticketId) {
		return postDao.readListPostByTicket(ticketId);
	}

	@Override
	public Post updatePost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 /**
	  * Converts the input PostDTO to a Post object to be able to create and send it 
	  * to the Database
	  * @author Vincent 
	  */
	@Override
	public Post toPost(PostDto postDto ) {
		return new Post(employeeDao.readEmployeeById(postDto.getEmployeeId()), postDto.getBody(), LocalDateTime.now(), ticketDao.readTicket(postDto.getTicketId()));
	}
}
