package requests;

import base_urls.Homework_12_BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojos.Homework_12_Pojo_Pet;


import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.Homework_12_Pojo_Pet;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Homework_12_week9_GetPet extends Homework_12_BaseUrl {

    @Test
    public void testReadPet() {
       //set the url
        long petId = 9223372036854775807L;
        spec.pathParam("first", "pet");

        //set the expectedData

        //send the request and get the response
        Response readResponse = given(spec)
                .get("{first}/" + petId);
        readResponse.prettyPrint();


        Homework_12_Pojo_Pet actualPet = readResponse.as(Homework_12_Pojo_Pet.class);

        // Do assertion
        assertEquals(readResponse.getStatusCode(), 200);
        assertEquals(actualPet.getId(), petId);

    }
}
