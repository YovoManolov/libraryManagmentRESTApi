package com.library.lirabry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.PatronSubscription;
import com.library.lirabry.servicesImpl.PatronSubscriptionService;

public class PatronSubscriptionController {
	
	@Autowired
	PatronSubscriptionService patronSubscriptionService;
	
    @GetMapping("/getAll")
    public ResponseEntity<List<PatronSubscription>> getAllPatronSubscriptions() {
    	 List<PatronSubscription> patronSubscriptionList = patronSubscriptionService.getAllPatronSubscriptions();
         return new ResponseEntity<List<PatronSubscription>>(patronSubscriptionList, HttpStatus.OK);
    }

    @GetMapping("/getOneById/{id}")
    public ResponseEntity<PatronSubscription> 
    	getPatronSubscriptionById(@PathVariable(value = "id") Long patronSubscriptionId) throws RecordNotFoundException {
    	
        PatronSubscription patronSubscription = patronSubscriptionService.getPatronSubscriptionById(patronSubscriptionId);
        return new ResponseEntity<PatronSubscription>(patronSubscription, HttpStatus.OK);
    }
   
    @PutMapping("/create")
	public ResponseEntity<PatronSubscription> createPatronSubscription(
			@RequestBody PatronSubscription patronSubscription) {
    	
    		PatronSubscription createdPatronSubscription = patronSubscriptionService.createPatronSubscription(patronSubscription);
    		return new ResponseEntity<PatronSubscription>(createdPatronSubscription, HttpStatus.OK);
    	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PatronSubscription> updatePatronSubscription(
			@RequestBody PatronSubscription newPatronSubscription, @PathVariable Long id )
			throws RecordNotFoundException {
		PatronSubscription updatedPatronSubscription = patronSubscriptionService.updatePatronSubscription(newPatronSubscription,id);
		return new ResponseEntity<PatronSubscription>(updatedPatronSubscription, HttpStatus.OK);
	}
}
