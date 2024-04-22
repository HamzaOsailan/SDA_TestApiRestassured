package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Homework_09_week9_BaseUrl {
    protected RequestSpecification spec;

    @BeforeMethod
    public void setUpBaseURL() {
        // Initialize the common settings for all tests in this class
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON) // Set the content type for all requests
                .build();
    }
}