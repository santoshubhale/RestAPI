package com.sginstitute.APIProject1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserScenarioForReqres {
	@Test
	public void userScenario() {
		try {
			RestAssured.baseURI="https://reqres.in/api/users";
			RequestSpecification httpRequest = RestAssured.given();
			// create file objcet 
			String path = System.getProperty("user.dir");
			System.out.println(path);
			File jsonfile = new File(path+"\\datafiles\\createuserforreqres.json");
			
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

}
