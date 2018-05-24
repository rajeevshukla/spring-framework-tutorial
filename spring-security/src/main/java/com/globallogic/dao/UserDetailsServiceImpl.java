package com.globallogic.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.globallogic.model.User;

@Service
public class UserDetailsServiceImpl  implements UserDetailsManager{
	
	@Autowired(required=true)
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		 User  user = null;
		// go to database user userdetails by username 
		 List<User> users = userRepository.findUserByUserName(username); 
		 
		  if(!users.isEmpty())
			  user=users.get(0);
		  System.out.println(user);
		return user;
		
		
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		System.out.println("User exists...");
		return false;
	}

}
