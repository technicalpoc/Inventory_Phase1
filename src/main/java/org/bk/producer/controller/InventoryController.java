package org.bk.producer.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@ComponentScan
@RestController
@RefreshScope
public class InventoryController {

    @Value("${p1.quantity}")
    private String p1Qty;
    
    @Value("${p2.quantity}")
    private String p2Qty;
    
    @Value("${p3.quantity}")
    private String p3Qty;

    
    /**
     * curl -X POST http://localhost:8082/refresh
     */
    
    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public String inventoryChecker(@RequestParam("productName") String reqProductName) {
    	
    	System.out.println("Requested ProductName :"+reqProductName);
    	String responseMessage = null;
    	 
    	switch(reqProductName){
    	case "p1" :
    		responseMessage =  "REQUEST: PRODUCT- "+reqProductName+", RESPONSE : Available quantity - "+p1Qty;
    		break;
    		
    	case "p2" :
    		responseMessage =  "REQUEST: PRODUCT- "+reqProductName+", RESPONSE : Available quantity - "+p2Qty;
    		break;
    		
    	case "p3" :
    		responseMessage = "REQUEST: PRODUCT- "+reqProductName+", RESPONSE : Available quantity - "+p3Qty;
    		break;
    	default :
    		responseMessage = "REQUEST: PRODUCT-"+reqProductName+", RESPONSE : Sorry, We have no such product in our store :-( ";
    		break;
    	
    	}

    	return responseMessage;
    }
}
