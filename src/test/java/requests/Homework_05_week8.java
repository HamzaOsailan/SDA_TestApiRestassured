package requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

public class Homework_05_week8 {
      /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */
    @Test
    public void Testmethod(){

        //1.Set the Url
        String url ="https://reqres.in/api/users/23";
        //2.Set the expected data

        //3.Send the request and get the response
        Response response=given().get(url);
        System.out.println(response.prettyPrint());
        //4.Do Assertion
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server","cloudflare")
                .body(equalTo("{}"));
    }

}
