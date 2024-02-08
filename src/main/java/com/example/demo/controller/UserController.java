package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/addusers")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/fetchuser")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		boolean deleted = userService.deleteUser(id);
		if (deleted) {
			return new ResponseEntity<>("User with ID " + id + " deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User with ID " + id + " not found", HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User newUserDetails) {
		boolean updated = userService.updateUser(id, newUserDetails);
		if (updated) {
			return new ResponseEntity<>("User with ID " + id + " updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User with ID " + id + " not found", HttpStatus.NOT_FOUND);
		}
	}

}
