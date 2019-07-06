package com.project.trade.tradeorderbook.controller;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.trade.tradeorderbook.entity.Instrument;
import com.project.trade.tradeorderbook.entity.OrderBook;
import com.project.trade.tradeorderbook.entity.OrderDetails;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TradeControllerTest {

	@LocalServerPort
	private int port;
	
	TestRestTemplate rest = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void OrderBookStatusUpdateTest() throws Exception
	{
		Instrument request =  new Instrument("BITCOIN","O");
	    HttpEntity<Instrument> entity = new HttpEntity<Instrument>(request, headers);
        ResponseEntity<String> response = rest.exchange(
        		"http://localhost:" + port + "/OrderBookStatusUpdate", HttpMethod.POST, entity, String.class);
        String actual = response.getStatusCode().toString();
 
			assertTrue(actual.contains("200"));
 
		 
	}
	
	@Test
	public void OrderStatusTest() throws Exception
	{

		    HttpEntity<String> entity_resp = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response_resp = rest.exchange(
	        		"http://localhost:" + port + "/orderStatus", HttpMethod.GET, entity_resp, String.class);
	        String actual = response_resp.getStatusCode().toString();
	        
	       			assertTrue(actual.contains("200"));
		 
	}
	

	@Test
	public void OrderBookaddTest() throws Exception
	{
		OrderDetails detail = new OrderDetails();
		detail.setPrice(new Double(90.01));
		detail.setQuantity(100);
		OrderBook request =  new OrderBook("BITCOIN",  Arrays
				.asList(detail));
	    HttpEntity<OrderBook> entity = new HttpEntity<OrderBook>(request, headers);
        ResponseEntity<String> response = rest.exchange(
        		"http://localhost:" + port + "/addOrder/BITCOIN", HttpMethod.POST, entity, String.class);
        String actual = response.getStatusCode().toString();
        
			assertTrue(actual.contains("200"));
		 
	}
	 
	@Test
	public void retrieveOrderBookTest() throws Exception
	{

		    HttpEntity<String> entity_resp = new HttpEntity<String>(null, headers);
	        ResponseEntity<String> response_resp = rest.exchange(
	        		"http://localhost:" + port + "/orderBook", HttpMethod.GET, entity_resp, String.class);
	        String actual = response_resp.getStatusCode().toString();
	        
   			assertTrue(actual.contains("200"));
		 
	}
	
}
