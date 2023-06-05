package com.sqa.github;

import com.sqa.utils.TestLogger;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredDemoTests implements TestLogger {

    private static final String BASE_URI = "https://api.github.com";
    private static final String ZEN_END_PINT = "/zen";
    private String issueTitle = String.format("issue %s", RandomStringUtils.randomAlphabetic(5));
    private String issueDescription = "Description of new issue";

    /*
        01. Check that 200 code comes in response to a simple GET
    */
    @Test
    public void verifyHealthcheckTest() {
        given()
                .baseUri(BASE_URI)
                .when()
                .get(ZEN_END_PINT)
                .then()
                .log().ifValidationFails() // get logs only if validation fails
                .statusCode(200); // validate that get response code is 200 (OK)
    }

    /*
        02. Check that a non-empty response body to a simple GET is coming
    */
    @Test
    public void verifyDefunktBodyTest() {
        given()
                .baseUri(BASE_URI)
                .when()
                .get(ZEN_END_PINT)
                .then()
                .log().ifValidationFails()
                .body(Matchers.not(Matchers.empty())); // validate that response body is not empty
        //      .body(Matchers.matchesPattern("[A-Z a-z.]*");
    }

    /*
        03. Check that the answer body contains a field equal to the value
    */
    @Test
    public void verifyIssuesContainTest() {
        given()
                .baseUri(BASE_URI)
                .when()
                .get("/repos/musagulov/sqa/issues")
                .then()
                .log().ifValidationFails()
                .body("message", Matchers.notNullValue())
                .body("message", Matchers.equalTo("Not Found")); /* validate that message field is
                                                                            not found within the JSON response */
    }

    /*
        04. Check that the response body contains a field after authorization
    */
    @Test
    public void verifyIssuesAuthorized() {
        given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer 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")
                .when()
                .get("/repos/musagulov/sqa/issues")
                .then()
                .log().ifValidationFails()
                .body("title", Matchers.hasItems("issue3"));  /* validate that title field contains
                                                                    some items within the JSON response */
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
