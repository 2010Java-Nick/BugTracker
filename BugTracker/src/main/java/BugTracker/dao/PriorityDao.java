package BugTracker.dao;

import BugTracker.pojos.Priority;

/**
 * Priority CRUD methods for Dao. 
 * @author Acacia and Hannah
 *
 */

public interface PriorityDao {
	
public Priority createPriority(Priority priority);
	
	public Priority readPriorityById(long priorityId);
		
	public Priority updatePriority(long priorityId, Priority priority);
	
	public void deletePriority(Priority priority);


}
