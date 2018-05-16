package com.gotprn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gotprn.models.User;

/**
Author Abhishek Uniyal
Created Date May 16, 2018
Created Time 11:21:38 AM
*/

public interface UserRepository extends JpaRepository<User, Long>{
	
}
