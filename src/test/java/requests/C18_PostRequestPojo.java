package requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.DummyPojo;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C18_PostRequestPojo extends JsonPlaceHolderBaseUrl {
/*
     Given
        https://jsonplaceholder.typicode.com/todos
        {
        "userId": 55,
        "title": "Tidy your room",
        "completed": false
        }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/

    @Test
    public void postRequestPojoTest(){

        DummyPojo dummyPojo =new DummyPojo("Mary","Max",35);
        System.out.println(dummyPojo);
        //set the url
        spec.pathParams("first","todos");

        //set the expectedaData
        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData =" +expectedData);
        //send the request and get the response
        Response response=given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPlaceHolderPojo actualData=response.as(JsonPlaceHolderPojo.class);
        System.out.println("actualData "+actualData);


        assertEquals(response.statusCode(),201);
        assertEquals(actualData.getUserId(),expectedData.getUserId());
        assertEquals(actualData.getTitle(),expectedData.getTitle());
        assertEquals(actualData.getCompleted(),expectedData.getCompleted());


    }


}