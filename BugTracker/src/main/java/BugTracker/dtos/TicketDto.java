package BugTracker.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import BugTracker.pojos.Employee;
import BugTracker.pojos.Post;
import BugTracker.pojos.Priority;
import BugTracker.pojos.Status;


public class TicketDto {
	/**
	 * Data transfer object to read in Tickets from front-end.
	 * @author Acacia and Hannah
	 */
	private long ticketId;
	private long openerId;
	private long assignedDeveloperId;
	private String name;
	private LocalDateTime created;
	private long statusId;
	private long priorityId;
	private int difficultyLevel;
	private List<Integer> commentIds = new ArrayList<>();
	
	
	public TicketDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TicketDto(long ticketId, long openerId, long assignedDeveloperId, String name, LocalDateTime created,
			long statusId, long priorityId, int difficultyLevel, List<Integer> commentIds) {
		super();
		this.ticketId = ticketId;
		this.openerId = openerId;
		this.assignedDeveloperId = assignedDeveloperId;
		this.name = name;
		this.created = created;
		this.statusId = statusId;
		this.priorityId = priorityId;
		this.difficultyLevel = difficultyLevel;
		this.commentIds = commentIds;
	}

	


	public TicketDto(long openerId, long assignedDeveloperId, String name, LocalDateTime created, long statusId,
			long priorityId, int difficultyLevel, List<Integer> commentIds) {
		super();
		this.openerId = openerId;
		this.assignedDeveloperId = assignedDeveloperId;
		this.name = name;
		this.created = created;
		this.statusId = statusId;
		this.priorityId = priorityId;
		this.difficultyLevel = difficultyLevel;
		this.commentIds = commentIds;
	}


	public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public long getOpenerId() {
		return openerId;
	}
	public void setOpenerId(long openerId) {
		this.openerId = openerId;
	}
	public long getAssignedDeveloperId() {
		return assignedDeveloperId;
	}
	public void setAssignedDeveloperId(long assignedDeveloperId) {
		this.assignedDeveloperId = assignedDeveloperId;
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
	public long getStatusId() {
		return statusId;
	}
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}
	public long getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(long priorityId) {
		this.priorityId = priorityId;
	}
	public int getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public List<Integer> getCommentIds() {
		return commentIds;
	}
	public void setCommentIds(List<Integer> commentIds) {
		this.commentIds = commentIds;
	}


	@Override
	public String toString() {
		return "TicketDto [ticketId=" + ticketId + ", openerId=" + openerId + ", assignedDeveloperId="
				+ assignedDeveloperId + ", name=" + name + ", created=" + created + ", statusId=" + statusId
				+ ", priorityId=" + priorityId + ", difficultyLevel=" + difficultyLevel + ", commentIds=" + commentIds
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (assignedDeveloperId ^ (assignedDeveloperId >>> 32));
		result = prime * result + ((commentIds == null) ? 0 : commentIds.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + difficultyLevel;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (openerId ^ (openerId >>> 32));
		result = prime * result + (int) (priorityId ^ (priorityId >>> 32));
		result = prime * result + (int) (statusId ^ (statusId >>> 32));
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
		TicketDto other = (TicketDto) obj;
		if (assignedDeveloperId != other.assignedDeveloperId)
			return false;
		if (commentIds == null) {
			if (other.commentIds != null)
				return false;
		} else if (!commentIds.equals(other.commentIds))
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
		if (openerId != other.openerId)
			return false;
		if (priorityId != other.priorityId)
			return false;
		if (statusId != other.statusId)
			return false;
		if (ticketId != other.ticketId)
			return false;
		return true;
	}
	
	
	
	
}
