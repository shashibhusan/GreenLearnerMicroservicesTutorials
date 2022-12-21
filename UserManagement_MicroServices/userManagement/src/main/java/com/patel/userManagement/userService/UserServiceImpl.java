package com.patel.userManagement.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patel.userManagement.model.User;
import com.patel.userManagement.userRepository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUserList();
	}

	@Override
	public User getUserById(String id) {
		return userRepository.getUserById(id);
	}

	@Override
	public void addUser(User user) {
		userRepository.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.updateUser(user);
	}

	@Override
	public User deleteUserById(String id) {
		return userRepository.deleteUserById(id);
	}

}
