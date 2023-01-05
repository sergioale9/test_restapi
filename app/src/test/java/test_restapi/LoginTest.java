package test_restapi;

import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

public class LoginTest {
    String BASE_URL = "https://test-api.k6.io/auth/basic/login/";
    @Test
    public void loginTest(){
        String response = RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" + 
                        "   \"username\": \"sergioale\",\n" +
                        "   \"password\": \"4713088013\"\n" +
                        "}")
                .post (BASE_URL)
                .then()
                .log()
                .all()
                .extract()
                .asString();
        System.out.println(response);
    }

}
