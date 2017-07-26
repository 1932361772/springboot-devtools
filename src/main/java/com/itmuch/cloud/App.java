package com.itmuch.cloud;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App
{
	/*public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastconfig = new FastJsonConfig();
		fastconfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastconfig);

		converters.add(fastConverter);

	}*/

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
	}
//用@Bean是不需要继承WebMvcConfigurationSupport
	 @Bean
	 public HttpMessageConverters fastJsonConverters() {
	 FastJsonHttpMessageConverter fastConverter = new
	 FastJsonHttpMessageConverter();
	 FastJsonConfig fastconfig = new FastJsonConfig();
	 fastconfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	 fastConverter.setFastJsonConfig(fastconfig);
	 HttpMessageConverter<?> converter = fastConverter;
	 return new HttpMessageConverters(converter);
	
	 }

}
/*
@SpringBootApplication
public class App extends WebMvcConfigurationSupport
{
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastconfig = new FastJsonConfig();
		fastconfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastconfig);

		converters.add(fastConverter);

	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
	}
//用@Bean是不需要继承WebMvcConfigurationSupport
	// @Bean
	// public HttpMessageConverters fastJsonConverters() {
	// FastJsonHttpMessageConverter fastConverter = new
	// FastJsonHttpMessageConverter();
	// FastJsonConfig fastconfig = new FastJsonConfig();
	// fastconfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	// fastConverter.setFastJsonConfig(fastconfig);
	// HttpMessageConverter<?> converter = fastConverter;
	// return new HttpMessageConverters(converter);
	//
	// }

}
*/