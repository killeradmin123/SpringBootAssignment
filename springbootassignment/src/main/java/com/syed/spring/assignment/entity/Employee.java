package com.syed.spring.assignment.entity;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// fname should not be null or empty
	// fname should have at least 2 characters

	@ApiModelProperty(notes = "First name of Employee")
	@NotEmpty
	@Size(min = 2, message = "fname should have at least 2 characters")
	@Column(name = "fname")
	private String fname;

	// lname should not be null or empty
	// lname should have at least 2 characters
	@ApiModelProperty(notes = "Last name of Employee")
	@NotEmpty
	@Size(min = 2, message = "lname should have at least 2 characters")
	@Column(name = "lname")
	private String lname;

	// email should be valid email format
	// email should not be null or empty
	@ApiModelProperty(notes = "Email of Employee")
	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;

	// phone should be exact 10 characters
	// phone should not be null or empty
	@ApiModelProperty(notes = "Phone_no of Employee",allowableValues = "range[10,10)")
	//@Range(min = 10, max = 10, message = "phone should be exact 10 characters")
	// @Size(min = 10, max = 10, message = "phone should be exact 10 characters")
	@Column(name = "phone")
	private BigInteger phone;

	@ApiModelProperty(notes = "Date Of birth of Employee")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name = "dob")
	private LocalDate dob;

	@ApiModelProperty(notes = "City Where Employee belongs to")
	@NotEmpty
	@Column(name = "city")
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String firstName) {
		this.fname = firstName;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lastName) {
		this.lname = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Employee(int id, @NotEmpty @Size(min = 2, message = "fname should have at least 2 characters") String fname,
			@NotEmpty @Size(min = 2, message = "lname should have at least 2 characters") String lname,
			@NotEmpty @Email String email,
			@Range(min = 10, max = 10, message = "phone should be exact 10 characters") BigInteger phone, LocalDate dob,
			@NotEmpty String city) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.city = city;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + fname + ", lastName=" + lname + ", email=" + email + ", phone="
				+ phone + ", dob=" + dob + ", city=" + city + "]";
	}

}
