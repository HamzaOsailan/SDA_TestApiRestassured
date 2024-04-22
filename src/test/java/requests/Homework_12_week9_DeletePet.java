package requests;

import base_urls.Homework_12_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.Homework_12_Pojo_Pet;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Homework_12_week9_DeletePet extends Homework_12_BaseUrl {
    @Test
    public void testCreateAndDeletePet(){
        // Set the URL url
        spec.pathParam("first", "pet");

        //set the expectedData
        Homework_12_Pojo_Pet.Category category = new Homework_12_Pojo_Pet.Category(1, "Dogs");
        Homework_12_Pojo_Pet.Tag tag = new Homework_12_Pojo_Pet.Tag(1, "cute");
        Homework_12_Pojo_Pet pet = new Homework_12_Pojo_Pet(9223372036854775807L, category, "Doggie", Arrays.asList("http://example.com/photo"), Arrays.asList(tag), "available");


        // Delete the pet
        Response deleteResponse = given(spec)
                .delete("{first}/" + pet.getId());
        deleteResponse.prettyPrint();

        // Assert deletion success
        assertEquals(deleteResponse.getStatusCode(), 200);
    }
}
