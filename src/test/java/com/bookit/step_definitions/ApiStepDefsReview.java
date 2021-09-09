package com.bookit.step_definitions;

import com.bookit.utilities.BookItApiUtils;
import com.bookit.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class ApiStepDefsReview {

    @Given("I logged Bookit api using {string} and {string}")
    public void i_logged_Bookit_api_using_and(String email, String password) {
        Response response = given().contentType(ContentType.JSON).
                                    and().queryParam("email", "sbirdbj@fc2.com")
                                         .queryParam("password", "asenorval").
                                    when().get(ConfigurationReader.get("qa2api.uri") + "/sign");

        String accessToken = response.path("accessToken");
        String finalToken = "Bearer " + accessToken;

    }
}
//email		sbirdbj@fc2.com
//password	asenorval
get("qa2api.uri") + "/sign")