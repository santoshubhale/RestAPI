package com.sgtesting.tests.users;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserScenario1 {
	
	@Test
	public void createUser()
	{
		try
		{
			RestAssured.baseURI="http://localhost:8082/springboot-sgsoftwaretestinginstitute-sgtesting/users";
			RequestSpecification httpRequest=RestAssured.given();
			//Create File object
			String path=System.getProperty("user.dir");
			System.out.println(path);
			File jsonfile=new File(path+"\\datafiles\\createuser.json");
			
			//Header and body values
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(jsonfile);
			
			// execute post method
			Response response=httpRequest.post();
			String content=response.asPrettyString();
			System.out.println(content);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
