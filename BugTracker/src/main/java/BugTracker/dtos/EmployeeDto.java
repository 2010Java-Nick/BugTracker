package BugTracker.dtos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import BugTracker.pojos.UserRole;

/**
 * Data Transfer object to read in Employees from front end and push to front end. 
 * @author Acacia and Hannah
 *
 */

public class EmployeeDto {
	
	private long employeeId;

	private String firstName;
	
	private String lastName;

	private String emailAddress;

	private int expPoints;
	
	private long userRoleId;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(String firstName, String lastName, String emailAddress, int expPoints, long userRoleId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.expPoints = expPoints;
		this.userRoleId = userRoleId;
	}

	public EmployeeDto(long employeeId, String firstName, String lastName, String emailAddress, int expPoints,
			long userRoleId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.expPoints = expPoints;
		this.userRoleId = userRoleId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getExpPoints() {
		return expPoints;
	}

	public void setExpPoints(int expPoints) {
		this.expPoints = expPoints;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
		result = prime * result + expPoints;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (int) (userRoleId ^ (userRoleId >>> 32));
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
		EmployeeDto other = (EmployeeDto) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (expPoints != other.expPoints)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (userRoleId != other.userRoleId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + ", expPoints=" + expPoints + ", userRoleId=" + userRoleId + "]";
	}
	
	
	

}
