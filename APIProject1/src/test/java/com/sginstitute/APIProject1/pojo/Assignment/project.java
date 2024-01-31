package com.sginstitute.APIProject1.pojo.Assignment;


public class project {
	private String description;
	private String projectDomain;
	private String projectName;
	private int projectCustomerId;
	public project(String description, String projectDomain, String projectName, int projectCustomerId) {
		super();
		this.description = description;
		this.projectDomain = projectDomain;
		this.projectName = projectName;
		this.projectCustomerId = projectCustomerId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProjectDomain() {
		return projectDomain;
	}
	public void setProjectDomain(String projectDomain) {
		this.projectDomain = projectDomain;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getProjectCustomerId() {
		return projectCustomerId;
	}
	public void setProjectCustomerId(int projectCustomerId) {
		this.projectCustomerId = projectCustomerId;
	}
	

}
