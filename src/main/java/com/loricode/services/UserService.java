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
	
}
