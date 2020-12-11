package BugTracker.pojos;




public class Status {
	
	private long statusId;
	private String statusName;
	
	
	public Status() {
		super();
	}


	
	public Status(String statusName) {
		super();
		this.statusName = statusName;
	}



	public Status(long statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}



	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusName=" + statusName + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (statusId ^ (statusId >>> 32));
		result = prime * result + ((statusName == null) ? 0 : statusName.hashCode());
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
		Status other = (Status) obj;
		if (statusId != other.statusId)
			return false;
		if (statusName == null) {
			if (other.statusName != null)
				return false;
		} else if (!statusName.equals(other.statusName))
			return false;
		return true;
	}

}

