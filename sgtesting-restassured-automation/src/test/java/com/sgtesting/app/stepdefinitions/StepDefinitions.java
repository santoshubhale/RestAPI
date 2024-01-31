package com.sgtesting.app.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.sgtesting.app.pojodata.Users;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitions {
	public static Logger log=LogManager.getLogger(StepDefinitions.class);
	public static RequestSpecification httpRequest=null;
	public static Users pojoUser1=null;
	public static Response response=null;
	public static String user_id=null;
	/**
	 * I provide createUser endpoint
	 */
	@Given("^I provide createUser endpoint$")
	public void I_provide_createUser_endpoint()
	{
		try
		{
			log.info("I provide createUser endpoint");
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users";
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I get the RequestSpecification reference object
	 */
	@And("^I get the RequestSpecification referece object$")
	public void I_get_the_RequestSpecification_referece_object()
	{
		try
		{
			log.info("I get the RequestSpecification reference object");
			httpRequest=RestAssured.given();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I create request json object
	 */
	@And("^I create request json object$")
	public void I_create_request_json_object()
	{
		try
		{
			log.info("I create request json object");
			pojoUser1=new Users();
			pojoUser1.setFirstName("Demo");
			pojoUser1.setLastName("User1");
			pojoUser1.setAddress("Garage Bus stop Vijayanagar");
			pojoUser1.setEmailId("demouser1@gmail.com");
			pojoUser1.setPhoneNumber("8090601020");
			
			pojoUser1.setStateName("Karnataka");
			pojoUser1.setUserRole("Full Stack Developer");
			pojoUser1.setZipcode(574241);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I assign pojo object to request
	 */
	@And("^I assign pojo object to request$")
	public void I_assign_pojo_object_to_request()
	{
		try
		{
			log.info("I assign pojo object to request");
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(pojoUser1);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I post the request
	 */
	@When("^I post the request$")
	public void I_post_the_request()
	{
		try
		{
			log.info("I post the request");
			response=httpRequest.post();
			String resposneContent=response.getBody().asString();
			log.info(resposneContent);
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I get the 201 status code
	 */
	@Then("^I get the 201 status code$")
	public void I_get_the_201_status_code()
	{
		try
		{
			log.info("I get the 201 status code");
			int statuscode=response.getStatusCode();
			Assert.assertEquals(201, statuscode);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I get the newly created user user_id
	 */
	@And("^I get the newly created user user_id$")
	public void I_get_the_newly_created_user_user_id()
	{
		try
		{
			log.info("I get the newly created user user_id");
			JsonPath jpath=response.jsonPath();
			user_id=jpath.getString("id");
			log.info("User ID of the newly Created User "+user_id);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * I provide displayUser endpoint
	 */
	@Given("^I provide displayUser endpoint$")
	public void I_provide_displayUser_endpoint()
	{
		try
		{
			log.info("I provide displayUser endpoint");
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * i get the user response from the server
	 */
	@When("^i get the user response from the server$")
	public void i_get_the_user_response_from_the_server()
	{
		try
		{
			log.info("i get the user response from the server");
			httpRequest.header("Content-Type", "application/json");
			response=httpRequest.get();
			String resposneContent=response.getBody().asString();
			log.info(resposneContent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I get the 200 status code
	 */
	@Then("^I get the 200 status code$")
	public void I_get_the_200_status_code()
	{
		try
		{
			log.info("I get the 200 status code");
			int statuscode=response.getStatusCode();
			Assert.assertEquals(200, statuscode);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I provide deleteUser endpoint
	 */
	@Given("^I provide deleteUser endpoint$")
	public void I_provide_deleteUser_endpoint()
	{
		try
		{
			log.info("I provide deleteUser endpoint");
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users/"+user_id;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * I delete the user from the server
	 */
	@When("^I delete the user from the server$")
	public void I_delete_the_user_from_the_server()
	{
		try
		{
			log.info("I delete the user from the server");
			//Execute Delete Http Method
			response=httpRequest.delete();
			String resposneContent=response.getBody().asString();
			log.info(resposneContent);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
