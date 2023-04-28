package practiceCRUDoperations;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUsertest {

	public static void main(String[] args) 
	{
		//step1:create the necessary data
		JSONObject obj=new JSONObject();
		obj.put("name", "Kavana");
		obj.put("job", "tester");
		
		//ste2:send the request
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		
		Response resp = req.post("https://reqres.in//api/users");
		
		//step3:validate the response
		
		resp.then().log().all();
		System.out.println(resp.getContentType());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getTime());
		
		resp.then().assertThat().statusCode(201);

	}// a wrong program

}
