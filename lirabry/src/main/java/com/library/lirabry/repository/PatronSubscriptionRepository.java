package com.library.lirabry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.lirabry.model.PatronSubscription;

public interface PatronSubscriptionRepository extends JpaRepository<PatronSubscription, Long>{

}