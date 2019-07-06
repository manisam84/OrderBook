package com.project.trade.tradeorderbook.entity;

import java.util.List;

/*
 * OrderBook conatain the quantity, price, orderdate, execution quantity & execution price
 * transaction type(buy/sell) , Order Type(Market Order/Limit Order) are added for later/future use
 * Once the Order is executed : Execution Quantity and Price added to the OrderBook  
 */
public class OrderBook {
	
	public String instrumentId;	
	
	public List<OrderDetails> entries;
	
	public OrderBook()
	{
		
	}
	
	public OrderBook(String instr, List<OrderDetails> details)
	{
		this.instrumentId = instr;
		this.entries = details;
	}
	 public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public List<OrderDetails> getEntries() {
		return entries;
	}

	public void setEntries(List<OrderDetails> entries) {
		this.entries = entries;
	}


}
