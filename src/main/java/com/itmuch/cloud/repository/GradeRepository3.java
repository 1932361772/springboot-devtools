package com.itmuch.cloud.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.itmuch.cloud.bean.Grade;
//PagingAndSortingTemplateVariables
public interface GradeRepository3 extends PagingAndSortingRepository<Grade,Integer> {
//	extends Repository查询方法需以find,read,get,开头.
	
	public Grade findByGradeNm(String gradeNm);
	
	@Query("from Grade where gradeNm=:Nm")
	public Grade findMyGradeNm(@Param("Nm")String gradeNm);
	
	
	

}
