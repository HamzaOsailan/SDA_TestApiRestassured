package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojos.ContactPojo;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ContactListContactStepDefinitions {
    ContactPojo expectedData;
    Response response;

    @Given("set the url for adding contact")
    public void set_the_url_for_adding_contact() {
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
        response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();
    }

    @Then("do assertion for adding contact")
    public void do_assertion_for_adding_contact() {
        ContactPojo actualData = response.as(ContactPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
        assertEquals(expectedData.getCountry(), actualData.getCountry());
        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
        assertEquals(expectedData.getStreet2(), actualData.getStreet2());

    }


    @Given("set the url for read contact")
    public void setTheUrlForReadContact() {
        spec.pathParams("first","contacts");
    }

    @And("set the expected data for read contact")
    public void setTheExpectedDataForReadContact() {
        //
    }

    @When("send the get request for read contact")
    public void sendThePostRequestForReadContact() {
        Response response=given(spec).get("{first}/{contacts}");
        response.prettyPrint();
    }

    @Then("do assertion for read contact")
    public void doAssertionForReadContact() {
        assertEquals(200, response.statusCode());
        ContactPojo actualData = response.as(ContactPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
        assertEquals(expectedData.getCountry(), actualData.getCountry());
        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
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
        response = given(spec).body(expectedData).post("{first}");
    }

    @Then("do assertion for updating contact")
    public void doAssertionForUpdatingContact() {
        ContactPojo actualData = response.as(ContactPojo.class);

        assertEquals(response.statusCode(),200);
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
        assertEquals(expectedData.getCountry(), actualData.getCountry());
        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
    }

    @Given("set the url for delete contact")
    public void setTheUrlForDeleteContact() {
        spec.pathParams("first","contacts");
    }

    @And("set the expected data for delete contact")
    public void setTheExpectedDataForDeleteContact() {
        //
    }

    @When("send the delete request for delete contact")
    public void sendTheDeleteRequestForDeleteContact() {
       Response response= given().delete();
       response.prettyPrint();
    }

    @Then("do assertion for delete contact")
    public void doAssertionForDeleteContact() {
        assertEquals(response.statusCode(),200);
        assertEquals("Contact deleted", response.asString().contains("Contact deleted"));

    }

    @Given("set the url for readContactlist")
    public void setTheUrlForReadContactlist() {
        spec.pathParams("first","contacts");
    }

    @And("set the expected data for readContactlist")
    public void setTheExpectedDataForReadContactlist() {
        //
    }

    @When("send the get request for readContactlist")
    public void sendTheGetRequestForReadContactlist() {
        response = given(spec).get("{first}");
        response.prettyPrint();
    }

    @Then("do assertion readContactlist")
    public void doAssertionReadContactlist() {
        ContactPojo actualData = response.as(ContactPojo.class);
        assertEquals(response.statusCode(),200);
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
        assertEquals(expectedData.getCountry(), actualData.getCountry());
        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
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
        response = given(spec).body(expectedData).patch("{first}");
        response.prettyPrint();
    }

    @Then("do assertion for patch contact")
    public void doAssertionForPatchContact() {
        ContactPojo actualData = response.as(ContactPojo.class);
        assertEquals(response.statusCode(),200);
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getBirthdate(), actualData.getBirthdate());
        assertEquals(expectedData.getPostalCode(), actualData.getPostalCode());
        assertEquals(expectedData.getStateProvince(), actualData.getStateProvince());
        assertEquals(expectedData.getCountry(), actualData.getCountry());
        assertEquals(expectedData.getStreet1(), actualData.getStreet1());
        assertEquals(expectedData.getStreet2(), actualData.getStreet2());
    }
}