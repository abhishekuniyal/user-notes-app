package com.gotprn.dao;

import java.util.List;

import com.gotprn.models.User;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:17:04 AM
*/

public interface UserDao {
	public List<User> getAllUsers();
	public void saveUser(User user);
}
