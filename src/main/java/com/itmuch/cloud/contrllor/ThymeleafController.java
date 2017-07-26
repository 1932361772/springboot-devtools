package com.itmuch.cloud.contrllor;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
	@RequestMapping("/index")
	public String indexHtml(Map<String, Object> map) {
		map.put("hello", "welcome");
		
		return "/NewFile";
	}
	

}
