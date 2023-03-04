package com.loricode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loricode.model.User;
import com.loricode.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("list")
	public ResponseEntity<List<User>> getListUsers(){
		
		return ResponseEntity.ok(userService.getListUser());
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addUsers(@RequestBody User user){
		
		return ResponseEntity.ok("add email: "+ user.getEmail());
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable String id){
		
		return ResponseEntity.ok("update: "+ id );
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Integer> deleteUser(){
		
		return ResponseEntity.ok(4004);
	}
}
