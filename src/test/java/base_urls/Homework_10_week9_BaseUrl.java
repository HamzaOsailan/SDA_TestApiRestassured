package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Homework_10_week9_BaseUrl {
    protected RequestSpecification spec ;
    @BeforeMethod
    public void setUpBaseURL() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .build();
    }
}

