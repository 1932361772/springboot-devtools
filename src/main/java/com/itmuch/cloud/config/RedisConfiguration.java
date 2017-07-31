package com.itmuch.cloud.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;
//和redis沟通的配置项.
@Configuration
@EnableAutoConfiguration
public class RedisConfiguration {
	@Bean
	@ConfigurationProperties(prefix="spring.redis")//配置其在*.yml中的配置的前缀.
	public JedisPoolConfig getRedisConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		System.err.println("-----------------redis getRedisConfig()............");
		return config;
	}
	@Bean
	@ConfigurationProperties(prefix="spring.redis")//配置其在*.yml中的配置的前缀.
	public JedisConnectionFactory getConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		JedisPoolConfig config = new JedisPoolConfig();
		factory.setPoolConfig(config);
		System.err.println("-----------------redis getConnectionFactory()............");
		return factory;
	}
	@Bean
	public RedisTemplate<?,?> geRestTemplate() {
		RedisTemplate<?, ?> template=new StringRedisTemplate(getConnectionFactory());
		System.err.println("-----------------redis geRestTemplate()...........");
		return template;
		
	}
	

}
