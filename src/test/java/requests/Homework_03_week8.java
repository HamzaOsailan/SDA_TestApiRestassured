package requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Homework_03_week8 {
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


    @Test
    void assertBodyMethod() {
        //Set the URL
        String url = " https://reqres.in/api/users/3";
        //User sends a GET Request to the url
        Response response = RestAssured.get(url);
        response.prettyPrint();
        //HTTP Status Code should be 200
        response.then().statusCode(200);
        //Content Type should be JSON
        response.then().contentType("application/json");
        //Status Line should be HTTP/1.1 200 OK
        response.then().statusLine("HTTP/1.1 200 OK");
    }
}
