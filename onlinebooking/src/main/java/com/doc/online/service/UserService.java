package com.doc.online.service;

import com.doc.online.entity.Users;

public interface UserService {
	
	public boolean checkUserAlreadyExist(String emailId);
	
	public boolean loginWithEmail(String emailId, String password);
	
	public boolean loginWithPhoneNo(String phoneNo, String password);
	
	public boolean validateOTP(String otp, Users users);
}
