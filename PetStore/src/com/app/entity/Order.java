package com.app.entity;
//orderId, petId, quantity, status
public class Order {
	private static int counter=0;
	private int orderId;
	private int petId;
	private int quantity;
	private Status status;
	
	public Order( int petId, int quantity) {
		super();
		this.orderId = ++counter;
		this.petId = petId;
		this.quantity = quantity;
		this.status = Status.PLACED;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
