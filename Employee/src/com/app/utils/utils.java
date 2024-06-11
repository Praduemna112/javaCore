package com.app.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.app.employee.Employe;
import com.app.employee.Login;
import com.app.employee.Role;
import com.app.exception.customException;

public class utils{

	public static Employe addDetails(String name, String dateOfJoining, String phoneNO, String aadhaarNO,
			Map<Integer, Employe> empmap) throws customException {
		LocalDate date = LocalDate.parse(dateOfJoining);
		validation(phoneNO, empmap); 
		
		return new Employe(name,date,phoneNO,aadhaarNO);
	}
	
	public static void validation(String phoneNo,Map<Integer, Employe>empmap) throws customException {
		String regex ="\\d{10}";
		Pattern.compile(regex).matcher(phoneNo).results().findFirst().orElseThrow(()->new customException("invalid phoneno"));
	}

	public static void deleteId(int id, Map<Integer, Employe> empmap) throws customException {
		Employe emp= empmap.values()
				.stream()
				.filter(entry->entry.getId()==id)
				.findFirst()
				.orElseThrow(()->new customException("invailid id"));
		empmap.remove(emp.getId());
	}

	public static void searchAadharNo(String aadhar, Map<Integer, Employe> empmap) throws customException {
			empmap.values()
			.stream()
			.filter(entry->entry.getAadhaarNO()==aadhar)
			.findFirst()
			.orElseThrow(()-> new customException("invalid aadhar"));
	}

	public static void sortedByDate(Map<Integer, Employe> empmap) {
		Comparator<Employe> emp = Comparator.comparing(Employe::getDateOfJoining);
		empmap.values()
		.stream()
		.sorted(emp)
		.forEach(entry->System.out.println(entry));
	
		
	}

	public static void updateName(int id, String name, Map<Integer, Employe> empmap) throws customException {
		Employe emp= empmap.values()
		.stream()
		.filter(entry->entry.getId()==id)
		.findFirst()
		.orElseThrow(()->new customException("invalid id"));
		emp.setName(name);
	}

	public static void writefilename(String filename, Map<Integer, Employe> empmap) throws IOException {
		try(PrintWriter pw = new PrintWriter(new FileWriter(filename))){
			empmap.values()
			.stream()
			.forEach(entry->pw.println(entry));
		}
		
	}

	public static void readfilename(String filename, Map<Integer, Employe> empmap) throws FileNotFoundException, IOException {
		try(BufferedReader bf = new BufferedReader(new FileReader(filename))){
			bf.lines().forEach(entry->System.out.println(entry));
		
		}
		
	}
	
	public static  Map<String, Login> populatedmap(){
		Login p1=new Login("admin","admin",Role.MANAGER);
		Login p2 =new Login("staff","staff",Role.STAFF);
		Login []arr= {p1,p2};
		Map<String, Login> map=new HashMap<>();
		for(Login lt : arr) {
			System.out.println(map.put(lt.getUsername(), lt));
		}
		return map;
		
		
	}

	public static Login username(String username, String password, Map<String, Login> logins) throws customException {
		return logins.values()
		.stream()
		.filter(entry->entry.getUsername().equals(username)&&entry.getPassword().equals(password))
		.findFirst()
		.orElseThrow(()->new customException("invaid username and password"));
		
	}
	
	
	
	


	
}