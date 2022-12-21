package com.patel.Spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.patel.Spring.model.User;
import com.patel.Spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	Logger logger=LoggerFactory.getLogger("Spring-data-demo");
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers() {
		List<User> userList=(List<User>)userRepository.findAll();
		logger.info("User list from database {} ",userList);
		return userList;
	}

	@Override
	public User findUserById(Long id) {
		User user=userRepository.findById(id).get();
		//logger.info("User from database {} ",user);
		return user;
	}

	@Override
	public void addUser(User user) {
		 userRepository.save(user);
		 logger.info("User Added {} ",user);
	}

	@Override
	public void deleteUserById(Long id) {
		 
		userRepository.deleteById(id);
		logger.info("User with {} deleted from database ",id);
	}

	@Override
	public List<User> getAllUserByLastName(String firstName) {
		return userRepository.getAllUserByLastName(firstName);
	}

	@Override
	public List<User> getAllUserByGender(String gender1) {
		return userRepository.getUsersByGender(gender1);
	}

	@Override
	public String updateAddressById(Long id, String newAddress) {
		userRepository.updateAddress(id, newAddress);
		return "Address updated successfully";
	}

	@Override
	public List<User> findSortedUsers(String sortingParam) {
		return (List<User>) userRepository.findAll(Sort.by(sortingParam));
	}
	 

	@Override
	public User updateUser(User user) {
		
		Optional<User> employee = userRepository.findById(user.getId());
        
        if(employee.isPresent()) 
        {
        	User newEntity = employee.get();
            newEntity.setFirstName(user.getFirstName());
            newEntity.setLastName(user.getLastName());
            newEntity.setGender(user.getGender());
            newEntity.setAddress(user.getAddress());
            
            newEntity = userRepository.save(newEntity);
             
            return newEntity;
        } else {
        	user = userRepository.save(user);
            return user;
        }
	}

	@Override
	public List<User> getAllUserByGenderAndSort(String gender, String sortingParam) {
		
		return userRepository.getUsersByGenderAndSort(gender,Sort.by(sortingParam));
	}

	@Override
	public Page<User> findAllUserByPageWise(int pageNumber, int numberOfElement) {
		 
		return userRepository.findAll(PageRequest.of(pageNumber, numberOfElement));
	}
	 
}
