package com.itmuch.cloud.jdbcdao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itmuch.cloud.bean.MybatisGrade;

public interface MybatisGradeMapper {
	@Select("select * from MybatisGrade where grade_nm=#{name}") // mybatis
																	// 的占位符用的是#.
	@Results({ @Result(property = "id", column = "id"), @Result(property = "gradeNm", column = "grade_nm"),
			@Result(property = "teacherId", column = "teacher_id"), })
	public List<MybatisGrade> mybatisgetByName(String name);

	@Insert("insert into Mybatisgrade(grade_nm,teacher_id)values(#{gradeNm},#{teacherId})")
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")//声明自增长的id.
	public void mybatisSave(MybatisGrade mybatisGrade);

	@Update("")
	public void mybatisUpdate();

	@Delete("")
	public void mybatisDelete();
	
	
	

}
