package com.univers.architecture.okhttpTutorial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univers.architecture.okhttpTutorial.dao.StudentDAO;
import com.univers.architecture.okhttpTutorial.model.Student;

@Service
public class StudentServices {
	@Autowired
	StudentDAO studentDAO;

	public Iterable<Student> listAllStudents() {
		Iterable<Student> findAll = this.studentDAO.findAll();
		return findAll;
	}

	public Student findByUsename(String username) {
		// TODO Auto-generated method stub
		return this.studentDAO.findByUsername(username);
	}

	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		this.studentDAO.save(student);
	}

	public String testTest() {
		return "hell";
	}

}
