package com.sginstitute.APIProject1.pojo.Assignment;


import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserScenario3PojoApproach {
	public static String user_id=null;
	@Test(priority = 1)
	public void createUser()
	{
		try
		{
			System.out.println("Create User using POST http method");
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users";
			RequestSpecification httpRequest=RestAssured.given();
			//create pojo class
			Users userobj=new Users("rajaji nagar", "santosh@gmail.com", "santosh", "ubhale", "9599095645", "karnataka", "software",560042);
			ObjectMapper mapper=new ObjectMapper();
			String jsonuser=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userobj);
			httpRequest.header("content-type", "application/json");
			httpRequest.body(jsonuser);
			//Execute post method
			Response response=httpRequest.post();
			String content=response.asPrettyString();
			System.out.println(content);
			JsonPath jpath=response.jsonPath();
			user_id=jpath.getString("id");
			System.out.println("Create userid:"+user_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 2)
	public void displayUser()
	{
		try
		{
			System.out.println("Display user using GET http method");
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
	RequestSpecification httpRequest=RestAssured.given();
	httpRequest.header("content-Type", "application/json");
	Response response=httpRequest.get();
	String content=response.asPrettyString();
	System.out.println(content);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 3)
	public void UpdateUserPatch()
	{
		try
		{
		System.out.println("Update Role of user using Patch method");
		RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
		RequestSpecification httpRequest=RestAssured.given();
		//Create POJO class
		Users userobj=new Users("dodkalsandra nagar", null, null, null, null, null, null, 0);
		ObjectMapper mapper=new ObjectMapper();
		String jsonuser=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userobj);
		httpRequest.header("content-Type", "application/json");
		httpRequest.body(jsonuser);
		System.out.println("Debug:"+jsonuser);
		//Execute patch method
		Response response=httpRequest.patch();
		String content=response.asPrettyString();
		System.out.println(content);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void displayUserPostUpdate()
	{
		try
		{
			System.out.println("Display user using GET http method");
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
	RequestSpecification httpRequest=RestAssured.given();
	httpRequest.header("content-Type", "application/json");
	Response response=httpRequest.get();
	String content=response.asPrettyString();
	System.out.println(content);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 5)
	public void deleteUser()
	{
		RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.header("content-Type", "application/json");
		Response response=httpRequest.delete();
		String content=response.asPrettyString();
		System.out.println(content);
		
	}
}
