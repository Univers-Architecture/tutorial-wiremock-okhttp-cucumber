package com.univers.architecture.okhttpTutorial.dao;

import org.springframework.data.repository.CrudRepository;

import com.univers.architecture.okhttpTutorial.model.Student;

public interface StudentDAO extends CrudRepository<Student, Long> {

//	public List<Student> findAll();

	public Student findByUsername(String username);

//	public Student save(Student student);

}
