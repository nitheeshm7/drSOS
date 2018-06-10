package com.doc.online.service;

public interface OtpService {
	public String generateOTP(int length, String phoneNo);
	public String getOtp();
}
