package com.univers.architecture.okhttpTutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	@ApiModelProperty(notes = "The database generated product ID")
	private Long Id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(unique = true, name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String fistname) {
		this.firstname = fistname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student(String fistname, String lastname, String email, String username, String password) {
		super();
		this.firstname = fistname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}
