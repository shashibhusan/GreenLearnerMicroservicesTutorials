package com.patel.userManagement.userService;

import java.util.List;

import com.patel.userManagement.model.User;

 
public interface UserService {

	List<User> getAllUsers();

	User getUserById(String id);

	void addUser(User user);

	User updateUser(User user);

	User deleteUserById(String id);

	 

}
