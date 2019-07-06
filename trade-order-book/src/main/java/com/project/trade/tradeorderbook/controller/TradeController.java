package com.project.trade.tradeorderbook.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.trade.tradeorderbook.entity.Instrument;
import com.project.trade.tradeorderbook.entity.OrderBook;
import com.project.trade.tradeorderbook.entity.OrderDetails;
import com.project.trade.tradeorderbook.exception.ResourceException;
import com.project.trade.tradeorderbook.service.TradeService;

@RestController
public class TradeController {
	@Autowired
	TradeService service;
	Logger log =LoggerFactory.getLogger(TradeController.class);

/* OrderBookStatusUpdate API : Update the Financial Instrument and 
 *  the corresponding OrderBookStatus in the Instrument which is stored in  
 *  Map with Financial Instrument as Key
 *  HTTP 200 Sucess
 */
    @RequestMapping(value="/OrderBookStatusUpdate",method=RequestMethod.POST,consumes="application/json")
	public void OrderBookStatusUpdate(@RequestBody Instrument request)
	{
    	log.info("inside orderbook status update");
    	service.updateInstrumentstatus(request);    	
		
	}
    
    /* addOrder API : Add the order to the OrderBook of Financial Instrument, if its open 
     *   the orderbook entries are stored in the Map with the financial instrument id 
     *   as Key and Order as List of entries
     *   HTTP 200 Sucess
     */
    
    @RequestMapping(value="/addOrder/{instrumentId}",method=RequestMethod.POST,consumes="application/json")
	public void OrderAdd(@PathVariable String instrumentId , @RequestBody OrderDetails request)
	{
    	log.info("inside orderbook update");
    	service.addOrder(instrumentId,request);

	}
    
    @RequestMapping(value="/executeOrder",method=RequestMethod.POST,consumes="application/json")
	public void OrderExecution()
	{
    	log.info("inside orderbook execution update");

	}
    
    /* orderStatus API : To retrieve orderStatus of Financial instrument : 
     * 
     */
    
    @RequestMapping(value="/orderStatus",method=RequestMethod.GET,produces="application/json")
  	public  Map<String,String> OrderStatus()
  	{

    	log.info("inside orderbook retrieve Order Status");

    	return service.retrieveInstrument();

  	}
    
    /* orderStatus API : To retrieve list of orders received
     */
    
    @RequestMapping(value="/orderBook",method=RequestMethod.GET,produces="application/json")
  	public Map<String,OrderBook> OrderBookdetails()
  	{
    	log.info("inside orderbook retrieve Order Book");

    	return service.retrieveOrderBook();

  	}
    /* Exception Handler: Failure Handling
     * <If the Financial Instrument Order Book is not opened,
     *  User tries to add the Order , Exception is thrown>
     * 400 : Failure
     */
    @ExceptionHandler(ResourceException.class)
    public ResponseEntity handleException(ResourceException e) {
        return ResponseEntity.status(e.getHttpstatus()).body(e.getMessage());
    }
}
