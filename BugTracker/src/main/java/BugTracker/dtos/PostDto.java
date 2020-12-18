package BugTracker.dtos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import BugTracker.dao.EmployeeDao;
import BugTracker.dao.TicketDao;
import BugTracker.pojos.Post;

public class PostDto {
	
	private String body;
	private String author;
	private long ticketId;
	private long employeeId;
	
	
	private EmployeeDao employeeDao;
	private TicketDao ticketDao;
	

	@Autowired
	@Qualifier(value = "employeeDao")
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	
	@Autowired
	@Qualifier(value = "ticketDao")
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}



	public PostDto() {
		super();
	}



	public PostDto(String body, String author, long ticketId, long employeeId) {
		super();
		this.body = body;
		this.author = author;
		this.ticketId = ticketId;
		this.employeeId = employeeId;
	}





	public String getBody() {
		return body;
	}



	public void setBody(String body) {
		this.body = body;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public long getTicketId() {
		return ticketId;
	}



	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}



	public long getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
		result = prime * result + (int) (ticketId ^ (ticketId >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDto other = (PostDto) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "PostDto [body=" + body + ", author=" + author + ", ticketId=" + ticketId + ", employeeId=" + employeeId
				+ "]";
	}
	
	public Post toPost() {
		return new Post(employeeDao.readEmployeeById(employeeId), body, LocalDateTime.now(), ticketDao.readTicket(ticketId));
	}

}
