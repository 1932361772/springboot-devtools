package com.itmuch.cloud.contrllor;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.itmuch.cloud.bean.Grade;
import com.itmuch.cloud.bean.JdbcGrade;
import com.itmuch.cloud.bean.MybatisGrade;
import com.itmuch.cloud.service.GradeService;
import com.itmuch.cloud.service.MybatisGradeService;

@RestController
//@Controller
public class GradeController {
	@Resource
	private GradeService gradeService;// 已经注入springbootjpa 和jdbc的Service.
	@Resource
	private MybatisGradeService mybatisGradeService ;

	@RequestMapping("/findByGradeNm")
	public Grade findByGradeNm(String gradeNm) {
		System.err.println("...查询ok.........................");
		return gradeService.findByGradeNm(gradeNm);
	}

	@RequestMapping("/findMyGradeNm")
	public Grade findMyGradeNm(String gradeNm) {
		System.err.println("...查询ok.........................");
		return gradeService.findMyGradeNm(gradeNm);
	}

	@RequestMapping("/save")
	public String save() {
		System.err.println(">>>>>>>>>>>>>>>Grad save>>>>>>>>>>>>>>>>");
		Grade grade = new Grade();
		// grade.setId(11);
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

	@RequestMapping("/getAll")
	public Iterable<Grade> getAll() {
		return gradeService.getAll();
	}

	@RequestMapping("/getAll2")
	public Iterable<Grade> getAll2() {
		return gradeService.getAll2();
	}

	@RequestMapping("/findByGradeNmJdbc/{gradeNm}")
	public JdbcGrade findByGradeNmJdbc(@PathVariable String gradeNm) {
		System.err.println("findByGradeNmJdbc>>>>>>>>>>>>>>>>>>>>>>>");
		return gradeService.findByGradeNmJdbc(gradeNm);
	}

	@RequestMapping("/create")
	public JdbcGrade create() {
		JdbcGrade g = new JdbcGrade();
		g.setId(111);
		g.setGradeNm("111");
		g.setTeacherId(222);
		gradeService.create(g);
		return g;
	}

	@RequestMapping("/jdbcfindAll")
	public Object jdbcfindAll() {
		return gradeService.jdbcfindAll();

	}
	@RequestMapping("/jdbcdelete/{id}")
	public String jdbcdelete(@PathVariable Integer id){
		gradeService.jdbcdelete(id);
		return "jdbcdelete ok..........";
	}
/*	@RequestMapping("/jdbcupdate/{id}/{jdbcgradeNm}/{teacherId}")
	public void jdbcupdate(@PathVariable int id,@PathVariable String jdbcgradeNm,@PathVariable int teacherId) {
		JdbcGrade g=new JdbcGrade();
		g.setId(id);
		g.setGradeNm(jdbcgradeNm);
		g.setTeacherId(teacherId);
		gradeService.jdbcupdate(g);
	}*/
	
	@RequestMapping("/jdbcupdate/{id}")
	public JdbcGrade jdbcupdate(@PathVariable int id) {
		JdbcGrade g=new JdbcGrade();
		g.setId(id);
		g.setGradeNm("tt");
		g.setTeacherId(333);
		gradeService.jdbcupdate(g);
		return g;
	}
	@RequestMapping("/mybatisgetByName/{name}")
	public List<MybatisGrade> getByName(@PathVariable String name) {
		System.err.println("Mybatis..........getByName....");
		return mybatisGradeService.mybatisgetByName(name);
	}
	@RequestMapping("/mybatisSave")
	public MybatisGrade mybatisSave(MybatisGrade mybatisGrade){
		System.err.println("..............mybatisSave.......");
		mybatisGradeService.mybatisSave(mybatisGrade);
		return mybatisGrade;
		
	}
	@RequestMapping("/mybatisgetByName2/{name}")
	public List<MybatisGrade> mybatisgetByName2(@PathVariable String name) {
		System.err.println("Mybatis..........getByName....");
		PageHelper.startPage(3,2);//每页2条,显示第3页.
		return mybatisGradeService.mybatisgetByName(name);
	}
	
	
}
