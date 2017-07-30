package com.itmuch.cloud.bean;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grade {
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String gradeNm;
	private int teacherId;

	public Grade() {
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

	public Grade(int id, String gradeNm, int teacherId) {
		super();
		this.id = id;
		this.gradeNm = gradeNm;
		this.teacherId = teacherId;
	}

}
