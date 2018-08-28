package com.univers.architecture.okhttpTutorial.cucumber.feature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univers.architecture.okhttpTutorial.cucumber.AbstractBaseStepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StudentsTest extends AbstractBaseStepDefinition {
	private final static Logger log = LoggerFactory.getLogger(StudentsTest.class);
	private OkHttpClient client = new OkHttpClient();
	private Response response;
	private List<Student> students = new ArrayList<>();
	Student student = new Student();

	@When("^I call for the list of students using \"([^\"]*)\"$")
	public void getAllStudents(String getStudentsUrl) throws Throwable {
		log.info("calling url to get all students");

		Request request = new Request.Builder().url(getStudentsUrl).get().build();
		response = client.newCall(request).execute();
		String string1 = response.body().string();
		students = this.retrieveResourceArrayFromResponse(string1, Student.class);
	}

	@Then("^the response must be \"([^\"]*)\"$")
	public void responseStatus(String responseStatus) throws Throwable {
		log.info("Checking reponse status is {}", responseStatus);
		int code = response.code();
		assertThat(code).isEqualTo(HttpStatus.valueOf(responseStatus).value());
	}

	@Then("^the list must contain \"([^\"]*)\" students$")
	public void the_list_must_contain(int studentsCount) throws Throwable {
		assertTrue(students.size() == studentsCount);
	}

	@Then("^the list must contain \"([^\"]*)\" one student with username \"([^\"]*)\" should be has those properties$")
	public void checkContent(int studentCount, String username, DataTable studentDetail) throws Throwable {
		log.info("search of students with username: {}", username);
		Map<String, String> details = studentDetail.asMap(String.class, String.class);
		ObjectMapper mapper = new ObjectMapper();
		Student student1 = mapper.convertValue(details, Student.class);

		int count = 0;
		// index of student who has this username
		int j = 0;
		for (int i = 0; i < students.size(); i++) {
			student = students.get(i);
			if (student.getUsername().equals(username)) {
				count++;
				j = i;
			}
		}

		student = students.get(j);
		assertThat(studentCount).isEqualTo(count);
		assertThat(student1).isEqualToComparingFieldByField(student);
	}

	// get student with username
	@When("^I call for a student using \"([^\"]*)\"$")
	public void callGetStudent(String getStudentUrl) throws Throwable {
		log.info("calling url to get all students");
		Request request = new Request.Builder().url(getStudentUrl).get().build();
		response = client.newCall(request).execute();
		String string1 = response.body().string();
		student = (Student) this.retrieveResourceFromResponse(string1, Student.class);
	}

	@Then("^the student should have those properties$")
	public void checkResponse(DataTable studentDetails) throws Exception {
		Map<String, String> details = studentDetails.asMap(String.class, String.class);
		ObjectMapper mapper = new ObjectMapper();
		Student student1 = mapper.convertValue(details, Student.class);
		assertThat(student1).isEqualToComparingFieldByField(student);
	}

	// add new Student
	@When("^I call \"([^\"]*)\" to add new student with those properties$")
	public void callAddStudent(String addStudentUrl, DataTable studentDetails) throws Exception {
		log.info("calling url to get all students");
		Map<String, String> details = studentDetails.asMap(String.class, String.class);
		final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(details);
		RequestBody body = RequestBody.create(JSON, jsonString);
		Request request = new Request.Builder().url(addStudentUrl).post(body).build();
		response = client.newCall(request).execute();
		log.info(response.body().string());
	}

}
