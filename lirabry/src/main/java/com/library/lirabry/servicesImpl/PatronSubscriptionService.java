package com.library.lirabry.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.lirabry.exception.RecordNotFoundException;
import com.library.lirabry.model.PatronSubscription;
import com.library.lirabry.repository.PatronSubscriptionRepository;
import com.library.lirabry.services.PatronSubscriptionServiceI;

@Service
public class PatronSubscriptionService implements PatronSubscriptionServiceI {

	
	@Autowired
	PatronSubscriptionRepository patronSubscriptionRepository;
	
	@Override
	public List<PatronSubscription> getAllPatronSubscriptions() throws RecordNotFoundException {
		
		List<PatronSubscription> patronSubscriptionList = patronSubscriptionRepository.findAll();
		
        if(patronSubscriptionList.size() > 0) {
            return patronSubscriptionList;
        } else {
            throw new RecordNotFoundException("No patronSubscription records exist!");
        }
	}

	@Override
	public PatronSubscription getPatronSubscriptionById(Long patronSubscriptionId) throws RecordNotFoundException {
		
	    Optional<PatronSubscription> patronSubscription =  patronSubscriptionRepository.findById(patronSubscriptionId);
	    
	    if(patronSubscription.isPresent()) {
            return patronSubscription.get();
        } else {
            throw new RecordNotFoundException("No patronSubscription record exist for given id");
        }
	}

	@Override
	public PatronSubscription createPatronSubscription( PatronSubscription newPatronSubscription) {
	     return patronSubscriptionRepository.save(newPatronSubscription);
	}

	@Override
	public PatronSubscription updatePatronSubscription(PatronSubscription newPatronSubscription, Long id ) {
	
			Function<PatronSubscription,PatronSubscription> updatePatronSubscription = (patronSubscriptionUpdated) -> {
				
				patronSubscriptionUpdated.setPatron(newPatronSubscription.getPatron());
				patronSubscriptionUpdated.setStartDate(newPatronSubscription.getStartDate());
				patronSubscriptionUpdated.setSubscription(newPatronSubscription.getSubscription());
				
				return patronSubscriptionRepository.save(patronSubscriptionUpdated);
			};
			
			Optional<Object> updatedPatronSubscription = 
					patronSubscriptionRepository.findById(id).map(updatePatronSubscription);
				
			return (PatronSubscription) updatedPatronSubscription.get();
	}
	
	@Override
	public boolean deletePatronSubscription(Long id) {
		if(patronSubscriptionRepository.findById(id).isPresent()) {
			patronSubscriptionRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public List<PatronSubscription> findAllByPatronFirstName(String firstName){
		return patronSubscriptionRepository.findAllByPatronFirstName(firstName);
	}
}
