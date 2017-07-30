package com.itmuch.cloud.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.itmuch.cloud.bean.Grade;
import com.itmuch.cloud.bean.JdbcGrade;
import com.itmuch.cloud.jdbcdao.GradeDao;
import com.itmuch.cloud.repository.GradeRepository;
import com.itmuch.cloud.repository.GradeRepository2;
import com.itmuch.cloud.repository.GradeRepository3;

import antlr.collections.List;

@Service
public class GradeService {
	@Resource
	private GradeRepository gradeRepository;
	@Resource
	private GradeRepository2 gradeRepository2;
	@Resource
	private GradeRepository3 gradeRepository3;
	@Resource
	private GradeDao gradeDao;// jdbc

	public Grade findByGradeNm(String gradeNm) {

		return gradeRepository.findByGradeNm(gradeNm);
	}

	public Grade findMyGradeNm(@Param("Nm") String gradeNm) {
		return gradeRepository.findMyGradeNm(gradeNm);
	}

	@Transactional // 切事务
	public void save(Grade grade) {
		gradeRepository2.save(grade);
	}

	@Transactional
	public void delete(int id) {
		gradeRepository2.delete(id);
	}

	public Iterable<Grade> getAll() {
		// return gradeRepository3.findAll((Iterable<Integer>) new
		// PageRequest(0, 3));//失败.
		return gradeRepository3.findAll();
	}

	public Iterable<Grade> getAll2() {
		// return gradeRepository3.findAll(new
		// Sort(Sort.Direction.DESC,"teacherId"));
		return gradeRepository3.findAll();

	}

	// jdbc
	public JdbcGrade findByGradeNmJdbc(String gradeNm) {

		return gradeDao.findByGradeNmJdbc(gradeNm);
	}

	@Transactional // 切事务
	public JdbcGrade create(final JdbcGrade jdbcGrade) {
		return gradeDao.create(jdbcGrade);

	}

	public Object jdbcfindAll() {
		return gradeDao.jdbcfindAll();

	}
	public void jdbcdelete(final Integer id){
		gradeDao.jdbcdelete(id);
		
	}
	public void jdbcupdate(JdbcGrade jdbcGrade) {
	 	gradeDao.jdbcupdate(jdbcGrade);
	}

}
