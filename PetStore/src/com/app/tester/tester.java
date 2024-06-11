package com.app.tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

import com.app.entity.Category;
import com.app.entity.Login;
import com.app.entity.Order;
import com.app.entity.Pet;
import com.app.entity.Role;
import com.app.validation.*;

public class tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			Map<Integer, Pet> pet = new HashMap<>();
			//Map<Integer, Order> orders = new HashMap<>();
			Map<String,Login> logins = validation.populatedmap();
			Map<Integer,Order> order =validation.populatedOrder();
			
//			logins.put(1, new Login("admin", "admin", Role.valueOf("admin".toUpperCase())));
//			logins.put(2, new Login("cust","cust",Role.CUSTOMER));

			pet.put(101, new Pet("Bull dog", Category.valueOf("Dog".toUpperCase()), 100, 20));
			pet.put(201, new Pet("persion cat", Category.valueOf("CAT"), 300, 10));
			pet.put(301, new Pet("RABBIT", Category.valueOf("RABBIT".toUpperCase()), 400, 30));
			pet.put(401, new Pet("fish", Category.valueOf("fish".toUpperCase()), 500, 50));
			
			//System.out.println("Pet map"+pet);
			while (!exit) {
				System.out.println("1.Login\n 2.Add new Pet (Admin only functionality)\n3.display\n4.update pet\n5.order id\n6.display order");
				System.out.println("choose");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter username and password");
						Login log=validation.login(sc.next(),sc.next(),logins);
						System.out.println("successful login"+log);

						break;
					case 2:
						System.out.println("Enter username and password");
						 log=validation.login(sc.next(),sc.next(),logins);
						if(log.getRole()==Role.ADMIN) {
						System.out.println("Enter name,caterory, unitPrice, stocks");
						Pet newPet = validation.addnewpet(sc.next(), sc.next(), sc.nextDouble(), sc.nextInt());
						pet.put(newPet.getPetId(), newPet);
						System.out.println("successful added");
						}else {
							System.out.println("only admin can access");
						}
						break;
					case 3:
						System.out.println("display");
						pet.forEach((k, v) -> System.out.println(v));
						break;
					case 4:
						System.out.println("update pet details");
						System.out.println("enter update pet id , name, category, unitprice, stocks");
						validation.updatePet(sc.nextInt(), sc.next(), Category.valueOf(sc.next().toUpperCase()),
								sc.nextDouble(), sc.nextInt(), pet);
					case 5:
						System.out.println("enter username password");
						log =validation.login(sc.next(), sc.next(), logins);
						if(log.getRole()==Role.CUSTOMER) {
						System.out.println("order pet petId, quantity, status ");
						Order ord=validation.orderPet(sc.nextInt(), sc.nextInt(), order);
						order.put(ord.getPetId(), ord);
						}else {
							System.out.println("not accssiable admin");
						}
						break;
						
					case 6:
						System.out.println("display order");
						order.forEach((k, v) -> System.out.println(v));
						break;
						
					}

				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}

		}

	}

}
