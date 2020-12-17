package BugTracker.services;

import BugTracker.dtos.CredentialsDTO;
import BugTracker.dtos.CurrentUserDTO;
import BugTracker.utils.AuthException;

public interface AuthService {
	
	CurrentUserDTO authenticate(CredentialsDTO credentials) throws AuthException;

}
