package BugTracker.dtos;

import java.time.LocalDateTime;





public class TicketDto {
	/**
	 * Data transfer object to read in Tickets from front-end.
	 * @author Acacia and Hannah
	 */
	private long openerId;
	private String name;
	private LocalDateTime created;
	private long statusId;
	private long priorityId;
	private int difficultyLevel;
	private String body;
	
	//TODO in front end, add difficulty level and body
	public TicketDto() {
		super();
	}




	public TicketDto(long openerId, String name, LocalDateTime created, long statusId, long priorityId,
			int difficultyLevel, String body) {
		super();
		this.openerId = openerId;
		this.name = name;
		this.created = created;
		this.statusId = statusId;
		this.priorityId = priorityId;
		this.difficultyLevel = difficultyLevel;
		this.setBody(body);
	}




	public long getOpenerId() {
		return openerId;
	}
	public void setOpenerId(long openerId) {
		this.openerId = openerId;
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




	public String getBody() {
		return body;
	}




	public void setBody(String body) {
		this.body = body;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + difficultyLevel;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (openerId ^ (openerId >>> 32));
		result = prime * result + (int) (priorityId ^ (priorityId >>> 32));
		result = prime * result + (int) (statusId ^ (statusId >>> 32));
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
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
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
		return true;
	}




	@Override
	public String toString() {
		return "TicketDto [openerId=" + openerId + ", name=" + name + ", created=" + created + ", statusId=" + statusId
				+ ", priorityId=" + priorityId + ", difficultyLevel=" + difficultyLevel + ", body=" + body + "]";
	}


	
	
	
}
