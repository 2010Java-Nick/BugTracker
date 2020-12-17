package BugTracker.dao;

import BugTracker.pojos.Employee;
import BugTracker.pojos.Status;

public interface StatusDao {
	
public Status createStatus(Status status);
	
	public Status readStatusById(long statusId);
		
	public Status updateStatus(long StatusId, Status status);
	
	public void deleteStatus(Status status);


}
