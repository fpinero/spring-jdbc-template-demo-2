package com.fpe.springdemo.domain;

public class Organization {

	private int id;
	private String companyName;
	private int yearOfIncorporation;
	private String potalCode;
	private int employeeCount;
	private String slogan;
	
	public Organization(){
		
	}

	public Organization(String companyName, int yearOfIncorporation, String potalCode, int employeeCount,
			String slogan) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		this.potalCode = potalCode;
		this.employeeCount = employeeCount;
		this.slogan = slogan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getYearOfIncorporation() {
		return yearOfIncorporation;
	}

	public void setYearOfIncorporation(int yearOfIncorporation) {
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public String getPotalCode() {
		return potalCode;
	}

	public void setPotalCode(String potalCode) {
		this.potalCode = potalCode;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", companyName=" + companyName + ", yearOfIncorporation="
				+ yearOfIncorporation + ", potalCode=" + potalCode + ", employeeCount=" + employeeCount + ", slogan="
				+ slogan + "]" + "\n";
	}

}
