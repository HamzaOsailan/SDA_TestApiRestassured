package requests;

import base_urls.Userhomework_13_BaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.Pojohomework13;

import static io.restassured.RestAssured.given;

public class Homework_13_Ceaduser extends Userhomework_13_BaseUrl {
    private Pojohomework13 expectedData;
    private Response response;
    //Write an automation test that will create a 'user'
    // then read, update and delete the created user using the
    // "https://petstore.swagger.io/" document.
    // (Create a classes for each request.)

    @Test
    public void main() throws JsonProcessingException {
        //set the url
        spec.pathParams("first","user");
        //set the expectedData
        String strJson= """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }
                """;
        expectedData =new ObjectMapper().readValue(strJson, Pojohomework13.class);
        //send the request and get the response
        response=given(spec)
                .body(expectedData)
                .post("{first}");
        response.prettyPrint();


        //Do assertion
    }

}
