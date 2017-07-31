package com.itmuch.cloud.contrllor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
	@RequestMapping("/thymeleafDemo")
	public String indexHtml(Map<String, Object> map) {
		map.put("hello", "welcome");

		return "/thymeleafDemo";
	}

	@RequestMapping("/thymeleaf")
	public String home(ModelMap modelMap) {

		modelMap.put("name", "Magical Sam");

		List<String> list = new ArrayList<>();
		list.add("sam a");
		list.add("sam b");
		list.add("sam c");
		list.add("sam d");
		modelMap.put("list", list);

		return "thymeleaf";
	}
	
	

}
