package requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Homework_13_Updateuser {
    public Response updateUser(String username, User user) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(user);
        return request.put("https://petstore.swagger.io/v2/user/" + username);
    }
}
