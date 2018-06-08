package com.doc.online.beans;

import com.doc.online.utilties.MD5HashingService;

public class LoginBean {

	MD5HashingService md5HashingService = new MD5HashingService();

	private String emailId;
	private String phoneNo;
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = md5HashingService.encryptString(password);
	}

	@Override
	public String toString() {
		return "LoginBean [emailId=" + emailId + ", phoneNo=" + phoneNo + ", password=" + password + "]";
	}

}
