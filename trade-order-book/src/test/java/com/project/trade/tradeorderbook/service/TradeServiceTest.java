package com.project.trade.tradeorderbook.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.trade.tradeorderbook.entity.Instrument;
import com.project.trade.tradeorderbook.entity.OrderBook;
import com.project.trade.tradeorderbook.entity.OrderDetails;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeServiceTest {
	@Test
	public void updateInstrumentstatusTest() throws Exception
	{
		 JSONObject json = new JSONObject();
	        json.put("instrumentId", "BITCOIN");
	        json.put("orderBookStatus", "O"); 
	        byte[] jsonData = json.toString().getBytes();
		ObjectMapper mapper = new ObjectMapper();		
		Instrument details = mapper.readValue(jsonData,Instrument.class);
		
		Map<String,String> instrumentdb = new HashMap<String,String>();
		instrumentdb.put(details.getInstrumentId().toUpperCase(), details.getOrderBookStatus().toUpperCase());
		assertNotNull(instrumentdb.get(details.getInstrumentId()));
		assertEquals(instrumentdb.get(details.getInstrumentId()),"O");

	}
	@Test
	public void addOrderTest() throws Exception
	{
		 JSONObject json_entries = new JSONObject();
	 		json_entries.put("quantity", 120);
	 		json_entries.put("price", 100.20); 
	 		byte[] jsonData_entries = json_entries.toString().getBytes();
	 		ObjectMapper mapper_entries = new ObjectMapper();		
	 		OrderDetails details_entries = mapper_entries.readValue(jsonData_entries,OrderDetails.class);
	 		Map<String,OrderBook> orderBookEntries= new HashMap<String,OrderBook>();
	List<OrderDetails> listOd = new ArrayList<OrderDetails>();
	listOd.add(details_entries);
	 OrderBook bookentry = new OrderBook();
	 bookentry.setEntries(listOd);
	 
	String instrumentId= "BITCOIN";
	orderBookEntries.put(instrumentId, bookentry);
	//Order Book entry for the financial instrument availalbe. check if new record added.
	
	//check if the financial instrument is open
	JSONObject json = new JSONObject();
	        json.put("instrumentId", "BITCOIN");
	        json.put("orderBookStatus", "O"); 
	        byte[] jsonData = json.toString().getBytes();
		ObjectMapper mapper = new ObjectMapper();		
		Instrument details = mapper.readValue(jsonData,Instrument.class);
		 
		Map<String,String> instrumentdb = new HashMap<String,String>();
		instrumentdb.put(details.getInstrumentId().toUpperCase(), details.getOrderBookStatus().toUpperCase());
	
		assertEquals(instrumentdb.get(details.getInstrumentId()),"O");
		
		//Order Book Entry available. orderBookEntries should be not null 
		assertNotNull(orderBookEntries.get(instrumentId));
		 
		assertEquals(orderBookEntries.size(),1);
	}
			 
}
