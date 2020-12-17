package BugTracker.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import BugTracker.dtos.CredentialsDTO;
import BugTracker.dtos.CurrentUserDTO;
import BugTracker.services.AuthService;
import BugTracker.utils.AuthException;

@Controller
@RequestMapping("/auth")
public class AuthController {

	private AuthService authService;

	@Autowired
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> authenticateUser(@RequestBody CredentialsDTO credentials, HttpServletRequest request)
			throws JsonProcessingException {

		CurrentUserDTO currentUser = null;

		try {
			currentUser = authService.authenticate(credentials);
			HttpSession userSession = request.getSession();
			userSession.setAttribute("currentUser", currentUser);
		} catch (AuthException e) {
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<CurrentUserDTO>(currentUser, HttpStatus.OK);
	}

}
