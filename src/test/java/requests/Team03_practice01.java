package requests;

import base_urls.Team03_BaseUr01;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Team03_practice01 extends Team03_BaseUr01 {
    // Given https://dummy.restapiexample.com/api/v1/employees
// When user send Request via GET Method
// Then Assert that Status Code is "200"
// And Print employee_age greater than 55 to the console. Assert that there are 8.
// And Print the ones with id's greater than 17 to the console and assert that there are 7.
// And Print the ones with salary is less than 100,000 to the console.Assert that
// Doris Wilder is one of them.



    @Test
    public void TestMethod(){

        //set the url
        specification.pathParams("first","employees");
        //set the expectedData

        //send the request and get the response
       Response response= given(specification).get("{first}");
       response.prettyPrint();
       response.then().statusCode(200);


        //do assertion
        // And Print employee_age greater than 55 to the console. Assert that there are 8.
        JsonPath jsonPath =response.jsonPath();
        List<Boolean> employee_age=jsonPath.getList("data.findAll{it.employee_age > 55}.employee_age");
        System.out.println("employee_age ->"+employee_age);
        assertEquals(employee_age.size(),8);

        // And Print the ones with id's greater than 17 to the console and assert that there are 7.
        List<Integer> id=jsonPath.getList("data.findAll { it.id > 17 }.id ");
        System.out.println("id's ->"+id);
        assertEquals(id.size(),7);

        // And Print the ones with salary is less than 100,000 to the console.Assert that
        List<Integer> salary=jsonPath.getList("data.findAll {it.employee_salary < 100000 }.employee_salary");
        System.out.println("salary ->"+salary);
        System.out.println("salary = " + salary);
        assertEquals(salary.size(),3);

        // Doris Wilder is one of them.
        List<String> getEmployeName=jsonPath.getList("data.findAll {it.employee_salary < 100000 }.employee_name");
        System.out.println("getEmployeName ->"+getEmployeName);
        assertTrue(getEmployeName.contains("Doris Wilder"));
    }
}
