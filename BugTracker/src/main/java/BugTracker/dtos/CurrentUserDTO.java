package BugTracker.dtos;

import BugTracker.pojos.Employee;

public class CurrentUserDTO {
	
	private long id;
	private String email;
	private String role;
	
	public CurrentUserDTO() {
		super();
	}
	
	public CurrentUserDTO(Employee e) {
		super();
		this.id = e.getEmployeeId();
		this.email = e.getEmailAddress();
		this.role = e.getUserRole().getRoleName();
	}
	
	public CurrentUserDTO(String email) {
		super();
		this.email = email;
	}

	public CurrentUserDTO(long id, String email, String role) {
		super();
		this.id = id;
		this.email = email;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		CurrentUserDTO other = (CurrentUserDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CurrentUserDTO [id=" + id + ", email=" + email + ", role=" + role + "]";
	}
}
