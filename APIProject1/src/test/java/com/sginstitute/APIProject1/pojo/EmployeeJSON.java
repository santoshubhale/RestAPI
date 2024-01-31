package com.sginstitute.APIProject1.pojo;

import javax.print.attribute.HashPrintJobAttributeSet;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeJSON {

	public static void main(String[] args) {
		employeeJSONObject();
		System.out.println("+++++++++++++");
		employeeJSONArrayObject();
		System.out.println("+++++++++++++");
		employeeJSONObject2();
	}
	@Test
	private static void employeeJSONObject() {
		try {
			Employee object = new Employee(101, "Santosh", "Manager", 12000.50);

			ObjectMapper mapper = new ObjectMapper();
			String jsonEmployee = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			System.out.println(jsonEmployee);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	private static void employeeJSONArrayObject() {
		try {
			Employee object[] = { new Employee(101, "Santosh", "Manager", 12000.50),
					new Employee(102, "Richard", "Sales Manager", 14000.75),
					new Employee(103, "James", "Analyst", 4500.75) };

			ObjectMapper mapper = new ObjectMapper();
			String jsonEmployee = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			System.out.println(jsonEmployee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	private static void employeeJSONObject2() {
		try {
			Employee object = new Employee();
			object.setEmpId(104);
			object.setEmpName("Adams");
			object.setJobName("Clerk");
			object.setSalary(11000.25);
			ObjectMapper mapper = new ObjectMapper();
			String jsonEmployee = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			System.out.println(jsonEmployee);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
