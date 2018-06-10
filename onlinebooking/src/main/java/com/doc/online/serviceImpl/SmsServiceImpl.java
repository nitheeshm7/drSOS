package com.doc.online.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;

import com.doc.online.service.SmsService;
import com.drsos.components.Messages;

public class SmsServiceImpl implements SmsService {
	@Autowired
    Messages messages;
	
	public void sendSms(String message)
	{
		try 
		{
			//msg 91 api integration
			String authkey = "219554AqHOYxPKOjhi5b1a6014";
			String mobiles = "919746419888";
			//Sender ID,While using route4 sender id should be 6 characters long.
			//String senderId = "102234";
			String senderId = "MSGIND";
			String otpMessage = message;
			String route="default";

			//Prepare Url
			URLConnection myURLConnection=null;
			URL myURL=null;
			BufferedReader reader=null;
			String encoded_message;	
			encoded_message = URLEncoder.encode(otpMessage, "UTF-8");	        
			String mainUrl=messages.get("OTP.sms.url");       
			StringBuilder sbPostData= new StringBuilder(mainUrl);
			sbPostData.append("authkey="+authkey);
			sbPostData.append("&mobiles="+mobiles);
			sbPostData.append("&message="+encoded_message);
			sbPostData.append("&route="+route);
			sbPostData.append("&sender="+senderId);

			mainUrl = sbPostData.toString();     
			myURL = new URL(mainUrl);
			myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));           
			String response;
			while ((response = reader.readLine()) != null)
				System.out.println(response);

			reader.close();
		}
		catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	}


