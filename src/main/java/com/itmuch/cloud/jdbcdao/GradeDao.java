package com.itmuch.cloud.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.itmuch.cloud.bean.JdbcGrade;
import com.mysql.jdbc.Statement;

@Repository
public class GradeDao {
	@Resource
	private JdbcTemplate jdbc;
//jdbc 由gradeNm查询jdbcgrade  成功
	public JdbcGrade findByGradeNmJdbc(String gradeNm) {
//		String sql = "select * from JdbcGrade where gradeNm=:gradNm";
		String sql = "select * from jdbcGrade where grade_nm=?";
		RowMapper<JdbcGrade> rowMapper=new BeanPropertyRowMapper<>(JdbcGrade.class);
		
		JdbcGrade jdbcGrade=jdbc.queryForObject(sql, new Object[] { gradeNm }, rowMapper);
		return jdbcGrade;

	}
//	jdbc 查找所有 成功
//	@Transactional(readOnly=true)
//	public List<JdbcGrade> findAll(){}
	@Transactional
	public Object jdbcfindAll() {
		return jdbc.query("select * from JdbcGrade", new GradeRowMapper());
	}
//	jdbc 单个查询 成功
	@Transactional
	public JdbcGrade findJdbcGradeById(int id) {
		return jdbc.queryForObject("select * from JdbcGrade where id=?", new Object[]{id},new GradeRowMapper());
	}
		
//	jdbc添加数据. 成功 批量插入效率高.每批至少100条以上.
	public JdbcGrade create(final JdbcGrade jdbcGrade) {
		final String sql="insert into jdbcGrade(grade_nm,teacher_id)value(?,?)";
		KeyHolder holder=new GeneratedKeyHolder();

		jdbc.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, jdbcGrade.getGradeNm());
				ps.setInt(2, jdbcGrade.getTeacherId());
				
				return ps;
			}
		},holder);
		
	
		int newGradeId=holder.getKey().intValue();
		jdbcGrade.setId(newGradeId);
		return jdbcGrade;
				
	}
//	jdbc删除 成功
	public void jdbcdelete(final Integer id) {
		final String sql="delete from jdbcGrade where id=?";
		jdbc.update(sql,new Object[]{id},new int[]{java.sql.Types.INTEGER});
	}
//	jdbc 更新  失败.
	
	public void jdbcupdate(final JdbcGrade jdbcGrade) {
	/*	jdbc.update("update jdbcGrade set grade_nm=?,teacher_id=?,where id=?",
					new Object[]{jdbcGrade.getGradeNm(),jdbcGrade.getTeacherId(),jdbcGrade.getId()});*/
		jdbc.update("update jdbcGrade set grade_nm=?,teacher_id=?,where id=?",
				new Object[]{"yyyyy",222,10});
	}
	
	
	

}


//可以将此处的jdbc等各种协议..........................
class GradeRowMapper implements RowMapper<JdbcGrade> {

	@Override
	public JdbcGrade mapRow(ResultSet rs, int rowNum) throws SQLException {
		JdbcGrade g=new JdbcGrade();
		g.setId(rs.getInt("id"));
		g.setGradeNm(rs.getString("grade_nm"));
		g.setTeacherId(rs.getInt("teacher_id"));
		
		return g;
	}

}
