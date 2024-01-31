package com.sgtesting.tests.pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserScenarioByPojoAproach {
	public static String user_id=null;
	@Test(priority = 1)
	public void createUser()
	{
		try
		{
			System.out.println("Create User Scenario using Post Http Method");
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users";
			RequestSpecification httpRequest=RestAssured.given();
			//Create Pojo Class object
			Users userobject=new Users("Jayanagar 4th Block", 
					"demouser@gmail.com", 
					"DemoUser1", 
					"User1", 
					"809070605012", 
					"Karnataka", 
					"Engineer", 
					540034);
			ObjectMapper mapper=new ObjectMapper();
			String jsonUser=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userobject);
			System.out.println(jsonUser);
			//Setting header and Body and send Request
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(jsonUser);
			
			// execute post method
			Response response=httpRequest.post();
			String content=response.asPrettyString();
			System.out.println(content);
			JsonPath jpath=response.jsonPath();
			user_id=jpath.getString("id");
			System.out.println("User Id :"+user_id);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	

	@Test(priority = 2)
	public void displayUser()
	{
		try
		{
			System.out.println("Display User Scenario after Create User using GET Http Method");
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
			RequestSpecification httpRequest=RestAssured.given();
			
			//Setting header and Body and send Request
			httpRequest.header("Content-Type", "application/json");
			
			// execute post method
			Response response=httpRequest.get();
			String content=response.asPrettyString();
			System.out.println(content);
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void updateUserStateName()
	{
		try
		{
			System.out.println("Modify User Scenario using Patch Http Method");
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
			RequestSpecification httpRequest=RestAssured.given();
			
			//Create Pojo object for Patch
			UserStateName obj=new UserStateName();
			obj.setStateName("Tamilnadu");
			
			ObjectMapper mapper=new ObjectMapper();
			String jsonUser=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			System.out.println(jsonUser);
			//Setting header and Body and send Request
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(jsonUser);
			
			// execute post method
			Response response=httpRequest.patch();
			String content=response.asPrettyString();
			System.out.println(content);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 4)
	public void displayAfterPatchUser()
	{
		try
		{
			System.out.println("Display User Scenario after Patch operation using GET Http Method");
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
			RequestSpecification httpRequest=RestAssured.given();
			
			//Setting header and Body and send Request
			httpRequest.header("Content-Type", "application/json");
			
			// execute post method
			Response response=httpRequest.get();
			String content=response.asPrettyString();
			System.out.println(content);
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 5)
	public void deleteUser()
	{
		try
		{
			System.out.println("Delete User Scenario using DELETE Http Method");
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
			RequestSpecification httpRequest=RestAssured.given();
			
			//Setting header and Body and send Request
			httpRequest.header("Content-Type", "application/json");
			
			// execute post method
			Response response=httpRequest.delete();
			String content=response.asPrettyString();
			System.out.println(content);
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
