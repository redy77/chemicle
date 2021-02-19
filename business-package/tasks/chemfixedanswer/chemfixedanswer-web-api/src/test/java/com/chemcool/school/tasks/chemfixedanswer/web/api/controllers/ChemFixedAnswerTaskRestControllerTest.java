package com.chemcool.school.tasks.chemfixedanswer.web.api.controllers;

import com.github.restdriver.serverdriver.http.response.Response;
import junit.framework.TestCase;
import org.junit.Test;

import static com.github.restdriver.serverdriver.Matchers.hasStatusCode;
import static com.github.restdriver.serverdriver.RestServerDriver.get;
import static com.github.restdriver.serverdriver.RestServerDriver.header;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChemFixedAnswerTaskRestControllerTest extends TestCase {

    private static final String BASE_URL = "http://localhost:8080//tasks-chemfixedanswer-application/v.1.0/tasks/fixed-answer";

    @Test
    public void testGetAllTasksJsonResponse(){
        Response response = get(BASE_URL + "/", header("Accept", "application/json"));
        assertThat(response, hasStatusCode(200));
    }
}