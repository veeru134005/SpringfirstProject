package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entityPojos.Address;
import com.app.entityPojos.Lecturers;
import com.app.entityPojos.Student;


@RestController
public class TestClass {

	@Autowired
	public SessionFactory sessionFactory;
	
	Session getCurrentSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	@RequestMapping("/veeru")
	public String saveStudentObject() {
		
		
		Address a= new Address();
		a.setCityName("hydeabda");
		a.setPinCode("53301");
		a.setStreetName("hai");
		
		Address a1= new Address();
		a1.setCityName("hydeabda");
		a1.setPinCode("53301");
		a1.setStreetName("hai");
		
		List<Address> listAd=new ArrayList<>();
		
		listAd.add(a);
		listAd.add(a1);
		listAd.add(a);
		listAd.add(a1);
		
		Lecturers l=new Lecturers();
		
		l.setLec_Name("hariOm");
		l.setLec_Qualification("b.tec");
		l.setLec_Subject("english");
		
		Lecturers l1=new Lecturers();
		
		l1.setLec_Name("hariOm");
		l1.setLec_Qualification("b.tec");
		l1.setLec_Subject("english");
		
		List<Lecturers> listLecture=new ArrayList<>();
		listLecture.add(l);
		listLecture.add(l1);
		listLecture.add(l);
		listLecture.add(l1);

		Student st=new Student();
		st.setStd_Name("veeru");
		st.setRoomNumber(20);
		st.setLecturer_studentId(listLecture);
		st.setStd_Id(listAd);
		
		getCurrentSession().save(st);
		return "success";
	}
	
}
