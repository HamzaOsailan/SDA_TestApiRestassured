package requests;

import base_urls.Homework_06_BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Homework_06_week8 extends Homework_06_BaseUrl {
     /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */
     @Test
     public void softAssert_jsonPathTest(){

         //1.Set the Url
          spec.pathParams("first", "unknown", "second", "3");
         //2.Set the expected data
         //3.Send the request and get the response
          Response response = given().spec(spec)
                  .get("/{first}/{second}")
                  .then()
                  .contentType("application/json; charset=utf-8")
                  .statusCode(200)
                  .extract()
                  .response();

          response.prettyPrint();

          JsonPath jsonPath = response.jsonPath();
          int id=jsonPath.getInt("data.id");
          String name=jsonPath.getString("data.name");
          int year=jsonPath.getInt("data.year");
          String color=jsonPath.getString("data.color");
          String pantone_value= jsonPath.getString("data.pantone_value");

          String url=jsonPath.getString("support.url");
          String text=jsonPath.getString("support.text");


          //4.Do Assertion
          SoftAssert softAssert = new SoftAssert();
          softAssert.assertEquals(id,3);
          softAssert.assertEquals(name,"true red");
          softAssert.assertEquals(year,2002);
          softAssert.assertEquals(color,"#BF1932");
          softAssert.assertEquals(pantone_value,"19-1664");
          softAssert.assertEquals(url,"https://reqres.in/#support-heading");
          softAssert.assertEquals(text,"To keep ReqRes free, contributions towards server costs are appreciated!");
          softAssert.assertAll();
     }
}
