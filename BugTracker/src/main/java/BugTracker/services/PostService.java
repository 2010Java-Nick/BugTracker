package BugTracker.services;

import java.util.List;

import BugTracker.pojos.Post;
import BugTracker.pojos.Ticket;

public interface PostService {
	/**
	 * 
	 * @param post
	 * Get parameter of Post Object to send to the dao to process it into the database. No return expected.
	 */
	public Post createPost(Post post);
	
	/**
	 * 
	 * @param post
	 * Get parameter of Post Object to delete Post in Database
	 */
	public void deletePost(Post post);
	
	/**
	 * 
	 * @param ticket
	 * Input ticket to fetch the list of Posts in the database.
	 * @return
	 * Returns a List of Posts of a given Ticket.
	 * @author Vincent
	 */
	public List<Post> getAllPostsInTicket(Ticket ticket);
	
	/**
	 * 
	 * @return
	 * Updates Post and return the updated post.
	 */
	public Post updatePost(Post post);
	
	

}
