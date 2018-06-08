package com.doc.online.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.online.entity.Users;
import com.doc.online.repository.UserRepository;
import com.doc.online.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public boolean checkUserAlreadyExist(String emailId) {
		boolean check = false;
		Users users = userRepository.findByEmailId(emailId);
		if (users != null) {
			check = true;
		}
		return check;
	}

	@Override
	public boolean loginWithEmail(String emailId, String password) {
		boolean check = false;
		Users users = userRepository.loginWithEmail(emailId);
		if (users != null && users.getPassword().equals(password)) {
			check = true;
		}
		return check;
	}

	@Override
	public boolean loginWithPhoneNo(String phoneNo, String password) {
		boolean check = false;
		Users users = userRepository.loginWithPhoneNo(phoneNo);
		if (users != null && users.getPassword().equals(password)) {
			check = true;
		}
		return check;
	}

}
