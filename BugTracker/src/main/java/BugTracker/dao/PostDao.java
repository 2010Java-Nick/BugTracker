package BugTracker.dao;

import java.util.List;

import BugTracker.pojos.Post;
import BugTracker.pojos.Ticket;

/**
 * This is the interface for the basic CRUD methods for the Post table in the database.
 * @author Vincent
 *
 */

public interface PostDao {
	
	public Post createPost(Post post);
	
	public Post readPost(long postId);
	
	public Post updatePost(long postId, Post post);
	
	public List<Post> readListPostByTicket(long ticketId);
	
	public void deletePost(Post post);

}
