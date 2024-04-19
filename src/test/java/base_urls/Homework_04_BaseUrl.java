package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class Homework_04_BaseUrl {
    protected RequestSpecification spec;

    @BeforeMethod
     public void setUp(){
        spec= new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api/users/2")
                .build();
    }
}
