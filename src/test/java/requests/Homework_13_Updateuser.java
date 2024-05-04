package requests;

import base_urls.Userhomework_13_BaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojos.Pojohomework13;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static requests.Homework_13_Createuser.username;

public class Homework_13_Updateuser extends Userhomework_13_BaseUrl {



    @Test
    public void TestMethod() throws JsonProcessingException {
        //set the url
        spec.pathParams("first", "user","second",username);

        //set the expectedData
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

        Pojohomework13 expectedData =new ObjectMapper().readValue(strJson, Pojohomework13.class);
        //send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();
        //Do assertion
        assertEquals(response.getStatusCode(), 200);
        username = expectedData.getUsername();
    }
}
