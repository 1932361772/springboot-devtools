package com.itmuch.cloud.service;

public interface IRedisService {
	
	public boolean set(String key, String value);

	public String get(String key);

}
