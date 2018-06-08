package com.doc.online.utilties;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingService {

	public String encryptString(String input) {
		String encryptedString = null;

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(input.getBytes());

			byte byteData[] = messageDigest.digest();

			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				buffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			encryptedString = buffer.toString();
			System.out.println("Encrypted Data is : " + buffer.toString());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return encryptedString;
	}

}
