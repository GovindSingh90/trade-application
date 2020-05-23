package com.monolith.example.tradeapplication;

public class Trade {
	private String ticker;
	private double price;
	private int quantity;
	private double totalCost;
	
	Trade(){
		
	}
	
	
	public Trade(String ticker, double price, int quantity) {
		super();
		this.ticker = ticker;
		this.price = price;
		this.quantity = quantity;
		//this.totalCost = totalCost;
	}


	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	

}
