package com.patel.userManagement.userRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.patel.userManagement.model.User;

@Repository
public class UserRepository {
	
	List<User> list=new ArrayList<>();
	public List<User> getAllUserList() {
		return list;
	}
	
	public User getUserById(String id) {
		
		Optional<User> first=list.stream().filter(u ->u.getId().equals(id)).findFirst();
		
		if(first.isPresent())
		{
			return first.get();
		}else
		{
			return new User();
		}
	}

	public void addUser(User user) {
		list.add(user);
	}

	public User updateUser(User user) {
		 
		for(User ul : list)
		{
			if(ul.getId().equals(user.getId()))
			{
				ul.setAddress(user.getAddress());
				ul.setName( user.getName());
				return ul;
			}
		}
		
		return new User();
		 
	}

	public User deleteUserById(String id) {
Optional<User> first=list.stream().filter(u ->u.getId().equals(id)).findFirst();
		
		if(first.isPresent())
		{
			User user=first.get();
			list.remove(user);
			return user;
		}else
		{
			return new User();
		}
		 
	}

}
