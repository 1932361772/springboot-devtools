package com.itmuch.cloud.bean;

public class JdbcGrade {
	private int id;
	private String gradeNm;
	private int teacherId;

	public JdbcGrade() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGradeNm() {
		return gradeNm;
	}

	public void setGradeNm(String gradeNm) {
		this.gradeNm = gradeNm;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public JdbcGrade(int id, String gradeNm, int teacherId) {
		super();
		this.id = id;
		this.gradeNm = gradeNm;
		this.teacherId = teacherId;
	}

}
