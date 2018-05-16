package com.gotprn.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gotprn.dao.UserDao;
import com.gotprn.models.User;
import com.gotprn.repository.UserRepository;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:19:35 AM
*/

@Repository
public class UserDaoImpl implements UserDao{
	
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

}
