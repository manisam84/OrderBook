Order Book:
----------

System for Managing the Order Book entries for the Financial Instrument

Tech stack:
-----------
-->Java Spring Boot, Maven 
-->Unit & Integration test case : Junit

This project uses Maven to build the project.
mvn package

To run the package:
java -jar target/trade-order-book-0.0.1-SNAPSHOT.jar

API Implemented:
---------------

1. Financial Instrument OrderBook Open/Close
      URL:http://localhost:8080/OrderBookStatusUpdate
      
      Request:
         {
	         "instrumentId" : "BITCOIN",
	         "orderBookStatus" : "O"
         }
	 
     Response: 
         HTTP Response 200 : Success

2. Order addition to the OrderBook
    URL:http://localhost:8080/addOrder/BITCOIN
    
    Request Parameter: InstrumentId
    
    Request:
       {
	     "quantity" : 120,
	     "price" : 100.20
       }
       
    Response:
        HTTP Response 200 : Success
        HTTP Response 400 : Failure
                     (eg. if user tried to add order to OrderBook and but order book not opened.it will return 400)
                     
    Future Development:
          -- To handle Buy/Sell Order
          -- To handle Market Order / Limit Order

Clarification required for implementation:
----------------------------------------
3. Execution of Order when OrderBook is closed for Financial Instrument
URL:http://localhost:8080/executeOrder

    Info required: 
    
    --Does the execute order change the order quantity in the orderbook when Api is triggered
    or it stored in seperate entity and consolidation happens by the end of day.
    
              
    
    
     
