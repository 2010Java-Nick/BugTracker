package BugTracker.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This defines the different powers a employee may have. The roles are 'basic', 'developer', and 'manager'.
 * A basic user can open a ticket. A developer can also resolve a ticket. A manager can moderate disputes.
 * @author Ksenia
 *
 */

@Entity
@Table(name = "bug-tracker-role")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "power")
	private int power;

	public UserRole() {
		super();
	}

	public UserRole(String roleName, int power) {
		super();
		this.roleName = roleName;
		this.power = power;
	}

	public UserRole(long roleId, String roleName, int power) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.power = power;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + power;
		result = prime * result + (int) (roleId ^ (roleId >>> 32));
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		UserRole other = (UserRole) obj;
		if (power != other.power)
			return false;
		if (roleId != other.roleId)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + ", power=" + power + "]";
	}
}
