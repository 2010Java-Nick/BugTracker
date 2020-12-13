package BugTracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import BugTracker.pojos.Post;
import BugTracker.pojos.Status;

public class PostDaoImpl implements PostDao {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	@Autowired
	public PostDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * createPost takes in a new post and puts it into the database, then returns
	 * that post
	 * @params post
	 * @returns post
	 * @author Acacia and Hannah
	 */
	@Override
	public Post createPost(Post post) {

		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(post);
		tx.commit();
		sess.close();
		
		return post;

	}

	/**
	 * readPost takes in a postId and returns the corresponding object from the database
	 * @param long
	 * @returns Post
	 * @author Acacia and Hannah
	 */
	@Override
	public Post readPost(long postId) {
		Post post;
		Session sess = sessionFactory.openSession();
		post =  sess.get(Post.class, postId);
		sess.close();
		return post;
	}

	@Override
	public Post updatePost(long postId, Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Post post) {
		// TODO Auto-generated method stub
		
	}

}
