package com.app.entityPojos;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity()
@Getter
@ToString
@NoArgsConstructor
@Table(name = "Lectures")
public class Lecturers implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Column(name = "lectureId")
//	private static final Integer serialVersionUID = 1;
	
	@Id
	@Column(name="LectureId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lectureId;
	@Column(name="Name")
	private String lec_Name;
	@Column(name="Qualification")
	private String lec_Qualification;
	@Column(name="Subject")
	private String lec_Subject;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId",nullable = false)
	private Student lecturer_studentId;

	public Integer getLectureId() {
		return lectureId;
	}

	public void setLectureId(Integer lectureId) {
		this.lectureId = lectureId;
	}

	public String getLec_Name() {
		return lec_Name;
	}

	public void setLec_Name(String lec_Name) {
		this.lec_Name = lec_Name;
	}

	public String getLec_Qualification() {
		return lec_Qualification;
	}

	public void setLec_Qualification(String lec_Qualification) {
		this.lec_Qualification = lec_Qualification;
	}

	public String getLec_Subject() {
		return lec_Subject;
	}

	public void setLec_Subject(String lec_Subject) {
		this.lec_Subject = lec_Subject;
	}

	public Student getLecturer_studentId() {
		return lecturer_studentId;
	}

	public void setLecturer_studentId(Student lecturer_studentId) {
		this.lecturer_studentId = lecturer_studentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
