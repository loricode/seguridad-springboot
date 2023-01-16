package com.loricode.controllers;

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

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

	
	@GetMapping("list")
	public ResponseEntity<String[]> getListUsers(){
		
		String[] nombres = { "nombre a", "nombre b"};
		
		return ResponseEntity.ok(nombres);
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
