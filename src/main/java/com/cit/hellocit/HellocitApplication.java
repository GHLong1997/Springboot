package com.cit.hellocit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HellocitApplication {

	public static void main(String[] args) {

//
//		SpringApplication application = new SpringApplication(HellocitApplication.class);
//		Map<String, Object> map = new HashMap<>();
//		map.put("SERVER_PORT", "8011");
//		application.setDefaultProperties(map);
//		application.run(args);
		SpringApplication.run(HellocitApplication.class, args);
	}
}
