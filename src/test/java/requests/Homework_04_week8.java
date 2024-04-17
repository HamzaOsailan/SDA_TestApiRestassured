package requests;

import base_urls.Homework_04_BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework_04_week8 extends Homework_04_BaseUrl {
    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           "email" is "janet.weaver@reqres.in",
       And
           "first_name" is "Janet"
       And
           "last_name" is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    void ReqRes(){


        Response response=given(spec).get();

        //User send GET Request to the URL
        response.prettyPrint();

        response.then().statusCode(200)
                .contentType("application/json")
                .body("data.email",equalTo("janet.weaver@reqres.in"))
                .body("data.first_name",equalTo("Janet"))
                .body("data.last_name",equalTo("Weaver"))
                .body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
}
