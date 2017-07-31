package com.itmuch.cloud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmuch.cloud.bean.MybatisGrade;
import com.itmuch.cloud.jdbcdao.MybatisGradeMapper;

@Service
public class MybatisGradeService {
	@Autowired
	private MybatisGradeMapper mybatisGradeMapper;

	public List<MybatisGrade> mybatisgetByName(String name) {
		return mybatisGradeMapper.mybatisgetByName(name);
	}
	@Transactional
	public void mybatisSave(MybatisGrade mybatisGrade){
		mybatisGradeMapper.mybatisSave(mybatisGrade);
		
	}
	
	
}
