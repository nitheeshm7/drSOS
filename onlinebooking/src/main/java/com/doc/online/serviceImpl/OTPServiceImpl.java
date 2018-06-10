package com.doc.online.serviceImpl;

import java.util.Random;

import org.springframework.cglib.core.internal.LoadingCache;

import com.doc.online.service.OtpService;

public class OTPServiceImpl implements OtpService {
	private static final Integer EXPIRE_MINS = 5;
	String otp;
	public String generateOTP(int length, String phoneNo)
    {
		String numbers = "0123456789";
        Random randomObject = new Random();      
        char[] generateOtp = new char[length];
        for (int i = 0; i < length; i++)
        {
        	generateOtp[i] = numbers.charAt(randomObject.nextInt(numbers.length()));
        }
        otp = String.valueOf(generateOtp);
        persistOtp(otp,phoneNo);
        return otp;
        }
	
	public void persistOtp(String otp, String phoneNo)
	{
		// store the otp against the ph no in db
	}
	
	public String getOtp(){ 
		//some caching has to be done with expiry time
		return otp;
		 }
	
}