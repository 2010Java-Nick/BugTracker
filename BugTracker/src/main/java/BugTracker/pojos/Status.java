package BugTracker.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *The level of progress on a ticket
 * The statuses are  opened, resolved-fixed, resolved-won't fix, resolved-postponed, 
 * resolved-not reproduceable, resolved-duplicate,* or resolved-by design, or closed
 * @author Acacia
 *
 */

@Entity
@Table(name = "bug_tracker_status")
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
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
