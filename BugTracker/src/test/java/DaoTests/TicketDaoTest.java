package DaoTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


import org.hibernate.SessionFactory;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import BugTracker.dao.TicketDaoImpl;
import BugTracker.pojos.Ticket;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class TicketDaoTest {
	
	@InjectMocks
	public SessionFactory sessionFactory;
	

	public TicketDaoImpl ticketDao = new TicketDaoImpl(sessionFactory);
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
		Ticket ticket = new Ticket();
		
		when(ticketDao.createTicket(ticket));
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
