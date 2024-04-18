package requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class C09_Groovy extends JsonPlaceHolderBaseUrl {
    /*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
         I send GET Request to the URL
    Then
         1)Status code is 200
         2)Print all ids greater than 190 on the console
           Assert that there are 10 ids greater than 190
         3)Print all completes whose ids are less than 5 on the console
           Assert that the number of userIds whose ids are less than 5 is 4
         4)Print all titles whose ids are greater than 195
           Assert that "quis eius est sint explicabo" is one of the titles whose id is less than 5
         5)Print id whose title is "quo adipisci enim quam ut ab"
           Assert that id is 8
*/

    @Test
    public void groovyTest(){
        //set the url
        spec.pathParams("first", "todos");
        //Set the expected data

        //send the request and get the response
        Response response=given(spec).get("{first]");
        response.prettyPrint();

        //Do assertion
        JsonPath jsonPath=response.jsonPath();
//        1)Status code is 200
        response.then().statusCode(200);
//        2)Print all ids greater than 190 on the console
//        Assert that there are 10 ids greater than 190
        List<Integer> idlist=jsonPath.getList("id");
        System.out.println(idlist);

        int idgreaterThan190=0;
        for (int w:idlist){
            if (w>190){
                System.out.println(w);
                idgreaterThan190++;
            }
        }
        assertEquals(idgreaterThan190,10);
//        3)Print all completes whose ids are less than 5 on the console
//        Assert that the number of userIds whose ids are less than 5 is 4
        List<Boolean> completedList=jsonPath.getList("findAll{it.id<5}.completed");
        System.out.println("completedList ->"+completedList);
        assertEquals(completedList.size(),4);
//        4)Print all titles whose ids are greater than 195
//        Assert that "quis eius est sint explicabo" is one of the titles whose id is less than 5
        List<String> completedList1=jsonPath.getList("findAll{it.id>195}.title");
        System.out.println("completedList ->"+completedList1);
        assertEquals(completedList1.size(),4);
        assertTrue(completedList1.contains("quo adipisci enim quam ut ab"));
//        5)Print id whose title is "quo adipisci enim quam ut ab"
//        Assert that id is 8
        Object dList=jsonPath.getList("findAll{it.title=='quo adipisci enim quam ut ab'}.id").get(0);
        System.out.println("idList -->"+dList);
        assertEquals(idlist,8);

    }
}
