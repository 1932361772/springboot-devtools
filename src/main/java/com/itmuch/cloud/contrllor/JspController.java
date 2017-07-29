package com.itmuch.cloud.contrllor;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController//用模板是用Controller//不用模板时用restController
@Controller
public class JspController {
	@RequestMapping("indexjsp")//成功:可以和thymeleaf联合使用.但thymeleaf失败.一个项目可以拥有多种模板.
	public String helloo(Map<String,Object> map) {
		map.put("hello", "there is Jsp..........");
		return "index";
	}

}
