package com.project.hareexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
@EnableSpringDataWebSupport
public class HareexpressApplication {

	public static void main(String[] args) {
		SpringApplication.run(HareexpressApplication.class, args);
	}

}
