Feature: call Students api's returns the right informations

	@scenario1
	Scenario: asking to get list of students must be succeed
	When I call for the list of students using "http://localhost:8080/getAll"
	Then the response must be "OK"
	Then the list must contain "2" students
	Then the list must contain "1" one student with username "souf1" and should has those properties
		| username | souf1 |
		| lastname | souf1 |
		| firstname |souf1  |
		| email | souf1@email.com |
		| password | souf1|
		
	@scenario2
	Scenario: asking to get a students with his username must be succeed
	When I call for a student using "http://localhost:8080/getStudent/soufelhanafi1"
	Then the response must be "OK"
	Then the student should have those properties
		| username | souf1 |
		| lastname | souf1 |
		| firstname |souf1  |
		| email | souf1@email.com |
		| password | souf1|
		
	@scenario3
	Scenario: asking to add new Student must be succeed		
	When I call "http://localhost:8080/addStudent" to add new student with those properties
	| username | souf1 |
	| lastname | souf1 |
	| firstname |souf1  |
	| email | souf1@email.com |
	| password | souf1|
	Then the response must be "OK"
	