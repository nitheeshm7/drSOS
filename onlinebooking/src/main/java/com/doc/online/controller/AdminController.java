package com.doc.online.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.doc.online.entity.Admin;
import com.doc.online.entity.Doctors;
import com.doc.online.entity.Users;
import com.doc.online.repository.AdminRepository;
import com.doc.online.repository.DoctorRepository;
import com.doc.online.repository.UserRepository;

@RestController
public class AdminController {

	@Autowired
	AdminRepository adminRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	UserRepository userRepository;

	@PostMapping("/createAdmin")
	public ResponseEntity<Object> registerAdmin(@RequestBody Admin admin) {
		ResponseEntity<Object> responseEntity = ResponseEntity.notFound().build();
		Admin createdAdmin = adminRepository.save(admin);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{adminName}")
				.buildAndExpand(createdAdmin.getAdminName()).toUri();
		responseEntity = ResponseEntity.created(uri).build();
		return responseEntity;
	}

	@PostMapping("/loginAdmin")
	public ResponseEntity<Object> loginAdmin(@RequestBody Admin admin) {
		ResponseEntity<Object> responseEntity = ResponseEntity.notFound().build();
		Admin loginAdmin = adminRepository.getAdmin(admin.getAdminId());
		if (loginAdmin != null && admin.getAdminPassword().equals(loginAdmin.getAdminPassword())) {
			responseEntity = ResponseEntity.ok().build();
		}
		return responseEntity;
	}
	
	@PostMapping("/activateDoctor")
	public ResponseEntity<Object> activateDoctor(@RequestBody Doctors doctor) {
		ResponseEntity<Object> responseEntity = ResponseEntity.notFound().build();
		int status = doctorRepository.setDoctorStatus(true, doctor.getDoctorId());
		responseEntity = ResponseEntity.ok().build();
		return responseEntity;
	}
	
	@PostMapping("/deActivateDoctor")
	public ResponseEntity<Object> deActivateDoctor(@RequestBody Doctors doctor) {
		ResponseEntity<Object> responseEntity = ResponseEntity.notFound().build();
		int status = doctorRepository.setDoctorStatus(false, doctor.getDoctorId());
		responseEntity = ResponseEntity.ok().build();
		return responseEntity;
	}
	
	@PostMapping("/activateUser")
	public ResponseEntity<Object> activateUser(@RequestBody Users user) {
		ResponseEntity<Object> responseEntity = ResponseEntity.notFound().build();
		int status = userRepository.setUserStatus(true, user.getUserId());
		responseEntity = ResponseEntity.ok().build();
		return responseEntity;
	}
	
	@PostMapping("/deActivateUser")
	public ResponseEntity<Object> deActivateUser(@RequestBody Users user) {
		ResponseEntity<Object> responseEntity = ResponseEntity.notFound().build();
		int status = userRepository.setUserStatus(false, user.getUserId());
		responseEntity = ResponseEntity.ok().build();
		return responseEntity;
	}

}
