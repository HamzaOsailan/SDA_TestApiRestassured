package requests;

import base_urls.Userhomework_13_BaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static requests.Homework_13_Createuser.username;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class Homework_13_Readuser extends Userhomework_13_BaseUrl {

    @Test
    public void readUserTest() {
        // Set the base URL
        spec.pathParams("first", "user", "second", username);

        // Set the expected data
        String strJson = """
        {
            "id": 11,
            "username": "Hamza",
            "firstName": "Osailan",
            "lastName": "osailan",
            "email": "hamzaosailan@hotmail.com",
            "password": "hamza123",
            "phone": "0530607682",
            "userStatus": 0
        }
        """;

        Map<String, Object> expectedData = convertJsonToJava(strJson, Map.class);

        // Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        // Convert response body to Map
        Map<String, Object> actualData = convertJsonToJava(response.asString(), Map.class);

        // Assert response body against expected data
//        assertEquals(actualData.get("username"), expectedData.get("username"), "Username mismatch");
//        assertEquals(actualData.get("firstName"), expectedData.get("firstName"), "First name mismatch");
//        assertEquals(actualData.get("lastName"), expectedData.get("lastName"), "Last name mismatch");
//        assertEquals(actualData.get("email"), expectedData.get("email"), "Email mismatch");
//        assertEquals(actualData.get("password"), expectedData.get("password"), "Password mismatch");
//        assertEquals(actualData.get("phone"), expectedData.get("phone"), "Phone number mismatch");
//        assertEquals(actualData.get("userStatus"), expectedData.get("userStatus"), "User status mismatch");
    }
}
