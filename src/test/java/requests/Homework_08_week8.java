package requests;

import base_urls.Homework_08_BaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test_data.Homework_08_test_data;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class Homework_08_week8 extends Homework_08_BaseUrl {
    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                      "name": "morpheus",
                                      "job": "leader",
                                       "id": "496",
                                        "createdAt": "2022-10-04T15:18:56.372Z"
                                      }
     */
    @Test
    public void Testmethod() {

        //1.Set the Url
        spec.pathParams("first","users");
        //2.Set the expected data
        Map<String, Object> expectedData = Homework_08_test_data.expectedDataMap(496,"leader","morpheus", "2022-10-04T15:18:56.372Z");
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
        Response response = RestAssured.given(spec)
                .body(expectedData).post("{first}");

        response.prettyPrint();



        //4.Do Assertion
        response.then()
                .statusCode(201)
                .body("name", equalTo(expectedData.get("name")),
                        "job", equalTo(expectedData.get("job")),
                        "id", equalTo(expectedData.get("id")),
                        "createdAt",notNullValue());
    }
}
