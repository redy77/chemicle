package com.chemcool.school.tasks.chemfixedanswer.web.api.controllers;

import static com.github.restdriver.serverdriver.Matchers.*;
import static com.github.restdriver.serverdriver.RestServerDriver.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import com.github.restdriver.serverdriver.http.response.Response;

class ChemFixedAnswerTaskRestControllerTest {

    private static final String BASE_URL = "http://localhost:8080//tasks-chemfixedanswer-application/v.1.0/tasks/fixed-answer";

    @Test
    public void getAllTasksJsonResponse(){
        Response response = get(BASE_URL + "/", header("Accept", "application/json"));
        assertThat(response, hasStatusCode(200));
    }

//    @Test
//    public void

}