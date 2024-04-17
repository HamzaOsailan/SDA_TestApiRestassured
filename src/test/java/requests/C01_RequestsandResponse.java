package requests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class C01_RequestsandResponse {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Print connection and Date headers on console
    And
        Print all headers on console
*/
    public static void main(String[] args){
//
//    Given
//    https://restful-booker.herokuapp.com/booking
//    User sends a GET Request to the url
        //RestAssured is used to send request and get response
        Response response= RestAssured.get("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();//to see body on console in pretty way we can use prettyprint() method

//    HTTP Status Code should be 200
        //everything we need is in response container
        int statusCode=response.statusCode();
        System.out.println("statusCode "+statusCode);
//    Content Type should be JSON
        String contentType=response.contentType();
        System.out.println("contentType "+contentType);
//    Status Line should be HTTP/1.1 200 OK
//
       String statusLine= response.statusLine();
        System.out.println("statusLine "+statusLine);


//        Print connection and Date headers on console
       String Connection=response.header("Connection");
       String Date=response.header("Date");
        System.out.println("\nConnection --> "+Connection);
        System.out.println("\nDate --> "+Date);
//        Print all headers on console
        Headers headers= response.headers();
        System.out.println("\nheaders --> "+headers);
    }
}
