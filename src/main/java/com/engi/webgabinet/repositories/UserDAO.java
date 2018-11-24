package com.engi.webgabinet.repositories;

import java.util.List;

import com.engi.webgabinet.domain.User;

public interface UserDAO  {
	
	User save(User user);
	
	List<User> findByEmail(String email);
	
	List<User> findByEmailAndPassword(String email, String password);
	
	void update(User user);
	
}
