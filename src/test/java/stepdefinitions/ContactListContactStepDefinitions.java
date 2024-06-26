package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.ContactPojo;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class ContactListContactStepDefinitions {
     Response response;
     RequestSpecification spec;
     String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NjFjYzk1YWMzZDcxMzAwMTM0ZjkxNTEiLCJpYXQiOjE3MTQ4NTI2Mzh9.AWeTumumo0F9s6ZENzziJd1wjaZfCbkCjYWS3OJmY9c";
     public ContactPojo expectedData;




    public ContactListContactStepDefinitions() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")

                .build();
    }



    @Given("set the url for adding contact")
    public void set_the_url_for_adding_contact(){
        //https://thinking-tester-contact-list.herokuapp.com/contacts
        spec.pathParams("first","contacts");
    }

    @Given("set the expected data for adding contact")
    public void set_the_expected_data_for_adding_contact() throws JsonProcessingException {
        String strJson = """
            {
                "firstName": "John",
                "lastName": "Doe",
                "birthdate": "1970-01-01",
                "email": "jdoe@fake.com",
                "phone": "8005555555",
                "street1": "1 Main St.",
                "street2": "Apartment A",
                "city": "Anytown",
                "stateProvince": "KS",
                "postalCode": "12345",
                "country": "USA"
            }""";


        expectedData = new ObjectMapper().readValue(strJson, ContactPojo.class);
        System.out.println("expectedData = " + expectedData);
    }

    @When("send the post request for adding contact")
    public void send_the_post_request_for_adding_contact() {
        response = given(spec)
                .header("Authorization", "Bearer " + token)
                .body(expectedData)
                .post("{first}");
        response.prettyPrint();
    }

    @Then("do assertion for adding contact")
    public void do_assertion_for_adding_contact() {
        ContactPojo actualData = response.as(ContactPojo.class);
        System.out.println("actualData = " + actualData);

//        assertEquals(201, response.statusCode());
//        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
//        assertEquals(expectedData.getLastName(), actualData.getLastName());
//        assertEquals(expectedData.getPhone(), actualData.getPhone());
//        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
//        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
//        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
//        assertEquals(expectedData.getCountry(), actualData.getCountry());
//        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
//        assertEquals(expectedData.getStreet2(), actualData.getStreet2());

    }




    @Given("set the url for read contact")
    public void setTheUrlForReadContact() {
        // Setting the path parameter for the endpoint
        spec.pathParams("first", "contacts");
    }

    @When("send the get request for read contact")
    public void sendThePostRequestForReadContact() {
        // Sending the GET request with path parameters
        response = given(spec)
                .header("Authorization", "Bearer " + token)
                .get("{first}");
//        response.prettyPrint();
    }

    @Then("do assertion for read contact")
    public void doAssertionForReadContact() {
        // Asserting the status code
//        assertEquals(200, response.statusCode());

        // Deserializing the response body into ContactPojo class
//        ContactPojo actualData = response.as(ContactPojo.class);
//        System.out.println("actualData = " + actualData);

        // Asserting the response body fields with expected data
//        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
//        assertEquals(expectedData.getLastName(), actualData.getLastName());
//        assertEquals(expectedData.getPhone(), actualData.getPhone());
//        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
//        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
//        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
//        assertEquals(expectedData.getCountry(), actualData.getCountry());
//        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
//        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
    }

    @Given("set the url for updating contact")
    public void setTheUrlForUpdatingContact() {
        spec.pathParams("first","contacts");
    }

    @And("set the expected data for updating contact")
    public void setTheExpectedDataForUpdatingContact() throws JsonProcessingException {
        String strJson = """
            {
                "firstName": "John",
                "lastName": "Doe",
                "birthdate": "1970-01-01",
                "email": "jdoe@fake.com",
                "phone": "8005555555",
                "street1": "1 Main St.",
                "street2": "Apartment A",
                "city": "Anytown",
                "stateProvince": "KS",
                "postalCode": "12345",
                "country": "USA"
            }""";

        expectedData = new ObjectMapper().readValue(strJson, ContactPojo.class);
    }

    @When("send the put request for updating contact")
    public void sendThePutRequestForUpdatingContact() {
        response = given(spec)
                .body(expectedData)
                .header("Authorization", "Bearer " + token)
                .post("{first}");
    }

    @Then("do assertion for updating contact")
    public void doAssertionForUpdatingContact() {
        ContactPojo actualData = response.as(ContactPojo.class);

//        assertEquals(200, response.statusCode());
//        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
//        assertEquals(expectedData.getLastName(), actualData.getLastName());
//        assertEquals(expectedData.getPhone(), actualData.getPhone());
//        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
//        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
//        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
//        assertEquals(expectedData.getCountry(), actualData.getCountry());
//        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
//        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
    }

    @Given("set the url for delete contact")
    public void setTheUrlForDeleteContact() {
        spec.pathParams("first","contacts");
    }


    @When("send the delete request for delete contact")
    public void sendTheDeleteRequestForDeleteContact() {
        response = given(spec)
                .header("Authorization", "Bearer " + token)
                .delete("{first}");
    }
    @Then("do assertion for delete contact")
    public void doAssertionForDeleteContact() {
//        assertEquals(200,response.statusCode());
//        assertEquals("Contact deleted", response.asString().contains("Contact deleted"));

    }

    @Given("set the url for readContactlist")
    public void setTheUrlForReadContactlist() {
        spec.pathParams("first","contacts");
    }

    @When("send the get request for readContactlist")
    public void sendTheGetRequestForReadContactlist() {

        response = given(spec)
                .header("Authorization", "Bearer " + token)
                .get("{first}");
//        response.prettyPrint();
    }

    @Then("do assertion readContactlist")
    public void doAssertionReadContactlist() {
//        ContactPojo actualData = response.as(ContactPojo.class);
//        assertEquals(200,response.statusCode());

//        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
//        assertEquals(expectedData.getLastName(), actualData.getLastName());
//        assertEquals(expectedData.getPhone(), actualData.getPhone());
//        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
//        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
//        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
//        assertEquals(expectedData.getCountry(), actualData.getCountry());
//        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
//        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
    }

    @Given("set the url for patch contact")
    public void setTheUrlForPatchContact() {
        spec.pathParams("first","contacts");
    }

    @And("set the expected data for patch contact")
    public void setTheExpectedDataForPatchContact() throws JsonProcessingException {
        String strJson= """
                {
                    "firstName": "Anna"
                }
                """;
        expectedData = new ObjectMapper().readValue(strJson, ContactPojo.class);
    }

    @When("send the post request for patch contact")
    public void sendThePostRequestForPatchContact() {
        response = given(spec).body(expectedData)
                .header("Authorization", "Bearer " + token)
                .patch("{first}");
//        response.prettyPrint();
    }

    @Then("do assertion for patch contact")
    public void doAssertionForPatchContact() {
//        ContactPojo actualData = response.as(ContactPojo.class);
//        assertEquals(200,response.statusCode());
//        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
//        assertEquals(expectedData.getLastName(), actualData.getLastName());
//        assertEquals(expectedData.getPhone(), actualData.getPhone());
//        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
//        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
//        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
//        assertEquals(expectedData.getCountry(), actualData.getCountry());
//        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
//        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
    }
}