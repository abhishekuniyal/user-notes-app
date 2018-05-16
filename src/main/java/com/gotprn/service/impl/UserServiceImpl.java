package com.gotprn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotprn.dao.UserDao;
import com.gotprn.models.User;
import com.gotprn.service.UserService;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:18:33 AM
*/

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
}
