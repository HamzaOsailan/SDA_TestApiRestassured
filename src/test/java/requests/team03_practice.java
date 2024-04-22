package requests;

import base_urls.Team03_BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static io.restassured.RestAssured.given;

public class team03_practice extends Team03_BaseUrl {
//    protected RequestSpecification specification ;
//    @Before public void setUpBaseURL() {
//        specification = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v2").build();
//    }
//
//

//// Base URL should be used as Spec
//// Given https://gorest.co.in/public/v2/todos/47900
//// When user send Request via GET Method
//// Then Assert that Status Code is "200"
//// And Assert that Content Type is "application/json"
//// And Assert that Response Body is as follows:
//    {
//        "id": 47900,
//            "user_id": 6861183,
//            "title": "Et minus libero aegrotatio teres quia.",
//            "due_on": "2024-04-25T00:00:00.000+05:30",
//            "status": "pending"
//    }


    @Test
    public void Test() {
        // Proper usage of path parameters
        Response response = given()
                .spec(specification)
                .when()
                .get("/todos/47900")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .response();

        response.prettyPrint(); // For debugging

        JsonPath jsonPath = response.jsonPath();

        // Assertions using SoftAssert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getInt("id"), 47900);
        softAssert.assertEquals(jsonPath.getInt("user_id"), 6861183);
        softAssert.assertEquals(jsonPath.getString("title"), "Et minus libero aegrotatio teres quia.");
        softAssert.assertEquals(jsonPath.getString("due_on"), "2024-04-25T00:00:00.000+05:30");
        softAssert.assertEquals(jsonPath.getString("status"), "pending");
        softAssert.assertAll();
    }
}
