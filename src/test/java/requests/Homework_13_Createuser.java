//package requests;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class Homework_13_Createuser {
//    public Response createUser(User user) {
//        RequestSpecification request = RestAssured.given();
//        request.header("Content-Type", "application/json");
//        request.body(user);
//        return request.post("https://petstore.swagger.io/v2/user");
//    }
//}
