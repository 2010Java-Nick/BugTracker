package BugTracker.pojos;

public class Priority {
	
	
	private long priorityId;
	private String priorityName;
	
	public Priority() {
		super();
	}
	
	public Priority(String priorityName) {
		super();
		this.priorityName = priorityName;
	}

	public Priority(long priorityId, String priorityName) {
		super();
		this.priorityId = priorityId;
		this.priorityName = priorityName;
	}
	

	/**
	 * @return the priorityId
	 */
	public long getPriorityId() {
		return priorityId;
	}
	/**
	 * @param priorityId the priorityId to set
	 */
	public void setPriorityId(long priorityId) {
		this.priorityId = priorityId;
	}
	/**
	 * @return the priorityName
	 */
	public String getPriorityName() {
		return priorityName;
	}
	/**
	 * @param priorityName the priorityName to set
	 */
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (priorityId ^ (priorityId >>> 32));
		result = prime * result + ((priorityName == null) ? 0 : priorityName.hashCode());
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
		Priority other = (Priority) obj;
		if (priorityId != other.priorityId)
			return false;
		if (priorityName == null) {
			if (other.priorityName != null)
				return false;
		} else if (!priorityName.equals(other.priorityName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Priority [priorityId=" + priorityId + ", priorityName=" + priorityName + "]";
	}
	
	
	

}
