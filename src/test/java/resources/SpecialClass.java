package resources;

public enum SpecialClass {
	

	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	public String resource;

SpecialClass(String resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}

public String getResource() {
	return resource;
}


}