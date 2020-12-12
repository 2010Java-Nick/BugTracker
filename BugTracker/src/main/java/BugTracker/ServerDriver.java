package BugTracker;

import java.io.File;
import java.time.LocalDateTime;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import BugTracker.dao.TicketDao;
import BugTracker.dao.TicketDaoImpl;
import BugTracker.pojos.Employee;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Status;
import BugTracker.pojos.Ticket;
import BugTracker.pojos.UserRole;

@Configuration
@ComponentScan
public class ServerDriver {
	@Autowired
	SessionFactory sessionFactory;
	TicketDao ticketDao = new TicketDaoImpl(sessionFactory);


	public static void main(String[] args) throws LifecycleException, ServletException {


		
		Tomcat server = new Tomcat();
		server.setPort(9090);
		server.getConnector();
		server.addWebapp("", new File("./").getAbsolutePath());
		server.start();
		server.getServer().await();
		
		
		
	}
	
	public  void testMethod() {
		UserRole developer = new UserRole("Developer", 2);
		Priority priority1 = new Priority("Urgent");
		Status opened = new Status("Opened");
		Employee employee1 = new Employee("Acacia", "Holliday", "aholliday@gmail.com", 0, developer);
		Employee employee2 = new Employee("Hannah", "Novack", "hNovack@gmail.com", 0, developer);
		Ticket ticket = new Ticket(employee1, "Test ticket", LocalDateTime.now(),opened, priority1, 3, null, employee2);
		ticketDao.createTicket(ticket);
		
	}
}
