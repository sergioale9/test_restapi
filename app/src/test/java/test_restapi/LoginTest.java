package test_restapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class LoginTest {
    String URL = "https://test-api.k6.io/auth/basic/login/";
    User user;
    @Test
    public void loginTest(){
        user = User.builder().username("sergioale").password("4713088013").build();
        Response rest = (Response) RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body(user)
                .post (URL)
                .then()
                .log()
                .all()
                .extract();
        int statuscode = rest.getStatusCode();
        Assertions.assertEquals(200, statuscode);
    }
}
