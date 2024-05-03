package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Homework_13_Deleteuser {
    public Response deleteUser(String username) {
        return RestAssured.delete("https://petstore.swagger.io/v2/user/" + username);
    }
}
