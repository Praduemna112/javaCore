package com.app.entity;
//( petId, name, category, unitPrice, stocks)
public class Pet {
	private static int counter;
	private int petId;
	private String name;
	private Category category;
	private double unitprice;
	private int stock;
	
	static {
		counter=0;
	}
	
	public Pet( String name2, String category2, double unitPrice2, int stock2) {
		// TODO Auto-generated constructor stub
	}

	public Pet(String name, Category category, double unitprice, int stock) {
		super();
		this.petId = ++counter;
		this.name = name;
		this.category = category;
		this.unitprice = unitprice;
		this.stock = stock;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", category=" + category + ", unitprice=" + unitprice
				+ ", stock=" + stock + "]";
	}
	
	
	
	

}
