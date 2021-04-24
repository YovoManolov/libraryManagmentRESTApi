package com.library.lirabry.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "patron_subscription")
public class PatronSubscription {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "start_date")
	private LocalDate startDate;

	@ManyToOne
	@JoinColumn(name = "patron_id")
	private Patron patron;

	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private Subscription subscription;

}
