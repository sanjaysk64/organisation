package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employee implements Serializable {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empid;
	private String name;
	private Integer age;
	private String qualification;
	private Integer yearOfExperience;
	private double salary;
	private double appraisal;
	private Integer leaves;
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Kolkata")
	private Date joining_date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Kolkata")
	private Date leaving_date;

	public Employee() {
		super();
	}

	
	

	public Employee(Integer empid, String name, Integer age, String qualification, Integer yearOfExperience,
			double salary, double appraisal, Integer leaves, Date joining_date, Date leaving_date) {
		super();
		this.empid = empid;
		this.name = name;
		this.age = age;
		this.qualification = qualification;
		this.yearOfExperience = yearOfExperience;
		this.salary = salary;
		this.appraisal = appraisal;
		this.leaves = leaves;
		this.joining_date = joining_date;
		this.leaving_date = leaving_date;
	}




	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Integer getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(Integer yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getAppraisal() {
		return appraisal;
	}

	public void setAppraisal(double appraisal) {
		this.appraisal = appraisal;
	}

	public Integer getLeaves() {
		return leaves;
	}

	public void setLeaves(Integer leaves) {
		this.leaves = leaves;
	}




	public Date getJoining_date() {
		return joining_date;
	}




	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}




	public Date getLeaving_date() {
		return leaving_date;
	}




	public void setLeaving_date(Date leaving_date) {
		this.leaving_date = leaving_date;
	}

	
	
}
