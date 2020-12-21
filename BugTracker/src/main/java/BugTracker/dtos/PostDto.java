package BugTracker.dtos;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import BugTracker.dao.EmployeeDao;
import BugTracker.dao.TicketDao;
import BugTracker.pojos.Post;

public class PostDto {
	
	private String body;
	private long ticketId;
	private long employeeId;
	private String employeeName;
	private String timePosted;
	
	
	public PostDto() {
		super();
	}



	public PostDto(String body, long ticketId, long employeeId) {
		super();
		this.body = body;
		this.ticketId = ticketId;
		this.employeeId = employeeId;
	}



	public PostDto(String body, String employeeName, String timePosted) {
		super();
		this.body = body;
		this.employeeName = employeeName;
		this.timePosted = timePosted;
	}



	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getTimePosted() {
		return timePosted;
	}



	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}



	public String getBody() {
		return body;
	}



	public void setBody(String body) {
		this.body = body;
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
		return "PostDto [body=" + body + ", ticketId=" + ticketId + ", employeeId=" + employeeId
				+ "]";
	}
	
	

}
