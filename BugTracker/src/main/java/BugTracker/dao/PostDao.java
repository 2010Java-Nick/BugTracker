package BugTracker.dao;

import BugTracker.pojos.Post;

/**
 * This is the interface for the basic CRUD methods for the Post table in the database.
 * @author Vincent
 *
 */

public interface PostDao {
	
	public Post createPost(Post post);
	
	public Post readPost(long postId);
	
	public Post updatePost(Post post);
	
	public void deletePost(Post post);

}
