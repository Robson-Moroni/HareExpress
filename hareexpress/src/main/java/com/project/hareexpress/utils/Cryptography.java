package com.project.hareexpress.utils;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;

public class Cryptography {

	public static void main(String[] args) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String passwordCrypt = encoder.encode("admin");

		System.out.println(String.join("-",passwordCrypt.toString(), "abacaxi"));

		boolean decode =  encoder.matches("admin", "$2a$10$fAC4KQitDaN1hBx90A1kxOR/qnKMSh1zdwEto1Bi.0dbzWYhem6Du");

		byte[] passwordByte = passwordCrypt.getBytes(StandardCharsets.UTF_8);

		String passwordDecode = BCrypt.hashpw(passwordByte, passwordCrypt).toString();

		System.out.println(passwordDecode);
		System.out.println(decode);
		System.out.println(encoder);


	}

	public static boolean matcherPassword(String password, String encodePassword){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(password, encodePassword);
	}




}
