package com.engi.webgabinet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.engi.webgabinet.domain.User;
import com.engi.webgabinet.exceptions.UnmatchingUserCredentialsException;
import com.engi.webgabinet.exceptions.UserNotFoundException;
import com.engi.webgabinet.repositories.UserDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
	
	@Override
	public User save(User user) {
		return userDAO.save(user);
	}
	
	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public User doesUserExist(String email) throws UserNotFoundException {
		List<User> users = userDAO.findByEmail(email);
		if(users.size() == 0) {
			throw new UserNotFoundException("brak usera w bazie");
		} 
		return users.get(0);
	}

	@Override
	public User isValidUser(String email, String password) throws UnmatchingUserCredentialsException {
		List<User> users =  userDAO.findByEmailAndPassword(email, password);
		if(users == null || users.size() == 0) {
			throw new UnmatchingUserCredentialsException("User o tych danych nie istnieje");
		} 
		return users.get(0);
	}

	@Override
	public User getByEmail(String email) throws UserNotFoundException {
		return this.doesUserExist(email);
	}

}
