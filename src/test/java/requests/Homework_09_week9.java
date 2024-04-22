package requests;

import base_urls.Homework_09_week9_BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Homework_09_week9 extends Homework_09_week9_BaseUrl {
    @Test
    public void createUser() {
        //set the url
        spec.pathParams("first","user");
        //set the expectedData
        String jsonBody = """
        {
            "id": 0,
            "username": "hamza",
            "firstName": "hamza",
            "lastName": "osailan",
            "email": "hamzaosailan@hotmail.com",
            "password": "Aa123",
            "phone": "0530607682",
            "userStatus": 0  
        }
        """;
        //send the request and get the response
        Response response = given(spec)
                .contentType("application/json")
                .body(jsonBody)
                .post("/{first}");
        response.prettyPrint();
        //Do assertion
        Assert.assertEquals(response.statusCode(), 200);
        JsonPath jsonPath = response.jsonPath();

        String type = jsonPath.getString("type");
        Assert.assertNotNull(type, "unknown");


    }
}
