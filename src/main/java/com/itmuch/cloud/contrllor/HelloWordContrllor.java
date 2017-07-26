package com.itmuch.cloud.contrllor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordContrllor {
	@RequestMapping("/hello2")
	public String hello() {
		System.err.println("hello word222..........");
		return "Hello word2223332... run as application.";
	}
	@RequestMapping("/hello3")
	public String hello3() {
		System.err.println("hello word3..........");
		return "Hello word3... run as application.";
	}


}
