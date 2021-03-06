package com.library.lirabry.services;

import java.util.List;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.PatronSubscription;

public interface PatronSubscriptionServiceI {
	
	List<PatronSubscription> getAllPatronSubscriptions() throws RecordNotFoundException;

	PatronSubscription getPatronSubscriptionById(Long patronSubscriptionId) throws RecordNotFoundException;

	PatronSubscription createPatronSubscription(PatronSubscription newPatronSubscription);

	PatronSubscription updatePatronSubscription(PatronSubscription newPatronSubscription, Long id);

	boolean deletePatronSubscription(Long id);

	List<PatronSubscription> findAllByPatronFirstName(String firstName);

}
