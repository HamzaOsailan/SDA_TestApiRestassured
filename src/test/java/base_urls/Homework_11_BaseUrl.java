package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Homework_11_BaseUrl {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/
    protected RequestSpecification spec;
    @BeforeMethod
    public void TestMethod() {
        spec=new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com/api/")
                .build();
    }





}
