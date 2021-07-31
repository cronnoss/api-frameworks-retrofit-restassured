package com.cronnoss.apiframeworksretrofitrestassured.restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;

@SpringBootTest
public class RestAssuredTests {
    @Test
    void getUserTest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users/2")
//				.get("http://localhost:5050/api/users/2")
                .then()
                .extract().response();

        System.out.println(response.getBody().prettyPrint());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Janet", response.jsonPath().getString("data.first_name"));
        Assertions.assertEquals("Weaver", response.jsonPath().getString("data.last_name"));
    }

    @Test
    void createUserTest() {

        JSONObject request = new JSONObject();
        request.put("job", "leader");
        request.put("name", "morpheus");

        Response response = given()
                .body(request.toJSONString())
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .extract().response();

        System.out.println(response.getBody().prettyPrint());
        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("leader", response.jsonPath().getString("job"));
        Assertions.assertEquals("morpheus", response.jsonPath().getString("name"));
        Assertions.assertNotNull(response.jsonPath().getString("id"));
        Assertions.assertNotNull(response.jsonPath().getString("createdAt"));
    }
}
