package BugTracker.dao;

import BugTracker.pojos.UserRole;

public interface UserRoleDao {
	
	public UserRole createUserRole(UserRole userRole);
	
	public UserRole readUserRole(long userRoleId);
	
	public void deleteUserRole(UserRole userRole);

}
