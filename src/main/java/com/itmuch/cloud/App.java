package com.itmuch.cloud;

import java.util.EventListener;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.itmuch.cloud.common.IndexFilter;
import com.itmuch.cloud.common.IndexListener;
import com.itmuch.cloud.common.IndexServlet;

//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * Hello world!
 *
 */
//第三种app========================================================================================================

@SpringBootApplication
@MapperScan("com.itmuch.cloud.jdbcdao")//mybatis的mapper所在的包名.启动的时候加载.
//@ServletComponentScan//添加这个注解才会自动扫描自定义的listener,filter,servlet
public class App
{
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
	}
	@Bean//以bean的方式启用filter 引用的是com.itmuch.cloud.common;下的java类下面两个同样.
	public FilterRegistrationBean	indexFilter() {
		FilterRegistrationBean filter=new FilterRegistrationBean(new IndexFilter());
		filter.addUrlPatterns("/*");
		return filter;
	}
	@Bean
	public ServletRegistrationBean indexServlet() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new IndexServlet());
		servlet.addUrlMappings("/helloservlet");
		
		return servlet;
	}
	@Bean
	public ServletListenerRegistrationBean indexListener() {
		ServletListenerRegistrationBean listener=new ServletListenerRegistrationBean<>(new IndexListener());
	return listener;
	
	}
//	实现.do .Action的风格 失败,因为要用的Tomcat,而Tomcat启动失败.<!--添加thymeleaf的模板文件的依赖 联合tomcat-catalina成功 -->
//	@Bean//打开此处的@Bean其它的servlet会失败.
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcher) {
		ServletRegistrationBean servlet=new ServletRegistrationBean(dispatcher);
		servlet.addUrlMappings("*.do");
		servlet.addUrlMappings("*.json");
		servlet.addUrlMappings("/*");
		return servlet;		
		
	}
//	以@Bean的方式配置Tomcat 此处用的是Tomcat-calalina 依赖,没有Tomcat的下面的类,所有报错.
	
/*	@Bean
	public EnabledservletContainerFactory servleContainer() {
		EnabledservletContainerFactory factory=new EnabledservletContainerFactory();
		factory.setport(7777);
		return factory;
	}*/
//	以@Bean的方式配置Tomcat 此处用的是Tomcat-calalina 依赖,没有jetty的下面的类,所有报错.	
/*	@Bean
	public EnableServletContainerFactory servletContainer() {
		JettyEnableServletcontainerFactory factory=new JettyEnableServletcontainerFactory();
		factory.setport(7777);
		return factory;
	}*/
	
	
//用@Bean是不需要继承WebMvcConfigurationSupport
//	 @Bean
//	 public HttpMessageConverters fastJsonConverters() {
//	 FastJsonHttpMessageConverter fastConverter = new
//	 FastJsonHttpMessageConverter();
//	 FastJsonConfig fastconfig = new FastJsonConfig();
//	 fastconfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//	 fastConverter.setFastJsonConfig(fastconfig);
//	 HttpMessageConverter<?> converter = fastConverter;
//	 return new HttpMessageConverters(converter);
//	
//	 }

}















//第二种app========================================================================================================
/*

@SpringBootApplication
@ServletComponentScan//添加这个注解才会自动扫描自定义的listener,filter,servlet
public class App
{
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
	}
	
	
	
	
	
	
	
	
	
	
//用@Bean是不需要继承WebMvcConfigurationSupport
//	 @Bean
//	 public HttpMessageConverters fastJsonConverters() {
//	 FastJsonHttpMessageConverter fastConverter = new
//	 FastJsonHttpMessageConverter();
//	 FastJsonConfig fastconfig = new FastJsonConfig();
//	 fastconfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//	 fastConverter.setFastJsonConfig(fastconfig);
//	 HttpMessageConverter<?> converter = fastConverter;
//	 return new HttpMessageConverters(converter);
//	
//	 }

}

*/


//第一种app==================================================================================================================

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