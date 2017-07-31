package com.itmuch.cloud.contrllor;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {
	@RequestMapping("/freemarker")//成功:可以和thymeleaf联合使用.但thymeleaf失败.一个项目可以拥有多种模板.
	public String helloo(Map<String,Object> map) {
		map.put("hello", "there is freemarker");
		return "/freemarkerindex";
	}

}
