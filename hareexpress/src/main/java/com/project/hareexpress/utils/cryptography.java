package com.project.hareexpress.utils;


import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;

public class cryptography {

	public static void main(String[] args) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String passwordCrypt = encoder.encode("moroni");

		System.out.println(passwordCrypt);

		boolean decode =  encoder.matches("admin", "$2a$10$V/0dtJNXTZaFsCG7v6txdeivUrt45XSeKwf8L6auQ00k0oN5KMRbO");

		byte[] passwordByte = passwordCrypt.getBytes(StandardCharsets.UTF_8);

		String passwordDecode = BCrypt.hashpw(passwordByte, passwordCrypt).toString();

		System.out.println(passwordDecode);
		System.out.println(decode);
		System.out.println(encoder);


	}

}
