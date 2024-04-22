package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Team03_BaseUr01 {
    protected RequestSpecification specification ;
    @BeforeMethod
    public void setUpBaseURL() {
        specification = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1").build();
    }
}
