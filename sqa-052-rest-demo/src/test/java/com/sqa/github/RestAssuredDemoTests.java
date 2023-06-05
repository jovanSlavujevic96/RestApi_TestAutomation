package com.sqa.github;

import com.sqa.utils.TestLogger;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredDemoTests implements TestLogger {

    private String issueTitle = String.format("issue %s", RandomStringUtils.randomAlphabetic(5));
    private String issueDescription = "Description of new issue";

    /*
        01. Check that 200 code comes in response to a simple GET
    */
    @Test
    public void verifyHealthcheckTest() {
        given()
                .when()
                .get("https://api.github.com/zen")
                .then()
                .statusCode(200);
    }

    /*
        02. Check that a non-empty response body to a simple GET is coming
    */
    @Test
    public void verifyDefunktBodyTest() {

    }

    /*
        03. Check that the answer body contains a field equal to the value
    */
    @Test
    public void verifyIssuesContainTest() {

    }

    /*
        04. Check that the response body contains a field after authorization
    */
    @Test
    public void verifyIssuesAuthorized() {

    }

    /*
        05. Check that the response body contains an error and a 403 code
    */
    @Test
    public void verifyIssuesNoUserAgent() {

    }

    /*
        06. Checking that the issue is published
    */
    @Test
    public void verifyPostIssues() {

    }

    /*
        07. Checking that the issue is published (data in params)
    */
    @Test
    public void verifyPostIssuesUrlParam() {

    }

    /*
        08. Checking that the issue is published (POJO)
    */
    @Test
    public void verifyPostPojo() {

    }

    /*
        09. Checking that the issue is published (Map)
    */
    @Test
    public void verifyPostMap() {

    }

    /*
        10. Checking that the issue is published (POJO, json path)
    */
    @Test
    public void verifyPostPojoWithJsonPath() {


    }
}
