package com.sginstitute.APIProject1.pojo;

public class Employee {

	private int empId;
	private String empName;
	private String jobName;
	private double salary;

	public Employee() {
		super();
	}

	public Employee(int empId, String empName, String jobName, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.jobName = jobName;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
