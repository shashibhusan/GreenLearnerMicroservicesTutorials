package com.patel.userManagement.contoller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.patel.userManagement.model.User;
import com.patel.userManagement.userService.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Logger log=LoggerFactory.getLogger("UserManagementLogs");
	
	@GetMapping("/users")
	public List<User>getAllUsers()
	{
		log.info("This is the method for getting the all users");
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable String id)
	{
		return userService.getUserById(id);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User>addUser(@RequestBody User user )
	{
		userService.addUser(user);
		
		URI path=ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(path).build();
	}
	@PutMapping("/user")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user);
		
	}
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable String id)
	{
		return userService.deleteUserById(id);
	}
}
