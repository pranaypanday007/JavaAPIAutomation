package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.*;

public class Utils {
	static RequestSpecification req; 
	
		
		public io.restassured.specification.RequestSpecification RequestSpecification() throws IOException 
		{
			
			if(req==null)
			{
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			  req =new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
					  .addFilter(RequestLoggingFilter.logRequestTo(log))  
					  .addFilter(ResponseLoggingFilter.logResponseTo(log))
					 .setContentType(ContentType.JSON).build();
			return req;
			}
			return req;
		}
		
		
		
		public static String getGlobalValue(String key) throws IOException
		{
			Properties prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\hari007\\EclipseNewWorkspace\\APIAutomationJune\\src\\test\\java\\resources\\global.properties");
			prop.load(file);
			return prop.getProperty(key);

		}
		
		public String getJsonPath(Response response, String key)
		{
			/*
		    if (response == null) {
		        throw new IllegalArgumentException("Response passed to getJsonPath is null");
		    }*/
			String res = response.asString();
		    JsonPath js = new JsonPath(res);
		    return js.get(key).toString();
		}
}
