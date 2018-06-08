package com.doc.online.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.doc.online.entity.Users;
import com.doc.online.repository.UserRepository;
import com.doc.online.service.UserService;

@RestController
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	UserService userService;

	@PostMapping("/create")
	public ResponseEntity<Object> createUser(@RequestBody Users user) {
		System.out.println("Nitheesh  " + user.toString());
		if (userService.checkUserAlreadyExist(user.getEmailId())) {
			return ResponseEntity.unprocessableEntity().build();
		} else {
			Users createdUser = userRepository.save(user);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userName}")
					.buildAndExpand(createdUser.getUserName()).toUri();
			return ResponseEntity.created(uri).build();
		}

	}

	@PostMapping("/updateProfile")
	public ResponseEntity<Object> updateUserProfile(@RequestBody Users user) {

		Users updatedUser = userRepository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userName}")
				.buildAndExpand(updatedUser.getUserName()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
