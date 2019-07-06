package com.project.trade.tradeorderbook.entity;

public class OrderDetails {

	private int quantity;
	private double price;
	private String orderdate;
	private String transactiontype ="B";   //buy or sell - defaulted to buy: Flag for future use
	private String orderType  ="M";         //Market Order or Limit Order Flag for future use
	
	private int executedQuantity;
	private double executedPrice;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public int getExecutedQuantity() {
		return executedQuantity;
	}
	public void setExecutedQuantity(int executedQuantity) {
		this.executedQuantity = executedQuantity;
	}
	public double getExecutedPrice() {
		return executedPrice;
	}
	public void setExecutedPrice(double executedPrice) {
		this.executedPrice = executedPrice;
	}
	 
}
