package com.library.lirabry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.lirabry.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{

}