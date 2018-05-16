package com.gotprn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gotprn.models.User;
import com.gotprn.service.UserService;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:12:09 AM
*/

@RestController
@RequestMapping("/userService")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/user",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping(value="/user",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public String saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return "user saved";
	}
}
