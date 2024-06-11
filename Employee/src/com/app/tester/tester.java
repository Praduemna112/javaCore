package com.app.tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.employee.Employe;
import com.app.employee.Login;
import com.app.utils.utils;

public class tester {
	public static void main(String[] args) {
		try(Scanner sc =new Scanner (System.in)){
			Map<Integer, Employe> empmap =new HashMap<>();
			Map<String, Login> logins =utils.populatedmap();
			boolean exit=false;
			while (!exit) {
				System.out.println("1.addDetails\n2,Display\n3.delete id\n4.search aadhar\n5.sorted\n6.update name\n7.exit\n8.read filename");
				System.out.println("choose");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("enter username and password");
						Login ln= utils.username(sc.next(),sc.next(),logins);
						System.out.println("successful login");
						break;
					case 2:
						System.out.println("enter username and password");
						 Login ln1= utils.username(sc.next(),sc.next(),logins);
						if(ln1.getRole() == ln1.getRole().MANAGER) {
						System.out.println("enter Name, Date of joining, Phone Number, Aadhaar number");
						Employe emp= utils.addDetails(sc.next(), sc.next(), sc.next(), sc.next(),empmap);
						empmap.put( emp.getId(), emp);
						System.out.println("successful add Details");
						}
						break;
					case 3:
						System.out.println("Display");
						empmap.forEach((k,v)->System.out.println(v));
						break;
					case 4:
						System.out.println("Enter id");
						utils.deleteId(sc.nextInt(), empmap);
						break;
					case 5:
						System.out.println("enter aadhar no");
						utils.searchAadharNo(sc.next(), empmap);
						break;
					case 6:
						utils.sortedByDate(empmap);
						break;
					case 7:
						System.out.println("enter name");
						utils.updateName(sc.nextInt(),sc.next(),empmap);
					case 8:
						exit=true;
						System.out.println("enter filename");
						utils.writefilename(sc.next(),empmap);
						System.out.println("successful entry");
						break;
					case 9:
						System.out.println("enter filename for read");
						utils.readfilename(sc.next(),empmap);
						break;
						
					}
					
				}catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}
			
		}

	}	
}
