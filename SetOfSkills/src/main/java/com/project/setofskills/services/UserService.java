package com.project.setofskills.services;

import java.util.List;

import com.project.setofskills.entities.User;

public interface UserService {


	User findByUserName(String username);

	List<User> index();

	User show(Integer id);

	User create(User user);

	User updateUserById(Integer id, User user);

	Boolean deleteUserById(Integer id);

	User findById(Integer id);

}
