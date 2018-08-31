package com.univers.architecture.okhttpTutorial.cucumber;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.univers.architecture.okhttpTutorial.cucumber.feature.Student;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", monochrome = true)
public class LaunchCucumberTest {
	private static final Logger log = LoggerFactory.getLogger(LaunchCucumberTest.class);
	private static WireMockServer wireMockServer;

	@BeforeClass
	public static void initWireMockServer() throws JsonProcessingException {
		log.info("Start Init Wire Mock Server ");

		wireMockServer = new WireMockServer();
		wireMockServer.start();

		// ObjectMapper mapper = new ObjectMapper();
		// List<Student> students = new ArrayList<>();
		// Student std1 = new Student("souf1", "souf1", "souf1@email.com", "souf1", "souf1");
		// Student std2 = new Student("souf2", "souf2", "souf2@email.com", "souf2", "souf2");
		// students.add(std1);
		// students.add(std2);

		// // get all students

		// String arrayString = mapper.writeValueAsString(students);
		// stubFor(get(urlEqualTo("/getAll")).willReturn(aResponse().withStatus(HttpStatus.OK.value())
		// 		.withHeader("Content-Type", APPLICATION_JSON_UTF8_VALUE).withBody(arrayString)));

		// // get Student with username
		// String studentString = mapper.writeValueAsString(std1);
		// stubFor(get(urlEqualTo("/getStudent/soufelhanafi1")).willReturn(aResponse().withStatus(HttpStatus.OK.value())
		// 		.withHeader("Content-Type", APPLICATION_JSON_UTF8_VALUE).withBody(studentString)));
		// log.info("End Init Wire Mock Server ");

		// // post student
		// stubFor(post(urlEqualTo("/addStudent")).willReturn(aResponse().withStatus(HttpStatus.OK.value())
		// 		.withBody(studentString).withHeader("Content-Type", APPLICATION_JSON_UTF8_VALUE)));
	}

	@AfterClass
	public static void stopWireMockServer() {
		log.info("Start Stopping Wire Server ");
		wireMockServer.stop();
		log.info("End Stopping Wire Server ");
	}

}
