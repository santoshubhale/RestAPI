package com.sginstitute.APIProject1.pojo.Assignment;


import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerScenario2 {
	public static String customer_id=null;
	@Test(priority = 1)
	public void createCustomer()
	{
		try
		{
			System.out.println("Create Customer Scenario using Post method");
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/customers";
			RequestSpecification httpRequest=RestAssured.given();
			//create Pojo class Object
			Customer customerobj=new Customer("vijayanagar", "santosh@gmail.com", "santosh","bnagalore","900887764");
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
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 2)
	public void displayCustomer()
	{
		try
		{
			System.out.println("Display Scenario using GET method");
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
	public void UpdateCustomerPut()
	{
		try
		{
			System.out.println("Update Customer Scenario using PUT method");
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/customers/"+customer_id;
			RequestSpecification httpRequest=RestAssured.given();
			//create Pojo class Object
			Customer customerobj=new Customer("vijayanagar", "santosh@gmail.com", "santosh","bnagalore","900887764");
			ObjectMapper mapper=new ObjectMapper();
			String jsonuser=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerobj);
			httpRequest.header("content-Type", "application/json");
			httpRequest.body(jsonuser);
			//Execute post method
			Response response=httpRequest.put();
			String content=response.asPrettyString();
			System.out.println(content);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(priority = 4)
	public void displayCustomerUponUpdate()
	{
		try
		{
			System.out.println("Display Scenario using GET method");
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/customers/"+customer_id;
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
	@Test(priority = 5)
	public void deleteCustomer()
	{
		try
		{
			System.out.println("Display Scenario using Delete method");
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
