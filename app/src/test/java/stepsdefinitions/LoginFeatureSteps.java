package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import test_restapi.User;

public class LoginFeatureSteps {
    String URL = "https://test-api.k6.io/auth/basic/login/";
    User user;
    Response response;

    @Given("user with a valid username and password")
    public void userWithAValidUsernameAndPassword() {
    user = User.builder().username("sergioale").password("4713088013").build();
    }
    @When("send a post request to the API")
    public void sendAPostRequestToTheAPI() {
        response = RestAssured.given().contentType(ContentType.JSON).body(user).post(URL);
    }
    @Then("user is login")
    public void userIsLogin() {
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
