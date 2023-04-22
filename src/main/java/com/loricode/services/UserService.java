package com.loricode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loricode.model.User;
import com.loricode.repositories.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository Iuser;


	public List<User> getListUser () {
		
		return Iuser.getListUsers();
		
	}
	
	public boolean addUser(String fullName, String email) {
		
		try {
			
			Iuser.addUser(fullName, email);
			
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	
    public boolean updateUser(String id, String fullName, String email) {
		
		try {
			
			Iuser.updateUser(id, fullName, email);
			
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}
	
	
}
