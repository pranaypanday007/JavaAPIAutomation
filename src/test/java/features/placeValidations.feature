 Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if add place is being successfully added using Add Place API
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When User calls "AddPlaceAPI" with "POST" http request 
	Then the API call got sucess with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
  And verify place_ID created maps to "<name>" using "getPlaceAPI"

	
Examples:
		| name 				 | language | address						 |
		|Pranay Panday | English  | World Cross Centre | 
#   |Pranay Panda1 | Hindi    | World Cross        | 
		
		

@DeletePlace @Regression
Scenario: Verify if delete place functionality is working

	Given DeletePlace Payload 
	When User calls "deletePlaceAPI" with "POST" http request 
	Then the API call got sucess with status code 200
  And "status" in response body is "OK"