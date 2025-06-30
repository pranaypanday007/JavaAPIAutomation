package stepdefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		//when delete place API is running independently, and it needs a place id to delete
		//need to generate a place id to run
		//need to create a POST request before place id can be executed
		//need to store the PLACE id which we get from get method after running post
		//1st requestspecification
		

		StepDefinations getURL = new StepDefinations();
		if(StepDefinations.placeid == null) {
		getURL.add_place_payload_with("Peter", "Hindi", "Sunnybank Hills");
		getURL.user_calls_with_http_request("AddPlaceAPI", "POST");
		getURL.verify_place_id_created_maps_to_using("Peter", "getPlaceAPI");
		}
	}
}
