package com.project.trade.tradeorderbook.entity;

public class Instrument {

	private String instrumentId;
	
	private String orderBookStatus;
	
	public Instrument()
	{
		
	}
	
	public Instrument(String inst, String ord)
	{
		super();
		this.instrumentId=inst;
		this.orderBookStatus=ord;
	}
	
	public String getInstrumentId() {
		return instrumentId;
	}
	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}
	public String getOrderBookStatus() {
		return orderBookStatus;
	}
	public void setOrderBookStatus(String orderBookStatus) {
		this.orderBookStatus = orderBookStatus;
	}
 
	 

}
