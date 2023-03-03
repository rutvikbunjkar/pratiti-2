package com.pratiti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//	@RequestMapping("/hello")
	@GetMapping("/hello")
	public String hello() {
		return "Welcome to Spring boot and rest api development " + " 857948759387985 "
				+ " fskdjhfkdjhfksdhfksdjh ?";
		
	}
}
