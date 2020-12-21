package BugTracker.pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import BugTracker.dtos.TicketDto;

/**
 * This is the information for a bug which will be resolved by a developer. The assigned developer will 
 * resolve the ticket and receive exp points for the ticket.
 * @author Ksenia, Vincent
 * 
 */

@Entity
@Table(name = "bug_tracker_ticket")

public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private long ticketId;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "opener_id" )
	private Employee opener;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "employee_id")
	private Employee assignedDeveloper;
	
	private String name;
	private LocalDateTime created;
	
	@OneToOne (cascade= {CascadeType.ALL})
	@JoinColumn(name = "status_id")
	private Status status;
	
	@OneToOne (cascade= {CascadeType.ALL})
	@JoinColumn(name = "priority_id")
	private Priority priority;
	
	@Column(name = "difficulty_level")
	private int difficultyLevel;
	
	@OneToMany (cascade= {CascadeType.ALL }, mappedBy = "ticket")
	private List<Post> comments = new ArrayList<>();
	
	public Ticket() {
		super();
	}

	public Ticket(Employee opener, String name, LocalDateTime created, Status status, Priority priority,
			int difficultyLevel, Employee assignedDeveloper) {
		super();
		this.opener = opener;
		this.name = name;
		this.created = created;
		this.status = status;
		this.priority = priority;
		this.difficultyLevel = difficultyLevel;
		this.assignedDeveloper = assignedDeveloper;
	}

	public Ticket(long ticketId, Employee opener, String name, LocalDateTime created, Status status,
			Priority priority, int difficultyLevel, List<Post> comments, Employee assignedDeveloper) {
		super();
		this.ticketId = ticketId;
		this.opener = opener;
		this.name = name;
		this.created = created;
		this.status = status;
		this.priority = priority;
		this.difficultyLevel = difficultyLevel;
		this.comments = comments;
		this.assignedDeveloper = assignedDeveloper;
	}
	
	public TicketDto toDisplay() {
		
		return new TicketDto(ticketId, opener.getFirstName(), name, created.toString(),
				status.getStatusName(), priority.getPriorityName(), difficultyLevel,
				assignedDeveloper.getFirstName());
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public Employee getOpener() {
		return opener;
	}

	public void setOpener(Employee opener) {
		this.opener = opener;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public List<Post> getComments() {
		return comments;
	}

	public void setComments(List<Post> comments) {
		this.comments = comments;
	}
	

	public Employee getAssignedDeveloper() {
		return assignedDeveloper;
	}

	public void setAssignedDeveloper(Employee assignedDeveloper) {
		this.assignedDeveloper = assignedDeveloper;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignedDeveloper == null) ? 0 : assignedDeveloper.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + difficultyLevel;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((opener == null) ? 0 : opener.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Ticket other = (Ticket) obj;
		if (assignedDeveloper == null) {
			if (other.assignedDeveloper != null)
				return false;
		} else if (!assignedDeveloper.equals(other.assignedDeveloper))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (difficultyLevel != other.difficultyLevel)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (opener == null) {
			if (other.opener != null)
				return false;
		} else if (!opener.equals(other.opener))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", opener=" + opener + ", name=" + name + ", created=" + created
				+ ", status=" + status + ", priority=" + priority + ", difficultyLevel=" + difficultyLevel
				+ ", comments=" + comments + ", assignedDeveloper=" + assignedDeveloper + "]";
	}


}
