package com.sginstitute.APIProject1.pojo.Assignment;


import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProjectScenario2 {
	public static String customer_id=null;
	public static String project_id=null;
	public static int projectCustomerId;
	@Test(priority = 1)
	public void createCustomer()
	{
		try
		{
			System.out.println("Create Customer Scenario using Post method");
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/customers";
			RequestSpecification httpRequest=RestAssured.given();
			//create Pojo class Object
			Customer customerobj=new Customer("health", "healthinsurence", "redfox","mbbs","1235689564");
			ObjectMapper mapper=new ObjectMapper();
			String jsonuser=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerobj);
			httpRequest.header("content-Type", "application/json");
			httpRequest.body(jsonuser);
			//Execute post method
			Response response=httpRequest.post();
			String content=response.asPrettyString();
			System.out.println(content);
			//To get the customerid from response
			JsonPath jpath=response.jsonPath();
			customer_id=jpath.getString("id");
			System.out.println("customer id from repsonse:"+customer_id);
			projectCustomerId=Integer.parseInt(customer_id);  
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 2)
	public void displayCustomer()
	{
		try
		{
			System.out.println("Display customer Scenario using GET method");
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/customers/"+customer_id;
			RequestSpecification httpRequest=RestAssured.given();
			httpRequest.header("content-Type", "application/json");
			//Execute post method
			Response response=httpRequest.get();
			String content=response.asPrettyString();
			System.out.println(content);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
@Test(priority = 3)
public void createProject()
{
	try
	{
		System.out.println("Create project Scenario using POST method");
		RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/projects";
		RequestSpecification httpRequest=RestAssured.given();
		//create Pojo class Object
		project projectobject=new project("medical", "abdoman", "md", projectCustomerId);
		ObjectMapper mapper=new ObjectMapper();
		String jsonproject=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(projectobject);
		httpRequest.header("content-Type", "application/json");
		httpRequest.body(jsonproject);
		//Execute post method
		Response response=httpRequest.post();
		String content=response.asPrettyString();
		System.out.println(content);
		JsonPath jpath=response.jsonPath();
		project_id=jpath.getString("id");
		System.out.println("project id from repsonse:"+project_id);
	}catch (Exception e) {
		e.printStackTrace();
	}
}
@Test(priority = 4)
public void displayProject()
{
	try
	{
		System.out.println("Display project Scenario using GET method");
		RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/projects/"+project_id;
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.header("content-Type", "application/json");
		//Execute post method
		Response response=httpRequest.get();
		String content=response.asPrettyString();
		System.out.println(content);
	}catch (Exception e) {
		e.printStackTrace();
	}
}
@Test(priority = 5)
public void updateProject()
{
	try
	{
		System.out.println("Update project Scenario using PUT method");
		RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/projects/"+project_id;
		RequestSpecification httpRequest=RestAssured.given();
		//create Pojo class Object
		project projectobject=new project("scientiest", null, null, projectCustomerId);
		ObjectMapper mapper=new ObjectMapper();
		String jsonproject=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(projectobject);
		httpRequest.header("content-Type", "application/json");
		httpRequest.body(jsonproject);
		//Execute put method
		Response response=httpRequest.put();
		String content=response.asPrettyString();
		System.out.println(content);
	}catch (Exception e) {
		e.printStackTrace();
	}
}
@Test(priority = 6)
public void displayProjectUponUpdate()
{
	try
	{
		System.out.println("Display project after update Scenario using GET method");
		RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/projects/"+project_id;
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.header("content-Type", "application/json");
		//Execute get method
		Response response=httpRequest.get();
		String content=response.asPrettyString();
		System.out.println(content);
	}catch (Exception e) {
		e.printStackTrace();
	}
}
@Test(priority = 7)
public void deleteProject()
{
	try
	{
		System.out.println("Delete Project Scenario using Delete method");
		RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/projects/"+project_id;
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.header("content-Type", "application/json");
		//Execute delete method
		Response response=httpRequest.delete();
		String content=response.asPrettyString();
		System.out.println(content);
	}catch (Exception e) {
		e.printStackTrace();
	}
}
@Test(priority = 8)
public void deleteCustomer()
{
	try
	{
		System.out.println("Delete customer Scenario using Delete method");
		RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/customers/"+customer_id;
		RequestSpecification httpRequest=RestAssured.given();
		httpRequest.header("content-Type", "application/json");
		//Execute delete method
		Response response=httpRequest.delete();
		String content=response.asPrettyString();
		System.out.println(content);
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
