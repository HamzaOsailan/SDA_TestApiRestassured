package requests;

import base_urls.Homework_14_BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.DataItem;
import pojos.JsonPlaceHolderPojo;
import pojos.Pojohomework14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Homework_14_Employees extends Homework_14_BaseUrl {

/*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 */

    @Test
    public void methodTest() {
        //set the url
        spec.pathParams("first", "employees");
        //set the expectedData

        DataItem dataItem = new DataItem(1, "Tiger Nixon", 320800, 61, "");
        Pojohomework14 expectedData = new Pojohomework14(Arrays.asList(dataItem), "Successfully! All records has been fetched.", "success");

        System.out.println("expectedData = " + expectedData);
        //send the get request and the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        Pojohomework14 actualData = response.as(Pojohomework14.class);
        System.out.println("actualData = " + actualData);

        boolean tigerNixonExists = false;
        boolean garrettWintersExists = false;
        for (DataItem item : actualData.getData()) {
            if (item.getEmployee_name().equals("Tiger Nixon"))
                tigerNixonExists = true;
            if (item.getEmployee_name().equals("Garrett Winters"))
                garrettWintersExists = true;
        }

        int greatestAge = response.jsonPath().get("data.max { it.employee_age }.employee_age");
        System.out.println("The greatest age is: " + greatestAge);

        //The name of the lowest age is "Tatyana Fitzpatrick"
        String empLowestAgeName = response.jsonPath().get("data.min { it.employee_age }.employee_name");
        System.out.println("The greatest age is: " + empLowestAgeName);


        // Total salary of all employees is 6,644,770
        int totalSalary = response.jsonPath().get("data.collect { it.employee_salary }.sum()");
        System.out.println("Total salary of all employees is: " + totalSalary);


        //Do assertion
        assertTrue(tigerNixonExists);
        assertTrue(garrettWintersExists);
        assertEquals(66, greatestAge);
        assertEquals(empLowestAgeName,"Tatyana Fitzpatrick");
        assertEquals(6644770, totalSalary, 0);


        assertEquals(response.statusCode(), 200);
        assertEquals(expectedData.getMessage(), actualData.getMessage());
        assertEquals(24, actualData.getData().size());
        assertEquals(expectedData.getStatus(), actualData.getStatus());
    }
}
