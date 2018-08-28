$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/okhttp.feature");
formatter.feature({
  "name": "call Students api\u0027s returns the right informations",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "asking to get list of students",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@scenario1"
    }
  ]
});
formatter.step({
  "name": "I call for the list of students using \"http://localhost:8080/getAll\"",
  "keyword": "When "
});
formatter.match({
  "location": "StudentsTest.getAllStudents(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the response must be \"OK\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentsTest.the_response_must_be_something(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list must contain",
  "rows": [
    {
      "cells": [
        "lastname",
        "soufian"
      ]
    },
    {
      "cells": [
        "firstname",
        "elhanafi"
      ]
    },
    {
      "cells": [
        "email",
        "soufelhanafi@gmail.com"
      ]
    },
    {
      "cells": [
        "username",
        "soufelhanafi"
      ]
    },
    {
      "cells": [
        "password",
        "password"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StudentsTest.the_list_must_contain(DataTable)"
});
formatter.result({
  "status": "passed"
});
});