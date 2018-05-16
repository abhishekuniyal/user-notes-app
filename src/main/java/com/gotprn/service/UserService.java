package com.gotprn.service;

import java.util.List;

import com.gotprn.models.User;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:13:58 AM
*/

public interface UserService {
	public List<User> getAllUsers();
	public void saveUser(User user);
}
