package com.project.trade.tradeorderbook.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.project.trade.tradeorderbook.entity.Instrument;
import com.project.trade.tradeorderbook.entity.OrderBook;
import com.project.trade.tradeorderbook.entity.OrderDetails;
import com.project.trade.tradeorderbook.exception.ResourceException; 
@Component
public class TradeService {

	Map<String,String> instrumentdb = new HashMap<String,String>();
	Map<String,OrderBook> orderBookEntries= new HashMap<String,OrderBook>();
	
	Logger log = LoggerFactory.getLogger(TradeService.class);
	
	/*
	 * instrumentdb contain the Financial Instrument and the Order Book Status 
	 */
	public void updateInstrumentstatus(Instrument details)
	{
		log.info("TradeService:updateInstrumentstatus:inside update instrument");
 
 		 instrumentdb.put(details.getInstrumentId().toUpperCase(), details.getOrderBookStatus().toUpperCase());
	}
	
	/*
	 * orderBookEntries contain the order details for the financial instrument
	 */
	public void addOrder(String instrumentId, OrderDetails details)
	{
		log.info("TradeService:addOrder:inside received order" + details);
		
		if( null!= instrumentdb.get(instrumentId.toUpperCase()) && instrumentdb.get(instrumentId.toUpperCase()).equalsIgnoreCase("O"))
		{
			OrderBook save=null;
			
			/*
			 *  Market Order and Limit Order : Considering Price will be sent from
			 *  Web application
			 *  set entry date to current date before updating order
			 */
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = sdf.format(new Date()); 
			details.setOrderdate(currentDate);
			
			//
			if (null!=orderBookEntries.get(instrumentId.toUpperCase()))
				{
				  save = orderBookEntries.get(instrumentId.toUpperCase());
				  List<OrderDetails> order_details = save.getEntries();
				  order_details.add(details); 
				}
			else
				{
					save = new OrderBook();
					List<OrderDetails> order_details = new ArrayList<OrderDetails>();
					order_details.add(details);					
					save.setEntries(order_details);
					save.setInstrumentId(instrumentId);
				}
			 
			orderBookEntries.put(instrumentId, save);
		}
		else
			{
			log.error("TradeService:addOrder:Error OrderBook not available for the instrument");
			throw new ResourceException(HttpStatus.BAD_REQUEST,"OrderBook not Opened");
			}
	}
	/*
	 * retrieveInstrument & retrieveOrderBook is for retrieving the Stored
	 * OrderBook status and Details for testing
	 */
	public Map<String,String> retrieveInstrument()
	{
		log.info("TradeService:addOrder:Logger for Integration Testing" + this.instrumentdb);
		return this.instrumentdb;
	}
	public Map<String,OrderBook> retrieveOrderBook()
	{
		log.info("TradeService:retrieveOrderBook:Logger for Integration Testing" + this.orderBookEntries);
		return this.orderBookEntries;
	}
	
   
}
