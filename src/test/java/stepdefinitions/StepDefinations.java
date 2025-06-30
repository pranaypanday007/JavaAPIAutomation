package stepdefinitions;


import static io.restassured.RestAssured.given;

import java.io.IOException;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import resources.SpecialClass;
import resources.TestDataBuild;
import resources.Utils;
public class StepDefinations extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String placeid;
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	
	    
	 
	     

	     res= given().spec(RequestSpecification())
	    .body(data.addPlacePayLoad(name,language,address));

	}
	
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
	    SpecialClass spclass1 = SpecialClass.valueOf(resource);
	    resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    
	    if(method.equalsIgnoreCase("POST"))
	    {
			response =res.when().post(spclass1.getResource());
	    }
	    else if(method.equalsIgnoreCase("GET"))
	    {
			response =res.when().get(spclass1.getResource());
	    }

	}
	
	@Then("the API call got sucess with status code {int}")
	public void the_api_call_got_sucess_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(),200);
		
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions

	    String res = response.asString();

	    assertEquals(getJsonPath(response,keyValue),ExpectedValue);
	}

	@Then("verify place_ID created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    //prepare request spec, get API call,  
		placeid = getJsonPath(response,"place_id");
	     res= given().spec(RequestSpecification()).queryParam("place_id", placeid);
	     user_calls_with_http_request(resource, "GET");
	     String actual_name = getJsonPath(response,"name");
	     assertEquals(actual_name,expectedName);
	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	     res= given().spec(RequestSpecification()).body(data.deletePlacePayLoad(placeid));
	}

}
