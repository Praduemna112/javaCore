package com.app.employee;

import java.time.LocalDate;

// Name, Date of joining, Phone Number, Aadhaar number
public class Employe {
	private static int counter=0;
	private int id;
	private String name;
	private LocalDate dateOfJoining;
	private String phoneNO;
	private String AadhaarNO;
	
	

	public Employe() {
		// TODO Auto-generated constructor stub
	}

	public Employe(String name, LocalDate dateOfJoining, String phoneNO, String aadhaarNO) {
		super();
		this.id=++counter;
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.phoneNO = phoneNO;
		this.AadhaarNO = aadhaarNO;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Employe.counter = counter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getPhoneNO() {
		return phoneNO;
	}

	public void setPhoneNO(String phoneNO) {
		this.phoneNO = phoneNO;
	}

	public String getAadhaarNO() {
		return AadhaarNO;
	}

	public void setAadhaarNO(String aadhaarNO) {
		AadhaarNO = aadhaarNO;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", name=" + name + ", dateOfJoining=" + dateOfJoining + ", phoneNO=" + phoneNO
				+ ", AadhaarNO=" + AadhaarNO + "]";
	}


	
	
}
