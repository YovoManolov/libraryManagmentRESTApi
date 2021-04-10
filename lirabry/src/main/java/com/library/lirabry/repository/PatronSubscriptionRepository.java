package com.library.lirabry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.lirabry.model.PatronSubscription;

public interface PatronSubscriptionRepository 
			extends JpaRepository<PatronSubscription, Long> {

	List<PatronSubscription> findAllByPatronFirstName(String name);
}