package com.doc.online.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doc.online.beans.LoginBean;
import com.doc.online.service.OtpService;
import com.doc.online.service.SmsService;
import com.drsos.components.Messages;

public class OtpController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    Messages messages;
	@Autowired
	public OtpService otpService;
	@Autowired
	public SmsService smsService;
	
	@GetMapping("/generateOtp")
	public void generateOtp(@RequestBody LoginBean login){
		int otpLength = 4;
		String otp = otpService.generateOTP(otpLength, login.getPhoneNo());
		//Generate The Template to send OTP 
		Map<String,String> replacements = new HashMap<String,String>();
		replacements.put("otpnum", otp);
		String messageTemplate = messages.get("OTP.sms.text");
		//Replace the String 
		for (Map.Entry<String, String> entry : replacements.entrySet()) {
			messageTemplate = messageTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue());
		}
		smsService.sendSms(messageTemplate);
	}
	
	@RequestMapping(value ="/validateOtp", method = RequestMethod.GET)
	public @ResponseBody String validateOtp(@RequestParam("otpnum") String otpnum){
		final String SUCCESS = "Entered Otp is valid";
		final String FAIL = "Entered Otp is NOT valid. Please Retry!";
			String serverOtp = otpService.getOtp();
				if(otpnum == serverOtp){											
					return SUCCESS;
				}			
		else {
			return FAIL;
		}
	}

}
