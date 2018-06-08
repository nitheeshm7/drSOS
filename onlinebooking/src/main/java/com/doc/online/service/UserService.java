package com.doc.online.service;

public interface UserService {
	
	public boolean checkUserAlreadyExist(String emailId);
	
	public boolean loginWithEmail(String emailId, String password);
	
	public boolean loginWithPhoneNo(String phoneNo, String password);

}
