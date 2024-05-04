package requests;

import base_urls.Userhomework_13_BaseUrl;
import com.sun.source.tree.AssertTree;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static requests.Homework_13_Createuser.username;

public class Homework_13_Deleteuser extends Userhomework_13_BaseUrl {

    /**
     * Write an automation test that will create a 'user' then read, update and delete the created user
     * using the "https://petstore.swagger.io/" document. (Create a classes for each request.)
     */

    @Test
    public void TestMethod(){

        spec.pathParams("first", "user", "second", username);

        // Send the request and get the response
        Response response = given(spec).delete("/{first}/{second}");
        response.prettyPrint();
        // Assertion
        assertTrue(response.asString().isEmpty());

    }
}
