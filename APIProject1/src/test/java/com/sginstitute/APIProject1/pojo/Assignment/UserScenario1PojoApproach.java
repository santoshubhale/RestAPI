package com.sginstitute.APIProject1.pojo.Assignment;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserScenario1PojoApproach {
	public static String user_id = null;

	@Test(priority = 1)
	public void createUser() {
		try {
			System.out.println("Create User Scenario using Post Http Method");
			RestAssured.baseURI = "http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users";
			RequestSpecification httpRequest = RestAssured.given();
			// Create Pojo Class object
			Users userobject = new Users("Jayanagar 4th Block", "demouser@gmail.com", "DemoUser1", "User1",
					"809070605012", "Karnaaka", "Engineer", 540034);
			ObjectMapper mapper = new ObjectMapper();
			String jsonUser = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userobject);
			System.out.println(jsonUser);
			// Setting header and Body and send Request
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(jsonUser);

			// execute post method
			Response response = httpRequest.post();
			String content = response.asPrettyString();
			System.out.println(content);
			JsonPath jpath = response.jsonPath();
			user_id = jpath.getString("id");
			System.out.println("User Id :" + user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void displayUser() {
		try {
			System.out.println("Display User Scenario using GET Http Method");
			RestAssured.baseURI = "http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users/"
					+ user_id;
			RequestSpecification httpRequest = RestAssured.given();

			// Setting header and Body and send Request
			httpRequest.header("Content-Type", "application/json");

			// execute post method
			Response response = httpRequest.get();
			String content = response.asPrettyString();
			System.out.println(content);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void deleteUser() {
		try {
			System.out.println("Delete User Scenario using DELETE Http Method");
			RestAssured.baseURI = "http://localhost:8083/springboot-sgsoftwaretestinginstitute-sgtesting/users/"
					+ user_id;
			RequestSpecification httpRequest = RestAssured.given();

			// Setting header and Body and send Request
			httpRequest.header("Content-Type", "application/json");

			// execute post method
			Response response = httpRequest.delete();
			String content = response.asPrettyString();
			System.out.println(content);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
