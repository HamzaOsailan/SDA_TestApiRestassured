package requests;

import base_urls.Homework_11_BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Homework_11_week9 extends Homework_11_BaseUrl {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/


    @Test
    public void TestMethod2() {
        //set the url
        spec.pathParams("first", "productsList");

        // Send the request and get the response
        Response response = given().spec(spec).get("/{first}");
        response.prettyPrint();

        // Extract the list of user types equal to "Women" using the correct nested structure
        JsonPath jsonPath = response.jsonPath();
        List<String> womenUserTypeList = jsonPath.getList("products.findAll { it.category.usertype.usertype == 'Women' }.category.usertype.usertype");
        System.out.println("List of 'Women' user types: " + womenUserTypeList);

        Assert.assertEquals(womenUserTypeList.size(), 12, "The number of 'Women' user types does not match the expected value.");
    }
}
