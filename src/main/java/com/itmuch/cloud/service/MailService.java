package com.itmuch.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Value("${spring.mail.username}")
	private String from;
	@Autowired
	private JavaMailSender sender;
	
	public void sendSimple(String to,String subject,String content) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);

		sender.send(mailMessage);
		System.err.println("邮件发送成功....send success......");
	}
	

}
