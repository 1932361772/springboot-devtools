package com.itmuch.cloud.contrllor;

import javax.annotation.Resource;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.bean.Grade;
import com.itmuch.cloud.service.GradeService;

@RestController
public class GradeController {
	@Resource
	private GradeService gradeService;
	@RequestMapping("/findByGradeNm")
	public Grade findByGradeNm(String gradeNm){
		System.err.println("...查询ok.........................");
		return gradeService.findByGradeNm(gradeNm);
	}
	
	@RequestMapping("/findMyGradeNm")
	public Grade findMyGradeNm(String gradeNm){
		System.err.println("...查询ok.........................");
		return gradeService.findMyGradeNm(gradeNm);
	}
	@RequestMapping("/save")
	public String save() {
		System.err.println(">>>>>>>>>>>>>>>Grad save>>>>>>>>>>>>>>>>");
		Grade grade = new Grade();
//		grade.setId(11);
		grade.setGradeNm("nihao");
		grade.setTeacherId(22);
		 gradeService.save(grade);
		 return "save ok";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		gradeService.delete(id);
		return "delete ok...";
	}
	@RequestMapping("/getall")
	public Iterable<Grade> getAll() {
		return gradeService.getAll();
	}
	@RequestMapping("/getall2")
	public Iterable<Grade> getAll2() {
		return gradeService.getAll2();
	}
	
	

}
