package requests;

import base_urls.Userhomework_13_BaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.Pojohomework13;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Homework_13_Createuser extends Userhomework_13_BaseUrl {
    public static String username;
    public Pojohomework13 expectedData;
    public Response response;

    @Test
    public void createUserTest() throws JsonProcessingException {
        // Set the base URL
        // Set the path parameters
        spec.pathParams("first", "user");

        // Set the expected data

        String strJson = """
{
    "id": 11,
    "username": "hamza",
    "firstName": "hamza",
    "lastName": "osailan",
    "email": "hamzaosailan@hotmail.com",
    "password": "hamza123",
    "phone": "0530607682",
    "userStatus": 0
}
""";



        expectedData = new ObjectMapper().readValue(strJson, Pojohomework13.class);

        // Send the request and get the response
        response = given(spec)
                .body(expectedData)
                .post("{first}");
        response.prettyPrint();


        // Do assertions
        assertEquals(200, response.getStatusCode());
        username = expectedData.getUsername();
    }
}
