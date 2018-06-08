package com.doc.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doc.online.beans.LoginBean;
import com.doc.online.service.UserService;

@RestController
public class LoginController {
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginBean login) {
		ResponseEntity<Object> responseEntity = ResponseEntity.notFound().build();
		if (login.getEmailId() != null) {
			if (userService.loginWithEmail(login.getEmailId(), login.getPassword())) {
				responseEntity = ResponseEntity.ok().build();
				System.out.println("Logged in ");
			} else {
				responseEntity = ResponseEntity.notFound().build();
			}
		} else if (login.getPhoneNo() != null) {
			if (userService.loginWithPhoneNo(login.getPhoneNo(), login.getPassword())) {
				responseEntity = ResponseEntity.ok().build();
				System.out.println("Logged in ");
			} else {
				responseEntity = ResponseEntity.notFound().build();
			}
		}
		return responseEntity;
	}

}
