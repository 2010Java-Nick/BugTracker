package ServiceTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import BugTracker.dao.PostDaoImpl;
import BugTracker.dao.TicketDaoImpl;
import BugTracker.pojos.Employee;
import BugTracker.pojos.Post;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Status;
import BugTracker.pojos.Ticket;
import BugTracker.pojos.UserRole;
import BugTracker.services.PostServiceImpl;
import BugTracker.services.TicketServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

	@Mock
	PostDaoImpl postDao;
	
	@InjectMocks
	PostServiceImpl postService;
	
	private Post testPost;
	private Post testPost1;
	private Post testPost2;
	private List<Post> posts = new ArrayList<Post>();
	
	
	@Before
	public void setUp() throws Exception {
		UserRole developer = new UserRole("Developer", 2);
		Priority priority1 = new Priority("Urgent");
		Status opened = new Status("Opened");
		Employee employee = new Employee(91, "Acacia", "Holliday", "aholliday@gmail.com", 0, developer, 0);
		Employee employee2 = new Employee(92, "Hannah", "Novack", "hNovack@gmail.com", 0, developer, 0);
		Ticket ticket = new Ticket(employee, "Test ticket", LocalDateTime.now(),opened, priority1, 3, employee2);
		testPost = new Post(1, employee, "Test FIle", LocalDateTime.now(), ticket);
		testPost1 = new Post(2, employee, "Test FIle", LocalDateTime.now(), ticket);
		testPost2 = new Post(3, employee, "Test FIle", LocalDateTime.now(), ticket);
		posts.add(testPost);
		posts.add(testPost1);
		posts.add(testPost2);
		
		
	}
	
	@Test
	public void testReadListPost() {
		long ticketId = 1;
		when(postDao.readListPostByTicket(ticketId)).thenReturn(posts);
		List<Post> testPosts = postService.getAllPostsInTicket(1);
		assertEquals(3, testPosts.size());
	}

	@Test
	public void testCreatePost() {
		when(postDao.createPost(Mockito.any(Post.class))).thenReturn(testPost);
		Post checkPost = postService.createPost(testPost);
		assertEquals(testPost, checkPost);
	}
	
}
