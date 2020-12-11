package BugTracker.pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the information for a bug which will be resolved by a developer.
 * @author Ksenia
 *
 */
public class Ticket {

	private long ticketId;
	private Employee opener;
	private String name;
	private LocalDateTime created;
	private Status status;
	private Priority priority;
	private int difficultyLevel;
	private List<Post> comments = new ArrayList<>();

	public Ticket() {
		super();
	}

	public Ticket(Employee opener, String name, LocalDateTime created, Status status, Priority priority,
			int difficultyLevel, List<Post> comments) {
		super();
		this.opener = opener;
		this.name = name;
		this.created = created;
		this.status = status;
		this.priority = priority;
		this.difficultyLevel = difficultyLevel;
		this.comments = comments;
	}

	public Ticket(long ticketId, Employee opener, String name, LocalDateTime created, Status status,
			Priority priority, int difficultyLevel, List<Post> comments) {
		super();
		this.ticketId = ticketId;
		this.opener = opener;
		this.name = name;
		this.created = created;
		this.status = status;
		this.priority = priority;
		this.difficultyLevel = difficultyLevel;
		this.comments = comments;
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

	public void setEmployee(Employee opener) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + difficultyLevel;
		result = prime * result + ((opener == null) ? 0 : opener.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (opener == null) {
			if (other.opener != null)
				return false;
		} else if (!opener.equals(other.opener))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "Ticket [ticketId=" + ticketId + ", employee=" + opener + ", name=" + name + ", created=" + created
				+ ", status=" + status + ", priority=" + priority + ", difficultyLevel=" + difficultyLevel
				+ ", comments=" + comments + "]";
	}
}
