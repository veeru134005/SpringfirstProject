package com.app.entityPojos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity()
@Getter
@ToString
@NoArgsConstructor
@Table(name="Students")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * @Column(name="StudentId") private static final Integer serialVersionUID = 1;
	 */
	@Id
	@Column(name="StudentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	@Column(name="RoomNumber")
	private Integer roomNumber;
	@Column(name="Name")
	private String  Std_Name;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "std_Id")
	@Fetch(value = FetchMode.SELECT)
	private List<Address> std_Id;
	
	  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="lecturer_studentId") 
	  private List<Lecturers> lecturer_studentId;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getStd_Name() {
		return Std_Name;
	}

	public void setStd_Name(String std_Name) {
		Std_Name = std_Name;
	}

	public List<Address> getStd_Id() {
		return std_Id;
	}

	public void setStd_Id(List<Address> std_Id) {
		this.std_Id = std_Id;
	}

	public List<Lecturers> getLecturer_studentId() {
		return lecturer_studentId;
	}

	public void setLecturer_studentId(List<Lecturers> lecturer_studentId) {
		this.lecturer_studentId = lecturer_studentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
