package requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Homework_07_week8 {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */
    @Test
    public void Testmethod(){

        //Set the Url

        //Set the expected data
        //Send the request and get the response
        Response response= given().get("https://reqres.in/api/unknown/");
        response.prettyPrint();


        //Do Assertion
        JsonPath jsonPath =response.jsonPath();
        //1)Status code is 200
        assertEquals(response.getStatusCode(),200);
        //2)Print all pantone_values
        List<String> pantone_values=jsonPath.getList("data.pantone_value");
        System.out.println("pantone_values ->>> "+pantone_values);
        /*3)Print all ids greater than 3 on the console
        Assert that there are 3 ids greater than 3*/
        List<Integer> idsGreaterThanThree = jsonPath.getList("data.findAll { it.id > 3 }.id");
        System.out.println(idsGreaterThanThree.toString());
        assertEquals(idsGreaterThanThree.size(),3);
        /*4)Print all names whose ids are less than 3 on the console
        Assert that the number of names whose ids are less than 3 is 2*/
        List<String> names=jsonPath.getList("data.findAll { it.id<3 }.name");
        System.out.println("Names with IDs less than 3: "+names);

        assertEquals(2,names.size());


    }
}
