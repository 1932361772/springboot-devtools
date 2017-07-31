package com.itmuch.cloud.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
//	返回运行异常信息到指定页面,
	@ExceptionHandler(value=Exception.class)
	public ModelAndView defaultErrorHandler(Exception exception) {
		System.err.println("..................defaultError ..");
		ModelAndView mv = new ModelAndView();

		mv.setViewName("exception");
		mv.addObject("message",exception);
		mv.addObject("message1","系统信息异常,请联系管理员...");
		return mv;
	}
	
	
//	返回固定字符串....
/*	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public String defaultErrorHandler() {
		System.err.println("..................defaultError ..");
		return "系统信息异常,请联系管理员...";
	}*/

}
