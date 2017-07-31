package com.itmuch.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
@Service("RedisService")
public class RedisServiceImpl implements IRedisService {
	@Autowired
	private RedisTemplate<String, ?>redistemplate;

	@Override
	public boolean set(final String key,final String value) {
		boolean result=redistemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> serializer = redistemplate.getStringSerializer();
				connection.set(serializer.serialize(key), serializer.serialize(value));
				
				return true;
				
			}
		});
		return result;
	}

	@Override
	public String get(final String key) {
		// TODO Auto-generated method stub
		String result=redistemplate.execute(new RedisCallback<String>() {

			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO Auto-generated method stub
				RedisSerializer<String> serializer = redistemplate.getStringSerializer();
				byte[] value = connection.get(serializer.serialize(key));
				return serializer.deserialize(value);
			}
		});
		
		return result;
	}

		

}
