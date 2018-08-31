package com.univers.architecture.okhttpTutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univers.architecture.okhttpTutorial.model.Student;
import com.univers.architecture.okhttpTutorial.services.StudentServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
@Api(description = "student's APIs operations")
public class StudentController {
	@Autowired
	StudentServices studentServices;

	@ApiOperation("view the list of students")
	@GetMapping(value = "/getAll")
	public Iterable<Student> getAllStudents() {
		Iterable<Student> list = this.studentServices.listAllStudents();
		return this.studentServices.listAllStudents();
	}

	@ApiOperation("add new Student")
	@PostMapping(value = "/addStudent")
	public ResponseEntity addStudent(@RequestBody Student student) {
		this.studentServices.addStudent(student);
		return new ResponseEntity("students added successfully", HttpStatus.OK);
	}

	@ApiOperation("get a student using his username")
	@GetMapping(value = "/getStudent/{username}")
	public Student getStudent(@PathVariable String username) {
		return this.studentServices.findByUsename(username);
	}

}
