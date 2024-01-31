package com.sginstitute.APIProject1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserScenario {
	//create user
//	@Test
	public void createUser() {
		try {
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users";
			RequestSpecification httpRequest = RestAssured.given();
			// create file objcet 
			String path = System.getProperty("user.dir");
			System.out.println(path);
			File jsonfile = new File(path+"\\datafiles\\createuser.json");
			
			// header and body values
			httpRequest.header("content-type","application/json");
			httpRequest.body(jsonfile);
			
			//execute post method
			Response response = httpRequest.post();
			String content = response.asPrettyString();
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// get user
//	@Test
	public void get() {
		try {
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.header("content-type","application/json");
			Response response = httpRequest.get();
			String content = response.asPrettyString();
			System.out.println(content);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//update user
//	@Test
	public void update() {
		try {
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users/5";
			RequestSpecification httpRequest = RestAssured.given();
			// create file objcet 
			String path = System.getProperty("user.dir");
			System.out.println(path);
			File jsonfile = new File(path+"\\datafiles\\updateuser.json");
			
			// header and body values
			httpRequest.header("content-type","application/json");
			httpRequest.body(jsonfile);
			
			//execute post method
			Response response = httpRequest.put();
			String content = response.asPrettyString();
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// delete user
	@Test
	public void delete() {
		try {
			RestAssured.baseURI="http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users/3";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.header("content-type","application/json");
			Response response = httpRequest.delete();
			String content = response.asPrettyString();
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
