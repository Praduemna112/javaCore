package com.app.validation;

import java.util.HashMap;
import java.util.Map;
import com.app.entity.Category;
import com.app.entity.Login;
import com.app.entity.Order;
import com.app.entity.Pet;
import com.app.entity.Role;
import com.app.entity.Status;
import com.app.exception.Customexception;

public class validation {
	// ( petId, name, category, unitPrice, stocks)


	public static Pet addnewpet(String name, String category, Double unitprice, int stock) throws Customexception {

		Category category2 = Category.valueOf(category.toUpperCase());
		return new Pet(name, category2, unitprice, stock);
	}

	public static void updatePet(int id,String name, Category category ,double unitprice,int stock,Map<Integer, Pet>pets) throws Customexception {
		
				Pet pet= pets.values()
				.stream()
				.filter(entry-> entry.getPetId()==id)
				.findFirst()
				.orElseThrow(()->new Customexception("id is invalid"));
		pet.setName(name);
		pet.setCategory(category);
		pet.setUnitprice(unitprice);
		pet.setStock(stock);
		System.out.println("update pet successful");
		 
		 }

	public static Login login(String userName, String Password,Map<String, Login>map) throws Customexception {
		
		/*
		 * Login login = loginmap.get(userName);
		 *  System.out.println(login);
		 */
		Login login = map.values()
				.stream()
				.filter(entry-> entry.getUsername().equals(userName) && entry.getPassword().equals(Password))
				.findFirst()
				.orElseThrow(()-> new Customexception("not exist username password"));
		return login;
		
//		if(!map.containsKey(userName)) {
//			throw new Customexception("invalid usename");
//		}
//		Login login=map.get(userName);
//		if(!login.getPassword().equals(Password)) {
//			throw new Customexception("invald password");
//		}
//		return login;
		
	}
	
	public static Map<String,Login> populatedmap(){
		Login l1=new Login("admin", "admin", Role.valueOf("admin".toUpperCase()));
		Login l2=new Login("cust","cust",Role.CUSTOMER);
		Login []arr= {l1,l2};
		Map<String,Login> map=new HashMap<>();
		for(Login lt: arr) {
			System.out.println(map.put(lt.getUsername(), lt));
		}
		return map;
		
	}

	public static Order orderPet(int petid, int quantity, Map<Integer, Order> orders)throws Customexception {
		
		return new Order(petid,quantity);
	}
	
	
	public static Map<Integer, Order> populatedOrder(){
		Order o1= new Order(101, 10);
		Order o2 =new Order(201, 20);
		Order o3 =new Order(301, 40);
		Order [] arr = {o1,o2,o3};
		Map<Integer, Order>map=new HashMap<>();
		for(Order or:arr) {
			System.out.println(map.put(or.getOrderId(), or));
		}
		
		return map;
		
	}

	
}
