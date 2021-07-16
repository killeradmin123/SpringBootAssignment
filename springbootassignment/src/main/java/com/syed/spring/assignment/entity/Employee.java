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

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// fname should not be null or empty
	// fname should have at least 2 characters
	@NotEmpty
	@Size(min = 2, message = "fname should have at least 2 characters")
	@Column(name = "fname")
	private String fname;

	// lname should not be null or empty
	// lname should have at least 2 characters
	@NotEmpty
	@Size(min = 2, message = "lname should have at least 2 characters")
	@Column(name = "lname")
	private String lname;

	// email should be valid email format
	// email should not be null or empty
	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;

	// phone should be exact 10 characters
	// phone should not be null or empty
	@Range(min = 10,max= 10, message = "phone should be exact 10 characters" )
	// @Size(min = 10, max = 10, message = "phone should be exact 10 characters")
	@Column(name = "phone")
	private BigInteger phone;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy/MM/dd")
	@Column(name = "dob")
	private LocalDate dob;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + fname + ", lastName=" + lname + ", email=" + email + ", phone="
				+ phone + ", dob=" + dob + ", city=" + city + "]";
	}

}
