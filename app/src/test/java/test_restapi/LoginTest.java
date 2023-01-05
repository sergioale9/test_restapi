package test_restapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class LoginTest {
    String URL = "https://test-api.k6.io/auth/basic/login/";
    @Test
    public void loginTest(){
        Response rest = (Response) RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" + 
                        "   \"username\": \"sergioale\",\n" +
                        "   \"password\": \"4713088013\"\n" +
                        "}")
                .post (URL)
                .then()
                .log()
                .all()
                .extract();
        int statuscode = rest.getStatusCode();
        Assertions.assertEquals(statuscode, 200);
    }

}
