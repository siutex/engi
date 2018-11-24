package com.engi.webgabinet.services;

import com.engi.webgabinet.domain.User;
import com.engi.webgabinet.exceptions.UnmatchingUserCredentialsException;
import com.engi.webgabinet.exceptions.UserNotFoundException;

public interface UserService {
	
	User save(User user);
	
	void update(User user);
	
	User doesUserExist(String email) throws UserNotFoundException;
	
	User getByEmail(String email) throws UserNotFoundException;
	
	User isValidUser(String email, String password) throws UnmatchingUserCredentialsException;
}
