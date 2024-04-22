package requests;

import base_urls.Homework_10_week9_BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Homework_10_week9 extends Homework_10_week9_BaseUrl {
//    Using the https://petstore.swagger.io/ document, write an automation test that finds the number of "pets" with the status "available" and asserts that there are more than 100.
@Test
public void testAvailablePetsCount() {

    //set the url
    spec.pathParams("first","pet","second","findByStatus");


    //set the expectedData

    //send the request and get the response

    Response response = given()
            .spec(spec)
            .queryParam("status", "available")
            .get("/{first}/{second}");

    response.prettyPrint();

    // Deserialize the JSON response to a List
    List<String> statuses = response.jsonPath().getList("findAll { it.status == 'available' }.status");
    // Assert that the number of available pets is more than 100
    Assert.assertTrue(statuses.size() > 100, "The number of available pets is less than or equal to 100.");
}
}
