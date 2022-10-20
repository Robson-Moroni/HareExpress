package com.project.hareexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class HareexpressApplication {

	public static void main(String[] args) {
		SpringApplication.run(HareexpressApplication.class, args);
	}

}
