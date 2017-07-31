package com.itmuch.cloud.contrllor;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.service.IRedisService;

@RestController
public class RedisController {
	@Autowired
	private IRedisService iRedisService;
	
	@RequestMapping("/set")
	public boolean redisSet(String key,String value) {
		
		return iRedisService.set(key, value);
	}
	@RequestMapping("/get")
	public String redisget(String key) {
		return iRedisService.get(key);
	}
	

}
