package com.itmuch.cloud.contrllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itmuch.cloud.service.MailService;

@Controller//与页面交互只能用@Controller
public class MailController {
	@Autowired
	private MailService mailService;
	private String to="13103843391@163.com ";

	@RequestMapping("/mail")
	public String mail() {
		return "/mail";
	}
	@RequestMapping("/send")
	@ResponseBody
	public String sendmail(String title) {
		System.err.println(".............title:"+title);
		mailService.sendSimple(to, title, title);
		System.err.println(".............title2:"+title);
		return "success";
	}

}
