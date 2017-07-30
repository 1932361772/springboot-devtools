package com.itmuch.cloud.contrllor;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.bean.User;

@RestController
public class JsonContrllor {
	@RequestMapping("/getuser")
	public User getUser() {
		User user = new User();
		user.setUserId("01");
		user.setUserName("zhangsanaa");
		user.setCreateDate(new Date());

		return user;
	}

}
