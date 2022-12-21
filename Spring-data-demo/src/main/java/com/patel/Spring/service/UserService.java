package com.patel.Spring.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.patel.Spring.model.User;

 
public interface UserService {

	List<User> findAllUsers();

	User findUserById(Long id);

	void addUser(User user);

	void deleteUserById(Long id);
	
	List<User> getAllUserByLastName(String firstName);

	List<User> getAllUserByGender(String gender1);

	String updateAddressById(Long id,String newAddress);
	
	List<User>findSortedUsers(String paramForSorting);
	
	List<User> getAllUserByGenderAndSort(String gender,String sortingParam);
	
	Page<User>findAllUserByPageWise(int pageNumber,int numberOfElement);
	
	User updateUser(User user);
	
}
