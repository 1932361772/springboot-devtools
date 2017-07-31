package com.itmuch.cloud.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
////和mybatis沟通的配置项..pagehelper-spring-boot-starter不需要自定义此配置.
//import com.github.pagehelper.PageHelper;
//此处可以以类的方式配置自定义的参数.  使用pagehelper需要自定义配置
/*@Configuration
public class MybatisConfiguration {
	@Bean
	public PageHelper pageHelper() {
	PageHelper page = new	PageHelper();
	Properties p = new Properties();
		p.setProperty("offSetAsPageNum","true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		page.setProperties(p);
		return page;
	}

}*/
